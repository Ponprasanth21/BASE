package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BAJ_RESOURCE_MASTER")
public class Assosiate_Profile_Entity {
	
	private String	organisation;
	private String	category;
	@Id
	private String	resource_id;
	private String	resource_name;
	private String	employee_ref;
	private String	employee_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	doj;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	dob;
	private String	groups;
	private String	team;
	private String	report_mgr_id;
	private String	report_mgr_name;
	private String	design;
	private String	role;
	private String	qual;
	private String	addl_qual;
	private String	skill_set;
	private String	expertise;
	private String	pancard;
	private String	aadhar;
	private String	passport;
	private String	driving_license;
	private String	gender;
	private String	blood_group;
	private String	marital_status;
	private BigDecimal	dependants;
	private String	mobile;
	private String	alt_mobile;
	private String	access_id;
	private String	email;
	private String	addr1;
	private String	addr2;
	private String	city;
	private String	state;
	private String	country;
	private String	postal_code;
	private String	loc_addr1;
	private String	loc_addr2;
	private String	loc_city;
	private String	loc_state;
	private String	loc_country;
	private String	loc_postal_code;
	private String	user_cont_person;
	private BigDecimal	cont_person_no;
	private String	password;
	private BigDecimal	life_of_pw;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	acct_expy_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	pw_expy_date;
	private String	user_remarks;
	private String	disable_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	dis_start_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	dis_end_date;
	private String	login_low;
	private String	login_high;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	verify_time;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private String	first_name;
	private String	middle_name;
	private String	last_name;
	private String	short_name;
	private String	virtual_flg;
	private String	login_status;
	private String	channel_id;
	private String	locked_flg;
	private String	session_id;
	private String	imei;
	private Date	dor;
	private String	ifsc;
	private String	bank;
	private String	bank_act_no;
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getEmployee_ref() {
		return employee_ref;
	}
	public void setEmployee_ref(String employee_ref) {
		this.employee_ref = employee_ref;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getReport_mgr_id() {
		return report_mgr_id;
	}
	public void setReport_mgr_id(String report_mgr_id) {
		this.report_mgr_id = report_mgr_id;
	}
	public String getReport_mgr_name() {
		return report_mgr_name;
	}
	public void setReport_mgr_name(String report_mgr_name) {
		this.report_mgr_name = report_mgr_name;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getAddl_qual() {
		return addl_qual;
	}
	public void setAddl_qual(String addl_qual) {
		this.addl_qual = addl_qual;
	}
	public String getSkill_set() {
		return skill_set;
	}
	public void setSkill_set(String skill_set) {
		this.skill_set = skill_set;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getDriving_license() {
		return driving_license;
	}
	public void setDriving_license(String driving_license) {
		this.driving_license = driving_license;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public BigDecimal getDependants() {
		return dependants;
	}
	public void setDependants(BigDecimal dependants) {
		this.dependants = dependants;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAlt_mobile() {
		return alt_mobile;
	}
	public void setAlt_mobile(String alt_mobile) {
		this.alt_mobile = alt_mobile;
	}
	public String getAccess_id() {
		return access_id;
	}
	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getLoc_addr1() {
		return loc_addr1;
	}
	public void setLoc_addr1(String loc_addr1) {
		this.loc_addr1 = loc_addr1;
	}
	public String getLoc_addr2() {
		return loc_addr2;
	}
	public void setLoc_addr2(String loc_addr2) {
		this.loc_addr2 = loc_addr2;
	}
	public String getLoc_city() {
		return loc_city;
	}
	public void setLoc_city(String loc_city) {
		this.loc_city = loc_city;
	}
	public String getLoc_state() {
		return loc_state;
	}
	public void setLoc_state(String loc_state) {
		this.loc_state = loc_state;
	}
	public String getLoc_country() {
		return loc_country;
	}
	public void setLoc_country(String loc_country) {
		this.loc_country = loc_country;
	}
	public String getLoc_postal_code() {
		return loc_postal_code;
	}
	public void setLoc_postal_code(String loc_postal_code) {
		this.loc_postal_code = loc_postal_code;
	}
	public String getUser_cont_person() {
		return user_cont_person;
	}
	public void setUser_cont_person(String user_cont_person) {
		this.user_cont_person = user_cont_person;
	}
	public BigDecimal getCont_person_no() {
		return cont_person_no;
	}
	public void setCont_person_no(BigDecimal cont_person_no) {
		this.cont_person_no = cont_person_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigDecimal getLife_of_pw() {
		return life_of_pw;
	}
	public void setLife_of_pw(BigDecimal life_of_pw) {
		this.life_of_pw = life_of_pw;
	}
	public Date getAcct_expy_date() {
		return acct_expy_date;
	}
	public void setAcct_expy_date(Date acct_expy_date) {
		this.acct_expy_date = acct_expy_date;
	}
	public Date getPw_expy_date() {
		return pw_expy_date;
	}
	public void setPw_expy_date(Date pw_expy_date) {
		this.pw_expy_date = pw_expy_date;
	}
	public String getUser_remarks() {
		return user_remarks;
	}
	public void setUser_remarks(String user_remarks) {
		this.user_remarks = user_remarks;
	}
	public String getDisable_flg() {
		return disable_flg;
	}
	public void setDisable_flg(String disable_flg) {
		this.disable_flg = disable_flg;
	}
	public Date getDis_start_date() {
		return dis_start_date;
	}
	public void setDis_start_date(Date dis_start_date) {
		this.dis_start_date = dis_start_date;
	}
	public Date getDis_end_date() {
		return dis_end_date;
	}
	public void setDis_end_date(Date dis_end_date) {
		this.dis_end_date = dis_end_date;
	}
	public String getLogin_low() {
		return login_low;
	}
	public void setLogin_low(String login_low) {
		this.login_low = login_low;
	}
	public String getLogin_high() {
		return login_high;
	}
	public void setLogin_high(String login_high) {
		this.login_high = login_high;
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
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getVirtual_flg() {
		return virtual_flg;
	}
	public void setVirtual_flg(String virtual_flg) {
		this.virtual_flg = virtual_flg;
	}
	public String getLogin_status() {
		return login_status;
	}
	public void setLogin_status(String login_status) {
		this.login_status = login_status;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getLocked_flg() {
		return locked_flg;
	}
	public void setLocked_flg(String locked_flg) {
		this.locked_flg = locked_flg;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public Date getDor() {
		return dor;
	}
	public void setDor(Date dor) {
		this.dor = dor;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBank_act_no() {
		return bank_act_no;
	}
	public void setBank_act_no(String bank_act_no) {
		this.bank_act_no = bank_act_no;
	}
	public Assosiate_Profile_Entity(String organisation, String category, String resource_id, String resource_name,
			String employee_ref, String employee_id, Date doj, Date dob, String groups, String team,
			String report_mgr_id, String report_mgr_name, String design, String role, String qual, String addl_qual,
			String skill_set, String expertise, String pancard, String aadhar, String passport, String driving_license,
			String gender, String blood_group, String marital_status, BigDecimal dependants, String mobile,
			String alt_mobile, String access_id, String email, String addr1, String addr2, String city, String state,
			String country, String postal_code, String loc_addr1, String loc_addr2, String loc_city, String loc_state,
			String loc_country, String loc_postal_code, String user_cont_person, BigDecimal cont_person_no,
			String password, BigDecimal life_of_pw, Date acct_expy_date, Date pw_expy_date, String user_remarks,
			String disable_flg, Date dis_start_date, Date dis_end_date, String login_low, String login_high,
			String entry_user, String modify_user, String verify_user, Date entry_time, Date modify_time,
			Date verify_time, String del_flg, String entity_flg, String modify_flg, String first_name,
			String middle_name, String last_name, String short_name, String virtual_flg, String login_status,
			String channel_id, String locked_flg, String session_id, String imei, Date dor, String ifsc, String bank,
			String bank_act_no) {
		super();
		this.organisation = organisation;
		this.category = category;
		this.resource_id = resource_id;
		this.resource_name = resource_name;
		this.employee_ref = employee_ref;
		this.employee_id = employee_id;
		this.doj = doj;
		this.dob = dob;
		this.groups = groups;
		this.team = team;
		this.report_mgr_id = report_mgr_id;
		this.report_mgr_name = report_mgr_name;
		this.design = design;
		this.role = role;
		this.qual = qual;
		this.addl_qual = addl_qual;
		this.skill_set = skill_set;
		this.expertise = expertise;
		this.pancard = pancard;
		this.aadhar = aadhar;
		this.passport = passport;
		this.driving_license = driving_license;
		this.gender = gender;
		this.blood_group = blood_group;
		this.marital_status = marital_status;
		this.dependants = dependants;
		this.mobile = mobile;
		this.alt_mobile = alt_mobile;
		this.access_id = access_id;
		this.email = email;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postal_code = postal_code;
		this.loc_addr1 = loc_addr1;
		this.loc_addr2 = loc_addr2;
		this.loc_city = loc_city;
		this.loc_state = loc_state;
		this.loc_country = loc_country;
		this.loc_postal_code = loc_postal_code;
		this.user_cont_person = user_cont_person;
		this.cont_person_no = cont_person_no;
		this.password = password;
		this.life_of_pw = life_of_pw;
		this.acct_expy_date = acct_expy_date;
		this.pw_expy_date = pw_expy_date;
		this.user_remarks = user_remarks;
		this.disable_flg = disable_flg;
		this.dis_start_date = dis_start_date;
		this.dis_end_date = dis_end_date;
		this.login_low = login_low;
		this.login_high = login_high;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.short_name = short_name;
		this.virtual_flg = virtual_flg;
		this.login_status = login_status;
		this.channel_id = channel_id;
		this.locked_flg = locked_flg;
		this.session_id = session_id;
		this.imei = imei;
		this.dor = dor;
		this.ifsc = ifsc;
		this.bank = bank;
		this.bank_act_no = bank_act_no;
	}
	public Assosiate_Profile_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
