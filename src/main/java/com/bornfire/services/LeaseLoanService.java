package com.bornfire.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.config.BGLSDataSource;
import com.bornfire.entities.BACP_CUS_PROFILE_REPO;
import com.bornfire.entities.BAJAccountLedgerRepo;
import com.bornfire.entities.BAJAccountLedger_Entity;
import com.bornfire.entities.Chart_Acc_Rep;
import com.bornfire.entities.DMD_TABLE;
import com.bornfire.entities.DMD_TABLE_REPO;
import com.bornfire.entities.LeaseData;
import com.bornfire.entities.Lease_Loan_Master_Entity;
import com.bornfire.entities.Lease_Loan_Master_Repo;
import com.bornfire.entities.Lease_Loan_Work_Entity;
import com.bornfire.entities.Lease_Loan_Work_Repo;
import com.bornfire.entities.Loan_Repayment_Master_Entity;
import com.bornfire.entities.Loan_Repayment_Master_Repo;
import com.bornfire.entities.NoticeDetailsPayment0Entity;
import com.bornfire.entities.NoticeDetailsPayment0Rep;
import com.bornfire.entities.TestPrincipalCalculation;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class LeaseLoanService {

	@Autowired
	Lease_Loan_Work_Repo lease_Loan_Work_Repo;

	@Autowired
	Environment env;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	NoticeDetailsPayment0Rep paymentWorkRepo;

	@Autowired
	Lease_Loan_Master_Repo lease_Loan_Master_Repo;

	@Autowired
	Loan_Repayment_Master_Repo loan_Repayment_Master_Repo;

	@Autowired
	DMD_TABLE_REPO dMD_TABLE_REPO;

	@Autowired
	Chart_Acc_Rep chart_Acc_Rep;

	@Autowired
	BACP_CUS_PROFILE_REPO bACP_CUS_PROFILE_REPO;

	@Autowired
	BAJAccountLedgerRepo bAJAccountLedgerRepo;

	@Autowired
	InterestCalculationServices interestCalculationServices;

	public String addLeaseLoan(LeaseData leaseRecord, String entryUser) {

		boolean flag = true;
		String msg = "";

		Lease_Loan_Work_Entity loandetails = leaseRecord.getLoanDetails();
		if (Objects.nonNull(loandetails.getLoan_accountno())) {
			loandetails.setEntry_user(entryUser);
			loandetails.setEntry_time(new Date());
			loandetails.setModify_user(entryUser);
			loandetails.setModify_time(new Date());
			loandetails.setEntity_flg("N");
			loandetails.setDel_flg("N");
		} else {
			flag = false;
		}

		NoticeDetailsPayment0Entity repaymentDetails = leaseRecord.getRepaymentDetails();
		if (Objects.nonNull(repaymentDetails.getAccount_no())) {
			repaymentDetails.setEntry_usr(entryUser);
			repaymentDetails.setEntry_tm(new Date());
			repaymentDetails.setMod_usr(entryUser);
			repaymentDetails.setMod_tm(new Date());
			repaymentDetails.setEntity_flg("N");
			repaymentDetails.setDel_flg("N");
		} else {
			flag = false;
		}

		if (flag) {
			lease_Loan_Work_Repo.save(loandetails);
			paymentWorkRepo.save(repaymentDetails);
			msg = "Loan Account Created Successfully";
		} else {
			msg = "Loan Account Created Failed";
		}
		return msg;
	}

	public String verifyleaseloan(String accountNo, String entryUser) {

		boolean flag = true;
		String msg = "";

		Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNo);
		Lease_Loan_Master_Entity masterLoan = new Lease_Loan_Master_Entity(loandetails);

		if (Objects.nonNull(masterLoan.getLoan_accountno())) {
			masterLoan.setVerify_user(entryUser);
			masterLoan.setVerify_time(new Date());
			masterLoan.setEntity_flg("Y");

		} else {
			flag = false;
		}

		NoticeDetailsPayment0Entity repaymentDetails = paymentWorkRepo.getPaymentDetails(accountNo);
		Loan_Repayment_Master_Entity masterPayment = new Loan_Repayment_Master_Entity(repaymentDetails);

		if (Objects.nonNull(masterPayment.getAccount_no())) {

			masterPayment.setVer_usr(entryUser);
			masterPayment.setVer_tm(new Date());
			masterPayment.setEntity_flg("Y");

		} else {
			flag = false;
		}

		if (flag) {
			lease_Loan_Master_Repo.save(masterLoan);
			loan_Repayment_Master_Repo.save(masterPayment);

			String demandFlow = disbursementDemand(masterLoan, entryUser);
			System.out.println(demandFlow);

			String principalFlow = principalAndInterestDemand(masterLoan, masterPayment, entryUser);
			System.out.println(principalFlow);

			lease_Loan_Work_Repo.deleteRecord(loandetails.getLoan_accountno());
			paymentWorkRepo.deleteRecord(repaymentDetails.getAccount_no());

			msg = "Lease Account Verified Successfully";
		} else {
			msg = "Lease Account Verified Failed";
		}

		return msg;
	}

	public String disbursementDemand(Lease_Loan_Master_Entity master, String user) {

		DMD_TABLE demand = new DMD_TABLE();

		BigDecimal srlNo = dMD_TABLE_REPO.getSrlNo();

		demand.setLoan_acct_no(master.getLoan_accountno());
		demand.setLoan_acid(master.getLoan_accountno());
		demand.setAcct_name(master.getCustomer_name());
		demand.setFlow_id(BigDecimal.ONE);
		demand.setFlow_code("DISBT");
		demand.setFlow_date(master.getDate_of_loan());
		demand.setFlow_amt(master.getLoan_sanctioned());
		demand.setFlow_crncy_code(master.getLoan_currency());
		demand.setEntry_time(new Date());
		demand.setEntry_user(user);
		demand.setDel_flg("N");
		demand.setSrl_no(srlNo);

		dMD_TABLE_REPO.save(demand);

		return "Disbursement Demand Updated";
	}

	public String principalAndInterestDemand(Lease_Loan_Master_Entity master,
			Loan_Repayment_Master_Entity paymentMaster, String user) {

		int no_of_inst = Integer.valueOf(paymentMaster.getNo_of_inst());

		Date start_date = paymentMaster.getInst_start_dt();

		LocalDate startDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = startDate.plus(no_of_inst, ChronoUnit.MONTHS);

		Date calculatedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		BigDecimal product = master.getLoan_sanctioned();
		BigDecimal productAmt = master.getLoan_sanctioned();
		BigDecimal intRate = master.getEffective_interest_rate();
		BigDecimal instmentAmount = paymentMaster.getInst_amount();
		String principle_frequency = paymentMaster.getInst_freq();
		String interestFrequency = paymentMaster.getInterest_frequency();

		List<TestPrincipalCalculation> InterestAmount = interestCalculationServices.calculatePrincialPaymentNotice(
				start_date, calculatedEndDate, product, productAmt, principle_frequency, intRate, no_of_inst,
				instmentAmount, interestFrequency);

		int toltalInstallment = InterestAmount.size();

		List<DMD_TABLE> principleAndInterest = new ArrayList<>();

		int noOfInstallment = 1;
		int noOfprincipalInstallment = 1;

		if (toltalInstallment > 0) {
			for (TestPrincipalCalculation record : InterestAmount) {
				DMD_TABLE entity = new DMD_TABLE();

				entity.setLoan_acid(master.getLoan_accountno());
				entity.setLoan_acct_no(master.getLoan_accountno());
				entity.setAcct_name(master.getCustomer_name());
				entity.setFlow_id(BigDecimal.valueOf(noOfInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());
				entity.setFlow_crncy_code(master.getLoan_currency());

				entity.setFlow_amt(record.getInterestAmount());
				entity.setFlow_code("INDEM");

				entity.setEntry_time(new Date());
				entity.setEntry_user(user);
				entity.setDel_flg("N");

				BigDecimal srlNo = dMD_TABLE_REPO.getSrlNo();
				entity.setSrl_no(srlNo);

				noOfInstallment++;
				principleAndInterest.add(entity);
			}

			for (TestPrincipalCalculation record : InterestAmount) {
				DMD_TABLE entity = new DMD_TABLE();

				entity.setLoan_acid(master.getLoan_accountno());
				entity.setLoan_acct_no(master.getLoan_accountno());
				entity.setAcct_name(master.getCustomer_name());
				entity.setFlow_id(BigDecimal.valueOf(noOfprincipalInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());
				entity.setFlow_crncy_code(master.getLoan_currency());

				entity.setFlow_amt(record.getPrincipalAmount());
				entity.setFlow_code("PRDEM");

				entity.setEntry_time(new Date());
				entity.setEntry_user(user);
				entity.setDel_flg("N");

				BigDecimal srlNo = dMD_TABLE_REPO.getSrlNo();
				entity.setSrl_no(srlNo);

				noOfprincipalInstallment++;
				principleAndInterest.add(entity);
			}

		} else {

		}

		dMD_TABLE_REPO.saveAll(principleAndInterest);

		return "Principle and Interest Demand Updated";

	}

	public File getSalaryFile(String filetype, String acctNum, String fromDate, String toDate)
			throws JRException, SQLException, DocumentException, IOException {
		String path = env.getProperty("output.exportpath"); // Define the path
		String fileName = "AccountLedger_" + System.currentTimeMillis();
		String fullPath = path + fileName;

		// Load and compile the Jasper report
		InputStream jasperFile = this.getClass().getResourceAsStream("/static/jasper/statement_report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperFile);

		BAJAccountLedger_Entity value = bAJAccountLedgerRepo.getaccno(acctNum);
		String tempdata = value.getAccount_type();

		String account_name = value.getAcct_name(); // Retrieve the account name
		Date date_of_birth = value.getDate_of_birth(); // Retrieve the date of birth

		// Extract the first four letters of the account name
		String namePart = account_name.substring(0, Math.min(account_name.length(), 4)).toUpperCase();

		// Format the date of birth to extract the first four numbers (DDMM)
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMM");
		String datePart = dateFormat.format(date_of_birth);

		// Combine namePart and datePart to generate the password
		String password = namePart + datePart;

		// Set the password string variable
		System.out.println("Generated Password: " + password);

		String temp_ids;
		if ("SBA".equals(tempdata)) {
			temp_ids = "SBA001";
			System.out.println("Savings account present: " + temp_ids);
		} else if ("CAA".equals(tempdata)) {
			temp_ids = "CAA001";
			System.out.println("Current account present: " + temp_ids);
		} else {
			temp_ids = ""; // Assign a default value if no condition matches
			System.out.println("No account type matched. Default template ID: " + temp_ids);
		}

		// Parameters map creation
		Map<String, Object> params = new HashMap<>();
		params.put("ACCT_NO", acctNum); // Account number
		params.put("FROM_DATE", fromDate); // From date
		params.put("TO_DATE", toDate); // To date
		params.put("TEMPLATE_ID", temp_ids); // Template ID derived from tempdata

		// Printing parameters for debugging (optional)
		System.out.println("Parameters: " + params);

		// Generate report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, srcdataSource.getConnection());

		if ("pdf".equalsIgnoreCase(filetype)) {
			fullPath += ".pdf";

			// Export JasperPrint to PDF bytes
			byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

			// Encrypt the PDF with a password using iText
			try (FileOutputStream fos = new FileOutputStream(fullPath)) {
				PdfReader reader = new PdfReader(new ByteArrayInputStream(pdfBytes));
				PdfStamper stamper = new PdfStamper(reader, fos);

				// Set the user and owner password
				String userPassword = "1234";
				String ownerPassword = "owner123"; // Optional, for advanced control

				stamper.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING, // Permissions
						PdfWriter.ENCRYPTION_AES_128 // Encryption level
				);
				stamper.close();
				reader.close();
			}
		} else if ("excel".equalsIgnoreCase(filetype)) {
			fullPath += ".xlsx";
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fullPath));
			exporter.exportReport();
		} else if ("email".equalsIgnoreCase(filetype)) {
			System.out.println("The gmail will recive that " + filetype);
		}

		return new File(fullPath);
	}

}
