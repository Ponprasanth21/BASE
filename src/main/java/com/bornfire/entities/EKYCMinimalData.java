package com.bornfire.entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BACP_MINIMAL_DATA")
public class EKYCMinimalData implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "national_id")	
	private String national_id;
	private String first_name;
	private String short_name;
	private String last_name;
	private String nationality;
	private String passport;
	private String mbl_num;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private String brn;
	private String trade_name;
	private String mid_name;
	private String full_name;
	private Date issue_date;
	private String address;
	private String cust_temp_id;
	private String cif_id;
	private String status;
	private String cust_grp;

	private String reject_remarks;
	private String hold_remarks;
	private String remarks;
	@Id
	private String appl_ref_no;
	private String acc_type;
	private BigDecimal rec_no;
	private String entry_user;
	private Date entry_time;
	private String modify_user;
	private Date modify_time;
	private String verify_user;
	private Date verify_time;
	private String sts_flg;
	private String channel_id;
	private String hold_type;
	private String relationship;
//	private String doc_type;
//	private String doc_code;
//	private String doc_decs;
//	private String unique_id;
//	private String place_of_issues;
//	private Date expiry_date;
	private String cust_type;
	private String country_origin;
	private String cust_type_1;
	private String country_origin_1;
	private String	first_name_1;
	private String	short_name_1;
	private String	last_name_1;
	private String	nationality_1;
	private String	passport_1;
	private String	mbl_num_1;
	private Date	dob_1;
	private String	brn_1;
	private String	trade_name_1;
	private String	mid_name_1;
	private String	full_name_1;
	private Date	issue_date_1;
	private String	address_1;
	private String	cust_temp_id_1;
	private String	cif_id_1;
	private String	status_1;
	private String	cust_grp_1;
	private String	national_id_1;
	private String	annual_income;
	private String	monthly_income;
	private String	loan_obligations;
	private String	family_maintenance;
	private String	certificate_registration;
	private String	business_registration;
	private String	date_incorporation;
	private String	business;
	private String	branch_id;
	private String	branch_desc;
	private String	la_customer_type;
	private String	la_loan_accountno;
	private String	la_date_loan;
	private String	la_loan_sanctioned;
	private String	la_margin;
	private String	la_drawing_limit;
	private String	la_disbursement;
	private String	la_outstanding;
	private String	la_loan_period;
	private String	la_repayment_terms;
	private String	la_expiry_date;
	private String	la_recovery_method;
	private String	la_remarks;
	private String	td_deposit_accountno;
	private String	td_date_deposit;
	private String	td_deposit_amt;
	private String	td_currency;
	private String	td_period;
	private String	td_maturity;
	private String	td_rate_interest;
	private String	td_interest_amt;
	private String	td_compounding_factor;
	private String	td_maturity_amt;
	private String constitutionName; 
	private String corporateName; 
	private String tradeName; 
	private String landlineNo; 
	private String website; 
	private String shortName; 
	private String countryOrigin;
	private String certificate_incorporation;

	public String getCertificate_incorporation() {
		return certificate_incorporation;
	}
	public void setCertificate_incorporation(String certificate_incorporation) {
		this.certificate_incorporation = certificate_incorporation;
	}

	public String getConstitutionName() {
		return constitutionName;
	}

	public void setConstitutionName(String constitutionName) {
		this.constitutionName = constitutionName;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_desc() {
		return branch_desc;
	}

	public void setBranch_desc(String branch_desc) {
		this.branch_desc = branch_desc;
	}

	public String getLa_customer_type() {
		return la_customer_type;
	}

	public void setLa_customer_type(String la_customer_type) {
		this.la_customer_type = la_customer_type;
	}

	public String getLa_loan_accountno() {
		return la_loan_accountno;
	}

	public void setLa_loan_accountno(String la_loan_accountno) {
		this.la_loan_accountno = la_loan_accountno;
	}

	public String getLa_date_loan() {
		return la_date_loan;
	}

	public void setLa_date_loan(String la_date_loan) {
		this.la_date_loan = la_date_loan;
	}

	public String getLa_loan_sanctioned() {
		return la_loan_sanctioned;
	}

	public void setLa_loan_sanctioned(String la_loan_sanctioned) {
		this.la_loan_sanctioned = la_loan_sanctioned;
	}

	public String getLa_margin() {
		return la_margin;
	}

	public void setLa_margin(String la_margin) {
		this.la_margin = la_margin;
	}

	public String getLa_drawing_limit() {
		return la_drawing_limit;
	}

	public void setLa_drawing_limit(String la_drawing_limit) {
		this.la_drawing_limit = la_drawing_limit;
	}

	public String getLa_disbursement() {
		return la_disbursement;
	}

	public void setLa_disbursement(String la_disbursement) {
		this.la_disbursement = la_disbursement;
	}

	public String getLa_outstanding() {
		return la_outstanding;
	}

	public void setLa_outstanding(String la_outstanding) {
		this.la_outstanding = la_outstanding;
	}

	public String getLa_loan_period() {
		return la_loan_period;
	}

	public void setLa_loan_period(String la_loan_period) {
		this.la_loan_period = la_loan_period;
	}

	public String getLa_repayment_terms() {
		return la_repayment_terms;
	}

	public void setLa_repayment_terms(String la_repayment_terms) {
		this.la_repayment_terms = la_repayment_terms;
	}

	public String getLa_expiry_date() {
		return la_expiry_date;
	}

	public void setLa_expiry_date(String la_expiry_date) {
		this.la_expiry_date = la_expiry_date;
	}

	public String getLa_recovery_method() {
		return la_recovery_method;
	}

	public void setLa_recovery_method(String la_recovery_method) {
		this.la_recovery_method = la_recovery_method;
	}

	public String getLa_remarks() {
		return la_remarks;
	}

	public void setLa_remarks(String la_remarks) {
		this.la_remarks = la_remarks;
	}

	public String getTd_deposit_accountno() {
		return td_deposit_accountno;
	}

	public void setTd_deposit_accountno(String td_deposit_accountno) {
		this.td_deposit_accountno = td_deposit_accountno;
	}

	public String getTd_date_deposit() {
		return td_date_deposit;
	}

	public void setTd_date_deposit(String td_date_deposit) {
		this.td_date_deposit = td_date_deposit;
	}

	public String getTd_deposit_amt() {
		return td_deposit_amt;
	}

	public void setTd_deposit_amt(String td_deposit_amt) {
		this.td_deposit_amt = td_deposit_amt;
	}

	public String getTd_currency() {
		return td_currency;
	}

	public void setTd_currency(String td_currency) {
		this.td_currency = td_currency;
	}

	public String getTd_period() {
		return td_period;
	}

	public void setTd_period(String td_period) {
		this.td_period = td_period;
	}

	public String getTd_maturity() {
		return td_maturity;
	}

	public void setTd_maturity(String td_maturity) {
		this.td_maturity = td_maturity;
	}

	public String getTd_rate_interest() {
		return td_rate_interest;
	}

	public void setTd_rate_interest(String td_rate_interest) {
		this.td_rate_interest = td_rate_interest;
	}

	public String getTd_interest_amt() {
		return td_interest_amt;
	}

	public void setTd_interest_amt(String td_interest_amt) {
		this.td_interest_amt = td_interest_amt;
	}

	public String getTd_compounding_factor() {
		return td_compounding_factor;
	}

	public void setTd_compounding_factor(String td_compounding_factor) {
		this.td_compounding_factor = td_compounding_factor;
	}

	public String getTd_maturity_amt() {
		return td_maturity_amt;
	}

	public void setTd_maturity_amt(String td_maturity_amt) {
		this.td_maturity_amt = td_maturity_amt;
	}

	public String getAnnual_income() {
		return annual_income;
	}

	public void setAnnual_income(String annual_income) {
		this.annual_income = annual_income;
	}

	public String getMonthly_income() {
		return monthly_income;
	}

	public void setMonthly_income(String monthly_income) {
		this.monthly_income = monthly_income;
	}

	public String getLoan_obligations() {
		return loan_obligations;
	}

	public void setLoan_obligations(String loan_obligations) {
		this.loan_obligations = loan_obligations;
	}

	public String getFamily_maintenance() {
		return family_maintenance;
	}

	public void setFamily_maintenance(String family_maintenance) {
		this.family_maintenance = family_maintenance;
	}

	public String getCertificate_registration() {
		return certificate_registration;
	}

	public void setCertificate_registration(String certificate_registration) {
		this.certificate_registration = certificate_registration;
	}

	public String getBusiness_registration() {
		return business_registration;
	}

	public void setBusiness_registration(String business_registration) {
		this.business_registration = business_registration;
	}

	public String getDate_incorporation() {
		return date_incorporation;
	}

	public void setDate_incorporation(String date_incorporation) {
		this.date_incorporation = date_incorporation;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getCountry_origin() {
		return country_origin;
	}

	public void setCountry_origin(String country_origin) {
		this.country_origin = country_origin;
	}

	public String getCountry_origin_1() {
		return country_origin_1;
	}

	public void setCountry_origin_1(String country_origin_1) {
		this.country_origin_1 = country_origin_1;
	}

	public String getCif_id() {
		return cif_id;
	}

	public void setCif_id(String cif_id) {
		this.cif_id = cif_id;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}


	public String getCust_type_1() {
		return cust_type_1;
	}

	public void setCust_type_1(String cust_type_1) {
		this.cust_type_1 = cust_type_1;
	}
 
	public String getFirst_name_1() {
		return first_name_1;
	}

	public void setFirst_name_1(String first_name_1) {
		this.first_name_1 = first_name_1;
	}

	public String getShort_name_1() {
		return short_name_1;
	}

	public void setShort_name_1(String short_name_1) {
		this.short_name_1 = short_name_1;
	}

	public String getLast_name_1() {
		return last_name_1;
	}

	public void setLast_name_1(String last_name_1) {
		this.last_name_1 = last_name_1;
	}

	public String getNationality_1() {
		return nationality_1;
	}

	public void setNationality_1(String nationality_1) {
		this.nationality_1 = nationality_1;
	}

	public String getPassport_1() {
		return passport_1;
	}

	public void setPassport_1(String passport_1) {
		this.passport_1 = passport_1;
	}

	public String getMbl_num_1() {
		return mbl_num_1;
	}

	public void setMbl_num_1(String mbl_num_1) {
		this.mbl_num_1 = mbl_num_1;
	}

	public Date getDob_1() {
		return dob_1;
	}

	public void setDob_1(Date dob_1) {
		this.dob_1 = dob_1;
	}

	public String getBrn_1() {
		return brn_1;
	}

	public void setBrn_1(String brn_1) {
		this.brn_1 = brn_1;
	}

	public String getTrade_name_1() {
		return trade_name_1;
	}

	public void setTrade_name_1(String trade_name_1) {
		this.trade_name_1 = trade_name_1;
	}

	public String getMid_name_1() {
		return mid_name_1;
	}

	public void setMid_name_1(String mid_name_1) {
		this.mid_name_1 = mid_name_1;
	}

	public String getFull_name_1() {
		return full_name_1;
	}

	public void setFull_name_1(String full_name_1) {
		this.full_name_1 = full_name_1;
	}

	public Date getIssue_date_1() {
		return issue_date_1;
	}

	public void setIssue_date_1(Date issue_date_1) {
		this.issue_date_1 = issue_date_1;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getCust_temp_id_1() {
		return cust_temp_id_1;
	}

	public void setCust_temp_id_1(String cust_temp_id_1) {
		this.cust_temp_id_1 = cust_temp_id_1;
	}

	public String getCif_id_1() {
		return cif_id_1;
	}

	public void setCif_id_1(String cif_id_1) {
		this.cif_id_1 = cif_id_1;
	}

	public String getStatus_1() {
		return status_1;
	}

	public void setStatus_1(String status_1) {
		this.status_1 = status_1;
	}

	public String getCust_grp_1() {
		return cust_grp_1;
	}

	public void setCust_grp_1(String cust_grp_1) {
		this.cust_grp_1 = cust_grp_1;
	}

	public String getNational_id_1() {
		return national_id_1;
	}

	public void setNational_id_1(String national_id_1) {
		this.national_id_1 = national_id_1;
	}

	public String getNational_id() {
		return national_id;
	}

	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getMbl_num() {
		return mbl_num;
	}

	public void setMbl_num(String mbl_num) {
		this.mbl_num = mbl_num;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBrn() {
		return brn;
	}

	public void setBrn(String brn) {
		this.brn = brn;
	}

	public String getTrade_name() {
		return trade_name;
	}

	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}

	public String getMid_name() {
		return mid_name;
	}

	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCust_temp_id() {
		return cust_temp_id;
	}

	public void setCust_temp_id(String cust_temp_id) {
		this.cust_temp_id = cust_temp_id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCust_grp() {
		return cust_grp;
	}

	public void setCust_grp(String cust_grp) {
		this.cust_grp = cust_grp;
	}

	public String getReject_remarks() {
		return reject_remarks;
	}

	public void setReject_remarks(String reject_remarks) {
		this.reject_remarks = reject_remarks;
	}

	public String getHold_remarks() {
		return hold_remarks;
	}

	public void setHold_remarks(String hold_remarks) {
		this.hold_remarks = hold_remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAppl_ref_no() {
		return appl_ref_no;
	}

	public void setAppl_ref_no(String appl_ref_no) {
		this.appl_ref_no = appl_ref_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public BigDecimal getRec_no() {
		return rec_no;
	}

	public void setRec_no(BigDecimal rec_no) {
		this.rec_no = rec_no;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public String getSts_flg() {
		return sts_flg;
	}

	public void setSts_flg(String sts_flg) {
		this.sts_flg = sts_flg;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getHold_type() {
		return hold_type;
	}

	public void setHold_type(String hold_type) {
		this.hold_type = hold_type;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	/*
	 * public String getDoc_type() { return doc_type; }
	 * 
	 * public void setDoc_type(String doc_type) { this.doc_type = doc_type; }
	 * 
	 * public String getDoc_code() { return doc_code; }
	 * 
	 * public void setDoc_code(String doc_code) { this.doc_code = doc_code; }
	 * 
	 * public String getDoc_decs() { return doc_decs; }
	 * 
	 * public void setDoc_decs(String doc_decs) { this.doc_decs = doc_decs; }
	 * 
	 * public String getUnique_id() { return unique_id; }
	 * 
	 * public void setUnique_id(String unique_id) { this.unique_id = unique_id; }
	 * 
	 * public String getPlace_of_issues() { return place_of_issues; }
	 * 
	 * public void setPlace_of_issues(String place_of_issues) { this.place_of_issues
	 * = place_of_issues; }
	 * 
	 * public Date getExpiry_date() { return expiry_date; }
	 * 
	 * public void setExpiry_date(Date expiry_date) { this.expiry_date =
	 * expiry_date; }
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EKYCMinimalData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}