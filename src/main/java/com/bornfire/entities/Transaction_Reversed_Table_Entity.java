package com.bornfire.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_RPT_TRANSACTIONS")
public class Transaction_Reversed_Table_Entity {
	private String branch_id;
	private String rev_acid;
	@Id
	private String rev_tran_id;
	private BigDecimal rev_part_tran_id;
	private String rev_acct_num;
	private String rev_acct_name;
	private String rev_tran_type;
	private String rev_part_tran_type;
	private String rev_acct_crncy;
	private BigDecimal rev_tran_amt;
	private String rev_tran_particular;
	private String rev_tran_remarks;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date rev_tran_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date rev_value_date;
	private String rev_tran_ref_no;
	private String rev_add_details;
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getRev_acid() {
		return rev_acid;
	}
	public void setRev_acid(String rev_acid) {
		this.rev_acid = rev_acid;
	}
	public String getRev_tran_id() {
		return rev_tran_id;
	}
	public void setRev_tran_id(String rev_tran_id) {
		this.rev_tran_id = rev_tran_id;
	}
	public BigDecimal getRev_part_tran_id() {
		return rev_part_tran_id;
	}
	public void setRev_part_tran_id(BigDecimal rev_part_tran_id) {
		this.rev_part_tran_id = rev_part_tran_id;
	}
	public String getRev_acct_num() {
		return rev_acct_num;
	}
	public void setRev_acct_num(String rev_acct_num) {
		this.rev_acct_num = rev_acct_num;
	}
	public String getRev_acct_name() {
		return rev_acct_name;
	}
	public void setRev_acct_name(String rev_acct_name) {
		this.rev_acct_name = rev_acct_name;
	}
	public String getRev_tran_type() {
		return rev_tran_type;
	}
	public void setRev_tran_type(String rev_tran_type) {
		this.rev_tran_type = rev_tran_type;
	}
	public String getRev_part_tran_type() {
		return rev_part_tran_type;
	}
	public void setRev_part_tran_type(String rev_part_tran_type) {
		this.rev_part_tran_type = rev_part_tran_type;
	}
	public String getRev_acct_crncy() {
		return rev_acct_crncy;
	}
	public void setRev_acct_crncy(String rev_acct_crncy) {
		this.rev_acct_crncy = rev_acct_crncy;
	}
	public BigDecimal getRev_tran_amt() {
		return rev_tran_amt;
	}
	public void setRev_tran_amt(BigDecimal rev_tran_amt) {
		this.rev_tran_amt = rev_tran_amt;
	}
	public String getRev_tran_particular() {
		return rev_tran_particular;
	}
	public void setRev_tran_particular(String rev_tran_particular) {
		this.rev_tran_particular = rev_tran_particular;
	}
	public String getRev_tran_remarks() {
		return rev_tran_remarks;
	}
	public void setRev_tran_remarks(String rev_tran_remarks) {
		this.rev_tran_remarks = rev_tran_remarks;
	}
	public Date getRev_tran_date() {
		return rev_tran_date;
	}
	public void setRev_tran_date(Date rev_tran_date) {
		this.rev_tran_date = rev_tran_date;
	}
	public Date getRev_value_date() {
		return rev_value_date;
	}
	public void setRev_value_date(Date rev_value_date) {
		this.rev_value_date = rev_value_date;
	}
	public String getRev_tran_ref_no() {
		return rev_tran_ref_no;
	}
	public void setRev_tran_ref_no(String rev_tran_ref_no) {
		this.rev_tran_ref_no = rev_tran_ref_no;
	}
	public String getRev_add_details() {
		return rev_add_details;
	}
	public void setRev_add_details(String rev_add_details) {
		this.rev_add_details = rev_add_details;
	}
	public Transaction_Reversed_Table_Entity(String branch_id, String rev_acid, String rev_tran_id,
			BigDecimal rev_part_tran_id, String rev_acct_num, String rev_acct_name, String rev_tran_type,
			String rev_part_tran_type, String rev_acct_crncy, BigDecimal rev_tran_amt, String rev_tran_particular,
			String rev_tran_remarks, Date rev_tran_date, Date rev_value_date, String rev_tran_ref_no,
			String rev_add_details) {
		super();
		this.branch_id = branch_id;
		this.rev_acid = rev_acid;
		this.rev_tran_id = rev_tran_id;
		this.rev_part_tran_id = rev_part_tran_id;
		this.rev_acct_num = rev_acct_num;
		this.rev_acct_name = rev_acct_name;
		this.rev_tran_type = rev_tran_type;
		this.rev_part_tran_type = rev_part_tran_type;
		this.rev_acct_crncy = rev_acct_crncy;
		this.rev_tran_amt = rev_tran_amt;
		this.rev_tran_particular = rev_tran_particular;
		this.rev_tran_remarks = rev_tran_remarks;
		this.rev_tran_date = rev_tran_date;
		this.rev_value_date = rev_value_date;
		this.rev_tran_ref_no = rev_tran_ref_no;
		this.rev_add_details = rev_add_details;
	}
	public Transaction_Reversed_Table_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean equalsIgnoreCase(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
