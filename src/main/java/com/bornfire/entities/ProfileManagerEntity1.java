
package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

@Entity
@Table(name = "BAJ_PROFILE_MANAGER")

public class ProfileManagerEntity1 {

	
	@Id
	private String	emp_id;
	private String	emp_name;
	private String	emp_desig;
	private String	emp_group;
	private String	marital_status;
	private BigDecimal	mobile_no;
	private String	email_id;
	private String	passport_no;
	private String	addr;
	private String	academic_qual;
	private String	addl_qual;
	private String	certification;
	private String	skill_set;
	private String	capabilities;
	private String	experience;
	private String	project_exposure;
	private String	remarks;
	private String	prev_orgn_1;
	private String	prev_orgn_2;
	private String	prev_orgn_3;
	private String	prev_orgn_4;
	private String	prev_orgn_5;
	private String	prev_orgn_6;
	private String	prev_orgn_7;
	private String	prev_orgn_8;
	private String	prev_orgn_9;
	private String	prev_orgn_10;
	private String	proj_det_1;
	private String	proj_det_2;
	private String	proj_det_3;
	private String	proj_det_4;
	private String	proj_det_5;
	private String	proj_det_6;
	private String	proj_det_7;
	private String	proj_det_8;
	private String	proj_det_9;
	private String	proj_det_10;
	private String	proj_det_11;
	private String	proj_det_12;
	private String	proj_det_13;
	private String	proj_det_14;
	private String	proj_det_15;
	private String	proj_det_16;
	private String	proj_det_17;
	private String	proj_det_18;
	private String	proj_det_19;
	private String	proj_det_20;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	dob;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	auth_time;
	private String	column1;
	private String	column2;
	private String	column3;
	private String	column4;
	private String	column5;
	private String	column6;
	private String	column7;
	private String	column8;
	private String	column9;
	private String	column10;
	private String	column11;
	private String	column12;
	private String	column13;
	private String	column14;
	private String	column15;
	private String	column16;
	private String	verify_flg;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_desig() {
		return emp_desig;
	}
	public void setEmp_desig(String emp_desig) {
		this.emp_desig = emp_desig;
	}
	public String getEmp_group() {
		return emp_group;
	}
	public void setEmp_group(String emp_group) {
		this.emp_group = emp_group;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public BigDecimal getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(BigDecimal mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAcademic_qual() {
		return academic_qual;
	}
	public void setAcademic_qual(String academic_qual) {
		this.academic_qual = academic_qual;
	}
	public String getAddl_qual() {
		return addl_qual;
	}
	public void setAddl_qual(String addl_qual) {
		this.addl_qual = addl_qual;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getSkill_set() {
		return skill_set;
	}
	public void setSkill_set(String skill_set) {
		this.skill_set = skill_set;
	}
	public String getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(String capabilities) {
		this.capabilities = capabilities;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getProject_exposure() {
		return project_exposure;
	}
	public void setProject_exposure(String project_exposure) {
		this.project_exposure = project_exposure;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPrev_orgn_1() {
		return prev_orgn_1;
	}
	public void setPrev_orgn_1(String prev_orgn_1) {
		this.prev_orgn_1 = prev_orgn_1;
	}
	public String getPrev_orgn_2() {
		return prev_orgn_2;
	}
	public void setPrev_orgn_2(String prev_orgn_2) {
		this.prev_orgn_2 = prev_orgn_2;
	}
	public String getPrev_orgn_3() {
		return prev_orgn_3;
	}
	public void setPrev_orgn_3(String prev_orgn_3) {
		this.prev_orgn_3 = prev_orgn_3;
	}
	public String getPrev_orgn_4() {
		return prev_orgn_4;
	}
	public void setPrev_orgn_4(String prev_orgn_4) {
		this.prev_orgn_4 = prev_orgn_4;
	}
	public String getPrev_orgn_5() {
		return prev_orgn_5;
	}
	public void setPrev_orgn_5(String prev_orgn_5) {
		this.prev_orgn_5 = prev_orgn_5;
	}
	public String getPrev_orgn_6() {
		return prev_orgn_6;
	}
	public void setPrev_orgn_6(String prev_orgn_6) {
		this.prev_orgn_6 = prev_orgn_6;
	}
	public String getPrev_orgn_7() {
		return prev_orgn_7;
	}
	public void setPrev_orgn_7(String prev_orgn_7) {
		this.prev_orgn_7 = prev_orgn_7;
	}
	public String getPrev_orgn_8() {
		return prev_orgn_8;
	}
	public void setPrev_orgn_8(String prev_orgn_8) {
		this.prev_orgn_8 = prev_orgn_8;
	}
	public String getPrev_orgn_9() {
		return prev_orgn_9;
	}
	public void setPrev_orgn_9(String prev_orgn_9) {
		this.prev_orgn_9 = prev_orgn_9;
	}
	public String getPrev_orgn_10() {
		return prev_orgn_10;
	}
	public void setPrev_orgn_10(String prev_orgn_10) {
		this.prev_orgn_10 = prev_orgn_10;
	}
	public String getProj_det_1() {
		return proj_det_1;
	}
	public void setProj_det_1(String proj_det_1) {
		this.proj_det_1 = proj_det_1;
	}
	public String getProj_det_2() {
		return proj_det_2;
	}
	public void setProj_det_2(String proj_det_2) {
		this.proj_det_2 = proj_det_2;
	}
	public String getProj_det_3() {
		return proj_det_3;
	}
	public void setProj_det_3(String proj_det_3) {
		this.proj_det_3 = proj_det_3;
	}
	public String getProj_det_4() {
		return proj_det_4;
	}
	public void setProj_det_4(String proj_det_4) {
		this.proj_det_4 = proj_det_4;
	}
	public String getProj_det_5() {
		return proj_det_5;
	}
	public void setProj_det_5(String proj_det_5) {
		this.proj_det_5 = proj_det_5;
	}
	public String getProj_det_6() {
		return proj_det_6;
	}
	public void setProj_det_6(String proj_det_6) {
		this.proj_det_6 = proj_det_6;
	}
	public String getProj_det_7() {
		return proj_det_7;
	}
	public void setProj_det_7(String proj_det_7) {
		this.proj_det_7 = proj_det_7;
	}
	public String getProj_det_8() {
		return proj_det_8;
	}
	public void setProj_det_8(String proj_det_8) {
		this.proj_det_8 = proj_det_8;
	}
	public String getProj_det_9() {
		return proj_det_9;
	}
	public void setProj_det_9(String proj_det_9) {
		this.proj_det_9 = proj_det_9;
	}
	public String getProj_det_10() {
		return proj_det_10;
	}
	public void setProj_det_10(String proj_det_10) {
		this.proj_det_10 = proj_det_10;
	}
	public String getProj_det_11() {
		return proj_det_11;
	}
	public void setProj_det_11(String proj_det_11) {
		this.proj_det_11 = proj_det_11;
	}
	public String getProj_det_12() {
		return proj_det_12;
	}
	public void setProj_det_12(String proj_det_12) {
		this.proj_det_12 = proj_det_12;
	}
	public String getProj_det_13() {
		return proj_det_13;
	}
	public void setProj_det_13(String proj_det_13) {
		this.proj_det_13 = proj_det_13;
	}
	public String getProj_det_14() {
		return proj_det_14;
	}
	public void setProj_det_14(String proj_det_14) {
		this.proj_det_14 = proj_det_14;
	}
	public String getProj_det_15() {
		return proj_det_15;
	}
	public void setProj_det_15(String proj_det_15) {
		this.proj_det_15 = proj_det_15;
	}
	public String getProj_det_16() {
		return proj_det_16;
	}
	public void setProj_det_16(String proj_det_16) {
		this.proj_det_16 = proj_det_16;
	}
	public String getProj_det_17() {
		return proj_det_17;
	}
	public void setProj_det_17(String proj_det_17) {
		this.proj_det_17 = proj_det_17;
	}
	public String getProj_det_18() {
		return proj_det_18;
	}
	public void setProj_det_18(String proj_det_18) {
		this.proj_det_18 = proj_det_18;
	}
	public String getProj_det_19() {
		return proj_det_19;
	}
	public void setProj_det_19(String proj_det_19) {
		this.proj_det_19 = proj_det_19;
	}
	public String getProj_det_20() {
		return proj_det_20;
	}
	public void setProj_det_20(String proj_det_20) {
		this.proj_det_20 = proj_det_20;
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
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	public String getColumn3() {
		return column3;
	}
	public void setColumn3(String column3) {
		this.column3 = column3;
	}
	public String getColumn4() {
		return column4;
	}
	public void setColumn4(String column4) {
		this.column4 = column4;
	}
	public String getColumn5() {
		return column5;
	}
	public void setColumn5(String column5) {
		this.column5 = column5;
	}
	public String getColumn6() {
		return column6;
	}
	public void setColumn6(String column6) {
		this.column6 = column6;
	}
	public String getColumn7() {
		return column7;
	}
	public void setColumn7(String column7) {
		this.column7 = column7;
	}
	public String getColumn8() {
		return column8;
	}
	public void setColumn8(String column8) {
		this.column8 = column8;
	}
	public String getColumn9() {
		return column9;
	}
	public void setColumn9(String column9) {
		this.column9 = column9;
	}
	public String getColumn10() {
		return column10;
	}
	public void setColumn10(String column10) {
		this.column10 = column10;
	}
	public String getColumn11() {
		return column11;
	}
	public void setColumn11(String column11) {
		this.column11 = column11;
	}
	public String getColumn12() {
		return column12;
	}
	public void setColumn12(String column12) {
		this.column12 = column12;
	}
	public String getColumn13() {
		return column13;
	}
	public void setColumn13(String column13) {
		this.column13 = column13;
	}
	public String getColumn14() {
		return column14;
	}
	public void setColumn14(String column14) {
		this.column14 = column14;
	}
	public String getColumn15() {
		return column15;
	}
	public void setColumn15(String column15) {
		this.column15 = column15;
	}
	public String getColumn16() {
		return column16;
	}
	public void setColumn16(String column16) {
		this.column16 = column16;
	}
	public String getVerify_flg() {
		return verify_flg;
	}
	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}
	public ProfileManagerEntity1(String emp_id, String emp_name, String emp_desig, String emp_group,
			String marital_status, BigDecimal mobile_no, String email_id, String passport_no, String addr,
			String academic_qual, String addl_qual, String certification, String skill_set, String capabilities,
			String experience, String project_exposure, String remarks, String prev_orgn_1, String prev_orgn_2,
			String prev_orgn_3, String prev_orgn_4, String prev_orgn_5, String prev_orgn_6, String prev_orgn_7,
			String prev_orgn_8, String prev_orgn_9, String prev_orgn_10, String proj_det_1, String proj_det_2,
			String proj_det_3, String proj_det_4, String proj_det_5, String proj_det_6, String proj_det_7,
			String proj_det_8, String proj_det_9, String proj_det_10, String proj_det_11, String proj_det_12,
			String proj_det_13, String proj_det_14, String proj_det_15, String proj_det_16, String proj_det_17,
			String proj_det_18, String proj_det_19, String proj_det_20, String entry_user, String modify_user,
			String auth_user, String del_flg, String entity_flg, String modify_flg, Date dob, Date entry_time,
			Date modify_time, Date auth_time, String column1, String column2, String column3, String column4,
			String column5, String column6, String column7, String column8, String column9, String column10,
			String column11, String column12, String column13, String column14, String column15, String column16,
			String verify_flg) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_desig = emp_desig;
		this.emp_group = emp_group;
		this.marital_status = marital_status;
		this.mobile_no = mobile_no;
		this.email_id = email_id;
		this.passport_no = passport_no;
		this.addr = addr;
		this.academic_qual = academic_qual;
		this.addl_qual = addl_qual;
		this.certification = certification;
		this.skill_set = skill_set;
		this.capabilities = capabilities;
		this.experience = experience;
		this.project_exposure = project_exposure;
		this.remarks = remarks;
		this.prev_orgn_1 = prev_orgn_1;
		this.prev_orgn_2 = prev_orgn_2;
		this.prev_orgn_3 = prev_orgn_3;
		this.prev_orgn_4 = prev_orgn_4;
		this.prev_orgn_5 = prev_orgn_5;
		this.prev_orgn_6 = prev_orgn_6;
		this.prev_orgn_7 = prev_orgn_7;
		this.prev_orgn_8 = prev_orgn_8;
		this.prev_orgn_9 = prev_orgn_9;
		this.prev_orgn_10 = prev_orgn_10;
		this.proj_det_1 = proj_det_1;
		this.proj_det_2 = proj_det_2;
		this.proj_det_3 = proj_det_3;
		this.proj_det_4 = proj_det_4;
		this.proj_det_5 = proj_det_5;
		this.proj_det_6 = proj_det_6;
		this.proj_det_7 = proj_det_7;
		this.proj_det_8 = proj_det_8;
		this.proj_det_9 = proj_det_9;
		this.proj_det_10 = proj_det_10;
		this.proj_det_11 = proj_det_11;
		this.proj_det_12 = proj_det_12;
		this.proj_det_13 = proj_det_13;
		this.proj_det_14 = proj_det_14;
		this.proj_det_15 = proj_det_15;
		this.proj_det_16 = proj_det_16;
		this.proj_det_17 = proj_det_17;
		this.proj_det_18 = proj_det_18;
		this.proj_det_19 = proj_det_19;
		this.proj_det_20 = proj_det_20;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.dob = dob;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
		this.column1 = column1;
		this.column2 = column2;
		this.column3 = column3;
		this.column4 = column4;
		this.column5 = column5;
		this.column6 = column6;
		this.column7 = column7;
		this.column8 = column8;
		this.column9 = column9;
		this.column10 = column10;
		this.column11 = column11;
		this.column12 = column12;
		this.column13 = column13;
		this.column14 = column14;
		this.column15 = column15;
		this.column16 = column16;
		this.verify_flg = verify_flg;
	}
	public ProfileManagerEntity1() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}