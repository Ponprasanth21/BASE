package com.bornfire.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.config.SequenceGenerator;
import com.bornfire.entities.BACP_CUS_PROFILE_REPO;
import com.bornfire.entities.BGLSBusinessTable_Entity;
import com.bornfire.entities.BGLSBusinessTable_Rep;
import com.bornfire.entities.Collection_Process_Entity;
import com.bornfire.entities.Collection_Process_Repo;
import com.bornfire.entities.CustomerRequest;
import com.bornfire.entities.DepositRep;
import com.bornfire.entities.EKYCMinimalData;
import com.bornfire.entities.GeneralLedgerWork_Entity;
import com.bornfire.entities.GeneralLedgerWork_Rep;
import com.bornfire.entities.HolidayMaster_Entity;
import com.bornfire.entities.HolidayMaster_Rep;
import com.bornfire.entities.MinimalDataRepository;
import com.bornfire.entities.Td_defn_Repo;
import com.bornfire.entities.UserProfile;
import com.bornfire.entities.UserProfileRep;

@Service
@ConfigurationProperties("output")
@Transactional
public class CustomerRequestService {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	MinimalDataRepository minimalDataRepository;

	@Autowired
	BACP_CUS_PROFILE_REPO bACP_CUS_PROFILE_REPO;

	@Autowired
	DepositRep depositRep;

	@Autowired
	Td_defn_Repo td_defn_Repo;

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	BGLSBusinessTable_Rep bglsBusinessTable_Rep;

	private static final Logger logger = LoggerFactory.getLogger(LoginServices.class);

	@SuppressWarnings("unchecked")
	public Object getCustomerSchemelist(String appl_ref_no) {

		List<CustomerRequest> cnt1 = (List<CustomerRequest>) sessionFactory.getCurrentSession()
				.createQuery("from CustomerRequest where STATUS!='REJECT'").getResultList();

		return cnt1;

	}

	@SuppressWarnings("unchecked")
	public CustomerRequest getUser(String appl_ref_no) {

		List<CustomerRequest> cnt1 = (List<CustomerRequest>) sessionFactory.getCurrentSession()
				.createQuery("from CustomerRequest where appl_ref_no=?1").setParameter(1, appl_ref_no).getResultList();

		if (cnt1.size() > 0) {
			return cnt1.get(0);
		} else {
			return new CustomerRequest();
		}

	}

	public CustomerRequest UserBlobImage(String appl_ref_no) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(appl_ref_no);
		@SuppressWarnings("unchecked")
		List<CustomerRequest> query = (List<CustomerRequest>) session
				.createQuery("from CustomerRequest where appl_ref_no=?1").setParameter(1, appl_ref_no).getResultList();
		return query.get(0);

	};

	public CustomerRequest getRoleMenu(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<CustomerRequest> query = session.createQuery(" from CustomerRequest where appl_ref_no=?1",
				CustomerRequest.class);
		query.setParameter(1, id);
		List<CustomerRequest> result = query.getResultList();
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return new CustomerRequest();
		}

	}

	public String addUser(CustomerRequest customerreq, String formmode) {
		System.out.println("hihihih");
		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		if (formmode.equals("submit")) {
			CustomerRequest up = customerreq;
			// up.setRef_num("1");
			hs.saveOrUpdate(up);
			up.setEntity_flg("N");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Login Security Submitted Successfully";

		}
		return msg;

	}

	public CustomerRequest getCustomer(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<CustomerRequest> query = session.createQuery(" from CustomerRequest where appl_ref_no=?1",
				CustomerRequest.class);
		query.setParameter(1, id);
		List<CustomerRequest> result = query.getResultList();
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return new CustomerRequest();
		}

	}

	public String addAlert(CustomerRequest customerreq, String formmode) {
		// TODO Auto-generated method stub
		String msg = "";

		/* try { */

		if (formmode.equals("add")) {

			CustomerRequest up = customerreq;
			up.setEntity_flg("Y");
			// up.setApproval_flg("N");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "User Created Successfully";

		}
		// When the user data modifed and submitted.

		else if (formmode.equals("edit")) {
			CustomerRequest up = customerreq;

			// up.setApproval_flg("N");
			bACP_CUS_PROFILE_REPO.save(up);

			msg = "User Edited Successfully";

		}
		return msg;
	}

	public String personalDetail(CustomerRequest customerreq, String ARNno, String rec_no, String userId) {
		String msg = null;
		String Acc_type;
		String customer_type;
		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		try {
			BigDecimal rec = new BigDecimal(rec_no);

			// Correct string comparison with .equals() instead of ==
			if (rec_no.equals("1")) {
				Acc_type = "INDIVIDUAL";
				customer_type = "RETAIL";
				audit.setFunc_code("INDIVIDUAL");
			} else {
				if ("CORPORATE".equals(customerreq.getCa_customer_type_1())) { // Avoid potential null pointer exception
					Acc_type = "CORPORATE";
					customer_type = "CORPORATE";
					audit.setFunc_code("CORPORATE");
				} else {
					Acc_type = "JOINT ACCOUNT";
					customer_type = "RETAIL";
					audit.setFunc_code("JOINT ACCOUNT");
				}
			}

			// Update customer request fields
			CustomerRequest up = customerreq;
			up.setAppl_ref_no(ARNno);
			up.setCa_acct_type(Acc_type);
			up.setCa_customer_type(customer_type);
			up.setEntry_user(userId);
			up.setEntry_time(new Date());
			up.setDel_flg("N");
			up.setEntity_flg("N");
			up.setVerify_flg("N");
			
			// Save customer profile
			bACP_CUS_PROFILE_REPO.save(up);

			// Prepare and save minimal data
			EKYCMinimalData as = new EKYCMinimalData();
			as.setAppl_ref_no(ARNno);
			as.setFirst_name(customerreq.getCa_first_name());
			as.setLast_name(customerreq.getCa_last_name());
			as.setNationality(customerreq.getCa_nationality());
			as.setMbl_num(customerreq.getCa_mobile_no());
			as.setDob(customerreq.getCa_date_of_birth());
			customerreq.getCa_acct_opendate();
			System.out.println(customerreq.getCa_acct_opendate() + " OPEN DATE");
			as.setStatus("INITIATED");
			as.setCust_grp(customer_type);
			as.setRec_no(rec);
			as.setAcc_type(Acc_type);
			as.setEntry_user(userId);
			as.setSts_flg("Y");
			as.setEntry_time(new Date());
			as.setChannel_id("CH3");
			as.setModify_user(userId);
			as.setModify_time(new Date());
			as.setNational_id(ARNno);

			// Save minimal data
			minimalDataRepository.save(as);
			// FOR AUIDT
			Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
			Optional<UserProfile> up1 = userProfileRep.findById(userId);
			UserProfile user = up1.get();

			LocalDateTime currentDateTime = LocalDateTime.now();
			Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
			audit.setAudit_date(new Date());
			audit.setEntry_time(dateValue);
			audit.setEntry_user(user.getUserid());

			audit.setRemarks("Customer Added Successfully");
			audit.setAudit_table("BACP_CUS_PROFILE");
			audit.setAudit_screen("CUSTOMER ONBOARDING");
			audit.setEvent_id(user.getUserid());
			audit.setEvent_name(user.getUsername());
			// audit.setModi_details("Login Successfully");
			UserProfile auth_user = userProfileRep.getRole(user.getUserid());
			String auth_user_val = auth_user.getAuth_user();
			Date auth_user_date = auth_user.getAuth_time();
			audit.setAuth_user(auth_user_val);
			audit.setAuth_time(auth_user_date);
			audit.setAudit_ref_no(auditID.toString());
			audit.setField_name("-");

			// bglsBusinessTable_Rep.save(audit);

			msg = "Personal Detail Uploaded Successfully";

		} catch (Exception e) {
			msg = "Error occurred!";
		}

		return msg;
	}

	
	public String personalDetailForEdit(CustomerRequest customerreq, String ARNno, String rec_no, String userId) {
		String msg = null;
		String Acc_type;
		String customer_type;
		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		try {
			BigDecimal rec = new BigDecimal(rec_no);

			// Correct string comparison with .equals() instead of ==
			if (rec_no.equals("1")) {
				Acc_type = "INDIVIDUAL";
				customer_type = "RETAIL";
				audit.setFunc_code("INDIVIDUAL");
			} else {
				if ("CORPORATE".equals(customerreq.getCa_customer_type_1())) { // Avoid potential null pointer exception
					Acc_type = "CORPORATE";
					customer_type = "CORPORATE";
					audit.setFunc_code("CORPORATE");
				} else {
					Acc_type = "JOINT ACCOUNT";
					customer_type = "RETAIL";
					audit.setFunc_code("JOINT ACCOUNT");
				}
			}

			// Update customer request fields
			CustomerRequest up = customerreq;
			up.setAppl_ref_no(ARNno);
			up.setCa_acct_type(Acc_type);
			up.setCa_customer_type(customer_type);
			up.setModify_user(userId);
			up.setModify_time(new Date());
			up.setDel_flg("N");
			up.setModify_flg("N");	
			up.setVerify_flg("N");
			up.setStatus("NOT APPROVED");
			// Save customer profile
			bACP_CUS_PROFILE_REPO.save(up);

			// Prepare and save minimal data
			EKYCMinimalData as = new EKYCMinimalData();
			as.setAppl_ref_no(ARNno);
			as.setFirst_name(customerreq.getCa_first_name());
			as.setLast_name(customerreq.getCa_last_name());
			as.setNationality(customerreq.getCa_nationality());
			as.setMbl_num(customerreq.getCa_mobile_no());
			as.setDob(customerreq.getCa_date_of_birth());
			customerreq.getCa_acct_opendate();
			System.out.println(customerreq.getCa_acct_opendate() + " OPEN DATE");
			as.setStatus("INITIATED");
			as.setCust_grp(customer_type);
			as.setRec_no(rec);
			as.setAcc_type(Acc_type);
			as.setEntry_user(userId);
			as.setSts_flg("Y");
			as.setEntry_time(new Date());
			as.setChannel_id("CH3");
			as.setModify_user(userId);
			as.setModify_time(new Date());
			as.setNational_id(ARNno);

			// Save minimal data
			minimalDataRepository.save(as);
			// FOR AUIDT
			Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
			Optional<UserProfile> up1 = userProfileRep.findById(userId);
			UserProfile user = up1.get();

			LocalDateTime currentDateTime = LocalDateTime.now();
			Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
			audit.setAudit_date(new Date());
			audit.setEntry_time(dateValue);
			audit.setEntry_user(user.getUserid());

			audit.setRemarks("Customer Added Successfully");
			audit.setAudit_table("BACP_CUS_PROFILE");
			audit.setAudit_screen("CUSTOMER ONBOARDING");
			audit.setEvent_id(user.getUserid());
			audit.setEvent_name(user.getUsername());
			// audit.setModi_details("Login Successfully");
			UserProfile auth_user = userProfileRep.getRole(user.getUserid());
			String auth_user_val = auth_user.getAuth_user();
			Date auth_user_date = auth_user.getAuth_time();
			audit.setAuth_user(auth_user_val);
			audit.setAuth_time(auth_user_date);
			audit.setAudit_ref_no(auditID.toString());
			audit.setField_name("-");

			// bglsBusinessTable_Rep.save(audit);

			msg = "Personal Detail Uploaded Successfully";

		} catch (Exception e) {
			msg = "Error occurred!";
		}

		return msg;
	}

	
	/**
	 * @param customerreq
	 * @param ARNno
	 * @return
	 */
	public String AccountDetailNxt(CustomerRequest customerreq, String ARNno) {
		String msg = null;
		try {
			System.out.println("The arn no is : " + ARNno);
			CustomerRequest ll = bACP_CUS_PROFILE_REPO.findByref_no(ARNno);
			ll.setCa_schemetype(customerreq.getCa_schemetype());
			ll.setCa_scheme_code(customerreq.getCa_scheme_code());
			ll.setCa_currency(customerreq.getCa_currency());
			// ll.setCa_glcode(customerreq.getCa_glcode());
			ll.setCa_solid(customerreq.getCa_solid());
			ll.setCa_idenditification_number(customerreq.getCa_idenditification_number());
			ll.setCa_issue_date(customerreq.getCa_issue_date());
			ll.setCa_passport_number(customerreq.getCa_passport_number());
			ll.setCa_expiry_date(customerreq.getCa_expiry_date());
			ll.setCa_non_resident(customerreq.getCa_non_resident());
			ll.setCa_staff_indicator(customerreq.getCa_staff_indicator());
			ll.setCa_trdfin(customerreq.getCa_trdfin());
			ll.setCa_minor_indicator(customerreq.getCa_minor_indicator());
			ll.setLa_loan_accountno(customerreq.getLa_loan_accountno());
			ll.setLa_date_loan(customerreq.getLa_date_loan());
			ll.setLa_loan_sanctioned(customerreq.getLa_loan_sanctioned());
			ll.setLa_margin(customerreq.getLa_margin());
			ll.setLa_drawing_limit(customerreq.getLa_drawing_limit());
			ll.setLa_disbursement(customerreq.getLa_disbursement());
			ll.setLa_outstanding(customerreq.getLa_outstanding());
			ll.setLa_loan_period(customerreq.getLa_loan_period());
			ll.setLa_repayment_terms(customerreq.getLa_repayment_terms());
			ll.setLa_expiry_date(customerreq.getLa_expiry_date());
			ll.setLa_remarks(customerreq.getLa_remarks());
			ll.setLa_recovery_method(customerreq.getLa_recovery_method());
			ll.setTd_deposit_accountno(customerreq.getTd_deposit_accountno());
			ll.setTd_date_deposit(customerreq.getTd_date_deposit());
			ll.setTd_deposit_amt(customerreq.getTd_deposit_amt());
			ll.setTd_currency(customerreq.getTd_currency());
			ll.setTd_period(customerreq.getTd_period());
			ll.setTd_maturity(customerreq.getTd_maturity());
			ll.setTd_rate_interest(customerreq.getTd_rate_interest());
			ll.setTd_compounding_factor(customerreq.getTd_compounding_factor());
			ll.setTd_maturity_amt(customerreq.getTd_maturity_amt());
			ll.setLa_loan_accountno(customerreq.getLa_loan_accountno());
			// ll.setCa_glshdesc(customerreq.getCa_glshdesc());
			ll.setCountry_of_operation(customerreq.getCountry_of_operation());
			ll.setLa_glcode(customerreq.getLa_glcode());
			ll.setLa_gldesc(customerreq.getLa_gldesc());
			ll.setLa_glshcode(customerreq.getLa_glshcode());
			ll.setLa_glshdesc(customerreq.getLa_glshdesc());
			ll.setTd_glcode(customerreq.getTd_glcode());
			ll.setTd_gldesc(customerreq.getTd_gldesc());
			ll.setTd_glshcode(customerreq.getTd_glshcode());
			ll.setTd_glshdesc(customerreq.getTd_glshdesc());
			System.out.println(customerreq.getCountry_of_operation()
					+ "ll.setCountry_of_operation(customerreq.getCountry_of_operation())");
			// bACP_CUS_PROFILE_REPO.save(ll);

			EKYCMinimalData as = minimalDataRepository.findByapplref(ARNno);
			as.setNational_id(customerreq.getCa_idenditification_number());
			as.setPassport(customerreq.getCa_passport_number());
			as.setIssue_date(customerreq.getCa_issue_date());
			minimalDataRepository.save(as);
			msg = "Account Detail Uploaded Successfully";

		} catch (Exception e) {
			msg = " Error is occured ! ";
		}

		return msg;
	}

	private boolean isRowEmpty(Row row) {
		boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();

		if (row != null) {
			for (Cell cell : row) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
	}

	@Autowired
	GeneralLedgerWork_Rep generalLedgerWork_Rep;

	public String Uploadgstservicetwo(String screenId, MultipartFile file, String userid,
			GeneralLedgerWork_Entity GeneralLedgerWork_Entity)
			throws SQLException, FileNotFoundException, IOException, NullPointerException {
		System.out.println("Entering third Service Succesfully of GST EXCEL UPLOAD");

		String fileName = file.getOriginalFilename();

		String fileExt = "";
		String msg = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			fileExt = fileName.substring(i + 1);
		}

		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {

			try {
				Workbook workbook = WorkbookFactory.create(file.getInputStream());

				List<HashMap<Integer, String>> mapList = new ArrayList<HashMap<Integer, String>>();
				for (Sheet s : workbook) {
					for (Row r : s) {

						if (!isRowEmpty(r)) {
							if (r.getRowNum() == 0) {
								continue;
							}

							HashMap<Integer, String> map = new HashMap<>();

							for (int j = 0; j < 100; j++) {

								Cell cell = r.getCell(j);
								DataFormatter formatter = new DataFormatter();
								String text = formatter.formatCellValue(cell);
								map.put(j, text);
							}
							mapList.add(map);

						}

					}

				}

				for (HashMap<Integer, String> item : mapList) {

					GeneralLedgerWork_Entity PO = new GeneralLedgerWork_Entity();

					/* String ORGANISATION = item.get(0); */

					// System.out.println("ORGANISATION" +ORGANISATION);

					String gl_code = item.get(0);
					System.out.println("gl_code: " + gl_code); //

					String gl_description = item.get(1);
					System.out.println("gl_description: " + gl_description);

					String branch_id = item.get(2);
					System.out.println("branch_id: " + branch_id);

					String branch_description = item.get(3);
					System.out.println("branch_description: " + branch_description);

					String glsh_code = item.get(4);
					System.out.println("glsh_code: " + glsh_code);

					String glsh_description = item.get(5);
					System.out.println("glsh_description: " + glsh_description);

					String crncy_code = item.get(6);
					System.out.println("crncy_code: " + crncy_code);

					String bal_sheet_grp = item.get(7);
					System.out.println("bal_sheet_grp: " + bal_sheet_grp);

					String seq_order = item.get(8);
					System.out.println("seq_order: " + seq_order);

					String gl_type = item.get(9);
					System.out.println("gl_type: " + gl_type);

					String gl_type_description = item.get(10);
					System.out.println("gl_type_description: " + gl_type_description);

					String module = item.get(11);
					System.out.println("module: " + module);

					String remarks = item.get(12);
					System.out.println("remarks: " + remarks);

					String no_of_acct_closed = item.get(13);
					System.out.println("no_of_acct_closed: " + no_of_acct_closed);

					String no_of_acct_opened = item.get(14);
					System.out.println("no_of_acct_opened: " + no_of_acct_opened);

					String total_balance = item.get(15);
					System.out.println("no_of_acct_opened: " + no_of_acct_opened);

					PO.setGlCode(gl_code);
					PO.setGlDescription(gl_description);
					PO.setBranch_id(branch_id);
					PO.setBranch_desc(branch_description);
					PO.setGlsh_code(glsh_code);
					PO.setGlsh_desc(glsh_description);
					PO.setCrncy_code(crncy_code);
					PO.setBal_sheet_group(bal_sheet_grp);
					PO.setSeq_order(seq_order);
					PO.setGl_type(gl_type);
					PO.setGl_type_description(gl_type_description);
					PO.setModule(module);
					PO.setRemarks(remarks);
					PO.setNo_acct_closed(no_of_acct_closed);
					PO.setNo_acct_opened(no_of_acct_opened);
					PO.setTotal_balance(total_balance);

					generalLedgerWork_Rep.save(PO);

					msg = "Excel Data Uploaded Successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg = "File has not been successfully uploaded";
			}
		}
		return msg;

	}

	@Autowired
	Collection_Process_Repo collection_Process_Repo;

	public String UploadgstserviceCOLLECTION(String screenId, MultipartFile file, String userid,
			Collection_Process_Entity Collection_Process_Entity)
			throws SQLException, FileNotFoundException, IOException, NullPointerException {
		System.out.println("Entering third Service Succesfully of GST EXCEL UPLOAD");

		String fileName = file.getOriginalFilename();

		String fileExt = "";
		String msg = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			fileExt = fileName.substring(i + 1);
		}

		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {

			try {
				Workbook workbook = WorkbookFactory.create(file.getInputStream());

				List<HashMap<Integer, String>> mapList = new ArrayList<HashMap<Integer, String>>();
				for (Sheet s : workbook) {
					for (Row r : s) {

						if (!isRowEmpty(r)) {
							if (r.getRowNum() == 0) {
								continue;
							}

							HashMap<Integer, String> map = new HashMap<>();

							for (int j = 0; j < 100; j++) {

								Cell cell = r.getCell(j);
								DataFormatter formatter = new DataFormatter();
								String text = formatter.formatCellValue(cell);
								map.put(j, text);
							}
							mapList.add(map);

						}

					}

				}

				for (HashMap<Integer, String> item : mapList) {

					Collection_Process_Entity PO = new Collection_Process_Entity();

					/* String ORGANISATION = item.get(0); */

					// System.out.println("ORGANISATION" +ORGANISATION);

					String bank = item.get(0);
					System.out.println("bank: " + bank); //

					String branch = item.get(1);
					System.out.println("branch: " + branch);

					String settlement_act = item.get(2);
					System.out.println("settlement_act: " + settlement_act);

					BigDecimal settlement_act_amount = new BigDecimal(item.get(3));
					System.out.println("settlement_act_amount: " + settlement_act_amount);

					String customer_name = item.get(4);
					System.out.println("customer_name: " + customer_name);
					String account = item.get(5);
					System.out.println("nic_no: " + account);

					String mobile_no = item.get(6);

					System.out.println("mobile_no: " + mobile_no);

					String cus_acct_amount = item.get(7);
					System.out.println("crncy_code: " + cus_acct_amount);

					BigDecimal cust_amount = null;

					String cleanedUsd = cus_acct_amount.replaceAll("[^0-9.]", "");

					try {
						// Convert the cleaned string to BigDecimal
						cust_amount = new BigDecimal(cleanedUsd);
						System.out.println("usds: " + cust_amount);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						System.out.println("Failed to convert string to BigDecimal: " + cleanedUsd);
					}

					String nic_no = item.get(8);
					System.out.println("nic_no: " + nic_no);

					PO.setBank(bank);
					PO.setBranch(branch);
					PO.setSettlement_accountString(settlement_act);
					PO.setSettlement_account_amount(settlement_act_amount);
					PO.setCustomer_name(customer_name);
					PO.setAccount_no(account);
					PO.setMobile_no(mobile_no);

					PO.setCustomer_account_amount(cust_amount);
					PO.setNic_number(nic_no);

					collection_Process_Repo.save(PO);

					msg = "Excel Data Uploaded Successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg = "File has not been successfully uploaded";
			}
		}
		return msg;

	}

	@Autowired
	HolidayMaster_Rep holidayMaster_Rep;

	public String Uploadholidaymaster(String screenId, MultipartFile file, String userid,
			HolidayMaster_Entity HolidayMaster_Entity)
			throws SQLException, FileNotFoundException, IOException, NullPointerException {
		System.out.println("Entering third Service Succesfully of GST EXCEL UPLOAD");

		String fileName = file.getOriginalFilename();

		String fileExt = "";
		String msg = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			fileExt = fileName.substring(i + 1);
		}

		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {

			try {
				Workbook workbook = WorkbookFactory.create(file.getInputStream());

				List<HashMap<Integer, String>> mapList = new ArrayList<HashMap<Integer, String>>();
				for (Sheet s : workbook) {
					for (Row r : s) {

						if (!isRowEmpty(r)) {
							if (r.getRowNum() == 0) {
								continue;
							}

							HashMap<Integer, String> map = new HashMap<>();

							for (int j = 0; j < 100; j++) {

								Cell cell = r.getCell(j);
								DataFormatter formatter = new DataFormatter();
								String text = formatter.formatCellValue(cell);
								map.put(j, text);
							}
							mapList.add(map);

						}

					}

				}

				for (HashMap<Integer, String> item : mapList) {

					HolidayMaster_Entity PO = new HolidayMaster_Entity();

					BigDecimal record_srl = new BigDecimal(item.get(0));
					System.out.println("record_srl: " + record_srl);

					String orgn = item.get(1);
					System.out.println("orgn: " + orgn);

					String location = item.get(2);
					System.out.println("location: " + location);

					String cal_year = item.get(3);
					System.out.println("cal_year: " + cal_year);

					/*
					 * BigDecimal settlement_act_amount = new BigDecimal(item.get(3)) ;
					 * System.out.println("settlement_act_amount: " + settlement_act_amount);
					 */
					String cal_month = item.get(4);
					System.out.println("cal_month: " + cal_month);

					String datePattern = "MM/dd/yy"; // Correct pattern for dates like "12/25/24"
					SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

					String record_date = item.get(5);
					Date date_value = null;

					if (record_date != null && !record_date.isEmpty()) {
					    try {
					        date_value = dateFormat.parse(record_date);
					    } catch (ParseException e) {
					        e.printStackTrace();
					    }
					} else {
					    System.out.println("Record Date is null");
					}

					System.out.println("date_value: " + date_value);

					String holiday_desc = item.get(6);
					System.out.println("holiday_desc: " + holiday_desc);

					String holiday_remarks = item.get(7);
					System.out.println("holiday_remarks: " + holiday_remarks);

					String holiday_flg = item.get(8);
					System.out.println("holiday_flg: " + holiday_flg);

					String record_status = item.get(9);
					System.out.println("record_status" + record_status);

					PO.setRecord_srl(record_srl);
					PO.setOrgn(orgn);
					PO.setLocation(location);
					PO.setCal_year(cal_year);
					PO.setRecord_date(date_value);
					PO.setCal_month(cal_month);
					PO.setHoliday_desc(holiday_desc);
					PO.setHoliday_remarks(holiday_remarks);
					PO.setHoliday_flg(holiday_flg);
					PO.setRecord_status(record_status);

					holidayMaster_Rep.save(PO);

					msg = "Excel Data Uploaded Successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg = "File has not been successfully uploaded";
			}
		}
		return msg;

	}

}
