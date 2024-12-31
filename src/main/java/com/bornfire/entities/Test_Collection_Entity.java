package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Test_Collection_Entity {

	private String customer_id;
	private String customer_name;
	private String loan_accountno;
	private BigDecimal loan_outstanding;
	private String flow_code;
	private BigDecimal flow_amt;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date flow_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_Of_loan;
	private BigDecimal loan_santioned;
	private BigDecimal flow_id;

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

	public String getLoan_accountno() {
		return loan_accountno;
	}

	public void setLoan_accountno(String loan_accountno) {
		this.loan_accountno = loan_accountno;
	}

	public BigDecimal getLoan_outstanding() {
		return loan_outstanding;
	}

	public void setLoan_outstanding(BigDecimal loan_outstanding) {
		this.loan_outstanding = loan_outstanding;
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

	public Date getFlow_date() {
		return flow_date;
	}

	public void setFlow_date(Date flow_date) {
		this.flow_date = flow_date;
	}

	public Date getDate_Of_loan() {
		return date_Of_loan;
	}

	public void setDate_Of_loan(Date date_Of_loan) {
		this.date_Of_loan = date_Of_loan;
	}

	public BigDecimal getLoan_santioned() {
		return loan_santioned;
	}

	public void setLoan_santioned(BigDecimal loan_santioned) {
		this.loan_santioned = loan_santioned;
	}

	public BigDecimal getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(BigDecimal flow_id) {
		this.flow_id = flow_id;
	}

	public Test_Collection_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
