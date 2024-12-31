package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SL_TRAN_TABLE")
@IdClass(TRANIDCLASS.class)
public class SL_TRAN_TABLE_ENTITY {
	private String acct_crncy;
	private String acct_name;
	private String acct_num;
	private String acct_sol_id;
	private String acid;
	private String del_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date entry_time;
	private String entry_user;
	private String flow_desc;
	private String flow_id;
	private String flow_type;
	private String initi_sol_id;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date instr_date;
	private String instr_num;
	private String iso_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date modify_time;
	private String modify_user;
	@Id
	private BigDecimal part_tran_id;
	private String part_tran_type;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date post_time;
	private String post_user;
	private BigDecimal rate;
	private String rate_code;
	private String ref_crncy;
	private BigDecimal ref_crncy_amt;
	private String sol_id;
	private BigDecimal tran_amt;
	private String tran_code;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tran_date;
	@Id
	private String tran_id;
	private String tran_particular;
	private String tran_ref_no;
	private String tran_remarks;
	private String tran_rpt_code;
	private String tran_status;
	private String tran_type;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date value_date;
	@Id
	private String srl_no;
	private String flow_amt;
	private String modify_flg;
	private String validate_flg;
	private String fin_tran_id;

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getValidate_flg() {
		return validate_flg;
	}

	public void setValidate_flg(String validate_flg) {
		this.validate_flg = validate_flg;
	}

	public String getFin_tran_id() {
		return fin_tran_id;
	}

	public void setFin_tran_id(String fin_tran_id) {
		this.fin_tran_id = fin_tran_id;
	}

	public String getFlow_amt() {
		return flow_amt;
	}

	public void setFlow_amt(String flow_amt) {
		this.flow_amt = flow_amt;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public String getAcct_crncy() {
		return acct_crncy;
	}

	public void setAcct_crncy(String acct_crncy) {
		this.acct_crncy = acct_crncy;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(String acct_num) {
		this.acct_num = acct_num;
	}

	public String getAcct_sol_id() {
		return acct_sol_id;
	}

	public void setAcct_sol_id(String acct_sol_id) {
		this.acct_sol_id = acct_sol_id;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public String getFlow_desc() {
		return flow_desc;
	}

	public void setFlow_desc(String flow_desc) {
		this.flow_desc = flow_desc;
	}

	public String getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(String flow_id) {
		this.flow_id = flow_id;
	}

	public String getFlow_type() {
		return flow_type;
	}

	public void setFlow_type(String flow_type) {
		this.flow_type = flow_type;
	}

	public String getIniti_sol_id() {
		return initi_sol_id;
	}

	public void setIniti_sol_id(String initi_sol_id) {
		this.initi_sol_id = initi_sol_id;
	}

	public Date getInstr_date() {
		return instr_date;
	}

	public void setInstr_date(Date instr_date) {
		this.instr_date = instr_date;
	}

	public String getInstr_num() {
		return instr_num;
	}

	public void setInstr_num(String instr_num) {
		this.instr_num = instr_num;
	}

	public String getIso_flg() {
		return iso_flg;
	}

	public void setIso_flg(String iso_flg) {
		this.iso_flg = iso_flg;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
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

	public Date getPost_time() {
		return post_time;
	}

	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}

	public String getPost_user() {
		return post_user;
	}

	public void setPost_user(String post_user) {
		this.post_user = post_user;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getRate_code() {
		return rate_code;
	}

	public void setRate_code(String rate_code) {
		this.rate_code = rate_code;
	}

	public String getRef_crncy() {
		return ref_crncy;
	}

	public void setRef_crncy(String ref_crncy) {
		this.ref_crncy = ref_crncy;
	}

	public BigDecimal getRef_crncy_amt() {
		return ref_crncy_amt;
	}

	public void setRef_crncy_amt(BigDecimal ref_crncy_amt) {
		this.ref_crncy_amt = ref_crncy_amt;
	}

	public String getSol_id() {
		return sol_id;
	}

	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}

	public BigDecimal getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}

	public String getTran_code() {
		return tran_code;
	}

	public void setTran_code(String tran_code) {
		this.tran_code = tran_code;
	}

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public String getTran_particular() {
		return tran_particular;
	}

	public void setTran_particular(String tran_particular) {
		this.tran_particular = tran_particular;
	}

	public String getTran_ref_no() {
		return tran_ref_no;
	}

	public void setTran_ref_no(String tran_ref_no) {
		this.tran_ref_no = tran_ref_no;
	}

	public String getTran_remarks() {
		return tran_remarks;
	}

	public void setTran_remarks(String tran_remarks) {
		this.tran_remarks = tran_remarks;
	}

	public String getTran_rpt_code() {
		return tran_rpt_code;
	}

	public void setTran_rpt_code(String tran_rpt_code) {
		this.tran_rpt_code = tran_rpt_code;
	}

	public String getTran_status() {
		return tran_status;
	}

	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}

	public String getTran_type() {
		return tran_type;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public Date getValue_date() {
		return value_date;
	}

	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}

	public SL_TRAN_TABLE_ENTITY(String acct_crncy, String acct_name, String acct_num, String acct_sol_id, String acid,
			String del_flg, Date entry_time, String entry_user, String flow_desc, String flow_id, String flow_type,
			String initi_sol_id, Date instr_date, String instr_num, String iso_flg, Date modify_time,
			String modify_user, BigDecimal part_tran_id, String part_tran_type, Date post_time, String post_user,
			BigDecimal rate, String rate_code, String ref_crncy, BigDecimal ref_crncy_amt, String sol_id,
			BigDecimal tran_amt, String tran_code, Date tran_date, String tran_id, String tran_particular,
			String tran_ref_no, String tran_remarks, String tran_rpt_code, String tran_status, String tran_type,
			Date value_date, String srl_no, String flow_amt, String modify_flg, String validate_flg,
			String fin_tran_id) {
		super();
		this.acct_crncy = acct_crncy;
		this.acct_name = acct_name;
		this.acct_num = acct_num;
		this.acct_sol_id = acct_sol_id;
		this.acid = acid;
		this.del_flg = del_flg;
		this.entry_time = entry_time;
		this.entry_user = entry_user;
		this.flow_desc = flow_desc;
		this.flow_id = flow_id;
		this.flow_type = flow_type;
		this.initi_sol_id = initi_sol_id;
		this.instr_date = instr_date;
		this.instr_num = instr_num;
		this.iso_flg = iso_flg;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.part_tran_id = part_tran_id;
		this.part_tran_type = part_tran_type;
		this.post_time = post_time;
		this.post_user = post_user;
		this.rate = rate;
		this.rate_code = rate_code;
		this.ref_crncy = ref_crncy;
		this.ref_crncy_amt = ref_crncy_amt;
		this.sol_id = sol_id;
		this.tran_amt = tran_amt;
		this.tran_code = tran_code;
		this.tran_date = tran_date;
		this.tran_id = tran_id;
		this.tran_particular = tran_particular;
		this.tran_ref_no = tran_ref_no;
		this.tran_remarks = tran_remarks;
		this.tran_rpt_code = tran_rpt_code;
		this.tran_status = tran_status;
		this.tran_type = tran_type;
		this.value_date = value_date;
		this.srl_no = srl_no;
		this.flow_amt = flow_amt;
		this.modify_flg = modify_flg;
		this.validate_flg = validate_flg;
		this.fin_tran_id = fin_tran_id;
	}

	public SL_TRAN_TABLE_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
