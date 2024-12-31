package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BACP_AUDIT_TABLE")
public class AuditInquiries {
	@Id
	private String	audit_ref_no;
	private BigDecimal	audit_srl_no;
	private String	audit_key_no;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	audit_date;
	private String	audit_table;
	private String	audit_screen;
	private String	event_id;
	private String	event_name;
	private String	func_id;
	private String	func_details;
	private String	modi_details;
	private String	entry_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	entry_time;
	private String	modify_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	modify_time;
	private String	auth_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	auth_time;
	private String	auth_flg;
	private String	escalation_flg;
	private String	escalation_user;
	private String	esc_remarks;
	private String	kyc_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	kyc_time;
	public String getAudit_ref_no() {
		return audit_ref_no;
	}
	public void setAudit_ref_no(String audit_ref_no) {
		this.audit_ref_no = audit_ref_no;
	}
	public BigDecimal getAudit_srl_no() {
		return audit_srl_no;
	}
	public void setAudit_srl_no(BigDecimal audit_srl_no) {
		this.audit_srl_no = audit_srl_no;
	}
	public String getAudit_key_no() {
		return audit_key_no;
	}
	public void setAudit_key_no(String audit_key_no) {
		this.audit_key_no = audit_key_no;
	}
	public Date getAudit_date() {
		return audit_date;
	}
	public void setAudit_date(Date audit_date) {
		this.audit_date = audit_date;
	}
	public String getAudit_table() {
		return audit_table;
	}
	public void setAudit_table(String audit_table) {
		this.audit_table = audit_table;
	}
	public String getAudit_screen() {
		return audit_screen;
	}
	public void setAudit_screen(String audit_screen) {
		this.audit_screen = audit_screen;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getFunc_id() {
		return func_id;
	}
	public void setFunc_id(String func_id) {
		this.func_id = func_id;
	}
	public String getFunc_details() {
		return func_details;
	}
	public void setFunc_details(String func_details) {
		this.func_details = func_details;
	}
	public String getModi_details() {
		return modi_details;
	}
	public void setModi_details(String modi_details) {
		this.modi_details = modi_details;
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
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	public String getAuth_flg() {
		return auth_flg;
	}
	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}
	public String getEscalation_flg() {
		return escalation_flg;
	}
	public void setEscalation_flg(String escalation_flg) {
		this.escalation_flg = escalation_flg;
	}
	public String getEscalation_user() {
		return escalation_user;
	}
	public void setEscalation_user(String escalation_user) {
		this.escalation_user = escalation_user;
	}
	public String getEsc_remarks() {
		return esc_remarks;
	}
	public void setEsc_remarks(String esc_remarks) {
		this.esc_remarks = esc_remarks;
	}
	public String getKyc_user() {
		return kyc_user;
	}
	public void setKyc_user(String kyc_user) {
		this.kyc_user = kyc_user;
	}
	public Date getKyc_time() {
		return kyc_time;
	}
	public void setKyc_time(Date kyc_time) {
		this.kyc_time = kyc_time;
	}
	public AuditInquiries(String audit_ref_no, BigDecimal audit_srl_no, String audit_key_no, Date audit_date,
			String audit_table, String audit_screen, String event_id, String event_name, String func_id,
			String func_details, String modi_details, String entry_user, Date entry_time, String modify_user,
			Date modify_time, String auth_user, Date auth_time, String auth_flg, String escalation_flg,
			String escalation_user, String esc_remarks, String kyc_user, Date kyc_time) {
		super();
		this.audit_ref_no = audit_ref_no;
		this.audit_srl_no = audit_srl_no;
		this.audit_key_no = audit_key_no;
		this.audit_date = audit_date;
		this.audit_table = audit_table;
		this.audit_screen = audit_screen;
		this.event_id = event_id;
		this.event_name = event_name;
		this.func_id = func_id;
		this.func_details = func_details;
		this.modi_details = modi_details;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.auth_flg = auth_flg;
		this.escalation_flg = escalation_flg;
		this.escalation_user = escalation_user;
		this.esc_remarks = esc_remarks;
		this.kyc_user = kyc_user;
		this.kyc_time = kyc_time;
	}
	public AuditInquiries() {
		super();
		// TODO Auto-generated constructor stub
	}


}
