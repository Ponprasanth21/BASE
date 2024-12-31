package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DDISD0")
public class NoticeDetailsSlabDetails0Entity {

	private String borr_name;
	private String comp_int;
	@Id
	private String dd_notice_ref;
	private String del_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date end_dt;
	private String entity_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date entry_tm;
	private String entry_usr;
	private String int_method;
	private String int_overdue_princ;
	private String int_pegged;
	private String int_polate_ch;
	private BigDecimal int_rate_period;
	private BigDecimal int_rate_period1;
	private String int_table_code;
	private String int_version_no;
	private String margin;
	private String max_int;
	private String min_int;
	private String modify_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date mod_tm;
	private String mod_usr;
	private String norm_int_rate;
	private String pegging_freq;
	private String pegging_freq1;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date pegging_review_dt;
	private String penal_int;
	private String penal_int_rate;
	private String penal_princ;
	private String reason_code;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date review_slab_start_dt;
	private String spread;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date start_dt;
	private String synd_fac_ref;
	private String trnc_curr;
	private String trnc_desc;
	private String verify_flg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date ver_tm;
	private String ver_usr;

	public String getBorr_name() {
		return borr_name;
	}

	public void setBorr_name(String borr_name) {
		this.borr_name = borr_name;
	}

	public String getComp_int() {
		return comp_int;
	}

	public void setComp_int(String comp_int) {
		this.comp_int = comp_int;
	}

	public String getDd_notice_ref() {
		return dd_notice_ref;
	}

	public void setDd_notice_ref(String dd_notice_ref) {
		this.dd_notice_ref = dd_notice_ref;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public Date getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public Date getEntry_tm() {
		return entry_tm;
	}

	public void setEntry_tm(Date entry_tm) {
		this.entry_tm = entry_tm;
	}

	public String getEntry_usr() {
		return entry_usr;
	}

	public void setEntry_usr(String entry_usr) {
		this.entry_usr = entry_usr;
	}

	public String getInt_method() {
		return int_method;
	}

	public void setInt_method(String int_method) {
		this.int_method = int_method;
	}

	public String getInt_overdue_princ() {
		return int_overdue_princ;
	}

	public void setInt_overdue_princ(String int_overdue_princ) {
		this.int_overdue_princ = int_overdue_princ;
	}

	public String getInt_pegged() {
		return int_pegged;
	}

	public void setInt_pegged(String int_pegged) {
		this.int_pegged = int_pegged;
	}

	public String getInt_polate_ch() {
		return int_polate_ch;
	}

	public void setInt_polate_ch(String int_polate_ch) {
		this.int_polate_ch = int_polate_ch;
	}

	public BigDecimal getInt_rate_period() {
		return int_rate_period;
	}

	public void setInt_rate_period(BigDecimal int_rate_period) {
		this.int_rate_period = int_rate_period;
	}

	public String getInt_table_code() {
		return int_table_code;
	}

	public void setInt_table_code(String int_table_code) {
		this.int_table_code = int_table_code;
	}

	public String getInt_version_no() {
		return int_version_no;
	}

	public void setInt_version_no(String int_version_no) {
		this.int_version_no = int_version_no;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getMax_int() {
		return max_int;
	}

	public void setMax_int(String max_int) {
		this.max_int = max_int;
	}

	public String getMin_int() {
		return min_int;
	}

	public void setMin_int(String min_int) {
		this.min_int = min_int;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public Date getMod_tm() {
		return mod_tm;
	}

	public void setMod_tm(Date mod_tm) {
		this.mod_tm = mod_tm;
	}

	public String getMod_usr() {
		return mod_usr;
	}

	public void setMod_usr(String mod_usr) {
		this.mod_usr = mod_usr;
	}

	public String getNorm_int_rate() {
		return norm_int_rate;
	}

	public void setNorm_int_rate(String norm_int_rate) {
		this.norm_int_rate = norm_int_rate;
	}

	public String getPegging_freq() {
		return pegging_freq;
	}

	public void setPegging_freq(String pegging_freq) {
		this.pegging_freq = pegging_freq;
	}

	public Date getPegging_review_dt() {
		return pegging_review_dt;
	}

	public void setPegging_review_dt(Date pegging_review_dt) {
		this.pegging_review_dt = pegging_review_dt;
	}

	public String getPenal_int() {
		return penal_int;
	}

	public void setPenal_int(String penal_int) {
		this.penal_int = penal_int;
	}

	public String getPenal_int_rate() {
		return penal_int_rate;
	}

	public void setPenal_int_rate(String penal_int_rate) {
		this.penal_int_rate = penal_int_rate;
	}

	public String getPenal_princ() {
		return penal_princ;
	}

	public void setPenal_princ(String penal_princ) {
		this.penal_princ = penal_princ;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public Date getReview_slab_start_dt() {
		return review_slab_start_dt;
	}

	public void setReview_slab_start_dt(Date review_slab_start_dt) {
		this.review_slab_start_dt = review_slab_start_dt;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public Date getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}

	public String getSynd_fac_ref() {
		return synd_fac_ref;
	}

	public void setSynd_fac_ref(String synd_fac_ref) {
		this.synd_fac_ref = synd_fac_ref;
	}

	public String getTrnc_curr() {
		return trnc_curr;
	}

	public void setTrnc_curr(String trnc_curr) {
		this.trnc_curr = trnc_curr;
	}

	public String getTrnc_desc() {
		return trnc_desc;
	}

	public void setTrnc_desc(String trnc_desc) {
		this.trnc_desc = trnc_desc;
	}

	public String getVerify_flg() {
		return verify_flg;
	}

	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}

	public Date getVer_tm() {
		return ver_tm;
	}

	public void setVer_tm(Date ver_tm) {
		this.ver_tm = ver_tm;
	}

	public String getVer_usr() {
		return ver_usr;
	}

	public void setVer_usr(String ver_usr) {
		this.ver_usr = ver_usr;
	}

	public BigDecimal getInt_rate_period1() {
		return int_rate_period1;
	}

	public void setInt_rate_period1(BigDecimal int_rate_period1) {
		this.int_rate_period1 = int_rate_period1;
	}

	public String getPegging_freq1() {
		return pegging_freq1;
	}

	public void setPegging_freq1(String pegging_freq1) {
		this.pegging_freq1 = pegging_freq1;
	}

	public NoticeDetailsSlabDetails0Entity(String borr_name, String comp_int, String dd_notice_ref, String del_flg,
			Date end_dt, String entity_flg, Date entry_tm, String entry_usr, String int_method,
			String int_overdue_princ, String int_pegged, String int_polate_ch, BigDecimal int_rate_period,
			BigDecimal int_rate_period1, String int_table_code, String int_version_no, String margin, String max_int,
			String min_int, String modify_flg, Date mod_tm, String mod_usr, String norm_int_rate, String pegging_freq,
			String pegging_freq1, Date pegging_review_dt, String penal_int, String penal_int_rate, String penal_princ,
			String reason_code, Date review_slab_start_dt, String spread, Date start_dt, String synd_fac_ref,
			String trnc_curr, String trnc_desc, String verify_flg, Date ver_tm, String ver_usr) {
		super();
		this.borr_name = borr_name;
		this.comp_int = comp_int;
		this.dd_notice_ref = dd_notice_ref;
		this.del_flg = del_flg;
		this.end_dt = end_dt;
		this.entity_flg = entity_flg;
		this.entry_tm = entry_tm;
		this.entry_usr = entry_usr;
		this.int_method = int_method;
		this.int_overdue_princ = int_overdue_princ;
		this.int_pegged = int_pegged;
		this.int_polate_ch = int_polate_ch;
		this.int_rate_period = int_rate_period;
		this.int_rate_period1 = int_rate_period1;
		this.int_table_code = int_table_code;
		this.int_version_no = int_version_no;
		this.margin = margin;
		this.max_int = max_int;
		this.min_int = min_int;
		this.modify_flg = modify_flg;
		this.mod_tm = mod_tm;
		this.mod_usr = mod_usr;
		this.norm_int_rate = norm_int_rate;
		this.pegging_freq = pegging_freq;
		this.pegging_freq1 = pegging_freq1;
		this.pegging_review_dt = pegging_review_dt;
		this.penal_int = penal_int;
		this.penal_int_rate = penal_int_rate;
		this.penal_princ = penal_princ;
		this.reason_code = reason_code;
		this.review_slab_start_dt = review_slab_start_dt;
		this.spread = spread;
		this.start_dt = start_dt;
		this.synd_fac_ref = synd_fac_ref;
		this.trnc_curr = trnc_curr;
		this.trnc_desc = trnc_desc;
		this.verify_flg = verify_flg;
		this.ver_tm = ver_tm;
		this.ver_usr = ver_usr;
	}

	public NoticeDetailsSlabDetails0Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
