package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_ORG_MASTER")
public class Organization_Entity {

	@Id
	private String org_name;
	private String org_type;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_of_regn;
	private String reg_no;
	private String pan_card;
	private String tan_card;
	private String gst_ref;
	private String pf_ref;
	private BigDecimal no_of_emp;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date as_on;

	private String reg_addr_1;
	private String reg_addr_2;
	private String corp_addr_1;
	private String cor_addr_2;
	private String web_site;
	private String email;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	private String	del_flg;
	private String	modify_flg;
	private String	entity_flg;
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getOrg_type() {
		return org_type;
	}
	public void setOrg_type(String org_type) {
		this.org_type = org_type;
	}
	public Date getDate_of_regn() {
		return date_of_regn;
	}
	public void setDate_of_regn(Date date_of_regn) {
		this.date_of_regn = date_of_regn;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getPan_card() {
		return pan_card;
	}
	public void setPan_card(String pan_card) {
		this.pan_card = pan_card;
	}
	public String getTan_card() {
		return tan_card;
	}
	public void setTan_card(String tan_card) {
		this.tan_card = tan_card;
	}
	public String getGst_ref() {
		return gst_ref;
	}
	public void setGst_ref(String gst_ref) {
		this.gst_ref = gst_ref;
	}
	public String getPf_ref() {
		return pf_ref;
	}
	public void setPf_ref(String pf_ref) {
		this.pf_ref = pf_ref;
	}
	public BigDecimal getNo_of_emp() {
		return no_of_emp;
	}
	public void setNo_of_emp(BigDecimal no_of_emp) {
		this.no_of_emp = no_of_emp;
	}
	public Date getAs_on() {
		return as_on;
	}
	public void setAs_on(Date as_on) {
		this.as_on = as_on;
	}
	public String getReg_addr_1() {
		return reg_addr_1;
	}
	public void setReg_addr_1(String reg_addr_1) {
		this.reg_addr_1 = reg_addr_1;
	}
	public String getReg_addr_2() {
		return reg_addr_2;
	}
	public void setReg_addr_2(String reg_addr_2) {
		this.reg_addr_2 = reg_addr_2;
	}
	public String getCorp_addr_1() {
		return corp_addr_1;
	}
	public void setCorp_addr_1(String corp_addr_1) {
		this.corp_addr_1 = corp_addr_1;
	}
	public String getCor_addr_2() {
		return cor_addr_2;
	}
	public void setCor_addr_2(String cor_addr_2) {
		this.cor_addr_2 = cor_addr_2;
	}
	public String getWeb_site() {
		return web_site;
	}
	public void setWeb_site(String web_site) {
		this.web_site = web_site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Organization_Entity(String org_name, String org_type, Date date_of_regn, String reg_no, String pan_card,
			String tan_card, String gst_ref, String pf_ref, BigDecimal no_of_emp, Date as_on, String reg_addr_1,
			String reg_addr_2, String corp_addr_1, String cor_addr_2, String web_site, String email, String entry_user,
			String modify_user, String verify_user, Date entry_time, Date modify_time, Date verify_time, String del_flg,
			String modify_flg, String entity_flg) {
		super();
		this.org_name = org_name;
		this.org_type = org_type;
		this.date_of_regn = date_of_regn;
		this.reg_no = reg_no;
		this.pan_card = pan_card;
		this.tan_card = tan_card;
		this.gst_ref = gst_ref;
		this.pf_ref = pf_ref;
		this.no_of_emp = no_of_emp;
		this.as_on = as_on;
		this.reg_addr_1 = reg_addr_1;
		this.reg_addr_2 = reg_addr_2;
		this.corp_addr_1 = corp_addr_1;
		this.cor_addr_2 = cor_addr_2;
		this.web_site = web_site;
		this.email = email;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.del_flg = del_flg;
		this.modify_flg = modify_flg;
		this.entity_flg = entity_flg;
	}
	public Organization_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
