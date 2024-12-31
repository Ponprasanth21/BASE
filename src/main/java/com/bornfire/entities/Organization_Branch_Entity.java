package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "BGLS_ORG_BRANCH")
public class Organization_Branch_Entity {
	private String branch_code;
	@Id
	private String branch_name;
	private String add_1;
	private String add_2;
	private String city;
	private String state;
	private String country;
	private String zip_code;
	private String swift_code;
	private String pic_no;
	private String land_line;
	private String fax;
	private BigDecimal mobile;
	private String cont_person;
	private String website;
	private String mail_id;
	private String branch_head;
	private String designation;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	private String	del_flg;
	private String	modify_flg;
	private String	entity_flg;
	@Lob
	private byte[]	photo;
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getAdd_1() {
		return add_1;
	}

	public void setAdd_1(String add_1) {
		this.add_1 = add_1;
	}

	public String getAdd_2() {
		return add_2;
	}

	public void setAdd_2(String add_2) {
		this.add_2 = add_2;
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

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getSwift_code() {
		return swift_code;
	}

	public void setSwift_code(String swift_code) {
		this.swift_code = swift_code;
	}

	public String getPic_no() {
		return pic_no;
	}

	public void setPic_no(String pic_no) {
		this.pic_no = pic_no;
	}

	public String getLand_line() {
		return land_line;
	}

	public void setLand_line(String land_line) {
		this.land_line = land_line;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public BigDecimal getMobile() {
		return mobile;
	}

	public void setMobile(BigDecimal mobile) {
		this.mobile = mobile;
	}

	public String getCont_person() {
		return cont_person;
	}

	public void setCont_person(String cont_person) {
		this.cont_person = cont_person;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getBranch_head() {
		return branch_head;
	}

	public void setBranch_head(String branch_head) {
		this.branch_head = branch_head;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	
	public Organization_Branch_Entity(String branch_code, String branch_name, String add_1, String add_2, String city,
			String state, String country, String zip_code, String swift_code, String pic_no, String land_line,
			String fax, BigDecimal mobile, String cont_person, String website, String mail_id, String branch_head,
			String designation, String entry_user, String modify_user, String verify_user, Date entry_time,
			Date modify_time, Date verify_time, String del_flg, String modify_flg, String entity_flg, byte[] photo) {
		super();
		this.branch_code = branch_code;
		this.branch_name = branch_name;
		this.add_1 = add_1;
		this.add_2 = add_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
		this.swift_code = swift_code;
		this.pic_no = pic_no;
		this.land_line = land_line;
		this.fax = fax;
		this.mobile = mobile;
		this.cont_person = cont_person;
		this.website = website;
		this.mail_id = mail_id;
		this.branch_head = branch_head;
		this.designation = designation;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.modify_flg = modify_flg;
		this.entity_flg = entity_flg;
		this.photo = photo;
	}

	public Organization_Branch_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
