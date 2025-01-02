package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TRMWORK_VIEW")
@IdClass(BAJ_TrmView_Entity_Idclass.class)
public class BAJ_TrmView_Entity {

	private Date	value_date;
	private String	tran_type;
	private String	tran_status;
	private String	tran_rpt_code;
	private String	tran_remarks;
	private String	tran_ref_no;
	private String	tran_particular;
	@Id
	private String	tran_id;
	
	private Date	tran_date;
	private String	tran_code;
	private BigDecimal	tran_amt;
	private BigDecimal	ref_crncy_amt;
	private String	ref_crncy;
	private String	rate_code;
	private BigDecimal	rate;
	private String	post_user;
	private Date	post_time;
	private String	part_tran_type;
	@Id
	private BigDecimal	part_tran_id;
	private String	partition_type;
	private String	partition_det;
	private String	modify_user;
	private Date	modify_time;
	private String	instr_num;
	private Date	instr_date;
	private String	gst_type;
	private BigDecimal	gst_amount;
	private String entry_user;
	private Date	entry_time;
	private String	del_flg;
	private String	add_details;
	
	private String	acct_num;
	private String	acct_name;
	private String	acct_crncy;
	
	public Date getValue_date() {
		return value_date;
	}
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}
	public String getTran_type() {
		return tran_type;
	}
	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}
	public String getTran_status() {
		return tran_status;
	}
	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}
	public String getTran_rpt_code() {
		return tran_rpt_code;
	}
	public void setTran_rpt_code(String tran_rpt_code) {
		this.tran_rpt_code = tran_rpt_code;
	}
	public String getTran_remarks() {
		return tran_remarks;
	}
	public void setTran_remarks(String tran_remarks) {
		this.tran_remarks = tran_remarks;
	}
	public String getTran_ref_no() {
		return tran_ref_no;
	}
	public void setTran_ref_no(String tran_ref_no) {
		this.tran_ref_no = tran_ref_no;
	}
	public String getTran_particular() {
		return tran_particular;
	}
	public void setTran_particular(String tran_particular) {
		this.tran_particular = tran_particular;
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
	public String getTran_code() {
		return tran_code;
	}
	public void setTran_code(String tran_code) {
		this.tran_code = tran_code;
	}
	public BigDecimal getTran_amt() {
		return tran_amt;
	}
	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}
	public BigDecimal getRef_crncy_amt() {
		return ref_crncy_amt;
	}
	public void setRef_crncy_amt(BigDecimal ref_crncy_amt) {
		this.ref_crncy_amt = ref_crncy_amt;
	}
	public String getRef_crncy() {
		return ref_crncy;
	}
	public void setRef_crncy(String ref_crncy) {
		this.ref_crncy = ref_crncy;
	}
	public String getRate_code() {
		return rate_code;
	}
	public void setRate_code(String rate_code) {
		this.rate_code = rate_code;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getPost_user() {
		return post_user;
	}
	public void setPost_user(String post_user) {
		this.post_user = post_user;
	}
	public Date getPost_time() {
		return post_time;
	}
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}
	public String getPart_tran_type() {
		return part_tran_type;
	}
	public void setPart_tran_type(String part_tran_type) {
		this.part_tran_type = part_tran_type;
	}
	public BigDecimal getPart_tran_id() {
		return part_tran_id;
	}
	public void setPart_tran_id(BigDecimal part_tran_id) {
		this.part_tran_id = part_tran_id;
	}
	public String getPartition_type() {
		return partition_type;
	}
	public void setPartition_type(String partition_type) {
		this.partition_type = partition_type;
	}
	public String getPartition_det() {
		return partition_det;
	}
	public void setPartition_det(String partition_det) {
		this.partition_det = partition_det;
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
	public String getInstr_num() {
		return instr_num;
	}
	public void setInstr_num(String instr_num) {
		this.instr_num = instr_num;
	}
	public Date getInstr_date() {
		return instr_date;
	}
	public void setInstr_date(Date instr_date) {
		this.instr_date = instr_date;
	}
	public String getGst_type() {
		return gst_type;
	}
	public void setGst_type(String gst_type) {
		this.gst_type = gst_type;
	}
	public BigDecimal getGst_amount() {
		return gst_amount;
	}
	public void setGst_amount(BigDecimal gst_amount) {
		this.gst_amount = gst_amount;
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
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getAdd_details() {
		return add_details;
	}
	public void setAdd_details(String add_details) {
		this.add_details = add_details;
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
	public BAJ_TrmView_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
