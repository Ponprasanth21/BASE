package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DEMAND_TBL")
@IdClass(DMD_TABLE_IDclass.class)
public class DMD_TABLE {

	private String loan_acid;
	@Id
	private String loan_acct_no;
	private String acct_name;
	@Id
	private BigDecimal flow_id;
	private String flow_frq;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date flow_date;
	@Id
	private String flow_code;
	private BigDecimal flow_amt;
	private String flow_crncy_code;
	private String tran_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date tran_date;
	private BigDecimal part_tran_id;
	private String part_tran_type;
	private String tran_crncy;
	private BigDecimal tran_amt;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date adj_dt;
	private BigDecimal adj_amt;
	private String cr_dr;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date modify_time;
	private String entry_user;
	private String modify_user;
	private String modify_flg;
	private String del_flg;
	@Id
	private BigDecimal srl_no;
	private BigDecimal no_of_rev;
	private String single_rev;

	public String getLoan_acid() {
		return loan_acid;
	}

	public void setLoan_acid(String loan_acid) {
		this.loan_acid = loan_acid;
	}

	public String getLoan_acct_no() {
		return loan_acct_no;
	}

	public void setLoan_acct_no(String loan_acct_no) {
		this.loan_acct_no = loan_acct_no;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public BigDecimal getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(BigDecimal flow_id) {
		this.flow_id = flow_id;
	}

	public String getFlow_frq() {
		return flow_frq;
	}

	public void setFlow_frq(String flow_frq) {
		this.flow_frq = flow_frq;
	}

	public Date getFlow_date() {
		return flow_date;
	}

	public void setFlow_date(Date flow_date) {
		this.flow_date = flow_date;
	}

	public String getFlow_code() {
		return flow_code;
	}

	public void setFlow_code(String flow_code) {
		this.flow_code = flow_code;
	}

	public BigDecimal getFlow_amt() {
		return flow_amt;
	}

	public void setFlow_amt(BigDecimal flow_amt) {
		this.flow_amt = flow_amt;
	}

	public String getFlow_crncy_code() {
		return flow_crncy_code;
	}

	public void setFlow_crncy_code(String flow_crncy_code) {
		this.flow_crncy_code = flow_crncy_code;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	public BigDecimal getPart_tran_id() {
		return part_tran_id;
	}

	public void setPart_tran_id(BigDecimal part_tran_id) {
		this.part_tran_id = part_tran_id;
	}

	public String getPart_tran_type() {
		return part_tran_type;
	}

	public void setPart_tran_type(String part_tran_type) {
		this.part_tran_type = part_tran_type;
	}

	public String getTran_crncy() {
		return tran_crncy;
	}

	public void setTran_crncy(String tran_crncy) {
		this.tran_crncy = tran_crncy;
	}

	public BigDecimal getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}

	public Date getAdj_dt() {
		return adj_dt;
	}

	public void setAdj_dt(Date adj_dt) {
		this.adj_dt = adj_dt;
	}

	public BigDecimal getAdj_amt() {
		return adj_amt;
	}

	public void setAdj_amt(BigDecimal adj_amt) {
		this.adj_amt = adj_amt;
	}

	public String getCr_dr() {
		return cr_dr;
	}

	public void setCr_dr(String cr_dr) {
		this.cr_dr = cr_dr;
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

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public BigDecimal getNo_of_rev() {
		return no_of_rev;
	}

	public void setNo_of_rev(BigDecimal no_of_rev) {
		this.no_of_rev = no_of_rev;
	}

	public String getSingle_rev() {
		return single_rev;
	}

	public void setSingle_rev(String single_rev) {
		this.single_rev = single_rev;
	}

	public DMD_TABLE() {
		super();
		// TODO Auto-generated constructor stub
	}

}