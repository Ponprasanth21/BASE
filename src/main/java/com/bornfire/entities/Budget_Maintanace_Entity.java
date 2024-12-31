package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_BUDGET_TABLE")
public class Budget_Maintanace_Entity {
	
	@Id
	private String	gl_code;
	private String	classification;
	private String	glsh_code;
	private String	glsh_desc;
	private BigDecimal	quarter_1;
	private BigDecimal	quarter_2;
	private BigDecimal	quarter_3;
	private BigDecimal	quarter_4;
	private BigDecimal	total_amnt;
	private String	entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	private String	modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	private String	verify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	verify_time;
	private String	entity_flg;
	private String	del_flg;
	private String	fin_year;
	
	private String	acct_num;
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getGlsh_code() {
		return glsh_code;
	}
	public void setGlsh_code(String glsh_code) {
		this.glsh_code = glsh_code;
	}
	public String getGlsh_desc() {
		return glsh_desc;
	}
	public void setGlsh_desc(String glsh_desc) {
		this.glsh_desc = glsh_desc;
	}
	public BigDecimal getQuarter_1() {
		return quarter_1;
	}
	public void setQuarter_1(BigDecimal quarter_1) {
		this.quarter_1 = quarter_1;
	}
	public BigDecimal getQuarter_2() {
		return quarter_2;
	}
	public void setQuarter_2(BigDecimal quarter_2) {
		this.quarter_2 = quarter_2;
	}
	public BigDecimal getQuarter_3() {
		return quarter_3;
	}
	public void setQuarter_3(BigDecimal quarter_3) {
		this.quarter_3 = quarter_3;
	}
	public BigDecimal getQuarter_4() {
		return quarter_4;
	}
	public void setQuarter_4(BigDecimal quarter_4) {
		this.quarter_4 = quarter_4;
	}
	public BigDecimal getTotal_amnt() {
		return total_amnt;
	}
	public void setTotal_amnt(BigDecimal total_amnt) {
		this.total_amnt = total_amnt;
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
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getFin_year() {
		return fin_year;
	}
	public void setFin_year(String fin_year) {
		this.fin_year = fin_year;
	}
	public String getAcct_num() {
		return acct_num;
	}
	public void setAcct_num(String acct_num) {
		this.acct_num = acct_num;
	}
	public Budget_Maintanace_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
