package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "REPAYMENT_SCHEDULE_WORK")
@IdClass(NoticeDetailsPayment0IDCLASS.class)
public class NoticeDetailsPayment0Entity {

	private String inst_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date inst_start_dt;
	private String inst_freq;
	private BigDecimal inst_amount;
	private String no_of_inst;
	private String record_flag;
	private String verify_flg;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date ver_tm;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_tm;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date mod_tm;
	private String ver_usr;
	private String entry_usr;
	private String mod_usr;
	private String srl_no;
	private String inst_pct;
	private String maturity_flg;
	private String interest_frequency;
	private String customer_id;
	private String acid;
	@Id
	private String account_no;
	private String branch_id;

	public String getInst_id() {
		return inst_id;
	}

	public void setInst_id(String inst_id) {
		this.inst_id = inst_id;
	}

	public Date getInst_start_dt() {
		return inst_start_dt;
	}

	public void setInst_start_dt(Date inst_start_dt) {
		this.inst_start_dt = inst_start_dt;
	}

	public String getInst_freq() {
		return inst_freq;
	}

	public void setInst_freq(String inst_freq) {
		this.inst_freq = inst_freq;
	}

	public BigDecimal getInst_amount() {
		return inst_amount;
	}

	public void setInst_amount(BigDecimal inst_amount) {
		this.inst_amount = inst_amount;
	}

	public String getNo_of_inst() {
		return no_of_inst;
	}

	public void setNo_of_inst(String no_of_inst) {
		this.no_of_inst = no_of_inst;
	}

	public String getRecord_flag() {
		return record_flag;
	}

	public void setRecord_flag(String record_flag) {
		this.record_flag = record_flag;
	}

	public String getVerify_flg() {
		return verify_flg;
	}

	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
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

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public Date getVer_tm() {
		return ver_tm;
	}

	public void setVer_tm(Date ver_tm) {
		this.ver_tm = ver_tm;
	}

	public Date getEntry_tm() {
		return entry_tm;
	}

	public void setEntry_tm(Date entry_tm) {
		this.entry_tm = entry_tm;
	}

	public Date getMod_tm() {
		return mod_tm;
	}

	public void setMod_tm(Date mod_tm) {
		this.mod_tm = mod_tm;
	}

	public String getVer_usr() {
		return ver_usr;
	}

	public void setVer_usr(String ver_usr) {
		this.ver_usr = ver_usr;
	}

	public String getEntry_usr() {
		return entry_usr;
	}

	public void setEntry_usr(String entry_usr) {
		this.entry_usr = entry_usr;
	}

	public String getMod_usr() {
		return mod_usr;
	}

	public void setMod_usr(String mod_usr) {
		this.mod_usr = mod_usr;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public String getInst_pct() {
		return inst_pct;
	}

	public void setInst_pct(String inst_pct) {
		this.inst_pct = inst_pct;
	}

	public String getMaturity_flg() {
		return maturity_flg;
	}

	public void setMaturity_flg(String maturity_flg) {
		this.maturity_flg = maturity_flg;
	}

	public String getInterest_frequency() {
		return interest_frequency;
	}

	public void setInterest_frequency(String interest_frequency) {
		this.interest_frequency = interest_frequency;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	
	

	public NoticeDetailsPayment0Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
