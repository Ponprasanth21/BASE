package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_DAILY_ACCT_BAL")
public class DAB_Entity {

	private String gl_code;
	private String gl_desc;
	private String glsh_code;
	private String glsh_desc;
	@Id
	private String acct_num;
	private String acct_name;
	private String acct_crncy;
	private BigDecimal tran_dr_bal;
	private BigDecimal tran_cr_bal;
	private BigDecimal tran_date_bal;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	  @Column(name = "TRAN_DATE")
	private Date tran_date;
	private BigDecimal tran_tot_net;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date end_tran_date;
	private String entry_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	private String del_flg;
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getGl_desc() {
		return gl_desc;
	}
	public void setGl_desc(String gl_desc) {
		this.gl_desc = gl_desc;
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
	public String getAcct_num() {
		return acct_num;
	}
	public void setAcct_num(String acct_num) {
		this.acct_num = acct_num;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public String getAcct_crncy() {
		return acct_crncy;
	}
	public void setAcct_crncy(String acct_crncy) {
		this.acct_crncy = acct_crncy;
	}
	public BigDecimal getTran_dr_bal() {
		return tran_dr_bal;
	}
	public void setTran_dr_bal(BigDecimal tran_dr_bal) {
		this.tran_dr_bal = tran_dr_bal;
	}
	public BigDecimal getTran_cr_bal() {
		return tran_cr_bal;
	}
	public void setTran_cr_bal(BigDecimal tran_cr_bal) {
		this.tran_cr_bal = tran_cr_bal;
	}
	public BigDecimal getTran_date_bal() {
		return tran_date_bal;
	}
	public void setTran_date_bal(BigDecimal tran_date_bal) {
		this.tran_date_bal = tran_date_bal;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public BigDecimal getTran_tot_net() {
		return tran_tot_net;
	}
	public void setTran_tot_net(BigDecimal tran_tot_net) {
		this.tran_tot_net = tran_tot_net;
	}
	public Date getEnd_tran_date() {
		return end_tran_date;
	}
	public void setEnd_tran_date(Date end_tran_date) {
		this.end_tran_date = end_tran_date;
	}
	public String getEntry_user_id() {
		return entry_user_id;
	}
	public void setEntry_user_id(String entry_user_id) {
		this.entry_user_id = entry_user_id;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public DAB_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
