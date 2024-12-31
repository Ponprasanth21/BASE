package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Settlement_Collection_Entity {

	private String customer_id;
	private String acct_num;
	private String acct_name;
	private BigDecimal balance;
	private String flow_Code;
	private Date flow_date;
	private BigDecimal amount;
	private BigDecimal allocation;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
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
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getFlow_Code() {
		return flow_Code;
	}
	public void setFlow_Code(String flow_Code) {
		this.flow_Code = flow_Code;
	}
	public Date getFlow_date() {
		return flow_date;
	}
	public void setFlow_date(Date flow_date) {
		this.flow_date = flow_date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAllocation() {
		return allocation;
	}
	public void setAllocation(BigDecimal allocation) {
		this.allocation = allocation;
	}
	public Settlement_Collection_Entity(String customer_id, String acct_num, String acct_name, BigDecimal balance,
			String flow_Code, Date flow_date, BigDecimal amount, BigDecimal allocation) {
		super();
		this.customer_id = customer_id;
		this.acct_num = acct_num;
		this.acct_name = acct_name;
		this.balance = balance;
		this.flow_Code = flow_Code;
		this.flow_date = flow_date;
		this.amount = amount;
		this.allocation = allocation;
	}
	public Settlement_Collection_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
