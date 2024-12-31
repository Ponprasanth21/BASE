package com.bornfire.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class DMD_TABLE_IDclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String loan_acct_no;
	@Id
	private String flow_code;
	@Id
	private BigDecimal srl_no;

	public String getLoan_acct_no() {
		return loan_acct_no;
	}

	public void setLoan_acct_no(String loan_acct_no) {
		this.loan_acct_no = loan_acct_no;
	}

	public String getFlow_code() {
		return flow_code;
	}

	public void setFlow_code(String flow_code) {
		this.flow_code = flow_code;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}