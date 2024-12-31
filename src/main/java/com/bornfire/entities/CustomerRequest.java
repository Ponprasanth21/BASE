package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BACP_CUS_PROFILE")
@IdClass(rec_no_id.class)
public class CustomerRequest {

	private	String	ca_customer_type	;
	private	String	ca_saluation	;
	private	String	ca_first_name	;
	private	String	mid_name	;
	private	String	ca_last_name	;
	private	String	ca_preferred_name	;
	private	String	ca_occupation1	;
	private	String	ca_gender	;
	private	String	ca_martial_staus	;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private	Date	ca_date_of_birth	;
	private	String	ca_address_type	;
	private	String	ca_house_no	;
	private	String	ca_street_no	;
	private	String	ca_street_name	;
	private	String	ca_country	;
	private	String	ca_state	;
	private	String	ca_city		;
	private	String	ca_postal_code	;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private	Date	ca_address_validation_form	;
	private	String	ca_nationality	;
	private	String	ca_country_of_birth	;
	private	String	ca_email_id	;
	private	String	ca_mobile_number	;
	private	String	ca_phone_number	;
	private	String	ca_occupation2	;
	private	String	ca_non_resident	;
	private	String	ca_staff_indicator	;
	private	String	ca_trdfin	;
	private	String	ca_minor_indicator	;
	private	String	ca_guardian_name	;
	private	String	ca_schemetype	;
	private	String	ca_scheme_code	;
	private	String	ca_currency	;
	private	String	ca_glcode	;
	private	String	ca_solid		;
	private	String	ca_idenditification_number	;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private	Date	ca_issue_date	;
	private	String	ca_passport_number	;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private	Date	ca_expiry_date	;
	private	String	ca_addrtype_nri	;
	private	String	ca_relname_nri	;
	private	String	ca_relationship_nri	;
	private	String	ca_locaddrnri	;
	private	String	ca_ctry_nri	;
	private	String	ca_nri_state	;
	private	String	ca_cty_nri	;
	private	String	ca_code_nri	;
	private	String	ca_phoneno_nri	;
	private	String	ca_emp_id	;
	private	String	ca_emp_name	;
	private	String	ca_emp_desi	;
	private	String	ca_emp_branch	;
	private	String	ca_nationlality_nri	;
	private	String	ca_swftcodebk_tf	;
	private	String	ca_codegvctlbk_tf	;
	private	String	ca_codegvntrd_tf	;
	private	String	ca_swftcodee_tf	;
	private	String	ca_min_gurd	;
	private	String	ca_min_rell	;
	private	String	ca_min_add	;
	private	String	ca_min_addcode	;
	private	String	ca_min_state1	;
	private	String	ca_min_cty1	;
	private	String	ca_min_post1	;
	private	String	ca_min_cont1	;
	private	String	ca_country_of_incorp	;
	private	String	ca_corp_name	;
	private	String	ca_nature_of_business	;
	private	String	ca_mode_of_operation	;
	private	String	ca_contact_person_name	;
	private	String	ca_job_title	;
	private	String	ca_email_address	;
	private	String	ca_fax_no	;
	private	String	ca_capital_invested	;
	private	String	ca_expected_turnover	;
	private	String	ca_expected_expenditure	;
	private	String	ca_account_no	;
	private	String	ca_introducer_name	;
	private	String	ca_address	;
	private	String	ca_mobile_no	;
	private	String	user_id1		;
	private	String	user_id2		;
	private	String	user_id3		;
	private	String	temp_k		;
	private	String	cif_id		;
	private	String	account_id	;
	private	String	notify_flg	;
	private	String	entity_flg	;
	private	String	approval_flg	;
	private	String	kyc_flg		;
	private	String	kyc_hold_flg	;
	private	String	kyc_reject_flg	;
	private	String	status		;
	private	String	hold_remarks	;
	private	String	reject_remarks	;
	private	String	remarks		;
	private	String	ca_acct_type	;
	@Id
	private	String	appl_ref_no	;
	@Id
	private	String	rec_no		;
	private	String	entry_user	;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private	Date	entry_time	;
	private	String	modify_user	;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private	Date	modify_time	;
	private	String	verify_user	;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private	Date	verify_time	;
	private	String	channel_id	;
	private	String	relationship	;
	private	String	hold_type	;
	private byte[] photo;
	private byte[] sign;
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
	private String	ca_customer_type_1;
	private String	ca_cif_id_1;
	private String	ca_primary_branch_1;
	private String	ca_branch_name_1;
	private String	ca_salutation_1;
	private String	ca_first_name_1;
	private String	ca_middle_name_1;
	private String	ca_last_name_1;
	private String	ca_full_name_1;
	private String	ca_short_name_1;
	private String	ca_gender_1;
	private String	ca_marital_status_1;
	private String	ca_occupation_1;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_1;
	private BigDecimal	ca_annual_income_1;
	private BigDecimal	ca_monthly_income_1;
	private String	ca_loan_obligations_1;
	private String	ca_family_maintenance_1;
	private String	ca_address_type_1;
	private String	ca_house_no_1;
	private String	ca_street_no_1;
	private String	ca_street_name_1;
	private String	ca_country_1;
	private String	ca_state_1;
	private String	ca_city_1;
	private String	ca_postal_code_1;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_1;
	private String	ca_nationality_1;
	private String	ca_country_of_birth_1;
	private String	ca_country_of_origin_1;
	private String	ca_email_id_1;
	private BigDecimal	ca_mobile_no_1;
	private String	ca_customer_type_2;
	private String	ca_cif_id_2;
	private String	ca_primary_branch_2;
	private String	ca_branch_name_2;
	private String	ca_salutation_2;
	private String	ca_first_name_2;
	private String	ca_middle_name_2;
	private String	ca_last_name_2;
	private String	ca_full_name_2;
	private String	ca_short_name_2;
	private String	ca_gender_2;
	private String	ca_marital_status_2;
	private String	ca_occupation_2;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_2;
	private BigDecimal	ca_annual_income_2;
	private BigDecimal	ca_monthly_income_2;
	private String	ca_loan_obligations_2;
	private String	ca_family_maintenance_2;
	private String	ca_address_type_2;
	private String	ca_house_no_2;
	private String	ca_street_no_2;
	private String	ca_street_name_2;
	private String	ca_country_2;
	private String	ca_state_2;
	private String	ca_city_2;
	private String	ca_postal_code_2;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_2;
	private String	ca_nationality_2;
	private String	ca_country_of_birth_2;
	private String	ca_country_of_origin_2;
	private String	ca_email_id_2;
	private BigDecimal	ca_mobile_no_2;
	private String	ca_customer_type_3;
	private String	ca_cif_id_3;
	private String	ca_primary_branch_3;
	private String	ca_branch_name_3;
	private String	ca_salutation_3;
	private String	ca_first_name_3;
	private String	ca_middle_name_3;
	private String	ca_last_name_3;
	private String	ca_full_name_3;
	private String	ca_short_name_3;
	private String	ca_gender_3;
	private String	ca_marital_status_3;
	private String	ca_occupation_3;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_3;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private BigDecimal	ca_annual_income_3;
	private BigDecimal	ca_monthly_income_3;
	private String	ca_loan_obligations_3;
	private String	ca_family_maintenance_3;
	private String	ca_address_type_3;
	private String	ca_house_no_3;
	private String	ca_street_no_3;
	private String	ca_street_name_3;
	private String	ca_country_3;
	private String	ca_state_3;
	private String	ca_city_3;
	private String	ca_postal_code_3;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_3;
	private String	ca_nationality_3;
	private String	ca_country_of_birth_3;
	private String	ca_country_of_origin_3;
	private String	ca_email_id_3;
	private BigDecimal	ca_mobile_no_3;
	private String	ca_customer_type_4;
	private String	ca_cif_id_4;
	private String	ca_primary_branch_4;
	private String	ca_branch_name_4;
	private String	ca_salutation_4;
	private String	ca_first_name_4;
	private String	ca_middle_name_4;
	private String	ca_last_name_4;
	private String	ca_full_name_4;
	private String	ca_short_name_4;
	private String	ca_gender_4;
	private String	ca_marital_status_4;
	private String	ca_occupation_4;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_4;
	private BigDecimal	ca_annual_income_4;
	private BigDecimal	ca_monthly_income_4;
	private String	ca_loan_obligations_4;
	private String	ca_family_maintenance_4;
	private String	ca_address_type_4;
	private String	ca_house_no_4;
	private String	ca_street_no_4;
	private String	ca_street_name_4;
	private String	ca_country_4;
	private String	ca_state_4;
	private String	ca_city_4;
	private String	ca_postal_code_4;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_4;
	private String	ca_nationality_4;
	private String	ca_country_of_birth_4;
	private String	ca_country_of_origin_4;
	private String	ca_email_id_4;
	private BigDecimal	ca_mobile_no_4;
	private String	ca_customer_type_5;
	private String	ca_cif_id_5;
	private String	ca_primary_branch_5;
	private String	ca_branch_name_5;
	private String	ca_salutation_5;
	private String	ca_first_name_5;
	private String	ca_middle_name_5;
	private String	ca_last_name_5;
	private String	ca_full_name_5;
	private String	ca_short_name_5;
	private String	ca_gender_5;
	private String	ca_marital_status_5;
	private String	ca_occupation_5;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_5;
	private BigDecimal	ca_annual_income_5;
	private BigDecimal	ca_monthly_income_5;
	private String	ca_loan_obligations_5;
	private String	ca_family_maintenance_5;
	private String	ca_address_type_5;
	private String	ca_house_no_5;
	private String	ca_street_no_5;
	private String	ca_street_name_5;
	private String	ca_country_5;
	private String	ca_state_5;
	private String	ca_city_5;
	private String	ca_postal_code_5;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_5;
	private String	ca_nationality_5;
	private String	ca_country_of_birth_5;
	private String	ca_country_of_origin_5;
	private String	ca_email_id_5;
	private BigDecimal	ca_mobile_no_5;
	private String	ca_customer_type_6;
	private String	ca_cif_id_6;
	private String	ca_primary_branch_6;
	private String	ca_branch_name_6;
	private String	ca_salutation_6;
	private String	ca_first_name_6;
	private String	ca_middle_name_6;
	private String	ca_last_name_6;
	private String	ca_full_name_6;
	private String	ca_short_name_6;
	private String	ca_gender_6;
	private String	ca_marital_status_6;
	private String	ca_occupation_6;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_6;
	private BigDecimal	ca_annual_income_6;
	private BigDecimal	ca_monthly_income_6;
	private String	ca_loan_obligations_6;
	private String	ca_family_maintenance_6;
	private String	ca_address_type_6;
	private String	ca_house_no_6;
	private String	ca_street_no_6;
	private String	ca_street_name_6;
	private String	ca_country_6;
	private String	ca_state_6;
	private String	ca_city_6;
	private String	ca_postal_code_6;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_6;
	private String	ca_nationality_6;
	private String	ca_country_of_birth_6;
	private String	ca_country_of_origin_6;
	private String	ca_email_id_6;
	private BigDecimal	ca_mobile_no_6;
	private String	ca_customer_type_7;
	private String	ca_cif_id_7;
	private String	ca_primary_branch_7;
	private String	ca_branch_name_7;
	private String	ca_salutation_7;
	private String	ca_first_name_7;
	private String	ca_middle_name_7;
	private String	ca_last_name_7;
	private String	ca_full_name_7;
	private String	ca_short_name_7;
	private String	ca_gender_7;
	private String	ca_marital_status_7;
	private String	ca_occupation_7;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_7;
	private BigDecimal	ca_annual_income_7;
	private BigDecimal	ca_monthly_income_7;
	private String	ca_loan_obligations_7;
	private String	ca_family_maintenance_7;
	private String	ca_address_type_7;
	private String	ca_house_no_7;
	private String	ca_street_no_7;
	private String	ca_street_name_7;
	private String	ca_country_7;
	private String	ca_state_7;
	private String	ca_city_7;
	private String	ca_postal_code_7;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_7;
	private String	ca_nationality_7;
	private String	ca_country_of_birth_7;
	private String	ca_country_of_origin_7;
	private String	ca_email_id_7;
	private BigDecimal	ca_mobile_no_7;
	private String	ca_customer_type_8;
	private String	ca_cif_id_8;
	private String	ca_primary_branch_8;
	private String	ca_branch_name_8;
	private String	ca_salutation_8;
	private String	ca_first_name_8;
	private String	ca_middle_name_8;
	private String	ca_last_name_8;
	private String	ca_full_name_8;
	private String	ca_short_name_8;
	private String	ca_gender_8;
	private String	ca_marital_status_8;
	private String	ca_occupation_8;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_8;
	private BigDecimal	ca_annual_income_8;
	private BigDecimal	ca_monthly_income_8;
	private String	ca_loan_obligations_8;
	private String	ca_family_maintenance_8;
	private String	ca_address_type_8;
	private String	ca_house_no_8;
	private String	ca_street_no_8;
	private String	ca_street_name_8;
	private String	ca_country_8;
	private String	ca_state_8;
	private String	ca_city_8;
	private String	ca_postal_code_8;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_8;
	private String	ca_nationality_8;
	private String	ca_country_of_birth_8;
	private String	ca_country_of_origin_8;
	private String	ca_email_id_8;
	private BigDecimal	ca_mobile_no_8;
	private String	ca_customer_type_9;
	private String	ca_cif_id_9;
	private String	ca_primary_branch_9;
	private String	ca_branch_name_9;
	private String	ca_salutation_9;
	private String	ca_first_name_9;
	private String	ca_middle_name_9;
	private String	ca_last_name_9;
	private String	ca_full_name_9;
	private String	ca_short_name_9;
	private String	ca_gender_9;
	private String	ca_marital_status_9;
	private String	ca_occupation_9;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_9;
	private BigDecimal	ca_annual_income_9;
	private BigDecimal	ca_monthly_income_9;
	private String	ca_loan_obligations_9;
	private String	ca_family_maintenance_9;
	private String	ca_address_type_9;
	private String	ca_house_no_9;
	private String	ca_street_no_9;
	private String	ca_street_name_9;
	private String	ca_country_9;
	private String	ca_state_9;
	private String	ca_city_9;
	private String	ca_postal_code_9;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_9;
	private String	ca_nationality_9;
	private String	ca_country_of_birth_9;
	private String	ca_country_of_origin_9;
	private String	ca_email_id_9;
	private BigDecimal	ca_mobile_no_9;
	private String	ca_customer_type_10;
	private String	ca_cif_id_10;
	private String	ca_primary_branch_10;
	private String	ca_branch_name_10;
	private String	ca_salutation_10;
	private String	ca_first_name_10;
	private String	ca_middle_name_10;
	private String	ca_last_name_10;
	private String	ca_full_name_10;
	private String	ca_short_name_10;
	private String	ca_gender_10;
	private String	ca_marital_status_10;
	private String	ca_occupation_10;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_date_of_birth_10;
	private BigDecimal	ca_annual_income_10;
	private BigDecimal	ca_monthly_income_10;
	private String	ca_loan_obligations_10;
	private String	ca_family_maintenance_10;
	private String	ca_address_type_10;
	private String	ca_house_no_10;
	private String	ca_street_no_10;
	private String	ca_street_name_10;
	private String	ca_country_10;
	private String	ca_state_10;
	private String	ca_city_10;
	private String	ca_postal_code_10;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ca_address_valid_from_10;
	private String	ca_nationality_10;
	private String	ca_country_of_birth_10;
	private String	ca_country_of_origin_10;
	private String	ca_email_id_10;
	private BigDecimal	ca_mobile_no_10;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	kyc_date; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private	Date	kyc_review_date	;
	private	String	doc_verify_flg	;
	private String	comp_verify_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	comp_verify_date;
	private String ca_glshdesc;
	private	String	kyc_officer	;
	private String	kyc_compliance;
	private	String	kyc_remarks	;
	private String	comp_customerdetails;
	private	String	comp_accountdetails	;
	private String	comp_document;
	private	String	comp_signature	;
	private String	comp_remarks;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date comp_date;
	private String	comp_photo;
	private String	country_of_operation;
	private String	ca_countrycode_1;
	private String	ca_countrycode_2;
	private String	ca_countrycode_3;
	private String	ca_countrycode_4;
	private String	ca_countrycode_5;
	private String	ca_countrycode_6;
	private String	ca_countrycode_7;
	private String	ca_countrycode_8;
	private String	ca_countrycode_9;
	private String	ca_countrycode_10;
	
	private String	la_glcode;
	private String	la_gldesc;
	private String	la_glshcode;
	private String	la_glshdesc;
	private String	td_glcode;
	private String	td_gldesc;
	private String	td_glshcode;
	private String	td_glshdesc;
	private String	ca_remarks ;
    @DateTimeFormat(pattern = "dd-MM-yyyy") 
	private Date	ca_acct_opendate ;
    private	String	modify_flg	;
    private	String	del_flg	;
    private	String	verify_flg	;
    
	
	public String getVerify_flg() {
		return verify_flg;
	}


	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}


	public String getModify_flg() {
		return modify_flg;
	}


	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}


	public String getDel_flg() {
		return del_flg;
	}


	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}


	public String getCa_remarks() {
		return ca_remarks;
	}


	public void setCa_remarks(String ca_remarks) {
		this.ca_remarks = ca_remarks;
	}


	public Date getCa_acct_opendate() {
		return ca_acct_opendate;
	}


	public void setCa_acct_opendate(Date ca_acct_opendate) {
		this.ca_acct_opendate = ca_acct_opendate;
	}


	public String getLa_glcode() {
		return la_glcode;
	}


	public void setLa_glcode(String la_glcode) {
		this.la_glcode = la_glcode;
	}


	public String getLa_gldesc() {
		return la_gldesc;
	}


	public void setLa_gldesc(String la_gldesc) {
		this.la_gldesc = la_gldesc;
	}


	public String getLa_glshcode() {
		return la_glshcode;
	}


	public void setLa_glshcode(String la_glshcode) {
		this.la_glshcode = la_glshcode;
	}


	public String getLa_glshdesc() {
		return la_glshdesc;
	}


	public void setLa_glshdesc(String la_glshdesc) {
		this.la_glshdesc = la_glshdesc;
	}


	public String getTd_glcode() {
		return td_glcode;
	}


	public void setTd_glcode(String td_glcode) {
		this.td_glcode = td_glcode;
	}


	public String getTd_gldesc() {
		return td_gldesc;
	}


	public void setTd_gldesc(String td_gldesc) {
		this.td_gldesc = td_gldesc;
	}


	public String getTd_glshcode() {
		return td_glshcode;
	}


	public void setTd_glshcode(String td_glshcode) {
		this.td_glshcode = td_glshcode;
	}


	


	public String getTd_glshdesc() {
		return td_glshdesc;
	}


	public void setTd_glshdesc(String td_glshdesc) {
		this.td_glshdesc = td_glshdesc;
	}


	public Date getComp_date() {
		return comp_date;
	}


	public void setComp_date(Date comp_date) {
		this.comp_date = comp_date;
	}


	public String getComp_photo() {
		return comp_photo;
	}


	public void setComp_photo(String comp_photo) {
		this.comp_photo = comp_photo;
	}


	public String getCountry_of_operation() {
		return country_of_operation;
	}


	public void setCountry_of_operation(String country_of_operation) {
		this.country_of_operation = country_of_operation;
	}


	public String getCa_countrycode_1() {
		return ca_countrycode_1;
	}


	public void setCa_countrycode_1(String ca_countrycode_1) {
		this.ca_countrycode_1 = ca_countrycode_1;
	}


	public String getCa_countrycode_2() {
		return ca_countrycode_2;
	}


	public void setCa_countrycode_2(String ca_countrycode_2) {
		this.ca_countrycode_2 = ca_countrycode_2;
	}


	public String getCa_countrycode_3() {
		return ca_countrycode_3;
	}


	public void setCa_countrycode_3(String ca_countrycode_3) {
		this.ca_countrycode_3 = ca_countrycode_3;
	}


	public String getCa_countrycode_4() {
		return ca_countrycode_4;
	}


	public void setCa_countrycode_4(String ca_countrycode_4) {
		this.ca_countrycode_4 = ca_countrycode_4;
	}


	public String getCa_countrycode_5() {
		return ca_countrycode_5;
	}


	public void setCa_countrycode_5(String ca_countrycode_5) {
		this.ca_countrycode_5 = ca_countrycode_5;
	}


	public String getCa_countrycode_6() {
		return ca_countrycode_6;
	}


	public void setCa_countrycode_6(String ca_countrycode_6) {
		this.ca_countrycode_6 = ca_countrycode_6;
	}


	public String getCa_countrycode_7() {
		return ca_countrycode_7;
	}


	public void setCa_countrycode_7(String ca_countrycode_7) {
		this.ca_countrycode_7 = ca_countrycode_7;
	}


	public String getCa_countrycode_8() {
		return ca_countrycode_8;
	}


	public void setCa_countrycode_8(String ca_countrycode_8) {
		this.ca_countrycode_8 = ca_countrycode_8;
	}


	public String getCa_countrycode_9() {
		return ca_countrycode_9;
	}


	public void setCa_countrycode_9(String ca_countrycode_9) {
		this.ca_countrycode_9 = ca_countrycode_9;
	}


	public String getCa_countrycode_10() {
		return ca_countrycode_10;
	}


	public void setCa_countrycode_10(String ca_countrycode_10) {
		this.ca_countrycode_10 = ca_countrycode_10;
	}


	public String getKyc_officer() {
		return kyc_officer;
	}


	public void setKyc_officer(String kyc_officer) {
		this.kyc_officer = kyc_officer;
	}


	public String getKyc_compliance() {
		return kyc_compliance;
	}


	public void setKyc_compliance(String kyc_compliance) {
		this.kyc_compliance = kyc_compliance;
	}


	public String getKyc_remarks() {
		return kyc_remarks;
	}


	public void setKyc_remarks(String kyc_remarks) {
		this.kyc_remarks = kyc_remarks;
	}


	public String getComp_customerdetails() {
		return comp_customerdetails;
	}


	public void setComp_customerdetails(String comp_customerdetails) {
		this.comp_customerdetails = comp_customerdetails;
	}


	public String getComp_accountdetails() {
		return comp_accountdetails;
	}


	public void setComp_accountdetails(String comp_accountdetails) {
		this.comp_accountdetails = comp_accountdetails;
	}


	public String getComp_document() {
		return comp_document;
	}


	public void setComp_document(String comp_document) {
		this.comp_document = comp_document;
	}


	public String getComp_signature() {
		return comp_signature;
	}


	public void setComp_signature(String comp_signature) {
		this.comp_signature = comp_signature;
	}


	public String getComp_remarks() {
		return comp_remarks;
	}


	public void setComp_remarks(String comp_remarks) {
		this.comp_remarks = comp_remarks;
	}


	public String getCa_customer_type() {
		return ca_customer_type;
	}


	public void setCa_customer_type(String ca_customer_type) {
		this.ca_customer_type = ca_customer_type;
	}


	public String getCa_saluation() {
		return ca_saluation;
	}


	public void setCa_saluation(String ca_saluation) {
		this.ca_saluation = ca_saluation;
	}


	public String getCa_first_name() {
		return ca_first_name;
	}


	public void setCa_first_name(String ca_first_name) {
		this.ca_first_name = ca_first_name;
	}


	public String getMid_name() {
		return mid_name;
	}


	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}


	public String getCa_last_name() {
		return ca_last_name;
	}


	public void setCa_last_name(String ca_last_name) {
		this.ca_last_name = ca_last_name;
	}


	public String getCa_preferred_name() {
		return ca_preferred_name;
	}


	public void setCa_preferred_name(String ca_preferred_name) {
		this.ca_preferred_name = ca_preferred_name;
	}


	public String getCa_occupation1() {
		return ca_occupation1;
	}


	public void setCa_occupation1(String ca_occupation1) {
		this.ca_occupation1 = ca_occupation1;
	}


	public String getCa_gender() {
		return ca_gender;
	}


	public void setCa_gender(String ca_gender) {
		this.ca_gender = ca_gender;
	}


	public String getCa_martial_staus() {
		return ca_martial_staus;
	}


	public void setCa_martial_staus(String ca_martial_staus) {
		this.ca_martial_staus = ca_martial_staus;
	}


	public Date getCa_date_of_birth() {
		return ca_date_of_birth;
	}


	public void setCa_date_of_birth(Date ca_date_of_birth) {
		this.ca_date_of_birth = ca_date_of_birth;
	}


	public String getCa_address_type() {
		return ca_address_type;
	}


	public void setCa_address_type(String ca_address_type) {
		this.ca_address_type = ca_address_type;
	}


	public String getCa_house_no() {
		return ca_house_no;
	}


	public void setCa_house_no(String ca_house_no) {
		this.ca_house_no = ca_house_no;
	}


	public String getCa_street_no() {
		return ca_street_no;
	}


	public void setCa_street_no(String ca_street_no) {
		this.ca_street_no = ca_street_no;
	}


	public String getCa_street_name() {
		return ca_street_name;
	}


	public void setCa_street_name(String ca_street_name) {
		this.ca_street_name = ca_street_name;
	}


	public String getCa_country() {
		return ca_country;
	}


	public void setCa_country(String ca_country) {
		this.ca_country = ca_country;
	}


	public String getCa_state() {
		return ca_state;
	}


	public void setCa_state(String ca_state) {
		this.ca_state = ca_state;
	}


	public String getCa_city() {
		return ca_city;
	}


	public void setCa_city(String ca_city) {
		this.ca_city = ca_city;
	}


	public String getCa_postal_code() {
		return ca_postal_code;
	}


	public void setCa_postal_code(String ca_postal_code) {
		this.ca_postal_code = ca_postal_code;
	}


	public Date getCa_address_validation_form() {
		return ca_address_validation_form;
	}


	public void setCa_address_validation_form(Date ca_address_validation_form) {
		this.ca_address_validation_form = ca_address_validation_form;
	}


	public String getCa_nationality() {
		return ca_nationality;
	}


	public void setCa_nationality(String ca_nationality) {
		this.ca_nationality = ca_nationality;
	}


	public String getCa_country_of_birth() {
		return ca_country_of_birth;
	}


	public void setCa_country_of_birth(String ca_country_of_birth) {
		this.ca_country_of_birth = ca_country_of_birth;
	}


	public String getCa_email_id() {
		return ca_email_id;
	}


	public void setCa_email_id(String ca_email_id) {
		this.ca_email_id = ca_email_id;
	}


	public String getCa_mobile_number() {
		return ca_mobile_number;
	}


	public void setCa_mobile_number(String ca_mobile_number) {
		this.ca_mobile_number = ca_mobile_number;
	}


	public String getCa_phone_number() {
		return ca_phone_number;
	}


	public void setCa_phone_number(String ca_phone_number) {
		this.ca_phone_number = ca_phone_number;
	}


	public String getCa_occupation2() {
		return ca_occupation2;
	}


	public void setCa_occupation2(String ca_occupation2) {
		this.ca_occupation2 = ca_occupation2;
	}


	public String getCa_non_resident() {
		return ca_non_resident;
	}


	public void setCa_non_resident(String ca_non_resident) {
		this.ca_non_resident = ca_non_resident;
	}


	public String getCa_staff_indicator() {
		return ca_staff_indicator;
	}


	public void setCa_staff_indicator(String ca_staff_indicator) {
		this.ca_staff_indicator = ca_staff_indicator;
	}


	public String getCa_trdfin() {
		return ca_trdfin;
	}


	public void setCa_trdfin(String ca_trdfin) {
		this.ca_trdfin = ca_trdfin;
	}


	public String getCa_minor_indicator() {
		return ca_minor_indicator;
	}


	public void setCa_minor_indicator(String ca_minor_indicator) {
		this.ca_minor_indicator = ca_minor_indicator;
	}


	public String getCa_guardian_name() {
		return ca_guardian_name;
	}


	public void setCa_guardian_name(String ca_guardian_name) {
		this.ca_guardian_name = ca_guardian_name;
	}


	public String getCa_schemetype() {
		return ca_schemetype;
	}


	public void setCa_schemetype(String ca_schemetype) {
		this.ca_schemetype = ca_schemetype;
	}


	public String getCa_scheme_code() {
		return ca_scheme_code;
	}


	public void setCa_scheme_code(String ca_scheme_code) {
		this.ca_scheme_code = ca_scheme_code;
	}


	public String getCa_currency() {
		return ca_currency;
	}


	public void setCa_currency(String ca_currency) {
		this.ca_currency = ca_currency;
	}


	public String getCa_glcode() {
		return ca_glcode;
	}


	public void setCa_glcode(String ca_glcode) {
		this.ca_glcode = ca_glcode;
	}


	public String getCa_solid() {
		return ca_solid;
	}


	public void setCa_solid(String ca_solid) {
		this.ca_solid = ca_solid;
	}


	public String getCa_idenditification_number() {
		return ca_idenditification_number;
	}


	public void setCa_idenditification_number(String ca_idenditification_number) {
		this.ca_idenditification_number = ca_idenditification_number;
	}


	public Date getCa_issue_date() {
		return ca_issue_date;
	}


	public void setCa_issue_date(Date ca_issue_date) {
		this.ca_issue_date = ca_issue_date;
	}


	public String getCa_passport_number() {
		return ca_passport_number;
	}


	public void setCa_passport_number(String ca_passport_number) {
		this.ca_passport_number = ca_passport_number;
	}


	public Date getCa_expiry_date() {
		return ca_expiry_date;
	}


	public void setCa_expiry_date(Date ca_expiry_date) {
		this.ca_expiry_date = ca_expiry_date;
	}


	public String getCa_addrtype_nri() {
		return ca_addrtype_nri;
	}


	public void setCa_addrtype_nri(String ca_addrtype_nri) {
		this.ca_addrtype_nri = ca_addrtype_nri;
	}


	public String getCa_relname_nri() {
		return ca_relname_nri;
	}


	public void setCa_relname_nri(String ca_relname_nri) {
		this.ca_relname_nri = ca_relname_nri;
	}


	public String getCa_relationship_nri() {
		return ca_relationship_nri;
	}


	public void setCa_relationship_nri(String ca_relationship_nri) {
		this.ca_relationship_nri = ca_relationship_nri;
	}


	public String getCa_locaddrnri() {
		return ca_locaddrnri;
	}


	public void setCa_locaddrnri(String ca_locaddrnri) {
		this.ca_locaddrnri = ca_locaddrnri;
	}


	public String getCa_ctry_nri() {
		return ca_ctry_nri;
	}


	public void setCa_ctry_nri(String ca_ctry_nri) {
		this.ca_ctry_nri = ca_ctry_nri;
	}


	public String getCa_nri_state() {
		return ca_nri_state;
	}


	public void setCa_nri_state(String ca_nri_state) {
		this.ca_nri_state = ca_nri_state;
	}


	public String getCa_cty_nri() {
		return ca_cty_nri;
	}


	public void setCa_cty_nri(String ca_cty_nri) {
		this.ca_cty_nri = ca_cty_nri;
	}


	public String getCa_code_nri() {
		return ca_code_nri;
	}


	public void setCa_code_nri(String ca_code_nri) {
		this.ca_code_nri = ca_code_nri;
	}


	public String getCa_phoneno_nri() {
		return ca_phoneno_nri;
	}


	public void setCa_phoneno_nri(String ca_phoneno_nri) {
		this.ca_phoneno_nri = ca_phoneno_nri;
	}


	public String getCa_emp_id() {
		return ca_emp_id;
	}


	public void setCa_emp_id(String ca_emp_id) {
		this.ca_emp_id = ca_emp_id;
	}


	public String getCa_emp_name() {
		return ca_emp_name;
	}


	public void setCa_emp_name(String ca_emp_name) {
		this.ca_emp_name = ca_emp_name;
	}


	public String getCa_emp_desi() {
		return ca_emp_desi;
	}


	public void setCa_emp_desi(String ca_emp_desi) {
		this.ca_emp_desi = ca_emp_desi;
	}


	public String getCa_emp_branch() {
		return ca_emp_branch;
	}


	public void setCa_emp_branch(String ca_emp_branch) {
		this.ca_emp_branch = ca_emp_branch;
	}


	public String getCa_nationlality_nri() {
		return ca_nationlality_nri;
	}


	public void setCa_nationlality_nri(String ca_nationlality_nri) {
		this.ca_nationlality_nri = ca_nationlality_nri;
	}


	public String getCa_swftcodebk_tf() {
		return ca_swftcodebk_tf;
	}


	public void setCa_swftcodebk_tf(String ca_swftcodebk_tf) {
		this.ca_swftcodebk_tf = ca_swftcodebk_tf;
	}


	public String getCa_codegvctlbk_tf() {
		return ca_codegvctlbk_tf;
	}


	public void setCa_codegvctlbk_tf(String ca_codegvctlbk_tf) {
		this.ca_codegvctlbk_tf = ca_codegvctlbk_tf;
	}


	public String getCa_codegvntrd_tf() {
		return ca_codegvntrd_tf;
	}


	public void setCa_codegvntrd_tf(String ca_codegvntrd_tf) {
		this.ca_codegvntrd_tf = ca_codegvntrd_tf;
	}


	public String getCa_swftcodee_tf() {
		return ca_swftcodee_tf;
	}


	public void setCa_swftcodee_tf(String ca_swftcodee_tf) {
		this.ca_swftcodee_tf = ca_swftcodee_tf;
	}


	public String getCa_min_gurd() {
		return ca_min_gurd;
	}


	public void setCa_min_gurd(String ca_min_gurd) {
		this.ca_min_gurd = ca_min_gurd;
	}


	public String getCa_min_rell() {
		return ca_min_rell;
	}


	public void setCa_min_rell(String ca_min_rell) {
		this.ca_min_rell = ca_min_rell;
	}


	public String getCa_min_add() {
		return ca_min_add;
	}


	public void setCa_min_add(String ca_min_add) {
		this.ca_min_add = ca_min_add;
	}


	public String getCa_min_addcode() {
		return ca_min_addcode;
	}


	public void setCa_min_addcode(String ca_min_addcode) {
		this.ca_min_addcode = ca_min_addcode;
	}


	public String getCa_min_state1() {
		return ca_min_state1;
	}


	public void setCa_min_state1(String ca_min_state1) {
		this.ca_min_state1 = ca_min_state1;
	}


	public String getCa_min_cty1() {
		return ca_min_cty1;
	}


	public void setCa_min_cty1(String ca_min_cty1) {
		this.ca_min_cty1 = ca_min_cty1;
	}


	public String getCa_min_post1() {
		return ca_min_post1;
	}


	public void setCa_min_post1(String ca_min_post1) {
		this.ca_min_post1 = ca_min_post1;
	}


	public String getCa_min_cont1() {
		return ca_min_cont1;
	}


	public void setCa_min_cont1(String ca_min_cont1) {
		this.ca_min_cont1 = ca_min_cont1;
	}


	public String getCa_country_of_incorp() {
		return ca_country_of_incorp;
	}


	public void setCa_country_of_incorp(String ca_country_of_incorp) {
		this.ca_country_of_incorp = ca_country_of_incorp;
	}


	public String getCa_corp_name() {
		return ca_corp_name;
	}


	public void setCa_corp_name(String ca_corp_name) {
		this.ca_corp_name = ca_corp_name;
	}


	public String getCa_nature_of_business() {
		return ca_nature_of_business;
	}


	public void setCa_nature_of_business(String ca_nature_of_business) {
		this.ca_nature_of_business = ca_nature_of_business;
	}


	public String getCa_mode_of_operation() {
		return ca_mode_of_operation;
	}


	public void setCa_mode_of_operation(String ca_mode_of_operation) {
		this.ca_mode_of_operation = ca_mode_of_operation;
	}


	public String getCa_contact_person_name() {
		return ca_contact_person_name;
	}


	public void setCa_contact_person_name(String ca_contact_person_name) {
		this.ca_contact_person_name = ca_contact_person_name;
	}


	public String getCa_job_title() {
		return ca_job_title;
	}


	public void setCa_job_title(String ca_job_title) {
		this.ca_job_title = ca_job_title;
	}


	public String getCa_email_address() {
		return ca_email_address;
	}


	public void setCa_email_address(String ca_email_address) {
		this.ca_email_address = ca_email_address;
	}


	public String getCa_fax_no() {
		return ca_fax_no;
	}


	public void setCa_fax_no(String ca_fax_no) {
		this.ca_fax_no = ca_fax_no;
	}


	public String getCa_capital_invested() {
		return ca_capital_invested;
	}


	public void setCa_capital_invested(String ca_capital_invested) {
		this.ca_capital_invested = ca_capital_invested;
	}


	public String getCa_expected_turnover() {
		return ca_expected_turnover;
	}


	public void setCa_expected_turnover(String ca_expected_turnover) {
		this.ca_expected_turnover = ca_expected_turnover;
	}


	public String getCa_expected_expenditure() {
		return ca_expected_expenditure;
	}


	public void setCa_expected_expenditure(String ca_expected_expenditure) {
		this.ca_expected_expenditure = ca_expected_expenditure;
	}


	public String getCa_account_no() {
		return ca_account_no;
	}


	public void setCa_account_no(String ca_account_no) {
		this.ca_account_no = ca_account_no;
	}


	public String getCa_introducer_name() {
		return ca_introducer_name;
	}


	public void setCa_introducer_name(String ca_introducer_name) {
		this.ca_introducer_name = ca_introducer_name;
	}


	public String getCa_address() {
		return ca_address;
	}


	public void setCa_address(String ca_address) {
		this.ca_address = ca_address;
	}


	public String getCa_mobile_no() {
		return ca_mobile_no;
	}


	public void setCa_mobile_no(String ca_mobile_no) {
		this.ca_mobile_no = ca_mobile_no;
	}


	public String getUser_id1() {
		return user_id1;
	}


	public void setUser_id1(String user_id1) {
		this.user_id1 = user_id1;
	}


	public String getUser_id2() {
		return user_id2;
	}


	public void setUser_id2(String user_id2) {
		this.user_id2 = user_id2;
	}


	public String getUser_id3() {
		return user_id3;
	}


	public void setUser_id3(String user_id3) {
		this.user_id3 = user_id3;
	}


	public String getTemp_k() {
		return temp_k;
	}


	public void setTemp_k(String temp_k) {
		this.temp_k = temp_k;
	}


	public String getCif_id() {
		return cif_id;
	}


	public void setCif_id(String cif_id) {
		this.cif_id = cif_id;
	}


	public String getAccount_id() {
		return account_id;
	}


	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}


	public String getNotify_flg() {
		return notify_flg;
	}


	public void setNotify_flg(String notify_flg) {
		this.notify_flg = notify_flg;
	}


	public String getEntity_flg() {
		return entity_flg;
	}


	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}


	public String getApproval_flg() {
		return approval_flg;
	}


	public void setApproval_flg(String approval_flg) {
		this.approval_flg = approval_flg;
	}


	public String getKyc_flg() {
		return kyc_flg;
	}


	public void setKyc_flg(String kyc_flg) {
		this.kyc_flg = kyc_flg;
	}


	public String getKyc_hold_flg() {
		return kyc_hold_flg;
	}


	public void setKyc_hold_flg(String kyc_hold_flg) {
		this.kyc_hold_flg = kyc_hold_flg;
	}


	public String getKyc_reject_flg() {
		return kyc_reject_flg;
	}


	public void setKyc_reject_flg(String kyc_reject_flg) {
		this.kyc_reject_flg = kyc_reject_flg;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getHold_remarks() {
		return hold_remarks;
	}


	public void setHold_remarks(String hold_remarks) {
		this.hold_remarks = hold_remarks;
	}


	public String getReject_remarks() {
		return reject_remarks;
	}


	public void setReject_remarks(String reject_remarks) {
		this.reject_remarks = reject_remarks;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getCa_acct_type() {
		return ca_acct_type;
	}


	public void setCa_acct_type(String ca_acct_type) {
		this.ca_acct_type = ca_acct_type;
	}


	public String getAppl_ref_no() {
		return appl_ref_no;
	}


	public void setAppl_ref_no(String appl_ref_no) {
		this.appl_ref_no = appl_ref_no;
	}


	public String getRec_no() {
		return rec_no;
	}


	public void setRec_no(String rec_no) {
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


	public String getChannel_id() {
		return channel_id;
	}


	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}


	public String getRelationship() {
		return relationship;
	}


	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}


	public String getHold_type() {
		return hold_type;
	}


	public void setHold_type(String hold_type) {
		this.hold_type = hold_type;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public byte[] getSign() {
		return sign;
	}


	public void setSign(byte[] sign) {
		this.sign = sign;
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


	public String getCertificate_incorporation() {
		return certificate_incorporation;
	}


	public void setCertificate_incorporation(String certificate_incorporation) {
		this.certificate_incorporation = certificate_incorporation;
	}


	public String getCa_customer_type_1() {
		return ca_customer_type_1;
	}


	public void setCa_customer_type_1(String ca_customer_type_1) {
		this.ca_customer_type_1 = ca_customer_type_1;
	}


	public String getCa_cif_id_1() {
		return ca_cif_id_1;
	}


	public void setCa_cif_id_1(String ca_cif_id_1) {
		this.ca_cif_id_1 = ca_cif_id_1;
	}


	public String getCa_primary_branch_1() {
		return ca_primary_branch_1;
	}


	public void setCa_primary_branch_1(String ca_primary_branch_1) {
		this.ca_primary_branch_1 = ca_primary_branch_1;
	}


	public String getCa_branch_name_1() {
		return ca_branch_name_1;
	}


	public void setCa_branch_name_1(String ca_branch_name_1) {
		this.ca_branch_name_1 = ca_branch_name_1;
	}


	public String getCa_salutation_1() {
		return ca_salutation_1;
	}


	public void setCa_salutation_1(String ca_salutation_1) {
		this.ca_salutation_1 = ca_salutation_1;
	}


	public String getCa_first_name_1() {
		return ca_first_name_1;
	}


	public void setCa_first_name_1(String ca_first_name_1) {
		this.ca_first_name_1 = ca_first_name_1;
	}


	public String getCa_middle_name_1() {
		return ca_middle_name_1;
	}


	public void setCa_middle_name_1(String ca_middle_name_1) {
		this.ca_middle_name_1 = ca_middle_name_1;
	}


	public String getCa_last_name_1() {
		return ca_last_name_1;
	}


	public void setCa_last_name_1(String ca_last_name_1) {
		this.ca_last_name_1 = ca_last_name_1;
	}


	public String getCa_full_name_1() {
		return ca_full_name_1;
	}


	public void setCa_full_name_1(String ca_full_name_1) {
		this.ca_full_name_1 = ca_full_name_1;
	}


	public String getCa_short_name_1() {
		return ca_short_name_1;
	}


	public void setCa_short_name_1(String ca_short_name_1) {
		this.ca_short_name_1 = ca_short_name_1;
	}


	public String getCa_gender_1() {
		return ca_gender_1;
	}


	public void setCa_gender_1(String ca_gender_1) {
		this.ca_gender_1 = ca_gender_1;
	}


	public String getCa_marital_status_1() {
		return ca_marital_status_1;
	}


	public void setCa_marital_status_1(String ca_marital_status_1) {
		this.ca_marital_status_1 = ca_marital_status_1;
	}


	public String getCa_occupation_1() {
		return ca_occupation_1;
	}


	public void setCa_occupation_1(String ca_occupation_1) {
		this.ca_occupation_1 = ca_occupation_1;
	}


	public Date getCa_date_of_birth_1() {
		return ca_date_of_birth_1;
	}


	public void setCa_date_of_birth_1(Date ca_date_of_birth_1) {
		this.ca_date_of_birth_1 = ca_date_of_birth_1;
	}


	public BigDecimal getCa_annual_income_1() {
		return ca_annual_income_1;
	}


	public void setCa_annual_income_1(BigDecimal ca_annual_income_1) {
		this.ca_annual_income_1 = ca_annual_income_1;
	}


	public BigDecimal getCa_monthly_income_1() {
		return ca_monthly_income_1;
	}


	public void setCa_monthly_income_1(BigDecimal ca_monthly_income_1) {
		this.ca_monthly_income_1 = ca_monthly_income_1;
	}


	public String getCa_loan_obligations_1() {
		return ca_loan_obligations_1;
	}


	public void setCa_loan_obligations_1(String ca_loan_obligations_1) {
		this.ca_loan_obligations_1 = ca_loan_obligations_1;
	}


	public String getCa_family_maintenance_1() {
		return ca_family_maintenance_1;
	}


	public void setCa_family_maintenance_1(String ca_family_maintenance_1) {
		this.ca_family_maintenance_1 = ca_family_maintenance_1;
	}


	public String getCa_address_type_1() {
		return ca_address_type_1;
	}


	public void setCa_address_type_1(String ca_address_type_1) {
		this.ca_address_type_1 = ca_address_type_1;
	}


	public String getCa_house_no_1() {
		return ca_house_no_1;
	}


	public void setCa_house_no_1(String ca_house_no_1) {
		this.ca_house_no_1 = ca_house_no_1;
	}


	public String getCa_street_no_1() {
		return ca_street_no_1;
	}


	public void setCa_street_no_1(String ca_street_no_1) {
		this.ca_street_no_1 = ca_street_no_1;
	}


	public String getCa_street_name_1() {
		return ca_street_name_1;
	}


	public void setCa_street_name_1(String ca_street_name_1) {
		this.ca_street_name_1 = ca_street_name_1;
	}


	public String getCa_country_1() {
		return ca_country_1;
	}


	public void setCa_country_1(String ca_country_1) {
		this.ca_country_1 = ca_country_1;
	}


	public String getCa_state_1() {
		return ca_state_1;
	}


	public void setCa_state_1(String ca_state_1) {
		this.ca_state_1 = ca_state_1;
	}


	public String getCa_city_1() {
		return ca_city_1;
	}


	public void setCa_city_1(String ca_city_1) {
		this.ca_city_1 = ca_city_1;
	}


	public String getCa_postal_code_1() {
		return ca_postal_code_1;
	}


	public void setCa_postal_code_1(String ca_postal_code_1) {
		this.ca_postal_code_1 = ca_postal_code_1;
	}


	public Date getCa_address_valid_from_1() {
		return ca_address_valid_from_1;
	}


	public void setCa_address_valid_from_1(Date ca_address_valid_from_1) {
		this.ca_address_valid_from_1 = ca_address_valid_from_1;
	}


	public String getCa_nationality_1() {
		return ca_nationality_1;
	}


	public void setCa_nationality_1(String ca_nationality_1) {
		this.ca_nationality_1 = ca_nationality_1;
	}


	public String getCa_country_of_birth_1() {
		return ca_country_of_birth_1;
	}


	public void setCa_country_of_birth_1(String ca_country_of_birth_1) {
		this.ca_country_of_birth_1 = ca_country_of_birth_1;
	}


	public String getCa_country_of_origin_1() {
		return ca_country_of_origin_1;
	}


	public void setCa_country_of_origin_1(String ca_country_of_origin_1) {
		this.ca_country_of_origin_1 = ca_country_of_origin_1;
	}


	public String getCa_email_id_1() {
		return ca_email_id_1;
	}


	public void setCa_email_id_1(String ca_email_id_1) {
		this.ca_email_id_1 = ca_email_id_1;
	}


	public BigDecimal getCa_mobile_no_1() {
		return ca_mobile_no_1;
	}


	public void setCa_mobile_no_1(BigDecimal ca_mobile_no_1) {
		this.ca_mobile_no_1 = ca_mobile_no_1;
	}


	public String getCa_customer_type_2() {
		return ca_customer_type_2;
	}


	public void setCa_customer_type_2(String ca_customer_type_2) {
		this.ca_customer_type_2 = ca_customer_type_2;
	}


	public String getCa_cif_id_2() {
		return ca_cif_id_2;
	}


	public void setCa_cif_id_2(String ca_cif_id_2) {
		this.ca_cif_id_2 = ca_cif_id_2;
	}


	public String getCa_primary_branch_2() {
		return ca_primary_branch_2;
	}


	public void setCa_primary_branch_2(String ca_primary_branch_2) {
		this.ca_primary_branch_2 = ca_primary_branch_2;
	}


	public String getCa_branch_name_2() {
		return ca_branch_name_2;
	}


	public void setCa_branch_name_2(String ca_branch_name_2) {
		this.ca_branch_name_2 = ca_branch_name_2;
	}


	public String getCa_salutation_2() {
		return ca_salutation_2;
	}


	public void setCa_salutation_2(String ca_salutation_2) {
		this.ca_salutation_2 = ca_salutation_2;
	}


	public String getCa_first_name_2() {
		return ca_first_name_2;
	}


	public void setCa_first_name_2(String ca_first_name_2) {
		this.ca_first_name_2 = ca_first_name_2;
	}


	public String getCa_middle_name_2() {
		return ca_middle_name_2;
	}


	public void setCa_middle_name_2(String ca_middle_name_2) {
		this.ca_middle_name_2 = ca_middle_name_2;
	}


	public String getCa_last_name_2() {
		return ca_last_name_2;
	}


	public void setCa_last_name_2(String ca_last_name_2) {
		this.ca_last_name_2 = ca_last_name_2;
	}


	public String getCa_full_name_2() {
		return ca_full_name_2;
	}


	public void setCa_full_name_2(String ca_full_name_2) {
		this.ca_full_name_2 = ca_full_name_2;
	}


	public String getCa_short_name_2() {
		return ca_short_name_2;
	}


	public void setCa_short_name_2(String ca_short_name_2) {
		this.ca_short_name_2 = ca_short_name_2;
	}


	public String getCa_gender_2() {
		return ca_gender_2;
	}


	public void setCa_gender_2(String ca_gender_2) {
		this.ca_gender_2 = ca_gender_2;
	}


	public String getCa_marital_status_2() {
		return ca_marital_status_2;
	}


	public void setCa_marital_status_2(String ca_marital_status_2) {
		this.ca_marital_status_2 = ca_marital_status_2;
	}


	public String getCa_occupation_2() {
		return ca_occupation_2;
	}


	public void setCa_occupation_2(String ca_occupation_2) {
		this.ca_occupation_2 = ca_occupation_2;
	}


	public Date getCa_date_of_birth_2() {
		return ca_date_of_birth_2;
	}


	public void setCa_date_of_birth_2(Date ca_date_of_birth_2) {
		this.ca_date_of_birth_2 = ca_date_of_birth_2;
	}


	public BigDecimal getCa_annual_income_2() {
		return ca_annual_income_2;
	}


	public void setCa_annual_income_2(BigDecimal ca_annual_income_2) {
		this.ca_annual_income_2 = ca_annual_income_2;
	}


	public BigDecimal getCa_monthly_income_2() {
		return ca_monthly_income_2;
	}


	public void setCa_monthly_income_2(BigDecimal ca_monthly_income_2) {
		this.ca_monthly_income_2 = ca_monthly_income_2;
	}


	public String getCa_loan_obligations_2() {
		return ca_loan_obligations_2;
	}


	public void setCa_loan_obligations_2(String ca_loan_obligations_2) {
		this.ca_loan_obligations_2 = ca_loan_obligations_2;
	}


	public String getCa_family_maintenance_2() {
		return ca_family_maintenance_2;
	}


	public void setCa_family_maintenance_2(String ca_family_maintenance_2) {
		this.ca_family_maintenance_2 = ca_family_maintenance_2;
	}


	public String getCa_address_type_2() {
		return ca_address_type_2;
	}


	public void setCa_address_type_2(String ca_address_type_2) {
		this.ca_address_type_2 = ca_address_type_2;
	}


	public String getCa_house_no_2() {
		return ca_house_no_2;
	}


	public void setCa_house_no_2(String ca_house_no_2) {
		this.ca_house_no_2 = ca_house_no_2;
	}


	public String getCa_street_no_2() {
		return ca_street_no_2;
	}


	public void setCa_street_no_2(String ca_street_no_2) {
		this.ca_street_no_2 = ca_street_no_2;
	}


	public String getCa_street_name_2() {
		return ca_street_name_2;
	}


	public void setCa_street_name_2(String ca_street_name_2) {
		this.ca_street_name_2 = ca_street_name_2;
	}


	public String getCa_country_2() {
		return ca_country_2;
	}


	public void setCa_country_2(String ca_country_2) {
		this.ca_country_2 = ca_country_2;
	}


	public String getCa_state_2() {
		return ca_state_2;
	}


	public void setCa_state_2(String ca_state_2) {
		this.ca_state_2 = ca_state_2;
	}


	public String getCa_city_2() {
		return ca_city_2;
	}


	public void setCa_city_2(String ca_city_2) {
		this.ca_city_2 = ca_city_2;
	}


	public String getCa_postal_code_2() {
		return ca_postal_code_2;
	}


	public void setCa_postal_code_2(String ca_postal_code_2) {
		this.ca_postal_code_2 = ca_postal_code_2;
	}


	public Date getCa_address_valid_from_2() {
		return ca_address_valid_from_2;
	}


	public void setCa_address_valid_from_2(Date ca_address_valid_from_2) {
		this.ca_address_valid_from_2 = ca_address_valid_from_2;
	}


	public String getCa_nationality_2() {
		return ca_nationality_2;
	}


	public void setCa_nationality_2(String ca_nationality_2) {
		this.ca_nationality_2 = ca_nationality_2;
	}


	public String getCa_country_of_birth_2() {
		return ca_country_of_birth_2;
	}


	public void setCa_country_of_birth_2(String ca_country_of_birth_2) {
		this.ca_country_of_birth_2 = ca_country_of_birth_2;
	}


	public String getCa_country_of_origin_2() {
		return ca_country_of_origin_2;
	}


	public void setCa_country_of_origin_2(String ca_country_of_origin_2) {
		this.ca_country_of_origin_2 = ca_country_of_origin_2;
	}


	public String getCa_email_id_2() {
		return ca_email_id_2;
	}


	public void setCa_email_id_2(String ca_email_id_2) {
		this.ca_email_id_2 = ca_email_id_2;
	}


	public BigDecimal getCa_mobile_no_2() {
		return ca_mobile_no_2;
	}


	public void setCa_mobile_no_2(BigDecimal ca_mobile_no_2) {
		this.ca_mobile_no_2 = ca_mobile_no_2;
	}


	public String getCa_customer_type_3() {
		return ca_customer_type_3;
	}


	public void setCa_customer_type_3(String ca_customer_type_3) {
		this.ca_customer_type_3 = ca_customer_type_3;
	}


	public String getCa_cif_id_3() {
		return ca_cif_id_3;
	}


	public void setCa_cif_id_3(String ca_cif_id_3) {
		this.ca_cif_id_3 = ca_cif_id_3;
	}


	public String getCa_primary_branch_3() {
		return ca_primary_branch_3;
	}


	public void setCa_primary_branch_3(String ca_primary_branch_3) {
		this.ca_primary_branch_3 = ca_primary_branch_3;
	}


	public String getCa_branch_name_3() {
		return ca_branch_name_3;
	}


	public void setCa_branch_name_3(String ca_branch_name_3) {
		this.ca_branch_name_3 = ca_branch_name_3;
	}


	public String getCa_salutation_3() {
		return ca_salutation_3;
	}


	public void setCa_salutation_3(String ca_salutation_3) {
		this.ca_salutation_3 = ca_salutation_3;
	}


	public String getCa_first_name_3() {
		return ca_first_name_3;
	}


	public void setCa_first_name_3(String ca_first_name_3) {
		this.ca_first_name_3 = ca_first_name_3;
	}


	public String getCa_middle_name_3() {
		return ca_middle_name_3;
	}


	public void setCa_middle_name_3(String ca_middle_name_3) {
		this.ca_middle_name_3 = ca_middle_name_3;
	}


	public String getCa_last_name_3() {
		return ca_last_name_3;
	}


	public void setCa_last_name_3(String ca_last_name_3) {
		this.ca_last_name_3 = ca_last_name_3;
	}


	public String getCa_full_name_3() {
		return ca_full_name_3;
	}


	public void setCa_full_name_3(String ca_full_name_3) {
		this.ca_full_name_3 = ca_full_name_3;
	}


	public String getCa_short_name_3() {
		return ca_short_name_3;
	}


	public void setCa_short_name_3(String ca_short_name_3) {
		this.ca_short_name_3 = ca_short_name_3;
	}


	public String getCa_gender_3() {
		return ca_gender_3;
	}


	public void setCa_gender_3(String ca_gender_3) {
		this.ca_gender_3 = ca_gender_3;
	}


	public String getCa_marital_status_3() {
		return ca_marital_status_3;
	}


	public void setCa_marital_status_3(String ca_marital_status_3) {
		this.ca_marital_status_3 = ca_marital_status_3;
	}


	public String getCa_occupation_3() {
		return ca_occupation_3;
	}


	public void setCa_occupation_3(String ca_occupation_3) {
		this.ca_occupation_3 = ca_occupation_3;
	}


	public Date getCa_date_of_birth_3() {
		return ca_date_of_birth_3;
	}


	public void setCa_date_of_birth_3(Date ca_date_of_birth_3) {
		this.ca_date_of_birth_3 = ca_date_of_birth_3;
	}


	public BigDecimal getCa_annual_income_3() {
		return ca_annual_income_3;
	}


	public void setCa_annual_income_3(BigDecimal ca_annual_income_3) {
		this.ca_annual_income_3 = ca_annual_income_3;
	}


	public BigDecimal getCa_monthly_income_3() {
		return ca_monthly_income_3;
	}


	public void setCa_monthly_income_3(BigDecimal ca_monthly_income_3) {
		this.ca_monthly_income_3 = ca_monthly_income_3;
	}


	public String getCa_loan_obligations_3() {
		return ca_loan_obligations_3;
	}


	public void setCa_loan_obligations_3(String ca_loan_obligations_3) {
		this.ca_loan_obligations_3 = ca_loan_obligations_3;
	}


	public String getCa_family_maintenance_3() {
		return ca_family_maintenance_3;
	}


	public void setCa_family_maintenance_3(String ca_family_maintenance_3) {
		this.ca_family_maintenance_3 = ca_family_maintenance_3;
	}


	public String getCa_address_type_3() {
		return ca_address_type_3;
	}


	public void setCa_address_type_3(String ca_address_type_3) {
		this.ca_address_type_3 = ca_address_type_3;
	}


	public String getCa_house_no_3() {
		return ca_house_no_3;
	}


	public void setCa_house_no_3(String ca_house_no_3) {
		this.ca_house_no_3 = ca_house_no_3;
	}


	public String getCa_street_no_3() {
		return ca_street_no_3;
	}


	public void setCa_street_no_3(String ca_street_no_3) {
		this.ca_street_no_3 = ca_street_no_3;
	}


	public String getCa_street_name_3() {
		return ca_street_name_3;
	}


	public void setCa_street_name_3(String ca_street_name_3) {
		this.ca_street_name_3 = ca_street_name_3;
	}


	public String getCa_country_3() {
		return ca_country_3;
	}


	public void setCa_country_3(String ca_country_3) {
		this.ca_country_3 = ca_country_3;
	}


	public String getCa_state_3() {
		return ca_state_3;
	}


	public void setCa_state_3(String ca_state_3) {
		this.ca_state_3 = ca_state_3;
	}


	public String getCa_city_3() {
		return ca_city_3;
	}


	public void setCa_city_3(String ca_city_3) {
		this.ca_city_3 = ca_city_3;
	}


	public String getCa_postal_code_3() {
		return ca_postal_code_3;
	}


	public void setCa_postal_code_3(String ca_postal_code_3) {
		this.ca_postal_code_3 = ca_postal_code_3;
	}


	public Date getCa_address_valid_from_3() {
		return ca_address_valid_from_3;
	}


	public void setCa_address_valid_from_3(Date ca_address_valid_from_3) {
		this.ca_address_valid_from_3 = ca_address_valid_from_3;
	}


	public String getCa_nationality_3() {
		return ca_nationality_3;
	}


	public void setCa_nationality_3(String ca_nationality_3) {
		this.ca_nationality_3 = ca_nationality_3;
	}


	public String getCa_country_of_birth_3() {
		return ca_country_of_birth_3;
	}


	public void setCa_country_of_birth_3(String ca_country_of_birth_3) {
		this.ca_country_of_birth_3 = ca_country_of_birth_3;
	}


	public String getCa_country_of_origin_3() {
		return ca_country_of_origin_3;
	}


	public void setCa_country_of_origin_3(String ca_country_of_origin_3) {
		this.ca_country_of_origin_3 = ca_country_of_origin_3;
	}


	public String getCa_email_id_3() {
		return ca_email_id_3;
	}


	public void setCa_email_id_3(String ca_email_id_3) {
		this.ca_email_id_3 = ca_email_id_3;
	}


	public BigDecimal getCa_mobile_no_3() {
		return ca_mobile_no_3;
	}


	public void setCa_mobile_no_3(BigDecimal ca_mobile_no_3) {
		this.ca_mobile_no_3 = ca_mobile_no_3;
	}


	public String getCa_customer_type_4() {
		return ca_customer_type_4;
	}


	public void setCa_customer_type_4(String ca_customer_type_4) {
		this.ca_customer_type_4 = ca_customer_type_4;
	}


	public String getCa_cif_id_4() {
		return ca_cif_id_4;
	}


	public void setCa_cif_id_4(String ca_cif_id_4) {
		this.ca_cif_id_4 = ca_cif_id_4;
	}


	public String getCa_primary_branch_4() {
		return ca_primary_branch_4;
	}


	public void setCa_primary_branch_4(String ca_primary_branch_4) {
		this.ca_primary_branch_4 = ca_primary_branch_4;
	}


	public String getCa_branch_name_4() {
		return ca_branch_name_4;
	}


	public void setCa_branch_name_4(String ca_branch_name_4) {
		this.ca_branch_name_4 = ca_branch_name_4;
	}


	public String getCa_salutation_4() {
		return ca_salutation_4;
	}


	public void setCa_salutation_4(String ca_salutation_4) {
		this.ca_salutation_4 = ca_salutation_4;
	}


	public String getCa_first_name_4() {
		return ca_first_name_4;
	}


	public void setCa_first_name_4(String ca_first_name_4) {
		this.ca_first_name_4 = ca_first_name_4;
	}


	public String getCa_middle_name_4() {
		return ca_middle_name_4;
	}


	public void setCa_middle_name_4(String ca_middle_name_4) {
		this.ca_middle_name_4 = ca_middle_name_4;
	}


	public String getCa_last_name_4() {
		return ca_last_name_4;
	}


	public void setCa_last_name_4(String ca_last_name_4) {
		this.ca_last_name_4 = ca_last_name_4;
	}


	public String getCa_full_name_4() {
		return ca_full_name_4;
	}


	public void setCa_full_name_4(String ca_full_name_4) {
		this.ca_full_name_4 = ca_full_name_4;
	}


	public String getCa_short_name_4() {
		return ca_short_name_4;
	}


	public void setCa_short_name_4(String ca_short_name_4) {
		this.ca_short_name_4 = ca_short_name_4;
	}


	public String getCa_gender_4() {
		return ca_gender_4;
	}


	public void setCa_gender_4(String ca_gender_4) {
		this.ca_gender_4 = ca_gender_4;
	}


	public String getCa_marital_status_4() {
		return ca_marital_status_4;
	}


	public void setCa_marital_status_4(String ca_marital_status_4) {
		this.ca_marital_status_4 = ca_marital_status_4;
	}


	public String getCa_occupation_4() {
		return ca_occupation_4;
	}


	public void setCa_occupation_4(String ca_occupation_4) {
		this.ca_occupation_4 = ca_occupation_4;
	}


	public Date getCa_date_of_birth_4() {
		return ca_date_of_birth_4;
	}


	public void setCa_date_of_birth_4(Date ca_date_of_birth_4) {
		this.ca_date_of_birth_4 = ca_date_of_birth_4;
	}


	public BigDecimal getCa_annual_income_4() {
		return ca_annual_income_4;
	}


	public void setCa_annual_income_4(BigDecimal ca_annual_income_4) {
		this.ca_annual_income_4 = ca_annual_income_4;
	}


	public BigDecimal getCa_monthly_income_4() {
		return ca_monthly_income_4;
	}


	public void setCa_monthly_income_4(BigDecimal ca_monthly_income_4) {
		this.ca_monthly_income_4 = ca_monthly_income_4;
	}


	public String getCa_loan_obligations_4() {
		return ca_loan_obligations_4;
	}


	public void setCa_loan_obligations_4(String ca_loan_obligations_4) {
		this.ca_loan_obligations_4 = ca_loan_obligations_4;
	}


	public String getCa_family_maintenance_4() {
		return ca_family_maintenance_4;
	}


	public void setCa_family_maintenance_4(String ca_family_maintenance_4) {
		this.ca_family_maintenance_4 = ca_family_maintenance_4;
	}


	public String getCa_address_type_4() {
		return ca_address_type_4;
	}


	public void setCa_address_type_4(String ca_address_type_4) {
		this.ca_address_type_4 = ca_address_type_4;
	}


	public String getCa_house_no_4() {
		return ca_house_no_4;
	}


	public void setCa_house_no_4(String ca_house_no_4) {
		this.ca_house_no_4 = ca_house_no_4;
	}


	public String getCa_street_no_4() {
		return ca_street_no_4;
	}


	public void setCa_street_no_4(String ca_street_no_4) {
		this.ca_street_no_4 = ca_street_no_4;
	}


	public String getCa_street_name_4() {
		return ca_street_name_4;
	}


	public void setCa_street_name_4(String ca_street_name_4) {
		this.ca_street_name_4 = ca_street_name_4;
	}


	public String getCa_country_4() {
		return ca_country_4;
	}


	public void setCa_country_4(String ca_country_4) {
		this.ca_country_4 = ca_country_4;
	}


	public String getCa_state_4() {
		return ca_state_4;
	}


	public void setCa_state_4(String ca_state_4) {
		this.ca_state_4 = ca_state_4;
	}


	public String getCa_city_4() {
		return ca_city_4;
	}


	public void setCa_city_4(String ca_city_4) {
		this.ca_city_4 = ca_city_4;
	}


	public String getCa_postal_code_4() {
		return ca_postal_code_4;
	}


	public void setCa_postal_code_4(String ca_postal_code_4) {
		this.ca_postal_code_4 = ca_postal_code_4;
	}


	public Date getCa_address_valid_from_4() {
		return ca_address_valid_from_4;
	}


	public void setCa_address_valid_from_4(Date ca_address_valid_from_4) {
		this.ca_address_valid_from_4 = ca_address_valid_from_4;
	}


	public String getCa_nationality_4() {
		return ca_nationality_4;
	}


	public void setCa_nationality_4(String ca_nationality_4) {
		this.ca_nationality_4 = ca_nationality_4;
	}


	public String getCa_country_of_birth_4() {
		return ca_country_of_birth_4;
	}


	public void setCa_country_of_birth_4(String ca_country_of_birth_4) {
		this.ca_country_of_birth_4 = ca_country_of_birth_4;
	}


	public String getCa_country_of_origin_4() {
		return ca_country_of_origin_4;
	}


	public void setCa_country_of_origin_4(String ca_country_of_origin_4) {
		this.ca_country_of_origin_4 = ca_country_of_origin_4;
	}


	public String getCa_email_id_4() {
		return ca_email_id_4;
	}


	public void setCa_email_id_4(String ca_email_id_4) {
		this.ca_email_id_4 = ca_email_id_4;
	}


	public BigDecimal getCa_mobile_no_4() {
		return ca_mobile_no_4;
	}


	public void setCa_mobile_no_4(BigDecimal ca_mobile_no_4) {
		this.ca_mobile_no_4 = ca_mobile_no_4;
	}


	public String getCa_customer_type_5() {
		return ca_customer_type_5;
	}


	public void setCa_customer_type_5(String ca_customer_type_5) {
		this.ca_customer_type_5 = ca_customer_type_5;
	}


	public String getCa_cif_id_5() {
		return ca_cif_id_5;
	}


	public void setCa_cif_id_5(String ca_cif_id_5) {
		this.ca_cif_id_5 = ca_cif_id_5;
	}


	public String getCa_primary_branch_5() {
		return ca_primary_branch_5;
	}


	public void setCa_primary_branch_5(String ca_primary_branch_5) {
		this.ca_primary_branch_5 = ca_primary_branch_5;
	}


	public String getCa_branch_name_5() {
		return ca_branch_name_5;
	}


	public void setCa_branch_name_5(String ca_branch_name_5) {
		this.ca_branch_name_5 = ca_branch_name_5;
	}


	public String getCa_salutation_5() {
		return ca_salutation_5;
	}


	public void setCa_salutation_5(String ca_salutation_5) {
		this.ca_salutation_5 = ca_salutation_5;
	}


	public String getCa_first_name_5() {
		return ca_first_name_5;
	}


	public void setCa_first_name_5(String ca_first_name_5) {
		this.ca_first_name_5 = ca_first_name_5;
	}


	public String getCa_middle_name_5() {
		return ca_middle_name_5;
	}


	public void setCa_middle_name_5(String ca_middle_name_5) {
		this.ca_middle_name_5 = ca_middle_name_5;
	}


	public String getCa_last_name_5() {
		return ca_last_name_5;
	}


	public void setCa_last_name_5(String ca_last_name_5) {
		this.ca_last_name_5 = ca_last_name_5;
	}


	public String getCa_full_name_5() {
		return ca_full_name_5;
	}


	public void setCa_full_name_5(String ca_full_name_5) {
		this.ca_full_name_5 = ca_full_name_5;
	}


	public String getCa_short_name_5() {
		return ca_short_name_5;
	}


	public void setCa_short_name_5(String ca_short_name_5) {
		this.ca_short_name_5 = ca_short_name_5;
	}


	public String getCa_gender_5() {
		return ca_gender_5;
	}


	public void setCa_gender_5(String ca_gender_5) {
		this.ca_gender_5 = ca_gender_5;
	}


	public String getCa_marital_status_5() {
		return ca_marital_status_5;
	}


	public void setCa_marital_status_5(String ca_marital_status_5) {
		this.ca_marital_status_5 = ca_marital_status_5;
	}


	public String getCa_occupation_5() {
		return ca_occupation_5;
	}


	public void setCa_occupation_5(String ca_occupation_5) {
		this.ca_occupation_5 = ca_occupation_5;
	}


	public Date getCa_date_of_birth_5() {
		return ca_date_of_birth_5;
	}


	public void setCa_date_of_birth_5(Date ca_date_of_birth_5) {
		this.ca_date_of_birth_5 = ca_date_of_birth_5;
	}


	public BigDecimal getCa_annual_income_5() {
		return ca_annual_income_5;
	}


	public void setCa_annual_income_5(BigDecimal ca_annual_income_5) {
		this.ca_annual_income_5 = ca_annual_income_5;
	}


	public BigDecimal getCa_monthly_income_5() {
		return ca_monthly_income_5;
	}


	public void setCa_monthly_income_5(BigDecimal ca_monthly_income_5) {
		this.ca_monthly_income_5 = ca_monthly_income_5;
	}


	public String getCa_loan_obligations_5() {
		return ca_loan_obligations_5;
	}


	public void setCa_loan_obligations_5(String ca_loan_obligations_5) {
		this.ca_loan_obligations_5 = ca_loan_obligations_5;
	}


	public String getCa_family_maintenance_5() {
		return ca_family_maintenance_5;
	}


	public void setCa_family_maintenance_5(String ca_family_maintenance_5) {
		this.ca_family_maintenance_5 = ca_family_maintenance_5;
	}


	public String getCa_address_type_5() {
		return ca_address_type_5;
	}


	public void setCa_address_type_5(String ca_address_type_5) {
		this.ca_address_type_5 = ca_address_type_5;
	}


	public String getCa_house_no_5() {
		return ca_house_no_5;
	}


	public void setCa_house_no_5(String ca_house_no_5) {
		this.ca_house_no_5 = ca_house_no_5;
	}


	public String getCa_street_no_5() {
		return ca_street_no_5;
	}


	public void setCa_street_no_5(String ca_street_no_5) {
		this.ca_street_no_5 = ca_street_no_5;
	}


	public String getCa_street_name_5() {
		return ca_street_name_5;
	}


	public void setCa_street_name_5(String ca_street_name_5) {
		this.ca_street_name_5 = ca_street_name_5;
	}


	public String getCa_country_5() {
		return ca_country_5;
	}


	public void setCa_country_5(String ca_country_5) {
		this.ca_country_5 = ca_country_5;
	}


	public String getCa_state_5() {
		return ca_state_5;
	}


	public void setCa_state_5(String ca_state_5) {
		this.ca_state_5 = ca_state_5;
	}


	public String getCa_city_5() {
		return ca_city_5;
	}


	public void setCa_city_5(String ca_city_5) {
		this.ca_city_5 = ca_city_5;
	}


	public String getCa_postal_code_5() {
		return ca_postal_code_5;
	}


	public void setCa_postal_code_5(String ca_postal_code_5) {
		this.ca_postal_code_5 = ca_postal_code_5;
	}


	public Date getCa_address_valid_from_5() {
		return ca_address_valid_from_5;
	}


	public void setCa_address_valid_from_5(Date ca_address_valid_from_5) {
		this.ca_address_valid_from_5 = ca_address_valid_from_5;
	}


	public String getCa_nationality_5() {
		return ca_nationality_5;
	}


	public void setCa_nationality_5(String ca_nationality_5) {
		this.ca_nationality_5 = ca_nationality_5;
	}


	public String getCa_country_of_birth_5() {
		return ca_country_of_birth_5;
	}


	public void setCa_country_of_birth_5(String ca_country_of_birth_5) {
		this.ca_country_of_birth_5 = ca_country_of_birth_5;
	}


	public String getCa_country_of_origin_5() {
		return ca_country_of_origin_5;
	}


	public void setCa_country_of_origin_5(String ca_country_of_origin_5) {
		this.ca_country_of_origin_5 = ca_country_of_origin_5;
	}


	public String getCa_email_id_5() {
		return ca_email_id_5;
	}


	public void setCa_email_id_5(String ca_email_id_5) {
		this.ca_email_id_5 = ca_email_id_5;
	}


	public BigDecimal getCa_mobile_no_5() {
		return ca_mobile_no_5;
	}


	public void setCa_mobile_no_5(BigDecimal ca_mobile_no_5) {
		this.ca_mobile_no_5 = ca_mobile_no_5;
	}


	public String getCa_customer_type_6() {
		return ca_customer_type_6;
	}


	public void setCa_customer_type_6(String ca_customer_type_6) {
		this.ca_customer_type_6 = ca_customer_type_6;
	}


	public String getCa_cif_id_6() {
		return ca_cif_id_6;
	}


	public void setCa_cif_id_6(String ca_cif_id_6) {
		this.ca_cif_id_6 = ca_cif_id_6;
	}


	public String getCa_primary_branch_6() {
		return ca_primary_branch_6;
	}


	public void setCa_primary_branch_6(String ca_primary_branch_6) {
		this.ca_primary_branch_6 = ca_primary_branch_6;
	}


	public String getCa_branch_name_6() {
		return ca_branch_name_6;
	}


	public void setCa_branch_name_6(String ca_branch_name_6) {
		this.ca_branch_name_6 = ca_branch_name_6;
	}


	public String getCa_salutation_6() {
		return ca_salutation_6;
	}


	public void setCa_salutation_6(String ca_salutation_6) {
		this.ca_salutation_6 = ca_salutation_6;
	}


	public String getCa_first_name_6() {
		return ca_first_name_6;
	}


	public void setCa_first_name_6(String ca_first_name_6) {
		this.ca_first_name_6 = ca_first_name_6;
	}


	public String getCa_middle_name_6() {
		return ca_middle_name_6;
	}


	public void setCa_middle_name_6(String ca_middle_name_6) {
		this.ca_middle_name_6 = ca_middle_name_6;
	}


	public String getCa_last_name_6() {
		return ca_last_name_6;
	}


	public void setCa_last_name_6(String ca_last_name_6) {
		this.ca_last_name_6 = ca_last_name_6;
	}


	public String getCa_full_name_6() {
		return ca_full_name_6;
	}


	public void setCa_full_name_6(String ca_full_name_6) {
		this.ca_full_name_6 = ca_full_name_6;
	}


	public String getCa_short_name_6() {
		return ca_short_name_6;
	}


	public void setCa_short_name_6(String ca_short_name_6) {
		this.ca_short_name_6 = ca_short_name_6;
	}


	public String getCa_gender_6() {
		return ca_gender_6;
	}


	public void setCa_gender_6(String ca_gender_6) {
		this.ca_gender_6 = ca_gender_6;
	}


	public String getCa_marital_status_6() {
		return ca_marital_status_6;
	}


	public void setCa_marital_status_6(String ca_marital_status_6) {
		this.ca_marital_status_6 = ca_marital_status_6;
	}


	public String getCa_occupation_6() {
		return ca_occupation_6;
	}


	public void setCa_occupation_6(String ca_occupation_6) {
		this.ca_occupation_6 = ca_occupation_6;
	}


	public Date getCa_date_of_birth_6() {
		return ca_date_of_birth_6;
	}


	public void setCa_date_of_birth_6(Date ca_date_of_birth_6) {
		this.ca_date_of_birth_6 = ca_date_of_birth_6;
	}


	public BigDecimal getCa_annual_income_6() {
		return ca_annual_income_6;
	}


	public void setCa_annual_income_6(BigDecimal ca_annual_income_6) {
		this.ca_annual_income_6 = ca_annual_income_6;
	}


	public BigDecimal getCa_monthly_income_6() {
		return ca_monthly_income_6;
	}


	public void setCa_monthly_income_6(BigDecimal ca_monthly_income_6) {
		this.ca_monthly_income_6 = ca_monthly_income_6;
	}


	public String getCa_loan_obligations_6() {
		return ca_loan_obligations_6;
	}


	public void setCa_loan_obligations_6(String ca_loan_obligations_6) {
		this.ca_loan_obligations_6 = ca_loan_obligations_6;
	}


	public String getCa_family_maintenance_6() {
		return ca_family_maintenance_6;
	}


	public void setCa_family_maintenance_6(String ca_family_maintenance_6) {
		this.ca_family_maintenance_6 = ca_family_maintenance_6;
	}


	public String getCa_address_type_6() {
		return ca_address_type_6;
	}


	public void setCa_address_type_6(String ca_address_type_6) {
		this.ca_address_type_6 = ca_address_type_6;
	}


	public String getCa_house_no_6() {
		return ca_house_no_6;
	}


	public void setCa_house_no_6(String ca_house_no_6) {
		this.ca_house_no_6 = ca_house_no_6;
	}


	public String getCa_street_no_6() {
		return ca_street_no_6;
	}


	public void setCa_street_no_6(String ca_street_no_6) {
		this.ca_street_no_6 = ca_street_no_6;
	}


	public String getCa_street_name_6() {
		return ca_street_name_6;
	}


	public void setCa_street_name_6(String ca_street_name_6) {
		this.ca_street_name_6 = ca_street_name_6;
	}


	public String getCa_country_6() {
		return ca_country_6;
	}


	public void setCa_country_6(String ca_country_6) {
		this.ca_country_6 = ca_country_6;
	}


	public String getCa_state_6() {
		return ca_state_6;
	}


	public void setCa_state_6(String ca_state_6) {
		this.ca_state_6 = ca_state_6;
	}


	public String getCa_city_6() {
		return ca_city_6;
	}


	public void setCa_city_6(String ca_city_6) {
		this.ca_city_6 = ca_city_6;
	}


	public String getCa_postal_code_6() {
		return ca_postal_code_6;
	}


	public void setCa_postal_code_6(String ca_postal_code_6) {
		this.ca_postal_code_6 = ca_postal_code_6;
	}


	public Date getCa_address_valid_from_6() {
		return ca_address_valid_from_6;
	}


	public void setCa_address_valid_from_6(Date ca_address_valid_from_6) {
		this.ca_address_valid_from_6 = ca_address_valid_from_6;
	}


	public String getCa_nationality_6() {
		return ca_nationality_6;
	}


	public void setCa_nationality_6(String ca_nationality_6) {
		this.ca_nationality_6 = ca_nationality_6;
	}


	public String getCa_country_of_birth_6() {
		return ca_country_of_birth_6;
	}


	public void setCa_country_of_birth_6(String ca_country_of_birth_6) {
		this.ca_country_of_birth_6 = ca_country_of_birth_6;
	}


	public String getCa_country_of_origin_6() {
		return ca_country_of_origin_6;
	}


	public void setCa_country_of_origin_6(String ca_country_of_origin_6) {
		this.ca_country_of_origin_6 = ca_country_of_origin_6;
	}


	public String getCa_email_id_6() {
		return ca_email_id_6;
	}


	public void setCa_email_id_6(String ca_email_id_6) {
		this.ca_email_id_6 = ca_email_id_6;
	}


	public BigDecimal getCa_mobile_no_6() {
		return ca_mobile_no_6;
	}


	public void setCa_mobile_no_6(BigDecimal ca_mobile_no_6) {
		this.ca_mobile_no_6 = ca_mobile_no_6;
	}


	public String getCa_customer_type_7() {
		return ca_customer_type_7;
	}


	public void setCa_customer_type_7(String ca_customer_type_7) {
		this.ca_customer_type_7 = ca_customer_type_7;
	}


	public String getCa_cif_id_7() {
		return ca_cif_id_7;
	}


	public void setCa_cif_id_7(String ca_cif_id_7) {
		this.ca_cif_id_7 = ca_cif_id_7;
	}


	public String getCa_primary_branch_7() {
		return ca_primary_branch_7;
	}


	public void setCa_primary_branch_7(String ca_primary_branch_7) {
		this.ca_primary_branch_7 = ca_primary_branch_7;
	}


	public String getCa_branch_name_7() {
		return ca_branch_name_7;
	}


	public void setCa_branch_name_7(String ca_branch_name_7) {
		this.ca_branch_name_7 = ca_branch_name_7;
	}


	public String getCa_salutation_7() {
		return ca_salutation_7;
	}


	public void setCa_salutation_7(String ca_salutation_7) {
		this.ca_salutation_7 = ca_salutation_7;
	}


	public String getCa_first_name_7() {
		return ca_first_name_7;
	}


	public void setCa_first_name_7(String ca_first_name_7) {
		this.ca_first_name_7 = ca_first_name_7;
	}


	public String getCa_middle_name_7() {
		return ca_middle_name_7;
	}


	public void setCa_middle_name_7(String ca_middle_name_7) {
		this.ca_middle_name_7 = ca_middle_name_7;
	}


	public String getCa_last_name_7() {
		return ca_last_name_7;
	}


	public void setCa_last_name_7(String ca_last_name_7) {
		this.ca_last_name_7 = ca_last_name_7;
	}


	public String getCa_full_name_7() {
		return ca_full_name_7;
	}


	public void setCa_full_name_7(String ca_full_name_7) {
		this.ca_full_name_7 = ca_full_name_7;
	}


	public String getCa_short_name_7() {
		return ca_short_name_7;
	}


	public void setCa_short_name_7(String ca_short_name_7) {
		this.ca_short_name_7 = ca_short_name_7;
	}


	public String getCa_gender_7() {
		return ca_gender_7;
	}


	public void setCa_gender_7(String ca_gender_7) {
		this.ca_gender_7 = ca_gender_7;
	}


	public String getCa_marital_status_7() {
		return ca_marital_status_7;
	}


	public void setCa_marital_status_7(String ca_marital_status_7) {
		this.ca_marital_status_7 = ca_marital_status_7;
	}


	public String getCa_occupation_7() {
		return ca_occupation_7;
	}


	public void setCa_occupation_7(String ca_occupation_7) {
		this.ca_occupation_7 = ca_occupation_7;
	}


	public Date getCa_date_of_birth_7() {
		return ca_date_of_birth_7;
	}


	public void setCa_date_of_birth_7(Date ca_date_of_birth_7) {
		this.ca_date_of_birth_7 = ca_date_of_birth_7;
	}


	public BigDecimal getCa_annual_income_7() {
		return ca_annual_income_7;
	}


	public void setCa_annual_income_7(BigDecimal ca_annual_income_7) {
		this.ca_annual_income_7 = ca_annual_income_7;
	}


	public BigDecimal getCa_monthly_income_7() {
		return ca_monthly_income_7;
	}


	public void setCa_monthly_income_7(BigDecimal ca_monthly_income_7) {
		this.ca_monthly_income_7 = ca_monthly_income_7;
	}


	public String getCa_loan_obligations_7() {
		return ca_loan_obligations_7;
	}


	public void setCa_loan_obligations_7(String ca_loan_obligations_7) {
		this.ca_loan_obligations_7 = ca_loan_obligations_7;
	}


	public String getCa_family_maintenance_7() {
		return ca_family_maintenance_7;
	}


	public void setCa_family_maintenance_7(String ca_family_maintenance_7) {
		this.ca_family_maintenance_7 = ca_family_maintenance_7;
	}


	public String getCa_address_type_7() {
		return ca_address_type_7;
	}


	public void setCa_address_type_7(String ca_address_type_7) {
		this.ca_address_type_7 = ca_address_type_7;
	}


	public String getCa_house_no_7() {
		return ca_house_no_7;
	}


	public void setCa_house_no_7(String ca_house_no_7) {
		this.ca_house_no_7 = ca_house_no_7;
	}


	public String getCa_street_no_7() {
		return ca_street_no_7;
	}


	public void setCa_street_no_7(String ca_street_no_7) {
		this.ca_street_no_7 = ca_street_no_7;
	}


	public String getCa_street_name_7() {
		return ca_street_name_7;
	}


	public void setCa_street_name_7(String ca_street_name_7) {
		this.ca_street_name_7 = ca_street_name_7;
	}


	public String getCa_country_7() {
		return ca_country_7;
	}


	public void setCa_country_7(String ca_country_7) {
		this.ca_country_7 = ca_country_7;
	}


	public String getCa_state_7() {
		return ca_state_7;
	}


	public void setCa_state_7(String ca_state_7) {
		this.ca_state_7 = ca_state_7;
	}


	public String getCa_city_7() {
		return ca_city_7;
	}


	public void setCa_city_7(String ca_city_7) {
		this.ca_city_7 = ca_city_7;
	}


	public String getCa_postal_code_7() {
		return ca_postal_code_7;
	}


	public void setCa_postal_code_7(String ca_postal_code_7) {
		this.ca_postal_code_7 = ca_postal_code_7;
	}


	public Date getCa_address_valid_from_7() {
		return ca_address_valid_from_7;
	}


	public void setCa_address_valid_from_7(Date ca_address_valid_from_7) {
		this.ca_address_valid_from_7 = ca_address_valid_from_7;
	}


	public String getCa_nationality_7() {
		return ca_nationality_7;
	}


	public void setCa_nationality_7(String ca_nationality_7) {
		this.ca_nationality_7 = ca_nationality_7;
	}


	public String getCa_country_of_birth_7() {
		return ca_country_of_birth_7;
	}


	public void setCa_country_of_birth_7(String ca_country_of_birth_7) {
		this.ca_country_of_birth_7 = ca_country_of_birth_7;
	}


	public String getCa_country_of_origin_7() {
		return ca_country_of_origin_7;
	}


	public void setCa_country_of_origin_7(String ca_country_of_origin_7) {
		this.ca_country_of_origin_7 = ca_country_of_origin_7;
	}


	public String getCa_email_id_7() {
		return ca_email_id_7;
	}


	public void setCa_email_id_7(String ca_email_id_7) {
		this.ca_email_id_7 = ca_email_id_7;
	}


	public BigDecimal getCa_mobile_no_7() {
		return ca_mobile_no_7;
	}


	public void setCa_mobile_no_7(BigDecimal ca_mobile_no_7) {
		this.ca_mobile_no_7 = ca_mobile_no_7;
	}


	public String getCa_customer_type_8() {
		return ca_customer_type_8;
	}


	public void setCa_customer_type_8(String ca_customer_type_8) {
		this.ca_customer_type_8 = ca_customer_type_8;
	}


	public String getCa_cif_id_8() {
		return ca_cif_id_8;
	}


	public void setCa_cif_id_8(String ca_cif_id_8) {
		this.ca_cif_id_8 = ca_cif_id_8;
	}


	public String getCa_primary_branch_8() {
		return ca_primary_branch_8;
	}


	public void setCa_primary_branch_8(String ca_primary_branch_8) {
		this.ca_primary_branch_8 = ca_primary_branch_8;
	}


	public String getCa_branch_name_8() {
		return ca_branch_name_8;
	}


	public void setCa_branch_name_8(String ca_branch_name_8) {
		this.ca_branch_name_8 = ca_branch_name_8;
	}


	public String getCa_salutation_8() {
		return ca_salutation_8;
	}


	public void setCa_salutation_8(String ca_salutation_8) {
		this.ca_salutation_8 = ca_salutation_8;
	}


	public String getCa_first_name_8() {
		return ca_first_name_8;
	}


	public void setCa_first_name_8(String ca_first_name_8) {
		this.ca_first_name_8 = ca_first_name_8;
	}


	public String getCa_middle_name_8() {
		return ca_middle_name_8;
	}


	public void setCa_middle_name_8(String ca_middle_name_8) {
		this.ca_middle_name_8 = ca_middle_name_8;
	}


	public String getCa_last_name_8() {
		return ca_last_name_8;
	}


	public void setCa_last_name_8(String ca_last_name_8) {
		this.ca_last_name_8 = ca_last_name_8;
	}


	public String getCa_full_name_8() {
		return ca_full_name_8;
	}


	public void setCa_full_name_8(String ca_full_name_8) {
		this.ca_full_name_8 = ca_full_name_8;
	}


	public String getCa_short_name_8() {
		return ca_short_name_8;
	}


	public void setCa_short_name_8(String ca_short_name_8) {
		this.ca_short_name_8 = ca_short_name_8;
	}


	public String getCa_gender_8() {
		return ca_gender_8;
	}


	public void setCa_gender_8(String ca_gender_8) {
		this.ca_gender_8 = ca_gender_8;
	}


	public String getCa_marital_status_8() {
		return ca_marital_status_8;
	}


	public void setCa_marital_status_8(String ca_marital_status_8) {
		this.ca_marital_status_8 = ca_marital_status_8;
	}


	public String getCa_occupation_8() {
		return ca_occupation_8;
	}


	public void setCa_occupation_8(String ca_occupation_8) {
		this.ca_occupation_8 = ca_occupation_8;
	}


	public Date getCa_date_of_birth_8() {
		return ca_date_of_birth_8;
	}


	public void setCa_date_of_birth_8(Date ca_date_of_birth_8) {
		this.ca_date_of_birth_8 = ca_date_of_birth_8;
	}


	public BigDecimal getCa_annual_income_8() {
		return ca_annual_income_8;
	}


	public void setCa_annual_income_8(BigDecimal ca_annual_income_8) {
		this.ca_annual_income_8 = ca_annual_income_8;
	}


	public BigDecimal getCa_monthly_income_8() {
		return ca_monthly_income_8;
	}


	public void setCa_monthly_income_8(BigDecimal ca_monthly_income_8) {
		this.ca_monthly_income_8 = ca_monthly_income_8;
	}


	public String getCa_loan_obligations_8() {
		return ca_loan_obligations_8;
	}


	public void setCa_loan_obligations_8(String ca_loan_obligations_8) {
		this.ca_loan_obligations_8 = ca_loan_obligations_8;
	}


	public String getCa_family_maintenance_8() {
		return ca_family_maintenance_8;
	}


	public void setCa_family_maintenance_8(String ca_family_maintenance_8) {
		this.ca_family_maintenance_8 = ca_family_maintenance_8;
	}


	public String getCa_address_type_8() {
		return ca_address_type_8;
	}


	public void setCa_address_type_8(String ca_address_type_8) {
		this.ca_address_type_8 = ca_address_type_8;
	}


	public String getCa_house_no_8() {
		return ca_house_no_8;
	}


	public void setCa_house_no_8(String ca_house_no_8) {
		this.ca_house_no_8 = ca_house_no_8;
	}


	public String getCa_street_no_8() {
		return ca_street_no_8;
	}


	public void setCa_street_no_8(String ca_street_no_8) {
		this.ca_street_no_8 = ca_street_no_8;
	}


	public String getCa_street_name_8() {
		return ca_street_name_8;
	}


	public void setCa_street_name_8(String ca_street_name_8) {
		this.ca_street_name_8 = ca_street_name_8;
	}


	public String getCa_country_8() {
		return ca_country_8;
	}


	public void setCa_country_8(String ca_country_8) {
		this.ca_country_8 = ca_country_8;
	}


	public String getCa_state_8() {
		return ca_state_8;
	}


	public void setCa_state_8(String ca_state_8) {
		this.ca_state_8 = ca_state_8;
	}


	public String getCa_city_8() {
		return ca_city_8;
	}


	public void setCa_city_8(String ca_city_8) {
		this.ca_city_8 = ca_city_8;
	}


	public String getCa_postal_code_8() {
		return ca_postal_code_8;
	}


	public void setCa_postal_code_8(String ca_postal_code_8) {
		this.ca_postal_code_8 = ca_postal_code_8;
	}


	public Date getCa_address_valid_from_8() {
		return ca_address_valid_from_8;
	}


	public void setCa_address_valid_from_8(Date ca_address_valid_from_8) {
		this.ca_address_valid_from_8 = ca_address_valid_from_8;
	}


	public String getCa_nationality_8() {
		return ca_nationality_8;
	}


	public void setCa_nationality_8(String ca_nationality_8) {
		this.ca_nationality_8 = ca_nationality_8;
	}


	public String getCa_country_of_birth_8() {
		return ca_country_of_birth_8;
	}


	public void setCa_country_of_birth_8(String ca_country_of_birth_8) {
		this.ca_country_of_birth_8 = ca_country_of_birth_8;
	}


	public String getCa_country_of_origin_8() {
		return ca_country_of_origin_8;
	}


	public void setCa_country_of_origin_8(String ca_country_of_origin_8) {
		this.ca_country_of_origin_8 = ca_country_of_origin_8;
	}


	public String getCa_email_id_8() {
		return ca_email_id_8;
	}


	public void setCa_email_id_8(String ca_email_id_8) {
		this.ca_email_id_8 = ca_email_id_8;
	}


	public BigDecimal getCa_mobile_no_8() {
		return ca_mobile_no_8;
	}


	public void setCa_mobile_no_8(BigDecimal ca_mobile_no_8) {
		this.ca_mobile_no_8 = ca_mobile_no_8;
	}


	public String getCa_customer_type_9() {
		return ca_customer_type_9;
	}


	public void setCa_customer_type_9(String ca_customer_type_9) {
		this.ca_customer_type_9 = ca_customer_type_9;
	}


	public String getCa_cif_id_9() {
		return ca_cif_id_9;
	}


	public void setCa_cif_id_9(String ca_cif_id_9) {
		this.ca_cif_id_9 = ca_cif_id_9;
	}


	public String getCa_primary_branch_9() {
		return ca_primary_branch_9;
	}


	public void setCa_primary_branch_9(String ca_primary_branch_9) {
		this.ca_primary_branch_9 = ca_primary_branch_9;
	}


	public String getCa_branch_name_9() {
		return ca_branch_name_9;
	}


	public void setCa_branch_name_9(String ca_branch_name_9) {
		this.ca_branch_name_9 = ca_branch_name_9;
	}


	public String getCa_salutation_9() {
		return ca_salutation_9;
	}


	public void setCa_salutation_9(String ca_salutation_9) {
		this.ca_salutation_9 = ca_salutation_9;
	}


	public String getCa_first_name_9() {
		return ca_first_name_9;
	}


	public void setCa_first_name_9(String ca_first_name_9) {
		this.ca_first_name_9 = ca_first_name_9;
	}


	public String getCa_middle_name_9() {
		return ca_middle_name_9;
	}


	public void setCa_middle_name_9(String ca_middle_name_9) {
		this.ca_middle_name_9 = ca_middle_name_9;
	}


	public String getCa_last_name_9() {
		return ca_last_name_9;
	}


	public void setCa_last_name_9(String ca_last_name_9) {
		this.ca_last_name_9 = ca_last_name_9;
	}


	public String getCa_full_name_9() {
		return ca_full_name_9;
	}


	public void setCa_full_name_9(String ca_full_name_9) {
		this.ca_full_name_9 = ca_full_name_9;
	}


	public String getCa_short_name_9() {
		return ca_short_name_9;
	}


	public void setCa_short_name_9(String ca_short_name_9) {
		this.ca_short_name_9 = ca_short_name_9;
	}


	public String getCa_gender_9() {
		return ca_gender_9;
	}


	public void setCa_gender_9(String ca_gender_9) {
		this.ca_gender_9 = ca_gender_9;
	}


	public String getCa_marital_status_9() {
		return ca_marital_status_9;
	}


	public void setCa_marital_status_9(String ca_marital_status_9) {
		this.ca_marital_status_9 = ca_marital_status_9;
	}


	public String getCa_occupation_9() {
		return ca_occupation_9;
	}


	public void setCa_occupation_9(String ca_occupation_9) {
		this.ca_occupation_9 = ca_occupation_9;
	}


	public Date getCa_date_of_birth_9() {
		return ca_date_of_birth_9;
	}


	public void setCa_date_of_birth_9(Date ca_date_of_birth_9) {
		this.ca_date_of_birth_9 = ca_date_of_birth_9;
	}


	public BigDecimal getCa_annual_income_9() {
		return ca_annual_income_9;
	}


	public void setCa_annual_income_9(BigDecimal ca_annual_income_9) {
		this.ca_annual_income_9 = ca_annual_income_9;
	}


	public BigDecimal getCa_monthly_income_9() {
		return ca_monthly_income_9;
	}


	public void setCa_monthly_income_9(BigDecimal ca_monthly_income_9) {
		this.ca_monthly_income_9 = ca_monthly_income_9;
	}


	public String getCa_loan_obligations_9() {
		return ca_loan_obligations_9;
	}


	public void setCa_loan_obligations_9(String ca_loan_obligations_9) {
		this.ca_loan_obligations_9 = ca_loan_obligations_9;
	}


	public String getCa_family_maintenance_9() {
		return ca_family_maintenance_9;
	}


	public void setCa_family_maintenance_9(String ca_family_maintenance_9) {
		this.ca_family_maintenance_9 = ca_family_maintenance_9;
	}


	public String getCa_address_type_9() {
		return ca_address_type_9;
	}


	public void setCa_address_type_9(String ca_address_type_9) {
		this.ca_address_type_9 = ca_address_type_9;
	}


	public String getCa_house_no_9() {
		return ca_house_no_9;
	}


	public void setCa_house_no_9(String ca_house_no_9) {
		this.ca_house_no_9 = ca_house_no_9;
	}


	public String getCa_street_no_9() {
		return ca_street_no_9;
	}


	public void setCa_street_no_9(String ca_street_no_9) {
		this.ca_street_no_9 = ca_street_no_9;
	}


	public String getCa_street_name_9() {
		return ca_street_name_9;
	}


	public void setCa_street_name_9(String ca_street_name_9) {
		this.ca_street_name_9 = ca_street_name_9;
	}


	public String getCa_country_9() {
		return ca_country_9;
	}


	public void setCa_country_9(String ca_country_9) {
		this.ca_country_9 = ca_country_9;
	}


	public String getCa_state_9() {
		return ca_state_9;
	}


	public void setCa_state_9(String ca_state_9) {
		this.ca_state_9 = ca_state_9;
	}


	public String getCa_city_9() {
		return ca_city_9;
	}


	public void setCa_city_9(String ca_city_9) {
		this.ca_city_9 = ca_city_9;
	}


	public String getCa_postal_code_9() {
		return ca_postal_code_9;
	}


	public void setCa_postal_code_9(String ca_postal_code_9) {
		this.ca_postal_code_9 = ca_postal_code_9;
	}


	public Date getCa_address_valid_from_9() {
		return ca_address_valid_from_9;
	}


	public void setCa_address_valid_from_9(Date ca_address_valid_from_9) {
		this.ca_address_valid_from_9 = ca_address_valid_from_9;
	}


	public String getCa_nationality_9() {
		return ca_nationality_9;
	}


	public void setCa_nationality_9(String ca_nationality_9) {
		this.ca_nationality_9 = ca_nationality_9;
	}


	public String getCa_country_of_birth_9() {
		return ca_country_of_birth_9;
	}


	public void setCa_country_of_birth_9(String ca_country_of_birth_9) {
		this.ca_country_of_birth_9 = ca_country_of_birth_9;
	}


	public String getCa_country_of_origin_9() {
		return ca_country_of_origin_9;
	}


	public void setCa_country_of_origin_9(String ca_country_of_origin_9) {
		this.ca_country_of_origin_9 = ca_country_of_origin_9;
	}


	public String getCa_email_id_9() {
		return ca_email_id_9;
	}


	public void setCa_email_id_9(String ca_email_id_9) {
		this.ca_email_id_9 = ca_email_id_9;
	}


	public BigDecimal getCa_mobile_no_9() {
		return ca_mobile_no_9;
	}


	public void setCa_mobile_no_9(BigDecimal ca_mobile_no_9) {
		this.ca_mobile_no_9 = ca_mobile_no_9;
	}


	public String getCa_customer_type_10() {
		return ca_customer_type_10;
	}


	public void setCa_customer_type_10(String ca_customer_type_10) {
		this.ca_customer_type_10 = ca_customer_type_10;
	}


	public String getCa_cif_id_10() {
		return ca_cif_id_10;
	}


	public void setCa_cif_id_10(String ca_cif_id_10) {
		this.ca_cif_id_10 = ca_cif_id_10;
	}


	public String getCa_primary_branch_10() {
		return ca_primary_branch_10;
	}


	public void setCa_primary_branch_10(String ca_primary_branch_10) {
		this.ca_primary_branch_10 = ca_primary_branch_10;
	}


	public String getCa_branch_name_10() {
		return ca_branch_name_10;
	}


	public void setCa_branch_name_10(String ca_branch_name_10) {
		this.ca_branch_name_10 = ca_branch_name_10;
	}


	public String getCa_salutation_10() {
		return ca_salutation_10;
	}


	public void setCa_salutation_10(String ca_salutation_10) {
		this.ca_salutation_10 = ca_salutation_10;
	}


	public String getCa_first_name_10() {
		return ca_first_name_10;
	}


	public void setCa_first_name_10(String ca_first_name_10) {
		this.ca_first_name_10 = ca_first_name_10;
	}


	public String getCa_middle_name_10() {
		return ca_middle_name_10;
	}


	public void setCa_middle_name_10(String ca_middle_name_10) {
		this.ca_middle_name_10 = ca_middle_name_10;
	}


	public String getCa_last_name_10() {
		return ca_last_name_10;
	}


	public void setCa_last_name_10(String ca_last_name_10) {
		this.ca_last_name_10 = ca_last_name_10;
	}


	public String getCa_full_name_10() {
		return ca_full_name_10;
	}


	public void setCa_full_name_10(String ca_full_name_10) {
		this.ca_full_name_10 = ca_full_name_10;
	}


	public String getCa_short_name_10() {
		return ca_short_name_10;
	}


	public void setCa_short_name_10(String ca_short_name_10) {
		this.ca_short_name_10 = ca_short_name_10;
	}


	public String getCa_gender_10() {
		return ca_gender_10;
	}


	public void setCa_gender_10(String ca_gender_10) {
		this.ca_gender_10 = ca_gender_10;
	}


	public String getCa_marital_status_10() {
		return ca_marital_status_10;
	}


	public void setCa_marital_status_10(String ca_marital_status_10) {
		this.ca_marital_status_10 = ca_marital_status_10;
	}


	public String getCa_occupation_10() {
		return ca_occupation_10;
	}


	public void setCa_occupation_10(String ca_occupation_10) {
		this.ca_occupation_10 = ca_occupation_10;
	}


	public Date getCa_date_of_birth_10() {
		return ca_date_of_birth_10;
	}


	public void setCa_date_of_birth_10(Date ca_date_of_birth_10) {
		this.ca_date_of_birth_10 = ca_date_of_birth_10;
	}


	public BigDecimal getCa_annual_income_10() {
		return ca_annual_income_10;
	}


	public void setCa_annual_income_10(BigDecimal ca_annual_income_10) {
		this.ca_annual_income_10 = ca_annual_income_10;
	}


	public BigDecimal getCa_monthly_income_10() {
		return ca_monthly_income_10;
	}


	public void setCa_monthly_income_10(BigDecimal ca_monthly_income_10) {
		this.ca_monthly_income_10 = ca_monthly_income_10;
	}


	public String getCa_loan_obligations_10() {
		return ca_loan_obligations_10;
	}


	public void setCa_loan_obligations_10(String ca_loan_obligations_10) {
		this.ca_loan_obligations_10 = ca_loan_obligations_10;
	}


	public String getCa_family_maintenance_10() {
		return ca_family_maintenance_10;
	}


	public void setCa_family_maintenance_10(String ca_family_maintenance_10) {
		this.ca_family_maintenance_10 = ca_family_maintenance_10;
	}


	public String getCa_address_type_10() {
		return ca_address_type_10;
	}


	public void setCa_address_type_10(String ca_address_type_10) {
		this.ca_address_type_10 = ca_address_type_10;
	}


	public String getCa_house_no_10() {
		return ca_house_no_10;
	}


	public void setCa_house_no_10(String ca_house_no_10) {
		this.ca_house_no_10 = ca_house_no_10;
	}


	public String getCa_street_no_10() {
		return ca_street_no_10;
	}


	public void setCa_street_no_10(String ca_street_no_10) {
		this.ca_street_no_10 = ca_street_no_10;
	}


	public String getCa_street_name_10() {
		return ca_street_name_10;
	}


	public void setCa_street_name_10(String ca_street_name_10) {
		this.ca_street_name_10 = ca_street_name_10;
	}


	public String getCa_country_10() {
		return ca_country_10;
	}


	public void setCa_country_10(String ca_country_10) {
		this.ca_country_10 = ca_country_10;
	}


	public String getCa_state_10() {
		return ca_state_10;
	}


	public void setCa_state_10(String ca_state_10) {
		this.ca_state_10 = ca_state_10;
	}


	public String getCa_city_10() {
		return ca_city_10;
	}


	public void setCa_city_10(String ca_city_10) {
		this.ca_city_10 = ca_city_10;
	}


	public String getCa_postal_code_10() {
		return ca_postal_code_10;
	}


	public void setCa_postal_code_10(String ca_postal_code_10) {
		this.ca_postal_code_10 = ca_postal_code_10;
	}


	public Date getCa_address_valid_from_10() {
		return ca_address_valid_from_10;
	}


	public void setCa_address_valid_from_10(Date ca_address_valid_from_10) {
		this.ca_address_valid_from_10 = ca_address_valid_from_10;
	}


	public String getCa_nationality_10() {
		return ca_nationality_10;
	}


	public void setCa_nationality_10(String ca_nationality_10) {
		this.ca_nationality_10 = ca_nationality_10;
	}


	public String getCa_country_of_birth_10() {
		return ca_country_of_birth_10;
	}


	public void setCa_country_of_birth_10(String ca_country_of_birth_10) {
		this.ca_country_of_birth_10 = ca_country_of_birth_10;
	}


	public String getCa_country_of_origin_10() {
		return ca_country_of_origin_10;
	}


	public void setCa_country_of_origin_10(String ca_country_of_origin_10) {
		this.ca_country_of_origin_10 = ca_country_of_origin_10;
	}


	public String getCa_email_id_10() {
		return ca_email_id_10;
	}


	public void setCa_email_id_10(String ca_email_id_10) {
		this.ca_email_id_10 = ca_email_id_10;
	}


	public BigDecimal getCa_mobile_no_10() {
		return ca_mobile_no_10;
	}


	public void setCa_mobile_no_10(BigDecimal ca_mobile_no_10) {
		this.ca_mobile_no_10 = ca_mobile_no_10;
	}


	public Date getKyc_date() {
		return kyc_date;
	}


	public void setKyc_date(Date kyc_date) {
		this.kyc_date = kyc_date;
	}


	public Date getKyc_review_date() {
		return kyc_review_date;
	}


	public void setKyc_review_date(Date kyc_review_date) {
		this.kyc_review_date = kyc_review_date;
	}


	public String getDoc_verify_flg() {
		return doc_verify_flg;
	}


	public void setDoc_verify_flg(String doc_verify_flg) {
		this.doc_verify_flg = doc_verify_flg;
	}


	public String getComp_verify_user() {
		return comp_verify_user;
	}


	public void setComp_verify_user(String comp_verify_user) {
		this.comp_verify_user = comp_verify_user;
	}


	public Date getComp_verify_date() {
		return comp_verify_date;
	}

 
	public void setComp_verify_date(Date comp_verify_date) {
		this.comp_verify_date = comp_verify_date;
	}


	public String getCa_glshdesc() {
		return ca_glshdesc;
	}


	public void setCa_glshdesc(String ca_glshdesc) {
		this.ca_glshdesc = ca_glshdesc;
	}

	public CustomerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
}
