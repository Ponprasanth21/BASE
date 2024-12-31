package com.bornfire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BACP_NEGATIVE_LIST")

public class BACP_NEGATIVE_LIST implements Serializable {

	
	private String	first_name;
	private String	shrt_name;
	private String	last_name;
	
	
	private String	nationality;
	private String	passport;
	private String	mbl_num;
	private Date	dob;
	@Id
	private String	national_id;
	private String	mid_name;
	private String	institution;
	private Date	date_of_list;
	private String	remark;
	private String certificate_incorporation;
	private String corporateName; 
	private String landlineNo; 
	private String	business_registration;
	private String	full_name;
	
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getCertificate_incorporation() {
		return certificate_incorporation;
	}
	public void setCertificate_incorporation(String certificate_incorporation) {
		this.certificate_incorporation = certificate_incorporation;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getLandlineNo() {
		return landlineNo;
	}
	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}
	public String getBusiness_registration() {
		return business_registration;
	}
	public void setBusiness_registration(String business_registration) {
		this.business_registration = business_registration;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getShrt_name() {
		return shrt_name;
	}
	public void setShrt_name(String shrt_name) {
		this.shrt_name = shrt_name;
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
	public String getNational_id() {
		return national_id;
	}
	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}
	public String getMid_name() {
		return mid_name;
	}
	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public Date getDate_of_list() {
		return date_of_list;
	}
	public void setDate_of_list(Date date_of_list) {
		this.date_of_list = date_of_list;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public BACP_NEGATIVE_LIST(String first_name, String shrt_name, String last_name, String nationality,
			String passport, String mbl_num, Date dob, String national_id, String mid_name, String institution,
			Date date_of_list, String remark, String certificate_incorporation, String corporateName, String landlineNo,
			String business_registration,String full_name) {
		super();
		this.first_name = first_name;
		this.shrt_name = shrt_name;
		this.last_name = last_name;
		this.nationality = nationality;
		this.passport = passport;
		this.mbl_num = mbl_num;
		this.dob = dob;
		this.national_id = national_id;
		this.mid_name = mid_name;
		this.institution = institution;
		this.date_of_list = date_of_list;
		this.remark = remark;
		this.certificate_incorporation = certificate_incorporation;
		this.corporateName = corporateName;
		this.landlineNo = landlineNo;
		this.business_registration = business_registration;
		this.full_name=full_name;
	}
	public BACP_NEGATIVE_LIST() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	

}
