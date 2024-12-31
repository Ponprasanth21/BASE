package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Loan_AccountMaster_Work")
public class Lease_Loan_Work_Entity {

	private String customer_id;
	private String customer_name;
	private String branch_name;
	private String branch_id;
	private String loan_type;
	@Id
	private String loan_accountno;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_of_loan;
	private BigDecimal loan_sanctioned;
	private BigDecimal margin_limit;
	private BigDecimal drawing_limit;
	private String loan_currency;
	private BigDecimal disbursement;
	private BigDecimal loan_outstanding;
	private BigDecimal loan_period;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date expiry_date;
	private String repayment_terms;
	private String recovery_method;
	private String del_flg;
	private String entity_flg;
	private String modify_flg;
	private BigDecimal effective_interest_rate;
	private String entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	private String modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date modify_time;
	private String verify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date verify_time;
	private String gl_code;
	private String gl_desc;
	private String glsh_code;
	private String glsh_desc;
	private String scheme_type;
	private String scheme_code;

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public String getLoan_accountno() {
		return loan_accountno;
	}

	public void setLoan_accountno(String loan_accountno) {
		this.loan_accountno = loan_accountno;
	}

	public Date getDate_of_loan() {
		return date_of_loan;
	}

	public void setDate_of_loan(Date date_of_loan) {
		this.date_of_loan = date_of_loan;
	}

	public BigDecimal getLoan_sanctioned() {
		return loan_sanctioned;
	}

	public void setLoan_sanctioned(BigDecimal loan_sanctioned) {
		this.loan_sanctioned = loan_sanctioned;
	}

	public BigDecimal getMargin_limit() {
		return margin_limit;
	}

	public void setMargin_limit(BigDecimal margin_limit) {
		this.margin_limit = margin_limit;
	}

	public BigDecimal getDrawing_limit() {
		return drawing_limit;
	}

	public void setDrawing_limit(BigDecimal drawing_limit) {
		this.drawing_limit = drawing_limit;
	}

	public String getLoan_currency() {
		return loan_currency;
	}

	public void setLoan_currency(String loan_currency) {
		this.loan_currency = loan_currency;
	}

	public BigDecimal getDisbursement() {
		return disbursement;
	}

	public void setDisbursement(BigDecimal disbursement) {
		this.disbursement = disbursement;
	}

	public BigDecimal getLoan_outstanding() {
		return loan_outstanding;
	}

	public void setLoan_outstanding(BigDecimal loan_outstanding) {
		this.loan_outstanding = loan_outstanding;
	}

	public BigDecimal getLoan_period() {
		return loan_period;
	}

	public void setLoan_period(BigDecimal loan_period) {
		this.loan_period = loan_period;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getRepayment_terms() {
		return repayment_terms;
	}

	public void setRepayment_terms(String repayment_terms) {
		this.repayment_terms = repayment_terms;
	}

	public String getRecovery_method() {
		return recovery_method;
	}

	public void setRecovery_method(String recovery_method) {
		this.recovery_method = recovery_method;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
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

	public BigDecimal getEffective_interest_rate() {
		return effective_interest_rate;
	}

	public void setEffective_interest_rate(BigDecimal effective_interest_rate) {
		this.effective_interest_rate = effective_interest_rate;
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

	public String getScheme_type() {
		return scheme_type;
	}

	public void setScheme_type(String scheme_type) {
		this.scheme_type = scheme_type;
	}

	public String getScheme_code() {
		return scheme_code;
	}

	public void setScheme_code(String scheme_code) {
		this.scheme_code = scheme_code;
	}

	public Lease_Loan_Work_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
