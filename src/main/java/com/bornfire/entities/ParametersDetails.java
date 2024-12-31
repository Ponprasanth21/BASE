package com.bornfire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.ibm.icu.math.BigDecimal;

@Entity
@Table(name = "BACP_PARAMETER")
public class ParametersDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sol_id;
	@Column(name = "scheme_type")
	private String schemetype; 
	@Column(name = "schm_code")
	private String schmcode;
	@Column(name = "schm_desc")
	private String schmdesc;   
	private String td_type;
	private String schm_group;       
	private String work_flow;         
	private String approval_flg ;       
	private String documents_flg;
	private String alert_flg;
	private String apr_user1 ;        
	private String apr_user2  ;       
	private String apr_user3   ;      
	private String apr_email_1  ;       
	private String apr_email_2   ;      
	private String apr_email_3     ;    
	private String apr_sms_1      ;   
	private String apr_sms_2   ;      
	private String apr_sms_3    ;     
	private String approval1;     
	private String approval2 ;    
	private String approval3;
	private String documents_type1 ;        
	private String documents_code1  ;       
	private String documents_desc1   ;      
	private String documents_type2;         
	private String documents_code2 ;        
	private String documents_desc2 ;        
	private String documents_type3  ;       
	private String documents_code3 ;        
	private String documents_desc3 ;        
	private String alr_user1 ;        
	private String alr_user2  ;       
	private String alr_user3   ;      
	private String alr_email_1  ;       
	private String alr_email_2 ;        
	private String alr_email_3  ;       
	private String alr_sms_1 ;        
	private String alr_sms_2  ;       
	private String alr_sms_3   ;      
	private String alert1 ;    
	private String alert2 ;    
	private String alert3;
	private String entry_user;
	private String modify_user;
	private String verify_user ;    
	private String entry_time  ;  
	private String modify_time  ;  
	private String verify_time  ;   
	private String del_flg ;
	//FOR I USE CHECKLIST FLG
	private String entity_cre_flg  ;       
	private String modify_flg  ;     
	@DateTimeFormat(pattern = "dd-MM-yyyy")  
	private Date expiry_date  ;  
	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	private Date eff_date  ;   
	private String aof  ;  
	@Id
	@Column(name = "ref_number")
	private String refnumber ;    
	private String cus_temp ;   
	private String acc_temp  ;   
	private String check_list ;
	private String gl_code ;
	private String glsh ;
	private String home_curr ;
	private String multi_curr ;
	private String apr_user_name1 ;
	private String apr_user_name2 ;
	private String apr_user_name3 ;
	private String apr_sol_id1 ;
	private String apr_sol_id2 ;
	private String apr_sol_id3 ;
	private String alr_user_name1 ;
	private String alr_user_name2 ;
	private String alr_user_name3 ;
	private String alrsol_id1 ;
	private String alrsol_id2 ;
	private String alrsol_id3 ;
	private String verify_flg ;
	@Column(name = "branchDesc")
	private String branchdesc;
	
	private String	deposit_scheme;
	private String	deposit_type;
	private BigDecimal	deposit_amount;
	private BigDecimal	deposit_period;
	private BigDecimal	interest_rate_deposit;
	private BigDecimal	interest_compund_frequency;
	private String	auto_renewal_flag;
	private String	loan_facility;
	private String	overdue_gl_sub_head_code;
	private String	loan_scheme;
	private BigDecimal	loan_amount;
	private BigDecimal	loan_period;
	private BigDecimal	repayment_period;
	private String	repayment_method;
	private BigDecimal	interest_rate_loan;
	private BigDecimal	interest_compounding_frequency;
	private String	collateral_flag;
	private String	collateral_margin;
	private String	recovery_method;
	private String	npa_norms;
	private BigDecimal	interest_booking_deposit;
	private BigDecimal	interest_application_deposit;
	private BigDecimal	account_place_holder_deposit;
	private BigDecimal	interest_booking_loan;
	private BigDecimal	interest_application_loan;
	private BigDecimal	account_place_holder_loan;
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getSchemetype() {
		return schemetype;
	}
	public void setSchemetype(String schemetype) {
		this.schemetype = schemetype;
	}
	public String getSchmcode() {
		return schmcode;
	}
	public void setSchmcode(String schmcode) {
		this.schmcode = schmcode;
	}
	public String getSchmdesc() {
		return schmdesc;
	}
	public void setSchmdesc(String schmdesc) {
		this.schmdesc = schmdesc;
	}
	public String getTd_type() {
		return td_type;
	}
	public void setTd_type(String td_type) {
		this.td_type = td_type;
	}
	public String getSchm_group() {
		return schm_group;
	}
	public void setSchm_group(String schm_group) {
		this.schm_group = schm_group;
	}
	public String getWork_flow() {
		return work_flow;
	}
	public void setWork_flow(String work_flow) {
		this.work_flow = work_flow;
	}
	public String getApproval_flg() {
		return approval_flg;
	}
	public void setApproval_flg(String approval_flg) {
		this.approval_flg = approval_flg;
	}
	public String getDocuments_flg() {
		return documents_flg;
	}
	public void setDocuments_flg(String documents_flg) {
		this.documents_flg = documents_flg;
	}
	public String getAlert_flg() {
		return alert_flg;
	}
	public void setAlert_flg(String alert_flg) {
		this.alert_flg = alert_flg;
	}
	public String getApr_user1() {
		return apr_user1;
	}
	public void setApr_user1(String apr_user1) {
		this.apr_user1 = apr_user1;
	}
	public String getApr_user2() {
		return apr_user2;
	}
	public void setApr_user2(String apr_user2) {
		this.apr_user2 = apr_user2;
	}
	public String getApr_user3() {
		return apr_user3;
	}
	public void setApr_user3(String apr_user3) {
		this.apr_user3 = apr_user3;
	}
	public String getApr_email_1() {
		return apr_email_1;
	}
	public void setApr_email_1(String apr_email_1) {
		this.apr_email_1 = apr_email_1;
	}
	public String getApr_email_2() {
		return apr_email_2;
	}
	public void setApr_email_2(String apr_email_2) {
		this.apr_email_2 = apr_email_2;
	}
	public String getApr_email_3() {
		return apr_email_3;
	}
	public void setApr_email_3(String apr_email_3) {
		this.apr_email_3 = apr_email_3;
	}
	public String getApr_sms_1() {
		return apr_sms_1;
	}
	public void setApr_sms_1(String apr_sms_1) {
		this.apr_sms_1 = apr_sms_1;
	}
	public String getApr_sms_2() {
		return apr_sms_2;
	}
	public void setApr_sms_2(String apr_sms_2) {
		this.apr_sms_2 = apr_sms_2;
	}
	public String getApr_sms_3() {
		return apr_sms_3;
	}
	public void setApr_sms_3(String apr_sms_3) {
		this.apr_sms_3 = apr_sms_3;
	}
	public String getApproval1() {
		return approval1;
	}
	public void setApproval1(String approval1) {
		this.approval1 = approval1;
	}
	public String getApproval2() {
		return approval2;
	}
	public void setApproval2(String approval2) {
		this.approval2 = approval2;
	}
	public String getApproval3() {
		return approval3;
	}
	public void setApproval3(String approval3) {
		this.approval3 = approval3;
	}
	public String getDocuments_type1() {
		return documents_type1;
	}
	public void setDocuments_type1(String documents_type1) {
		this.documents_type1 = documents_type1;
	}
	public String getDocuments_code1() {
		return documents_code1;
	}
	public void setDocuments_code1(String documents_code1) {
		this.documents_code1 = documents_code1;
	}
	public String getDocuments_desc1() {
		return documents_desc1;
	}
	public void setDocuments_desc1(String documents_desc1) {
		this.documents_desc1 = documents_desc1;
	}
	public String getDocuments_type2() {
		return documents_type2;
	}
	public void setDocuments_type2(String documents_type2) {
		this.documents_type2 = documents_type2;
	}
	public String getDocuments_code2() {
		return documents_code2;
	}
	public void setDocuments_code2(String documents_code2) {
		this.documents_code2 = documents_code2;
	}
	public String getDocuments_desc2() {
		return documents_desc2;
	}
	public void setDocuments_desc2(String documents_desc2) {
		this.documents_desc2 = documents_desc2;
	}
	public String getDocuments_type3() {
		return documents_type3;
	}
	public void setDocuments_type3(String documents_type3) {
		this.documents_type3 = documents_type3;
	}
	public String getDocuments_code3() {
		return documents_code3;
	}
	public void setDocuments_code3(String documents_code3) {
		this.documents_code3 = documents_code3;
	}
	public String getDocuments_desc3() {
		return documents_desc3;
	}
	public void setDocuments_desc3(String documents_desc3) {
		this.documents_desc3 = documents_desc3;
	}
	public String getAlr_user1() {
		return alr_user1;
	}
	public void setAlr_user1(String alr_user1) {
		this.alr_user1 = alr_user1;
	}
	public String getAlr_user2() {
		return alr_user2;
	}
	public void setAlr_user2(String alr_user2) {
		this.alr_user2 = alr_user2;
	}
	public String getAlr_user3() {
		return alr_user3;
	}
	public void setAlr_user3(String alr_user3) {
		this.alr_user3 = alr_user3;
	}
	public String getAlr_email_1() {
		return alr_email_1;
	}
	public void setAlr_email_1(String alr_email_1) {
		this.alr_email_1 = alr_email_1;
	}
	public String getAlr_email_2() {
		return alr_email_2;
	}
	public void setAlr_email_2(String alr_email_2) {
		this.alr_email_2 = alr_email_2;
	}
	public String getAlr_email_3() {
		return alr_email_3;
	}
	public void setAlr_email_3(String alr_email_3) {
		this.alr_email_3 = alr_email_3;
	}
	public String getAlr_sms_1() {
		return alr_sms_1;
	}
	public void setAlr_sms_1(String alr_sms_1) {
		this.alr_sms_1 = alr_sms_1;
	}
	public String getAlr_sms_2() {
		return alr_sms_2;
	}
	public void setAlr_sms_2(String alr_sms_2) {
		this.alr_sms_2 = alr_sms_2;
	}
	public String getAlr_sms_3() {
		return alr_sms_3;
	}
	public void setAlr_sms_3(String alr_sms_3) {
		this.alr_sms_3 = alr_sms_3;
	}
	public String getAlert1() {
		return alert1;
	}
	public void setAlert1(String alert1) {
		this.alert1 = alert1;
	}
	public String getAlert2() {
		return alert2;
	}
	public void setAlert2(String alert2) {
		this.alert2 = alert2;
	}
	public String getAlert3() {
		return alert3;
	}
	public void setAlert3(String alert3) {
		this.alert3 = alert3;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public String getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(String verify_time) {
		this.verify_time = verify_time;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEntity_cre_flg() {
		return entity_cre_flg;
	}
	public void setEntity_cre_flg(String entity_cre_flg) {
		this.entity_cre_flg = entity_cre_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public Date getEff_date() {
		return eff_date;
	}
	public void setEff_date(Date eff_date) {
		this.eff_date = eff_date;
	}
	public String getAof() {
		return aof;
	}
	public void setAof(String aof) {
		this.aof = aof;
	}
	public String getRefnumber() {
		return refnumber;
	}
	public void setRefnumber(String refnumber) {
		this.refnumber = refnumber;
	}
	public String getCus_temp() {
		return cus_temp;
	}
	public void setCus_temp(String cus_temp) {
		this.cus_temp = cus_temp;
	}
	public String getAcc_temp() {
		return acc_temp;
	}
	public void setAcc_temp(String acc_temp) {
		this.acc_temp = acc_temp;
	}
	public String getCheck_list() {
		return check_list;
	}
	public void setCheck_list(String check_list) {
		this.check_list = check_list;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getGlsh() {
		return glsh;
	}
	public void setGlsh(String glsh) {
		this.glsh = glsh;
	}
	public String getHome_curr() {
		return home_curr;
	}
	public void setHome_curr(String home_curr) {
		this.home_curr = home_curr;
	}
	public String getMulti_curr() {
		return multi_curr;
	}
	public void setMulti_curr(String multi_curr) {
		this.multi_curr = multi_curr;
	}
	public String getApr_user_name1() {
		return apr_user_name1;
	}
	public void setApr_user_name1(String apr_user_name1) {
		this.apr_user_name1 = apr_user_name1;
	}
	public String getApr_user_name2() {
		return apr_user_name2;
	}
	public void setApr_user_name2(String apr_user_name2) {
		this.apr_user_name2 = apr_user_name2;
	}
	public String getApr_user_name3() {
		return apr_user_name3;
	}
	public void setApr_user_name3(String apr_user_name3) {
		this.apr_user_name3 = apr_user_name3;
	}
	public String getApr_sol_id1() {
		return apr_sol_id1;
	}
	public void setApr_sol_id1(String apr_sol_id1) {
		this.apr_sol_id1 = apr_sol_id1;
	}
	public String getApr_sol_id2() {
		return apr_sol_id2;
	}
	public void setApr_sol_id2(String apr_sol_id2) {
		this.apr_sol_id2 = apr_sol_id2;
	}
	public String getApr_sol_id3() {
		return apr_sol_id3;
	}
	public void setApr_sol_id3(String apr_sol_id3) {
		this.apr_sol_id3 = apr_sol_id3;
	}
	public String getAlr_user_name1() {
		return alr_user_name1;
	}
	public void setAlr_user_name1(String alr_user_name1) {
		this.alr_user_name1 = alr_user_name1;
	}
	public String getAlr_user_name2() {
		return alr_user_name2;
	}
	public void setAlr_user_name2(String alr_user_name2) {
		this.alr_user_name2 = alr_user_name2;
	}
	public String getAlr_user_name3() {
		return alr_user_name3;
	}
	public void setAlr_user_name3(String alr_user_name3) {
		this.alr_user_name3 = alr_user_name3;
	}
	public String getAlrsol_id1() {
		return alrsol_id1;
	}
	public void setAlrsol_id1(String alrsol_id1) {
		this.alrsol_id1 = alrsol_id1;
	}
	public String getAlrsol_id2() {
		return alrsol_id2;
	}
	public void setAlrsol_id2(String alrsol_id2) {
		this.alrsol_id2 = alrsol_id2;
	}
	public String getAlrsol_id3() {
		return alrsol_id3;
	}
	public void setAlrsol_id3(String alrsol_id3) {
		this.alrsol_id3 = alrsol_id3;
	}
	public String getVerify_flg() {
		return verify_flg;
	}
	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}
	public String getBranchdesc() {
		return branchdesc;
	}
	public void setBranchdesc(String branchdesc) {
		this.branchdesc = branchdesc;
	}
	public String getDeposit_scheme() {
		return deposit_scheme;
	}
	public void setDeposit_scheme(String deposit_scheme) {
		this.deposit_scheme = deposit_scheme;
	}
	public String getDeposit_type() {
		return deposit_type;
	}
	public void setDeposit_type(String deposit_type) {
		this.deposit_type = deposit_type;
	}
	public BigDecimal getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(BigDecimal deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	public BigDecimal getDeposit_period() {
		return deposit_period;
	}
	public void setDeposit_period(BigDecimal deposit_period) {
		this.deposit_period = deposit_period;
	}
	public BigDecimal getInterest_rate_deposit() {
		return interest_rate_deposit;
	}
	public void setInterest_rate_deposit(BigDecimal interest_rate_deposit) {
		this.interest_rate_deposit = interest_rate_deposit;
	}
	public BigDecimal getInterest_compund_frequency() {
		return interest_compund_frequency;
	}
	public void setInterest_compund_frequency(BigDecimal interest_compund_frequency) {
		this.interest_compund_frequency = interest_compund_frequency;
	}
	public String getAuto_renewal_flag() {
		return auto_renewal_flag;
	}
	public void setAuto_renewal_flag(String auto_renewal_flag) {
		this.auto_renewal_flag = auto_renewal_flag;
	}
	public String getLoan_facility() {
		return loan_facility;
	}
	public void setLoan_facility(String loan_facility) {
		this.loan_facility = loan_facility;
	}
	public String getOverdue_gl_sub_head_code() {
		return overdue_gl_sub_head_code;
	}
	public void setOverdue_gl_sub_head_code(String overdue_gl_sub_head_code) {
		this.overdue_gl_sub_head_code = overdue_gl_sub_head_code;
	}
	public String getLoan_scheme() {
		return loan_scheme;
	}
	public void setLoan_scheme(String loan_scheme) {
		this.loan_scheme = loan_scheme;
	}
	public BigDecimal getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(BigDecimal loan_amount) {
		this.loan_amount = loan_amount;
	}
	public BigDecimal getLoan_period() {
		return loan_period;
	}
	public void setLoan_period(BigDecimal loan_period) {
		this.loan_period = loan_period;
	}
	public BigDecimal getRepayment_period() {
		return repayment_period;
	}
	public void setRepayment_period(BigDecimal repayment_period) {
		this.repayment_period = repayment_period;
	}
	public String getRepayment_method() {
		return repayment_method;
	}
	public void setRepayment_method(String repayment_method) {
		this.repayment_method = repayment_method;
	}
	public BigDecimal getInterest_rate_loan() {
		return interest_rate_loan;
	}
	public void setInterest_rate_loan(BigDecimal interest_rate_loan) {
		this.interest_rate_loan = interest_rate_loan;
	}
	public BigDecimal getInterest_compounding_frequency() {
		return interest_compounding_frequency;
	}
	public void setInterest_compounding_frequency(BigDecimal interest_compounding_frequency) {
		this.interest_compounding_frequency = interest_compounding_frequency;
	}
	public String getCollateral_flag() {
		return collateral_flag;
	}
	public void setCollateral_flag(String collateral_flag) {
		this.collateral_flag = collateral_flag;
	}
	public String getCollateral_margin() {
		return collateral_margin;
	}
	public void setCollateral_margin(String collateral_margin) {
		this.collateral_margin = collateral_margin;
	}
	public String getRecovery_method() {
		return recovery_method;
	}
	public void setRecovery_method(String recovery_method) {
		this.recovery_method = recovery_method;
	}
	public String getNpa_norms() {
		return npa_norms;
	}
	public void setNpa_norms(String npa_norms) {
		this.npa_norms = npa_norms;
	}
	public BigDecimal getInterest_booking_deposit() {
		return interest_booking_deposit;
	}
	public void setInterest_booking_deposit(BigDecimal interest_booking_deposit) {
		this.interest_booking_deposit = interest_booking_deposit;
	}
	public BigDecimal getInterest_application_deposit() {
		return interest_application_deposit;
	}
	public void setInterest_application_deposit(BigDecimal interest_application_deposit) {
		this.interest_application_deposit = interest_application_deposit;
	}
	public BigDecimal getAccount_place_holder_deposit() {
		return account_place_holder_deposit;
	}
	public void setAccount_place_holder_deposit(BigDecimal account_place_holder_deposit) {
		this.account_place_holder_deposit = account_place_holder_deposit;
	}
	public BigDecimal getInterest_booking_loan() {
		return interest_booking_loan;
	}
	public void setInterest_booking_loan(BigDecimal interest_booking_loan) {
		this.interest_booking_loan = interest_booking_loan;
	}
	public BigDecimal getInterest_application_loan() {
		return interest_application_loan;
	}
	public void setInterest_application_loan(BigDecimal interest_application_loan) {
		this.interest_application_loan = interest_application_loan;
	}
	public BigDecimal getAccount_place_holder_loan() {
		return account_place_holder_loan;
	}
	public void setAccount_place_holder_loan(BigDecimal account_place_holder_loan) {
		this.account_place_holder_loan = account_place_holder_loan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ParametersDetails(String sol_id, String schemetype, String schmcode, String schmdesc, String td_type,
			String schm_group, String work_flow, String approval_flg, String documents_flg, String alert_flg,
			String apr_user1, String apr_user2, String apr_user3, String apr_email_1, String apr_email_2,
			String apr_email_3, String apr_sms_1, String apr_sms_2, String apr_sms_3, String approval1,
			String approval2, String approval3, String documents_type1, String documents_code1, String documents_desc1,
			String documents_type2, String documents_code2, String documents_desc2, String documents_type3,
			String documents_code3, String documents_desc3, String alr_user1, String alr_user2, String alr_user3,
			String alr_email_1, String alr_email_2, String alr_email_3, String alr_sms_1, String alr_sms_2,
			String alr_sms_3, String alert1, String alert2, String alert3, String entry_user, String modify_user,
			String verify_user, String entry_time, String modify_time, String verify_time, String del_flg,
			String entity_cre_flg, String modify_flg, Date expiry_date, Date eff_date, String aof, String refnumber,
			String cus_temp, String acc_temp, String check_list, String gl_code, String glsh, String home_curr,
			String multi_curr, String apr_user_name1, String apr_user_name2, String apr_user_name3, String apr_sol_id1,
			String apr_sol_id2, String apr_sol_id3, String alr_user_name1, String alr_user_name2, String alr_user_name3,
			String alrsol_id1, String alrsol_id2, String alrsol_id3, String verify_flg, String branchdesc,
			String deposit_scheme, String deposit_type, BigDecimal deposit_amount, BigDecimal deposit_period,
			BigDecimal interest_rate_deposit, BigDecimal interest_compund_frequency, String auto_renewal_flag,
			String loan_facility, String overdue_gl_sub_head_code, String loan_scheme, BigDecimal loan_amount,
			BigDecimal loan_period, BigDecimal repayment_period, String repayment_method, BigDecimal interest_rate_loan,
			BigDecimal interest_compounding_frequency, String collateral_flag, String collateral_margin,
			String recovery_method, String npa_norms, BigDecimal interest_booking_deposit,
			BigDecimal interest_application_deposit, BigDecimal account_place_holder_deposit,
			BigDecimal interest_booking_loan, BigDecimal interest_application_loan,
			BigDecimal account_place_holder_loan) {
		super();
		this.sol_id = sol_id;
		this.schemetype = schemetype;
		this.schmcode = schmcode;
		this.schmdesc = schmdesc;
		this.td_type = td_type;
		this.schm_group = schm_group;
		this.work_flow = work_flow;
		this.approval_flg = approval_flg;
		this.documents_flg = documents_flg;
		this.alert_flg = alert_flg;
		this.apr_user1 = apr_user1;
		this.apr_user2 = apr_user2;
		this.apr_user3 = apr_user3;
		this.apr_email_1 = apr_email_1;
		this.apr_email_2 = apr_email_2;
		this.apr_email_3 = apr_email_3;
		this.apr_sms_1 = apr_sms_1;
		this.apr_sms_2 = apr_sms_2;
		this.apr_sms_3 = apr_sms_3;
		this.approval1 = approval1;
		this.approval2 = approval2;
		this.approval3 = approval3;
		this.documents_type1 = documents_type1;
		this.documents_code1 = documents_code1;
		this.documents_desc1 = documents_desc1;
		this.documents_type2 = documents_type2;
		this.documents_code2 = documents_code2;
		this.documents_desc2 = documents_desc2;
		this.documents_type3 = documents_type3;
		this.documents_code3 = documents_code3;
		this.documents_desc3 = documents_desc3;
		this.alr_user1 = alr_user1;
		this.alr_user2 = alr_user2;
		this.alr_user3 = alr_user3;
		this.alr_email_1 = alr_email_1;
		this.alr_email_2 = alr_email_2;
		this.alr_email_3 = alr_email_3;
		this.alr_sms_1 = alr_sms_1;
		this.alr_sms_2 = alr_sms_2;
		this.alr_sms_3 = alr_sms_3;
		this.alert1 = alert1;
		this.alert2 = alert2;
		this.alert3 = alert3;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.entity_cre_flg = entity_cre_flg;
		this.modify_flg = modify_flg;
		this.expiry_date = expiry_date;
		this.eff_date = eff_date;
		this.aof = aof;
		this.refnumber = refnumber;
		this.cus_temp = cus_temp;
		this.acc_temp = acc_temp;
		this.check_list = check_list;
		this.gl_code = gl_code;
		this.glsh = glsh;
		this.home_curr = home_curr;
		this.multi_curr = multi_curr;
		this.apr_user_name1 = apr_user_name1;
		this.apr_user_name2 = apr_user_name2;
		this.apr_user_name3 = apr_user_name3;
		this.apr_sol_id1 = apr_sol_id1;
		this.apr_sol_id2 = apr_sol_id2;
		this.apr_sol_id3 = apr_sol_id3;
		this.alr_user_name1 = alr_user_name1;
		this.alr_user_name2 = alr_user_name2;
		this.alr_user_name3 = alr_user_name3;
		this.alrsol_id1 = alrsol_id1;
		this.alrsol_id2 = alrsol_id2;
		this.alrsol_id3 = alrsol_id3;
		this.verify_flg = verify_flg;
		this.branchdesc = branchdesc;
		this.deposit_scheme = deposit_scheme;
		this.deposit_type = deposit_type;
		this.deposit_amount = deposit_amount;
		this.deposit_period = deposit_period;
		this.interest_rate_deposit = interest_rate_deposit;
		this.interest_compund_frequency = interest_compund_frequency;
		this.auto_renewal_flag = auto_renewal_flag;
		this.loan_facility = loan_facility;
		this.overdue_gl_sub_head_code = overdue_gl_sub_head_code;
		this.loan_scheme = loan_scheme;
		this.loan_amount = loan_amount;
		this.loan_period = loan_period;
		this.repayment_period = repayment_period;
		this.repayment_method = repayment_method;
		this.interest_rate_loan = interest_rate_loan;
		this.interest_compounding_frequency = interest_compounding_frequency;
		this.collateral_flag = collateral_flag;
		this.collateral_margin = collateral_margin;
		this.recovery_method = recovery_method;
		this.npa_norms = npa_norms;
		this.interest_booking_deposit = interest_booking_deposit;
		this.interest_application_deposit = interest_application_deposit;
		this.account_place_holder_deposit = account_place_holder_deposit;
		this.interest_booking_loan = interest_booking_loan;
		this.interest_application_loan = interest_application_loan;
		this.account_place_holder_loan = account_place_holder_loan;
	}
	public ParametersDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	



}
