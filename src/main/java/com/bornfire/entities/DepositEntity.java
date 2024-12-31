package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BGLS_DEPOSIT_WORK")
public class DepositEntity {
	private String	branch_id;
	private String	branch_desc;
	
	private String	cust_id;
	private String	cust_name;
	private String	deposit_type;
	private String	scheme_code;
	private String	glsh_code;
	private String	glsh_desc;
	private String	gl_code;
	private String	gl_desc;
	@Id
	private String	depo_actno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	deposit_date;
	private String	deposit_period;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	maturity_date;
	private String	rate_of_int;
	private BigDecimal	int_amt;
	private String	frequency;
	private BigDecimal	deposit_amt;
	private String	del_flg;
	private String	entity_flg;
	private String verify_flg;
	private String	modify_flg;
	private String	currency;
	private String	maturity_amt;



	public DepositEntity(String branch_id, String branch_desc, String cust_id, String cust_name, String deposit_type,
			String scheme_code, String glsh_code, String glsh_desc, String gl_code, String gl_desc, String depo_actno,
			Date deposit_date, String deposit_period, Date maturity_date, String rate_of_int, BigDecimal int_amt,
			String frequency, BigDecimal deposit_amt, String del_flg, String entity_flg, String verify_flg,
			String modify_flg, String currency, String maturity_amt) {
		super();
		this.branch_id = branch_id;
		this.branch_desc = branch_desc;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.deposit_type = deposit_type;
		this.scheme_code = scheme_code;
		this.glsh_code = glsh_code;
		this.glsh_desc = glsh_desc;
		this.gl_code = gl_code;
		this.gl_desc = gl_desc;
		this.depo_actno = depo_actno;
		this.deposit_date = deposit_date;
		this.deposit_period = deposit_period;
		this.maturity_date = maturity_date;
		this.rate_of_int = rate_of_int;
		this.int_amt = int_amt;
		this.frequency = frequency;
		this.deposit_amt = deposit_amt;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.verify_flg = verify_flg;
		this.modify_flg = modify_flg;
		this.currency = currency;
		this.maturity_amt = maturity_amt;
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

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_desc() {
		return branch_desc;
	}

	public void setBranch_desc(String branch_desc) {
		this.branch_desc = branch_desc;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getDeposit_type() {
		return deposit_type;
	}

	public void setDeposit_type(String deposit_type) {
		this.deposit_type = deposit_type;
	}

	public String getScheme_code() {
		return scheme_code;
	}

	public void setScheme_code(String scheme_code) {
		this.scheme_code = scheme_code;
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

	public String getDepo_actno() {
		return depo_actno;
	}

	public void setDepo_actno(String depo_actno) {
		this.depo_actno = depo_actno;
	}

	public Date getDeposit_date() {
		return deposit_date;
	}

	public void setDeposit_date(Date deposit_date) {
		this.deposit_date = deposit_date;
	}

	public String getDeposit_period() {
		return deposit_period;
	}

	public void setDeposit_period(String deposit_period) {
		this.deposit_period = deposit_period;
	}

	public Date getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	public String getRate_of_int() {
		return rate_of_int;
	}

	public void setRate_of_int(String rate_of_int) {
		this.rate_of_int = rate_of_int;
	}

	public BigDecimal getInt_amt() {
		return int_amt;
	}

	public void setInt_amt(BigDecimal int_amt) {
		this.int_amt = int_amt;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BigDecimal getDeposit_amt() {
		return deposit_amt;
	}

	public void setDeposit_amt(BigDecimal deposit_amt) {
		this.deposit_amt = deposit_amt;
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

	public String getVerify_flg() {
		return verify_flg;
	}

	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMaturity_amt() {
		return maturity_amt;
	}

	public void setMaturity_amt(String maturity_amt) {
		this.maturity_amt = maturity_amt;
	}

	public DepositEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
