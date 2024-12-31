package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "BAJ_SAL_WORK")

public class Baj_Sal_Work_Entity {
	
	
	
	private String	emp_no;
	private String	emp_name;
	private String	emp_desig;
	private String	emp_group;
	private String	emp_division;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_birth;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_joining;
	private String	spf_acct_no;
	private String	urn_no;
	
	private String salary_month;
	private BigDecimal	no_of_days;
	private BigDecimal	days_paid;
	private BigDecimal	loss_of_pay;
	private String	payment_mode;
	private String	bank_name;
	private String	bank_acct_no;
	private BigDecimal	basic_pay;
	private BigDecimal	hra;
	private BigDecimal	spl_allow;
	private BigDecimal	medi_reimb;
	private BigDecimal	conv_allow;
	private BigDecimal	lunch_allow;
	private BigDecimal	edu_allow;
	private BigDecimal	buss_attire;
	private BigDecimal	car_maint;
	private BigDecimal	leave_travel_allow;
	private BigDecimal	outstn_allow;
	private BigDecimal	annual_loyal_bonus;
	private BigDecimal	otr_allow;
	private BigDecimal	gross_salary;
	private BigDecimal	spf;
	private BigDecimal	tds;
	private BigDecimal	prof_tax;
	private BigDecimal	esi;
	private BigDecimal	recovery;
	private BigDecimal	otr_ded;
	private BigDecimal	total_deductions;
	private BigDecimal	net_salary;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_pay;
	private BigDecimal	cum_tds_fy;
	private BigDecimal	prov_it;
	private BigDecimal	tax_due;
	private BigDecimal	tax_per_month;
	private BigDecimal	ctc_amt;
	private String	decl_status;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	ctc_eff_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	ctc_end_date;
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
	private String	ifsc_code;
	private String	remarks;
	private String	aadhar_no;
	@Id
	private String	uniqueid;
	public Baj_Sal_Work_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Baj_Sal_Work_Entity(String emp_no, String emp_name, String emp_desig, String emp_group, String emp_division,
			Date date_of_birth, Date date_of_joining, String spf_acct_no, String urn_no, String salary_month,
			BigDecimal no_of_days, BigDecimal days_paid, BigDecimal loss_of_pay, String payment_mode, String bank_name,
			String bank_acct_no, BigDecimal basic_pay, BigDecimal hra, BigDecimal spl_allow, BigDecimal medi_reimb,
			BigDecimal conv_allow, BigDecimal lunch_allow, BigDecimal edu_allow, BigDecimal buss_attire,
			BigDecimal car_maint, BigDecimal leave_travel_allow, BigDecimal outstn_allow, BigDecimal annual_loyal_bonus,
			BigDecimal otr_allow, BigDecimal gross_salary, BigDecimal spf, BigDecimal tds, BigDecimal prof_tax,
			BigDecimal esi, BigDecimal recovery, BigDecimal otr_ded, BigDecimal total_deductions, BigDecimal net_salary,
			Date date_of_pay, BigDecimal cum_tds_fy, BigDecimal prov_it, BigDecimal tax_due, BigDecimal tax_per_month,
			BigDecimal ctc_amt, String decl_status, Date ctc_eff_date, Date ctc_end_date, BigDecimal mobile_no,
			String email_id, String record_type, String record_srl_no, Date record_date, String entity_flg,
			String del_flg, String pay_status, Date entry_time, String entry_user, String modify_flg, Date modify_time,
			String modify_user, Date verify_time, String verify_user, String ifsc_code, String remarks,
			String aadhar_no, String uniqueid) {
		super();
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_desig = emp_desig;
		this.emp_group = emp_group;
		this.emp_division = emp_division;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
		this.spf_acct_no = spf_acct_no;
		this.urn_no = urn_no;
		this.salary_month = salary_month;
		this.no_of_days = no_of_days;
		this.days_paid = days_paid;
		this.loss_of_pay = loss_of_pay;
		this.payment_mode = payment_mode;
		this.bank_name = bank_name;
		this.bank_acct_no = bank_acct_no;
		this.basic_pay = basic_pay;
		this.hra = hra;
		this.spl_allow = spl_allow;
		this.medi_reimb = medi_reimb;
		this.conv_allow = conv_allow;
		this.lunch_allow = lunch_allow;
		this.edu_allow = edu_allow;
		this.buss_attire = buss_attire;
		this.car_maint = car_maint;
		this.leave_travel_allow = leave_travel_allow;
		this.outstn_allow = outstn_allow;
		this.annual_loyal_bonus = annual_loyal_bonus;
		this.otr_allow = otr_allow;
		this.gross_salary = gross_salary;
		this.spf = spf;
		this.tds = tds;
		this.prof_tax = prof_tax;
		this.esi = esi;
		this.recovery = recovery;
		this.otr_ded = otr_ded;
		this.total_deductions = total_deductions;
		this.net_salary = net_salary;
		this.date_of_pay = date_of_pay;
		this.cum_tds_fy = cum_tds_fy;
		this.prov_it = prov_it;
		this.tax_due = tax_due;
		this.tax_per_month = tax_per_month;
		this.ctc_amt = ctc_amt;
		this.decl_status = decl_status;
		this.ctc_eff_date = ctc_eff_date;
		this.ctc_end_date = ctc_end_date;
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
		this.ifsc_code = ifsc_code;
		this.remarks = remarks;
		this.aadhar_no = aadhar_no;
		this.uniqueid = uniqueid;
	}
	@Override
	public String toString() {
		return "Baj_Sal_Work_Entity [emp_no=" + emp_no + ", emp_name=" + emp_name + ", emp_desig=" + emp_desig
				+ ", emp_group=" + emp_group + ", emp_division=" + emp_division + ", date_of_birth=" + date_of_birth
				+ ", date_of_joining=" + date_of_joining + ", spf_acct_no=" + spf_acct_no + ", urn_no=" + urn_no
				+ ", salary_month=" + salary_month + ", no_of_days=" + no_of_days + ", days_paid=" + days_paid
				+ ", loss_of_pay=" + loss_of_pay + ", payment_mode=" + payment_mode + ", bank_name=" + bank_name
				+ ", bank_acct_no=" + bank_acct_no + ", basic_pay=" + basic_pay + ", hra=" + hra + ", spl_allow="
				+ spl_allow + ", medi_reimb=" + medi_reimb + ", conv_allow=" + conv_allow + ", lunch_allow="
				+ lunch_allow + ", edu_allow=" + edu_allow + ", buss_attire=" + buss_attire + ", car_maint=" + car_maint
				+ ", leave_travel_allow=" + leave_travel_allow + ", outstn_allow=" + outstn_allow
				+ ", annual_loyal_bonus=" + annual_loyal_bonus + ", otr_allow=" + otr_allow + ", gross_salary="
				+ gross_salary + ", spf=" + spf + ", tds=" + tds + ", prof_tax=" + prof_tax + ", esi=" + esi
				+ ", recovery=" + recovery + ", otr_ded=" + otr_ded + ", total_deductions=" + total_deductions
				+ ", net_salary=" + net_salary + ", date_of_pay=" + date_of_pay + ", cum_tds_fy=" + cum_tds_fy
				+ ", prov_it=" + prov_it + ", tax_due=" + tax_due + ", tax_per_month=" + tax_per_month + ", ctc_amt="
				+ ctc_amt + ", decl_status=" + decl_status + ", ctc_eff_date=" + ctc_eff_date + ", ctc_end_date="
				+ ctc_end_date + ", mobile_no=" + mobile_no + ", email_id=" + email_id + ", record_type=" + record_type
				+ ", record_srl_no=" + record_srl_no + ", record_date=" + record_date + ", entity_flg=" + entity_flg
				+ ", del_flg=" + del_flg + ", pay_status=" + pay_status + ", entry_time=" + entry_time + ", entry_user="
				+ entry_user + ", modify_flg=" + modify_flg + ", modify_time=" + modify_time + ", modify_user="
				+ modify_user + ", verify_time=" + verify_time + ", verify_user=" + verify_user + ", ifsc_code="
				+ ifsc_code + ", remarks=" + remarks + ", aadhar_no=" + aadhar_no + ", uniqueid=" + uniqueid + "]";
	}
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
	public String getSpf_acct_no() {
		return spf_acct_no;
	}
	public void setSpf_acct_no(String spf_acct_no) {
		this.spf_acct_no = spf_acct_no;
	}
	public String getUrn_no() {
		return urn_no;
	}
	public void setUrn_no(String urn_no) {
		this.urn_no = urn_no;
	}
	public String getSalary_month() {
		return salary_month;
	}
	public void setSalary_month(String salary_month) {
		this.salary_month = salary_month;
	}
	public BigDecimal getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(BigDecimal no_of_days) {
		this.no_of_days = no_of_days;
	}
	public BigDecimal getDays_paid() {
		return days_paid;
	}
	public void setDays_paid(BigDecimal days_paid) {
		this.days_paid = days_paid;
	}
	public BigDecimal getLoss_of_pay() {
		return loss_of_pay;
	}
	public void setLoss_of_pay(BigDecimal loss_of_pay) {
		this.loss_of_pay = loss_of_pay;
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
	public BigDecimal getBasic_pay() {
		return basic_pay;
	}
	public void setBasic_pay(BigDecimal basic_pay) {
		this.basic_pay = basic_pay;
	}
	public BigDecimal getHra() {
		return hra;
	}
	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}
	public BigDecimal getSpl_allow() {
		return spl_allow;
	}
	public void setSpl_allow(BigDecimal spl_allow) {
		this.spl_allow = spl_allow;
	}
	public BigDecimal getMedi_reimb() {
		return medi_reimb;
	}
	public void setMedi_reimb(BigDecimal medi_reimb) {
		this.medi_reimb = medi_reimb;
	}
	public BigDecimal getConv_allow() {
		return conv_allow;
	}
	public void setConv_allow(BigDecimal conv_allow) {
		this.conv_allow = conv_allow;
	}
	public BigDecimal getLunch_allow() {
		return lunch_allow;
	}
	public void setLunch_allow(BigDecimal lunch_allow) {
		this.lunch_allow = lunch_allow;
	}
	public BigDecimal getEdu_allow() {
		return edu_allow;
	}
	public void setEdu_allow(BigDecimal edu_allow) {
		this.edu_allow = edu_allow;
	}
	public BigDecimal getBuss_attire() {
		return buss_attire;
	}
	public void setBuss_attire(BigDecimal buss_attire) {
		this.buss_attire = buss_attire;
	}
	public BigDecimal getCar_maint() {
		return car_maint;
	}
	public void setCar_maint(BigDecimal car_maint) {
		this.car_maint = car_maint;
	}
	public BigDecimal getLeave_travel_allow() {
		return leave_travel_allow;
	}
	public void setLeave_travel_allow(BigDecimal leave_travel_allow) {
		this.leave_travel_allow = leave_travel_allow;
	}
	public BigDecimal getOutstn_allow() {
		return outstn_allow;
	}
	public void setOutstn_allow(BigDecimal outstn_allow) {
		this.outstn_allow = outstn_allow;
	}
	public BigDecimal getAnnual_loyal_bonus() {
		return annual_loyal_bonus;
	}
	public void setAnnual_loyal_bonus(BigDecimal annual_loyal_bonus) {
		this.annual_loyal_bonus = annual_loyal_bonus;
	}
	public BigDecimal getOtr_allow() {
		return otr_allow;
	}
	public void setOtr_allow(BigDecimal otr_allow) {
		this.otr_allow = otr_allow;
	}
	public BigDecimal getGross_salary() {
		return gross_salary;
	}
	public void setGross_salary(BigDecimal gross_salary) {
		this.gross_salary = gross_salary;
	}
	public BigDecimal getSpf() {
		return spf;
	}
	public void setSpf(BigDecimal spf) {
		this.spf = spf;
	}
	public BigDecimal getTds() {
		return tds;
	}
	public void setTds(BigDecimal tds) {
		this.tds = tds;
	}
	public BigDecimal getProf_tax() {
		return prof_tax;
	}
	public void setProf_tax(BigDecimal prof_tax) {
		this.prof_tax = prof_tax;
	}
	public BigDecimal getEsi() {
		return esi;
	}
	public void setEsi(BigDecimal esi) {
		this.esi = esi;
	}
	public BigDecimal getRecovery() {
		return recovery;
	}
	public void setRecovery(BigDecimal recovery) {
		this.recovery = recovery;
	}
	public BigDecimal getOtr_ded() {
		return otr_ded;
	}
	public void setOtr_ded(BigDecimal otr_ded) {
		this.otr_ded = otr_ded;
	}
	public BigDecimal getTotal_deductions() {
		return total_deductions;
	}
	public void setTotal_deductions(BigDecimal total_deductions) {
		this.total_deductions = total_deductions;
	}
	public BigDecimal getNet_salary() {
		return net_salary;
	}
	public void setNet_salary(BigDecimal net_salary) {
		this.net_salary = net_salary;
	}
	public Date getDate_of_pay() {
		return date_of_pay;
	}
	public void setDate_of_pay(Date date_of_pay) {
		this.date_of_pay = date_of_pay;
	}
	public BigDecimal getCum_tds_fy() {
		return cum_tds_fy;
	}
	public void setCum_tds_fy(BigDecimal cum_tds_fy) {
		this.cum_tds_fy = cum_tds_fy;
	}
	public BigDecimal getProv_it() {
		return prov_it;
	}
	public void setProv_it(BigDecimal prov_it) {
		this.prov_it = prov_it;
	}
	public BigDecimal getTax_due() {
		return tax_due;
	}
	public void setTax_due(BigDecimal tax_due) {
		this.tax_due = tax_due;
	}
	public BigDecimal getTax_per_month() {
		return tax_per_month;
	}
	public void setTax_per_month(BigDecimal tax_per_month) {
		this.tax_per_month = tax_per_month;
	}
	public BigDecimal getCtc_amt() {
		return ctc_amt;
	}
	public void setCtc_amt(BigDecimal ctc_amt) {
		this.ctc_amt = ctc_amt;
	}
	public String getDecl_status() {
		return decl_status;
	}
	public void setDecl_status(String decl_status) {
		this.decl_status = decl_status;
	}
	public Date getCtc_eff_date() {
		return ctc_eff_date;
	}
	public void setCtc_eff_date(Date ctc_eff_date) {
		this.ctc_eff_date = ctc_eff_date;
	}
	public Date getCtc_end_date() {
		return ctc_end_date;
	}
	public void setCtc_end_date(Date ctc_end_date) {
		this.ctc_end_date = ctc_end_date;
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
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	
	
	

	
}
