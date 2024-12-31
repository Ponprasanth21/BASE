package com.bornfire.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.config.SequenceGenerator;
import com.bornfire.entities.Access_Role_Entity;
import com.bornfire.entities.Account_Ledger_Entity;
import com.bornfire.entities.Account_Ledger_Rep;
import com.bornfire.entities.BACP_CUS_PROFILE_REPO;
import com.bornfire.entities.BGLSAuditTable;
import com.bornfire.entities.BGLSAuditTable_Rep;
import com.bornfire.entities.BGLSBusinessTable_Entity;
import com.bornfire.entities.BGLSBusinessTable_Rep;
import com.bornfire.entities.Chart_Acc_Entity;
import com.bornfire.entities.Chart_Acc_Rep;
import com.bornfire.entities.CustomerRequest;
import com.bornfire.entities.DAB_Repo;
import com.bornfire.entities.DMD_TABLE;
import com.bornfire.entities.DMD_TABLE_REPO;
import com.bornfire.entities.DepositEntity;
import com.bornfire.entities.DepositRep;
import com.bornfire.entities.Employee_Profile;
import com.bornfire.entities.Employee_Profile_Rep;
import com.bornfire.entities.GeneralLedgerEntity;
import com.bornfire.entities.GeneralLedgerRep;
import com.bornfire.entities.GeneralLedgerWork_Rep;
import com.bornfire.entities.LeaseData;
import com.bornfire.entities.Lease_Loan_Master_Entity;
import com.bornfire.entities.Lease_Loan_Master_Repo;
import com.bornfire.entities.Lease_Loan_Work_Entity;
import com.bornfire.entities.Lease_Loan_Work_Repo;
import com.bornfire.entities.NoticeDetailsPayment0Entity;
import com.bornfire.entities.NoticeDetailsPayment0Rep;
import com.bornfire.entities.Organization_Branch_Entity;
import com.bornfire.entities.Organization_Branch_Rep;
import com.bornfire.entities.Organization_Entity;
import com.bornfire.entities.Organization_Repo;
import com.bornfire.entities.Principle_and_intrest_shedule_Entity;
import com.bornfire.entities.Reference_Code_Entity;
import com.bornfire.entities.Reference_code_Rep;
import com.bornfire.entities.RepaymentScheduleEntity;
import com.bornfire.entities.Settlement_Collection_Entity;
import com.bornfire.entities.TRAN_MAIN_TRM_REP;
import com.bornfire.entities.TRAN_MAIN_TRM_WRK_ENTITY;
import com.bornfire.entities.TRAN_MAIN_TRM_WRK_REP;
import com.bornfire.entities.Td_defn_Repo;
import com.bornfire.entities.Td_defn_table;
import com.bornfire.entities.TestPrincipalCalculation;
import com.bornfire.entities.Test_Collection_Entity;
import com.bornfire.entities.Transaction_Partition_Detail_Entity;
import com.bornfire.entities.Transaction_Partition_Detail_Repo;
import com.bornfire.entities.Transaction_Pointing_Table_Entity;
import com.bornfire.entities.Transaction_Pointing_Table_Repo;
import com.bornfire.entities.Transaction_Reversed_Table_Entity;
import com.bornfire.entities.Transaction_Reversed_Table_Repo;
import com.bornfire.entities.UserProfile;
import com.bornfire.entities.UserProfileRep;
import com.bornfire.services.AdminOperServices;
import com.bornfire.services.DepositServices;
import com.bornfire.services.InterestCalculationServices;
import com.bornfire.services.LeaseLoanService;
import com.bornfire.services.LoginServices;
import com.bornfire.services.RepaymentScheduleServices;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

@RestController
@Transactional

public class BGLSRestController {

	@Autowired
	Employee_Profile_Rep employee_Profile_Rep;

	@Autowired
	LoginServices loginServices;

	@Autowired
	DAB_Repo dab_Repo;

	@Autowired
	Chart_Acc_Rep chart_Acc_Rep;

	@Autowired
	Account_Ledger_Rep account_Ledger_Rep;

	@Autowired
	Organization_Branch_Rep organization_Branch_Rep;

	@Autowired
	Organization_Repo organization_Repo;

	@Autowired
	Reference_code_Rep reference_code_Rep;

	@Autowired
	AdminOperServices adminOperServices;

	@Autowired
	DMD_TABLE_REPO dmdRepo;

	@Autowired
	NoticeDetailsPayment0Rep noticeDetailsPayment0Rep;

	@Autowired
	RepaymentScheduleServices repaymentScheduleServices;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	BGLSBusinessTable_Rep bGLSBusinessTable_Rep;

	@Autowired
	BGLSAuditTable_Rep bGLSAuditTable_Rep;

	@Autowired
	DepositRep depositRep;

	@Autowired
	BACP_CUS_PROFILE_REPO bACP_CUS_PROFILE_REPO;

	@Autowired
	InterestCalculationServices interestCalculationServices;

	@Autowired
	TRAN_MAIN_TRM_REP transactionMaintenanceRepository;

	@Autowired
	TRAN_MAIN_TRM_WRK_REP tranMainRep;

	@Autowired
	Td_defn_Repo td_defn_Repo;

	@Autowired
	DepositServices depositServices;

	@Autowired
	Lease_Loan_Master_Repo lease_Loan_Master_Repo;

	@Autowired
	LeaseLoanService leaseLoanService;

	@Autowired
	Lease_Loan_Work_Repo lease_Loan_Work_Repo;

	@Autowired
	TRAN_MAIN_TRM_WRK_REP tRAN_MAIN_TRM_WRK_REP;

	@Autowired
	DMD_TABLE_REPO dMD_TABLE_REPO;

	@Autowired
	GeneralLedgerWork_Rep generalLedgerWork_Rep;

	@Autowired
	BGLSBusinessTable_Rep bglsBusinessTable_Rep;

	@Autowired
	GeneralLedgerRep generalLedgerRep;

	@Autowired
	Transaction_Partition_Detail_Repo transaction_Partition_Detail_Repo;

	@Autowired
	Transaction_Pointing_Table_Repo transaction_Pointing_Table_Repo;

	@Autowired
	Transaction_Reversed_Table_Repo transaction_Reversed_Table_Repo;

	/* THANVEER */
	@RequestMapping(value = "employeeAdd", method = RequestMethod.POST)
	@ResponseBody
	public String employeeAdd(HttpServletRequest rq, @ModelAttribute Employee_Profile employee_Profile) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		List<String> existingdata = employee_Profile_Rep.getexistingData();
		if (existingdata.contains(employee_Profile.getEmployee_id())) {
			return "Employee Id Already Exist";
		} else {
			System.out.println("sss" + employee_Profile.getEntry_user());
			employee_Profile.setEntry_user(userid);

			// String empSrlNo = employee_Profile_Rep.getSrlNo();
			// employee_Profile.setEmployee_id(empSrlNo);

			employee_Profile.setEntry_time(new Date());
			employee_Profile.setEntity_flg("N");
			employee_Profile.setModify_flg("N");
			employee_Profile.setDel_flg("N");

			// FOR AUIDT
			BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
			Long auditID = bGLSBusinessTable_Rep.getAuditRefUUID();
			Optional<UserProfile> up1 = userProfileRep.findById(userid);
			UserProfile user = up1.get();

			LocalDateTime currentDateTime = LocalDateTime.now();
			Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
			audit.setAudit_date(new Date());
			audit.setEntry_time(dateValue);
			audit.setEntry_user(user.getUserid());
			audit.setFunc_code("Employee Id");
			audit.setRemarks("Sucessfully Saved");
			audit.setAudit_table("BGLS_EMPLOYEE_PROFILE");
			audit.setAudit_screen("EMPLOYEE PROFILE - ADD");
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
			employee_Profile_Rep.save(employee_Profile);
			bGLSBusinessTable_Rep.save(audit);
			return "Sucessfully Saved";
		}

	}

	@RequestMapping(value = "employeeAdddemo", method = RequestMethod.POST)
	@ResponseBody
	public String employeeAdddemo(HttpServletRequest rq, @ModelAttribute Employee_Profile employee_Profile) {
		String user = (String) rq.getSession().getAttribute("USERID");
		List<String> existingData = employee_Profile_Rep.getexistingData();

		if (existingData.contains(employee_Profile.getEmployee_id())) {
			return "Employee Id Already Exist";
		} else {
			employee_Profile.setEntry_user(user);
			employee_Profile.setEntry_time(new Date());
			employee_Profile.setEntity_flg("N");
			employee_Profile.setModify_flg("N");
			employee_Profile.setDel_flg("N");

			employee_Profile_Rep.save(employee_Profile);
			return "Successfully Saved";
		}
	}

	@RequestMapping(value = "employeeAdd1", method = RequestMethod.POST)
	@ResponseBody
	public String employeeAddPhoto(@RequestParam("photoFile") MultipartFile photoFile,
			@RequestParam String employeeId, HttpServletRequest rq) {

		System.out.println("Uploading photo for employee ID: " + employeeId);

		// Check if the photo file is provided
		if (photoFile == null || photoFile.isEmpty()) {
			return "Please upload an image.";
		}

		// Fetch the Employee_Profile record by employeeId
		Employee_Profile employee_Profile = employee_Profile_Rep.getEmployeeData(employeeId);
		if (employee_Profile == null) {
			return "Employee not found.";
		}

		try {
			byte[] photoBytes = photoFile.getBytes();
			employee_Profile.setEmployee_Photo(photoBytes);

			// Save the updated profile
			employee_Profile_Rep.save(employee_Profile);
			return "Photo uploaded successfully.";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error processing the image.";
		}
	}

	/* Praveen */
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String createUser(@RequestParam("formmode") String formmode,
			@RequestParam("accountExpiryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date accountExpiryDate,
			@RequestBody UserProfile userprofile, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println("accountExpiryDate " + accountExpiryDate);
		userprofile.setAcc_exp_date(accountExpiryDate);
		String msg = loginServices.addUser(userprofile, formmode, userid);

		return msg;
	}

	/* Praveen */
	@RequestMapping(value = "verifyUser", method = RequestMethod.POST)
	public String verifyUser(@RequestParam("userId") String userId, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.verifyUser(userId, userid);

		return msg;

	}

	/* Praveen */
	@RequestMapping(value = "mosifyUser", method = RequestMethod.POST)
	public String mosifyUser(@RequestParam("formmode") String formmode,
			@RequestParam("accountExpiryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date accountExpiryDate,
			@RequestBody UserProfile userprofile, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println("accountExpiryDate " + accountExpiryDate);
		userprofile.setAcc_exp_date(accountExpiryDate);
		String msg = loginServices.addUser(userprofile, formmode, userid);

		return msg;
	}

	/* Praveen */
	@RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("userid") String userid, @RequestParam("deleteType") String deleteType,
			Model md, HttpServletRequest rq) {
		String userid1 = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.deleteUser(userid, deleteType, userid1);

		return msg;

	}

	/* THANVEER */
	@RequestMapping(value = "employeeVerify", method = RequestMethod.POST)
	@ResponseBody
	public String employeeVerify(HttpServletRequest rq, @ModelAttribute Employee_Profile employee_Profile) {

		System.out.println(employee_Profile + "verify");
		Employee_Profile up = employee_Profile_Rep.getEmployeeData(employee_Profile.getEmployee_id());
		String userid = (String) rq.getSession().getAttribute("USERID");
		employee_Profile.setEntity_flg("Y");
		employee_Profile.setModify_flg("N");
		employee_Profile.setDel_flg("N");
		employee_Profile.setEntry_time(up.getEntry_time());
		employee_Profile.setEntry_user(up.getEntry_user());
		employee_Profile.setEmployee_Photo(up.getEmployee_Photo());
		employee_Profile.setVerify_time(new Date());
		employee_Profile.setVerify_user(userid);
		employee_Profile_Rep.save(employee_Profile);
		System.out.println("Sucessfully Verified");

		// FOR AUIDT
		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		Long auditID = bGLSBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());
		audit.setFunc_code("Employee Id");
		audit.setRemarks("Sucessfully Verified");
		audit.setAudit_table("BGLS_EMPLOYEE_PROFILE");
		audit.setAudit_screen("EMPLOYEE PROFILE - VERIFY");
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

		bGLSBusinessTable_Rep.save(audit);
		return "Sucessfully Verified";

	}

	/* THANVEER */
	@RequestMapping(value = "employeeModify", method = RequestMethod.POST)
	@ResponseBody
	public String employeeModify(HttpServletRequest request, @ModelAttribute Employee_Profile employeeProfile) {

		// Retrieve current user ID from session
		String userId = (String) request.getSession().getAttribute("USERID");

		// Get existing employee data
		Employee_Profile existingProfile = employee_Profile_Rep.getEmployeeData(employeeProfile.getEmployee_id());

		// Preserve original entry and verification details
		employeeProfile.setEntry_time(existingProfile.getEntry_time());
		employeeProfile.setEntry_user(existingProfile.getEntry_user());
		employeeProfile.setVerify_time(existingProfile.getVerify_time());
		employeeProfile.setVerify_user(existingProfile.getVerify_user());

		// Set modification details
		employeeProfile.setModify_time(new Date());
		employeeProfile.setModify_user(userId);
		employeeProfile.setEntity_flg("N");
		employeeProfile.setModify_flg("Y");
		employeeProfile.setDel_flg("N");

		// Handle employee photo: retain existing if not provided in request
		if (employeeProfile.getEmployee_Photo() == null) {
			employeeProfile.setEmployee_Photo(existingProfile.getEmployee_Photo());
		}

		// Save updated profile to the repository
		employee_Profile_Rep.save(employeeProfile);

		return "Successfully Modified";
	}

	/* THANVEER */
	@RequestMapping(value = "employeedelete", method = RequestMethod.POST)
	@ResponseBody
	public String employeedelete(@RequestParam(required = false) String employeeId, HttpServletRequest rq,
			@ModelAttribute Employee_Profile employee_Profile) {

		Employee_Profile data = employee_Profile_Rep.getEmployeeData(employeeId);
		employee_Profile_Rep.delete(data);
		String userid = (String) rq.getSession().getAttribute("USERID");
		// FOR AUIDT
		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		Long auditID = bGLSBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());
		audit.setFunc_code("Employee Id");
		audit.setRemarks("Sucessfully Deleted");
		audit.setAudit_table("BGLS_EMPLOYEE_PROFILE");
		audit.setAudit_screen("EMPLOYEE PROFILE - DELETE");
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

		bGLSBusinessTable_Rep.save(audit);
		return "Sucessfully Deleted";

	}

	/* PRAVEEN */
	@GetMapping("/getTransactionBalance")
	@ResponseBody
	public BigDecimal getTransactionBalance(@RequestParam(required = false) String acctnum,
			@RequestParam(required = false) String fromdate, Model md) {

		System.out.println("Acct number: " + acctnum + " From date: " + fromdate);

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		Date fromDateParsed = null;
		String formattedDate = null;

		try {

			if (fromdate != null) {
				fromDateParsed = inputDateFormat.parse(fromdate);/* 08-12-2024 */
			}

			if (fromDateParsed != null) {

				formattedDate = outputDateFormat.format(fromDateParsed); /* 08-DEC-2024 */
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Error parsing 'fromdate': " + e.getMessage());
		}

		// Now pass the formatted date to the repository query
		BigDecimal tranDateBal = dab_Repo.getTranDateBAlance(acctnum, formattedDate);
		System.out.println("THE VALUE OF tran_date_bal: " + tranDateBal);

		return tranDateBal;
	}

	/* PRAVEEN */
	@GetMapping("/getTransactionRecords")
	public List<TRAN_MAIN_TRM_WRK_ENTITY> getTransactionRecords(@RequestParam(required = false) String acctnum,
			@RequestParam(required = false) String fromdate, @RequestParam(required = false) String todate) {

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");/* 08-12-2024 */
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy");/* 08-DEC-2024 */

		Date fromDateParsed = null;
		Date toDateParsed = null;

		try {
			if (fromdate != null) {
				fromDateParsed = inputDateFormat.parse(fromdate);
			}
			if (todate != null) {
				toDateParsed = inputDateFormat.parse(todate);
			}
		} catch (ParseException e) {
			e.printStackTrace();

		}

		String formattedFromDate = (fromDateParsed != null) ? outputDateFormat.format(fromDateParsed) : null;
		String formattedToDate = (toDateParsed != null) ? outputDateFormat.format(toDateParsed) : null;

		System.out.println("Formatted Dates: From = " + formattedFromDate + ", To = " + formattedToDate);

		List<TRAN_MAIN_TRM_WRK_ENTITY> records = tRAN_MAIN_TRM_WRK_REP.getTranList(acctnum, formattedFromDate,
				formattedToDate);
		for (TRAN_MAIN_TRM_WRK_ENTITY i : records) {
			System.out.println(i + "records");
		}
		return records;
	}

	/* Thanveer */
	@RequestMapping(value = "AddScreens", method = RequestMethod.POST)

	@ResponseBody
	public String AddScreens(Model md, HttpServletRequest rq, @ModelAttribute Chart_Acc_Entity chart_Acc_Entity) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		List<String> existingdata = chart_Acc_Rep.getexistingData();
		if (existingdata.contains(chart_Acc_Entity.getAcct_num())) {
			return "Employee Id Already Exist";
		} else {
			Chart_Acc_Entity up = chart_Acc_Entity;
			up.setEntity_flg("N");
			up.setDel_flg("N");
			chart_Acc_Rep.save(up);
			// FOR AUIDT
			Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
			Optional<UserProfile> up1 = userProfileRep.findById(userid);
			UserProfile user = up1.get();

			BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
			LocalDateTime currentDateTime = LocalDateTime.now();
			Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
			audit.setAudit_date(new Date());
			audit.setEntry_time(dateValue);
			audit.setEntry_user(user.getUserid());

			audit.setRemarks("Saved Successfully");
			audit.setAudit_table("BGLS_CHART_OF_ACCOUNTS");
			audit.setAudit_screen("CHART OF ACCOUNTS - ADD");
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

			bglsBusinessTable_Rep.save(audit);

			return "Saved Successfully";
		}
	}

	/* Thanveer */
	@RequestMapping(value = "VerifyScreens", method = RequestMethod.POST)

	@ResponseBody
	public String VerifyScreens(Model md, HttpServletRequest rq, @ModelAttribute Chart_Acc_Entity chart_Acc_Entity) {
		Chart_Acc_Entity up = chart_Acc_Entity;
		up.setEntity_flg("Y");
		up.setDel_flg("N");
		chart_Acc_Rep.save(up);
		String userid = (String) rq.getSession().getAttribute("USERID");
		// FOR AUIDT
		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();

		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());

		audit.setRemarks("Verified Successfully");
		audit.setAudit_table("BGLS_CHART_OF_ACCOUNTS");
		audit.setAudit_screen("CHART OF ACCOUNTS - VERIFY");
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

		bglsBusinessTable_Rep.save(audit);
		return "Verified Successfully";

	}

	/* Thanveer */
	@RequestMapping(value = "OrgBranchAdd", method = RequestMethod.POST)
	@ResponseBody
	public String OrgBranchAdd(Model md, HttpServletRequest rq,
			@ModelAttribute Organization_Branch_Entity organization_Branch_Entity,
			@RequestParam(required = false) MultipartFile photoFile) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		List<String> existingdata = organization_Branch_Rep.getexistingData();
		if (existingdata.contains(organization_Branch_Entity.getBranch_name())) {
			return "Branch Name Already Exist";
		} else {


			try {
				Organization_Branch_Entity up = organization_Branch_Entity;
				 
				 
				 if (photoFile != null && !photoFile.isEmpty()) {
				       
				            byte[] photoBytes = photoFile.getBytes(); // Convert the MultipartFile to byte array
				            up.setPhoto(photoBytes); // Set the byte array to the photo field
				        
				    } else {
				        // Handle the case where no file was selected
				        return "No file selected";
				    }
				
				up.setEntity_flg("N");
				up.setModify_flg("N");
				up.setDel_flg("N");
				up.setEntry_user(userid);
				up.setEntry_time(new Date());
				organization_Branch_Rep.save(up);

				BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
				audit.setFunc_code("BRANCH");
				Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
				Optional<UserProfile> up1 = userProfileRep.findById(userid);
				UserProfile user = up1.get();

				LocalDateTime currentDateTime = LocalDateTime.now();
				Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
				audit.setAudit_date(new Date());
				audit.setEntry_time(dateValue);
				audit.setEntry_user(user.getUserid());

				audit.setRemarks("Branch Added Successfully");
				audit.setAudit_table("BGLS_ORG_BRANCH");
				audit.setAudit_screen("Organization Details");
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

				bglsBusinessTable_Rep.save(audit);
			

				return "Added successfully.";
			} catch (IOException e) {
				e.printStackTrace();
				return "Error processing the image.";
			}
			

		
		}
	}
	/* tab2Del */

	@RequestMapping(value = "tab2Del", method = RequestMethod.POST)
	@ResponseBody
	public String tab2Del(Model md, HttpServletRequest rq,
			@ModelAttribute Organization_Branch_Entity organization_Branch_Entity) {
		String userid = (String) rq.getSession().getAttribute("USERID");

		Organization_Branch_Entity up = organization_Branch_Entity;
		up.setEntity_flg("N");
		up.setModify_flg("N");
		up.setDel_flg("Y");
		up.setEntry_user(userid);
		up.setEntry_time(new Date());
		organization_Branch_Rep.save(up);

		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		audit.setFunc_code("BRANCH-DELETE");
		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();

		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());

		audit.setRemarks("Branch Added Successfully");
		audit.setAudit_table("BGLS_ORG_BRANCH");
		audit.setAudit_screen("Organization Details");
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

		bglsBusinessTable_Rep.save(audit);

		return "Deleted Successfully";

	}

	/* Thanveer */
	@RequestMapping(value = "tab1modify", method = RequestMethod.POST)
	@ResponseBody
	public String tab1modify(Model md, HttpServletRequest rq, @ModelAttribute Organization_Entity organization_Entity)
			throws ParseException {

		Optional<Organization_Entity> up = organization_Repo.findById(organization_Entity.getOrg_name());
		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		String userid = (String) rq.getSession().getAttribute("USERID");
		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
		System.out.println(organization_Entity.getAs_on() + "uigiu");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(organization_Entity.getAs_on());

		try {
			Date parsedDate = dateFormat.parse(formattedDate); // Parse the String back to Date
			System.out.println("Parsed Date: " + parsedDate); // Prints the Date object
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Organization_Entity up = organization_Entity;
		String msg = "";
		if (up.isPresent()) {
			Organization_Entity us1 = up.get();
			if ((us1.getOrg_type().equals(organization_Entity.getOrg_type())
					&& us1.getDate_of_regn().equals(organization_Entity.getDate_of_regn())
					&& us1.getReg_no().equals(organization_Entity.getReg_no())
					&& us1.getPan_card().equals(organization_Entity.getPan_card())
					&& us1.getTan_card().equals(organization_Entity.getTan_card())
					&& us1.getNo_of_emp().equals(organization_Entity.getNo_of_emp())
					&& us1.getAs_on().equals(organization_Entity.getAs_on())
					&& us1.getReg_addr_1().equals(organization_Entity.getReg_addr_1())
					&& us1.getReg_addr_2().equals(organization_Entity.getReg_addr_2())
					&& us1.getCorp_addr_1().equals(organization_Entity.getCorp_addr_1())
					&& us1.getCor_addr_2().equals(organization_Entity.getCor_addr_2())
					&& us1.getWeb_site().equals(organization_Entity.getWeb_site())
					&& us1.getEmail().equals(organization_Entity.getEmail())

			)) {
				msg = "No any Modification done";
			} else {
				System.out.println(organization_Entity.getEmail());
				System.out.println(us1.getEmail());
				organization_Entity.setModify_flg("Y");
				organization_Entity.setDel_flg("N");
				organization_Entity.setModify_time(new Date());
				organization_Entity.setModify_user(userid);

				// for audit
				StringBuilder stringBuilder = new StringBuilder();

				if ((us1.getOrg_type().equals(organization_Entity.getOrg_type())
						&& us1.getDate_of_regn().equals(organization_Entity.getDate_of_regn())
						&& us1.getReg_no().equals(organization_Entity.getReg_no())
						&& us1.getPan_card().equals(organization_Entity.getPan_card())
						&& us1.getTan_card().equals(organization_Entity.getTan_card())
						&& us1.getNo_of_emp().equals(organization_Entity.getNo_of_emp())
						&& us1.getAs_on().equals(organization_Entity.getAs_on())
						&& us1.getReg_addr_1().equals(organization_Entity.getReg_addr_1())
						&& us1.getReg_addr_2().equals(organization_Entity.getReg_addr_2())
						&& us1.getCorp_addr_1().equals(organization_Entity.getCorp_addr_1())
						&& us1.getCor_addr_2().equals(organization_Entity.getCor_addr_2())
						&& us1.getWeb_site().equals(organization_Entity.getWeb_site())
						&& us1.getEmail().equals(organization_Entity.getEmail())

				)) {

				}
				if (!us1.getOrg_type().equals(organization_Entity.getOrg_type())) {
					stringBuilder = stringBuilder.append(
							"Organization Type+" + us1.getOrg_type() + "+" + organization_Entity.getOrg_type() + "||");
				}
				if (!us1.getDate_of_regn().equals(organization_Entity.getDate_of_regn())) {
					stringBuilder = stringBuilder.append("Date of Registration+" + us1.getDate_of_regn() + "+"
							+ organization_Entity.getDate_of_regn() + "||");
				}
				if (!us1.getReg_no().equals(organization_Entity.getReg_no())) {
					stringBuilder = stringBuilder.append("Certificate and Registration+" + us1.getReg_no() + "+"
							+ organization_Entity.getReg_no() + "||");
				}
				if (!us1.getPan_card().equals(organization_Entity.getPan_card())) {
					stringBuilder = stringBuilder.append("Business Registration Card+" + us1.getPan_card() + "+"
							+ organization_Entity.getPan_card() + "||");
				}
				if (!us1.getTan_card().equals(organization_Entity.getTan_card())) {
					stringBuilder = stringBuilder.append(
							"VAT Reference+" + us1.getTan_card() + "+" + organization_Entity.getTan_card() + "||");
				}
				if (!us1.getNo_of_emp().equals(organization_Entity.getNo_of_emp())) {
					stringBuilder = stringBuilder.append(
							"No of Employees+" + us1.getNo_of_emp() + "+" + organization_Entity.getNo_of_emp() + "||");
				}
				if (!us1.getAs_on().equals(organization_Entity.getAs_on())) {
					stringBuilder = stringBuilder
							.append("As On+" + us1.getAs_on() + "+" + organization_Entity.getAs_on() + "||");
				}
				if (!us1.getOrg_type().equals(organization_Entity.getOrg_type())) {
					stringBuilder = stringBuilder.append("Registered Office Address 1+" + us1.getOrg_type() + "+"
							+ organization_Entity.getOrg_type() + "||");
				}
				if (!us1.getReg_addr_1().equals(organization_Entity.getReg_addr_1())) {
					stringBuilder = stringBuilder.append("Registered Office Address 1+" + us1.getReg_addr_1() + "+"
							+ organization_Entity.getReg_addr_1() + "||");
				}
				if (!us1.getCorp_addr_1().equals(organization_Entity.getCorp_addr_1())) {
					stringBuilder = stringBuilder.append("Corporate Office Address 1+" + us1.getCorp_addr_1() + "+"
							+ organization_Entity.getCorp_addr_1() + "||");
				}
				if (!us1.getCor_addr_2().equals(organization_Entity.getCor_addr_2())) {
					stringBuilder = stringBuilder.append("Corporate Office Address 2+" + us1.getOrg_type() + "+"
							+ organization_Entity.getOrg_type() + "||");
				}
				if (!us1.getWeb_site().equals(organization_Entity.getWeb_site())) {
					stringBuilder = stringBuilder
							.append("Website+" + us1.getWeb_site() + "+" + organization_Entity.getWeb_site() + "||");
				}

				if (!us1.getEmail().equalsIgnoreCase(organization_Entity.getEmail())) {
					stringBuilder = stringBuilder
							.append("Email+" + us1.getEmail() + "+" + organization_Entity.getEmail() + "||");
					System.out.println(stringBuilder + us1.getEmail());
				}
				audit.setAudit_date(new Date());
				audit.setEntry_time(new Date());
				audit.setEntry_user(userid);
				audit.setFunc_code("HEAD OFFIC MODIFICATION");
				audit.setRemarks(userid + " : User Modified Successfully");
				audit.setAudit_table("BGLS_ORG_MASTER");
				audit.setAudit_screen("HEAD OFFICE - MODIFY");
				Optional<UserProfile> up1 = userProfileRep.findById(userid);
				UserProfile user = up1.get();
				audit.setEvent_name(user.getUsername());
				audit.setEvent_id(user.getUserid());
				// audit.setEvent_name(up.getUsername());
				String modiDetails = stringBuilder.toString();
				System.out.println(modiDetails + "modiDetailsmodiDetails");
				audit.setModi_details(modiDetails);
				audit.setAudit_ref_no(auditID.toString());
				UserProfile auth_user = userProfileRep.getRole(userid);
				String auth_user_val = auth_user.getAuth_user();
				Date auth_user_date = auth_user.getAuth_time();
				audit.setAuth_user(auth_user_val);
				audit.setAuth_time(auth_user_date);
				bglsBusinessTable_Rep.save(audit);
				organization_Repo.save(organization_Entity);
				msg = "User Modified Successfully";

			}

		}

		/*
		 * up.setEntity_flg("N"); up.setDel_flg("N"); organization_Repo.save(up);
		 */
		// for audit

		return msg;

	}

	/* Thanveer */
	@RequestMapping(value = "tab2modify", method = RequestMethod.POST)
	@ResponseBody
	public String tab2modify(Model md, HttpServletRequest rq,
			@ModelAttribute Organization_Branch_Entity organization_Branch_Entity) {

		/*
		 * Organization_Branch_Entity up = organization_Branch_Entity;
		 * up.setEntity_flg("N"); up.setDel_flg("N");
		 * 
		 * organization_Branch_Rep.save(up);
		 */

		Optional<Organization_Branch_Entity> up = organization_Branch_Rep
				.findById(organization_Branch_Entity.getBranch_name());
		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		String userid = (String) rq.getSession().getAttribute("USERID");
		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();

		// organization_Branch_Entity up = organization_Branch_Entity;
		String msg = "";
		if (up.isPresent()) {
			Organization_Branch_Entity us1 = up.get();
			if ((us1.getBranch_code().equals(organization_Branch_Entity.getBranch_code())
					&& us1.getDesignation().equals(organization_Branch_Entity.getDesignation())
					&& us1.getSwift_code().equals(organization_Branch_Entity.getSwift_code())
					&& us1.getPic_no().equals(organization_Branch_Entity.getPic_no())
					&& us1.getLand_line().equals(organization_Branch_Entity.getLand_line())
					&& us1.getFax().equals(organization_Branch_Entity.getFax())
					&& us1.getMobile().equals(organization_Branch_Entity.getMobile())
					&& us1.getCont_person().equals(organization_Branch_Entity.getCont_person())
					&& us1.getWebsite().equals(organization_Branch_Entity.getWebsite())
					&& us1.getMail_id().equals(organization_Branch_Entity.getMail_id())
					&& us1.getAdd_1().equals(organization_Branch_Entity.getAdd_1())
					&& us1.getAdd_2().equals(organization_Branch_Entity.getAdd_2())
					&& us1.getCity().equals(organization_Branch_Entity.getCity())
					&& us1.getState().equals(organization_Branch_Entity.getState())
					&& us1.getCountry().equals(organization_Branch_Entity.getCountry())
					&& us1.getZip_code().equals(organization_Branch_Entity.getZip_code()))) {
				msg = "No any Modification done";
			} else {

				organization_Branch_Entity.setModify_flg("Y");
				organization_Branch_Entity.setDel_flg("N");
				organization_Branch_Entity.setModify_time(new Date());
				organization_Branch_Entity.setModify_user(userid);

				// for audit
				StringBuilder stringBuilder = new StringBuilder();

				if ((us1.getBranch_code().equals(organization_Branch_Entity.getBranch_code())
						&& us1.getBranch_head().equals(organization_Branch_Entity.getBranch_head())
						&& us1.getDesignation().equals(organization_Branch_Entity.getDesignation())
						&& us1.getSwift_code().equals(organization_Branch_Entity.getSwift_code())
						&& us1.getPic_no().equals(organization_Branch_Entity.getPic_no())
						&& us1.getLand_line().equals(organization_Branch_Entity.getLand_line())
						&& us1.getFax().equals(organization_Branch_Entity.getFax())
						&& us1.getMobile().equals(organization_Branch_Entity.getMobile())
						&& us1.getCont_person().equals(organization_Branch_Entity.getCont_person())
						&& us1.getWebsite().equals(organization_Branch_Entity.getWebsite())
						&& us1.getMail_id().equals(organization_Branch_Entity.getMail_id())
						&& us1.getAdd_1().equals(organization_Branch_Entity.getAdd_1())
						&& us1.getAdd_2().equals(organization_Branch_Entity.getAdd_2())
						&& us1.getCity().equals(organization_Branch_Entity.getCity())
						&& us1.getState().equals(organization_Branch_Entity.getState())
						&& us1.getCountry().equals(organization_Branch_Entity.getCountry())
						&& us1.getZip_code().equals(organization_Branch_Entity.getZip_code()))) {

				}
				if (!us1.getBranch_code().equals(organization_Branch_Entity.getBranch_code())) {
					stringBuilder = stringBuilder.append("Branch Code+" + us1.getBranch_code() + "+"
							+ organization_Branch_Entity.getBranch_code() + "||");
				}
				if (!us1.getBranch_head().equals(organization_Branch_Entity.getBranch_head())) {
					stringBuilder = stringBuilder.append("Branch Head+" + us1.getBranch_head() + "+"
							+ organization_Branch_Entity.getBranch_head() + "||");
				}
				if (!us1.getDesignation().equals(organization_Branch_Entity.getDesignation())) {
					stringBuilder = stringBuilder.append("Designation+" + us1.getDesignation() + "+"
							+ organization_Branch_Entity.getDesignation() + "||");
				}
				if (!us1.getSwift_code().equals(organization_Branch_Entity.getSwift_code())) {
					stringBuilder = stringBuilder.append("Swift Code+" + us1.getSwift_code() + "+"
							+ organization_Branch_Entity.getSwift_code() + "||");
				}
				if (!us1.getPic_no().equals(organization_Branch_Entity.getPic_no())) {
					stringBuilder = stringBuilder
							.append("Pic No+" + us1.getPic_no() + "+" + organization_Branch_Entity.getPic_no() + "||");
				}
				if (!us1.getLand_line().equals(organization_Branch_Entity.getLand_line())) {
					stringBuilder = stringBuilder.append(
							"Land Line+" + us1.getLand_line() + "+" + organization_Branch_Entity.getLand_line() + "||");
				}
				if (!us1.getFax().equals(organization_Branch_Entity.getFax())) {
					stringBuilder = stringBuilder
							.append("Fax+" + us1.getFax() + "+" + organization_Branch_Entity.getFax() + "||");
				}
				if (!us1.getMobile().equals(organization_Branch_Entity.getMobile())) {
					stringBuilder = stringBuilder
							.append("Mobile+" + us1.getMobile() + "+" + organization_Branch_Entity.getMobile() + "||");
				}
				if (!us1.getCont_person().equals(organization_Branch_Entity.getCont_person())) {
					stringBuilder = stringBuilder.append("Contact Person+" + us1.getCont_person() + "+"
							+ organization_Branch_Entity.getCont_person() + "||");
				}
				if (!us1.getWebsite().equals(organization_Branch_Entity.getWebsite())) {
					stringBuilder = stringBuilder.append(
							"Web Site+" + us1.getWebsite() + "+" + organization_Branch_Entity.getWebsite() + "||");
				}
				if (!us1.getMail_id().equals(organization_Branch_Entity.getMail_id())) {
					stringBuilder = stringBuilder.append(
							"Mail Id+" + us1.getMail_id() + "+" + organization_Branch_Entity.getMail_id() + "||");
				}
				if (!us1.getAdd_1().equals(organization_Branch_Entity.getAdd_1())) {
					stringBuilder = stringBuilder
							.append("Address 1+" + us1.getAdd_1() + "+" + organization_Branch_Entity.getAdd_1() + "||");
				}

				if (!us1.getAdd_2().equalsIgnoreCase(organization_Branch_Entity.getAdd_2())) {
					stringBuilder = stringBuilder
							.append("Address 2+" + us1.getAdd_2() + "+" + organization_Branch_Entity.getAdd_2() + "||");

				}
				if (!us1.getCity().equalsIgnoreCase(organization_Branch_Entity.getCity())) {
					stringBuilder = stringBuilder
							.append("City+" + us1.getCity() + "+" + organization_Branch_Entity.getCity() + "||");

				}
				if (!us1.getCountry().equalsIgnoreCase(organization_Branch_Entity.getCountry())) {
					stringBuilder = stringBuilder
							.append("State+" + us1.getCountry() + "+" + organization_Branch_Entity.getCountry() + "||");
				}
				if (!us1.getState().equalsIgnoreCase(organization_Branch_Entity.getState())) {
					stringBuilder = stringBuilder
							.append("Country+" + us1.getState() + "+" + organization_Branch_Entity.getState() + "||");
				}

				if (!us1.getZip_code().equalsIgnoreCase(organization_Branch_Entity.getZip_code())) {
					stringBuilder = stringBuilder.append(
							"Zip Code+" + us1.getZip_code() + "+" + organization_Branch_Entity.getZip_code() + "||");
				}

				audit.setAudit_date(new Date());
				audit.setEntry_time(new Date());
				audit.setEntry_user(userid);
				audit.setFunc_code("BRANCH MODIFICATION");
				audit.setRemarks(userid + " : Modified Successfully");
				audit.setAudit_table("BGLS_ORG_BRANCH");
				audit.setAudit_screen("BRANCH - MODIFY");
				Optional<UserProfile> up1 = userProfileRep.findById(userid);
				UserProfile user = up1.get();
				audit.setEvent_name(user.getUsername());
				audit.setEvent_id(user.getUserid());
				// audit.setEvent_name(up.getUsername());
				String modiDetails = stringBuilder.toString();

				audit.setModi_details(modiDetails);
				audit.setAudit_ref_no(auditID.toString());
				UserProfile auth_user = userProfileRep.getRole(userid);
				String auth_user_val = auth_user.getAuth_user();
				Date auth_user_date = auth_user.getAuth_time();
				audit.setAuth_user(auth_user_val);
				audit.setAuth_time(auth_user_date);
				bglsBusinessTable_Rep.save(audit);
				organization_Branch_Rep.save(organization_Branch_Entity);
				msg = "User Modified Successfully";

			}

		}
		return "Modified Successfully";

	}

	/* pon prasanth */
	@GetMapping("transactionaccountdetails")
	public Chart_Acc_Entity transactionaccountdetails(@RequestParam(required = false) String acct_num) {
		Chart_Acc_Entity accountvalue = chart_Acc_Rep.getlistpopupvalues(acct_num);
		System.out.println("THE ACCOUNT NUMBER IS" + acct_num);
		return accountvalue;
	}

	/* Praveen */
	@RequestMapping(value = "accessRoleSubmit", method = RequestMethod.POST)
	public String accessRoleSubmit(@RequestBody Access_Role_Entity Access_Role_Entity, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		String userid = (String) rq.getSession().getAttribute("USERID");

		String msg = loginServices.addAccessAndRole(Access_Role_Entity, userid);

		return msg;
	}

	/* Thanveer */
	@RequestMapping(value = "getTypeDescription", method = RequestMethod.GET)
	@ResponseBody
	public String getTypeDescription(Model md, HttpServletRequest rq, @RequestParam(required = false) String refType,
			@ModelAttribute Reference_Code_Entity reference_Code_Entity) {

		List<Object[]> typeDescList = reference_code_Rep.getTypeDesc(refType);
		System.out.println(typeDescList);

		String typeDesc = "";
		if (typeDescList != null && !typeDescList.isEmpty()) {
			Object[] firstRow = typeDescList.get(0);
			if (firstRow.length >= 2) {
				// Assuming the fields you need are at index 0 and 1
				typeDesc = firstRow[0] + " - " + firstRow[1];
			}
		}

		md.addAttribute("typeDesc", typeDesc);
		return typeDesc;

	}

	/* Thanveer */
	@RequestMapping(value = "refAdd", method = RequestMethod.POST)
	@ResponseBody
	public String refAdd(HttpServletRequest rq, @ModelAttribute Reference_Code_Entity reference_Code_Entity) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		reference_Code_Entity.setEntity_flg("N");
		reference_Code_Entity.setModify_flg("N");
		reference_Code_Entity.setDel_flg("N");
		reference_Code_Entity.setEntry_user(userid);
		reference_Code_Entity.setEntry_time(new Date());
		reference_code_Rep.save(reference_Code_Entity);

		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();

		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();

		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());
		audit.setFunc_code("REFERENCE CODE");
		audit.setRemarks("Sucessfully Saved");
		audit.setAudit_table("BGLS_REF_MASTER");
		audit.setAudit_screen("REFERENCE CODE MAINTENANCE - ADD");
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

		bglsBusinessTable_Rep.save(audit);
		return "Sucessfully Saved";
	}

	/* Thanveer */

	@RequestMapping(value = "GeneralLedgerAdd", method = RequestMethod.POST)
	@ResponseBody
	public String GeneralLedgerAdd(@RequestParam("formmode") String formmode,
			@RequestParam(required = false) String glcode,@ModelAttribute GeneralLedgerEntity generalLedgerEntity,
			Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		
		String glsh_code = generalLedgerEntity.getGlsh_code();
		
		System.out.println("the controller glcode is here "+glcode);
		System.out.println("the controller glshcode is here "+glsh_code);
		String msg = adminOperServices.addGeneralLedger(generalLedgerEntity, formmode,glsh_code, glcode, userid);
		return msg;
	}

	/* pon prasanth */
	@RequestMapping(value = "addtransactiondata", method = RequestMethod.POST)
	@ResponseBody
	public String addTransactionDatas(Model md, HttpServletRequest rq,
			@RequestBody List<TRAN_MAIN_TRM_WRK_ENTITY> transactionDetails) {
		List<TRAN_MAIN_TRM_WRK_ENTITY> transactionsToSave = new ArrayList<>();
		String tranid = "";
		Transaction_Partition_Detail_Entity partitionRecord = new Transaction_Partition_Detail_Entity();
		Transaction_Pointing_Table_Entity pointingRecord = new Transaction_Pointing_Table_Entity();
		Transaction_Reversed_Table_Entity reversedRecord = new Transaction_Reversed_Table_Entity();

		for (TRAN_MAIN_TRM_WRK_ENTITY transaction : transactionDetails) {

			tranid = transaction.getTran_id();
			String nextSerialNumber = tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID(); // Fetch the next SRLNO
			transaction.setSrl_no(nextSerialNumber); // Set the serial number manually

			String data1 = transaction.getFlow_code();
			System.out.println("The flow code is "+data1);
			
			String accountNumber = transaction.getAcct_num();
			System.out.println("Account Number : " + accountNumber);
			String partitionFlag = chart_Acc_Rep.getpartitionFlag(accountNumber);
			String pointingDetail = chart_Acc_Rep.getpointingDetail(accountNumber);

			/* partition table update */
			if (partitionFlag != null) {
				if (partitionFlag.equalsIgnoreCase("Y")) {

					partitionRecord.setAcct_name(transaction.getAcct_name());
					partitionRecord.setAcct_num(transaction.getAcct_num());
					partitionRecord.setTran_id(transaction.getTran_id());
					partitionRecord.setPart_tran_id(transaction.getPart_tran_id());
					partitionRecord.setTran_type(transaction.getTran_type());
					partitionRecord.setPart_tran_type(transaction.getPart_tran_type());
					partitionRecord.setAcct_crncy(transaction.getAcct_crncy());
					partitionRecord.setTran_amt(transaction.getTran_amt());
					partitionRecord.setTran_particular(transaction.getTran_particular());
					partitionRecord.setTran_remarks(transaction.getTran_remarks());
					partitionRecord.setTran_date(transaction.getTran_date());
					partitionRecord.setValue_date(transaction.getValue_date());

					partitionRecord.setTran_ref_no(transaction.getTran_ref_no());
					partitionRecord.setAdd_details(transaction.getAdd_details());
					partitionRecord.setPartition_det(transaction.getPartition_det());
					partitionRecord.setPartition_type(transaction.getPartition_type());

					transaction_Partition_Detail_Repo.save(partitionRecord);
				} else {
					System.out.println("partition flag N");
				}

			} else {
				System.out.println("Not a partition account");
			}

			/* pointing table update */

			if (pointingDetail != null) {

				if (pointingDetail.equalsIgnoreCase("C") || pointingDetail.equalsIgnoreCase("D")) {

					String pointingType = pointingDetail.equalsIgnoreCase("C") ? "Credit" : "Debit";

					if (pointingType.equalsIgnoreCase(transaction.getPart_tran_type())) {

						/*
						 * pointingType = credit and part_tran_type=credit or pointingType = debit and
						 * part_tran_type=debit
						 */

						pointingRecord.setOrg_tran_id(transaction.getTran_id());
						pointingRecord.setOrg_part_tran_id(transaction.getPart_tran_id());
						pointingRecord.setOrg_acct_num(transaction.getAcct_num());
						pointingRecord.setOrg_acct_name(transaction.getAcct_name());
						pointingRecord.setOrg_tran_type(transaction.getTran_type());
						pointingRecord.setOrg_part_tran_type(transaction.getPart_tran_type());
						pointingRecord.setOrg_acct_crncy(transaction.getAcct_crncy());
						pointingRecord.setOrg_tran_amt(transaction.getTran_amt());
						pointingRecord.setOrg_tran_particular(transaction.getTran_particular());
						pointingRecord.setOrg_tran_remarks(transaction.getTran_remarks());
						pointingRecord.setOrg_tran_date(transaction.getTran_date());
						pointingRecord.setOrg_value_date(transaction.getValue_date());

						pointingRecord.setOrg_tran_ref_no(transaction.getTran_ref_no());
						pointingRecord.setOrg_add_details(transaction.getAdd_details());
						pointingRecord.setOffset_tran_amt(BigDecimal.ZERO);
						pointingRecord.setBal_outstd_amt(transaction.getTran_amt());

						transaction_Pointing_Table_Repo.save(pointingRecord);

					} else {

						/*
						 * pointingType = credit and part_tran_type=debit or pointingType = debit and
						 * part_tran_type=credit
						 */

					}
				} else {
					System.out.println("POINTING DETAIL NOT MENTIONED ");
				}

			} else {
				System.out.println("Not a pointing account");
			}

			/* reversed table update */
			if (reversedRecord != null) {
				System.out.println("Reversed function Start");

				// Determine the pointing type as "Credit" or "Debit"
				String pointingType = reversedRecord.equalsIgnoreCase("C") ? "Credit" : "Debit";

				// Only proceed if pointingType and part_tran_type do not match
				if (!pointingType.equalsIgnoreCase(transaction.getPart_tran_type())) {
					reversedRecord.setRev_acct_name(transaction.getAcct_name());
					reversedRecord.setRev_acct_num(transaction.getAcct_num());
					reversedRecord.setRev_tran_id(transaction.getTran_id());
					reversedRecord.setRev_part_tran_id(transaction.getPart_tran_id());
					reversedRecord.setRev_tran_type(transaction.getTran_type());
					reversedRecord.setRev_part_tran_type(transaction.getPart_tran_type());
					reversedRecord.setRev_acct_crncy(transaction.getAcct_crncy());
					reversedRecord.setRev_tran_amt(transaction.getTran_amt());
					reversedRecord.setRev_tran_particular(transaction.getTran_particular());
					reversedRecord.setRev_tran_remarks(transaction.getTran_remarks());
					reversedRecord.setRev_tran_date(transaction.getTran_date());
					reversedRecord.setRev_value_date(transaction.getValue_date());
					reversedRecord.setRev_tran_ref_no(transaction.getTran_ref_no());
					reversedRecord.setRev_add_details(transaction.getAdd_details());

					// Save the reversed record
					transaction_Reversed_Table_Repo.save(reversedRecord);
					System.out.println("Reversed record saved successfully.");
				} else {
					System.out.println("The function will not work. Values match.");
				}
			} else {
				System.out.println("Not a Reversed account");
			}

			transactionsToSave.add(transaction);

		}

		tRAN_MAIN_TRM_WRK_REP.saveAll(transactionsToSave);
		return "TRAN ID " + tranid + " Saved Successfully";
	}

	@RequestMapping(value = "addtransactiondatamodiy", method = RequestMethod.POST)
	@ResponseBody
	public String addtransactiondatamodiy(Model md, HttpServletRequest rq,
			@RequestBody List<TRAN_MAIN_TRM_WRK_ENTITY> transactionDetails,
			@RequestParam(required = false) List<String> tran_id, // Accept multiple tran_id values
			@RequestParam(required = false) List<String> part_tran_id) { // Accept multiple part_tran_id values

		System.out.println("addtransactiondatamodiy" + " first step to modify");

		// Check if both lists are not null and have the same size
		if (tran_id != null && part_tran_id != null && tran_id.size() == part_tran_id.size()) {
			List<TRAN_MAIN_TRM_WRK_ENTITY> transactionsToSave = new ArrayList<>();

			for (int i = 0; i < tran_id.size(); i++) {
				String currentTranId = tran_id.get(i);
				String currentPartTranId = part_tran_id.get(i);

				TRAN_MAIN_TRM_WRK_ENTITY existingDevice = tRAN_MAIN_TRM_WRK_REP.getmodifyjournal(currentTranId,
						currentPartTranId);
				String existsrlno = existingDevice.getSrl_no();
				if (existingDevice != null) { // Check if existingDevice is not null
					System.out.println("Processing transaction with tran_id: " + currentTranId + " and part_tran_id: "
							+ currentPartTranId);

					for (TRAN_MAIN_TRM_WRK_ENTITY transaction : transactionDetails) {
						System.out.println("Second step to modify");
						System.out.println("Third step to modify: " + transaction.getFlow_code());
						System.out.println(transaction.getValue_date() + "trandate" + transaction.getTran_date());
						transaction.setSrl_no(existsrlno);
						transaction.setDel_flg("Y"); // Set the delete flag manually
						tRAN_MAIN_TRM_WRK_REP.save(transaction); // Add each transaction to the list
					}

					// Save all transactions after processing
					// tRAN_MAIN_TRM_WRK_REP.saveAll(transactionsToSave);
				} else {
					// Handle the case where existingDevice is null
					System.out.println("No value previously stored for tran_id: " + currentTranId
							+ " and part_tran_id: " + currentPartTranId);
				}
			}
		} else {
			System.out.println("tran_id and part_tran_id lists are not of the same size or are null.");
			return "Error: Transaction IDs and Part Transaction IDs must be the same size and not null.";
		}

		return "Transaction modification completed.";
	}

	/* pon prasanth */
	@Transactional
	@GetMapping("postedTrmRecords")
	public String postedTrmRecords(Model md, HttpServletRequest rq, @RequestParam(required = false) String acct_num,
			@RequestParam(required = false) String tran_id, @RequestParam(required = false) String part_tran_id,
			HttpServletRequest request) {

		System.out.println("Tran id : " + tran_id);

		/* list of tranId values */
		List<TRAN_MAIN_TRM_WRK_ENTITY> values = tRAN_MAIN_TRM_WRK_REP.findByjournalvalues(tran_id);

		List<String> partTranTypes = new ArrayList<>();
		List<BigDecimal> partTranid = new ArrayList<>();

		for (TRAN_MAIN_TRM_WRK_ENTITY entity : values) {
			partTranTypes.add(entity.getPart_tran_type());
			partTranid.add(entity.getPart_tran_id());

		}

		if (partTranid.size() > 1) {

			boolean hasDebit = partTranTypes.contains("Debit");
			boolean hasCredit = partTranTypes.contains("Credit");

			if (hasDebit && hasCredit) {

				String user = (String) rq.getSession().getAttribute("USERID");
				Date con_date = (Date) rq.getSession().getAttribute("TRANDATE");

				List<TRAN_MAIN_TRM_WRK_ENTITY> savedatas = new ArrayList<>();

				for (TRAN_MAIN_TRM_WRK_ENTITY entity : values) {
					entity.setPost_user(user);
					entity.setPost_time(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
					entity.setDel_flg("N");
					entity.setTran_status("POSTED");
					savedatas.add(entity);

					if (entity.getFlow_code().equalsIgnoreCase("DISBT")) {
						String accountNumber = entity.getAcct_num();
						String acountName = lease_Loan_Master_Repo.accountName(accountNumber);
						if (Objects.nonNull(acountName) || acountName != null) {
							Lease_Loan_Master_Entity leaseRecord = lease_Loan_Master_Repo.findByref_no(accountNumber);
							leaseRecord.setDisbursement(entity.getTran_amt());
							lease_Loan_Master_Repo.save(leaseRecord);
						} else {
							System.out.println("Not a loan account");
						}

					} else {
						System.out.println("Not a disbursement");
					}
				}

				String auditID = sequence.generateRequestUUId();
				String user1 = (String) request.getSession().getAttribute("USERID");
				String username = (String) request.getSession().getAttribute("USERNAME");

				BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
				audit.setAudit_date(new Date());
				audit.setEntry_time(new Date());
				audit.setEntry_user(user1);
				audit.setFunc_code("VERIFIED");
				audit.setAudit_table("BGLSBUSINESSTABLE");
				audit.setAudit_screen("VERIFIED");
				audit.setEvent_id(user1);
				audit.setEvent_name(username);
				audit.setModi_details("Verified Successfully");

				UserProfile values1 = userProfileRep.getRole(user1);
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
				audit.setAudit_ref_no(auditID);

				for (TRAN_MAIN_TRM_WRK_ENTITY entity : values) {

					if (entity.getPart_tran_type().equals("Credit")) {

						System.out.println("Credit Part");

						/* Account details get by account number in COA table */

						Chart_Acc_Entity originalAccount = chart_Acc_Rep.getaedit(entity.getAcct_num());

						BigDecimal balance = originalAccount.getAcct_bal();
						BigDecimal creditBalance = Objects.nonNull(originalAccount.getCr_amt())
								? originalAccount.getCr_amt()
								: BigDecimal.ZERO;
						BigDecimal debitBalance = Objects.nonNull(originalAccount.getDr_amt())
								? originalAccount.getDr_amt()
								: BigDecimal.ZERO;

						BigDecimal creditVal = tRAN_MAIN_TRM_WRK_REP.getcredit(entity.getTran_id(),
								entity.getPart_tran_id());

						System.out.println("Account Balance : " + balance);
						System.out.println("Cr_Amt : " + creditBalance);
						System.out.println("Dr_amt : " + debitBalance);
						System.out.println("Credited Amount : " + creditVal);

						// Add credit amount to the account balance
						BigDecimal newBalance = balance.add(creditVal);

						// Add credited amount to the cr_amt
						creditBalance = creditBalance.add(creditVal);
						debitBalance.add(BigDecimal.ZERO);

						System.out.println("Updated Account Balance : " + newBalance);
						System.out.println("Updated Cr_Amt  : " + creditBalance);
						System.out.println("Updated Dr_Amt : " + debitBalance);

						// Update the account with the new balances
						originalAccount.setAcct_bal(newBalance);
						originalAccount.setCr_amt(creditBalance);
						originalAccount.setDr_amt(debitBalance);
						originalAccount.setModify_time(con_date);
						originalAccount.setModify_user(user);

						chart_Acc_Rep.save(originalAccount);

					} else {

						System.out.println("Debit Part");

						/* Account details get by account number in COA table */

						Chart_Acc_Entity originalAccount = chart_Acc_Rep.getaedit(entity.getAcct_num());

						BigDecimal balance = originalAccount.getAcct_bal();
						BigDecimal creditBalance = Objects.nonNull(originalAccount.getCr_amt())
								? originalAccount.getCr_amt()
								: BigDecimal.ZERO;
						BigDecimal debitBalance = Objects.nonNull(originalAccount.getDr_amt())
								? originalAccount.getDr_amt()
								: BigDecimal.ZERO;

						BigDecimal debitVal = tRAN_MAIN_TRM_WRK_REP.getdebit(entity.getTran_id(),
								entity.getPart_tran_id());
						System.out.println("Account Balance : " + balance);
						System.out.println("Dr_Amt : " + debitBalance);
						System.out.println("Cr_Amt : " + creditBalance);
						System.out.println("Debited Amount : " + debitVal);

						// Subtract debited amount from the account balance
						BigDecimal newBalance = balance.subtract(debitVal);

						// add debited amount to dr_amt
						debitBalance = debitBalance.add(debitVal);
						creditBalance.add(BigDecimal.ZERO);

						System.out.println("Updated Account Balance: " + newBalance);
						System.out.println("Updated Dr_Amt : " + debitBalance);
						System.out.println("Updated Cr_Amt : " + creditBalance);

						// Update the account with the new balances
						originalAccount.setAcct_bal(newBalance);
						originalAccount.setDr_amt(debitBalance);
						originalAccount.setCr_amt(creditBalance);
						originalAccount.setModify_time(con_date);
						originalAccount.setModify_user(user);

						chart_Acc_Rep.save(originalAccount);
					}
				}

				bGLSBusinessTable_Rep.save(audit);
				tRAN_MAIN_TRM_WRK_REP.saveAll(savedatas);
			} else {
				return "Error: Please select at least one credit and one debit transaction.";
			}
		}

		return "Posted Successfully";
	}

	/* pon prasanth */
	@GetMapping("transactionaccountdetailsvalues")
	public TRAN_MAIN_TRM_WRK_ENTITY transactionaccountdetailsvalues(@RequestParam(required = false) String acct_num,
			@RequestParam(required = false) String tran_id, @RequestParam(required = false) String part_tran_id) {
		TRAN_MAIN_TRM_WRK_ENTITY accountvalue = tRAN_MAIN_TRM_WRK_REP.getValuepopvalues(tran_id, acct_num,
				part_tran_id);
		return accountvalue;
	}

	@GetMapping("calculateRepayment")
	public List<RepaymentScheduleEntity> calculateRepayment(@RequestParam(defaultValue = "0") int inst_id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inst_start_dt, @RequestParam String inst_freq,
			@RequestParam(defaultValue = "0") int no_of_inst, @RequestParam(defaultValue = "0") double inst_amount,
			@RequestParam String inst_amt_spec, @RequestParam(defaultValue = "0") double principalAmount,
			@RequestParam(defaultValue = "0") double inst_pct, @RequestParam String maturity_flg,
			@RequestParam String interest_frequency) throws ParseException {

		System.out.println(principalAmount + " " + inst_amt_spec + " " + inst_freq + " " + no_of_inst + " "
				+ inst_start_dt + " " + inst_pct + " " + inst_amount + " " + inst_id + " " + maturity_flg);
		if (maturity_flg.equals("Y")) {
			return repaymentScheduleServices.calculateRepaymentScheduleAtMaturity(principalAmount, inst_amt_spec,
					interest_frequency, no_of_inst, inst_start_dt, inst_pct, inst_amount, inst_id);
		} else {
			return repaymentScheduleServices.calculateRepaymentSchedule(principalAmount, inst_amt_spec, inst_freq,
					no_of_inst, inst_start_dt, inst_pct, inst_amount, inst_id);
		}
	}

	/* pon prasanth */
	@GetMapping("datepickervalueaudit")
	public List<BGLSAuditTable> datepickervalueaudit(@RequestParam(required = false) Date audit_date) {
		List<BGLSAuditTable> accountvalue = bGLSAuditTable_Rep.getauditListLocalvalues(audit_date);
		System.out.println("THE ACCOUNT NUMBER IS" + audit_date);
		return accountvalue;
	}

	/* Thanveer */
	/*
	 * @RequestMapping(value = "getBranchName", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String getBranchName(Model md, HttpServletRequest
	 * rq, @RequestParam(required = false) String branchId) {
	 * 
	 * String branch = employee_Profile_Rep.getBranchName(branchId);
	 * System.out.println(branch); md.addAttribute("branchName", branch); return
	 * branch;
	 * 
	 * }
	 */

	/* Thanveer */
	@RequestMapping(value = "getBranchName", method = RequestMethod.GET)
	@ResponseBody
	public String getBranchName(Model md, HttpServletRequest rq, @RequestParam(required = false) String branchId) {

		String branch = bGLSAuditTable_Rep.getBranchName(branchId);
		System.out.println(branch);
		md.addAttribute("branchName", branch);
		return branch;

	}

	/* THANVEER */
	@RequestMapping(value = "depositAdd", method = RequestMethod.POST)
	@ResponseBody
	public String depositAdd(HttpServletRequest rq, Model md, @ModelAttribute DepositEntity depositEntity,
			@ModelAttribute Td_defn_table td_defn_table) {

		String user = (String) rq.getSession().getAttribute("USERID");
		List<String> existingdata = depositRep.getexistingData();
		if (existingdata.contains(depositEntity.getDepo_actno())) {
			return "Account Num Already Exist";
		}
		String msg = depositServices.deposit(td_defn_table, depositEntity);

		return msg;
	}

	/* THANVEER */
	@RequestMapping(value = "depositAddCust", method = RequestMethod.POST)
	@ResponseBody
	public String depositAddCust(HttpServletRequest rq, Model md, @RequestBody DepositEntity depositEntity) {
		Td_defn_table td_defn_table = new Td_defn_table();
		String user = (String) rq.getSession().getAttribute("USERID");
		List<String> existingdata = depositRep.getexistingData();
		if (existingdata.contains(depositEntity.getDepo_actno())) {
			return "Account Num Already Exist";
		}
		String msg = depositServices.deposit(td_defn_table, depositEntity);

		return msg;
	}

	/* THANVEER */
	@RequestMapping(value = "/depositVerify", method = RequestMethod.POST)
	@ResponseBody
	public String depositVerify(HttpServletRequest rq, Model md, @ModelAttribute DepositEntity depositEntity,
			@ModelAttribute Td_defn_table td_dfn_table, @RequestParam(required = false) String actno) {
		System.out.println(depositEntity);
		System.out.println("hello");

		DepositEntity up = depositRep.getCustdataact(actno);
		System.out.println("up" + up.getDepo_actno());
		depositEntity.setDepo_actno(actno);
		depositEntity.setEntity_flg("Y");
		depositEntity.setModify_flg("N");
		depositEntity.setDel_flg("N");

		depositRep.save(depositEntity);

		return "Verified Successfully";
	}

	/* THANVEER */
	@RequestMapping(value = "/verifyDeposit", method = RequestMethod.POST)

	public String verifyDeposit(@RequestParam(required = false) String accountNo) {

		DepositEntity up = depositRep.getCustdataact(accountNo);
		System.out.println("up" + up.getDepo_actno());

		up.setEntity_flg("Y");
		up.setModify_flg("N");
		up.setDel_flg("N");

		depositRep.save(up);

		return "Verified Successfully";
	}

	/* THANVEER */
	@RequestMapping(value = "/depositModify", method = RequestMethod.POST)
	@ResponseBody
	public String depositModify(HttpServletRequest rq, Model md, @ModelAttribute DepositEntity depositEntity,
			@ModelAttribute Td_defn_table td_defn_table) {

		String user = (String) rq.getSession().getAttribute("USERID");
		System.out.println("save");
		String msg = depositServices.deposit(td_defn_table, depositEntity);
		return msg;
	}

	/* Thanveer */
	@RequestMapping(value = "getCustId", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getCustId(Model md, HttpServletRequest rq, @RequestParam(required = false) String custId) {
		System.out.println(custId);
		Object[] cust = bACP_CUS_PROFILE_REPO.getCustList(custId);
		List<Object> custList = Arrays.asList(cust);

		// Object[] cust = bACP_CUS_PROFILE_REPO.getCustList(custId);

		if (cust != null && cust.length > 0) {
			for (Object cust1 : cust) {
				// Assuming cust1 is an Object[] (array), then access the 8th element (index 7)
				if (cust1 instanceof Object[]) {
					Object[] custArray = (Object[]) cust1; // Cast to Object[] to access the 8th element
					if (custArray.length > 6 && "INDIVIDUAL".equals(custArray[7])) {
						System.out.println("CIF_ID is null, calling getCustList1");
						cust = bACP_CUS_PROFILE_REPO.getCustList(custId); // Re-fetch the data
						break; // Break the loop if condition is met
					}
				}
			}
		} else {
			System.out.println("it is in else");
			cust = bACP_CUS_PROFILE_REPO.getCustList1(custId); // Fetch data from an alternative method
		}

		md.addAttribute("cust", cust);
		return cust;

	}

	@GetMapping("getInterestDetails")
	public List<Principle_and_intrest_shedule_Entity> getInterestDetails(
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date creation_Date,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date start_date,
			@RequestParam(defaultValue = "0") double Product_value, @RequestParam String principle_frequency,
			@RequestParam(defaultValue = "0") int int_rate, @RequestParam(defaultValue = "0") int no_of_inst,
			@RequestParam(defaultValue = "0") double int_amt, @RequestParam String interestFrequency)
			throws ParseException {

		LocalDate startDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = startDate.plus(no_of_inst, ChronoUnit.MONTHS);
		Date calculatedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		BigDecimal product = BigDecimal.valueOf(Product_value);
		BigDecimal productAmt = BigDecimal.valueOf(Product_value);
		BigDecimal intRate = BigDecimal.valueOf(int_rate);
		BigDecimal instmentAmount = BigDecimal.valueOf(int_amt);

		List<TestPrincipalCalculation> InterestAmount = interestCalculationServices.calculatePrincialPaymentNotice(
				start_date, calculatedEndDate, product, productAmt, principle_frequency, intRate, no_of_inst,
				instmentAmount, interestFrequency);

		int toltalInstallment = InterestAmount.size();

		List<Principle_and_intrest_shedule_Entity> principleEntity = new ArrayList<>();
		int noOfInstallment = 1;

		if (toltalInstallment > 0) {
			for (TestPrincipalCalculation record : InterestAmount) {
				Principle_and_intrest_shedule_Entity entity = new Principle_and_intrest_shedule_Entity();

				entity.setLoan_amt(productAmt);
				entity.setNo_of_instalment(BigDecimal.valueOf(noOfInstallment));
				entity.setAccount_creation_date(creation_Date);
				entity.setEffective_interest_rate(intRate);
				entity.setTotal_installment(BigDecimal.valueOf(toltalInstallment));
				entity.setFrom_date(record.getInstallmentFromDate());
				entity.setInstallment_date(record.getInstallmentDate());
				// entity.setInstallment_amt(record.getInterestAmount());
				entity.setInterest_amt(record.getInterestAmount());
				entity.setPrincipal_amt(record.getPrincipalAmount());
				entity.setPrincipal_outstanding(record.getPrincipalAmountOutstanding());
				entity.setInstallment_description(record.getInstallmentDescription());
				entity.setCharges_amt(BigDecimal.ZERO);
				if (record.getInstallmentDescription().equalsIgnoreCase("Regular Installment")) {
					entity.setInstallment_amt(record.getInterestAmount().add(record.getPrincipalAmount()));
				} else {
					entity.setInstallment_amt(record.getInterestAmount());
				}

				noOfInstallment++;
				principleEntity.add(entity);
			}

		} else {

		}

		return principleEntity;
	}

	/* THANVEER */
	@GetMapping("getDepositFlow")
	public List<Td_defn_table> td_defn_table(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date deposit_date,
			@RequestParam String deposit_type, @RequestParam String depo_actno, @RequestParam String deposit_period,
			@RequestParam BigDecimal deposit_amt, @RequestParam String rate_of_int, @RequestParam String frequency)
			throws ParseException {

		// Retrieve existing data
		List<String> existingdata = depositRep.getexistingData();

		// Initialize the list to store the Td_defn_table entities
		List<Td_defn_table> newTdDefnTables = new ArrayList<>();

		String depotype = deposit_type;

		if (depotype.equals("Fixed")) {
			BigDecimal flowAmount1 = null;
			BigDecimal flowAmount2 = null;
			BigDecimal depositPeriod = new BigDecimal(deposit_period);
			BigDecimal one = BigDecimal.ONE;
			System.out.println("Deposit Period: " + depositPeriod);

			String Frequency = frequency;
			Date depositDate = deposit_date;
			System.out.println(depositDate);
			BigDecimal flowAmount = deposit_amt;
			System.out.println(flowAmount + " flowAmount");

			BigDecimal rate = new BigDecimal(rate_of_int);
			int scale = 2;
			BigDecimal percentageRate = rate.divide(BigDecimal.valueOf(100), scale, RoundingMode.DOWN);

			if (Frequency.equals("Monthly")) {
				flowAmount1 = flowAmount.multiply(percentageRate)
						.divide(BigDecimal.valueOf(12), scale, RoundingMode.DOWN).setScale(2, RoundingMode.DOWN);
				System.out.println("amt1: " + flowAmount1);
			} else {
				flowAmount2 = flowAmount.multiply(percentageRate).setScale(2, RoundingMode.DOWN);
				System.out.println("amt2: " + flowAmount2);
			}

			Date lastIoDepositDate = null;
			BigDecimal rowCount = depositPeriod.add(new BigDecimal("2"));

			// Loop through each period
			for (BigDecimal i = BigDecimal.ONE; i.compareTo(rowCount) <= 0; i = i.add(BigDecimal.ONE)) {
				Td_defn_table newTdDefnTable = new Td_defn_table();

				newTdDefnTable.setAcid(depo_actno);
				// newTdDefnTable.setFlow_date(depositDate);

				if (i.equals(BigDecimal.ONE)) {
					// First row
					newTdDefnTable.setFlow_code("PI");
					newTdDefnTable.setFlow_amt(flowAmount);
					newTdDefnTable.setClr_bal_amt(flowAmount);
				} else if (i.equals(rowCount)) {
					// Last row

					newTdDefnTable.setFlow_code("PO");

					depositDate = lastIoDepositDate;

					newTdDefnTable.setFlow_amt(flowAmount);
					newTdDefnTable.setClr_bal_amt(BigDecimal.ZERO);
				} else {
					// Middle rows

					newTdDefnTable.setFlow_code("IO");

					newTdDefnTable.setFlow_amt(Frequency.equals("Monthly") ? flowAmount1 : flowAmount2);
					newTdDefnTable.setClr_bal_amt(flowAmount);
					lastIoDepositDate = depositDate;
				}

				newTdDefnTable.setFlow_date(depositDate);

				// Generate serial number and flow ID
				String notifyRef = td_defn_Repo.getTranNo();
				int notifyReference = notifyRef != null ? Integer.parseInt(notifyRef) + 1 : 1;
				newTdDefnTable.setSrl_no(BigDecimal.valueOf(notifyReference));
				newTdDefnTable.setFlow_id(i);

				newTdDefnTables.add(newTdDefnTable);

				// td_defn_Repo.save(newTdDefnTable);

				// Update the depositDate for the next iteration based on frequency
				if (!i.equals(rowCount) && !i.equals(rowCount.add(one))) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(depositDate);
					if (Frequency.equals("Monthly")) {
						calendar.add(Calendar.MONTH, 1);
					} else {
						calendar.add(Calendar.YEAR, 1);
					}
					depositDate = calendar.getTime();
				}
			}
		} else if (depotype.equals("Reinvestment")) {

			System.out.println("deposit");
			BigDecimal previousBalance = BigDecimal.ZERO;
			BigDecimal balance1 = BigDecimal.ZERO;
			BigDecimal balance2 = BigDecimal.ZERO;
			BigDecimal depositPeriod = new BigDecimal(deposit_period);
			BigDecimal one = BigDecimal.ONE;
			System.out.println("Deposit Period: " + depositPeriod);

			String Frequency = frequency;
			Date depositDate = deposit_date;
			System.out.println(depositDate + " maturityDate");

			BigDecimal rate = new BigDecimal(rate_of_int);
			int scale = 2;
			BigDecimal percentageRate = rate.divide(BigDecimal.valueOf(100), scale, RoundingMode.DOWN);

			Date lastIoDepositDate = null;
			BigDecimal rowCount = depositPeriod.add(new BigDecimal("2"));

			// Loop through each period
			for (BigDecimal i = BigDecimal.ONE; i.compareTo(rowCount) <= 0; i = i.add(one)) {
				Td_defn_table newTdDefnTable = new Td_defn_table();

				newTdDefnTable.setAcid(depo_actno);
				newTdDefnTable.setFlow_date(depositDate);

				BigDecimal flowAmount = previousBalance.equals(BigDecimal.ZERO) ? deposit_amt : previousBalance;
				System.out.println("flowAmountfinal" + flowAmount);

				if (i.equals(BigDecimal.ONE)) {
					// First row
					newTdDefnTable.setFlow_code("PI");
					newTdDefnTable.setFlow_amt(flowAmount);
					newTdDefnTable.setClr_bal_amt(flowAmount);
				} else if (i.equals(rowCount)) {
					// Last row

					newTdDefnTable.setFlow_code("TO");

					depositDate = lastIoDepositDate;

					newTdDefnTable.setFlow_amt(flowAmount);
					System.out.println("flowAmountfinal" + flowAmount);
					newTdDefnTable.setClr_bal_amt(BigDecimal.ZERO);
				} else {
					// Middle rows
					newTdDefnTable.setFlow_code("II");
					if (Frequency.equals("Monthly")) {
						BigDecimal flowAmount1 = flowAmount.multiply(percentageRate)
								.divide(BigDecimal.valueOf(12), scale, RoundingMode.DOWN)
								.setScale(2, RoundingMode.DOWN);
						balance1 = flowAmount.add(flowAmount1);

						newTdDefnTable.setFlow_amt(flowAmount1);
						newTdDefnTable.setClr_bal_amt(balance1);
						previousBalance = balance1;

						lastIoDepositDate = depositDate;
					} else {
						BigDecimal flowAmount2 = flowAmount.multiply(percentageRate).setScale(2, RoundingMode.DOWN);
						balance2 = flowAmount.add(flowAmount2);

						newTdDefnTable.setFlow_amt(flowAmount2);
						newTdDefnTable.setClr_bal_amt(balance2);
						previousBalance = balance2;
					}
				}

				newTdDefnTable.setFlow_date(depositDate);

				// Generate serial number and flow ID
				String notifyRef = td_defn_Repo.getTranNo();
				int notifyReference = notifyRef != null ? Integer.parseInt(notifyRef) + 1 : 1;
				newTdDefnTable.setSrl_no(BigDecimal.valueOf(notifyReference));
				newTdDefnTable.setFlow_id(i);

				newTdDefnTables.add(newTdDefnTable);

				// td_defn_Repo.save(newTdDefnTable);

				// Update the depositDate for the next iteration based on frequency
				if (!i.equals(rowCount) && !i.equals(rowCount.add(one))) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(depositDate);
					if (Frequency.equals("Monthly")) {
						calendar.add(Calendar.MONTH, 1);
					} else {
						calendar.add(Calendar.YEAR, 1);
					}
					depositDate = calendar.getTime();
				}
			}
		}
		for (Td_defn_table up : newTdDefnTables) {
			System.out.println(up.getFlow_code());
		}
		return newTdDefnTables;

	}

	@GetMapping("FlowForDateloan")
	public DMD_TABLE FlowForDateloan(@RequestParam(required = false) String actno1,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom)
			throws ParseException {

		System.out.println("dateFrom" + dateFrom);
		// Retrieve existing data
		DMD_TABLE defn = dMD_TABLE_REPO.getflowcode(actno1, dateFrom);
		System.out.println(defn + "defncdscv");
		if (defn == null) {
			defn = dMD_TABLE_REPO.getPreviousFlowCode(actno1, dateFrom);
			System.out.println(defn + "defn2132");
		}

		BigDecimal amt = defn.getFlow_amt();
		Date flowdate = defn.getFlow_date();

		LocalDate localDate = flowdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// Subtract one month from the LocalDate
		LocalDate previousMonthSameDay = localDate.minusMonths(1);

		// Convert the LocalDate back to Date
		Date resultDate = Date.from(previousMonthSameDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

		System.out.println("Previous month, same day: " + resultDate);

		LocalDate startDate = convertToLocalDate(resultDate);
		LocalDate endDate = convertToLocalDate(flowdate);
		long monthsBetween = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println(monthsBetween + "monthsBetween");

		LocalDate startDate1 = convertToLocalDate(resultDate);
		LocalDate endDate1 = convertToLocalDate(dateFrom);
		long monthsBetween1 = ChronoUnit.DAYS.between(startDate1, endDate1);
		System.out.println(monthsBetween1 + "monthsBetween1");

		BigDecimal daysInMonthDecimal = new BigDecimal(monthsBetween);
		BigDecimal singledayamount = amt.divide(daysInMonthDecimal, 2, RoundingMode.HALF_UP);
		System.out.println(singledayamount + "singledayamount");

		BigDecimal betweendaysDecimal = new BigDecimal(monthsBetween1);
		// betweendaysDecimal=betweendaysDecimal.add(BigDecimal.ONE);
		BigDecimal finalamount = singledayamount.multiply(betweendaysDecimal);
		System.out.println(finalamount + "finalamount");

		defn.setTran_amt(finalamount);
		defn.setPart_tran_id(betweendaysDecimal);

		return defn;

	}

	private static LocalDate convertToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@GetMapping("FlowForDate")
	public Td_defn_table FlowForDate(@RequestParam(required = false) String actno2,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom)
			throws ParseException {

		System.out.println("hiiihihihihihihihi");
		System.out.println("dateFrom" + dateFrom);
		// Retrieve existing data
		Td_defn_table defn = td_defn_Repo.getflowcode(actno2, dateFrom);
		System.out.println(defn + "defncdscv");
		if (defn == null) {
			defn = td_defn_Repo.getPreviousFlowCode(actno2, dateFrom);
			System.out.println(defn + "defn2132");
		}
		BigDecimal amt = defn.getFlow_amt();
		Date flowdate = defn.getFlow_date();

		LocalDate localDate = flowdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// Subtract one month from the LocalDate
		LocalDate previousMonthSameDay = localDate.minusMonths(1);

		// Convert the LocalDate back to Date
		Date resultDate = Date.from(previousMonthSameDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

		System.out.println("Previous month, same day: " + resultDate);

		LocalDate startDate = convertToLocalDate(resultDate);
		LocalDate endDate = convertToLocalDate(flowdate);
		long monthsBetween = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println(monthsBetween + "monthsBetween");

		LocalDate startDate1 = convertToLocalDate(resultDate);
		LocalDate endDate1 = convertToLocalDate(dateFrom);
		long monthsBetween1 = ChronoUnit.DAYS.between(startDate1, endDate1);
		System.out.println(monthsBetween1 + "monthsBetween1");

		BigDecimal daysInMonthDecimal = new BigDecimal(monthsBetween);
		BigDecimal singledayamount = amt.divide(daysInMonthDecimal, 2, RoundingMode.HALF_UP);
		System.out.println(singledayamount + "singledayamount");

		BigDecimal betweendaysDecimal = new BigDecimal(monthsBetween1);
		// betweendaysDecimal=betweendaysDecimal.add(BigDecimal.ONE);
		BigDecimal finalamount = singledayamount.multiply(betweendaysDecimal);
		System.out.println(finalamount + "finalamount");

		defn.setTran_amt(finalamount);
		defn.setResidual_bal(betweendaysDecimal);

		return defn;

	}

	@PostMapping("addLeaseAccount")
	@Transactional
	public String addLeaseAccount(HttpServletRequest req, @RequestBody LeaseData leaseData) {
		String userID = (String) req.getSession().getAttribute("USERID");
		String response = leaseLoanService.addLeaseLoan(leaseData, userID);
		return response;
	}

	@GetMapping("getInterestDetailsView")
	public List<Principle_and_intrest_shedule_Entity> getInterestDetailsView(@RequestParam String accountNo)
			throws ParseException {

		Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNo);
		NoticeDetailsPayment0Entity paymentDetails = noticeDetailsPayment0Rep.getPaymentDetails(accountNo);

		BigDecimal product = loandetails.getLoan_sanctioned();
		BigDecimal productAmt = loandetails.getLoan_sanctioned();
		BigDecimal intRate = loandetails.getEffective_interest_rate();
		Date creation_Date = loandetails.getDate_of_loan();

		int no_of_inst = Integer.valueOf(paymentDetails.getNo_of_inst());
		Date start_date = paymentDetails.getInst_start_dt();

		LocalDate startDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = startDate.plus(no_of_inst, ChronoUnit.MONTHS);
		Date calculatedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		BigDecimal instmentAmount = paymentDetails.getInst_amount();
		String principle_frequency = paymentDetails.getInst_freq();
		String interestFrequency = paymentDetails.getInterest_frequency();

		List<TestPrincipalCalculation> InterestAmount = interestCalculationServices.calculatePrincialPaymentNotice(
				start_date, calculatedEndDate, product, productAmt, principle_frequency, intRate, no_of_inst,
				instmentAmount, interestFrequency);

		int toltalInstallment = InterestAmount.size();

		List<Principle_and_intrest_shedule_Entity> principleEntity = new ArrayList<>();
		int noOfInstallment = 1;

		if (toltalInstallment > 0) {
			for (TestPrincipalCalculation record : InterestAmount) {
				Principle_and_intrest_shedule_Entity entity = new Principle_and_intrest_shedule_Entity();

				entity.setLoan_amt(productAmt);
				entity.setNo_of_instalment(BigDecimal.valueOf(noOfInstallment));
				entity.setAccount_creation_date(creation_Date);
				entity.setEffective_interest_rate(intRate);
				entity.setTotal_installment(BigDecimal.valueOf(toltalInstallment));
				entity.setFrom_date(record.getInstallmentFromDate());
				entity.setInstallment_date(record.getInstallmentDate());
				// entity.setInstallment_amt(record.getInterestAmount());
				entity.setInterest_amt(record.getInterestAmount());
				entity.setPrincipal_amt(record.getPrincipalAmount());
				entity.setPrincipal_outstanding(record.getPrincipalAmountOutstanding());
				entity.setInstallment_description(record.getInstallmentDescription());
				entity.setCharges_amt(BigDecimal.ZERO);
				if (record.getInstallmentDescription().equalsIgnoreCase("Regular Installment")) {
					entity.setInstallment_amt(record.getInterestAmount().add(record.getPrincipalAmount()));
				} else {
					entity.setInstallment_amt(record.getInterestAmount());
				}

				noOfInstallment++;
				principleEntity.add(entity);
			}

		} else {

		}

		return principleEntity;
	}

	@GetMapping("getdemandflow")
	public List<DMD_TABLE> getdemandflow(@RequestParam String accountNo) throws ParseException {

		Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNo);
		NoticeDetailsPayment0Entity paymentDetails = noticeDetailsPayment0Rep.getPaymentDetails(accountNo);

		BigDecimal product = loandetails.getLoan_sanctioned();
		BigDecimal productAmt = loandetails.getLoan_sanctioned();
		BigDecimal intRate = loandetails.getEffective_interest_rate();
		Date creation_Date = loandetails.getDate_of_loan();

		int no_of_inst = Integer.valueOf(paymentDetails.getNo_of_inst());
		Date start_date = paymentDetails.getInst_start_dt();

		LocalDate startDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = startDate.plus(no_of_inst, ChronoUnit.MONTHS);
		Date calculatedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		BigDecimal instmentAmount = paymentDetails.getInst_amount();
		String principle_frequency = paymentDetails.getInst_freq();
		String interestFrequency = paymentDetails.getInterest_frequency();

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

				entity.setFlow_id(BigDecimal.valueOf(noOfInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());

				entity.setFlow_amt(record.getInterestAmount().add(record.getPrincipalAmount()));
				entity.setFlow_code("RIDEM");

				noOfInstallment++;
				principleAndInterest.add(entity);
			}

			/*
			 * for (TestPrincipalCalculation record : InterestAmount) { DMD_TABLE entity =
			 * new DMD_TABLE();
			 * 
			 * entity.setFlow_id(BigDecimal.valueOf(noOfprincipalInstallment));
			 * 
			 * entity.setFlow_frq(record.getInstallmentFrequency());
			 * entity.setFlow_date(record.getInstallmentDate());
			 * 
			 * entity.setFlow_amt(record.getPrincipalAmount());
			 * entity.setFlow_code("PRDEM");
			 * 
			 * noOfprincipalInstallment++; principleAndInterest.add(entity); }
			 */
		} else {

		}

		// principleAndInterest.sort(Comparator.comparing(DMD_TABLE::getFlow_id));

		return principleAndInterest;
	}

	@PostMapping("verifyLeaseLoan")
	@Transactional
	public String verifyLeaseLoan(HttpServletRequest req, @RequestParam String accountNo) {
		String userID = (String) req.getSession().getAttribute("USERID");
		String response = leaseLoanService.verifyleaseloan(accountNo, userID);
		return response;
	}

	/* pon prasanth */
	@GetMapping("transactionaccountdetailsvaluesed")
	public Td_defn_table transactionaccountdetailsvaluesed(@RequestParam(required = false) String acid) {
		Td_defn_table accountvalue = td_defn_Repo.getactListval(acid);
		System.out.println("THE ACCOUNT NUMBER IS" + acid);
		return accountvalue;
	}

	/* pon prasanth */
	@GetMapping("transactionaccountdetailsvaluesed1")
	public Lease_Loan_Master_Entity transactionaccountdetailsvaluesed1(@RequestParam(required = false) String acid) {
		Lease_Loan_Master_Entity accountvalue = lease_Loan_Master_Repo.findByref_no(acid);
		System.out.println("THE ACCOUNT NUMBER IS" + acid);
		return accountvalue;
	}

	/* pon prasanth */
	@GetMapping("transactionaccountdetailsdepositedebit")
	public DepositEntity transactionaccountdetailsdepositedebit(@RequestParam(required = false) String DEPO_ACTNO) {
		DepositEntity accountvalue = depositRep.getCustdataact(DEPO_ACTNO);
		System.out.println("THE debit account ACCOUNT NUMBER IS" + DEPO_ACTNO);
		return accountvalue;
	}

	/* pon prasanth */
	@GetMapping("transactionaccountdetailsvaluesdep")
	public TRAN_MAIN_TRM_WRK_ENTITY transactionaccountdetailsvaluesdep(
			@RequestParam(required = false) String acct_num) {
		TRAN_MAIN_TRM_WRK_ENTITY accountvalue = tRAN_MAIN_TRM_WRK_REP.gettranpopvaluesdata(acct_num);
		System.out.println("the Entered Account Num Is  " + acct_num);
		return accountvalue;
	}

	/* pon prasanth */
	@GetMapping("demandloanvalues")
	public DMD_TABLE demandloanvalues(@RequestParam(required = false) String acct_num) {
		DMD_TABLE accountvalue = dmdRepo.gettranpopvalues(acct_num);
		System.out.println("the Entered Account Num Is  " + acct_num);
		return accountvalue;
	}

	/* praveen */
	@GetMapping("transactionValues")
	public TRAN_MAIN_TRM_WRK_ENTITY transactionValues(@RequestParam(required = false) String tran_id,
			@RequestParam(required = false) String part_tran_id) {
		TRAN_MAIN_TRM_WRK_ENTITY accountvalue = tRAN_MAIN_TRM_WRK_REP.getValuepop(tran_id, part_tran_id);
		return accountvalue;
	}

	@GetMapping("validateAccountStatus")
	public String validateAccountStatus(Model md, HttpServletRequest rq, @RequestParam(required = false) String tran_id,
			HttpServletRequest request) {

		System.out.println("Tran id : " + tran_id);
		String msg = "";

		BigDecimal cr_amt = BigDecimal.ZERO;
		BigDecimal dr_amt = BigDecimal.ZERO;

		/* list of tranId values */
		List<TRAN_MAIN_TRM_WRK_ENTITY> values = tRAN_MAIN_TRM_WRK_REP.findByjournalvalues(tran_id);

		for (TRAN_MAIN_TRM_WRK_ENTITY entity : values) {
			if (entity.getPart_tran_type().equals("Credit")) {
				cr_amt = cr_amt.add(entity.getTran_amt());
			} else {
				dr_amt = dr_amt.add(entity.getTran_amt());
			}
		}

		if (cr_amt.compareTo(dr_amt) == 0) {
			msg = "Validation successful: Credit and Debit amounts are equal.";
		} else {
			msg = "Validation failed: Credit and Debit amounts are not equal.";
		}

		return msg;
	}

	private final BigDecimalParser bigDecimalParser = new BigDecimalParser();

	@PostMapping("/uploadxml")
	@ResponseBody
	public String uploadxml(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
		// Initialize BigDecimal variables to store the sum of credit and debit
		// transactions
		BigDecimal creditSum = BigDecimal.ZERO;
		BigDecimal debitSum = BigDecimal.ZERO;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		LocalDate localDate = LocalDate.now();
		String userId = (String) req.getSession().getAttribute("USERID");
		// String user=userId;
		System.out.println(userId + "userId");

		LocalDateTime localDateTime = LocalDateTime.now(); // Get current date and time
		java.util.Date utilDate = java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		Date entryDate = new Date(utilDate.getTime());
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		// List to store transactions temporarily
		List<TRAN_MAIN_TRM_WRK_ENTITY> transactions = new ArrayList<>();

		try (InputStream inputStream = file.getInputStream(); Workbook workbook = new XSSFWorkbook(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet contains data
			int rowCount = 1; // Initialize row count
			String tranId = tranMainRep.gettrmRefUUID1();
			String commonTranId = "TR" + tranId;
			String del_flag = "N";
			// Process each row in the Excel sheet
			for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Starting from row 1, skipping the header
				Row row = sheet.getRow(i);
				TRAN_MAIN_TRM_WRK_ENTITY transaction = new TRAN_MAIN_TRM_WRK_ENTITY();

				// Branch ID logic
				String branchId = getCellValueAsString(row.getCell(0));
				if (branchId != null && branchId.contains(".")) {
					branchId = new BigDecimal(branchId).stripTrailingZeros().toPlainString();
				}
				transaction.setBranch_id(branchId);

				// Other field values
				transaction.setAcid(getValidValue(getCellValueAsString(row.getCell(1))));
				transaction.setCust_id(getValidValue(getCellValueAsString(row.getCell(2))));

				// Transaction ID logic
				transaction.setTran_id(commonTranId);
				transaction.setPart_tran_id(BigDecimal.valueOf(rowCount));
				setCellValue(row, 7, String.valueOf(rowCount));
				rowCount++;

				String acctNum = getCellValueAsString(row.getCell(5));
				transaction.setAcct_num(getValidValue(acctNum));

				transaction.setAcct_name(getValidValue(getCellValueAsString(row.getCell(6))));
				transaction.setTran_type(getValidValue(getCellValueAsString(row.getCell(7))));

				// Process credit/debit type in cell 8
				String partTranType = getValidValue(getCellValueAsString(row.getCell(8)));
				transaction.setPart_tran_type(partTranType);

				transaction.setAcct_crncy(getValidValue(getCellValueAsString(row.getCell(9))));

				BigDecimal tranAmt = bigDecimalParser.getBigDecimalValue(row.getCell(10));
				if (tranAmt != null) {
					tranAmt = tranAmt.stripTrailingZeros(); // Remove trailing zeros
					if (tranAmt.scale() > 2) {
						tranAmt = tranAmt.setScale(2, RoundingMode.HALF_UP); // Set scale to 2
					}
				}

				transaction.setTran_amt(isZero(tranAmt) ? null : tranAmt);

				// Add to either credit or debit sum based on the value in cell 8
				if ("Credit".equalsIgnoreCase(partTranType)) {
					creditSum = creditSum.add(tranAmt != null ? tranAmt : BigDecimal.ZERO);
				} else if ("Debit".equalsIgnoreCase(partTranType)) {
					debitSum = debitSum.add(tranAmt != null ? tranAmt : BigDecimal.ZERO);
				}

				transaction.setTran_particular(getValidValue(getCellValueAsString(row.getCell(11))));
				transaction.setTran_remarks(getValidValue(getCellValueAsString(row.getCell(12))));

				// Set transaction dates
				transaction.setTran_date(date);
				transaction.setValue_date(date);
				transaction.setEntry_user(userId);
				System.out.println(transaction.getEntry_user() + "entry_user");
				transaction.setEntry_time(entryDate);

				parseAndSetDate(row, 27, transaction::setPost_time);
				parseAndSetDate(row, 30, transaction::setInstr_date);
				parseAndSetDate(row, 34, transaction::setModify_time);

				// Set other remaining fields
				transaction.setTran_ref_no(getValidValue(getCellValueAsString(row.getCell(15))));
				transaction.setAdd_details(getValidValue(getCellValueAsString(row.getCell(16))));
				transaction.setPartition_type(getValidValue(getCellValueAsString(row.getCell(17))));
				transaction.setPartition_det(getValidValue(getCellValueAsString(row.getCell(18))));
				transaction.setInstr_num(getValidValue(getCellValueAsString(row.getCell(19))));
				transaction.setRef_crncy(getValidValue(getCellValueAsString(row.getCell(20))));

				BigDecimal refCrncyAmt = bigDecimalParser.getBigDecimalValue(row.getCell(21));
				transaction.setRef_crncy_amt(isZero(refCrncyAmt) ? null : refCrncyAmt.stripTrailingZeros());

				BigDecimal rate = bigDecimalParser.getBigDecimalValue(row.getCell(23));
				transaction.setRate(isZero(rate) ? null : rate.stripTrailingZeros());

				// transaction.setEntry_user(getValidValue(getCellValueAsString(row.getCell(24))));
				transaction.setPost_user(getValidValue(getCellValueAsString(row.getCell(25))));
				transaction.setTran_status(getValidValue(getCellValueAsString(row.getCell(28))));
				transaction.setDel_flg(getValidValue(getCellValueAsString(row.getCell(29))));
				transaction.setTran_code(getValidValue(getCellValueAsString(row.getCell(31))));
				transaction.setTran_rpt_code(getValidValue(getCellValueAsString(row.getCell(32))));
				transaction.setModify_user(getValidValue(getCellValueAsString(row.getCell(33))));
				transaction.setFlow_code(getValidValue(getCellValueAsString(row.getCell(35))));
				transaction.setDel_flg(del_flag);

				// Serial Number
				transaction.setSrl_no(tranMainRep.gettrmRefUUID());

				// Add the transaction to the temporary list
				transactions.add(transaction);
			}

			// Check if the sums of credit and debit are equal after processing all rows
			if (creditSum.compareTo(debitSum) == 0) {
				// Save all transactions to the database if credit and debit sums match
				for (TRAN_MAIN_TRM_WRK_ENTITY transaction : transactions) {
					tranMainRep.save(transaction);
				}
				return "Credit sum: " + creditSum + "\nDebit sum: " + debitSum
						+ "\nTransactions successfully uploaded.";
			} else {
				// Do not save if credit and debit sums do not match
				return "Credit sum: " + creditSum + "\nDebit sum: " + debitSum
						+ "\nError: Debit sum does not equal Credit sum! RE Upload";
			}

		} catch (Exception e) {
			e.printStackTrace(); // Consider using a logging framework
			return "Error: " + e.getMessage();
		}
	}

	// Utility method to return null if the value is invalid
	private String getValidValue(String value) {
		return (value == null || value.trim().isEmpty()) ? null : value;
	}

	// Utility method to check if a BigDecimal value is zero
	private boolean isZero(BigDecimal value) {
		return value != null && value.compareTo(BigDecimal.ZERO) == 0;
	}

	private void setCellValue(Row row, int cellIndex, String tranId) {
		// TODO Auto-generated method stub

	}

	// Utility method to set cell values safely
	private void setCellValue(Row row, int cellIndex, Consumer<String> setter) {
		Cell cell = row.getCell(cellIndex);
		if (cell != null) {
			setter.accept(getCellValueAsString(cell));
		}
	}

	// Utility method to parse date and set the value if successful
	private void parseAndSetDate(Row row, int cellIndex, Consumer<Date> setter) throws java.text.ParseException {
		Cell cell = row.getCell(cellIndex);
		if (cell != null) {
			try {
				String dateStr = getCellValueAsString(cell);
				if (!dateStr.isEmpty()) {
					Date parsedDate = parseDate(dateStr);
					setter.accept(parsedDate);
				}
			} catch (ParseException e) {
				System.err.println("Error parsing date for cell index " + cellIndex + ": " + e.getMessage());
			}
		}
	}

	// Custom method to parse date string into Date object
	public Date parseDate(String dateStr) throws ParseException, java.text.ParseException {
		if (dateStr == null || dateStr.isEmpty()) {
			return null; // Return null for empty strings
		}

		// Handle different date formats here as needed
		SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		Date date = inputFormat.parse(dateStr);
		return date; // Return the parsed date directly
	}

	private String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return "";
		}

		CellType cellType = cell.getCellTypeEnum(); // Use getCellType() for compatibility with POI 3.7

		switch (cellType) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		case BOOLEAN:
			return Boolean.toString(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "Unsupported Cell Type";
		}
	}

	/* SURIYA */
	@GetMapping("AllApproved")
	public List<CustomerRequest> AllApproved(@RequestParam(required = false) String tran_id,
			@RequestParam(required = false) String part_tran_id) {
		return bACP_CUS_PROFILE_REPO.getApprovelist();
	}

	@GetMapping("Approved")
	public List<CustomerRequest> Approved(@RequestParam(required = false) String tran_id,
			@RequestParam(required = false) String part_tran_id) {
		return bACP_CUS_PROFILE_REPO.getapproved();
	}

	@GetMapping("NotApproved")
	public List<CustomerRequest> NotApproved(@RequestParam(required = false) String tran_id,
			@RequestParam(required = false) String part_tran_id) {
		return bACP_CUS_PROFILE_REPO.getnotapproved();
	}

	/* praveen */
	@GetMapping("loanflowDetails")
	public List<DMD_TABLE> loanflowDetails(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate,
			@RequestParam(required = false) String accountNumber) {

		List<DMD_TABLE> loanFlowRecords = dmdRepo.getloanflows(fromDate, todate, accountNumber);
		return loanFlowRecords;
	}

	/* praveen */
	@GetMapping("loanflowDetails1")
	public List<DMD_TABLE> loanflowDetails1(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate,
			@RequestParam(required = false) String accountNumber) {

		List<DMD_TABLE> loanFlowRecords = dmdRepo.getloanflows1(fromDate, todate, accountNumber);
		return loanFlowRecords;
	}

	/* praveen */
	@GetMapping("depositflowDetails")
	public List<Td_defn_table> depositflowDetails(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate,
			@RequestParam(required = false) String accountNumber) {

		List<Td_defn_table> depositFlowRecords = td_defn_Repo.getDepositflows(fromDate, todate, accountNumber);

		return depositFlowRecords;
	}

	/* praveen */
	@GetMapping("depositAcctName")
	public String depositAcctName(@RequestParam(required = false) String acctNo) {

		String accountName = depositRep.getCustName(acctNo);

		return accountName;
	}

	/* thanveer - Booking */
	@GetMapping("transactionBooking")
	public String transactionBooking(@RequestParam(required = false) String flow_code,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date flow_date,
			@RequestParam(required = false) String flow_amount, @RequestParam(required = false) String flow_id,
			@RequestParam(required = false) String account_no, @RequestParam(required = false) String accountName,
			@RequestParam(required = false) String operation, @RequestParam(required = false) String days,
			@RequestParam(required = false) BigDecimal interest, HttpServletRequest rq) {

		String user = (String) rq.getSession().getAttribute("USERID");

		/* tranId sequence */
		String tranId = "TR" + tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID1();

		BigDecimal partTranId1 = BigDecimal.valueOf(1);
		BigDecimal partTranId2 = BigDecimal.valueOf(2);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(flow_date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		Date monthEndDate = calendar.getTime();

		String ActNo = "";

		if (operation.equals("Booking")) {

			System.out.println("Booking Part");

			if (flow_code.equals("PRDEM") || flow_code.equals("INDEM")) {

				String tranParticulars = null;

				Lease_Loan_Work_Entity dep = lease_Loan_Work_Repo.getLeaseAccount(account_no);
				BigDecimal intrate = dep.getEffective_interest_rate();

				/* INTEREST RECEIVABLE account already in CoA */
				String acct_num = "1200001220";

				if (flow_code.equals("INDEM")) {
					tranParticulars = "Booking: " + account_no + " for " + days + " days  @ " + intrate + "%";

				} else {
					tranParticulars = "Booking: " + account_no + " for " + days + " days @ " + intrate + "%";
				}

				Chart_Acc_Entity depositevalue = chart_Acc_Rep.getaedit(acct_num);
				/* TRM table entry set here */
				ActNo = acct_num;
				TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				/* First Transaction - INTEREST RECEIVABLE account debit */
				debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				debitTrm.setTran_id(tranId);
				debitTrm.setPart_tran_id(partTranId1);
				debitTrm.setAcct_num(depositevalue.getAcct_num());
				debitTrm.setAcct_name(depositevalue.getAcct_name());
				debitTrm.setAcct_crncy(depositevalue.getAcct_crncy());
				debitTrm.setTran_type("TRANSFER");
				debitTrm.setPart_tran_type("Debit");
				debitTrm.setTran_amt(interest);
				debitTrm.setTran_particular(tranParticulars);
				debitTrm.setTran_remarks(tranParticulars);
				debitTrm.setTran_date(monthEndDate);
				debitTrm.setValue_date(monthEndDate);
				debitTrm.setFlow_code(flow_code);
				debitTrm.setFlow_date(flow_date);
				debitTrm.setTran_status("ENTERED");
				debitTrm.setEntry_user(user);
				debitTrm.setEntry_time(flow_date);
				debitTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

				/* Second Transaction - office LOAN INTEREST Account credit */
				/* this account already existed in COA */
				String acct_num1 = "4100004110";
				Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num1);

				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(partTranId2);
				creditTrm.setAcct_num(termdeposite.getAcct_num());
				creditTrm.setAcct_name(termdeposite.getAcct_name());
				creditTrm.setTran_type("TRANSFER");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(termdeposite.getAcct_crncy());
				creditTrm.setTran_amt(interest);
				creditTrm.setTran_particular(tranParticulars);
				creditTrm.setTran_remarks(tranParticulars);
				creditTrm.setTran_date(monthEndDate);
				creditTrm.setValue_date(monthEndDate);
				creditTrm.setFlow_code(flow_code);
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

			} else {

				System.out.println("Deposit Account Booking");

				DepositEntity depo = depositRep.getCustdataact(account_no);
				String intrate = depo.getRate_of_int();

				String tranParticulars = null;

				if (flow_code.equals("IO")) {
					tranParticulars = "Booking: " + account_no + " for " + days + " days  @ " + intrate + "%";

				} else {
					tranParticulars = "Booking: " + account_no + " for " + days + " days @ " + intrate + "%";
				}

				/* First Transaction - deposit Interest account debit */
				String acct_num = "6100006110";
				Chart_Acc_Entity depositevalue = chart_Acc_Rep.getaedit(acct_num);
				/* TRM table entry set here */
				ActNo = acct_num;
				TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				/* First Transaction - deposit Interest account debit */
				debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				debitTrm.setTran_id(tranId);
				debitTrm.setPart_tran_id(partTranId1);
				debitTrm.setAcct_num(depositevalue.getAcct_num());
				debitTrm.setAcct_name(depositevalue.getAcct_name());
				debitTrm.setAcct_crncy(depositevalue.getAcct_crncy());
				debitTrm.setTran_type("TRANSFER");
				debitTrm.setPart_tran_type("Debit");
				debitTrm.setTran_amt(interest);
				debitTrm.setTran_particular(tranParticulars);
				debitTrm.setTran_remarks(tranParticulars);
				debitTrm.setTran_date(monthEndDate);
				debitTrm.setValue_date(monthEndDate);
				debitTrm.setFlow_code(flow_code);
				debitTrm.setFlow_date(flow_date);
				debitTrm.setTran_status("ENTERED");
				debitTrm.setEntry_user(user);
				debitTrm.setEntry_time(flow_date);
				debitTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

				/* Second Transaction - Interest payable credit */
				/* this account already existed in COA */
				String acct_num1 = "2200002220";
				Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num1);

				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(partTranId2);
				creditTrm.setAcct_num(termdeposite.getAcct_num());
				creditTrm.setAcct_name(termdeposite.getAcct_name());
				creditTrm.setTran_type("TRANSFER");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(termdeposite.getAcct_crncy());
				creditTrm.setTran_amt(interest);
				creditTrm.setTran_particular(tranParticulars);
				creditTrm.setTran_remarks(tranParticulars);
				creditTrm.setTran_date(monthEndDate);
				creditTrm.setValue_date(monthEndDate);
				creditTrm.setFlow_code(flow_code);
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

			}
		}

		return tranId + "," + ActNo;
	}

	/* praveen - Interest (Application) */
	@GetMapping("transactionInterest")
	public String transactionInterest(@RequestParam(required = false) String flow_code,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date flow_date,
			@RequestParam(required = false) String flow_amount, @RequestParam(required = false) String flow_id,
			@RequestParam(required = false) String account_no, @RequestParam(required = false) String accountName,
			@RequestParam(required = false) String operation, HttpServletRequest rq) {

		String user = (String) rq.getSession().getAttribute("USERID");

		/* tranId sequence */
		String tranId = "TR" + tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID1();

		BigDecimal partTranId1 = BigDecimal.valueOf(1);
		BigDecimal partTranId2 = BigDecimal.valueOf(2);
		BigDecimal partTranId3 = BigDecimal.valueOf(3);

		System.out.println("Interest Part");

		if (flow_code.equals("PRDEM") || flow_code.equals("INDEM")) {

			String tranParticulars = null;

			if (flow_code.equals("PRDEM")) {
				tranParticulars = "Principle Debited";

			} else {
				tranParticulars = "Interest Debited";

			}

			System.out.println("Loan Account Interest");

			LocalDate localDate = flow_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();/* 15-04-2024 */
			LocalDate previousMonthSameDay = localDate.minusMonths(1);
			/* flow date -1 month */
			Date resultDate = Date
					.from(previousMonthSameDay.atStartOfDay(ZoneId.systemDefault()).toInstant());/* 15-03-2024 */

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(resultDate);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

			Date bookingDate = calendar.getTime();/* 30-03-2024 */

			LocalDate startDate = convertToLocalDate(resultDate);/* 15-03-2024 */
			LocalDate endDate = convertToLocalDate(flow_date);/* 15-04-2024 */
			long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);/* 30 days */

			LocalDate startDate1 = convertToLocalDate(resultDate);/* 15-03-2024 */
			LocalDate endDate1 = convertToLocalDate(bookingDate);/* 30-03-2024 */
			long daysBetween1 = ChronoUnit.DAYS.between(startDate1, endDate1);/* 15 days */

			BigDecimal flowAmount = new BigDecimal(flow_amount);

			BigDecimal daysInMonthDecimal = new BigDecimal(daysBetween);
			BigDecimal singledayamount = flowAmount.divide(daysInMonthDecimal, 2,
					RoundingMode.HALF_UP);/* 6000/30=200 */

			BigDecimal betweendaysDecimal = new BigDecimal(daysBetween1);
			BigDecimal finalamount = singledayamount.multiply(betweendaysDecimal);/* 200*15=3000 */

			BigDecimal creditAmount = flowAmount.subtract(finalamount);/* 6000-3000=3000 */
			/* TRM table entry set here */

			Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(account_no);

			/* First Transaction - customer loan account DEBIT */
			TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
			debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
			debitTrm.setTran_id(tranId);
			debitTrm.setPart_tran_id(partTranId1);
			debitTrm.setAcct_num(loandetails.getLoan_accountno());
			debitTrm.setAcct_name(loandetails.getCustomer_name());
			debitTrm.setTran_type("TRANSFER");
			debitTrm.setPart_tran_type("Debit");
			debitTrm.setAcct_crncy(loandetails.getLoan_currency());
			debitTrm.setTran_amt(flowAmount);
			debitTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
			debitTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
			debitTrm.setTran_date(flow_date);
			debitTrm.setValue_date(flow_date);
			debitTrm.setFlow_code(flow_code);
			debitTrm.setFlow_date(flow_date);
			debitTrm.setTran_status("ENTERED");
			debitTrm.setEntry_user(user);
			debitTrm.setEntry_time(flow_date);
			debitTrm.setDel_flg("N");
			tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

			/* Second Transaction - office Loan INTEREST Account CREDIT */
			/* this account already existed in COA */
			String acct_num = "4100004110";
			Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

			TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

			creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
			creditTrm.setTran_id(tranId);
			creditTrm.setPart_tran_id(partTranId2);
			creditTrm.setAcct_num(leasydebit.getAcct_num());
			creditTrm.setAcct_name(leasydebit.getAcct_name());
			creditTrm.setTran_type("TRANSFER");
			creditTrm.setPart_tran_type("Credit");
			creditTrm.setAcct_crncy(leasydebit.getAcct_crncy());
			creditTrm.setTran_amt(creditAmount);
			creditTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
			creditTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
			creditTrm.setTran_date(flow_date);
			creditTrm.setValue_date(flow_date);
			creditTrm.setFlow_code(flow_code);
			creditTrm.setFlow_date(flow_date);
			creditTrm.setTran_status("ENTERED");
			creditTrm.setEntry_user(user);
			creditTrm.setEntry_time(flow_date);
			creditTrm.setDel_flg("N");
			tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

			/* third Transaction - interest receivable CREDIT */
			/* this account already existed in COA */
			String acct_num1 = "1200001220";
			Chart_Acc_Entity leasydebit1 = chart_Acc_Rep.getaedit(acct_num1);

			TRAN_MAIN_TRM_WRK_ENTITY creditTrm1 = new TRAN_MAIN_TRM_WRK_ENTITY();

			creditTrm1.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
			creditTrm1.setTran_id(tranId);
			creditTrm1.setPart_tran_id(partTranId3);
			creditTrm1.setAcct_num(leasydebit1.getAcct_num());
			creditTrm1.setAcct_name(leasydebit1.getAcct_name());
			creditTrm1.setTran_type("TRANSFER");
			creditTrm1.setPart_tran_type("Credit");
			creditTrm1.setAcct_crncy(leasydebit1.getAcct_crncy());
			creditTrm1.setTran_amt(finalamount);
			creditTrm1.setTran_particular(loandetails.getLoan_accountno() + " " + "Reversal of Booking");
			creditTrm1.setTran_remarks(loandetails.getLoan_accountno() + " " + "Reversal of Booking");
			creditTrm1.setTran_date(flow_date);
			creditTrm1.setValue_date(flow_date);
			creditTrm1.setFlow_code(flow_code);
			creditTrm1.setFlow_date(flow_date);
			creditTrm1.setTran_status("ENTERED");
			creditTrm1.setEntry_user(user);
			creditTrm1.setEntry_time(flow_date);
			creditTrm1.setDel_flg("N");
			tRAN_MAIN_TRM_WRK_REP.save(creditTrm1);

			/* update demand table interest tran details */
			DMD_TABLE demandRecords = dMD_TABLE_REPO.getDemandData(account_no, flow_code, flow_id);

			demandRecords.setTran_date(flow_date);
			demandRecords.setTran_id(tranId);
			demandRecords.setPart_tran_id(partTranId1);
			demandRecords.setPart_tran_type("Debit");
			demandRecords.setTran_crncy(loandetails.getLoan_currency());
			demandRecords.setTran_amt(new BigDecimal(flow_amount));
			demandRecords.setModify_time(flow_date);
			demandRecords.setModify_flg("Y");
			demandRecords.setModify_user(user);

			dMD_TABLE_REPO.save(demandRecords);

		} else {

			System.out.println("Deposit Account Interest");

			String tranParticulars = null;

			if (flow_code.equals("II")) {
				tranParticulars = "Interest Credited";

			} else {
				tranParticulars = "Interest Credited";

			}

			LocalDate localDate = flow_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();/* 15-04-2024 */
			LocalDate previousMonthSameDay = localDate.minusMonths(1);
			/* flow date -1 month */
			Date resultDate = Date
					.from(previousMonthSameDay.atStartOfDay(ZoneId.systemDefault()).toInstant());/* 15-03-2024 */

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(resultDate);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

			Date bookingDate = calendar.getTime();/* 30-03-2024 */

			LocalDate startDate = convertToLocalDate(resultDate);/* 15-03-2024 */
			LocalDate endDate = convertToLocalDate(flow_date);/* 15-04-2024 */
			long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);/* 30 days */

			LocalDate startDate1 = convertToLocalDate(resultDate);/* 15-03-2024 */
			LocalDate endDate1 = convertToLocalDate(bookingDate);/* 30-03-2024 */
			long daysBetween1 = ChronoUnit.DAYS.between(startDate1, endDate1);/* 15 days */

			BigDecimal flowAmount = new BigDecimal(flow_amount);

			BigDecimal daysInMonthDecimal = new BigDecimal(daysBetween);
			BigDecimal singledayamount = flowAmount.divide(daysInMonthDecimal, 2,
					RoundingMode.HALF_UP);/* 6000/30=200 */

			BigDecimal betweendaysDecimal = new BigDecimal(daysBetween1);
			BigDecimal finalamount = singledayamount.multiply(betweendaysDecimal);/* 200*15=3000 */

			BigDecimal creditAmount = flowAmount.subtract(finalamount);/* 6000-3000=3000 */

			DepositEntity depositevalue = depositRep.getCustdataactval(account_no);

			/* TRM table entry set here */

			TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

			/* First Transaction - deposit customer account CREDIT */
			creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
			creditTrm.setTran_id(tranId);
			creditTrm.setPart_tran_id(partTranId1);
			creditTrm.setAcct_num(depositevalue.getDepo_actno());
			creditTrm.setAcct_name(depositevalue.getCust_name());
			creditTrm.setAcct_crncy(depositevalue.getCurrency());
			creditTrm.setTran_type("TRANSFER");
			creditTrm.setPart_tran_type("Credit");
			creditTrm.setTran_amt(flowAmount);
			creditTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
			creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
			creditTrm.setTran_date(flow_date);
			creditTrm.setValue_date(flow_date);
			creditTrm.setFlow_code(flow_code);
			creditTrm.setFlow_date(flow_date);
			creditTrm.setTran_status("ENTERED");
			creditTrm.setEntry_user(user);
			creditTrm.setEntry_time(flow_date);
			creditTrm.setDel_flg("N");

			tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

			/* Second Transaction - office Deposit INTEREST Account DEBIT */
			/* this account already existed in COA */
			String acct_num = "6100006110";
			Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num);

			TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

			debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
			debitTrm.setTran_id(tranId);
			debitTrm.setPart_tran_id(partTranId2);
			debitTrm.setAcct_num(termdeposite.getAcct_num());
			debitTrm.setAcct_name(termdeposite.getAcct_name());
			debitTrm.setTran_type("TRANSFER");
			debitTrm.setPart_tran_type("Debit");
			debitTrm.setAcct_crncy(termdeposite.getAcct_crncy());
			debitTrm.setTran_amt(creditAmount);
			debitTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
			debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
			debitTrm.setTran_date(flow_date);
			debitTrm.setValue_date(flow_date);
			debitTrm.setFlow_code(flow_code);
			debitTrm.setFlow_date(flow_date);
			debitTrm.setTran_status("ENTERED");
			debitTrm.setEntry_user(user);
			debitTrm.setEntry_time(flow_date);
			debitTrm.setDel_flg("N");

			tRAN_MAIN_TRM_WRK_REP.save(debitTrm); // Save the second transaction

			/* THIRD Transaction - INTEREST PAYABLE Account DEBIT */
			/* this account already existed in COA */
			String acct_num1 = "2200002220";
			Chart_Acc_Entity termdeposit = chart_Acc_Rep.getaedit(acct_num1);

			TRAN_MAIN_TRM_WRK_ENTITY debitTrm1 = new TRAN_MAIN_TRM_WRK_ENTITY();

			debitTrm1.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
			debitTrm1.setTran_id(tranId);
			debitTrm1.setPart_tran_id(partTranId3);
			debitTrm1.setAcct_num(termdeposit.getAcct_num());
			debitTrm1.setAcct_name(termdeposit.getAcct_name());
			debitTrm1.setTran_type("TRANSFER");
			debitTrm1.setPart_tran_type("Debit");
			debitTrm1.setAcct_crncy(termdeposit.getAcct_crncy());
			debitTrm1.setTran_amt(finalamount);
			debitTrm1.setTran_particular(depositevalue.getDepo_actno() + " " + "Reversal Of Booking");
			debitTrm1.setTran_remarks(depositevalue.getDepo_actno() + " " + "Reversal Of Booking");
			debitTrm1.setTran_date(flow_date);
			debitTrm1.setValue_date(flow_date);
			debitTrm1.setFlow_code(flow_code);
			debitTrm1.setFlow_date(flow_date);
			debitTrm1.setTran_status("ENTERED");
			debitTrm1.setEntry_user(user);
			debitTrm1.setEntry_time(flow_date);
			debitTrm1.setDel_flg("N");

			tRAN_MAIN_TRM_WRK_REP.save(debitTrm1);

			/* update demand table interest tran details */
			Td_defn_table flowRecords = td_defn_Repo.getFlowrecords(account_no, flow_code, flow_id);
			flowRecords.setTran_date(flow_date);
			flowRecords.setTran_id(tranId);
			flowRecords.setPart_tran_id(partTranId1);
			flowRecords.setTran_amt(new BigDecimal(flow_amount));
			flowRecords.setModify_user(user);
			flowRecords.setModify_time(flow_date);
			flowRecords.setModify_flg("Y");

			td_defn_Repo.save(flowRecords);

		}

		return tranId;
	}

	/* praveen - Collection */
	@GetMapping("transactionCollection")
	public String transactionCollection(@RequestParam(required = false) String flow_code,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date flow_date,
			@RequestParam(required = false) String flow_amount, @RequestParam(required = false) String flow_id,
			@RequestParam(required = false) String account_no, @RequestParam(required = false) String accountName,
			@RequestParam(required = false) String operation, HttpServletRequest rq) {

		String user = (String) rq.getSession().getAttribute("USERID");

		/* tranId sequence */
		String tranId = "TR" + tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID1();

		BigDecimal partTranId1 = BigDecimal.valueOf(1);
		BigDecimal partTranId2 = BigDecimal.valueOf(2);

		if (operation.equals("CollectionCash")) {

			System.out.println("Cash Collection Part");

			if (flow_code.equals("PRDEM") || flow_code.equals("INDEM")) {

				String tranParticulars = null;

				if (flow_code.equals("PRDEM")) {
					tranParticulars = "Principle Installment Recovered";

				} else {
					tranParticulars = "Interest Installment Recovered";

				}

				System.out.println("Loan Account Collection");

				Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(account_no);

				/* TRM table entry set here */

				/* First Transaction - customer loan account credit */
				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(partTranId1);
				creditTrm.setAcct_num(loandetails.getLoan_accountno());
				creditTrm.setAcct_name(loandetails.getCustomer_name());
				creditTrm.setTran_type("CASH");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(loandetails.getLoan_currency());
				creditTrm.setTran_amt(new BigDecimal(flow_amount));
				creditTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
				creditTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
				creditTrm.setTran_date(flow_date);
				creditTrm.setValue_date(flow_date);
				creditTrm.setFlow_code(flow_code);
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");
				tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

				/* Second Transaction - cash on hand account Debit */
				/* this account already existed in COA */
				String acct_num = "1100001120";
				Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

				TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				debitTrm.setTran_id(tranId);
				debitTrm.setPart_tran_id(partTranId2);
				debitTrm.setAcct_num(leasydebit.getAcct_num());
				debitTrm.setAcct_name(leasydebit.getAcct_name());
				debitTrm.setTran_type("CASH");
				debitTrm.setPart_tran_type("Debit");
				debitTrm.setAcct_crncy(leasydebit.getAcct_crncy());
				debitTrm.setTran_amt(new BigDecimal(flow_amount));
				debitTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
				debitTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
				debitTrm.setTran_date(flow_date);
				debitTrm.setValue_date(flow_date);
				debitTrm.setFlow_code(flow_code);
				debitTrm.setFlow_date(flow_date);
				debitTrm.setTran_status("ENTERED");
				debitTrm.setEntry_user(user);
				debitTrm.setEntry_time(flow_date);
				debitTrm.setDel_flg("N");
				tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

				/* update demand table interest tran details */
				DMD_TABLE demandRecords = dMD_TABLE_REPO.getDemandData(account_no, flow_code, flow_id);

				demandRecords.setAdj_dt(flow_date);
				demandRecords.setAdj_amt(new BigDecimal(flow_amount));

				dMD_TABLE_REPO.save(demandRecords);

			} else {

				System.out.println("Deposit Account Collection");

				String tranParticulars = null;

				if (flow_code.equals("II")) {
					tranParticulars = "Interest Debited";

				} else {
					tranParticulars = "Interest Debited";

				}

				DepositEntity depositevalue = depositRep.getCustdataactval(account_no);

				/* TRM table entry set here */

				TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				/* First Transaction - deposit customer account debit */
				debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				debitTrm.setTran_id(tranId);
				debitTrm.setPart_tran_id(partTranId1);
				debitTrm.setAcct_num(depositevalue.getDepo_actno());
				debitTrm.setAcct_name(depositevalue.getCust_name());
				debitTrm.setAcct_crncy(depositevalue.getCurrency());
				debitTrm.setTran_type("TRANSFER");
				debitTrm.setPart_tran_type("Debit");
				debitTrm.setTran_amt(new BigDecimal(flow_amount));
				debitTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
				debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
				debitTrm.setTran_date(flow_date);
				debitTrm.setValue_date(flow_date);
				debitTrm.setFlow_code(flow_code);
				debitTrm.setFlow_date(flow_date);
				debitTrm.setTran_status("ENTERED");
				debitTrm.setEntry_user(user);
				debitTrm.setEntry_time(flow_date);
				debitTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

				/* Second Transaction - office Deposit Account credit */
				/* this account already existed in COA */
				String acct_num = "1700001750";
				Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num);

				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(partTranId2);
				creditTrm.setAcct_num(termdeposite.getAcct_num());
				creditTrm.setAcct_name(termdeposite.getAcct_name());
				creditTrm.setTran_type("TRANSFER");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(termdeposite.getAcct_crncy());
				creditTrm.setTran_amt(new BigDecimal(flow_amount));
				creditTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
				creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
				creditTrm.setTran_date(flow_date);
				creditTrm.setValue_date(flow_date);
				creditTrm.setFlow_code(flow_code);
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

			}

		} else if (operation.equals("CollectionRouting")) {

			System.out.println("Routing A/C Collection Part");

			if (flow_code.equals("PRDEM") || flow_code.equals("INDEM")) {

				String tranParticulars = null;

				if (flow_code.equals("PRDEM")) {
					tranParticulars = "Principle Installment Recovered";

				} else {
					tranParticulars = "Interest Installment Recovered";

				}

				System.out.println("Loan Account Interest");

				Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(account_no);

				/* TRM table entry set here */

				/* First Transaction - customer loan account credit */
				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(partTranId1);
				creditTrm.setAcct_num(loandetails.getLoan_accountno());
				creditTrm.setAcct_name(loandetails.getCustomer_name());
				creditTrm.setTran_type("TRANSFER");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(loandetails.getLoan_currency());
				creditTrm.setTran_amt(new BigDecimal(flow_amount));
				creditTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
				creditTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
				creditTrm.setTran_date(flow_date);
				creditTrm.setValue_date(flow_date);
				creditTrm.setFlow_code(flow_code);
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");
				tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

				/* Second Transaction - office Loan Account Debit */
				/* this account already existed in COA */
				String acct_num = "2700002750";
				Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

				TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				debitTrm.setTran_id(tranId);
				debitTrm.setPart_tran_id(partTranId2);
				debitTrm.setAcct_num(leasydebit.getAcct_num());
				debitTrm.setAcct_name(leasydebit.getAcct_name());
				debitTrm.setTran_type("TRANSFER");
				debitTrm.setPart_tran_type("Debit");
				debitTrm.setAcct_crncy(leasydebit.getAcct_crncy());
				debitTrm.setTran_amt(new BigDecimal(flow_amount));
				debitTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
				debitTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
				debitTrm.setTran_date(flow_date);
				debitTrm.setValue_date(flow_date);
				debitTrm.setFlow_code(flow_code);
				debitTrm.setFlow_date(flow_date);
				debitTrm.setTran_status("ENTERED");
				debitTrm.setEntry_user(user);
				debitTrm.setEntry_time(flow_date);
				debitTrm.setDel_flg("N");
				tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

				/* update demand table interest tran details */
				DMD_TABLE demandRecords = dMD_TABLE_REPO.getDemandData(account_no, flow_code, flow_id);

				demandRecords.setAdj_dt(flow_date);
				demandRecords.setAdj_amt(new BigDecimal(flow_amount));

				dMD_TABLE_REPO.save(demandRecords);

			} else {

				System.out.println("Deposit Account Interest");

				String tranParticulars = null;

				if (flow_code.equals("II")) {
					tranParticulars = "Interest Debited";

				} else {
					tranParticulars = "Interest Debited";

				}

				DepositEntity depositevalue = depositRep.getCustdataactval(account_no);

				/* TRM table entry set here */

				TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				/* First Transaction - deposit customer account debit */
				debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				debitTrm.setTran_id(tranId);
				debitTrm.setPart_tran_id(partTranId1);
				debitTrm.setAcct_num(depositevalue.getDepo_actno());
				debitTrm.setAcct_name(depositevalue.getCust_name());
				debitTrm.setAcct_crncy(depositevalue.getCurrency());
				debitTrm.setTran_type("TRANSFER");
				debitTrm.setPart_tran_type("Debit");
				debitTrm.setTran_amt(new BigDecimal(flow_amount));
				debitTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
				debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
				debitTrm.setTran_date(flow_date);
				debitTrm.setValue_date(flow_date);
				debitTrm.setFlow_code(flow_code);
				debitTrm.setFlow_date(flow_date);
				debitTrm.setTran_status("ENTERED");
				debitTrm.setEntry_user(user);
				debitTrm.setEntry_time(flow_date);
				debitTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

				/* Second Transaction - office Deposit Account credit */
				/* this account already existed in COA */
				String acct_num = "1700001750";
				Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num);

				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(partTranId2);
				creditTrm.setAcct_num(termdeposite.getAcct_num());
				creditTrm.setAcct_name(termdeposite.getAcct_name());
				creditTrm.setTran_type("TRANSFER");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(termdeposite.getAcct_crncy());
				creditTrm.setTran_amt(new BigDecimal(flow_amount));
				creditTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
				creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
				creditTrm.setTran_date(flow_date);
				creditTrm.setValue_date(flow_date);
				creditTrm.setFlow_code(flow_code);
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");

				tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

			}
		}
		return tranId;
	}

	@GetMapping("getFlowDetails")
	public List<DMD_TABLE> getFlowDetails(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date creation_Date,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date start_date,
			@RequestParam(defaultValue = "0") double Product_value, @RequestParam String principle_frequency,
			@RequestParam(defaultValue = "0") int int_rate, @RequestParam(defaultValue = "0") int no_of_inst,
			@RequestParam(defaultValue = "0") double int_amt, @RequestParam String interestFrequency)
			throws ParseException {

		LocalDate startDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = startDate.plus(no_of_inst, ChronoUnit.MONTHS);
		Date calculatedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		BigDecimal product = BigDecimal.valueOf(Product_value);
		BigDecimal productAmt = BigDecimal.valueOf(Product_value);
		BigDecimal intRate = BigDecimal.valueOf(int_rate);
		BigDecimal instmentAmount = BigDecimal.valueOf(int_amt);

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

				entity.setFlow_id(BigDecimal.valueOf(noOfInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());

				entity.setFlow_amt(record.getInterestAmount());
				entity.setFlow_code("INDEM");

				noOfInstallment++;
				principleAndInterest.add(entity);
			}

			for (TestPrincipalCalculation record : InterestAmount) {
				DMD_TABLE entity = new DMD_TABLE();

				entity.setFlow_id(BigDecimal.valueOf(noOfprincipalInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());

				entity.setFlow_amt(record.getPrincipalAmount());
				entity.setFlow_code("PRDEM");

				noOfprincipalInstallment++;
				principleAndInterest.add(entity);
			}

		} else {

		}

		principleAndInterest.sort(Comparator.comparing(DMD_TABLE::getFlow_id));

		return principleAndInterest;
	}

	@GetMapping("LeaseBalance")
	public List<Object[]> LeaseBalance(
			@RequestParam("date_of_loan") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date_of_loan) {

		return dab_Repo.getLeaseBal(date_of_loan);
	}

	@GetMapping("DepositBalance")
	public List<Object[]> DepositBalance(
			@RequestParam("deposit_period") @DateTimeFormat(pattern = "dd-MM-yyyy") Date deposit_period) {

		return dab_Repo.getDepositBal(deposit_period);
	}
	/*
	 * @RequestMapping(value = "glconsolidation", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String glconsolidation(@RequestParam(required =
	 * false) String formmode, Model model, HttpServletRequest request) {
	 * 
	 * // Perform the update without expecting a return value
	 * generalLedgerWork_Rep.getupdateglwork();
	 * generalLedgerWork_Rep.updateNoAcctOpened();
	 * generalLedgerWork_Rep.updateNoAcctClosed();
	 * 
	 * return "Successful"; }
	 */

	@RequestMapping(value = "glconsolidation", method = { RequestMethod.GET, RequestMethod.POST })
	public String glconsolidation(@RequestParam(required = false) String formmode, Model model,
			HttpServletRequest request) {

		// Perform the update without expecting a return value
		generalLedgerRep.getupdateglwork();
		generalLedgerRep.updateNoAcctOpened();
		generalLedgerRep.updateNoAcctClosed();

		return "Successful";
	}

	@GetMapping("getAccountName")
	public String getAccountName(@RequestParam(required = false) String accountNum) {

		String acountName = lease_Loan_Master_Repo.accountName(accountNum);
		return acountName;
	}

	@GetMapping("loanCollection")
	public String getrecordfromcoa(@RequestParam(required = false) String accountNum,
			@RequestParam(required = false) BigDecimal amount, @RequestParam(required = false) String operationType,
			HttpServletRequest req) {

		Date flowdate = (Date) req.getSession().getAttribute("TRANDATE");

		String user = (String) req.getSession().getAttribute("USERID");

		/* tranId sequence */
		String tranId = "TR" + tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID1();
		String msg = "";

		List<DMD_TABLE> demand_records = dMD_TABLE_REPO.getAlldemand(accountNum, flowdate);

		if (demand_records.size() > 0) {

			/* Any Demand available only collection operation will be done */
			BigDecimal insterestAmuont = BigDecimal.ZERO;
			BigDecimal principleAmount = BigDecimal.ZERO;

			BigDecimal partTranId1 = BigDecimal.valueOf(1);
			BigDecimal partTranId2 = BigDecimal.valueOf(2);

			for (DMD_TABLE demand : demand_records) {

				if (demand.getFlow_code().equalsIgnoreCase("INDEM")) {
					insterestAmuont = insterestAmuont.add(demand.getFlow_amt());
				} else {
					principleAmount = principleAmount.add(demand.getFlow_amt());
				}
			}

			String flow_code = "RIDEM";
			Date flow_date = demand_records.get(0).getFlow_date();
			BigDecimal flow_amount = amount;
			String flow_id = demand_records.get(0).getFlow_id().toString();

			if (operationType.equals("CollectionCash")) {

				System.out.println("Cash Collection Part");

				if (flow_code.equals("PRDEM") || flow_code.equals("INDEM") || flow_code.equals("RIDEM")) {

					String tranParticulars = null;

					if (flow_code.equals("PRDEM") || flow_code.equals("RIDEM")) {
						tranParticulars = "Installment Recovered";

					} else {
						tranParticulars = "Interest Installment Recovered";

					}

					System.out.println("Loan Account Collection");

					Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNum);

					/* TRM table entry set here */

					/* First Transaction - customer loan account credit */
					TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
					creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					creditTrm.setTran_id(tranId);
					creditTrm.setPart_tran_id(partTranId1);
					creditTrm.setAcct_num(loandetails.getLoan_accountno());
					creditTrm.setAcct_name(loandetails.getCustomer_name());
					creditTrm.setTran_type("CASH");
					creditTrm.setPart_tran_type("Credit");
					creditTrm.setAcct_crncy(loandetails.getLoan_currency());
					creditTrm.setTran_amt(flow_amount);
					creditTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
					creditTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
					creditTrm.setTran_date(flow_date);
					creditTrm.setValue_date(flow_date);
					creditTrm.setFlow_code("COLLECT");
					creditTrm.setFlow_date(flow_date);
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(flow_date);
					creditTrm.setDel_flg("N");
					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

					/* Second Transaction - cash on hand account Debit */
					/* this account already existed in COA */
					String acct_num = "1100001120";
					Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

					TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

					debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					debitTrm.setTran_id(tranId);
					debitTrm.setPart_tran_id(partTranId2);
					debitTrm.setAcct_num(leasydebit.getAcct_num());
					debitTrm.setAcct_name(leasydebit.getAcct_name());
					debitTrm.setTran_type("CASH");
					debitTrm.setPart_tran_type("Debit");
					debitTrm.setAcct_crncy(leasydebit.getAcct_crncy());
					debitTrm.setTran_amt(flow_amount);
					debitTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
					debitTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
					debitTrm.setTran_date(flow_date);
					debitTrm.setValue_date(flow_date);
					debitTrm.setFlow_code("COLLECT");
					debitTrm.setFlow_date(flow_date);
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(flow_date);
					debitTrm.setDel_flg("N");
					tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

					/* update demand table interest tran details */
					BigDecimal principalAdjAmt = amount.subtract(insterestAmuont);
					String flowPrinCode = "PRDEM";

					DMD_TABLE demandRecords = dMD_TABLE_REPO.getDemandData(accountNum, flowPrinCode, flow_id);

					demandRecords.setAdj_dt(flow_date);
					demandRecords.setAdj_amt(principalAdjAmt);
					demandRecords.setTran_amt(principalAdjAmt);
					demandRecords.setTran_date(flow_date);
					demandRecords.setTran_id(tranId);
					demandRecords.setPart_tran_type("Credit");
					demandRecords.setPart_tran_id(partTranId1);
					demandRecords.setModify_time(flow_date);
					demandRecords.setModify_flg("Y");
					demandRecords.setModify_user(user);

					dMD_TABLE_REPO.save(demandRecords);

					String flowIntCode = "INDEM";

					DMD_TABLE demandRecordsInt = dMD_TABLE_REPO.getDemandData(accountNum, flowIntCode, flow_id);

					demandRecordsInt.setAdj_dt(flow_date);
					demandRecordsInt.setAdj_amt(insterestAmuont);

					dMD_TABLE_REPO.save(demandRecordsInt);

				} else {

					System.out.println("Deposit Account Collection");

					String tranParticulars = null;

					if (flow_code.equals("II")) {
						tranParticulars = "Interest Debited";

					} else {
						tranParticulars = "Interest Debited";

					}

					DepositEntity depositevalue = depositRep.getCustdataactval(accountNum);

					/* TRM table entry set here */

					TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

					/* First Transaction - deposit customer account debit */
					debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					debitTrm.setTran_id(tranId);
					debitTrm.setPart_tran_id(partTranId1);
					debitTrm.setAcct_num(depositevalue.getDepo_actno());
					debitTrm.setAcct_name(depositevalue.getCust_name());
					debitTrm.setAcct_crncy(depositevalue.getCurrency());
					debitTrm.setTran_type("TRANSFER");
					debitTrm.setPart_tran_type("Debit");
					debitTrm.setTran_amt(flow_amount);
					debitTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
					debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
					debitTrm.setTran_date(flow_date);
					debitTrm.setValue_date(flow_date);
					debitTrm.setFlow_code(flow_code);
					debitTrm.setFlow_date(flow_date);
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(flow_date);
					debitTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

					/* Second Transaction - office Deposit Account credit */
					/* this account already existed in COA */
					String acct_num = "1700001750";
					Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num);

					TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

					creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					creditTrm.setTran_id(tranId);
					creditTrm.setPart_tran_id(partTranId2);
					creditTrm.setAcct_num(termdeposite.getAcct_num());
					creditTrm.setAcct_name(termdeposite.getAcct_name());
					creditTrm.setTran_type("TRANSFER");
					creditTrm.setPart_tran_type("Credit");
					creditTrm.setAcct_crncy(termdeposite.getAcct_crncy());
					creditTrm.setTran_amt(flow_amount);
					creditTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
					creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
					creditTrm.setTran_date(flow_date);
					creditTrm.setValue_date(flow_date);
					creditTrm.setFlow_code(flow_code);
					creditTrm.setFlow_date(flow_date);
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(flow_date);
					creditTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

				}

			} else if (operationType.equals("CollectionRouting")) {

				System.out.println("Routing A/C Collection Part");

				if (flow_code.equals("PRDEM") || flow_code.equals("INDEM") || flow_code.equals("RIDEM")) {

					String tranParticulars = null;

					if (flow_code.equals("PRDEM") || flow_code.equals("RIDEM")) {
						tranParticulars = "Installment Recovered";

					} else {
						tranParticulars = "Interest Installment Recovered";

					}

					System.out.println("Loan Account Interest");

					Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNum);

					/* TRM table entry set here */

					/* First Transaction - customer loan account credit */
					TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
					creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					creditTrm.setTran_id(tranId);
					creditTrm.setPart_tran_id(partTranId1);
					creditTrm.setAcct_num(loandetails.getLoan_accountno());
					creditTrm.setAcct_name(loandetails.getCustomer_name());
					creditTrm.setTran_type("TRANSFER");
					creditTrm.setPart_tran_type("Credit");
					creditTrm.setAcct_crncy(loandetails.getLoan_currency());
					creditTrm.setTran_amt(flow_amount);
					creditTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
					creditTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
					creditTrm.setTran_date(flow_date);
					creditTrm.setValue_date(flow_date);
					creditTrm.setFlow_code("COLLECT");
					creditTrm.setFlow_date(flow_date);
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(flow_date);
					creditTrm.setDel_flg("N");
					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

					/* Second Transaction - office Loan Account Debit */
					/* this account already existed in COA */
					String acct_num = "2700002750";
					Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

					TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

					debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					debitTrm.setTran_id(tranId);
					debitTrm.setPart_tran_id(partTranId2);
					debitTrm.setAcct_num(leasydebit.getAcct_num());
					debitTrm.setAcct_name(leasydebit.getAcct_name());
					debitTrm.setTran_type("TRANSFER");
					debitTrm.setPart_tran_type("Debit");
					debitTrm.setAcct_crncy(leasydebit.getAcct_crncy());
					debitTrm.setTran_amt(flow_amount);
					debitTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
					debitTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
					debitTrm.setTran_date(flow_date);
					debitTrm.setValue_date(flow_date);
					debitTrm.setFlow_code("COLLECT");
					debitTrm.setFlow_date(flow_date);
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(flow_date);
					debitTrm.setDel_flg("N");
					tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

					/* update demand table interest tran details */
					BigDecimal principalAdjAmt = amount.subtract(insterestAmuont);
					String flowPrinCode = "PRDEM";
					DMD_TABLE demandRecords = dMD_TABLE_REPO.getDemandData(accountNum, flowPrinCode, flow_id);

					demandRecords.setAdj_dt(flow_date);
					demandRecords.setAdj_amt(principalAdjAmt);
					demandRecords.setTran_amt(principalAdjAmt);
					demandRecords.setTran_date(flow_date);
					demandRecords.setTran_id(tranId);
					demandRecords.setPart_tran_type("Credit");
					demandRecords.setPart_tran_id(partTranId1);
					demandRecords.setModify_time(flow_date);
					demandRecords.setModify_flg("Y");
					demandRecords.setModify_user(user);

					dMD_TABLE_REPO.save(demandRecords);

					String flowIntCode = "INDEM";

					DMD_TABLE demandRecordsInt = dMD_TABLE_REPO.getDemandData(accountNum, flowIntCode, flow_id);

					demandRecordsInt.setAdj_dt(flow_date);
					demandRecordsInt.setAdj_amt(insterestAmuont);

					dMD_TABLE_REPO.save(demandRecordsInt);

				} else {

					System.out.println("Deposit Account Interest");

					String tranParticulars = null;

					if (flow_code.equals("II")) {
						tranParticulars = "Interest Debited";

					} else {
						tranParticulars = "Interest Debited";

					}

					DepositEntity depositevalue = depositRep.getCustdataactval(accountNum);

					/* TRM table entry set here */

					TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

					/* First Transaction - deposit customer account debit */
					debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					debitTrm.setTran_id(tranId);
					debitTrm.setPart_tran_id(partTranId1);
					debitTrm.setAcct_num(depositevalue.getDepo_actno());
					debitTrm.setAcct_name(depositevalue.getCust_name());
					debitTrm.setAcct_crncy(depositevalue.getCurrency());
					debitTrm.setTran_type("TRANSFER");
					debitTrm.setPart_tran_type("Debit");
					debitTrm.setTran_amt(flow_amount);
					debitTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
					debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
					debitTrm.setTran_date(flow_date);
					debitTrm.setValue_date(flow_date);
					debitTrm.setFlow_code(flow_code);
					debitTrm.setFlow_date(flow_date);
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(flow_date);
					debitTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

					/* Second Transaction - office Deposit Account credit */
					/* this account already existed in COA */
					String acct_num = "1700001750";
					Chart_Acc_Entity termdeposite = chart_Acc_Rep.getaedit(acct_num);

					TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

					creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					creditTrm.setTran_id(tranId);
					creditTrm.setPart_tran_id(partTranId2);
					creditTrm.setAcct_num(termdeposite.getAcct_num());
					creditTrm.setAcct_name(termdeposite.getAcct_name());
					creditTrm.setTran_type("TRANSFER");
					creditTrm.setPart_tran_type("Credit");
					creditTrm.setAcct_crncy(termdeposite.getAcct_crncy());
					creditTrm.setTran_amt(flow_amount);
					creditTrm.setTran_particular(depositevalue.getDepo_actno() + " " + tranParticulars);
					creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " " + tranParticulars);
					creditTrm.setTran_date(flow_date);
					creditTrm.setValue_date(flow_date);
					creditTrm.setFlow_code(flow_code);
					creditTrm.setFlow_date(flow_date);
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(flow_date);
					creditTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

				}
			}

			msg = "Transaction Entered Successfully and TRANID : " + tranId;

		} else {
			msg = "No data available for Account Number : " + accountNum;
		}

		return msg;
	}

	@GetMapping("getAbstractionRecords")
	public List<TRAN_MAIN_TRM_WRK_ENTITY> getAbstractionRecords(@RequestParam(required = false) String operationType,
			HttpServletRequest req) {

		Date flow_date = (Date) req.getSession().getAttribute("TRANDATE");
		String user = (String) req.getSession().getAttribute("USERID");

		List<TRAN_MAIN_TRM_WRK_ENTITY> transaction = tranMainRep.getTransactionRecords(flow_date, user);

		return transaction;
	}

	@GetMapping("getLoanPosition")
	public List<DMD_TABLE> getLoanPosition(@RequestParam(required = false) String accountNum, HttpServletRequest req) {

		Date flow_date = (Date) req.getSession().getAttribute("TRANDATE");

		List<DMD_TABLE> returnRecord = dmdRepo.getloanposition(accountNum, flow_date);

		return returnRecord;
	}

	@PostMapping("/settlementCollection")
	public String settlementCollection(@RequestBody Settlement_Collection_Entity[] settlementRecords,
			HttpServletRequest req) {

		Date flowdate = (Date) req.getSession().getAttribute("TRANDATE");

		String user = (String) req.getSession().getAttribute("USERID");

		/* tranId sequence */
		String tranId = "TR" + tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID1();
		String msg = "";

		int partTranId1 = 1;
		BigDecimal totalAllocation = BigDecimal.ZERO;

		/* final save data added in allTransaction */
		List<TRAN_MAIN_TRM_WRK_ENTITY> allTransaction = new ArrayList<>();

		/* Credit legs Transaction only set here for loan account */
		for (Settlement_Collection_Entity record : settlementRecords) {

			/* from the list get account number and allocation amount */
			String accountNum = record.getAcct_num();
			BigDecimal amountPaid = record.getAllocation();

			totalAllocation = totalAllocation.add(amountPaid);

			/* get PRDEM and IRDEM Demand of account */
			List<DMD_TABLE> demand_records = dMD_TABLE_REPO.getAlldemand(accountNum, flowdate);

			if (demand_records.size() > 0) {

				/* Any Demand available only collection operation will be done */
				BigDecimal insterestAmuont = BigDecimal.ZERO;
				BigDecimal principleAmount = BigDecimal.ZERO;

				for (DMD_TABLE demand : demand_records) {

					if (demand.getFlow_code().equalsIgnoreCase("INDEM")) {
						insterestAmuont = insterestAmuont.add(demand.getFlow_amt());
					} else {
						principleAmount = principleAmount.add(demand.getFlow_amt());
					}
				}

				Date flow_date = demand_records.get(0).getFlow_date();
				BigDecimal flow_amount = amountPaid;
				String flow_id = demand_records.get(0).getFlow_id().toString();

				String tranParticulars = "Installment Recovered";

				Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNum);

				/* TRM table entry set here */

				/* customer loan account credit */
				TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
				creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
				creditTrm.setTran_id(tranId);
				creditTrm.setPart_tran_id(BigDecimal.valueOf(partTranId1));
				creditTrm.setAcct_num(loandetails.getLoan_accountno());
				creditTrm.setAcct_name(loandetails.getCustomer_name());
				creditTrm.setTran_type("CASH");
				creditTrm.setPart_tran_type("Credit");
				creditTrm.setAcct_crncy(loandetails.getLoan_currency());
				creditTrm.setTran_amt(flow_amount);
				creditTrm.setTran_particular(loandetails.getLoan_accountno() + " " + tranParticulars);
				creditTrm.setTran_remarks(loandetails.getLoan_accountno() + " " + tranParticulars);
				creditTrm.setTran_date(flow_date);
				creditTrm.setValue_date(flow_date);
				creditTrm.setFlow_code("COLLECT");
				creditTrm.setFlow_date(flow_date);
				creditTrm.setTran_status("ENTERED");
				creditTrm.setEntry_user(user);
				creditTrm.setEntry_time(flow_date);
				creditTrm.setDel_flg("N");
				allTransaction.add(creditTrm);

				/* update demand table interest tran details */
				/* principal adjustment */
				BigDecimal principalAdjAmt = amountPaid.subtract(insterestAmuont);
				String flowPrinCode = "PRDEM";

				DMD_TABLE demandRecords = dMD_TABLE_REPO.getDemandData(accountNum, flowPrinCode, flow_id);

				demandRecords.setAdj_dt(flow_date);
				demandRecords.setAdj_amt(principalAdjAmt);
				demandRecords.setTran_amt(principalAdjAmt);
				demandRecords.setTran_date(flow_date);
				demandRecords.setTran_id(tranId);
				demandRecords.setPart_tran_type("Credit");
				demandRecords.setPart_tran_id(BigDecimal.valueOf(partTranId1));
				demandRecords.setModify_time(flow_date);
				demandRecords.setModify_flg("Y");
				demandRecords.setModify_user(user);

				// dMD_TABLE_REPO.save(demandRecords);

				/* interest adjustment */
				String flowIntCode = "INDEM";

				DMD_TABLE demandRecordsInt = dMD_TABLE_REPO.getDemandData(accountNum, flowIntCode, flow_id);

				demandRecordsInt.setAdj_dt(flow_date);
				demandRecordsInt.setAdj_amt(insterestAmuont);

				// dMD_TABLE_REPO.save(demandRecordsInt);

			}

			partTranId1++;
		}

		/* Debit leg Transaction set here for Settlement account */
		BigDecimal partTranId2 = BigDecimal.valueOf(partTranId1);

		/* Final Transaction - Settlement Account Debit */
		/* this account already existed in COA */
		String acct_num = "1100001115";
		Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

		TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

		debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
		debitTrm.setTran_id(tranId);
		debitTrm.setPart_tran_id(partTranId2);
		debitTrm.setAcct_num(leasydebit.getAcct_num());
		debitTrm.setAcct_name(leasydebit.getAcct_name());
		debitTrm.setTran_type("TRANSFER");
		debitTrm.setPart_tran_type("Debit");
		debitTrm.setAcct_crncy(leasydebit.getAcct_crncy());
		debitTrm.setTran_amt(totalAllocation);
		debitTrm.setTran_particular("Absa Bank Settlement");
		debitTrm.setTran_remarks("Absa Bank Settlement");
		debitTrm.setTran_date(flowdate);
		debitTrm.setValue_date(flowdate);
		debitTrm.setFlow_code("COLLECT");
		debitTrm.setFlow_date(flowdate);
		debitTrm.setTran_status("ENTERED");
		debitTrm.setEntry_user(user);
		debitTrm.setEntry_time(flowdate);
		debitTrm.setDel_flg("N");
		allTransaction.add(debitTrm);

		System.out.println(allTransaction);
		tRAN_MAIN_TRM_WRK_REP.saveAll(allTransaction);

		msg = "Transaction Entered Successfully and TRANID : " + tranId;

		return msg;
	}

	@GetMapping("getPartitionFlag")
	public String getPartitionFlag(@RequestParam(required = false) String accountNum) {

		String partitionFlag = chart_Acc_Rep.getpartitionFlag(accountNum);

		return partitionFlag;
	}

	@GetMapping("getPointingDetail")
	public String getPointingDetail(@RequestParam(required = false) String accountNum) {

		String pointingDetail = chart_Acc_Rep.getpointingDetail(accountNum);

		return pointingDetail;
	}

	@GetMapping("getTranRefDetails")
	public List<Transaction_Pointing_Table_Entity> getTranRefDetails(
			@RequestParam(required = false) String accountNum) {

		List<Transaction_Pointing_Table_Entity> tranRefRecords = transaction_Pointing_Table_Repo
				.getTranRefRecords(accountNum);

		return tranRefRecords;
	}
	
	
	/* Thanveer */
	@RequestMapping(value = "DeleteScreens", method = RequestMethod.POST)

	@ResponseBody
	public String DeleteScreens(Model md, HttpServletRequest rq, @ModelAttribute Chart_Acc_Entity chart_Acc_Entity,
			@RequestParam(required = false) String acct_num) {
		String msg = "";
		Chart_Acc_Entity up = chart_Acc_Rep.getaedit(acct_num);
		System.out.println("the getting account no is " + acct_num);
		if (Objects.nonNull(up)) {
			up = chart_Acc_Entity;
			up.setDel_flg("Y");
			chart_Acc_Rep.save(up);
			msg = "Deleted Successfully";
		} else {
			msg = "Data Not Found";
		}
		String userid = (String) rq.getSession().getAttribute("USERID");
		// FOR AUIDT
		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();

		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());

		audit.setRemarks("Deleted Successfully");
		audit.setAudit_table("BGLS_CHART_OF_ACCOUNTS");
		audit.setAudit_screen("CHART OF ACCOUNTS - DELETE");
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

		bglsBusinessTable_Rep.save(audit);
		return msg;

	}

	/* Thanveer */
	@RequestMapping(value = "ModifyScreens", method = RequestMethod.POST)

	@ResponseBody
	public String ModifyScreens(Model md, HttpServletRequest rq, @ModelAttribute Chart_Acc_Entity chart_Acc_Entity,
			@RequestParam(required = false) String acct_num) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println("THE GETT");
		String msg = "";

		Chart_Acc_Entity up = chart_Acc_Rep.getaedit(acct_num);

		if (Objects.nonNull(up)) {
			up = chart_Acc_Entity;
			up.setDel_flg("N");
			up.setEntity_flg("N");
			chart_Acc_Rep.save(up);
			msg = "Modify Successfully";
		} else {
			msg = "Data Not Found";
		}
		// FOR AUIDT
		Long auditID = bglsBusinessTable_Rep.getAuditRefUUID();
		Optional<UserProfile> up1 = userProfileRep.findById(userid);
		UserProfile user = up1.get();

		BGLSBusinessTable_Entity audit = new BGLSBusinessTable_Entity();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date dateValue = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
		audit.setAudit_date(new Date());
		audit.setEntry_time(dateValue);
		audit.setEntry_user(user.getUserid());

		audit.setRemarks("Modify Successfully");
		audit.setAudit_table("BGLS_CHART_OF_ACCOUNTS");
		audit.setAudit_screen("CHART OF ACCOUNTS - MODIFY");
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

		bglsBusinessTable_Rep.save(audit);

		return msg;
	}

	

}
