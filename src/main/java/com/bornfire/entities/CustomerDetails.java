package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BACP_CUS_PROFILE")
public class CustomerDetails {

	private String ca_customer_type;
	private String ca_saluation;
	private String ca_first_name;
	private String mid_name;
	private String ca_last_name;
	private String ca_preferred_name;
	private String ca_occupation1;
	private String ca_gender;
	private String ca_martial_staus;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ca_date_of_birth;
	private String ca_address_type;
	private String ca_house_no;
	private String ca_street_no;
	private String ca_street_name;
	private String ca_country;
	private String ca_state;
	private String ca_city;
	private String ca_postal_code;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date ca_address_validation_form;
	private String ca_nationality;
	private String ca_country_of_birth;
	private String ca_email_id;
	private String ca_mobile_number;
	private String ca_phone_number;
	private String ca_occupation2;
	private String ca_non_resident;
	private String ca_staff_indicator;
	private String ca_trdfin;
	private String ca_minor_indicator;
	private String ca_guardian_name;
	private String ca_schemetype;
	private String ca_scheme_code;
	private String ca_currency;
	private String ca_glcode;
	private String ca_solid;
	private String ca_idenditification_number;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date ca_issue_date;
	private String ca_passport_number;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date ca_expiry_date;
	private String ca_addrtype_nri;
	private String ca_relname_nri;
	private String ca_relationship_nri;
	private String ca_locaddrnri;
	private String ca_ctry_nri;
	private String ca_nri_state;
	private String ca_cty_nri;
	private String ca_code_nri;
	private String ca_phoneno_nri;
	private String ca_emp_id;
	private String ca_emp_name;
	private String ca_emp_desi;
	private String ca_emp_branch;
	private String ca_nationlality_nri;
	private String ca_swftcodebk_tf;
	private String ca_codegvctlbk_tf;
	private String ca_codegvntrd_tf;
	private String ca_swftcodee_tf;
	private String ca_min_gurd;
	private String ca_min_rell;
	private String ca_min_add;
	private String ca_min_addcode;
	private String ca_min_state1;
	private String ca_min_cty1;
	private String ca_min_post1;
	private String ca_min_cont1;
	private String ca_country_of_incorp;
	private String ca_corp_name;
	private String ca_nature_of_business;
	private String ca_mode_of_operation;
	private String ca_contact_person_name;
	private String ca_job_title;
	private String ca_email_address;
	private String ca_fax_no;
	private String ca_capital_invested;
	private String ca_expected_turnover;
	private String ca_expected_expenditure;
	private String ca_account_no;
	private String ca_introducer_name;
	private String ca_address;
	private String ca_mobile_no;
	private String user_id1;
	private String user_id2;
	private String user_id3;
	private String temp_k;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cif_id;
	private String account_id;
	private String notify_flg;
	private String entity_flg;
	private String approval_flg;
	private String kyc_flg;
	private String kyc_hold_flg;
	private String kyc_reject_flg;
	private String status;
	private String hold_remarks;
	private String reject_remarks;
	private String remarks;
	private String ca_acct_type;
	@Id
	
	private String appl_ref_no;
	private String rec_no;
	private String entry_user;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date entry_time;
	private String modify_user;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date modify_time;
	private String verify_user;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date verify_time;
	private String channel_id;
	private String relationship;
	private String hold_type;

	// check
	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDetails(String ca_customer_type, String ca_saluation, String ca_first_name, String mid_name,
			String ca_last_name, String ca_preferred_name, String ca_occupation1, String ca_gender,
			String ca_martial_staus, Date ca_date_of_birth, String ca_address_type, String ca_house_no,
			String ca_street_no, String ca_street_name, String ca_country, String ca_state, String ca_city,
			String ca_postal_code, Date ca_address_validation_form, String ca_nationality, String ca_country_of_birth,
			String ca_email_id, String ca_mobile_number, String ca_phone_number, String ca_occupation2,
			String ca_non_resident, String ca_staff_indicator, String ca_trdfin, String ca_minor_indicator,
			String ca_guardian_name, String ca_schemetype, String ca_scheme_code, String ca_currency, String ca_glcode,
			String ca_solid, String ca_idenditification_number, Date ca_issue_date, String ca_passport_number,
			Date ca_expiry_date, String ca_addrtype_nri, String ca_relname_nri, String ca_relationship_nri,
			String ca_locaddrnri, String ca_ctry_nri, String ca_nri_state, String ca_cty_nri, String ca_code_nri,
			String ca_phoneno_nri, String ca_emp_id, String ca_emp_name, String ca_emp_desi, String ca_emp_branch,
			String ca_nationlality_nri, String ca_swftcodebk_tf, String ca_codegvctlbk_tf, String ca_codegvntrd_tf,
			String ca_swftcodee_tf, String ca_min_gurd, String ca_min_rell, String ca_min_add, String ca_min_addcode,
			String ca_min_state1, String ca_min_cty1, String ca_min_post1, String ca_min_cont1,
			String ca_country_of_incorp, String ca_corp_name, String ca_nature_of_business, String ca_mode_of_operation,
			String ca_contact_person_name, String ca_job_title, String ca_email_address, String ca_fax_no,
			String ca_capital_invested, String ca_expected_turnover, String ca_expected_expenditure,
			String ca_account_no, String ca_introducer_name, String ca_address, String ca_mobile_no, String user_id1,
			String user_id2, String user_id3, String temp_k, String cif_id, String account_id, String notify_flg,
			String entity_flg, String approval_flg, String kyc_flg, String kyc_hold_flg, String kyc_reject_flg,
			String status, String hold_remarks, String reject_remarks, String remarks, String ca_acct_type,
			String appl_ref_no, String rec_no, String entry_user, Date entry_time, String modify_user, Date modify_time,
			String verify_user, Date verify_time, String channel_id, String relationship, String hold_type) {
		super();

		this.ca_customer_type = ca_customer_type;
		this.ca_saluation = ca_saluation;
		this.ca_first_name = ca_first_name;
		this.mid_name = mid_name;
		this.ca_last_name = ca_last_name;
		this.ca_preferred_name = ca_preferred_name;
		this.ca_occupation1 = ca_occupation1;
		this.ca_gender = ca_gender;
		this.ca_martial_staus = ca_martial_staus;
		this.ca_date_of_birth = ca_date_of_birth;
		this.ca_address_type = ca_address_type;
		this.ca_house_no = ca_house_no;
		this.ca_street_no = ca_street_no;
		this.ca_street_name = ca_street_name;
		this.ca_country = ca_country;
		this.ca_state = ca_state;
		this.ca_city = ca_city;
		this.ca_postal_code = ca_postal_code;
		this.ca_address_validation_form = ca_address_validation_form;
		this.ca_nationality = ca_nationality;
		this.ca_country_of_birth = ca_country_of_birth;
		this.ca_email_id = ca_email_id;
		this.ca_mobile_number = ca_mobile_number;
		this.ca_phone_number = ca_phone_number;
		this.ca_occupation2 = ca_occupation2;
		this.ca_non_resident = ca_non_resident;
		this.ca_staff_indicator = ca_staff_indicator;
		this.ca_trdfin = ca_trdfin;
		this.ca_minor_indicator = ca_minor_indicator;
		this.ca_guardian_name = ca_guardian_name;
		this.ca_schemetype = ca_schemetype;
		this.ca_scheme_code = ca_scheme_code;
		this.ca_currency = ca_currency;
		this.ca_glcode = ca_glcode;
		this.ca_solid = ca_solid;
		this.ca_idenditification_number = ca_idenditification_number;
		this.ca_issue_date = ca_issue_date;
		this.ca_passport_number = ca_passport_number;
		this.ca_expiry_date = ca_expiry_date;
		this.ca_addrtype_nri = ca_addrtype_nri;
		this.ca_relname_nri = ca_relname_nri;
		this.ca_relationship_nri = ca_relationship_nri;
		this.ca_locaddrnri = ca_locaddrnri;
		this.ca_ctry_nri = ca_ctry_nri;
		this.ca_nri_state = ca_nri_state;
		this.ca_cty_nri = ca_cty_nri;
		this.ca_code_nri = ca_code_nri;
		this.ca_phoneno_nri = ca_phoneno_nri;
		this.ca_emp_id = ca_emp_id;
		this.ca_emp_name = ca_emp_name;
		this.ca_emp_desi = ca_emp_desi;
		this.ca_emp_branch = ca_emp_branch;
		this.ca_nationlality_nri = ca_nationlality_nri;
		this.ca_swftcodebk_tf = ca_swftcodebk_tf;
		this.ca_codegvctlbk_tf = ca_codegvctlbk_tf;
		this.ca_codegvntrd_tf = ca_codegvntrd_tf;
		this.ca_swftcodee_tf = ca_swftcodee_tf;
		this.ca_min_gurd = ca_min_gurd;
		this.ca_min_rell = ca_min_rell;
		this.ca_min_add = ca_min_add;
		this.ca_min_addcode = ca_min_addcode;
		this.ca_min_state1 = ca_min_state1;
		this.ca_min_cty1 = ca_min_cty1;
		this.ca_min_post1 = ca_min_post1;
		this.ca_min_cont1 = ca_min_cont1;
		this.ca_country_of_incorp = ca_country_of_incorp;
		this.ca_corp_name = ca_corp_name;
		this.ca_nature_of_business = ca_nature_of_business;
		this.ca_mode_of_operation = ca_mode_of_operation;
		this.ca_contact_person_name = ca_contact_person_name;
		this.ca_job_title = ca_job_title;
		this.ca_email_address = ca_email_address;
		this.ca_fax_no = ca_fax_no;
		this.ca_capital_invested = ca_capital_invested;
		this.ca_expected_turnover = ca_expected_turnover;
		this.ca_expected_expenditure = ca_expected_expenditure;
		this.ca_account_no = ca_account_no;
		this.ca_introducer_name = ca_introducer_name;
		this.ca_address = ca_address;
		this.ca_mobile_no = ca_mobile_no;
		this.user_id1 = user_id1;
		this.user_id2 = user_id2;
		this.user_id3 = user_id3;
		this.temp_k = temp_k;
		this.cif_id = cif_id;
		this.account_id = account_id;
		this.notify_flg = notify_flg;
		this.entity_flg = entity_flg;
		this.approval_flg = approval_flg;
		this.kyc_flg = kyc_flg;
		this.kyc_hold_flg = kyc_hold_flg;
		this.kyc_reject_flg = kyc_reject_flg;
		this.status = status;
		this.hold_remarks = hold_remarks;
		this.reject_remarks = reject_remarks;
		this.remarks = remarks;
		this.ca_acct_type = ca_acct_type;
		this.appl_ref_no = appl_ref_no;
		this.rec_no = rec_no;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.channel_id = channel_id;
		this.relationship = relationship;
		this.hold_type = hold_type;
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

	

}
