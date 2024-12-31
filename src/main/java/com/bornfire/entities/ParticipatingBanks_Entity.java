package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_BRANCH_TABLE")
public class ParticipatingBanks_Entity {

	private String	bank_code;
	private String	bank_name;
	private String	branch_code;
	private String	branch_name;
	private String	address_1;
	private String	address_2;
	private String	district;
	private String	city;
	private String	country;
	private String	state;
	private String	web_site;
	private String	landline;
	private String	contact_details;
	private String	contact_person;
	private String	email_id;
	private String	mobile_no;
	private String	bic_code;
	private String	swift_code;
	private String	settlement_account_name;
	@Id
	private String	settlement_account_no;
	private String	mirror_account_no;
	private String	settlement_currency;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
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
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWeb_site() {
		return web_site;
	}
	public void setWeb_site(String web_site) {
		this.web_site = web_site;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getContact_details() {
		return contact_details;
	}
	public void setContact_details(String contact_details) {
		this.contact_details = contact_details;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getBic_code() {
		return bic_code;
	}
	public void setBic_code(String bic_code) {
		this.bic_code = bic_code;
	}
	public String getSwift_code() {
		return swift_code;
	}
	public void setSwift_code(String swift_code) {
		this.swift_code = swift_code;
	}
	public String getSettlement_account_name() {
		return settlement_account_name;
	}
	public void setSettlement_account_name(String settlement_account_name) {
		this.settlement_account_name = settlement_account_name;
	}
	public String getSettlement_account_no() {
		return settlement_account_no;
	}
	public void setSettlement_account_no(String settlement_account_no) {
		this.settlement_account_no = settlement_account_no;
	}
	public String getMirror_account_no() {
		return mirror_account_no;
	}
	public void setMirror_account_no(String mirror_account_no) {
		this.mirror_account_no = mirror_account_no;
	}
	public String getSettlement_currency() {
		return settlement_currency;
	}
	public void setSettlement_currency(String settlement_currency) {
		this.settlement_currency = settlement_currency;
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
	public ParticipatingBanks_Entity(String bank_code, String bank_name, String branch_code, String branch_name,
			String address_1, String address_2, String district, String city, String country, String state,
			String web_site, String landline, String contact_details, String contact_person, String email_id,
			String mobile_no, String bic_code, String swift_code, String settlement_account_name,
			String settlement_account_no, String mirror_account_no, String settlement_currency, String del_flg,
			String entity_flg, String modify_flg, String entry_user, String modify_user, String verify_user,
			Date entry_time, Date modify_time, Date verify_time) {
		super();
		this.bank_code = bank_code;
		this.bank_name = bank_name;
		this.branch_code = branch_code;
		this.branch_name = branch_name;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.district = district;
		this.city = city;
		this.country = country;
		this.state = state;
		this.web_site = web_site;
		this.landline = landline;
		this.contact_details = contact_details;
		this.contact_person = contact_person;
		this.email_id = email_id;
		this.mobile_no = mobile_no;
		this.bic_code = bic_code;
		this.swift_code = swift_code;
		this.settlement_account_name = settlement_account_name;
		this.settlement_account_no = settlement_account_no;
		this.mirror_account_no = mirror_account_no;
		this.settlement_currency = settlement_currency;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
	}
	public ParticipatingBanks_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
