package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_TPT_TRANSACTIONS")
public class Transaction_Pointing_Table_Entity {

	private String branch_id;
	private String org_acid;
	@Id
	private String org_tran_id;
	private BigDecimal org_part_tran_id;
	private String org_acct_num;
	private String org_acct_name;
	private String org_tran_type;
	private String org_part_tran_type;
	private String org_acct_crncy;
	private BigDecimal org_tran_amt;
	private String org_tran_particular;
	private String org_tran_remarks;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date org_tran_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date org_value_date;
	private String org_tran_ref_no;
	private String org_add_details;
	private String org_partition_type;
	private String org_partition_det;
	private BigDecimal org_gst_amount;
	private String org_gst_type;
	private BigDecimal offset_tran_amt;
	private String single_rev_flg;
	private BigDecimal bal_outstd_amt;
	private String del_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date last_offset_date;
	private BigDecimal no_of_offset_tran;

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getOrg_acid() {
		return org_acid;
	}

	public void setOrg_acid(String org_acid) {
		this.org_acid = org_acid;
	}

	public String getOrg_tran_id() {
		return org_tran_id;
	}

	public void setOrg_tran_id(String org_tran_id) {
		this.org_tran_id = org_tran_id;
	}

	public BigDecimal getOrg_part_tran_id() {
		return org_part_tran_id;
	}

	public void setOrg_part_tran_id(BigDecimal org_part_tran_id) {
		this.org_part_tran_id = org_part_tran_id;
	}

	public String getOrg_acct_num() {
		return org_acct_num;
	}

	public void setOrg_acct_num(String org_acct_num) {
		this.org_acct_num = org_acct_num;
	}

	public String getOrg_acct_name() {
		return org_acct_name;
	}

	public void setOrg_acct_name(String org_acct_name) {
		this.org_acct_name = org_acct_name;
	}

	public String getOrg_tran_type() {
		return org_tran_type;
	}

	public void setOrg_tran_type(String org_tran_type) {
		this.org_tran_type = org_tran_type;
	}

	public String getOrg_part_tran_type() {
		return org_part_tran_type;
	}

	public void setOrg_part_tran_type(String org_part_tran_type) {
		this.org_part_tran_type = org_part_tran_type;
	}

	public String getOrg_acct_crncy() {
		return org_acct_crncy;
	}

	public void setOrg_acct_crncy(String org_acct_crncy) {
		this.org_acct_crncy = org_acct_crncy;
	}

	public BigDecimal getOrg_tran_amt() {
		return org_tran_amt;
	}

	public void setOrg_tran_amt(BigDecimal org_tran_amt) {
		this.org_tran_amt = org_tran_amt;
	}

	public String getOrg_tran_particular() {
		return org_tran_particular;
	}

	public void setOrg_tran_particular(String org_tran_particular) {
		this.org_tran_particular = org_tran_particular;
	}

	public String getOrg_tran_remarks() {
		return org_tran_remarks;
	}

	public void setOrg_tran_remarks(String org_tran_remarks) {
		this.org_tran_remarks = org_tran_remarks;
	}

	public Date getOrg_tran_date() {
		return org_tran_date;
	}

	public void setOrg_tran_date(Date org_tran_date) {
		this.org_tran_date = org_tran_date;
	}

	public Date getOrg_value_date() {
		return org_value_date;
	}

	public void setOrg_value_date(Date org_value_date) {
		this.org_value_date = org_value_date;
	}

	public String getOrg_tran_ref_no() {
		return org_tran_ref_no;
	}

	public void setOrg_tran_ref_no(String org_tran_ref_no) {
		this.org_tran_ref_no = org_tran_ref_no;
	}

	public String getOrg_add_details() {
		return org_add_details;
	}

	public void setOrg_add_details(String org_add_details) {
		this.org_add_details = org_add_details;
	}

	public String getOrg_partition_type() {
		return org_partition_type;
	}

	public void setOrg_partition_type(String org_partition_type) {
		this.org_partition_type = org_partition_type;
	}

	public String getOrg_partition_det() {
		return org_partition_det;
	}

	public void setOrg_partition_det(String org_partition_det) {
		this.org_partition_det = org_partition_det;
	}

	public BigDecimal getOrg_gst_amount() {
		return org_gst_amount;
	}

	public void setOrg_gst_amount(BigDecimal org_gst_amount) {
		this.org_gst_amount = org_gst_amount;
	}

	public String getOrg_gst_type() {
		return org_gst_type;
	}

	public void setOrg_gst_type(String org_gst_type) {
		this.org_gst_type = org_gst_type;
	}

	public BigDecimal getOffset_tran_amt() {
		return offset_tran_amt;
	}

	public void setOffset_tran_amt(BigDecimal offset_tran_amt) {
		this.offset_tran_amt = offset_tran_amt;
	}

	public String getSingle_rev_flg() {
		return single_rev_flg;
	}

	public void setSingle_rev_flg(String single_rev_flg) {
		this.single_rev_flg = single_rev_flg;
	}

	public BigDecimal getBal_outstd_amt() {
		return bal_outstd_amt;
	}

	public void setBal_outstd_amt(BigDecimal bal_outstd_amt) {
		this.bal_outstd_amt = bal_outstd_amt;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public Date getLast_offset_date() {
		return last_offset_date;
	}

	public void setLast_offset_date(Date last_offset_date) {
		this.last_offset_date = last_offset_date;
	}

	public BigDecimal getNo_of_offset_tran() {
		return no_of_offset_tran;
	}

	public void setNo_of_offset_tran(BigDecimal no_of_offset_tran) {
		this.no_of_offset_tran = no_of_offset_tran;
	}

	public Transaction_Pointing_Table_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
