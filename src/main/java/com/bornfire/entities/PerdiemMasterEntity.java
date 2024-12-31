package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

@Entity
@Table(name = "BAJ_STAFF_PERDIEM")

public class PerdiemMasterEntity {

	@Id
	private String	emp_no;
	private String	emp_name;
	private String	emp_desig;
	private String	emp_group;
	private String	emp_division;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_birth;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_joining;
	private String	proj_name;
	private String	location;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	travel_date;
	private String	eligibility;
	private BigDecimal	eligible_amount;
	private String	eligible_currency;
	private String	fin_year;
	private String	month;
	private BigDecimal	srl_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	period_from;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	period_to;
	private BigDecimal	no_of_days;
	private BigDecimal	amount_usd;
	private BigDecimal	conv_rate;
	private BigDecimal	amount_inr;
	private BigDecimal	cum_amt_usd;
	private BigDecimal	cum_amt_inr;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_disb;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private String	payment_mode;
	private String	bank_name;
	private String	bank_acct_no;
	private String	decl_status;
	private BigDecimal	mobile_no;
	private String	email_id;
	private String	record_type;
	private String	record_srl_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	record_date;
	private String	entity_flg;
	private String	del_flg;
	private String	pay_status;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	private String	entry_user;
	private String	modify_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	private String	modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	verify_time;
	private String	verify_user;
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_desig() {
		return emp_desig;
	}
	public void setEmp_desig(String emp_desig) {
		this.emp_desig = emp_desig;
	}
	public String getEmp_group() {
		return emp_group;
	}
	public void setEmp_group(String emp_group) {
		this.emp_group = emp_group;
	}
	public String getEmp_division() {
		return emp_division;
	}
	public void setEmp_division(String emp_division) {
		this.emp_division = emp_division;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public Date getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public BigDecimal getEligible_amount() {
		return eligible_amount;
	}
	public void setEligible_amount(BigDecimal eligible_amount) {
		this.eligible_amount = eligible_amount;
	}
	public String getEligible_currency() {
		return eligible_currency;
	}
	public void setEligible_currency(String eligible_currency) {
		this.eligible_currency = eligible_currency;
	}
	public String getFin_year() {
		return fin_year;
	}
	public void setFin_year(String fin_year) {
		this.fin_year = fin_year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public BigDecimal getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}
	public Date getPeriod_from() {
		return period_from;
	}
	public void setPeriod_from(Date period_from) {
		this.period_from = period_from;
	}
	public Date getPeriod_to() {
		return period_to;
	}
	public void setPeriod_to(Date period_to) {
		this.period_to = period_to;
	}
	public BigDecimal getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(BigDecimal no_of_days) {
		this.no_of_days = no_of_days;
	}
	public BigDecimal getAmount_usd() {
		return amount_usd;
	}
	public void setAmount_usd(BigDecimal amount_usd) {
		this.amount_usd = amount_usd;
	}
	public BigDecimal getConv_rate() {
		return conv_rate;
	}
	public void setConv_rate(BigDecimal conv_rate) {
		this.conv_rate = conv_rate;
	}
	public BigDecimal getAmount_inr() {
		return amount_inr;
	}
	public void setAmount_inr(BigDecimal amount_inr) {
		this.amount_inr = amount_inr;
	}
	public BigDecimal getCum_amt_usd() {
		return cum_amt_usd;
	}
	public void setCum_amt_usd(BigDecimal cum_amt_usd) {
		this.cum_amt_usd = cum_amt_usd;
	}
	public BigDecimal getCum_amt_inr() {
		return cum_amt_inr;
	}
	public void setCum_amt_inr(BigDecimal cum_amt_inr) {
		this.cum_amt_inr = cum_amt_inr;
	}
	public Date getDate_disb() {
		return date_disb;
	}
	public void setDate_disb(Date date_disb) {
		this.date_disb = date_disb;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_acct_no() {
		return bank_acct_no;
	}
	public void setBank_acct_no(String bank_acct_no) {
		this.bank_acct_no = bank_acct_no;
	}
	public String getDecl_status() {
		return decl_status;
	}
	public void setDecl_status(String decl_status) {
		this.decl_status = decl_status;
	}
	public BigDecimal getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(BigDecimal mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getRecord_type() {
		return record_type;
	}
	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}
	public String getRecord_srl_no() {
		return record_srl_no;
	}
	public void setRecord_srl_no(String record_srl_no) {
		this.record_srl_no = record_srl_no;
	}
	public Date getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
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
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public PerdiemMasterEntity(String emp_no, String emp_name, String emp_desig, String emp_group, String emp_division,
			Date date_of_birth, Date date_of_joining, String proj_name, String location, Date travel_date,
			String eligibility, BigDecimal eligible_amount, String eligible_currency, String fin_year, String month,
			BigDecimal srl_no, Date period_from, Date period_to, BigDecimal no_of_days, BigDecimal amount_usd,
			BigDecimal conv_rate, BigDecimal amount_inr, BigDecimal cum_amt_usd, BigDecimal cum_amt_inr, Date date_disb,
			String payment_mode, String bank_name, String bank_acct_no, String decl_status, BigDecimal mobile_no,
			String email_id, String record_type, String record_srl_no, Date record_date, String entity_flg,
			String del_flg, String pay_status, Date entry_time, String entry_user, String modify_flg, Date modify_time,
			String modify_user, Date verify_time, String verify_user) {
		super();
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_desig = emp_desig;
		this.emp_group = emp_group;
		this.emp_division = emp_division;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
		this.proj_name = proj_name;
		this.location = location;
		this.travel_date = travel_date;
		this.eligibility = eligibility;
		this.eligible_amount = eligible_amount;
		this.eligible_currency = eligible_currency;
		this.fin_year = fin_year;
		this.month = month;
		this.srl_no = srl_no;
		this.period_from = period_from;
		this.period_to = period_to;
		this.no_of_days = no_of_days;
		this.amount_usd = amount_usd;
		this.conv_rate = conv_rate;
		this.amount_inr = amount_inr;
		this.cum_amt_usd = cum_amt_usd;
		this.cum_amt_inr = cum_amt_inr;
		this.date_disb = date_disb;
		this.payment_mode = payment_mode;
		this.bank_name = bank_name;
		this.bank_acct_no = bank_acct_no;
		this.decl_status = decl_status;
		this.mobile_no = mobile_no;
		this.email_id = email_id;
		this.record_type = record_type;
		this.record_srl_no = record_srl_no;
		this.record_date = record_date;
		this.entity_flg = entity_flg;
		this.del_flg = del_flg;
		this.pay_status = pay_status;
		this.entry_time = entry_time;
		this.entry_user = entry_user;
		this.modify_flg = modify_flg;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.verify_time = verify_time;
		this.verify_user = verify_user;
	}
	public PerdiemMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
