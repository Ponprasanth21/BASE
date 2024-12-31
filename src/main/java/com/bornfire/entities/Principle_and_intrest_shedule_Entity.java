package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PRINCIPLE_AND_INTEREST_SCHEDULE_TABLE")
public class Principle_and_intrest_shedule_Entity {

	private String loan_account_no;
	private BigDecimal loan_amt;
	private BigDecimal no_of_instalment;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date account_creation_date;
	private BigDecimal effective_interest_rate;
	@Id
	private BigDecimal srl_no;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date installment_date;
	private String installment_description;
	private BigDecimal installment_amt;
	private BigDecimal principal_amt;
	private BigDecimal interest_amt;
	private BigDecimal charges_amt;
	private BigDecimal principal_outstanding;
	private String verify_flg;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String acct_name;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date ver_tm;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date entry_tm;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date mod_tm;
	private String ver_usr;
	private String entry_usr;
	private String mod_usr;
	private String installment_id;
	private BigDecimal total_installment;
	private Date from_date;

	public String getLoan_account_no() {
		return loan_account_no;
	}

	public void setLoan_account_no(String loan_account_no) {
		this.loan_account_no = loan_account_no;
	}

	public BigDecimal getLoan_amt() {
		return loan_amt;
	}

	public void setLoan_amt(BigDecimal loan_amt) {
		this.loan_amt = loan_amt;
	}

	public BigDecimal getNo_of_instalment() {
		return no_of_instalment;
	}

	public void setNo_of_instalment(BigDecimal no_of_instalment) {
		this.no_of_instalment = no_of_instalment;
	}

	public Date getAccount_creation_date() {
		return account_creation_date;
	}

	public void setAccount_creation_date(Date account_creation_date) {
		this.account_creation_date = account_creation_date;
	}

	public BigDecimal getEffective_interest_rate() {
		return effective_interest_rate;
	}

	public void setEffective_interest_rate(BigDecimal effective_interest_rate) {
		this.effective_interest_rate = effective_interest_rate;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public Date getInstallment_date() {
		return installment_date;
	}

	public void setInstallment_date(Date installment_date) {
		this.installment_date = installment_date;
	}

	public String getInstallment_description() {
		return installment_description;
	}

	public void setInstallment_description(String installment_description) {
		this.installment_description = installment_description;
	}

	public BigDecimal getInstallment_amt() {
		return installment_amt;
	}

	public void setInstallment_amt(BigDecimal installment_amt) {
		this.installment_amt = installment_amt;
	}

	public BigDecimal getPrincipal_amt() {
		return principal_amt;
	}

	public void setPrincipal_amt(BigDecimal principal_amt) {
		this.principal_amt = principal_amt;
	}

	public BigDecimal getInterest_amt() {
		return interest_amt;
	}

	public void setInterest_amt(BigDecimal interest_amt) {
		this.interest_amt = interest_amt;
	}

	public BigDecimal getCharges_amt() {
		return charges_amt;
	}

	public void setCharges_amt(BigDecimal charges_amt) {
		this.charges_amt = charges_amt;
	}

	public BigDecimal getPrincipal_outstanding() {
		return principal_outstanding;
	}

	public void setPrincipal_outstanding(BigDecimal principal_outstanding) {
		this.principal_outstanding = principal_outstanding;
	}

	public String getVerify_flg() {
		return verify_flg;
	}

	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
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

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public Date getVer_tm() {
		return ver_tm;
	}

	public void setVer_tm(Date ver_tm) {
		this.ver_tm = ver_tm;
	}

	public Date getEntry_tm() {
		return entry_tm;
	}

	public void setEntry_tm(Date entry_tm) {
		this.entry_tm = entry_tm;
	}

	public Date getMod_tm() {
		return mod_tm;
	}

	public void setMod_tm(Date mod_tm) {
		this.mod_tm = mod_tm;
	}

	public String getVer_usr() {
		return ver_usr;
	}

	public void setVer_usr(String ver_usr) {
		this.ver_usr = ver_usr;
	}

	public String getEntry_usr() {
		return entry_usr;
	}

	public void setEntry_usr(String entry_usr) {
		this.entry_usr = entry_usr;
	}

	public String getMod_usr() {
		return mod_usr;
	}

	public void setMod_usr(String mod_usr) {
		this.mod_usr = mod_usr;
	}

	public String getInstallment_id() {
		return installment_id;
	}

	public void setInstallment_id(String installment_id) {
		this.installment_id = installment_id;
	}

	public BigDecimal getTotal_installment() {
		return total_installment;
	}

	public void setTotal_installment(BigDecimal total_installment) {
		this.total_installment = total_installment;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public Principle_and_intrest_shedule_Entity(String loan_account_no, BigDecimal loan_amt,
			BigDecimal no_of_instalment, Date account_creation_date, BigDecimal effective_interest_rate,
			BigDecimal srl_no, Date installment_date, String installment_description, BigDecimal installment_amt,
			BigDecimal principal_amt, BigDecimal interest_amt, BigDecimal charges_amt, BigDecimal principal_outstanding,
			String verify_flg, String entity_flg, String modify_flg, String del_flg, Date ver_tm, Date entry_tm,
			Date mod_tm, String ver_usr, String entry_usr, String mod_usr, String installment_id,
			BigDecimal total_installment, Date from_date, String acct_name) {
		super();
		this.loan_account_no = loan_account_no;
		this.loan_amt = loan_amt;
		this.no_of_instalment = no_of_instalment;
		this.account_creation_date = account_creation_date;
		this.effective_interest_rate = effective_interest_rate;
		this.srl_no = srl_no;
		this.installment_date = installment_date;
		this.installment_description = installment_description;
		this.installment_amt = installment_amt;
		this.principal_amt = principal_amt;
		this.interest_amt = interest_amt;
		this.charges_amt = charges_amt;
		this.principal_outstanding = principal_outstanding;
		this.verify_flg = verify_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.ver_tm = ver_tm;
		this.entry_tm = entry_tm;
		this.mod_tm = mod_tm;
		this.ver_usr = ver_usr;
		this.entry_usr = entry_usr;
		this.mod_usr = mod_usr;
		this.installment_id = installment_id;
		this.total_installment = total_installment;
		this.from_date = from_date;
		this.acct_name = acct_name;
	}

	public Principle_and_intrest_shedule_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
