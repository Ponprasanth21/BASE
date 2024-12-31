package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="BGLS_TD_DEFN_TABLE")
@IdClass(Td_defn_table_Idclass.class)
public class Td_defn_table {

	@Id
	private String	acid;
	private String	srl_num;
	private String	tsd_srl_num;
	private String	flow_code;
	private Date	flow_date;
	private BigDecimal	flow_amt;
	private Date	value_date;
	private BigDecimal	tran_amt;
	private BigDecimal	number_pcnt;
	private BigDecimal	clr_bal_amt;
	private BigDecimal	dep_period_mths;
	private BigDecimal	dep_period_days;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	rcre_user_id;
	private Date	rcre_time;
	private BigDecimal	number_amt_before_tax;
	private BigDecimal	ts_cnt;
	private BigDecimal	actual_number_pcnt;
	private String	tdt_crncy_code;
	private String	bank_id;
	private String	installment_status;
	private String	loc_flow_date_yyyymmdd;
	private BigDecimal	residual_bal;
	private String	branch_id;
	private String	cust_id;
	private String  tran_id;
	private String  int_rate;
	private Date    tran_date;
	private BigDecimal  part_tran_id;
	@Id
	private BigDecimal srl_no;
	@Id
	private BigDecimal flow_id;
	private String entry_user;
	private String modify_user;
	private String del_flg;
	private String modify_flg;
	private Date entry_time;
	private Date modify_time;

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getSrl_num() {
		return srl_num;
	}

	public void setSrl_num(String srl_num) {
		this.srl_num = srl_num;
	}

	public String getTsd_srl_num() {
		return tsd_srl_num;
	}

	public void setTsd_srl_num(String tsd_srl_num) {
		this.tsd_srl_num = tsd_srl_num;
	}

	public String getFlow_code() {
		return flow_code;
	}

	public void setFlow_code(String flow_code) {
		this.flow_code = flow_code;
	}

	public Date getFlow_date() {
		return flow_date;
	}

	public void setFlow_date(Date flow_date) {
		this.flow_date = flow_date;
	}

	public BigDecimal getFlow_amt() {
		return flow_amt;
	}

	public void setFlow_amt(BigDecimal flow_amt) {
		this.flow_amt = flow_amt;
	}

	public Date getValue_date() {
		return value_date;
	}

	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}

	public BigDecimal getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}

	public BigDecimal getNumber_pcnt() {
		return number_pcnt;
	}

	public void setNumber_pcnt(BigDecimal number_pcnt) {
		this.number_pcnt = number_pcnt;
	}

	public BigDecimal getClr_bal_amt() {
		return clr_bal_amt;
	}

	public void setClr_bal_amt(BigDecimal clr_bal_amt) {
		this.clr_bal_amt = clr_bal_amt;
	}

	public BigDecimal getDep_period_mths() {
		return dep_period_mths;
	}

	public void setDep_period_mths(BigDecimal dep_period_mths) {
		this.dep_period_mths = dep_period_mths;
	}

	public BigDecimal getDep_period_days() {
		return dep_period_days;
	}

	public void setDep_period_days(BigDecimal dep_period_days) {
		this.dep_period_days = dep_period_days;
	}

	public String getLchg_user_id() {
		return lchg_user_id;
	}

	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}

	public Date getLchg_time() {
		return lchg_time;
	}

	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}

	public String getRcre_user_id() {
		return rcre_user_id;
	}

	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}

	public Date getRcre_time() {
		return rcre_time;
	}

	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}

	public BigDecimal getNumber_amt_before_tax() {
		return number_amt_before_tax;
	}

	public void setNumber_amt_before_tax(BigDecimal number_amt_before_tax) {
		this.number_amt_before_tax = number_amt_before_tax;
	}

	public BigDecimal getTs_cnt() {
		return ts_cnt;
	}

	public void setTs_cnt(BigDecimal ts_cnt) {
		this.ts_cnt = ts_cnt;
	}

	public BigDecimal getActual_number_pcnt() {
		return actual_number_pcnt;
	}

	public void setActual_number_pcnt(BigDecimal actual_number_pcnt) {
		this.actual_number_pcnt = actual_number_pcnt;
	}

	public String getTdt_crncy_code() {
		return tdt_crncy_code;
	}

	public void setTdt_crncy_code(String tdt_crncy_code) {
		this.tdt_crncy_code = tdt_crncy_code;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getInstallment_status() {
		return installment_status;
	}

	public void setInstallment_status(String installment_status) {
		this.installment_status = installment_status;
	}

	public String getLoc_flow_date_yyyymmdd() {
		return loc_flow_date_yyyymmdd;
	}

	public void setLoc_flow_date_yyyymmdd(String loc_flow_date_yyyymmdd) {
		this.loc_flow_date_yyyymmdd = loc_flow_date_yyyymmdd;
	}

	public BigDecimal getResidual_bal() {
		return residual_bal;
	}

	public void setResidual_bal(BigDecimal residual_bal) {
		this.residual_bal = residual_bal;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public String getInt_rate() {
		return int_rate;
	}

	public void setInt_rate(String int_rate) {
		this.int_rate = int_rate;
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

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public BigDecimal getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(BigDecimal flow_id) {
		this.flow_id = flow_id;
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

	public Td_defn_table() {
		super();
		// TODO Auto-generated constructor stub
	}

}
