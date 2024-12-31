package com.bornfire.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bornfire.entities.AIRep;
import com.bornfire.entities.BACP_BLACKLIST_Repo;
import com.bornfire.entities.BACP_CUS_PROFILE_REPO;
import com.bornfire.entities.BACP_DE_DUPRepo;
import com.bornfire.entities.BACP_DOC_MAN_ENTITY;
import com.bornfire.entities.BACP_DOC_MAN_REP;
import com.bornfire.entities.BACP_NEGATIVE_LIST_Repo;
import com.bornfire.entities.Bacp_Signature_master;
import com.bornfire.entities.Bacp_Signature_masterRepo;
import com.bornfire.entities.Bacp_WorkFLow_Entity;
import com.bornfire.entities.Bacp_WorkFLow_Repo;
import com.bornfire.entities.Chart_Acc_Entity;
import com.bornfire.entities.Chart_Acc_Rep;
import com.bornfire.entities.CustomerRequest;
import com.bornfire.entities.DMD_TABLE;
import com.bornfire.entities.DMD_TABLE_REPO;
import com.bornfire.entities.DepositEntity;
import com.bornfire.entities.DepositRep;
import com.bornfire.entities.DynamicFromValue;
import com.bornfire.entities.Employee_Profile;
import com.bornfire.entities.Employee_Profile_Rep;
import com.bornfire.entities.Lease_Loan_Work_Entity;
import com.bornfire.entities.Lease_Loan_Work_Repo;
import com.bornfire.entities.MinimalDataRepository;
import com.bornfire.entities.NoticeDetailsPayment0Rep;
import com.bornfire.entities.ParameterRep;
import com.bornfire.entities.ParametersDetails;
import com.bornfire.entities.Reference_Code_Entity;
import com.bornfire.entities.Reference_code_Rep;
import com.bornfire.entities.TRAN_MAIN_TRM_WRK_ENTITY;
import com.bornfire.entities.TRAN_MAIN_TRM_WRK_REP;
import com.bornfire.entities.Td_defn_Repo;
import com.bornfire.entities.Td_defn_table;
import com.bornfire.entities.UserProfileRep;
import com.bornfire.services.CustomerDetailsService;
import com.bornfire.services.CustomerRequestService;
import com.bornfire.services.LeaseLoanService;

@Controller
@ConfigurationProperties("default")
public class CustOnboardinController {

	private static final Logger logger = LoggerFactory.getLogger(CustOnboardinController.class);

	@Autowired
	Employee_Profile_Rep employee_Profile_Rep;
	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	ParameterRep parameterrep;

	@Autowired
	MinimalDataRepository minimalDataRepository;

	@Autowired
	CustomerRequestService customerRequestService;

	@Autowired
	CustomerDetailsService customerDetailsService;

	@Autowired
	BACP_DE_DUPRepo bACP_DE_DUPRepo;

	@Autowired
	BACP_NEGATIVE_LIST_Repo bACP_NEGATIVE_LIST_Repo;

	@Autowired
	BACP_BLACKLIST_Repo bACP_BLACKLIST_Repo;

	@Autowired
	Bacp_Signature_masterRepo bacp_Signature_masterRepo;

	@Autowired
	BACP_DOC_MAN_REP bacpRep;

	@Autowired
	BACP_CUS_PROFILE_REPO bACP_CUS_PROFILE_REPO;

	@Autowired
	Reference_code_Rep reference_code_Rep;

	@Autowired
	AIRep aIRep;

	@Autowired
	Bacp_WorkFLow_Repo bacp_WorkFLow_Repo;

	@Autowired
	Td_defn_Repo td_defn_Repo;

	@Autowired
	Lease_Loan_Work_Repo lease_Loan_Work_Repo;

	@Autowired
	NoticeDetailsPayment0Rep noticeDetailsPayment0Rep;

	@Autowired
	DepositRep depositRep;

	@Autowired
	TRAN_MAIN_TRM_WRK_REP tRAN_MAIN_TRM_WRK_REP;

	@Autowired
	Chart_Acc_Rep chart_Acc_Rep;

	@Autowired
	LeaseLoanService leaseLoanService;

	@Autowired
	DMD_TABLE_REPO dMD_TABLE_REPO;

	// Start API
	/// for get session
	private String getSessionAttribute(HttpServletRequest req, String paramName) {
		String paramValue = req.getParameter(paramName);
		if (paramValue != null) {
			req.getSession().setAttribute(paramName, paramValue);
		} else {
			paramValue = (String) req.getSession().getAttribute(paramName);
		}
		return paramValue;
	}
     String unique ;
	@RequestMapping(value = "CustomerOnboarding")
	public String CustomerOnboarding(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String firstname, @RequestParam(required = false) String middlename,
			@RequestParam(required = false) String lastname, @RequestParam(required = false) String fullname,
			@RequestParam(required = false) String shortname, @RequestParam(required = false) String datebirth,
			@RequestParam(required = false) String mobileno, @RequestParam(required = false) String passno,
			@RequestParam(required = false) String nationalid, @RequestParam(required = false) String middlenameja,
			@RequestParam(required = false) String lastnameja, @RequestParam(required = false) String fullnameja,
			@RequestParam(required = false) String shortnameja, @RequestParam(required = false) String datebirthja,
			@RequestParam(required = false) String mobilenoja, @RequestParam(required = false) String passnoja,
			@RequestParam(required = false) String nationalidja, @RequestParam(required = false) String firstnameja,
			@RequestParam(required = false) String cons_name, @RequestParam(required = false) String cor_name,
			@RequestParam(required = false) String trade_name, @RequestParam(required = false) String cer_od_incop,
			@RequestParam(required = false) String buss_ref_no, @RequestParam(required = false) String doi,
			@RequestParam(required = false) String pbn, @RequestParam(required = false) String lno,
			@RequestParam(required = false) String fn, @RequestParam(required = false) String email,
			@RequestParam(required = false) String website, @RequestParam(required = false) String branchid,
			@RequestParam(required = false) String branchdesc, @RequestParam(required = false) String accType,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) Integer ls,
			@RequestParam(required = false) String count, @RequestParam(required = false) String noofpersons, Model md,
			HttpServletRequest req, @RequestParam(required = false) String act,
			@RequestParam(required = false) String unique_id,
			@RequestParam(required = false) String dataURL) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String BRANCH_ID = (String) req.getSession().getAttribute("BRANCH_ID");
		String BRANCH_DESC = (String) req.getSession().getAttribute("BRANCH_DESC");
		Date TRANDATE = (Date) req.getSession().getAttribute("TRANDATE");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(TRANDATE);
		System.out.println(unique_id+"unique_idunique_id");
		System.out.println(formattedDate);
		md.addAttribute("userid", userid);
		md.addAttribute("sess_branch_id", BRANCH_ID);
		md.addAttribute("sess_branch_desc", BRANCH_DESC);
		md.addAttribute("date", new Date());
		md.addAttribute("tran_date", TRANDATE);
		/*
		 * if (formmode == null || formmode.equals("list")) {
		 * md.addAttribute("formmode", "list"); }
		 */ if (formmode == null || formmode.equals("add")) {
			md.addAttribute("formmode", "add");
			String arnNo = "ARN0" + minimalDataRepository.ARNNO();
			System.out.println(arnNo + "yyyyyyyy");
			md.addAttribute("appreNO", arnNo);
			md.addAttribute("count", count);
			md.addAttribute("ls", ls);
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistformval", minimalDataRepository.findByapplref(ApprefNO));
			System.out.println("////////////////////////" + minimalDataRepository.findByapplrefcount(ApprefNO));
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(ApprefNO));
			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
			md.addAttribute("TRANDATE", TRANDATE);
			
			Integer dd = Integer.valueOf(minimalDataRepository.ARNNO());
			int ff = dd - 1;
			String arnNo = "ARN0" + ff;
			md.addAttribute("appreNO", arnNo);
			System.out.println("APPLREFNO " + arnNo);
			System.out.println("dataURL " + dataURL);
			String cifId = minimalDataRepository.getCifId();
			String CifReference;

			if (cifId != null) {
				// Increment the number and ensure it stays in the same length format
				int nextCifId = Integer.parseInt(cifId) + 1;
				CifReference = "CUST" + String.format("%09d", nextCifId); // Ensures 9 digits with leading zeros
			} else {
				CifReference = "CUST00000100"; // Initial value if cifId is null
			}

			md.addAttribute("CifId", CifReference);
			System.out.println("CIFID " + CifReference);
			md.addAttribute("ApplRefNO", arnNo);
			md.addAttribute("dataURL", dataURL);
			unique = unique_id;
			System.out.println(unique+"uniqueunique");
			md.addAttribute("unique_id", unique);
			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getScheme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			// md.addAttribute("DocumentType", reference_code_Rep.getRefCode("DOC1"));
			md.addAttribute("DocumentType", reference_code_Rep.getdoctype());

			noofpersons = getSessionAttribute(req, "noofpersons");
			accType = getSessionAttribute(req, "accType");
			branchid = getSessionAttribute(req, "branchid");
			branchdesc = getSessionAttribute(req, "branchdesc");
			firstname = getSessionAttribute(req, "firstname");
			middlename = getSessionAttribute(req, "middlename");
			lastname = getSessionAttribute(req, "lastname");
			fullname = getSessionAttribute(req, "fullname");
			shortname = getSessionAttribute(req, "shortname");
			datebirth = getSessionAttribute(req, "datebirth");
			mobileno = getSessionAttribute(req, "mobileno");
			passno = getSessionAttribute(req, "passno");
			nationalid = getSessionAttribute(req, "nationalid");
			generateAndAddCifIds(md, noofpersons);
			// Add parameters to the model
			md.addAttribute("noofpers", noofpersons);
			md.addAttribute("Acc_Type", accType);
			System.out.println("ACCOUNT DETAILS " + accType);
			md.addAttribute("FirstName", firstname);
			md.addAttribute("MiddleName", middlename);
			md.addAttribute("BranchId", branchid);
			md.addAttribute("BranchDesc", branchdesc);
			md.addAttribute("LastName", lastname);
			md.addAttribute("FullName", fullname);
			md.addAttribute("ShortName", shortname);
			md.addAttribute("DateBirth", datebirth);
			md.addAttribute("Mobileno", mobileno);
			md.addAttribute("PassNo", passno);
			md.addAttribute("NationalId", nationalid);

			// md.addAttribute("listact", td_defn_Repo.getactList(act));
		} else if (formmode.equals("hold")) {

			System.out.println(formmode);
			md.addAttribute("formmode", "hold");
		} else if (formmode.equals("view")) {

			System.out.println(formmode);
			md.addAttribute("formmode", "view");
		} else if (formmode.equals("corporate")) {

			md.addAttribute("formmode", "corporate");
			Integer dd = Integer.valueOf(minimalDataRepository.ARNNO());
			int ff = dd - 1;
			String arnNo = "ARN0" + ff;
			md.addAttribute("appreNO", arnNo);
			System.out.println("APPLREFNO " + arnNo);

			md.addAttribute("ApplRefNO", arnNo);

			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getSchme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			md.addAttribute("DocumentType", reference_code_Rep.getdoctype());
			// for getseesion
			noofpersons = getSessionAttribute(req, "noofpersons");
			cons_name = getSessionAttribute(req, "cons_name");
			cor_name = getSessionAttribute(req, "cor_name");
			trade_name = getSessionAttribute(req, "trade_name");
			cer_od_incop = getSessionAttribute(req, "cer_od_incop");
			buss_ref_no = getSessionAttribute(req, "buss_ref_no");
			doi = getSessionAttribute(req, "doi");
			pbn = getSessionAttribute(req, "pbn");
			lno = getSessionAttribute(req, "lno");
			fn = getSessionAttribute(req, "fn");
			email = getSessionAttribute(req, "email");
			website = getSessionAttribute(req, "website");
			branchid = getSessionAttribute(req, "branchid");
			branchdesc = getSessionAttribute(req, "branchdesc");
			// Add parameters to the model

			generateAndAddCifIds(md, noofpersons);
//LEASE ACCOUNT

			// String LA_C = "LA" + bACP_CUS_PROFILE_REPO.GetLEASE_ACCOUNT_COR();
			md.addAttribute("noofpers", noofpersons);
			md.addAttribute("cons_name", cons_name);
			md.addAttribute("cor_name", cor_name);
			md.addAttribute("trade_name", trade_name);
			md.addAttribute("cer_od_incop", cer_od_incop);
			md.addAttribute("buss_ref_no", buss_ref_no);
			md.addAttribute("doi", doi);
			md.addAttribute("pbn", pbn);
			md.addAttribute("lno", lno);
			md.addAttribute("fn", fn);
			md.addAttribute("email", email);
			md.addAttribute("website", website);
			md.addAttribute("BranchId", branchid);
			md.addAttribute("BranchDesc", branchdesc);
		}else if (formmode.equals("smspopup")) {
			md.addAttribute("formmode", "smspopup");
		}
		return "CustomerOnboarding.html";
	}

	@RequestMapping(value = "CustomerAccountCor")
	public String CustomerAccountCor(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String cons_name, @RequestParam(required = false) String cor_name,
			@RequestParam(required = false) String trade_name, @RequestParam(required = false) String cer_od_incop,
			@RequestParam(required = false) String buss_ref_no, @RequestParam(required = false) String doi,
			@RequestParam(required = false) String pbn, @RequestParam(required = false) String lno,
			@RequestParam(required = false) String fn, @RequestParam(required = false) String email,
			@RequestParam(required = false) String website, @RequestParam(required = false) String branchid,
			@RequestParam(required = false) String branchdesc, @RequestParam(required = false) String accType,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) Integer ls,
			@RequestParam(required = false) String count, @RequestParam(required = false) String noofpersons, Model md,
			HttpServletRequest req, @RequestParam(required = false) String act) {

		String userid = (String) req.getSession().getAttribute("USERID");
		String BRANCH_ID = (String) req.getSession().getAttribute("BRANCH_ID");
		String BRANCH_DESC = (String) req.getSession().getAttribute("BRANCH_DESC");
		Date TRANDATE = (Date) req.getSession().getAttribute("TRANDATE");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		md.addAttribute("userid", userid);
		md.addAttribute("sess_branch_id", BRANCH_ID);
		md.addAttribute("sess_branch_desc", BRANCH_DESC);
		md.addAttribute("date", new Date());
		md.addAttribute("TRANDATE", TRANDATE);
		System.out.println(TRANDATE);

		if (formmode.equals("corporate")) {

			md.addAttribute("formmode", "corporate");
			Integer dd = Integer.valueOf(minimalDataRepository.ARNNO());
			int ff = dd - 1;
			String arnNo = "ARN0" + ff;
			md.addAttribute("appreNO", arnNo);
			System.out.println("APPLREFNO " + arnNo);

			md.addAttribute("ApplRefNO", arnNo);

			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getSchme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			md.addAttribute("DocumentType", reference_code_Rep.getdoctype());
			// for getseesion
			noofpersons = getSessionAttribute(req, "noofpersons");
			cons_name = getSessionAttribute(req, "cons_name");
			cor_name = getSessionAttribute(req, "cor_name");
			trade_name = getSessionAttribute(req, "trade_name");
			cer_od_incop = getSessionAttribute(req, "cer_od_incop");
			buss_ref_no = getSessionAttribute(req, "buss_ref_no");
			doi = getSessionAttribute(req, "doi");
			pbn = getSessionAttribute(req, "pbn");
			lno = getSessionAttribute(req, "lno");
			fn = getSessionAttribute(req, "fn");
			email = getSessionAttribute(req, "email");
			website = getSessionAttribute(req, "website");
			branchid = getSessionAttribute(req, "branchid");
			branchdesc = getSessionAttribute(req, "branchdesc");
			// Add parameters to the model

			generateAndAddCifIds(md, noofpersons);
//LEASE ACCOUNT

			// String LA_C = "LA" + bACP_CUS_PROFILE_REPO.GetLEASE_ACCOUNT_COR();
			md.addAttribute("noofpers", noofpersons);
			md.addAttribute("cons_name", cons_name);
			md.addAttribute("cor_name", cor_name);
			md.addAttribute("trade_name", trade_name);
			md.addAttribute("cer_od_incop", cer_od_incop);
			md.addAttribute("buss_ref_no", buss_ref_no);
			md.addAttribute("doi", doi);
			md.addAttribute("pbn", pbn);
			md.addAttribute("lno", lno);
			md.addAttribute("fn", fn);
			md.addAttribute("email", email);
			md.addAttribute("website", website);
			md.addAttribute("BranchId", branchid);
			md.addAttribute("BranchDesc", branchdesc);
		}
		return "BACP/CustomerAccountCor.html";
	}

	@RequestMapping(value = "CustomerJoint")
	public String CustomerJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String firstname, @RequestParam(required = false) String middlename,
			@RequestParam(required = false) String lastname, @RequestParam(required = false) String fullname,
			@RequestParam(required = false) String shortname, @RequestParam(required = false) String datebirth,
			@RequestParam(required = false) String mobileno, @RequestParam(required = false) String passno,
			@RequestParam(required = false) String nationalid, @RequestParam(required = false) String middlenameja,
			@RequestParam(required = false) String lastnameja, @RequestParam(required = false) String fullnameja,
			@RequestParam(required = false) String shortnameja, @RequestParam(required = false) String datebirthja,
			@RequestParam(required = false) String mobilenoja, @RequestParam(required = false) String passnoja,
			@RequestParam(required = false) String nationalidja, @RequestParam(required = false) String firstnameja,
			@RequestParam(required = false) String cons_name, @RequestParam(required = false) String cor_name,
			@RequestParam(required = false) String trade_name, @RequestParam(required = false) String cer_od_incop,
			@RequestParam(required = false) String buss_ref_no, @RequestParam(required = false) String doi,
			@RequestParam(required = false) String pbn, @RequestParam(required = false) String lno,
			@RequestParam(required = false) String fn, @RequestParam(required = false) String email,
			@RequestParam(required = false) String website, @RequestParam(required = false) String branchid,
			@RequestParam(required = false) String branchdesc, @RequestParam(required = false) String accType,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) Integer ls,
			@RequestParam(required = false) String count, @RequestParam(required = false) String noofpersons, Model md,
			HttpServletRequest req, @RequestParam(required = false) String act) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("userid", userid);
		md.addAttribute("date", new Date());
		Date TRANDATE = (Date) req.getSession().getAttribute("TRANDATE");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(TRANDATE);
		md.addAttribute("tran_date", TRANDATE);

		if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
			md.addAttribute("TRANDATE", TRANDATE);
			Integer dd = Integer.valueOf(minimalDataRepository.ARNNO());
			int ff = dd - 1;
			String arnNo = "ARN0" + ff;
			md.addAttribute("appreNO", arnNo);
			System.out.println("APPLREFNO " + arnNo);

			String cifId = minimalDataRepository.getCifId();
			String CifReference;

			if (cifId != null) {
				// Increment the number and ensure it stays in the same length format
				int nextCifId = Integer.parseInt(cifId) + 1;
				CifReference = "CUST" + String.format("%09d", nextCifId); // Ensures 9 digits with leading zeros
			} else {
				CifReference = "CUST00000100"; // Initial value if cifId is null
			}

			md.addAttribute("CifId", CifReference);
			System.out.println("CIFID " + CifReference);
			md.addAttribute("ApplRefNO", arnNo);
			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getScheme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			// md.addAttribute("DocumentType", reference_code_Rep.getRefCode("DOC1"));
			md.addAttribute("DocumentType", reference_code_Rep.getdoctype());

			noofpersons = getSessionAttribute(req, "noofpersons");
			accType = getSessionAttribute(req, "accType");
			branchid = getSessionAttribute(req, "branchid");
			branchdesc = getSessionAttribute(req, "branchdesc");
			firstname = getSessionAttribute(req, "firstname");
			middlename = getSessionAttribute(req, "middlename");
			lastname = getSessionAttribute(req, "lastname");
			fullname = getSessionAttribute(req, "fullname");
			shortname = getSessionAttribute(req, "shortname");
			datebirth = getSessionAttribute(req, "datebirth");
			mobileno = getSessionAttribute(req, "mobileno");
			passno = getSessionAttribute(req, "passno");
			nationalid = getSessionAttribute(req, "nationalid");
			generateAndAddCifIds(md, noofpersons);
			// Add parameters to the model
			md.addAttribute("noofpers", noofpersons);
			md.addAttribute("Acc_Type", accType);
			System.out.println("ACCOUNT DETAILS " + accType);
			md.addAttribute("FirstName", firstname);
			md.addAttribute("MiddleName", middlename);
			md.addAttribute("BranchId", branchid);
			md.addAttribute("BranchDesc", branchdesc);
			md.addAttribute("LastName", lastname);
			md.addAttribute("FullName", fullname);
			md.addAttribute("ShortName", shortname);
			md.addAttribute("DateBirth", datebirth);
			md.addAttribute("Mobileno", mobileno);
			md.addAttribute("PassNo", passno);
			md.addAttribute("NationalId", nationalid);

			// md.addAttribute("listact", td_defn_Repo.getactList(act));
		} else if (formmode.equals("hold")) {

			System.out.println(formmode);
			md.addAttribute("formmode", "hold");
		} else if (formmode.equals("view")) {

			System.out.println(formmode);
			md.addAttribute("formmode", "view");
		} else if (formmode.equals("corporate")) {

			md.addAttribute("formmode", "corporate");
			Integer dd = Integer.valueOf(minimalDataRepository.ARNNO());
			int ff = dd - 1;
			String arnNo = "ARN0" + ff;
			md.addAttribute("appreNO", arnNo);
			System.out.println("APPLREFNO " + arnNo);

			md.addAttribute("ApplRefNO", arnNo);

			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getSchme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			md.addAttribute("DocumentType", reference_code_Rep.getdoctype());
			// for getseesion
			noofpersons = getSessionAttribute(req, "noofpersons");
			cons_name = getSessionAttribute(req, "cons_name");
			cor_name = getSessionAttribute(req, "cor_name");
			trade_name = getSessionAttribute(req, "trade_name");
			cer_od_incop = getSessionAttribute(req, "cer_od_incop");
			buss_ref_no = getSessionAttribute(req, "buss_ref_no");
			doi = getSessionAttribute(req, "doi");
			pbn = getSessionAttribute(req, "pbn");
			lno = getSessionAttribute(req, "lno");
			fn = getSessionAttribute(req, "fn");
			email = getSessionAttribute(req, "email");
			website = getSessionAttribute(req, "website");
			branchid = getSessionAttribute(req, "branchid");
			branchdesc = getSessionAttribute(req, "branchdesc");
			// Add parameters to the model

			generateAndAddCifIds(md, noofpersons);

			md.addAttribute("noofpers", noofpersons);
			md.addAttribute("cons_name", cons_name);
			md.addAttribute("cor_name", cor_name);
			md.addAttribute("trade_name", trade_name);
			md.addAttribute("cer_od_incop", cer_od_incop);
			md.addAttribute("buss_ref_no", buss_ref_no);
			md.addAttribute("doi", doi);
			md.addAttribute("pbn", pbn);
			md.addAttribute("lno", lno);
			md.addAttribute("fn", fn);
			md.addAttribute("email", email);
			md.addAttribute("website", website);
			md.addAttribute("BranchId", branchid);
			md.addAttribute("BranchDesc", branchdesc);
		}
		return "BACP/CustomerJointAcc.html";
	}

	@RequestMapping(value = "CustomerSummary")
	public String CustomerSummary(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String numberElement, Model md, HttpServletRequest req) {
		System.out.println();
		if (formmode == null || formmode.equals("viewcorp")) {
			md.addAttribute("formmode", "viewcorp");
			System.out.println("document list" + ApprefNO);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", numberElement);
			md.addAttribute("appl_ref_no", ApprefNO);
			md.addAttribute("DocumentList", bacpRep.findByAppl(ApprefNO));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(ApprefNO));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));
		} else if (formmode.equals("view1")) {
			md.addAttribute("formmode", "view1");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO));
		}
		return "BACP/CustomerSummary.html";
	}

	public void generateAndAddCifIds(Model md, String noofpersons) {
		// Convert noofpersons to an integer
		int noOfPersons;
		try {
			noOfPersons = Integer.parseInt(noofpersons);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid number of persons: " + noofpersons, e);
		}

		// Fetch existing CIF IDs from the database
		List<String[]> existingCifIds = bACP_CUS_PROFILE_REPO.getExistingCifIds(Collections.emptyList());
		Set<String> existingCifIdSet = new HashSet<>();

		// Flatten the array and add existing CIF IDs to a set for quick lookup
		for (String[] cifArray : existingCifIds) {
			for (String cif : cifArray) {
				if (cif != null) {
					existingCifIdSet.add(cif);
				}
			}
		}

		List<String> generatedCifIds = new ArrayList<>();

		// Retrieve the base sequence value from the repository
		int baseSequenceValue = bACP_CUS_PROFILE_REPO.cif_id();

		// Start generating CIF IDs
		for (int i = 1; i <= noOfPersons; i++) {
			int newSuffix = i; // Increment based on the loop
			String cifReference = String.format("CUST%08d%02d", baseSequenceValue, newSuffix);

			// Ensure the new CIF ID is unique
			while (existingCifIdSet.contains(cifReference)) {
				newSuffix++;
				cifReference = String.format("CUST%08d%02d", baseSequenceValue, newSuffix);
			}

			// Add the unique CIF ID to the model attributes and the existing CIF ID set
			generatedCifIds.add(cifReference);
			existingCifIdSet.add(cifReference);
			md.addAttribute("cifid_" + i, cifReference);
			System.out.println("CIFID " + i + ": " + cifReference);
		}
	}

	@RequestMapping(value = "ParameterAdd", method = RequestMethod.POST)
	@ResponseBody
	public String Parameter(@RequestParam("formmode") String formmode, @ModelAttribute ParametersDetails parametersde,
			Model md, HttpServletRequest rq) {
		System.out.println("createParameter" + parametersde.getCheck_list());

		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = customerDetailsService.addAlert(parametersde, formmode, userid);

		return msg;

	}

	@RequestMapping(value = "Parameter", method = { RequestMethod.GET, RequestMethod.POST })
	public String Parameters(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String refnumber,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req,
			String Sort, String acct_open_form, String acc_temp, String cus_temp) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		Date TRANDATE = (Date) req.getSession().getAttribute("TRANDATE");

// String loginuserid = (String) req.getSession().getAttribute("USERID");
// Logging Navigation
// loginServices.SessionLogging("USERPROFILE", "M2", req.getSession().getId(),
// loginuserid, req.getRemoteAddr(),
// "ACTIVE");

		if (formmode == null || formmode.equals("list")) {
			System.out.println("Value=======================>>> " + refnumber);
			md.addAttribute("OtherServices", parameterrep.listofvalue());
			md.addAttribute("menu", "AMLCustomerKYC");
			md.addAttribute("menuname", "CustomerKYC");
			md.addAttribute("formmode", "list"); // to set which form - valid values are "edit" , "add" & "list"
			// md.addAttribute("CustomerKYC",CMGrepository.findAll(PageRequest.of(currentPage,
			// pageSize)));

		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", "add");
			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getSchme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("gl_code", reference_code_Rep.getGL_CODE());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			md.addAttribute("curr", reference_code_Rep.getCurr());
			md.addAttribute("multi_curr", reference_code_Rep.getMulti_Curr());
			md.addAttribute("userId", userProfileRep.getUserId());

			String paramRef = parameterrep.getParamRef();
			String ParamReference;
			if (paramRef != null) {
				ParamReference = "REF" + (Integer.valueOf(paramRef) + 1);
			} else {
				ParamReference = "REF1";
			}
			md.addAttribute("ParamRef", ParamReference);
			System.out.println("PARAM " + ParamReference);

		} else if (formmode.equals("workflow")) {
			md.addAttribute("formmode", "workflow");
			md.addAttribute("acc_temp", acc_temp);
			md.addAttribute("userId", userId);
		} else if (formmode.equals("view")) {
			md.addAttribute("formmode", formmode);

			md.addAttribute("formmode", "view");
			System.out.println("Value========>>>" + refnumber);
			md.addAttribute("OtherServicess", parameterrep.findbyId(refnumber));
			md.addAttribute("parameterslist", parameterrep.findAll());
			ParametersDetails check = parameterrep.findbyId(refnumber);

			String checklist = check.getCheck_list();
			List<String> valuesList = checklist != null ? Arrays.asList(checklist.split(",")) : new ArrayList<>();
			md.addAttribute("valuesList", valuesList);

			// Check and split the approval values
			String appr1 = check.getApproval1();
			List<String> valappr1 = appr1 != null ? Arrays.asList(appr1.split(",")) : new ArrayList<>();
			md.addAttribute("appr1", valappr1);

			String appr2 = check.getApproval2();
			List<String> valappr2 = appr2 != null ? Arrays.asList(appr2.split(",")) : new ArrayList<>();
			md.addAttribute("appr2", valappr2);

			String appr3 = check.getApproval3();
			List<String> valappr3 = appr3 != null ? Arrays.asList(appr3.split(",")) : new ArrayList<>();
			md.addAttribute("appr3", valappr3);

			// Check and split the alert values
			String alr1 = check.getAlert1();
			List<String> valalr1 = alr1 != null ? Arrays.asList(alr1.split(",")) : new ArrayList<>();
			md.addAttribute("alr1", valalr1);

			String alr2 = check.getAlert2();
			List<String> valalr2 = alr2 != null ? Arrays.asList(alr2.split(",")) : new ArrayList<>();
			md.addAttribute("alr2", valalr2);

			String alr3 = check.getAlert3();
			List<String> valalr3 = alr3 != null ? Arrays.asList(alr3.split(",")) : new ArrayList<>();
			md.addAttribute("alr3", valalr3);

		} else if (formmode.equals("verify")) {
			md.addAttribute("formmode", formmode);

			md.addAttribute("formmode", "verify");
			System.out.println("Value========>>>" + refnumber);
			md.addAttribute("OtherServicess", parameterrep.findbyId(refnumber));
			md.addAttribute("parameterslist", parameterrep.findAll());
			// for check list
			ParametersDetails check = parameterrep.findbyId(refnumber);

			String checklist = check.getCheck_list();
			List<String> valuesList = checklist != null ? Arrays.asList(checklist.split(",")) : new ArrayList<>();
			md.addAttribute("valuesList", valuesList);

			// Check and split the approval values
			String appr1 = check.getApproval1();
			List<String> valappr1 = appr1 != null ? Arrays.asList(appr1.split(",")) : new ArrayList<>();
			md.addAttribute("appr1", valappr1);

			String appr2 = check.getApproval2();
			List<String> valappr2 = appr2 != null ? Arrays.asList(appr2.split(",")) : new ArrayList<>();
			md.addAttribute("appr2", valappr2);

			String appr3 = check.getApproval3();
			List<String> valappr3 = appr3 != null ? Arrays.asList(appr3.split(",")) : new ArrayList<>();
			md.addAttribute("appr3", valappr3);

			// Check and split the alert values
			String alr1 = check.getAlert1();
			List<String> valalr1 = alr1 != null ? Arrays.asList(alr1.split(",")) : new ArrayList<>();
			md.addAttribute("alr1", valalr1);

			String alr2 = check.getAlert2();
			List<String> valalr2 = alr2 != null ? Arrays.asList(alr2.split(",")) : new ArrayList<>();
			md.addAttribute("alr2", valalr2);

			String alr3 = check.getAlert3();
			List<String> valalr3 = alr3 != null ? Arrays.asList(alr3.split(",")) : new ArrayList<>();
			md.addAttribute("alr3", valalr3);

			md.addAttribute("userId", userId);

		} else if (formmode.equals("new")) {
			md.addAttribute("formmode", "new");
			md.addAttribute("acc_temp", acc_temp);
			md.addAttribute("tran_date", TRANDATE);
			md.addAttribute("userId", userId);
		} else if (formmode.equals("move")) {
			md.addAttribute("formmode", "move");
			md.addAttribute("cus_temp", cus_temp);
			md.addAttribute("tran_date", TRANDATE);
			md.addAttribute("userId", userId);
		} else if (formmode.equals("with")) {
			md.addAttribute("formmode", "with");
			md.addAttribute("acct_open_form", acct_open_form);
			md.addAttribute("userId", userId);
		} else if (formmode.equals("modify")) {
			md.addAttribute("formmode", "modify");
			md.addAttribute("OtherServicess", parameterrep.findbyId(refnumber));
			md.addAttribute("parameterslist", parameterrep.findAll());
			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getSchme_Type());
			md.addAttribute("schme_code", reference_code_Rep.getSchme_Code());
			md.addAttribute("gl_code", reference_code_Rep.getGL_CODE());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			md.addAttribute("curr", reference_code_Rep.getCurr());
			md.addAttribute("multi_curr", reference_code_Rep.getMulti_Curr());
			// for check list
			// for check list
			ParametersDetails check = parameterrep.findbyId(refnumber);
			String checklist = check.getCheck_list();
			
			List<String> valuesList = checklist != null ? Arrays.asList(checklist.split(",")) : new ArrayList<>();
			md.addAttribute("valuesList", valuesList);

			// Check and split the approval values
			String appr1 = check.getApproval1();
			List<String> valappr1 = appr1 != null ? Arrays.asList(appr1.split(",")) : new ArrayList<>();
			md.addAttribute("appr1", valappr1);

			String appr2 = check.getApproval2();
			List<String> valappr2 = appr2 != null ? Arrays.asList(appr2.split(",")) : new ArrayList<>();
			md.addAttribute("appr2", valappr2);

			String appr3 = check.getApproval3();
			List<String> valappr3 = appr3 != null ? Arrays.asList(appr3.split(",")) : new ArrayList<>();
			md.addAttribute("appr3", valappr3);

			// Check and split the alert values
			String alr1 = check.getAlert1();
			List<String> valalr1 = alr1 != null ? Arrays.asList(alr1.split(",")) : new ArrayList<>();
			md.addAttribute("alr1", valalr1);

			String alr2 = check.getAlert2();
			List<String> valalr2 = alr2 != null ? Arrays.asList(alr2.split(",")) : new ArrayList<>();
			md.addAttribute("alr2", valalr2);

			String alr3 = check.getAlert3();
			List<String> valalr3 = alr3 != null ? Arrays.asList(alr3.split(",")) : new ArrayList<>();
			md.addAttribute("alr3", valalr3);
		}

// to set which form - valid values are "edit" , "add" & "list"
// md.addAttribute("CustomerKYC",
// CMGrepository.findAll(PageRequest.of(currentPage, pageSize)));

		md.addAttribute("riskmgntflag", "riskmgntflag");
		md.addAttribute("riskcatflag", "riskcatflag");

		return "BACP/PARAMETER";
	}

	@RequestMapping(value = "getBranchDetails", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getBranchDetails(@RequestParam(required = false) String sol_id) throws IOException, SQLException {
		System.out.println("Sol ID " + sol_id);
		return reference_code_Rep.getbranchDesc(sol_id);
	}

	@RequestMapping(value = "getSchemeDetails", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getSchemeDetails(@RequestParam(required = false) String schemetype)
			throws IOException, SQLException {
		System.out.println("schemetype " + schemetype);
		return reference_code_Rep.getscheme(schemetype);
	}

	@RequestMapping(value = "getglshCode", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getglshCode(@RequestParam(required = false) String glsh) throws IOException, SQLException {
		System.out.println("glsh" + glsh);
		return reference_code_Rep.getbranchDesc(glsh);
	}

	/*
	 * @RequestMapping(value = "Approval") public String
	 * Approval(@RequestParam(required = false) String formmode, Model md,
	 * HttpServletRequest req) { if (formmode == null || formmode.equals("list")) {
	 * md.addAttribute("formmode", "list"); } else if (formmode.equals("add")) {
	 * md.addAttribute("formmode", "add"); } else if (formmode.equals("proceed")) {
	 * md.addAttribute("formmode", "proceed"); } return "BACP/Approval.html"; }
	 */

	@RequestMapping(value = "Compliancekyc", method = RequestMethod.POST)
	@ResponseBody
	public String Compliancekyc(Model md, HttpServletRequest rq, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String rec_no, @ModelAttribute CustomerRequest custReq,
			@RequestParam(required = false) String comp_date, @RequestParam(required = false) String comp_genremarks,
			@RequestParam(required = false) String comp_sign, @RequestParam(required = false) String comp_photo,
			@RequestParam(required = false) String comp_document,
			@RequestParam(required = false) String comp_customerdetail,
			@RequestParam(required = false) String account_detail_comp) {
		System.out.println("date" + comp_date);
		System.out.println("remarks" + comp_genremarks);
		System.out.println("sign" + comp_sign);
		System.out.println("photo" + comp_photo);
		System.out.println("document" + comp_document);
		System.out.println("customerdet" + comp_customerdetail);
		System.out.println("accountdet" + account_detail_comp);
		String userId = (String) rq.getSession().getAttribute("USERID");
		CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);

		up.setKyc_flg("Y");
		up.setComp_remarks(comp_genremarks);
		up.setComp_accountdetails(account_detail_comp);
		up.setComp_customerdetails(comp_customerdetail);
		up.setComp_document(comp_document);
		up.setComp_signature(comp_sign);
		up.setComp_verify_user(userId);
		up.setComp_verify_date(new Date());

		bACP_CUS_PROFILE_REPO.save(up);

		String msg = "KYC Compliance Successfull for Reference No:" + ApprefNO;

		return msg;

	}

	@RequestMapping(value = "complianceForKyc")
	public String complianceForKyc(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req,
			@RequestParam(required = false) String appl_ref_no) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("kyc", bACP_CUS_PROFILE_REPO.getkyclist());
		} else if (formmode.equals("view")) {
			md.addAttribute("formmode", "view");
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		}
		return "BACP/ComplianceForKyc.html";
	}

	/*
	 * @RequestMapping(value = "ComplianceForKycJoint") public String
	 * ComplianceForKycJoint(@RequestParam(required = false) String formmode, Model
	 * md, HttpServletRequest req,
	 * 
	 * @RequestParam(required = false) String appl_ref_no) { if (formmode == null ||
	 * formmode.equals("viewJoint")) { md.addAttribute("formmode", "viewJoint");
	 * md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
	 * md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
	 * 
	 * CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
	 * String AccountNO = CifId.getLa_loan_accountno();
	 * md.addAttribute("loanDetails",
	 * lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
	 * md.addAttribute("paymentDetails",
	 * noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
	 * 
	 * String AccountNO1 = CifId.getTd_deposit_accountno();
	 * md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));
	 * 
	 * } else if (formmode.equals("proceed")) { md.addAttribute("formmode",
	 * "proceed"); } return "BACP/ComplianceForKycJoint.html"; }
	 */

	@RequestMapping(value = "ComplianceForKycJoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String ComplianceForKycJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("viewJoint")) {

			md.addAttribute("formmode", "viewJoint");
			md.addAttribute("UserId", userId);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + "  REJECTED  ";
		}
		System.out.println("4");
		return "BACP/ComplianceForKycJoint.html";
	}

	@RequestMapping(value = "complianceForKycCorp")
	public String complianceForKycCorp(@RequestParam(required = false) String formmode, Model md,
			HttpServletRequest req, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg) {
		if (formmode.equals("viewcorp")) {
			md.addAttribute("formmode", "viewcorp");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		}
		return "BACP/ComplianceForKycCorp.html";
	}

	@RequestMapping(value = "HoldandReject")
	public String HoldandReject(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req,
			@RequestParam(required = false) String appl_ref_no) {
		/*
		 * if (formmode == null || formmode.equals("list")) {
		 * md.addAttribute("formmode", "list"); md.addAttribute("HoldandReject",);
		 */
		if (formmode == null || formmode.equals("list")) {
			System.out.println("HI");
			// md.addAttribute("HoldandReject", bACP_CUS_PROFILE_REPO.getCSlist1());
			md.addAttribute("HoldandReject", bACP_CUS_PROFILE_REPO.findholdandrejectlist());
			System.out.println(bACP_CUS_PROFILE_REPO.getCSlist1());
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("view")) {
			System.out.println("HI");
			md.addAttribute("formmode", "view");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getuser(appl_ref_no));
		
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		}
		return "BACP/HoldandReject.html";
	}

	@RequestMapping(value = "HoldRejectJoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String HoldRejectJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("viewJoint")) {

			md.addAttribute("formmode", "viewJoint");
			md.addAttribute("UserId", userId);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/HoldRejectJoint.html";
	}

	@RequestMapping(value = "HoldRejectCorporate")
	public String HoldRejectCorporate(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String rec_no) {
		/*
		 * if (formmode == null || formmode.equals("list")) {
		 * md.addAttribute("formmode", "list"); md.addAttribute("HoldandReject",);
		 */
		if (formmode.equals("viewcorp")) {
			System.out.println(appl_ref_no + "ApprefNOApprefNOApprefNOApprefNOApprefNO");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			System.out.println("HI");
			md.addAttribute("formmode", "viewcorp");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		}
		return "BACP/HoldRejectCorporate.html";
	}

	@RequestMapping(value = "CustInquiries")
	public String CustInquiries(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", "add");
		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		}
		return "BACP/CustInquiries.html";
	}

	@RequestMapping(value = "CustomerDetailsCorrection", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerDetailsCorrection(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String valuedoctype, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) String valuedoccode, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String rec_no, @RequestParam(required = false) String valuedocdesc,
			@RequestParam(required = false) String msg,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {
		System.out.println("doctype" + valuedoctype);

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));

		String loginuserid = (String) req.getSession().getAttribute("USERID");
		// Logging Navigation
		// loginServices.SessionLogging("USERPROFILE", "M2", req.getSession().getId(),
		// loginuserid, req.getRemoteAddr(),
		// "ACTIVE");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("list")) {
			System.out.println("HI");
			md.addAttribute("HoldandReject", bACP_CUS_PROFILE_REPO.getcustlist());
			System.out.println(bACP_CUS_PROFILE_REPO.getCSlist1());
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("view")) {
			System.out.println("HI");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getuser(appl_ref_no));
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("formmode", "view");

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));
		} else if (formmode.equals("view1")) {

			md.addAttribute("formmode", formmode);
			// md.addAttribute("domains", reportServices.getDomainList());
			// md.addAttribute("FinUserProfiles", userProfileDao.getFinUsersList());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			com.bornfire.entities.CustomerRequest val = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			System.out.println(val.getCa_currency());
			System.out.println("34");

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to Hold List ";

		} else if (formmode.equals("edit")) {
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("HoldRejview", bACP_CUS_PROFILE_REPO.getuser(appl_ref_no));
			md.addAttribute("formmode", formmode);
			md.addAttribute("branch_id", reference_code_Rep.getBranch_Id());
			md.addAttribute("schme_type", reference_code_Rep.getScheme_Type());
			md.addAttribute("glsh", reference_code_Rep.getGLSH());
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			System.out.println("34");

		}
		md.addAttribute("adminflag", "adminflag");
		md.addAttribute("userprofileflag", "userprofileflag");
		System.out.println("4");
		return "BACP/CustomerDetailsCorrection.html";
	}

	@RequestMapping(value = "CustomerCorrectionJoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerCorrectionJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("viewJoint")) {

			md.addAttribute("formmode", "viewJoint");
			md.addAttribute("UserId", userId);
			// md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		} else if (formmode.equals("edit")) {

			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("formmode", formmode);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("UserId", userId);

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		}
		System.out.println("4");
		return "BACP/CustomerCorrectionJoint.html";
	}

	@RequestMapping(value = "CustomerRequest")
	public String CustomerRequest(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", "add");
		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		}
		return "BACP/CustomerRequest.html";
	}

	@RequestMapping(value = "CustomerProfile")
	public String CustomerProfile(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String numberElement, Model md, HttpServletRequest req) {
		System.out.println();
		if (formmode == null || formmode.equals("view")) {
			md.addAttribute("formmode", "view");
			md.addAttribute("DocumentList", bacpRep.findByAppl(ApprefNO));
			System.out.println("document list" + ApprefNO);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", numberElement);
			md.addAttribute("appl_ref_no", ApprefNO);
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(ApprefNO));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(ApprefNO));
		} else if (formmode.equals("view1")) {
			md.addAttribute("formmode", "view1");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO));
		} else if (formmode.equals("viewcorp")) {
			md.addAttribute("formmode", "viewcorp");
			System.out.println("document list" + ApprefNO);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", numberElement);
			md.addAttribute("appl_ref_no", ApprefNO);
			md.addAttribute("DocumentList", bacpRep.findByAppl(ApprefNO));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(ApprefNO));

		}
		return "BACP/CustomerProfile.html";
	}

	@RequestMapping(value = "personalDetail", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String personalDetail(@RequestParam(required = false) String refnumber, Model md, HttpServletRequest rq,
			String rec_no, CustomerRequest CustomerRequest) {
		String userId = (String) rq.getSession().getAttribute("USERID");
		String msg = customerRequestService.personalDetail(CustomerRequest, refnumber, rec_no, userId);
		return msg;

	}

	@RequestMapping(value = "personalDetailForEdit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String personalDetailForEdit(@RequestParam(required = false) String refnumber, Model md,
			HttpServletRequest rq, String rec_no, CustomerRequest CustomerRequest) {
		String userId = (String) rq.getSession().getAttribute("USERID");

		String msg = customerRequestService.personalDetailForEdit(CustomerRequest, refnumber, rec_no, userId);
		return msg;

	}

	@RequestMapping(value = "AccountDetailNxt", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String AccountDetailNxt(@RequestParam(required = false) String refnumber, Model md, HttpServletRequest rq,
			CustomerRequest CustomerRequest) {

		String msg = customerRequestService.AccountDetailNxt(CustomerRequest, refnumber);
		return msg;

	}

	@PostMapping(value = "/AddStudentss")
	@ResponseBody
	public String uploadSignatureAndPhoto(@RequestParam String appl_ref_no, @RequestParam String srcURL,
			@RequestParam String dataURL, @RequestParam String imgaccesscode, @RequestParam String group,
			@RequestParam String keyword, @RequestParam BigDecimal numberElement,
			@RequestParam(required = true) String cif_id) throws IOException, SQLException {

		String msg = customerDetailsService.minimalsign(appl_ref_no, srcURL, dataURL, imgaccesscode, group, keyword,
				numberElement, cif_id);

		return msg;
	}

	@RequestMapping(value = "/CheckDuplicateCor", method = { RequestMethod.GET })
	@ResponseBody
	public String Duplicatecheck(@RequestParam(required = false) String id,
			@RequestParam(required = false) String cor_name, @RequestParam(required = false) String cer_od_incop,
			@RequestParam(required = false) String buss_ref_no, @RequestParam(required = false) String lno) {
		System.out.println(cor_name + cer_od_incop + buss_ref_no + lno);
		StringBuilder msg = new StringBuilder();

		boolean duplicateFound = false;
		try {
			// Check for duplicate cor_name
			List<String> cor_name1 = bACP_DE_DUPRepo.getcor_nameList();
			if (cor_name1.contains(cor_name)) {
				duplicateFound = true;
				msg.append("CORPORATE NAME<span class='spaced1'>").append(cor_name).append("<span class='spaced11'>")
						.append(cor_name).append("<br>");
			}

			// Check for duplicate cer_od_incop
			List<String> cer_od_incop1 = bACP_DE_DUPRepo.findcer_od_incop();
			if (cer_od_incop1.contains(cer_od_incop)) {
				duplicateFound = true;
				msg.append("CERTIFICATE OF INCORPORATION<span class='spaced2'>").append(cer_od_incop)
						.append("<span class='spaced21'>").append(cer_od_incop).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> buss_ref_no1 = bACP_DE_DUPRepo.findbuss_ref_no();
			if (buss_ref_no1.contains(buss_ref_no)) {
				duplicateFound = true;
				msg.append("BUSINESS REGISTRATION NO<span class='spaced3'>").append(buss_ref_no)
						.append("<span class='spaced31'>").append(buss_ref_no).append("<br>");
			}

			// Check for duplicate lno
			List<String> lno1 = bACP_DE_DUPRepo.findlno();
			if (lno1.contains(lno)) {
				duplicateFound = true;
				msg.append("LAND LINE NO<span class='spaced4'>").append(lno).append("<span class='spaced41'>")
						.append(lno).append("<br>");
			}

			if (!duplicateFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@RequestMapping(value = "/CheckBlackListCor", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckBlackList(@RequestParam(required = false) String id,
			@RequestParam(required = false) String cor_name, @RequestParam(required = false) String cer_od_incop,
			@RequestParam(required = false) String buss_ref_no, @RequestParam(required = false) String lno) {
		System.out.println(cor_name + cer_od_incop + buss_ref_no + lno + "9334293342");
		StringBuilder msg = new StringBuilder();

		boolean BlackListFound = false;
		try {

			List<String> cor_name1 = bACP_BLACKLIST_Repo.getcor_nameList();
			if (cor_name1.contains(cor_name)) {
				BlackListFound = true;
				msg.append("CORPORATE NAME<span class='spaced1'>").append(cor_name).append("<span class='spaced11'>")
						.append(cor_name).append("<br>");
			}

			// Check for duplicate cer_od_incop
			List<String> cer_od_incop1 = bACP_BLACKLIST_Repo.findcer_od_incop();
			if (cer_od_incop1.contains(cer_od_incop)) {
				BlackListFound = true;
				msg.append("CERTIFICATE OF INCORPORATION<span class='spaced2'>").append(cer_od_incop)
						.append("<span class='spaced21'>").append(cer_od_incop).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> buss_ref_no1 = bACP_BLACKLIST_Repo.findbuss_ref_no();
			if (buss_ref_no1.contains(buss_ref_no)) {
				BlackListFound = true;
				msg.append("BUSINESS REGISTRATION NO<span class='spaced3'>").append(buss_ref_no)
						.append("<span class='spaced31'>").append(buss_ref_no).append("<br>");
			}

			// Check for duplicate lno
			List<String> lno1 = bACP_BLACKLIST_Repo.findlno();
			if (lno1.contains(lno)) {
				BlackListFound = true;
				msg.append("LAND LINE NO<span class='spaced4'>").append(lno).append("<span class='spaced41'>")
						.append(lno).append("<br>");
			}

			if (!BlackListFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString() + "CORPORATE");
		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@RequestMapping(value = "/CheckNegativeListCor", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckNegativeList(@RequestParam(required = false) String cor_name,
			@RequestParam(required = false) String cer_od_incop, @RequestParam(required = false) String buss_ref_no,
			@RequestParam(required = false) String lno) {
		System.out.println(cor_name + cer_od_incop + buss_ref_no + lno + "9334293342");
		StringBuilder msg = new StringBuilder();

		boolean NegativeListFound = false;
		try {

			List<String> cor_name1 = bACP_NEGATIVE_LIST_Repo.getcor_nameList();
			if (cor_name1.contains(cor_name)) {
				NegativeListFound = true;
				msg.append("CORPORATE NAME<span class='spaced1'>").append(cor_name).append("<span class='spaced11'>")
						.append(cor_name).append("<br>");
			}

			// Check for duplicate cer_od_incop
			List<String> cer_od_incop1 = bACP_NEGATIVE_LIST_Repo.findcer_od_incop();
			if (cer_od_incop1.contains(cer_od_incop)) {
				NegativeListFound = true;
				msg.append("CERTIFICATE OF INCORPORATION<span class='spaced2'>").append(cer_od_incop)
						.append("<span class='spaced21'>").append(cer_od_incop).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> buss_ref_no1 = bACP_NEGATIVE_LIST_Repo.findbuss_ref_no();
			if (buss_ref_no1.contains(buss_ref_no)) {
				NegativeListFound = true;
				msg.append("BUSINESS REGISTRATION NO<span class='spaced3'>").append(buss_ref_no)
						.append("<span class='spaced31'>").append(buss_ref_no).append("<br>");
			}

			// Check for duplicate lno
			List<String> lno1 = bACP_NEGATIVE_LIST_Repo.findlno();
			if (lno1.contains(lno)) {
				NegativeListFound = true;
				msg.append("LAND LINE NO<span class='spaced4'>").append(lno).append("<span class='spaced41'>")
						.append(lno).append("<br>");
			}

			if (!NegativeListFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString() + "CORPORATE");
		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	// for retail
	@RequestMapping(value = "/CheckDuplicateIndiv", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckDuplicateIndiv(@RequestParam(required = false) String id,
			@RequestParam(required = false) String Mobile_num,

			@RequestParam(required = false) String Passport_num, @RequestParam(required = false) String fullname) {
		System.out.println(id + Mobile_num + Passport_num + fullname + "fullnameindiv");
		StringBuilder msg = new StringBuilder();

		boolean duplicateFound = false;
		try {
			// Check for duplicate id
			List<String> fullname1 = bACP_DE_DUPRepo.getfull_name();
			if (fullname1.contains(fullname)) {
				duplicateFound = true;
				msg.append("Full Name<span class='spacedInv4'>").append(fullname).append("<span class='spacedInv41'>")
						.append(fullname).append("<br>");
			}

			List<String> id1 = bACP_DE_DUPRepo.findnationality();
			if (id1.contains(id)) {
				duplicateFound = true;
				msg.append("National Id<span class='spacedInv1'>").append(id).append("<span class='spacedInv11'>")
						.append(id).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> Passport_num1 = bACP_DE_DUPRepo.findpassport();
			if (Passport_num1.contains(Passport_num)) {
				duplicateFound = true;
				msg.append("Passport No<span class='spacedInv3'>").append(Passport_num)
						.append("<span class='spacedInv31'>").append(Passport_num).append("<br>");
			}
			// Check for duplicate cer_od_incop
			List<String> Mobile_num1 = bACP_DE_DUPRepo.findmbl_num();
			if (Mobile_num1.contains(Mobile_num)) {
				duplicateFound = true;
				msg.append("Mobile No<span class='spacedInv2'>").append(Mobile_num).append("<span class='spacedInv21'>")
						.append(Mobile_num).append("<br>");
			}
			// Check for duplicate lno

			if (!duplicateFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@RequestMapping(value = "/CheckBlackListIndiv", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckBlackListIndiv(@RequestParam(required = false) String id,
			@RequestParam(required = false) String Mobile_num,

			@RequestParam(required = false) String Passport_num, @RequestParam(required = false) String fullname) {
		System.out.println(id + Mobile_num + Passport_num + fullname + "fullnameindiv");
		StringBuilder msg = new StringBuilder();

		boolean BlacklistFound = false;
		try {
			// Check for duplicate id
			List<String> fullname1 = bACP_BLACKLIST_Repo.getfull_name();
			if (fullname1.contains(fullname)) {
				BlacklistFound = true;
				msg.append("Full Name<span class='spacedInv4'>").append(fullname).append("<span class='spacedInv41'>")
						.append(fullname).append("<br>");
			}

			List<String> id1 = bACP_BLACKLIST_Repo.findnationality();
			if (id1.contains(id)) {
				BlacklistFound = true;
				msg.append("National Id<span class='spacedInv1'>").append(id).append("<span class='spacedInv11'>")
						.append(id).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> Passport_num1 = bACP_BLACKLIST_Repo.findpassport();
			if (Passport_num1.contains(Passport_num)) {
				BlacklistFound = true;
				msg.append("Passport No<span class='spacedInv3'>").append(Passport_num)
						.append("<span class='spacedInv31'>").append(Passport_num).append("<br>");
			}
			// Check for duplicate cer_od_incop
			List<String> Mobile_num1 = bACP_BLACKLIST_Repo.findmbl_num();
			if (Mobile_num1.contains(Mobile_num)) {
				BlacklistFound = true;
				msg.append("Mobile No<span class='spacedInv2'>").append(Mobile_num).append("<span class='spacedInv21'>")
						.append(Mobile_num).append("<br>");
			}
			// Check for duplicate lno

			if (!BlacklistFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@RequestMapping(value = "/CheckNegativeListIndiv", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckNegativeListIndiv(@RequestParam(required = false) String id,
			@RequestParam(required = false) String Mobile_num,

			@RequestParam(required = false) String Passport_num, @RequestParam(required = false) String fullname) {
		System.out.println(id + Mobile_num + Passport_num + fullname + "CheckNegativeListIndiv");
		StringBuilder msg = new StringBuilder();

		boolean NegativeFound = false;
		try {
			// Check for duplicate id
			List<String> fullname1 = bACP_NEGATIVE_LIST_Repo.getfull_name();
			if (fullname1.contains(fullname)) {
				NegativeFound = true;
				msg.append("Full Name<span class='spacedInv4'>").append(fullname).append("<span class='spacedInv41'>")
						.append(fullname).append("<br>");
			}

			List<String> id1 = bACP_NEGATIVE_LIST_Repo.findnationality();
			if (id1.contains(id)) {
				NegativeFound = true;
				msg.append("National Id<span class='spacedInv1'>").append(id).append("<span class='spacedInv11'>")
						.append(id).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> Passport_num1 = bACP_NEGATIVE_LIST_Repo.findpassport();
			if (Passport_num1.contains(Passport_num)) {
				NegativeFound = true;
				msg.append("Passport No<span class='spacedInv3'>").append(Passport_num)
						.append("<span class='spacedInv31'>").append(Passport_num).append("<br>");
			}
			// Check for duplicate cer_od_incop
			List<String> Mobile_num1 = bACP_NEGATIVE_LIST_Repo.findmbl_num();
			if (Mobile_num1.contains(Mobile_num)) {
				NegativeFound = true;
				msg.append("Mobile No<span class='spacedInv2'>").append(Mobile_num).append("<span class='spacedInv21'>")
						.append(Mobile_num).append("<br>");
			}
			// Check for duplicate lno

			if (!NegativeFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	// joint

	@RequestMapping(value = "/CheckDuplicateJoint", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckDuplicateJoint(@RequestParam(required = false) String id,
			@RequestParam(required = false) String Mobile_num,

			@RequestParam(required = false) String Passport_num, @RequestParam(required = false) String fullname) {
		System.out.println(id + Mobile_num + Passport_num + fullname + "fullnameindiv");
		StringBuilder msg = new StringBuilder();

		boolean duplicateFound = false;
		try {
			// Check for duplicate id
			List<String> fullname1 = bACP_DE_DUPRepo.getfull_name();
			if (fullname1.contains(fullname)) {
				duplicateFound = true;
				msg.append("Full Name<span class='spacedInv4'>").append(fullname).append("<span class='spacedInv41'>")
						.append(fullname).append("<br>");
			}

			List<String> id1 = bACP_DE_DUPRepo.findnationality();
			if (id1.contains(id)) {
				duplicateFound = true;
				msg.append("National Id<span class='spacedInv1'>").append(id).append("<span class='spacedInv11'>")
						.append(id).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> Passport_num1 = bACP_DE_DUPRepo.findpassport();
			if (Passport_num1.contains(Passport_num)) {
				duplicateFound = true;
				msg.append("Passport No<span class='spacedInv3'>").append(Passport_num)
						.append("<span class='spacedInv31'>").append(Passport_num).append("<br>");
			}
			// Check for duplicate cer_od_incop
			List<String> Mobile_num1 = bACP_DE_DUPRepo.findmbl_num();
			if (Mobile_num1.contains(Mobile_num)) {
				duplicateFound = true;
				msg.append("Mobile No<span class='spacedInv2'>").append(Mobile_num).append("<span class='spacedInv21'>")
						.append(Mobile_num).append("<br>");
			}
			// Check for duplicate lno

			if (!duplicateFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@RequestMapping(value = "/CheckBlackListJoint", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckBlackListJoint(@RequestParam(required = false) String id,
			@RequestParam(required = false) String Mobile_num,

			@RequestParam(required = false) String Passport_num, @RequestParam(required = false) String fullname) {
		System.out.println(id + Mobile_num + Passport_num + fullname + "fullnameindiv");
		StringBuilder msg = new StringBuilder();

		boolean BlacklistFound = false;
		try {
			// Check for duplicate id
			List<String> fullname1 = bACP_BLACKLIST_Repo.getfull_name();
			if (fullname1.contains(fullname)) {
				BlacklistFound = true;
				msg.append("Full Name<span class='spacedInv4'>").append(fullname).append("<span class='spacedInv41'>")
						.append(fullname).append("<br>");
			}

			List<String> id1 = bACP_BLACKLIST_Repo.findnationality();
			if (id1.contains(id)) {
				BlacklistFound = true;
				msg.append("National Id<span class='spacedInv1'>").append(id).append("<span class='spacedInv11'>")
						.append(id).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> Passport_num1 = bACP_BLACKLIST_Repo.findpassport();
			if (Passport_num1.contains(Passport_num)) {
				BlacklistFound = true;
				msg.append("Passport No<span class='spacedInv3'>").append(Passport_num)
						.append("<span class='spacedInv31'>").append(Passport_num).append("<br>");
			}
			// Check for duplicate cer_od_incop
			List<String> Mobile_num1 = bACP_BLACKLIST_Repo.findmbl_num();
			if (Mobile_num1.contains(Mobile_num)) {
				BlacklistFound = true;
				msg.append("Mobile No<span class='spacedInv2'>").append(Mobile_num).append("<span class='spacedInv21'>")
						.append(Mobile_num).append("<br>");
			}
			// Check for duplicate lno

			if (!BlacklistFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@RequestMapping(value = "/CheckNegativeListJoint", method = { RequestMethod.GET })
	@ResponseBody
	public String CheckNegativeListJoint(@RequestParam(required = false) String id,
			@RequestParam(required = false) String Mobile_num,

			@RequestParam(required = false) String Passport_num, @RequestParam(required = false) String fullname) {
		System.out.println(id + Mobile_num + Passport_num + fullname + "fullnameindivnegativelist");
		StringBuilder msg = new StringBuilder();

		boolean NegativeFound = false;
		try {
			// Check for duplicate id
			List<String> fullname1 = bACP_NEGATIVE_LIST_Repo.getfull_name();
			if (fullname1.contains(fullname)) {
				NegativeFound = true;
				msg.append("Full Name<span class='spacedInv4'>").append(fullname).append("<span class='spacedInv41'>")
						.append(fullname).append("<br>");
			}

			List<String> id1 = bACP_NEGATIVE_LIST_Repo.findnationality();
			if (id1.contains(id)) {
				NegativeFound = true;
				msg.append("National Id<span class='spacedInv1'>").append(id).append("<span class='spacedInv11'>")
						.append(id).append("<br>");
			}

			// Check for duplicate buss_ref_no
			List<String> Passport_num1 = bACP_NEGATIVE_LIST_Repo.findpassport();
			if (Passport_num1.contains(Passport_num)) {
				NegativeFound = true;
				msg.append("Passport No<span class='spacedInv3'>").append(Passport_num)
						.append("<span class='spacedInv31'>").append(Passport_num).append("<br>");
			}
			// Check for duplicate cer_od_incop
			List<String> Mobile_num1 = bACP_NEGATIVE_LIST_Repo.findmbl_num();
			if (Mobile_num1.contains(Mobile_num)) {
				NegativeFound = true;
				msg.append("Mobile No<span class='spacedInv2'>").append(Mobile_num).append("<span class='spacedInv21'>")
						.append(Mobile_num).append("<br>");
			}
			// Check for duplicate lno

			if (!NegativeFound) {
				msg.append("MATCH NOT FOUND");
			}

			System.out.println(msg.toString());

		} catch (NullPointerException e) {
			msg = new StringBuilder("clear");
		}
		return msg.toString();
	}

	@PostMapping("/imageupload11")
	@ResponseBody

	public String uploadimage(@RequestParam("files") List<MultipartFile> file,
			@RequestParam("unique") List<String> unique_id,
			@RequestParam(value = "appl_ref_no", required = false) String appl_ref_no,
			@RequestParam("dataURL") List<String> dataURL) throws IOException, SerialException, SQLException {
		String msg = null;
		System.out.println(unique_id);
		try {

			for (int i = 0; i < file.size(); i++) {

				byte[] fileBytes = file.get(i).getBytes();
				BACP_DOC_MAN_ENTITY back = bacpRep.findByApplAndUnquieimg(appl_ref_no, unique_id.get(i));

				// Check if it's an image (use dataURL), otherwise store the raw fileBytes
				if (!file.get(i).getContentType().startsWith("image/")) {
					// For non-image files (PDF, Excel, etc.), store the raw file bytes
					back.setUpd_file(fileBytes);
				} else {
					// For images, use the dataURL if present
					String docString = dataURL.get(i);
					byte[] document = docString.getBytes(); // Handle dataURL for images
					back.setUpd_file(document);
				}

				bacpRep.save(back);

			}
			msg = " File Uploaded Succesfully ";
			// System.out.println(" file Size " + file.size());
		} catch (Exception e) {
			System.out.println("Exception >>>>>>>>>>>>>>>>>" + e);
			msg = " File Upload Unsuccesfull ";
		}
		return msg;
	}

	@PostMapping("/multiline")
	@ResponseBody
	public List<String> upLoadForm1(@RequestBody List<DynamicFromValue> dynamicValues,
			@RequestParam(value = "appl_ref_no", required = false) String appl_ref_no,
			@RequestParam(value = "rec_no", required = false) String rec_no,
			@RequestParam(value = "cif_id", required = false) String cif_id) {

		System.out.println("The rec no is " + rec_no);
		System.err.println(" size " + dynamicValues.size());
		System.out.println(dynamicValues);
		List<BACP_DOC_MAN_ENTITY> list_of_bacp_record = new ArrayList<>();
		for (DynamicFromValue dynamic : dynamicValues) {
			System.err.println(" size " + dynamicValues.size());
			BACP_DOC_MAN_ENTITY bdcm = new BACP_DOC_MAN_ENTITY();
			bdcm.setFile_name(dynamic.getFilename());
			bdcm.setDocument_type(dynamic.getDoctype());
			bdcm.setDocument_code(dynamic.getDoccode());
			bdcm.setDocument_type_desc(dynamic.getDoctypesesc());
			bdcm.setUnique_id(dynamic.getUniqueid());
			bdcm.setPlace_of_issue(dynamic.getPlaceofissue());
			bdcm.setIssue_date(dynamic.getIssuedate());
			bdcm.setExpiry_date(dynamic.getExprydate());
			bdcm.setAppl_ref_no(appl_ref_no);
			bdcm.setRec_no(rec_no);
			bdcm.setCif_id(cif_id);
			bdcm.setDel_flg("N");
			bacpRep.save(bdcm);
			list_of_bacp_record.add(bdcm);
		}
		try {
			bacpRep.saveAll(list_of_bacp_record);
			List<String> uniquelist = list_of_bacp_record.stream().map(e -> e.getUnique_id())
					.collect(Collectors.toList());
			return uniquelist;
		} catch (Exception e) {
			return new ArrayList();
		}

	}

	@RequestMapping(value = "BacpMinimalData", method = { RequestMethod.GET, RequestMethod.POST })
	public String BacpMinimalData(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String count, Model md, HttpServletRequest req) {

		if (formmode == null || formmode.equals("view")) {
			md.addAttribute("formmode", formmode);
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(ApprefNO));
		} else if (formmode.equals("view1a")) {
			md.addAttribute("formmode", "view1a");
			com.bornfire.entities.CustomerRequest val = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
		} else {
			System.out.println("Error occured");
		}

		return "BACP_minimal_last";
	}

	/*
	 * @PostMapping("/imageupload")
	 * 
	 * @ResponseBody public String uploadImage(@RequestParam("files")
	 * List<MultipartFile> file,
	 * 
	 * @RequestParam("unique") List<String> unique_id, @RequestParam("cif_id")
	 * String cif_id,
	 * 
	 * @RequestParam("dataURL") String dataURL) throws IOException, SerialException,
	 * SQLException {
	 * 
	 * System.out.println("the uniqueid: " + unique_id); BACP_DOC_MAN_ENTITY bcme =
	 * new BACP_DOC_MAN_ENTITY();
	 * 
	 * for (int i = 0; i < file.size(); i++) { byte[] photoBytes =
	 * file.get(i).getBytes(); Blob ser = new SerialBlob(photoBytes);
	 * BACP_DOC_MAN_ENTITY back = bacpRep.findByApplAndUnquie(cif_id,
	 * unique_id.get(i)); System.out.println("The cifid: " + cif_id);
	 * 
	 * // You can use the dataURL here if needed back.setUpd_file(new
	 * SerialBlob(dataURL.getBytes())); System.out.println("the url :" +
	 * dataURL.getBytes()); // back.setUpd_file(ser); bacpRep.save(back); }
	 * 
	 * System.out.println("file Size " + file.size()); return
	 * "Image uploaded successfully"; }
	 */

	@RequestMapping(value = "/getimages", method = { RequestMethod.GET })
	@ResponseBody
	public String getimagesss(@RequestParam(required = false) String appl_ref_no) throws SQLException {

		String msg = null;
		String lastChars = null;

		try {
			System.out.println("inside");
			List<Bacp_Signature_master> vv = bacp_Signature_masterRepo.findByref_no(appl_ref_no);
			System.out.println("The encryptedddddd" + vv.get(0).getSign());

			InputStream ll = vv.get(0).getSign().getBinaryStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(ll));
			msg = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lastChars = msg.substring(22, msg.length());

		return lastChars;

	}

	@RequestMapping(value = "/getimagesone", method = { RequestMethod.GET })
	@ResponseBody
	public String getimagesssone(@RequestParam(required = false) String appl_ref_no) throws SQLException {

		String str = "";
		String lastChars = null;
		System.out.println("inside imagesone");
		List<Bacp_Signature_master> vv = bacp_Signature_masterRepo.findByref_no(appl_ref_no);
		/*
		 * // System.out.println("The encryptedddddd"+vv.get(0).getPhoto()); byte[]
		 * valueDecoded = Base64.decodeBase64(vv.get(0).getPhoto());
		 * System.out.println("Decoded value is " + new String(valueDecoded)); File ff =
		 * new File(valueDecoded.toString());
		 */

		byte[] ll = vv.get(0).getPhoto();
		str = new String(ll, StandardCharsets.UTF_8);
		System.out.println(str);

		lastChars = str.substring(str.indexOf(",") + 1);

		System.out.println(lastChars);
		return lastChars;
	}

	@RequestMapping(value = "/getproof1", method = { RequestMethod.GET })
	@ResponseBody
	public String getproof1(@RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) String doc_type, String md) throws SQLException, ParseException {

		// @RequestParam(required = false) String document_type)

		String msg = null;
		String lastChars = null;

		try {
			System.out.println("inside");
			System.out.println("inside");
			System.out.println("inside");
			List<BACP_DOC_MAN_ENTITY> vv = bacpRep.findBy1(appl_ref_no, doc_type);
			// System.out.println("The encryptedddddd" +
			// vv.get(0).getUpd_file().toString());

			byte[] ll = vv.get(0).getUpd_file();
			String str = new String(ll, StandardCharsets.UTF_8);
			lastChars = str.substring(str.indexOf(",") + 1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("lastChars" + lastChars);

		return lastChars;

	}

	@RequestMapping(value = "listkyc", method = RequestMethod.POST)
	@ResponseBody
	public String listkyc(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@ModelAttribute CustomerRequest custReq, @RequestParam(required = false) String kyc_officer,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date kyc_date,
			@RequestParam(required = false) String remaks, @RequestParam(required = false) String kyc_comp,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date kycreview,
			@RequestParam(required = false) String hold_remarks,
			@RequestParam(required = false) String reject_remarks) {

		String msg = null;

		if (formmode.equals("kyc_compliance")) {
			System.out.println(ApprefNO + "rec_no" + rec_no);
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setKyc_flg("Y");
			up.setKyc_review_date(kycreview);
			up.setKyc_date(kyc_date);
			up.setKyc_compliance(kyc_comp);
			up.setKyc_officer(kyc_officer);
			up.setKyc_remarks(remaks);
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "KYC Compliance Successfull for Reference No:" + ApprefNO;
		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setHold_remarks(hold_remarks);
			bACP_CUS_PROFILE_REPO.save(up);

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();
			String AccountNo = null;
			Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO2);
			DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
			if (CifId.getCa_schemetype().equals("LA")) {
				AccountNo = LeaseAccount.getLoan_accountno();
			} else {
				AccountNo = DepositAccount.getDepo_actno();
			}
			msg = "Account No:  " + AccountNo + "   Kept Hold<br>";
			msg += "Reference No: " + ApprefNO + "<br>";
			// msg += "Customer Id: " + up.getCif_id() + "<br>";
			// msg += "Approved Name: " +username + " <br>";
			// msg += "Approved Date: " + ComplianceDate + " ";

			// msg = "Reference No: " + ApprefNO + " has been moved to Hold List ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setReject_remarks(reject_remarks);
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + "  Rejected";
		}

		else {

			msg = "Error Occured!!!";
		}
		return msg;

	}

	@RequestMapping(value = "BacpMinisub", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String BacpMinisub(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String hold_remarks) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));

		String msg = null;

		if (formmode.equals("submitfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");

			if (up != null) {
				if (up.getCa_acct_type().equals("INDIVIDUAL")) {
					up.setApproval_flg("N");
					up.setStatus("NOT APPROVED");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.getCa_preferred_name();
					up.getCif_id();

					String ComplianceDate = compDate.format(new Date());

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Customer Created Successfully " + up.getCif_id() + "<br>";
					msg += "Account Opened Successfully " + AccountNo + "<br>";
					msg += "Account Opening Successfully Generated " + ApprefNO + "";

				} else if (up.getCa_acct_type().equals("CORPORATE")) {
					System.out.println("CORPORATE");
					up.setApproval_flg("N");
					up.setStatus("NOT APPROVED");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.getCa_preferred_name();
					up.getCif_id();

					String ComplianceDate = compDate.format(new Date());

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Customer Created Successfully " + "<br>";
					msg += "Account Opened Successfully " + AccountNo + "<br>";
					msg += "Account Opening Successfully Generated " + ApprefNO + "";

					System.out.println(msg);
				} else if (up.getCa_acct_type().equals("JOINT ACCOUNT")) {
					System.out.println("JOINT ACCOUNT");
					up.setApproval_flg("N");
					up.setStatus("NOT APPROVED");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.getCa_preferred_name();
					up.getCif_id();

					String ComplianceDate = compDate.format(new Date());

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Customer Created Successfully " + "<br>";
					msg += "Account Opened Successfully " + AccountNo + "<br>";
					msg += "Account Opening Successfully Generated " + ApprefNO + "";

					System.out.println(msg);
				} else {
					// Handle other account types if any
					System.out.println("Unknown account type: " + up.getCa_acct_type());
				}
			} else {

			}
		} else if (formmode.equals("Holdfin")) {
			System.out.println(ApprefNO + "ApprefNOApprefNO");

			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByappl(ApprefNO);
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());
			if (up != null) {

				if (up.getCa_acct_type().equals("INDIVIDUAL")) {
					up.setStatus("HOLD");
					up.setApproval_flg("N");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.setHold_remarks(hold_remarks);
					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been moved to Hold List<br>";

					msg += "Hold Date: " + ComplianceDate + " ";
				} else if (up.getCa_acct_type().equals("JOINT ACCOUNT")) {
					System.out.println("JOINT ACCOUNT");
					up.setStatus("HOLD");
					up.setApproval_flg("N");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.setHold_remarks(hold_remarks);
					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been moved to Hold List<br>";
					msg += "Hold Date: " + ComplianceDate + " ";

				} else if (up.getCa_acct_type().equals("CORPORATE")) {
					System.out.println("CORPORATE");
					up.setStatus("HOLD");
					up.setApproval_flg("N");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.setHold_remarks(hold_remarks);
					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been moved to Hold List<br>";
					msg += "Hold Date: " + ComplianceDate + " ";

				}
			} else {
				// Handle the case where up is null, e.g., log an error or throw an exception
				System.out.println("No customer request found for ApprefNO: " + ApprefNO);

			}

		} else if (formmode.equals("Approve_acc")) {
			msg = customerDetailsService.Approve_acc(ApprefNO, rec_no);
		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByappl(ApprefNO);
			up.setStatus("REJECT");
			up.getCa_preferred_name();
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}

		else {

			msg = "Error Occured!!!";
		}
		return msg;

	}

	@RequestMapping(value = "HoldFuncs", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String HoldFuncs(@RequestParam(required = false) String formmode, Model md, HttpServletRequest req,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));

		String msg = null;

		if (formmode.equals("submitfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");

			if (up != null) {
				if (up.getCa_acct_type().equals("INDIVIDUAL")) {
					up.setApproval_flg("N");
					up.setStatus("NOT APPROVED");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.getCa_preferred_name();
					up.getCif_id();

					String ComplianceDate = compDate.format(new Date());

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been Submitted Successfully<br>";

				} else if (up.getCa_acct_type().equals("CORPORATE")) {
					System.out.println("CORPORATE");
					up.setApproval_flg("N");
					up.setStatus("NOT APPROVED");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.getCa_preferred_name();
					up.getCif_id();

					String ComplianceDate = compDate.format(new Date());

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been Submitted Successfully<br>";

					System.out.println(msg);
				} else if (up.getCa_acct_type().equals("JOINT ACCOUNT")) {
					System.out.println("JOINT ACCOUNT");
					up.setApproval_flg("N");
					up.setStatus("NOT APPROVED");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					up.getCa_preferred_name();
					up.getCif_id();

					String ComplianceDate = compDate.format(new Date());

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been Submitted Successfully<br>";

					System.out.println(msg);
				} else {
					// Handle other account types if any
					System.out.println("Unknown account type: " + up.getCa_acct_type());
				}
			} else {

			}
		} else if (formmode.equals("Holdfin")) {
			System.out.println(ApprefNO + "ApprefNOApprefNO");

			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByappl(ApprefNO);
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());
			if (up != null) {

				if (up.getCa_acct_type().equals("INDIVIDUAL")) {
					up.setStatus("HOLD");
					up.setApproval_flg("N");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been moved to Hold List<br>";

					msg += "Hold Date: " + ComplianceDate + " ";
				} else if (up.getCa_acct_type().equals("JOINT ACCOUNT")) {
					System.out.println("JOINT ACCOUNT");
					up.setStatus("HOLD");
					up.setApproval_flg("N");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been moved to Hold List<br>";
					msg += "Hold Date: " + ComplianceDate + " ";

				} else if (up.getCa_acct_type().equals("CORPORATE")) {
					System.out.println("CORPORATE");
					up.setStatus("HOLD");
					up.setApproval_flg("N");
					up.setKyc_flg("N");
					up.setDoc_verify_flg("N");
					up.setEntity_flg("N");
					up.setEntry_user(userId);
					up.setEntry_time(new Date());
					bACP_CUS_PROFILE_REPO.save(up);
					msg = "Reference No: " + ApprefNO + "  has been moved to Hold List<br>";
					msg += "Hold Date: " + ComplianceDate + " ";

				}
			} else {
				// Handle the case where up is null, e.g., log an error or throw an exception
				System.out.println("No customer request found for ApprefNO: " + ApprefNO);

			}

		} else if (formmode.equals("Approve_acc")) {
			msg = customerDetailsService.Approve_acc(ApprefNO, rec_no);
		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByappl(ApprefNO);
			up.setStatus("REJECT");
			up.getCa_preferred_name();
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}

		else {

			msg = "Error Occured!!!";
		}
		return msg;

	}

	@RequestMapping(value = "approvefuncs", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, String> approvefuncs(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@ModelAttribute DepositEntity depositEntity, @RequestParam(required = false) String AccountNO,
			@RequestParam(required = false) String schmtypes, @RequestParam(required = false) String schmcodes,
			HttpServletRequest rq, @RequestParam(required = false) String reject_remarks,
			@RequestParam(required = false) String hold_remarks) {
		System.out.println("THE ACCOUNT NUMBER IS : " + AccountNO);
		String user = (String) rq.getSession().getAttribute("USERID");
		String msg = null;
		String username = (String) rq.getSession().getAttribute("USERNAME");

		/* tranId sequence */
		String tranId = "TR" + tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID1();

		if (formmode.equals("approveAcc")) {

			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);

			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());

			if (schmcodes.equals("RETAIL")) {

				System.out.println("The Retail Account Opening");

				Date tranvaldate = new Date();
				BigDecimal partTranId1 = BigDecimal.valueOf(1);
				BigDecimal partTranId2 = BigDecimal.valueOf(2);

				if (schmtypes.equals("LA")) {

					System.out.println("The Retail Loan Account Opening");

					/* verify customer lease account */
					Lease_Loan_Work_Entity leasy = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					String leaseAccountSaved = leaseLoanService.verifyleaseloan(AccountNO, user);
					System.out.println(leaseAccountSaved);

					/* COA table entry - new Loan Account of customer */
					Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);

					Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(loandetails.getLoan_accountno());
					coa.setAcct_name(loandetails.getCustomer_name());
					coa.setAcct_crncy(loandetails.getLoan_currency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(up.getLa_glcode());
					coa.setGl_desc(up.getLa_gldesc());
					coa.setGlsh_code(up.getLa_glshcode());
					coa.setGlsh_desc(up.getLa_glshdesc());
					coa.setSchm_code(up.getCa_scheme_code());
					coa.setSchm_type(up.getCa_schemetype());
					coa.setMobile_no(new BigDecimal(up.getCa_mobile_number()));
					coa.setNational_id(up.getCa_idenditification_number());
					coa.setClassification("Asset");
					coa.setAdd_det_flg("N");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("L");

					chart_Acc_Rep.save(coa);

					if (loandetails.getRecovery_method().equalsIgnoreCase("Cash")) {

						/* TRM table entry set here */

						/* First Transaction - customer loan account DEBIT */
						TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
						debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
						debitTrm.setTran_id(tranId);
						debitTrm.setPart_tran_id(partTranId1);
						debitTrm.setAcct_num(leasy.getLoan_accountno());
						debitTrm.setAcct_name(leasy.getCustomer_name());
						debitTrm.setTran_type("CASH");
						debitTrm.setPart_tran_type("Debit");
						debitTrm.setAcct_crncy(leasy.getLoan_currency());
						debitTrm.setTran_amt(leasy.getLoan_sanctioned());
						debitTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_date(leasy.getDate_of_loan());
						debitTrm.setValue_date(leasy.getDate_of_loan());
						debitTrm.setFlow_code("DISBT");
						debitTrm.setFlow_date(leasy.getDate_of_loan());
						debitTrm.setTran_status("ENTERED");
						debitTrm.setEntry_user(user);
						debitTrm.setEntry_time(tranvaldate);
						debitTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

						/* Second Transaction - CASH ON HAND ACCOUNT CREDIT */
						/* this account already existed in COA */
						String acct_num = "1100001120";
						Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

						TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

						creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
						creditTrm.setTran_id(tranId);
						creditTrm.setPart_tran_id(partTranId2);
						creditTrm.setAcct_num(leasydebit.getAcct_num());
						creditTrm.setAcct_name(leasydebit.getAcct_name());
						creditTrm.setTran_type("CASH");
						creditTrm.setPart_tran_type("Credit");
						creditTrm.setAcct_crncy(leasydebit.getAcct_crncy());
						creditTrm.setTran_amt(leasy.getLoan_sanctioned());
						creditTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_date(leasy.getDate_of_loan());
						creditTrm.setValue_date(leasy.getDate_of_loan());
						creditTrm.setFlow_code("DISBT");
						creditTrm.setFlow_date(leasy.getDate_of_loan());
						creditTrm.setTran_status("ENTERED");
						creditTrm.setEntry_user(user);
						creditTrm.setEntry_time(tranvaldate);
						creditTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

						/* update loan demand table Tran Details */

						String flowcode = "DISBT";
						String flowId = "1";

						DMD_TABLE demandFlow = dMD_TABLE_REPO.getDemandData(AccountNO, flowcode, flowId);
						demandFlow.setTran_id(tranId);
						demandFlow.setTran_date(leasy.getDate_of_loan());
						demandFlow.setPart_tran_id(partTranId1);
						demandFlow.setPart_tran_type("Debit");
						demandFlow.setModify_time(leasy.getDate_of_loan());
						demandFlow.setModify_user(user);
						demandFlow.setModify_flg("Y");

						dMD_TABLE_REPO.save(demandFlow);

					} else if (loandetails.getRecovery_method().equalsIgnoreCase("Office Routing Account")) {

						/* TRM table entry set here */

						/* First Transaction - customer loan account DEBIT */
						TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
						debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
						debitTrm.setTran_id(tranId);
						debitTrm.setPart_tran_id(partTranId1);
						debitTrm.setAcct_num(leasy.getLoan_accountno());
						debitTrm.setAcct_name(leasy.getCustomer_name());
						debitTrm.setTran_type("TRANSFER");
						debitTrm.setPart_tran_type("Debit");
						debitTrm.setAcct_crncy(leasy.getLoan_currency());
						debitTrm.setTran_amt(leasy.getLoan_sanctioned());
						debitTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_date(leasy.getDate_of_loan());
						debitTrm.setValue_date(leasy.getDate_of_loan());
						debitTrm.setFlow_code("DISBT");
						debitTrm.setFlow_date(leasy.getDate_of_loan());
						debitTrm.setTran_status("ENTERED");
						debitTrm.setEntry_user(user);
						debitTrm.setEntry_time(tranvaldate);
						debitTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

						/* Second Transaction - office Loan Account CREDIT */
						/* this account already existed in COA */
						String acct_num = "2700002750";
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
						creditTrm.setTran_amt(leasy.getLoan_sanctioned());
						creditTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_date(leasy.getDate_of_loan());
						creditTrm.setValue_date(leasy.getDate_of_loan());
						creditTrm.setFlow_code("DISBT");
						creditTrm.setFlow_date(leasy.getDate_of_loan());
						creditTrm.setTran_status("ENTERED");
						creditTrm.setEntry_user(user);
						creditTrm.setEntry_time(tranvaldate);
						creditTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

						/* update loan demand table Tran Details */

						String flowcode = "DISBT";
						String flowId = "1";

						DMD_TABLE demandFlow = dMD_TABLE_REPO.getDemandData(AccountNO, flowcode, flowId);
						demandFlow.setTran_id(tranId);
						demandFlow.setTran_date(leasy.getDate_of_loan());
						demandFlow.setPart_tran_id(partTranId1);
						demandFlow.setPart_tran_type("Debit");
						demandFlow.setModify_time(leasy.getDate_of_loan());
						demandFlow.setModify_user(user);
						demandFlow.setModify_flg("Y");

						dMD_TABLE_REPO.save(demandFlow);
					}

				} else {

					System.out.println("The Retail Deposit Account Opening");

					/* deposit customer account verify */

					DepositEntity deposit = depositRep.getCustdataact(AccountNO);
					System.out.println("Deposit Account No : " + deposit.getDepo_actno());
					deposit.setEntity_flg("Y");
					deposit.setModify_flg("N");
					deposit.setDel_flg("N");

					depositRep.save(deposit);

					/* COA table entry - new Deposit Account of customer */
					DepositEntity depositevalue = depositRep.getCustdataactval(AccountNO);
					Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(depositevalue.getDepo_actno());
					coa.setAcct_name(depositevalue.getCust_name());
					coa.setAcct_crncy(depositevalue.getCurrency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(up.getTd_glcode());
					coa.setGl_desc(up.getTd_gldesc());
					coa.setGlsh_code(up.getTd_glshcode());
					coa.setGlsh_desc(up.getTd_glshdesc());
					coa.setSchm_code(up.getCa_scheme_code());
					coa.setSchm_type(up.getCa_schemetype());
					coa.setMobile_no(new BigDecimal(up.getCa_mobile_number()));
					coa.setNational_id(up.getCa_idenditification_number());
					coa.setClassification("Liability");
					coa.setAdd_det_flg("C");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("D");

					chart_Acc_Rep.save(coa);

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
					creditTrm.setTran_amt(depositevalue.getDeposit_amt());
					creditTrm.setTran_particular(depositevalue.getDepo_actno() + " Principal Deposit");
					creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " Principal Deposit");
					creditTrm.setTran_date(depositevalue.getDeposit_date());
					creditTrm.setValue_date(depositevalue.getDeposit_date());
					creditTrm.setFlow_code("PI");
					creditTrm.setFlow_date(depositevalue.getDeposit_date());
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(tranvaldate);
					creditTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

					/* Second Transaction - office Deposit Account DEBIT */
					/* this account already existed in COA */
					String acct_num = "1700001750";
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
					debitTrm.setTran_amt(depositevalue.getDeposit_amt());
					debitTrm.setTran_particular(depositevalue.getDepo_actno() + " Principal Deposit");
					debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " Principal Deposit");
					debitTrm.setTran_date(depositevalue.getDeposit_date());
					debitTrm.setValue_date(depositevalue.getDeposit_date());
					debitTrm.setFlow_code("PI");
					debitTrm.setFlow_date(depositevalue.getDeposit_date());
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(tranvaldate);
					debitTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(debitTrm); // Save the second transaction

					/* update deposit demand table Tran Details */
					String flowcode = "PI";
					String flowId = "1";

					Td_defn_table flowRecords = td_defn_Repo.getFlowrecords(AccountNO, flowcode, flowId);
					flowRecords.setTran_date(tranvaldate);
					flowRecords.setTran_id(tranId);
					flowRecords.setPart_tran_id(partTranId1);
					flowRecords.setTran_amt(depositevalue.getDeposit_amt());
					flowRecords.setModify_user(user);
					flowRecords.setModify_time(tranvaldate);
					flowRecords.setModify_flg("Y");

					td_defn_Repo.save(flowRecords);

				}
			} else if (schmcodes.equals("CORPORATE")) {

				System.out.println("The Corporate Account Opening");

				Date tranvaldate = new Date();
				BigDecimal partTranId1 = BigDecimal.valueOf(1);
				BigDecimal partTranId2 = BigDecimal.valueOf(2);

				if (schmtypes.equals("LA")) {

					System.out.println("The corporate Loan Account Opening");

					/* verify customer lease account */
					Lease_Loan_Work_Entity leasy = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					String leaseAccountSaved = leaseLoanService.verifyleaseloan(AccountNO, user);
					System.out.println(leaseAccountSaved);

					/* COA table entry - new Loan Account of customer */
					Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);

					Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(loandetails.getLoan_accountno());
					coa.setAcct_name(loandetails.getCustomer_name());
					coa.setAcct_crncy(loandetails.getLoan_currency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(up.getLa_glcode());
					coa.setGl_desc(up.getLa_gldesc());
					coa.setGlsh_code(up.getLa_glshcode());
					coa.setGlsh_desc(up.getLa_glshdesc());
					coa.setSchm_code(up.getCa_scheme_code());
					coa.setSchm_type(up.getCa_schemetype());
					coa.setMobile_no(up.getCa_mobile_no_1());
					coa.setNational_id(up.getCa_idenditification_number());
					coa.setClassification("Asset");
					coa.setAdd_det_flg("N");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("L");

					chart_Acc_Rep.save(coa);

					if (loandetails.getRecovery_method().equalsIgnoreCase("Cash")) {

						/* TRM table entry set here */

						/* First Transaction - customer loan account DEBIT */
						TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
						debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
						debitTrm.setTran_id(tranId);
						debitTrm.setPart_tran_id(partTranId1);
						debitTrm.setAcct_num(leasy.getLoan_accountno());
						debitTrm.setAcct_name(leasy.getCustomer_name());
						debitTrm.setTran_type("CASH");
						debitTrm.setPart_tran_type("Debit");
						debitTrm.setAcct_crncy(leasy.getLoan_currency());
						debitTrm.setTran_amt(leasy.getLoan_sanctioned());
						debitTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_date(leasy.getDate_of_loan());
						debitTrm.setValue_date(leasy.getDate_of_loan());
						debitTrm.setFlow_code("DISBT");
						debitTrm.setFlow_date(leasy.getDate_of_loan());
						debitTrm.setTran_status("ENTERED");
						debitTrm.setEntry_user(user);
						debitTrm.setEntry_time(tranvaldate);
						debitTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

						/* Second Transaction - CASH ON HAND ACCOUNT CREDIT */
						/* this account already existed in COA */
						String acct_num = "1100001120";
						Chart_Acc_Entity leasydebit = chart_Acc_Rep.getaedit(acct_num);

						TRAN_MAIN_TRM_WRK_ENTITY creditTrm = new TRAN_MAIN_TRM_WRK_ENTITY();

						creditTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
						creditTrm.setTran_id(tranId);
						creditTrm.setPart_tran_id(partTranId2);
						creditTrm.setAcct_num(leasydebit.getAcct_num());
						creditTrm.setAcct_name(leasydebit.getAcct_name());
						creditTrm.setTran_type("CASH");
						creditTrm.setPart_tran_type("Credit");
						creditTrm.setAcct_crncy(leasydebit.getAcct_crncy());
						creditTrm.setTran_amt(leasy.getLoan_sanctioned());
						creditTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_date(leasy.getDate_of_loan());
						creditTrm.setValue_date(leasy.getDate_of_loan());
						creditTrm.setFlow_code("DISBT");
						creditTrm.setFlow_date(leasy.getDate_of_loan());
						creditTrm.setTran_status("ENTERED");
						creditTrm.setEntry_user(user);
						creditTrm.setEntry_time(tranvaldate);
						creditTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

						/* update loan demand table Tran Details */

						String flowcode = "DISBT";
						String flowId = "1";

						DMD_TABLE demandFlow = dMD_TABLE_REPO.getDemandData(AccountNO, flowcode, flowId);
						demandFlow.setTran_id(tranId);
						demandFlow.setTran_date(leasy.getDate_of_loan());
						demandFlow.setPart_tran_id(partTranId1);
						demandFlow.setPart_tran_type("Debit");
						demandFlow.setModify_time(leasy.getDate_of_loan());
						demandFlow.setModify_user(user);
						demandFlow.setModify_flg("Y");

						dMD_TABLE_REPO.save(demandFlow);

					} else if (loandetails.getRecovery_method().equalsIgnoreCase("Office Routing Account")) {

						/* TRM table entry set here */

						/* First Transaction - customer loan account DEBIT */
						TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
						debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
						debitTrm.setTran_id(tranId);
						debitTrm.setPart_tran_id(partTranId1);
						debitTrm.setAcct_num(leasy.getLoan_accountno());
						debitTrm.setAcct_name(leasy.getCustomer_name());
						debitTrm.setTran_type("TRANSFER");
						debitTrm.setPart_tran_type("Debit");
						debitTrm.setAcct_crncy(leasy.getLoan_currency());
						debitTrm.setTran_amt(leasy.getLoan_sanctioned());
						debitTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						debitTrm.setTran_date(leasy.getDate_of_loan());
						debitTrm.setValue_date(leasy.getDate_of_loan());
						debitTrm.setFlow_code("DISBT");
						debitTrm.setFlow_date(leasy.getDate_of_loan());
						debitTrm.setTran_status("ENTERED");
						debitTrm.setEntry_user(user);
						debitTrm.setEntry_time(tranvaldate);
						debitTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

						/* Second Transaction - office Loan Account CREDIT */
						/* this account already existed in COA */
						String acct_num = "2700002750";
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
						creditTrm.setTran_amt(leasy.getLoan_sanctioned());
						creditTrm.setTran_particular(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_remarks(leasy.getLoan_accountno() + " Loan Disbursement");
						creditTrm.setTran_date(leasy.getDate_of_loan());
						creditTrm.setValue_date(leasy.getDate_of_loan());
						creditTrm.setFlow_code("DISBT");
						creditTrm.setFlow_date(leasy.getDate_of_loan());
						creditTrm.setTran_status("ENTERED");
						creditTrm.setEntry_user(user);
						creditTrm.setEntry_time(tranvaldate);
						creditTrm.setDel_flg("N");
						tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

						/* update loan demand table Tran Details */

						String flowcode = "DISBT";
						String flowId = "1";

						DMD_TABLE demandFlow = dMD_TABLE_REPO.getDemandData(AccountNO, flowcode, flowId);
						demandFlow.setTran_id(tranId);
						demandFlow.setTran_date(leasy.getDate_of_loan());
						demandFlow.setPart_tran_id(partTranId1);
						demandFlow.setPart_tran_type("Debit");
						demandFlow.setModify_time(leasy.getDate_of_loan());
						demandFlow.setModify_user(user);
						demandFlow.setModify_flg("Y");

						dMD_TABLE_REPO.save(demandFlow);
					}

				} else {

					System.out.println("The corporate Deposit Account Opening");

					/* deposit customer account verify */

					DepositEntity deposit = depositRep.getCustdataact(AccountNO);
					System.out.println("Deposit Account No : " + deposit.getDepo_actno());
					deposit.setEntity_flg("Y");
					deposit.setModify_flg("N");
					deposit.setDel_flg("N");

					depositRep.save(deposit);

					/* COA table entry - new Deposit Account of customer */
					DepositEntity depositevalue = depositRep.getCustdataactval(AccountNO);
					Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(depositevalue.getDepo_actno());
					coa.setAcct_name(depositevalue.getCust_name());
					coa.setAcct_crncy(depositevalue.getCurrency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(up.getTd_glcode());
					coa.setGl_desc(up.getTd_gldesc());
					coa.setGlsh_code(up.getTd_glshcode());
					coa.setGlsh_desc(up.getTd_glshdesc());
					coa.setSchm_code(up.getCa_scheme_code());
					coa.setSchm_type(up.getCa_schemetype());
					coa.setMobile_no(up.getCa_mobile_no_1());
					coa.setNational_id(up.getCa_idenditification_number());
					coa.setClassification("Liability");
					coa.setAdd_det_flg("C");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("D");

					chart_Acc_Rep.save(coa);

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
					creditTrm.setTran_amt(depositevalue.getDeposit_amt());
					creditTrm.setTran_particular(depositevalue.getDepo_actno() + " Principal Deposit");
					creditTrm.setTran_remarks(depositevalue.getDepo_actno() + " Principal Deposit");
					creditTrm.setTran_date(depositevalue.getDeposit_date());
					creditTrm.setValue_date(depositevalue.getDeposit_date());
					creditTrm.setFlow_code("PI");
					creditTrm.setFlow_date(depositevalue.getDeposit_date());
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(tranvaldate);
					creditTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

					/* Second Transaction - office Deposit Account DEBIT */
					/* this account already existed in COA */
					String acct_num = "1700001750";
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
					debitTrm.setTran_amt(depositevalue.getDeposit_amt());
					debitTrm.setTran_particular(depositevalue.getDepo_actno() + " Principal Deposit");
					debitTrm.setTran_remarks(depositevalue.getDepo_actno() + " Principal Deposit");
					debitTrm.setTran_date(depositevalue.getDeposit_date());
					debitTrm.setValue_date(depositevalue.getDeposit_date());
					debitTrm.setFlow_code("PI");
					debitTrm.setFlow_date(depositevalue.getDeposit_date());
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(tranvaldate);
					debitTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(debitTrm); // Save the second transaction

					/* update deposit demand table Tran Details */
					String flowcode = "PI";
					String flowId = "1";

					Td_defn_table flowRecords = td_defn_Repo.getFlowrecords(AccountNO, flowcode, flowId);
					flowRecords.setTran_date(tranvaldate);
					flowRecords.setTran_id(tranId);
					flowRecords.setPart_tran_id(partTranId1);
					flowRecords.setTran_amt(depositevalue.getDeposit_amt());
					flowRecords.setModify_user(user);
					flowRecords.setModify_time(tranvaldate);
					flowRecords.setModify_flg("Y");

					td_defn_Repo.save(flowRecords);

				}

			} else if (schmcodes.equals("JOINT ACCOUNT")) {

				System.out.println("The Joint Account Opening");

				Date tranvaldate = new Date();
				BigDecimal partTranId1 = BigDecimal.valueOf(1);
				BigDecimal partTranId2 = BigDecimal.valueOf(2);

				if (schmtypes.equals("LA")) {

					System.out.println("The corporate Loan Account Opening");

					/* verify customer lease account */
					Lease_Loan_Work_Entity leasy = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);
					String leaseAccountSaved = leaseLoanService.verifyleaseloan(AccountNO, user);
					System.out.println(leaseAccountSaved);

					/* COA table entry - new Loan Account of customer */
					Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(AccountNO);

					Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(loandetails.getLoan_accountno());
					coa.setAcct_name(loandetails.getCustomer_name());
					coa.setAcct_crncy(loandetails.getLoan_currency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(up.getLa_glcode());
					coa.setGl_desc(up.getLa_gldesc());
					coa.setGlsh_code(up.getLa_glshcode());
					coa.setGlsh_desc(up.getLa_glshdesc());
					coa.setSchm_code(up.getCa_scheme_code());
					coa.setSchm_type(up.getCa_schemetype());
					coa.setMobile_no(up.getCa_mobile_no_1());
					coa.setNational_id(up.getCa_idenditification_number());
					coa.setClassification("Asset");
					coa.setAdd_det_flg("N");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("L");

					chart_Acc_Rep.save(coa);

					/* TRM table entry set here */

					/* First Transaction - customer loan account DEBIT */
					TRAN_MAIN_TRM_WRK_ENTITY debitTrm = new TRAN_MAIN_TRM_WRK_ENTITY();
					debitTrm.setSrl_no(tRAN_MAIN_TRM_WRK_REP.gettrmRefUUID());
					debitTrm.setTran_id(tranId);
					debitTrm.setPart_tran_id(partTranId1);
					debitTrm.setAcct_num(leasy.getLoan_accountno());
					debitTrm.setAcct_name(leasy.getCustomer_name());
					debitTrm.setTran_type("TRANSFER");
					debitTrm.setPart_tran_type("Debit");
					debitTrm.setAcct_crncy(leasy.getLoan_currency());
					debitTrm.setTran_amt(leasy.getLoan_sanctioned());
					debitTrm.setTran_particular("LOAN DISBURSEMENT");
					debitTrm.setTran_remarks("LOAN DISBURSEMENT");
					debitTrm.setTran_date(tranvaldate);
					debitTrm.setValue_date(tranvaldate);
					debitTrm.setFlow_code("DISBT");
					debitTrm.setFlow_date(leasy.getDate_of_loan());
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(tranvaldate);
					debitTrm.setDel_flg("N");
					tRAN_MAIN_TRM_WRK_REP.save(debitTrm);

					/* Second Transaction - office Loan Account CREDIT */
					/* this account already existed in COA */
					String acct_num = "2700002750";
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
					creditTrm.setTran_amt(leasy.getLoan_sanctioned());
					creditTrm.setTran_particular("LOAN DISBURSEMENT");
					creditTrm.setTran_remarks("LOAN DISBURSEMENT");
					creditTrm.setTran_date(tranvaldate);
					creditTrm.setValue_date(tranvaldate);
					creditTrm.setFlow_code("DISBT");
					creditTrm.setFlow_date(leasy.getDate_of_loan());
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(tranvaldate);
					creditTrm.setDel_flg("N");
					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

				} else {

					System.out.println("The corporate Deposit Account Opening");

					/* deposit customer account verify */

					DepositEntity deposit = depositRep.getCustdataact(AccountNO);
					System.out.println("Deposit Account No : " + deposit.getDepo_actno());
					deposit.setEntity_flg("Y");
					deposit.setModify_flg("N");
					deposit.setDel_flg("N");

					depositRep.save(deposit);

					/* COA table entry - new Deposit Account of customer */
					DepositEntity depositevalue = depositRep.getCustdataactval(AccountNO);
					Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(depositevalue.getDepo_actno());
					coa.setAcct_name(depositevalue.getCust_name());
					coa.setAcct_crncy(depositevalue.getCurrency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(up.getTd_glcode());
					coa.setGl_desc(up.getTd_gldesc());
					coa.setGlsh_code(up.getTd_glshcode());
					coa.setGlsh_desc(up.getTd_glshdesc());
					coa.setSchm_code(up.getCa_scheme_code());
					coa.setSchm_type(up.getCa_schemetype());
					coa.setMobile_no(up.getCa_mobile_no_1());
					coa.setNational_id(up.getCa_idenditification_number());
					coa.setClassification("Liability");
					coa.setAdd_det_flg("C");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("D");

					chart_Acc_Rep.save(coa);

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
					creditTrm.setTran_amt(depositevalue.getDeposit_amt());
					creditTrm.setTran_particular("TERM DEPOSITE");
					creditTrm.setTran_remarks("TERM DEPOSITE PROCESSING");
					creditTrm.setTran_date(tranvaldate);
					creditTrm.setValue_date(tranvaldate);
					creditTrm.setFlow_code("PI");
					creditTrm.setFlow_date(depositevalue.getDeposit_date());
					creditTrm.setTran_status("ENTERED");
					creditTrm.setEntry_user(user);
					creditTrm.setEntry_time(tranvaldate);
					creditTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(creditTrm);

					/* Second Transaction - office Deposit Account DEBIT */
					/* this account already existed in COA */
					String acct_num = "1700001750";
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
					debitTrm.setTran_amt(depositevalue.getDeposit_amt());
					debitTrm.setTran_particular("TERM DEPOSITE");
					debitTrm.setTran_remarks("TERM DEPOSITE DISBURSEMENT");
					debitTrm.setTran_date(tranvaldate);
					debitTrm.setValue_date(tranvaldate);
					debitTrm.setFlow_code("PI");
					debitTrm.setFlow_date(depositevalue.getDeposit_date());
					debitTrm.setTran_status("ENTERED");
					debitTrm.setEntry_user(user);
					debitTrm.setEntry_time(tranvaldate);
					debitTrm.setDel_flg("N");

					tRAN_MAIN_TRM_WRK_REP.save(debitTrm); // Save the second transaction

				}

			} else {
				System.out.println("No Values Avilable For This Transaction");
			}

			if (up != null) {

				if (up.getCa_acct_type().equals("INDIVIDUAL")) {

					up.setStatus("APPROVED");
					up.setApproval_flg("Y");
					up.setVerify_time(new Date());
					up.setVerify_user(user);
					bACP_CUS_PROFILE_REPO.save(up);

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO2 = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO2);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}
					msg = "Account Approved Successfully " + AccountNo + "<br>";
					msg += "Customer Id: " + up.getCif_id() + "<br>";
					msg += "Reference No: " + ApprefNO + "<br>";
					msg += "Approved Name: " + username + " <br>";
					msg += "Approved Date: " + ComplianceDate + " ";
				} else {

					System.out.println("CORPORATE");
					up.setStatus("APPROVED");
					up.setApproval_flg("Y");
					up.setVerify_time(new Date());
					up.setVerify_user(user);
					bACP_CUS_PROFILE_REPO.save(up);

					CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(ApprefNO);
					String AccountNO2 = CifId.getLa_loan_accountno();
					String AccountNO1 = CifId.getTd_deposit_accountno();
					String AccountNo = null;
					Lease_Loan_Work_Entity LeaseAccount = lease_Loan_Work_Repo.getLeaseAccount(AccountNO2);
					DepositEntity DepositAccount = depositRep.getCustdataact(AccountNO1);
					if (CifId.getCa_schemetype().equals("LA")) {
						AccountNo = LeaseAccount.getLoan_accountno();
					} else {
						AccountNo = DepositAccount.getDepo_actno();
					}

					msg = "Account Approved Successfully " + AccountNo + "<br>";
					msg += "Reference No: " + ApprefNO + "<br>";
					msg += "Approved Name: " + username + " <br>";
					msg += "Approved Date: " + ComplianceDate + " ";

				}
			}
		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.getCa_preferred_name();
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());
			up.setHold_remarks(hold_remarks);
			up.setVerify_time(new Date());
			up.setVerify_user(user);
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.getCa_preferred_name();

			up.setVerify_time(new Date());
			up.setVerify_user(user);
			SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
			String ComplianceDate = compDate.format(new Date());
			up.setReject_remarks(reject_remarks);
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + "  Rejected";
		}

		else {

			msg = "Error Occured!!!";
		}

		Map<String, String> response = new HashMap<>();
		response.put("tranId", tranId);
		response.put("message", msg);
		return response;

	}

	@RequestMapping(value = "Approval", method = { RequestMethod.GET, RequestMethod.POST })
	public String approval(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("userid", userid);
		md.addAttribute("date", new Date());
		String loginuserid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("list")) {

			md.addAttribute("formmode", "list"); // to set which form - valid values are "edit" , "add" & "list"
			// md.addAttribute("customerRequest",
			// customerDetailsService.getCustomerSchemelist(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("view")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			// md.addAttribute("customerReq", depositRep.getCustdata(custid));
			System.out.println("3");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));


		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/Approval.html";
	}

	@RequestMapping(value = "ApprovalCorporate", method = { RequestMethod.GET, RequestMethod.POST })
	public String ApprovalCorporate(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("userid", userid);
		md.addAttribute("date", new Date());
		String loginuserid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("viewcorp")) {

			md.addAttribute("formmode", "viewcorp");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(appl_ref_no, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + appl_ref_no + " has been moved to HOLD LIST ";

		} else if (formmode.equals("view")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			// md.addAttribute("customerReq", depositRep.getCustdata(custid));
			System.out.println("3");

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(appl_ref_no, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + appl_ref_no + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/ApprovalCorporate.html";
	}

	@RequestMapping(value = "CustomerDetailForCor", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerDetailForCor(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));

		String loginuserid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("viewcorp")) {

			md.addAttribute("formmode", "viewcorp");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("ViewCorpEdit")) {
			md.addAttribute("formmode", "ViewCorpEdit");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
		}
		return "BACP/CustomerDetailForCor.html";
	}

	@RequestMapping(value = "ApprovalJoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String ApprovalJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("userid", userid);
		md.addAttribute("date", new Date());
		String loginuserid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("viewcorp")) {

			md.addAttribute("formmode", "viewcorp");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));
		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(appl_ref_no, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + appl_ref_no + " has been moved to HOLD LIST ";

		} else if (formmode.equals("view")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			// md.addAttribute("customerReq", depositRep.getCustdata(custid));
			System.out.println("3");

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(appl_ref_no, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + appl_ref_no + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/ApprovalJoint.html";
	}

	// for parameter

	@RequestMapping(value = "getModelForUseridAlert1", method = RequestMethod.GET)
	@ResponseBody
	public Object[] ModelForUseridAlert1(@RequestParam(required = false) String alr_user1)
			throws IOException, SQLException {
		System.out.println("alr_user1 ID " + alr_user1);
		return userProfileRep.getdetailsforalert(alr_user1);
	}

	@RequestMapping(value = "getModelForUseridAlert2", method = RequestMethod.GET)
	@ResponseBody
	public Object[] ModelForUseridAlert2(@RequestParam(required = false) String alr_user2)
			throws IOException, SQLException {
		System.out.println("alr_user1 ID " + alr_user2);
		return userProfileRep.getdetailsforalert(alr_user2);
	}

	@RequestMapping(value = "getModelForUseridAlert3", method = RequestMethod.GET)
	@ResponseBody
	public Object[] ModelForUseridAlert3(@RequestParam(required = false) String alr_user3)
			throws IOException, SQLException {
		System.out.println("alr_user1 ID " + alr_user3);
		return userProfileRep.getdetailsforalert(alr_user3);
	}

	@RequestMapping(value = "getModelForUseridAppr1", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getModelForUseridAppr1(@RequestParam(required = false) String apr_user1)
			throws IOException, SQLException {
		System.out.println("apr_user1 ID " + apr_user1);
		return userProfileRep.getdetailsforalert(apr_user1);
	}

	@RequestMapping(value = "getModelForUseridAppr2", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getModelForUseridAppr2(@RequestParam(required = false) String apr_user2)
			throws IOException, SQLException {
		System.out.println("apr_user1 ID " + apr_user2);
		return userProfileRep.getdetailsforalert(apr_user2);
	}

	@RequestMapping(value = "getModelForUseridAppr3", method = RequestMethod.GET)
	@ResponseBody
	public Object[] getModelForUseridAppr3(String apr_user3) throws IOException, SQLException {
		System.out.println("apr_user1 ID " + apr_user3);
		return userProfileRep.getdetailsforalert(apr_user3);
	}

	@RequestMapping(value = "CustInquiries", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustInquiries(@RequestParam(required = false) String formmode,
			@RequestParam(value = "refnumber", required = false) String refnumber,
			@RequestParam(value = "keynumber", required = false) String keynumber,
			@RequestParam(required = false) String Fromdate, @RequestParam(required = false) String Todate,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException

	{
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("inlist", minimalDataRepository.getInquirelist());
		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", "add");
		} else if (formmode.equals("proceed")) {
			md.addAttribute("formmode", "proceed");
		} else if (formmode.equals("edit")) {
			System.out.println(keynumber);
			md.addAttribute("formmode", "edit");
			md.addAttribute("inlist1", minimalDataRepository.findByapplref1(keynumber));

			md.addAttribute("inlist", aIRep.findbyId(keynumber));

		}

		else if (formmode.equals("reco")) {
			System.out.println(refnumber + "and" + keynumber);
			md.addAttribute("formmode", "reco");
			/*
			 * md.addAttribute("inlist1", UserProfileRep.getminimalData(keynumber));
			 * 
			 * md.addAttribute("inlist", UserProfileRep.getauditListLocal(refnumber,
			 * keynumber));
			 */

		}

		return "BACP/CustInquiries.html";
	}

	@RequestMapping(value = "ListForKyc", method = { RequestMethod.GET, RequestMethod.POST })
	public String ListForKyc(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("kyc", bACP_CUS_PROFILE_REPO.getkyclist());
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("view")) {
			md.addAttribute("UserId", userId);
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			System.out.println(bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			System.out.println("System.out.println(bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));\r\n"
					+ bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));

			md.addAttribute("formmode", "view");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();
			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/LISTFORKYC.html";
	}

	@RequestMapping(value = "ListForKycCorporate", method = { RequestMethod.GET, RequestMethod.POST })
	public String ListForKycCorporate(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("viewcorp")) {

			md.addAttribute("formmode", "viewcorp");
			md.addAttribute("UserId", userId);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/ListForKycCorporate.html";
	}

	@RequestMapping(value = "ListForKycJoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String ListForKycJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("viewJoint")) {

			md.addAttribute("formmode", "viewJoint");
			md.addAttribute("UserId", userId);
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO = CifId.getLa_loan_accountno();

			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("customerdata", depositRep.getCustdataact(AccountNO1));

			md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(AccountNO));
			md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(AccountNO));

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/ListForKycJoint.html";
	}

	@RequestMapping(value = "Customerinformation", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerInformation(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO, @RequestParam(required = false) String rec_no,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String appl_ref_no,
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req)
			throws ParseException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));
		System.out.println(appl_ref_no);

		if (formmode == null || formmode.equals("list")) {
			System.out.println("ggggggggggggggggg");
			md.addAttribute("kyc", bACP_CUS_PROFILE_REPO.getCSlist());
			System.out.println(bACP_CUS_PROFILE_REPO.getCSlist());

			md.addAttribute("formmode", "list");

			System.out.println("1");
		} else if (formmode.equals("view")) {
			System.out.println("hiihihihihihihihihihihi");
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			System.out.println(bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			System.out.println(bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			System.out.println(bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			System.out.println("System.out.println(bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));\r\n"
					+ bACP_CUS_PROFILE_REPO.getCS(appl_ref_no));
			md.addAttribute("formmode", "view");

		} else if (formmode.equals("Holdfin")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("HOLD");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been moved to HOLD LIST ";

		} else if (formmode.equals("Reject_acc")) {
			CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			up.setStatus("REJECT");
			up.setApproval_flg("Y");
			bACP_CUS_PROFILE_REPO.save(up);
			msg = "Reference No: " + ApprefNO + " has been REJECTED and moved to HOLD LIST ";
		}
		System.out.println("4");
		return "BACP/Custinformation.html";

	}

	@Controller
	public class BacpWorkFlowController {

		@PostMapping("/submitWorkflow")
		@ResponseBody
		public ResponseEntity<String> submitWorkflowData(@RequestBody Bacp_WorkFLow_Entity workflowData) {
			// Process the workflowData here, e.g., save it to the repository
			workflowData.setDel_flag("N");
			workflowData.setModify_flag("N");
			workflowData.setEntity_flag("N");
			bacp_WorkFLow_Repo.save(workflowData);
			return ResponseEntity.ok("Work Flow Submitted Successfully");
		}
	}

	@RequestMapping(value = "ParameterMod", method = RequestMethod.POST)
	@ResponseBody
	public String ParameterMod(@RequestParam(required = false) String refnumber,
			@RequestBody ParametersDetails parametersde, Model md, HttpServletRequest rq) {
		System.out.println("parametersde" + parametersde.getGlsh());
		String userId = (String) rq.getSession().getAttribute("USERID");
		ParametersDetails up = parameterrep.findbyId(refnumber);
		parametersde.setEntity_cre_flg("Y");
		parametersde.setDocuments_flg("Y");
		parametersde.setAlert_flg("Y");
		parametersde.setApproval_flg("Y");
		parametersde.setModify_flg("Y");
		parametersde.setModify_user(userId);
		parametersde.setVerify_flg("N");
		parametersde.setDel_flg("N");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = now.format(formatter);
		parametersde.setModify_time(formattedDate);
		parameterrep.save(parametersde);
		String msg = "Modified Succesfully";
		return msg;

	}

	@RequestMapping(value = "ParameterVerify", method = RequestMethod.POST)
	@ResponseBody
	public String ParameterVerify(@RequestParam(required = true) String refnumber, Model md, HttpServletRequest rq,
			@ModelAttribute ParametersDetails parametersde) {
		String userId = (String) rq.getSession().getAttribute("USERID");

		ParametersDetails up = parameterrep.findbyId(refnumber);
		parametersde.setVerify_user(userId);
		parametersde.setVerify_flg("Y");
		parametersde.setDel_flg("N");
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();

		// Define a date-time formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Format the current date and time as a string
		String formattedDate = now.format(formatter);

		// Assuming parametersde is an object with a setModify_time method that accepts
		// a String

		parametersde.setVerify_time(formattedDate);
		parameterrep.save(parametersde);

		/* String userid = (String) rq.getSession().getAttribute("USERID"); */

		String msg = "Verified Succesfully";

		return msg;

	}

	@RequestMapping(value = "DocumenCall", method = RequestMethod.POST)
	@ResponseBody
	public List<Reference_Code_Entity> DocumenCall(Model md, HttpServletRequest rq) {

		return reference_code_Rep.getdoctype();
	}

	public byte[] getPhoto(byte[] photoBytes) {
		// Ensure the byte array is not null or empty
		if (photoBytes == null || photoBytes.length == 0) {
			throw new IllegalArgumentException("Photo bytes cannot be null or empty");
		}

		// Return the byte array directly or perform any processing you need
		return photoBytes; // or process it further if necessary
	}

	@PostMapping(value = "/AddSigCor")
	public ResponseEntity<String> handleFormSubmission(@RequestPart("scheduler") List<Bacp_Signature_master> requests,
			@RequestParam("photo") List<MultipartFile> photoFiles, @RequestParam("sign") List<MultipartFile> signFiles,
			@RequestParam(required = true) String cif_id) throws SQLException, IOException {

		// Check if requests is empty
		if (requests.isEmpty()) {
			return ResponseEntity.badRequest().body("No data received.");
		}
		System.out.println(signFiles + "signFilessignFilessignFiles");
		for (int i = 0; i < requests.size(); i++) {
			Bacp_Signature_master request = requests.get(i);

			// Print all fields of the request object
			System.out.println("Received Bacp_Signature_master request: ");
			System.out.println("applRefNo: " + request.getAppl_ref_no());
			System.out.println("recNo: " + request.getRec_no());
			System.out.println("imgAccessCode: " + request.getImg_access_code());
			System.out.println("imgGroup: " + request.getImg_group());
			System.out.println("keyword: " + request.getKeyword());

			// Create a new instance of Bacp_Signature_master
			Bacp_Signature_master valueget = new Bacp_Signature_master();

			// Fetch the next serial number
			Integer srlno = bacp_Signature_masterRepo.srlnum();

			if (srlno == null) {
				return ResponseEntity.badRequest().body("Failed to generate serial number.");
			}

			valueget.setSrl_no(srlno);
			valueget.setAppl_ref_no(request.getAppl_ref_no());
			valueget.setRec_no(request.getRec_no());
			valueget.setImg_access_code(request.getImg_access_code());
			valueget.setImg_group(request.getImg_group());
			valueget.setKeyword(request.getKeyword());
			valueget.setCif_id(cif_id);
			valueget.setDel_flg("N");

			// Handle photo file
			if (i < photoFiles.size() && photoFiles.get(i) != null && !photoFiles.get(i).isEmpty()) {
				try {
					byte[] photoBytes = photoFiles.get(i).getBytes(); // Get bytes from the photo file
					valueget.setPhoto(photoBytes); // Set the photo bytes in the entity
					System.out.println("Photo file length: " + photoBytes.length + ", Name: "
							+ photoFiles.get(i).getOriginalFilename());
				} catch (IOException e) {
					return ResponseEntity.badRequest().body("Error processing photo file: " + e.getMessage());
				}
			} else {
				System.out.println("No photo file provided for row " + i);
			}

			// Handle signature file
			if (i < signFiles.size() && signFiles.get(i) != null && !signFiles.get(i).isEmpty()) {
				try {
					byte[] signBytes = signFiles.get(i).getBytes(); // Get bytes from the signature file
					Blob signBlob = new SerialBlob(signBytes);
					valueget.setSign(signBlob); // Set the signature blob in the entity
					System.out.println("Signature file length: " + signBytes.length + ", Name: "
							+ signFiles.get(i).getOriginalFilename());
				} catch (IOException e) {
					return ResponseEntity.badRequest().body("Error processing signature file: " + e.getMessage());
				}
			} else {
				System.out.println("No signature file provided for row " + i);
			}

			// Save the Bacp_Signature_master entity to the database
			bacp_Signature_masterRepo.save(valueget);
		}

		return ResponseEntity.ok("Form submitted successfully.");
	}

	@RequestMapping(value = "/getimagescor", method = { RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<List<String>> getimagescor(@RequestParam(required = false) String appl_ref_no)
			throws SQLException {
		System.out.println("get the images" + appl_ref_no);

		try {
			System.out.println("inside");
			List<Bacp_Signature_master> vv = bacp_Signature_masterRepo.findByref_no(appl_ref_no);

			// Check if the list is not empty
			if (vv == null || vv.isEmpty()) {
				return ResponseEntity.ok(Arrays.asList("No records found for the given reference number"));
			}

			List<String> base64Images = new ArrayList<>(); // List to hold Base64 encoded images

			for (Bacp_Signature_master signature : vv) {
				InputStream inputStream = signature.getSign().getBinaryStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int bytesRead;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					byteArrayOutputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = byteArrayOutputStream.toByteArray();

				// Convert the byte array to Base64 String
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				// System.out.println(base64Image + "
				// hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

				// Add the Base64 string to the list (adjust mime-type based on image format)
				base64Images.add("data:image/png;base64," + base64Image);
			}

			// Return the list of Base64 encoded image strings
			return ResponseEntity.ok(base64Images);

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.ok(Arrays.asList("No records found for the given reference number"));
		}
	}

	@RequestMapping(value = "/getimagesonecor", method = { RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<List<String>> getimagesssone(@RequestParam(required = false) String appl_ref_no, Model md,
			HttpServletRequest req) throws SQLException {
		System.out.println("inside imagesone");

		int srlno = 286;
		// List<Bacp_Signature_master> vv =
		// bacp_Signature_masterRepo.findByref_no1(appl_ref_no,srlno);
		List<Bacp_Signature_master> vv = bacp_Signature_masterRepo.findByref_no(appl_ref_no);

		// Check if the list is not empty
		if (vv == null || vv.isEmpty()) {
			return ResponseEntity.ok(Arrays.asList("No records found for the given reference number"));
		}

		List<String> base64FileDataList = new ArrayList<>();

		// Iterate over the retrieved records and convert each photo to Base64
		for (Bacp_Signature_master signature : vv) {
			System.out.println(signature.getSrl_no());
			byte[] photoData = signature.getPhoto();
			if (photoData != null) {
				String base64FileData = Base64.getEncoder().encodeToString(photoData);
				base64FileDataList.add(base64FileData); // Add Base64 string to the list
				// System.out.println(base64FileData + " hiii from list"); // Optional: Print
				// each Base64 string for debugging
			} else {
				base64FileDataList.add("Photo content is null");
			}
		}

		return ResponseEntity.ok(base64FileDataList); // Return the list of Base64 encoded strings
	}

	@RequestMapping(value = "Onschemetype1document", method = RequestMethod.GET)
	@ResponseBody
	public ParametersDetails Onschemetype1document(@RequestParam(required = false) String schemetype,
			HttpServletRequest req) {
		System.out.println("-----------------------------------" + schemetype);
		if (schemetype != null && !schemetype.isEmpty()) {
			return parameterrep.findbyIdschmcode(schemetype);
		} else {
			// Handle case where 'a' is null or empty
			// You may return a default response or throw an exception
			return null; // or throw new IllegalArgumentException("Parameter 'a' is required");
		}
	}

	@RequestMapping(value = "Onschemetype1cordocument", method = RequestMethod.GET)
	@ResponseBody
	public ParametersDetails Onschemetype1cordocument(@RequestParam(required = false) String schemetype,
			HttpServletRequest req) {
		System.out.println("-----------------------------------" + schemetype);
		if (schemetype != null && !schemetype.isEmpty()) {
			return parameterrep.findbyIdschmcode(schemetype);
		} else {
			// Handle case where 'a' is null or empty
			// You may return a default response or throw an exception
			return null; // or throw new IllegalArgumentException("Parameter 'a' is required");
		}
	}

	@RequestMapping(value = "CustomerTEST", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerTEST(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String acct_num, String keyword, Model md, HttpServletRequest req) {
		String arnNo = "ARN0" + minimalDataRepository.ARNNO();
		System.out.println(arnNo + "yyyyyyyy");
		md.addAttribute("appreNO", arnNo);
		return "CustomerTEST";
	}

	@PostMapping("/multilinetest")
	@ResponseBody
	public List<String> upLoadForm1test(@RequestBody List<DynamicFromValue> dynamicValues, MultipartFile file,
			@RequestParam(value = "appl_ref_no", required = false) String appl_ref_no,
			@RequestParam(value = "rec_no", required = false) String rec_no) {

		System.out.println("The rec no is " + rec_no);
		System.err.println(" size " + file.getOriginalFilename() + file.getContentType());
		System.out.println(dynamicValues);
		List<BACP_DOC_MAN_ENTITY> list_of_bacp_record = new ArrayList<>();
		for (DynamicFromValue dynamic : dynamicValues) {
			System.err.println(" size " + dynamicValues.size());
			BACP_DOC_MAN_ENTITY bdcm = new BACP_DOC_MAN_ENTITY();
			bdcm.setFile_name(dynamic.getFilename());
			bdcm.setDocument_type(dynamic.getDoctype());
			bdcm.setDocument_code(dynamic.getDoccode());
			bdcm.setDocument_type_desc(dynamic.getDoctypesesc());
			bdcm.setUnique_id(dynamic.getUniqueid());
			bdcm.setPlace_of_issue(dynamic.getPlaceofissue());
			bdcm.setIssue_date(dynamic.getIssuedate());
			bdcm.setExpiry_date(dynamic.getExprydate());
			bdcm.setAppl_ref_no(appl_ref_no);
			bdcm.setRec_no(rec_no);
			bdcm.setDel_flg("N");
			bacpRep.save(bdcm);
			list_of_bacp_record.add(bdcm);
		}
		try {
			bacpRep.saveAll(list_of_bacp_record);
			List<String> uniquelist = list_of_bacp_record.stream().map(e -> e.getUnique_id())
					.collect(Collectors.toList());
			return uniquelist;
		} catch (Exception e) {
			return new ArrayList();
		}

	}

	@PostMapping("/submit")
	public String handleFormSubmit(@RequestParam("docType") String[] doctype, @RequestParam("docCode") String[] doccode,
			@RequestParam("docDesc") String[] doctypesesc, @RequestParam("uniqId") String[] uniqueid,
			@RequestParam("docIssPlace") String[] placeofissue, @RequestParam("docIssDate") String[] issuedate,
			@RequestParam("docExpDate") String[] exprydate, @RequestParam("appl_ref_no") String[] appl_ref_no,
			@RequestParam("uploadfile") MultipartFile[] files, RedirectAttributes redirectAttributes) {

		for (int i = 0; i < doctype.length; i++) {
			try {
				saveFileData(doctype[i], doccode[i], doctypesesc[i], uniqueid[i], placeofissue[i], issuedate[i],
						exprydate[i], appl_ref_no[i], i, files[i]);
			} catch (IOException e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("message", "File upload failed for: " + uniqueid[i]);
				return "redirect:/";
			}
		}

		redirectAttributes.addFlashAttribute("message", "All files uploaded successfully!");
		return "redirect:/";
	}

	public void saveFileData(String Doctype, String Doccode, String Doctypesesc, String Uniqueid, String Placeofissue,
			String Issuedate, String Exprydate, String appl_ref_no, int rec_i, MultipartFile file) throws IOException {
		/*
		 * BACP_DOC_MAN_ENTITY fileData = new BACP_DOC_MAN_ENTITY();
		 * fileData.setName(name); fileData.setDescription(description);
		 * fileData.setFileContent(file.getBytes());
		 * fileData.setFileName(file.getOriginalFilename());
		 * fileData.setFileType(file.getContentType());
		 */

		BACP_DOC_MAN_ENTITY bdcm = new BACP_DOC_MAN_ENTITY();
		bdcm.setFile_name(file.getOriginalFilename());
		bdcm.setPath(file.getContentType());
		bdcm.setUpd_file(file.getBytes());
		bdcm.setDocument_type(Doctype);
		bdcm.setDocument_code(Doccode);
		bdcm.setDocument_type_desc(Doctypesesc);
		bdcm.setUnique_id(Uniqueid);
		bdcm.setPlace_of_issue(Placeofissue);
		bdcm.setIssue_date(Issuedate);
		bdcm.setExpiry_date(Exprydate);
		bdcm.setAppl_ref_no(appl_ref_no);
		bdcm.setRec_no(Integer.toString(rec_i, 1));
		bacpRep.save(bdcm);

	}

	@GetMapping("/{uniqueId}")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> viewOrDownloadFile(@PathVariable String uniqueId) {
		System.out.println("Unique ID: " + uniqueId);

		BACP_DOC_MAN_ENTITY document = bacpRep.findByUnique1(uniqueId);

		if (document != null) {
			byte[] documentContent = document.getUpd_file();
			String fileName = document.getFile_name();
			String fileType = determineFileType(fileName);

			// Log the file type
			System.out.println("File Type: " + fileType);

			ByteArrayResource resource = new ByteArrayResource(documentContent);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"")
					.contentType(MediaType.parseMediaType(fileType)).contentLength(documentContent.length)
					.header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate")
					.header(HttpHeaders.PRAGMA, "no-cache").header(HttpHeaders.EXPIRES, "0").body(resource);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	private String determineFileType(String fileName) {
		if (fileName.endsWith(".png")) {
			return "image/png";
		} else if (fileName.endsWith(".pdf")) {
			return "application/pdf";
		} else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".jfif")) {
			return "image/jpeg";
		} else if (fileName.endsWith(".mp4")) {
			return "video/mp4";
		} else if (fileName.endsWith(".xls")) {
			return "application/vnd.ms-excel"; // MIME type for .xls
		} else if (fileName.endsWith(".xlsx")) {
			return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"; // MIME type for .xlsx
		} else {
			return "application/octet-stream"; // Fallback MIME type
		}
	}

	@RequestMapping(value = "CustomerMaintenance", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerMaintenance(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String count, Model md,
			HttpServletRequest req) {

		String userid = (String) req.getSession().getAttribute("USERID");

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getcustlist());
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("retailclick")) {
			System.out.println(bACP_CUS_PROFILE_REPO.getretaillist());
			md.addAttribute("formmode", "retailclick");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getretaillist());
		} else if (formmode.equals("Corporateclick")) {
			System.out.println(bACP_CUS_PROFILE_REPO.getcorplist());
			md.addAttribute("formmode", "Corporateclick");
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getcorplist());
		} else if (formmode.equals("viewCust")) {
			md.addAttribute("formmode", "viewCust");

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}

			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
		} else if (formmode.equals("EditCust")) {
			md.addAttribute("formmode", "EditCust");

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}

			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());
			md.addAttribute("appreNO", appl_ref_no);
			List<Bacp_Signature_master> signatureList = bacp_Signature_masterRepo.findByref_no(appl_ref_no);

			 List<String[]> base64FileDataList = new ArrayList<>();

			    for (Bacp_Signature_master signature : signatureList) {
			        // Get the necessary data for each entry
			        String textValue1 = signature.getImg_access_code();
			        String textValue3 = signature.getImg_group();
			        String textValue2 = signature.getKeyword();
			        byte[] base64SignatureBlob = signature.getPhoto(); // Base64 encoded image data

			        // Convert the photo to a Base64 string
			        String base64String = "";
			        if (base64SignatureBlob != null) {
			            base64String = Base64.getEncoder().encodeToString(base64SignatureBlob);
			        }

			        InputStream inputStream = null;
			        ByteArrayOutputStream byteArrayOutputStream = null;

			        try {
			            if (signature != null && signature.getSign() != null) {
			                inputStream = signature.getSign().getBinaryStream();
			            } else {
			                // Log or handle the null cases appropriately
			                if (signature == null) {
			                    System.err.println("Signature object is null.");
			                } else {
			                    System.err.println("Signature data is null.");
			                }
			                // Skip this signature as it has no sign data
			                continue;
			            }

			            byteArrayOutputStream = new ByteArrayOutputStream();
			            byte[] buffer = new byte[1024];
			            int bytesRead;

			            while ((bytesRead = inputStream.read(buffer)) != -1) {
			                byteArrayOutputStream.write(buffer, 0, bytesRead);
			            }

			            byte[] imageBytes = byteArrayOutputStream.toByteArray();
			            String base64Image_sign = Base64.getEncoder().encodeToString(imageBytes);

			            System.out.println(base64Image_sign + " base64Image_sign");
			            String srl_no = signature.getSrl_no().toString();

			            base64FileDataList.add(new String[]{textValue1, textValue3, textValue2, base64String, base64Image_sign,srl_no});

			        } catch (SQLException | IOException e) {
			            e.printStackTrace();
			            // Handle exceptions appropriately
			        } finally {
			            // Close the input stream if it was opened
			            if (inputStream != null) {
			                try {
			                    inputStream.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			            // Close the byte array output stream
			            if (byteArrayOutputStream != null) {
			                try {
			                    byteArrayOutputStream.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			        }
			    }


			md.addAttribute("SIGNATURE", base64FileDataList);


		} else if (formmode.equals("VerifyCust")) {
			md.addAttribute("formmode", "VerifyCust");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();
			md.addAttribute("appreNO", appl_ref_no);
			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());
		} else {
			System.out.println("Error occured");
		}

		return "BACP/CustomerMaintenance.html";
	}

	@RequestMapping(value = "CustMaintCorp", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustMaintCorp(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) throws SQLException, IOException {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));

		String userid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("viewCust")) {

			md.addAttribute("formmode", "viewCust");

			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}

		} else if (formmode.equals("EditCust")) {
			md.addAttribute("formmode", "EditCust");
			md.addAttribute("appreNO", appl_ref_no);
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());

			List<Bacp_Signature_master> signatureList = bacp_Signature_masterRepo.findByref_no(appl_ref_no);

			 List<String[]> base64FileDataList = new ArrayList<>();

			    for (Bacp_Signature_master signature : signatureList) {
			        // Get the necessary data for each entry
			        String textValue1 = signature.getImg_access_code();
			        String textValue3 = signature.getImg_group();
			        String textValue2 = signature.getKeyword();
			        byte[] base64SignatureBlob = signature.getPhoto(); // Base64 encoded image data

			        // Convert the photo to a Base64 string
			        String base64String = "";
			        if (base64SignatureBlob != null) {
			            base64String = Base64.getEncoder().encodeToString(base64SignatureBlob);
			        }

			        InputStream inputStream = null;
			        ByteArrayOutputStream byteArrayOutputStream = null;

			        try {
			            if (signature != null && signature.getSign() != null) {
			                inputStream = signature.getSign().getBinaryStream();
			            } else {
			                // Log or handle the null cases appropriately
			                if (signature == null) {
			                    System.err.println("Signature object is null.");
			                } else {
			                    System.err.println("Signature data is null.");
			                }
			                // Skip this signature as it has no sign data
			                continue;
			            }

			            byteArrayOutputStream = new ByteArrayOutputStream();
			            byte[] buffer = new byte[1024];
			            int bytesRead;

			            while ((bytesRead = inputStream.read(buffer)) != -1) {
			                byteArrayOutputStream.write(buffer, 0, bytesRead);
			            }

			            byte[] imageBytes = byteArrayOutputStream.toByteArray();
			            String base64Image_sign = Base64.getEncoder().encodeToString(imageBytes);

			            System.out.println(base64Image_sign + " base64Image_sign");
			            String srl_no = signature.getSrl_no().toString();

			            base64FileDataList.add(new String[]{textValue1, textValue3, textValue2, base64String, base64Image_sign,srl_no});

			        } catch (SQLException | IOException e) {
			            e.printStackTrace();
			            // Handle exceptions appropriately
			        } finally {
			            // Close the input stream if it was opened
			            if (inputStream != null) {
			                try {
			                    inputStream.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			            // Close the byte array output stream
			            if (byteArrayOutputStream != null) {
			                try {
			                    byteArrayOutputStream.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			        }
			    }


			md.addAttribute("SIGNATURE", base64FileDataList);


			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}
		} else if (formmode.equals("VerifyCust")) {
			md.addAttribute("formmode", "VerifyCust");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}
		} else {
			System.out.println("Error occured");
		}
		return "BACP/CustMaintCorp.html";
	}

	private String convertBlobToString(Blob base64Signature) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "CustMaintJoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustMaintJoint(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String userId = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userId));

		String userid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("menu", "UserProfile"); // To highlight the menu

		if (formmode == null || formmode.equals("viewCust")) {

			md.addAttribute("formmode", "viewCust");
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.getApprovelist());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", rec_no);
			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("DocumentList", bacpRep.findByAppl(appl_ref_no));
			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}

		} else if (formmode.equals("EditCust")) {
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());
			md.addAttribute("formmode", "EditCust");
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");

			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));
			md.addAttribute("appreNO", appl_ref_no);
			List<Bacp_Signature_master> signatureList = bacp_Signature_masterRepo.findByref_no(appl_ref_no);

			 List<String[]> base64FileDataList = new ArrayList<>();

			    for (Bacp_Signature_master signature : signatureList) {
			        // Get the necessary data for each entry
			        String textValue1 = signature.getImg_access_code();
			        String textValue3 = signature.getImg_group();
			        String textValue2 = signature.getKeyword();
			        byte[] base64SignatureBlob = signature.getPhoto(); // Base64 encoded image data

			        // Convert the photo to a Base64 string
			        String base64String = "";
			        if (base64SignatureBlob != null) {
			            base64String = Base64.getEncoder().encodeToString(base64SignatureBlob);
			        }

			        InputStream inputStream = null;
			        ByteArrayOutputStream byteArrayOutputStream = null;

			        try {
			            if (signature != null && signature.getSign() != null) {
			                inputStream = signature.getSign().getBinaryStream();
			            } else {
			                // Log or handle the null cases appropriately
			                if (signature == null) {
			                    System.err.println("Signature object is null.");
			                } else {
			                    System.err.println("Signature data is null.");
			                }
			                // Skip this signature as it has no sign data
			                continue;
			            }

			            byteArrayOutputStream = new ByteArrayOutputStream();
			            byte[] buffer = new byte[1024];
			            int bytesRead;

			            while ((bytesRead = inputStream.read(buffer)) != -1) {
			                byteArrayOutputStream.write(buffer, 0, bytesRead);
			            }

			            byte[] imageBytes = byteArrayOutputStream.toByteArray();
			            String base64Image_sign = Base64.getEncoder().encodeToString(imageBytes);

			            System.out.println(base64Image_sign + " base64Image_sign");
			            String srl_no = signature.getSrl_no().toString();

			            base64FileDataList.add(new String[]{textValue1, textValue3, textValue2, base64String, base64Image_sign,srl_no});

			        } catch (SQLException | IOException e) {
			            e.printStackTrace();
			            // Handle exceptions appropriately
			        } finally {
			            // Close the input stream if it was opened
			            if (inputStream != null) {
			                try {
			                    inputStream.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			            // Close the byte array output stream
			            if (byteArrayOutputStream != null) {
			                try {
			                    byteArrayOutputStream.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			        }
			    }


			md.addAttribute("SIGNATURE", base64FileDataList);


			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}
		} else if (formmode.equals("VerifyCust")) {
			md.addAttribute("formmode", "VerifyCust");
			md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
			md.addAttribute("SIGNATURE", bacp_Signature_masterRepo.findByref_no(appl_ref_no));
			md.addAttribute("user", userid);
			md.addAttribute("currentDate", new Date());
			md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
			md.addAttribute("holdlistcount", "1");
			md.addAttribute("holdlistcountdub", "88");
			md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));

			CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
			String AccountNO2 = CifId.getLa_loan_accountno();
			String AccountNO1 = CifId.getTd_deposit_accountno();

			System.out.println(AccountNO2 + "AccountNO");
			System.out.println(AccountNO1 + "AccountNO1");

			if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
				CustomerRequest getDDDetailsLa1 = bACP_CUS_PROFILE_REPO.FindByLeaseAccount(AccountNO2);
				if (getDDDetailsLa1 != null) {
					md.addAttribute("getDDDetailsLa1", getDDDetailsLa1);
				}

			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsLa1", Collections.emptyList());
			}

			if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
				CustomerRequest getDDDetailsTd1 = bACP_CUS_PROFILE_REPO.FindByDepositAccount(AccountNO1);
				if (getDDDetailsTd1 != null) {
					md.addAttribute("getDDDetailsTd1", getDDDetailsTd1);
				}
			} else { // Optionally, add an empty list or a default value
				md.addAttribute("getDDDetailsTd1", Collections.emptyList());
			}

			// Check the scheme type first
			String schemeType = CifId.getCa_schemetype();
			if (schemeType != null && !schemeType.trim().isEmpty()) {
				if (schemeType.equals("LA")) {
					// Check if AccountNO2 is valid
					if (AccountNO2 != null && !AccountNO2.trim().isEmpty()) {
						md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO2));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO2));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO2));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO2));
					} else {
						// Handle case when AccountNO2 is null or empty
						md.addAttribute("getDDDetailsLa", "Lease account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else if (schemeType.equals("TD")) {
					// Check if AccountNO1 is valid
					if (AccountNO1 != null && !AccountNO1.trim().isEmpty()) {
						md.addAttribute("getDDDetailsTd", depositRep.getCustdataact(AccountNO1));
						md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(AccountNO1));
						md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(AccountNO1));
						md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(AccountNO1));
						md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(AccountNO1));
					} else {
						// Handle case when AccountNO1 is null or empty
						md.addAttribute("getDDDetailsTd", "Deposit account number is required.");
						md.addAttribute("jour", "No transaction data available.");
						md.addAttribute("Chartacctbal", "No balance data available.");
						md.addAttribute("ChartbalIndicator", "No indicator data available.");
						md.addAttribute("CustIdName", "No customer name data available.");
					}
				} else {
					// Handle case when schemeType is neither "LA" nor "TD"
					md.addAttribute("error", "Invalid scheme type specified.");
				}
			} else {
				// Handle case when schemeType is null or empty
				md.addAttribute("error", "Scheme type is required.");
			}
		} else {
			System.out.println("Error occured");
		}
		return "BACP/CustMaintJoint.html";
	}

	@RequestMapping(value = "/userprofileimage", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> userprofileimage(@RequestParam(required = false) String userphoto)
			throws SQLException {
		System.out.println("Getting the image for employee ID: " + userphoto);

		// Fetch employee profile data based on employee ID
		Employee_Profile employee_Profile = employee_Profile_Rep.getEmployeeData(userphoto);

		// Check if the employee profile is found
		if (employee_Profile == null) {
			System.out.println("No records found for the given employee ID");
			return ResponseEntity.ok("No records found for the given employee ID");
		}

		byte[] employeePhoto = employee_Profile.getEmployee_Photo();
		System.out.println("second step");

		// Check if the employee photo is available
		if (employeePhoto != null) {
			System.out.println("Third step");
			String base64FileData = Base64.getEncoder().encodeToString(employeePhoto);
			// System.out.println("Base64 encoded image data: " + base64FileData);
			return ResponseEntity.ok(base64FileData); // Return the Base64 string
		} else {
			return ResponseEntity.ok("Photo content is null");
		}
	}

	@RequestMapping(value = "CustomerMaintenanceFromLease", method = { RequestMethod.GET, RequestMethod.POST })
	public String CustomerMaintenanceFromLeaseforcust(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String customer_id, @RequestParam(required = false) String loanAcctNo,
			@RequestParam(required = false) String count, Model md, HttpServletRequest req) {

		String userid = (String) req.getSession().getAttribute("USERID");
		CustomerRequest CifId1 = bACP_CUS_PROFILE_REPO.findByCustId(customer_id);
		CustomerRequest CifIdcor = bACP_CUS_PROFILE_REPO.findByCustIdCor(customer_id);

		if (CifIdcor != null && "CORPORATE".equals(CifIdcor.getCa_acct_type())) {
			populateModelAttributesforcorp(customer_id, loanAcctNo, md, req);
			return "BACP/CustMaintCorp.html";
		} else if (CifIdcor != null && "JOINT ACCOUNT".equals(CifIdcor.getCa_acct_type())) {
			populateModelAttributesforcorp(customer_id, loanAcctNo, md, req);
			return "BACP/CustMaintJoint.html";
		} else if (CifId1 != null && "INDIVIDUAL".equals(CifId1.getCa_acct_type())) {
			populateModelAttributes(customer_id, loanAcctNo, md, req);
			return "BACP/CustomerMaintenance.html";
		}

		return "added";

	}

	private void populateModelAttributes(String customer_id, String loanAcctNo, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");

		CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByCustId(customer_id);
		String appl_ref_no = CifId.getAppl_ref_no();

		md.addAttribute("formmode", "viewCust");
		md.addAttribute("getDDDetailsLa1", CifId);
		md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(loanAcctNo));
		md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(loanAcctNo));
		md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(loanAcctNo));
		md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(loanAcctNo));
		md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(loanAcctNo));
		md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
		md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
		md.addAttribute("holdlistcount", "1");
		md.addAttribute("holdlistcountdub", "88");
		md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));
		md.addAttribute("user", userid);
		md.addAttribute("currentDate", new Date());
		md.addAttribute("appl_ref_no", appl_ref_no);
	}

	private void populateModelAttributesforcorp(String customer_id, String loanAcctNo, Model md,
			HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");

		CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByCustIdCor(customer_id);
		String appl_ref_no = CifId.getAppl_ref_no();
		String rec_no = CifId.getRec_no();
		md.addAttribute("formmode", "viewCust");
		md.addAttribute("getDDDetailsLa1", CifId);
		md.addAttribute("holdlistcount", "1");
		md.addAttribute("holdlistcountdub", rec_no);
		md.addAttribute("getDDDetailsLa", lease_Loan_Work_Repo.getLeaseAccount(loanAcctNo));
		md.addAttribute("jour", tRAN_MAIN_TRM_WRK_REP.findbyacctno(loanAcctNo));
		md.addAttribute("Chartacctbal", chart_Acc_Rep.getacctbal(loanAcctNo));
		md.addAttribute("ChartbalIndicator", chart_Acc_Rep.getaedit(loanAcctNo));
		md.addAttribute("CustIdName", lease_Loan_Work_Repo.getLeaseAccount(loanAcctNo));
		md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
		md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));
		md.addAttribute("holdlistcount", "1");
		md.addAttribute("holdlistcountdub", "88");
		md.addAttribute("holdlistsize", minimalDataRepository.findByapplrefcount(appl_ref_no));
		md.addAttribute("user", userid);
		md.addAttribute("currentDate", new Date());
		md.addAttribute("appl_ref_no", appl_ref_no);
	}

	@RequestMapping(value = "ApprovalFromLease", method = { RequestMethod.GET, RequestMethod.POST })
	public String ApprovalFromLease(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String customer_id, @RequestParam(required = false) String loanAcctNo,
			@RequestParam(required = false) String msg, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String rec_no,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {
		CustomerRequest CifId1 = bACP_CUS_PROFILE_REPO.findByCustId(customer_id);
		CustomerRequest CifIdcor = bACP_CUS_PROFILE_REPO.findByCustIdCor(customer_id);

		if (CifIdcor != null && "CORPORATE".equals(CifIdcor.getCa_acct_type())) {
			populateModelAprovalforCorp(customer_id, loanAcctNo, md, req);
			return "BACP/ApprovalCorporate.html";
		} else if (CifIdcor != null && "JOINT ACCOUNT".equals(CifIdcor.getCa_acct_type())) {
			populateModelAttributesforcorp(customer_id, loanAcctNo, md, req);
			return "BACP/ApprovalJoint.html";
		} else if (CifId1 != null && "INDIVIDUAL".equals(CifId1.getCa_acct_type())) {
			populateModelAprovalforIndiv(customer_id, loanAcctNo, md, req);
			return "BACP/Approval.html";
		}

		return "APPROVAL";
	}

	private void populateModelAprovalforIndiv(String customer_id, String loanAcctNo, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userid));
		md.addAttribute("userid", userid);
		md.addAttribute("date", new Date());
		CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByCustId(customer_id);

		String appl_ref_no = CifId.getAppl_ref_no();

		md.addAttribute("formmode", "view");
		md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
		md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));

		md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(loanAcctNo));
		md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(loanAcctNo));
	}

	private void populateModelAprovalforCorp(String customer_id, String loanAcctNo, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("Role", userProfileRep.getRole(userid));
		md.addAttribute("userid", userid);
		md.addAttribute("date", new Date());
		CustomerRequest CifId = bACP_CUS_PROFILE_REPO.findByCustIdCor(customer_id);

		String appl_ref_no = CifId.getAppl_ref_no();
		String rec_no = CifId.getRec_no();
		md.addAttribute("holdlistcount", "1");
		md.addAttribute("holdlistcountdub", rec_no);
		md.addAttribute("formmode", "viewcorp");
		md.addAttribute("DocumentList", bacpRep.findBy(appl_ref_no));
		md.addAttribute("customerRequest", bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no));

		md.addAttribute("loanDetails", lease_Loan_Work_Repo.getLeaseAccount(loanAcctNo));
		md.addAttribute("paymentDetails", noticeDetailsPayment0Rep.getPaymentDetails(loanAcctNo));
	}

	@RequestMapping(value = "DocRemove", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String DocRemove(@RequestParam(required = false) String unique_no) {

		BACP_DOC_MAN_ENTITY uniqueid = bacpRep.findByUnique1(unique_no);
		uniqueid.setDel_flg("Y");
		bacpRep.save(uniqueid);
		return "Deleted Successfully.....";
	}

	@RequestMapping(value = "CustMainVerify", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String CustMainVerify(@RequestParam(required = false) String appl_ref_no, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		CustomerRequest appl = bACP_CUS_PROFILE_REPO.findByref_no(appl_ref_no);
		appl.setDel_flg("N");
		appl.setVerify_user(userid);
		appl.setVerify_time(new Date());
		appl.setVerify_flg("Y");
		appl.setStatus("APPROVED");
		bACP_CUS_PROFILE_REPO.save(appl);
		return "Verified Successfully.....";
	}
	
	
	@RequestMapping(value = "SignRemove", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String SignRemove(@RequestParam(required = false) String srl_no, Model md, HttpServletRequest req) {
		Bacp_Signature_master uniqueid = bacp_Signature_masterRepo.findsrl_no1(srl_no);
		uniqueid.setDel_flg("Y");
		bacp_Signature_masterRepo.save(uniqueid);
		return "Deleted Successfully.....";
		
	}
	@RequestMapping(value = "SmsPopup")
	public String SmsPopup(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String appl_ref_no, @RequestParam(required = false) String ApprefNO,
			@RequestParam(required = false) String numberElement, Model md, HttpServletRequest req,
			 @RequestParam(required = false) String unique_id) {

			md.addAttribute("appl_ref_no", appl_ref_no);
			md.addAttribute("unique_id", unique_id);
		return "BACP/SmsPopup.html";
	}


	@RequestMapping(value = "valuesending", method = RequestMethod.POST)
	@ResponseBody
		public String valuesend8ing(Model md, HttpServletRequest rq,
				@RequestParam(required = false) String phone_no,
				@RequestParam(required = false) String unique_id,
				@RequestParam(required = false) String appl_ref_no
				) {

			try {		
				String encodedUnique = URLEncoder.encode(unique_id, "UTF-8");
				String encodedAppl = URLEncoder.encode(appl_ref_no, "UTF-8");

			
					try {
						String apiUrl = "https://api.smslane.com/api/v2/SendSMS";
						String constructedUrl = apiUrl + "?SenderId=" +"&formmode="+"smspopup"+ "&appl_ref_no=" + appl_ref_no +
								"&MobileNumbers="
								+ "91" + phone_no;

						URL url = new URL(constructedUrl);
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.setRequestMethod("GET");

						// Reading the response
						BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
						String inputLine;
						StringBuilder response = new StringBuilder();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						System.out.println(response.toString());
						connection.disconnect();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				return "Sent Successfully";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "Error constructing URL";
			}
		}
}
