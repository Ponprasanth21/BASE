package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

@Entity
@Table(name = "BGLS_CHART_OF_ACCOUNTS")
public class Chart_Acc_Entity {
	
	private String	classification;
	private String	acct_type;
	private String	gl_code;
	private String	gl_desc;
	private String	glsh_code;
	private String	glsh_desc;
	private String	schm_type;
	private String	schm_code;
	@Id
	private String	acct_num;
	private String	acct_name;
	private String	add_det_flg;
	private String	acct_partition;
	private String	acct_crncy;
	private String	ref_crncy;
	private String	ref_code;
	private String	ref_desc;
	private String	rpt_code;
	private String	acct_status;
	private BigDecimal	cr_amt;
	private BigDecimal	dr_amt;
	private BigDecimal	acct_bal;
	private BigDecimal	ref_crncy_bal;
	private String	entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	private String	modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	private String	auth_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	auth_time;
	private String	entity_flg;
	private String	del_flg;
	private String	acct_cls_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	acct_cls_date;
	private String	own_type;
	private String	own_remarks;
	private String	vendor_type;
	private String	vendor_name;
	private String	pan_no;
	private String	gstin;
	private String	passport;
	private String	bank_acc_name;
	private String	bank_remarks;
	private String  crncy_code;
	private String  branch_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	acct_open_date;
	private String	national_id;
	private BigDecimal	mobile_no;

	public Date getAcct_open_date() {
		return acct_open_date;
	}

	public void setAcct_open_date(Date acct_open_date) {
		this.acct_open_date = acct_open_date;
	}

	public String getNational_id() {
		return national_id;
	}

	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}

 

	public BigDecimal getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(BigDecimal mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getAcct_type() {
		return acct_type;
	}

	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}

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

	public String getSchm_type() {
		return schm_type;
	}

	public void setSchm_type(String schm_type) {
		this.schm_type = schm_type;
	}

	public String getSchm_code() {
		return schm_code;
	}

	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
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

	public String getAdd_det_flg() {
		return add_det_flg;
	}

	public void setAdd_det_flg(String add_det_flg) {
		this.add_det_flg = add_det_flg;
	}

	public String getAcct_partition() {
		return acct_partition;
	}

	public void setAcct_partition(String acct_partition) {
		this.acct_partition = acct_partition;
	}

	public String getAcct_crncy() {
		return acct_crncy;
	}

	public void setAcct_crncy(String acct_crncy) {
		this.acct_crncy = acct_crncy;
	}

	public String getRef_crncy() {
		return ref_crncy;
	}

	public void setRef_crncy(String ref_crncy) {
		this.ref_crncy = ref_crncy;
	}

	public String getRef_code() {
		return ref_code;
	}

	public void setRef_code(String ref_code) {
		this.ref_code = ref_code;
	}

	public String getRef_desc() {
		return ref_desc;
	}

	public void setRef_desc(String ref_desc) {
		this.ref_desc = ref_desc;
	}

	public String getRpt_code() {
		return rpt_code;
	}

	public void setRpt_code(String rpt_code) {
		this.rpt_code = rpt_code;
	}

	public String getAcct_status() {
		return acct_status;
	}

	public void setAcct_status(String acct_status) {
		this.acct_status = acct_status;
	}

	public BigDecimal getCr_amt() {
		return cr_amt;
	}

	public void setCr_amt(BigDecimal cr_amt) {
		this.cr_amt = cr_amt;
	}

	public BigDecimal getDr_amt() {
		return dr_amt;
	}

	public void setDr_amt(BigDecimal dr_amt) {
		this.dr_amt = dr_amt;
	}

	public BigDecimal getAcct_bal() {
		return acct_bal;
	}

	public void setAcct_bal(BigDecimal acct_bal) {
		this.acct_bal = acct_bal;
	}

	public BigDecimal getRef_crncy_bal() {
		return ref_crncy_bal;
	}

	public void setRef_crncy_bal(BigDecimal ref_crncy_bal) {
		this.ref_crncy_bal = ref_crncy_bal;
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

	public String getAuth_user() {
		return auth_user;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public Date getAuth_time() {
		return auth_time;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
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

	public String getAcct_cls_flg() {
		return acct_cls_flg;
	}

	public void setAcct_cls_flg(String acct_cls_flg) {
		this.acct_cls_flg = acct_cls_flg;
	}

	public Date getAcct_cls_date() {
		return acct_cls_date;
	}

	public void setAcct_cls_date(Date acct_cls_date) {
		this.acct_cls_date = acct_cls_date;
	}

	public String getOwn_type() {
		return own_type;
	}

	public void setOwn_type(String own_type) {
		this.own_type = own_type;
	}

	public String getOwn_remarks() {
		return own_remarks;
	}

	public void setOwn_remarks(String own_remarks) {
		this.own_remarks = own_remarks;
	}

	public String getVendor_type() {
		return vendor_type;
	}

	public void setVendor_type(String vendor_type) {
		this.vendor_type = vendor_type;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getBank_acc_name() {
		return bank_acc_name;
	}

	public void setBank_acc_name(String bank_acc_name) {
		this.bank_acc_name = bank_acc_name;
	}

	public String getBank_remarks() {
		return bank_remarks;
	}

	public void setBank_remarks(String bank_remarks) {
		this.bank_remarks = bank_remarks;
	}

	public String getCrncy_code() {
		return crncy_code;
	}

	public void setCrncy_code(String crncy_code) {
		this.crncy_code = crncy_code;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}



	public Chart_Acc_Entity(String classification, String acct_type, String gl_code, String gl_desc, String glsh_code,
			String glsh_desc, String schm_type, String schm_code, String acct_num, String acct_name, String add_det_flg,
			String acct_partition, String acct_crncy, String ref_crncy, String ref_code, String ref_desc,
			String rpt_code, String acct_status, BigDecimal cr_amt, BigDecimal dr_amt, BigDecimal acct_bal,
			BigDecimal ref_crncy_bal, String entry_user, Date entry_time, String modify_user, Date modify_time,
			String auth_user, Date auth_time, String entity_flg, String del_flg, String acct_cls_flg,
			Date acct_cls_date, String own_type, String own_remarks, String vendor_type, String vendor_name,
			String pan_no, String gstin, String passport, String bank_acc_name, String bank_remarks, String crncy_code,
			String branch_id, Date acct_open_date, String national_id, BigDecimal mobile_no) {
		super();
		this.classification = classification;
		this.acct_type = acct_type;
		this.gl_code = gl_code;
		this.gl_desc = gl_desc;
		this.glsh_code = glsh_code;
		this.glsh_desc = glsh_desc;
		this.schm_type = schm_type;
		this.schm_code = schm_code;
		this.acct_num = acct_num;
		this.acct_name = acct_name;
		this.add_det_flg = add_det_flg;
		this.acct_partition = acct_partition;
		this.acct_crncy = acct_crncy;
		this.ref_crncy = ref_crncy;
		this.ref_code = ref_code;
		this.ref_desc = ref_desc;
		this.rpt_code = rpt_code;
		this.acct_status = acct_status;
		this.cr_amt = cr_amt;
		this.dr_amt = dr_amt;
		this.acct_bal = acct_bal;
		this.ref_crncy_bal = ref_crncy_bal;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.entity_flg = entity_flg;
		this.del_flg = del_flg;
		this.acct_cls_flg = acct_cls_flg;
		this.acct_cls_date = acct_cls_date;
		this.own_type = own_type;
		this.own_remarks = own_remarks;
		this.vendor_type = vendor_type;
		this.vendor_name = vendor_name;
		this.pan_no = pan_no;
		this.gstin = gstin;
		this.passport = passport;
		this.bank_acc_name = bank_acc_name;
		this.bank_remarks = bank_remarks;
		this.crncy_code = crncy_code;
		this.branch_id = branch_id;
		this.acct_open_date = acct_open_date;
		this.national_id = national_id;
		this.mobile_no = mobile_no;
	}

	public Chart_Acc_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
