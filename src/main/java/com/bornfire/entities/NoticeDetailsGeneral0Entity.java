package com.bornfire.entities;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "DDGD0")
public class NoticeDetailsGeneral0Entity {
	private String borr_name;
	private String curr_holiday_treat;
	@Id
	private String dd_notice_ref;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dd_notice_date;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dd_value_date;
	private BigDecimal dd_amount;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dd_notice_exp_date;
	private String dd_int_pay;
	private String int_rate_ref_curr;
	private String msg_part_lenders;
	private BigDecimal loan_tenor;
	private BigDecimal loan_tenor1;
	

	private String notice_from_cust;
	
	private String srl_no;	
	private String synd_fac_ref;
	private String trnc_desc;
	private String trnc_curr;
	private String tranche_ref_int_pay;
	private String verify_flg;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date ver_tm;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date entry_tm;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date mod_tm;
	private String ver_usr;
	private String entry_usr;
	private String mod_usr;

	public String getBorr_name() {
		return borr_name;
	}

	public void setBorr_name(String borr_name) {
		this.borr_name = borr_name;
	}

	public String getCurr_holiday_treat() {
		return curr_holiday_treat;
	}

	public void setCurr_holiday_treat(String curr_holiday_treat) {
		this.curr_holiday_treat = curr_holiday_treat;
	}

	public String getDd_notice_ref() {
		return dd_notice_ref;
	}

	public void setDd_notice_ref(String dd_notice_ref) {
		this.dd_notice_ref = dd_notice_ref;
	}

	public Date getDd_notice_date() {
		return dd_notice_date;
	}

	public void setDd_notice_date(Date dd_notice_date) {
		this.dd_notice_date = dd_notice_date;
	}

	public Date getDd_value_date() {
		return dd_value_date;
	}

	public void setDd_value_date(Date dd_value_date) {
		this.dd_value_date = dd_value_date;
	}

	public BigDecimal getDd_amount() {
		return dd_amount;
	}

	public void setDd_amount(BigDecimal dd_amount) {
		this.dd_amount = dd_amount;
	}

	public Date getDd_notice_exp_date() {
		return dd_notice_exp_date;
	}

	public void setDd_notice_exp_date(Date dd_notice_exp_date) {
		this.dd_notice_exp_date = dd_notice_exp_date;
	}

	public String getDd_int_pay() {
		return dd_int_pay;
	}

	public void setDd_int_pay(String dd_int_pay) {
		this.dd_int_pay = dd_int_pay;
	}

	public String getInt_rate_ref_curr() {
		return int_rate_ref_curr;
	}

	public void setInt_rate_ref_curr(String int_rate_ref_curr) {
		this.int_rate_ref_curr = int_rate_ref_curr;
	}

	public String getMsg_part_lenders() {
		return msg_part_lenders;
	}

	public void setMsg_part_lenders(String msg_part_lenders) {
		this.msg_part_lenders = msg_part_lenders;
	}

	

	public BigDecimal getLoan_tenor() {
		return loan_tenor;
	}

	public void setLoan_tenor(BigDecimal loan_tenor) {
		this.loan_tenor = loan_tenor;
	}

	public String getNotice_from_cust() {
		return notice_from_cust;
	}

	public void setNotice_from_cust(String notice_from_cust) {
		this.notice_from_cust = notice_from_cust;
	}

	
	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public String getSynd_fac_ref() {
		return synd_fac_ref;
	}

	public void setSynd_fac_ref(String synd_fac_ref) {
		this.synd_fac_ref = synd_fac_ref;
	}

	public String getTrnc_desc() {
		return trnc_desc;
	}

	public void setTrnc_desc(String trnc_desc) {
		this.trnc_desc = trnc_desc;
	}

	public String getTrnc_curr() {
		return trnc_curr;
	}

	public void setTrnc_curr(String trnc_curr) {
		this.trnc_curr = trnc_curr;
	}

	public String getTranche_ref_int_pay() {
		return tranche_ref_int_pay;
	}

	public void setTranche_ref_int_pay(String tranche_ref_int_pay) {
		this.tranche_ref_int_pay = tranche_ref_int_pay;
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
	

	public BigDecimal getLoan_tenor1() {
		return loan_tenor1;
	}

	public void setLoan_tenor1(BigDecimal loan_tenor1) {
		this.loan_tenor1 = loan_tenor1;
	}

	public NoticeDetailsGeneral0Entity(String borr_name, String curr_holiday_treat, String dd_notice_ref,
			 Date dd_notice_date, Date dd_value_date, BigDecimal dd_amount, Date dd_notice_exp_date,

			String dd_int_pay, String int_rate_ref_curr, String msg_part_lenders, BigDecimal loan_tenor,BigDecimal loan_tenor1,

			String notice_from_cust,  String srl_no, String synd_fac_ref,
			String trnc_desc, String trnc_curr, String tranche_ref_int_pay, String verify_flg, String entity_flg,
			String modify_flg, String del_flg, Date ver_tm, Date entry_tm, Date mod_tm, String ver_usr,
			String entry_usr, String mod_usr) {
		super();
		this.borr_name = borr_name;
		this.curr_holiday_treat = curr_holiday_treat;
		this.dd_notice_ref = dd_notice_ref;
		
		this.dd_notice_date = dd_notice_date;
		this.dd_value_date = dd_value_date;
		this.dd_amount = dd_amount;
		this.dd_notice_exp_date = dd_notice_exp_date;
		this.dd_int_pay = dd_int_pay;
		this.int_rate_ref_curr = int_rate_ref_curr;
		this.msg_part_lenders = msg_part_lenders;
		this.loan_tenor = loan_tenor;
		this.loan_tenor = loan_tenor1;
		this.notice_from_cust = notice_from_cust;
	
		this.srl_no = srl_no;
		this.synd_fac_ref = synd_fac_ref;
		this.trnc_desc = trnc_desc;
		this.trnc_curr = trnc_curr;
		this.tranche_ref_int_pay = tranche_ref_int_pay;
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
	}

	public NoticeDetailsGeneral0Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
