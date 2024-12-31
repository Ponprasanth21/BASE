package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_EMPLOYEE_PROFILE")
public class Employee_Profile {
	private String	branch_desc;
	private String	category;
	@Id
	private String	employee_id;
	private String	employee_name;
	private String	bank;
	private String	bank_act_no;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	doj;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	dob;
	private String	branch_id;
	private String	department;
	private String	report_mgr_id;
	private String	report_mgr_name;
	private String	design;
	private String	role;
	private String	qual;
	private String	addl_qual;
	private String	skill_set;
	private String	expertise;
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
	private String	emer_contact_person;
	private String	emer_contact_num;
	private String	password;
	private BigDecimal	life_of_pw;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	acct_expy_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	pw_expy_date;
	private String	user_remarks;
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
	private String	locked_flg;
	private String	session_id;
	private String	employee_Remarks;
	private byte[]  employee_Photo;
	public String getBranch_desc() {
		return branch_desc;
	}
	public void setBranch_desc(String branch_desc) {
		this.branch_desc = branch_desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
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
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String getEmer_contact_person() {
		return emer_contact_person;
	}
	public void setEmer_contact_person(String emer_contact_person) {
		this.emer_contact_person = emer_contact_person;
	}
	public String getEmer_contact_num() {
		return emer_contact_num;
	}
	public void setEmer_contact_num(String emer_contact_num) {
		this.emer_contact_num = emer_contact_num;
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
	public String getEmployee_Remarks() {
		return employee_Remarks;
	}
	public void setEmployee_Remarks(String employee_Remarks) {
		this.employee_Remarks = employee_Remarks;
	}
	public byte[] getEmployee_Photo() {
		return employee_Photo;
	}
	public void setEmployee_Photo(byte[] employee_Photo) {
		this.employee_Photo = employee_Photo;
	}
	@Override
	public String toString() {
		return "Employee_Profile [branch_desc=" + branch_desc + ", category=" + category + ", employee_id="
				+ employee_id + ", employee_name=" + employee_name + ", bank=" + bank + ", bank_act_no=" + bank_act_no
				+ ", doj=" + doj + ", dob=" + dob + ", branch_id=" + branch_id + ", department=" + department
				+ ", report_mgr_id=" + report_mgr_id + ", report_mgr_name=" + report_mgr_name + ", design=" + design
				+ ", role=" + role + ", qual=" + qual + ", addl_qual=" + addl_qual + ", skill_set=" + skill_set
				+ ", expertise=" + expertise + ", passport=" + passport + ", driving_license=" + driving_license
				+ ", gender=" + gender + ", blood_group=" + blood_group + ", marital_status=" + marital_status
				+ ", dependants=" + dependants + ", mobile=" + mobile + ", alt_mobile=" + alt_mobile + ", access_id="
				+ access_id + ", email=" + email + ", addr1=" + addr1 + ", addr2=" + addr2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", postal_code=" + postal_code
				+ ", emer_contact_person=" + emer_contact_person + ", emer_contact_num=" + emer_contact_num
				+ ", password=" + password + ", life_of_pw=" + life_of_pw + ", acct_expy_date=" + acct_expy_date
				+ ", pw_expy_date=" + pw_expy_date + ", user_remarks=" + user_remarks + ", entry_user=" + entry_user
				+ ", modify_user=" + modify_user + ", verify_user=" + verify_user + ", entry_time=" + entry_time
				+ ", modify_time=" + modify_time + ", verify_time=" + verify_time + ", del_flg=" + del_flg
				+ ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", locked_flg=" + locked_flg
				+ ", session_id=" + session_id + ", employee_Remarks=" + employee_Remarks + ", employee_Photo="
				+ Arrays.toString(employee_Photo) + ", getBranch_desc()=" + getBranch_desc() + ", getCategory()="
				+ getCategory() + ", getEmployee_id()=" + getEmployee_id() + ", getEmployee_name()="
				+ getEmployee_name() + ", getBank()=" + getBank() + ", getBank_act_no()=" + getBank_act_no()
				+ ", getDoj()=" + getDoj() + ", getDob()=" + getDob() + ", getBranch_id()=" + getBranch_id()
				+ ", getDepartment()=" + getDepartment() + ", getReport_mgr_id()=" + getReport_mgr_id()
				+ ", getReport_mgr_name()=" + getReport_mgr_name() + ", getDesign()=" + getDesign() + ", getRole()="
				+ getRole() + ", getQual()=" + getQual() + ", getAddl_qual()=" + getAddl_qual() + ", getSkill_set()="
				+ getSkill_set() + ", getExpertise()=" + getExpertise() + ", getPassport()=" + getPassport()
				+ ", getDriving_license()=" + getDriving_license() + ", getGender()=" + getGender()
				+ ", getBlood_group()=" + getBlood_group() + ", getMarital_status()=" + getMarital_status()
				+ ", getDependants()=" + getDependants() + ", getMobile()=" + getMobile() + ", getAlt_mobile()="
				+ getAlt_mobile() + ", getAccess_id()=" + getAccess_id() + ", getEmail()=" + getEmail()
				+ ", getAddr1()=" + getAddr1() + ", getAddr2()=" + getAddr2() + ", getCity()=" + getCity()
				+ ", getState()=" + getState() + ", getCountry()=" + getCountry() + ", getPostal_code()="
				+ getPostal_code() + ", getEmer_contact_person()=" + getEmer_contact_person()
				+ ", getEmer_contact_num()=" + getEmer_contact_num() + ", getPassword()=" + getPassword()
				+ ", getLife_of_pw()=" + getLife_of_pw() + ", getAcct_expy_date()=" + getAcct_expy_date()
				+ ", getPw_expy_date()=" + getPw_expy_date() + ", getUser_remarks()=" + getUser_remarks()
				+ ", getEntry_user()=" + getEntry_user() + ", getModify_user()=" + getModify_user()
				+ ", getVerify_user()=" + getVerify_user() + ", getEntry_time()=" + getEntry_time()
				+ ", getModify_time()=" + getModify_time() + ", getVerify_time()=" + getVerify_time()
				+ ", getDel_flg()=" + getDel_flg() + ", getEntity_flg()=" + getEntity_flg() + ", getModify_flg()="
				+ getModify_flg() + ", getLocked_flg()=" + getLocked_flg() + ", getSession_id()=" + getSession_id()
				+ ", getEmployee_Remarks()=" + getEmployee_Remarks() + ", getEmployee_Photo()="
				+ Arrays.toString(getEmployee_Photo()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Employee_Profile(String branch_desc, String category, String employee_id, String employee_name, String bank,
			String bank_act_no, Date doj, Date dob, String branch_id, String department, String report_mgr_id,
			String report_mgr_name, String design, String role, String qual, String addl_qual, String skill_set,
			String expertise, String passport, String driving_license, String gender, String blood_group,
			String marital_status, BigDecimal dependants, String mobile, String alt_mobile, String access_id,
			String email, String addr1, String addr2, String city, String state, String country, String postal_code,
			String emer_contact_person, String emer_contact_num, String password, BigDecimal life_of_pw,
			Date acct_expy_date, Date pw_expy_date, String user_remarks, String entry_user, String modify_user,
			String verify_user, Date entry_time, Date modify_time, Date verify_time, String del_flg, String entity_flg,
			String modify_flg, String locked_flg, String session_id, String employee_Remarks, byte[] employee_Photo) {
		super();
		this.branch_desc = branch_desc;
		this.category = category;
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.bank = bank;
		this.bank_act_no = bank_act_no;
		this.doj = doj;
		this.dob = dob;
		this.branch_id = branch_id;
		this.department = department;
		this.report_mgr_id = report_mgr_id;
		this.report_mgr_name = report_mgr_name;
		this.design = design;
		this.role = role;
		this.qual = qual;
		this.addl_qual = addl_qual;
		this.skill_set = skill_set;
		this.expertise = expertise;
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
		this.emer_contact_person = emer_contact_person;
		this.emer_contact_num = emer_contact_num;
		this.password = password;
		this.life_of_pw = life_of_pw;
		this.acct_expy_date = acct_expy_date;
		this.pw_expy_date = pw_expy_date;
		this.user_remarks = user_remarks;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.locked_flg = locked_flg;
		this.session_id = session_id;
		this.employee_Remarks = employee_Remarks;
		this.employee_Photo = employee_Photo;
	}
	public Employee_Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
