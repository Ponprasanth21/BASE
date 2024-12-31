package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="BACP_WORK_FLOW")

public class Bacp_WorkFLow_Entity {
	

	private String	workflow;
	private String	customized_flow;
	private String	del_flag;
	private String	modify_flag;
	private String	entity_flag;
	@Id
	private String	minimal_data;
	private String	customer_checks;
	private String	customer_information;
	private String	account_information;
	private String	documents_upload;
	private String	signature_capture;
	private String	photo_upload;
	private String	aof;
	private String	submission_approval;
	private String	submission_kyc;
	private String	customer_creation;
	private String	account_creation;
	private String	atm_debitcard_issue;
	private String	internet_banking;
	private String	mobile_banking;
	private String	document_archieval;
	private String	signature_upload;
	private String	account_maintenance;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date entry_time;
	private Date modify_time;
	private Date verify_time;
	
	
	public String getAccount_creation() {
		return account_creation;
	}
	public void setAccount_creation(String account_creation) {
		this.account_creation = account_creation;
	}
	public String getWorkflow() {
		return workflow;
	}
	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}
	public String getCustomized_flow() {
		return customized_flow;
	}
	public void setCustomized_flow(String customized_flow) {
		this.customized_flow = customized_flow;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public String getModify_flag() {
		return modify_flag;
	}
	public void setModify_flag(String modify_flag) {
		this.modify_flag = modify_flag;
	}
	public String getEntity_flag() {
		return entity_flag;
	}
	public void setEntity_flag(String entity_flag) {
		this.entity_flag = entity_flag;
	}
	public String getMinimal_data() {
		return minimal_data;
	}
	public void setMinimal_data(String minimal_data) {
		this.minimal_data = minimal_data;
	}
	public String getCustomer_checks() {
		return customer_checks;
	}
	public void setCustomer_checks(String customer_checks) {
		this.customer_checks = customer_checks;
	}
	public String getCustomer_information() {
		return customer_information;
	}
	public void setCustomer_information(String customer_information) {
		this.customer_information = customer_information;
	}
	public String getAccount_information() {
		return account_information;
	}
	public void setAccount_information(String account_information) {
		this.account_information = account_information;
	}
	public String getDocuments_upload() {
		return documents_upload;
	}
	public void setDocuments_upload(String documents_upload) {
		this.documents_upload = documents_upload;
	}
	public String getSignature_capture() {
		return signature_capture;
	}
	public void setSignature_capture(String signature_capture) {
		this.signature_capture = signature_capture;
	}
	public String getPhoto_upload() {
		return photo_upload;
	}
	public void setPhoto_upload(String photo_upload) {
		this.photo_upload = photo_upload;
	}
	public String getAof() {
		return aof;
	}
	public void setAof(String aof) {
		this.aof = aof;
	}
	public String getSubmission_approval() {
		return submission_approval;
	}
	public void setSubmission_approval(String submission_approval) {
		this.submission_approval = submission_approval;
	}
	public String getSubmission_kyc() {
		return submission_kyc;
	}
	public void setSubmission_kyc(String submission_kyc) {
		this.submission_kyc = submission_kyc;
	}
	public String getCustomer_creation() {
		return customer_creation;
	}
	public void setCustomer_creation(String customer_creation) {
		this.customer_creation = customer_creation;
	}
	public String getAtm_debitcard_issue() {
		return atm_debitcard_issue;
	}
	public void setAtm_debitcard_issue(String atm_debitcard_issue) {
		this.atm_debitcard_issue = atm_debitcard_issue;
	}
	public String getInternet_banking() {
		return internet_banking;
	}
	public void setInternet_banking(String internet_banking) {
		this.internet_banking = internet_banking;
	}
	public String getMobile_banking() {
		return mobile_banking;
	}
	public void setMobile_banking(String mobile_banking) {
		this.mobile_banking = mobile_banking;
	}
	public String getDocument_archieval() {
		return document_archieval;
	}
	public void setDocument_archieval(String document_archieval) {
		this.document_archieval = document_archieval;
	}
	public String getSignature_upload() {
		return signature_upload;
	}
	public void setSignature_upload(String signature_upload) {
		this.signature_upload = signature_upload;
	}
	public String getAccount_maintenance() {
		return account_maintenance;
	}
	public void setAccount_maintenance(String account_maintenance) {
		this.account_maintenance = account_maintenance;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
 
	public Bacp_WorkFLow_Entity(String workflow, String customized_flow, String del_flag, String modify_flag,
			String entity_flag, String minimal_data, String customer_checks, String customer_information,
			String account_information, String documents_upload, String signature_capture, String photo_upload,
			String aof, String submission_approval, String submission_kyc, String customer_creation,
			String account_creation, String atm_debitcard_issue, String internet_banking, String mobile_banking,
			String document_archieval, String signature_upload, String account_maintenance, String entry_user,
			String modify_user, String verify_user, Date entry_time, Date modify_time, Date verify_time) {
		super();
		this.workflow = workflow;
		this.customized_flow = customized_flow;
		this.del_flag = del_flag;
		this.modify_flag = modify_flag;
		this.entity_flag = entity_flag;
		this.minimal_data = minimal_data;
		this.customer_checks = customer_checks;
		this.customer_information = customer_information;
		this.account_information = account_information;
		this.documents_upload = documents_upload;
		this.signature_capture = signature_capture;
		this.photo_upload = photo_upload;
		this.aof = aof;
		this.submission_approval = submission_approval;
		this.submission_kyc = submission_kyc;
		this.customer_creation = customer_creation;
		this.account_creation = account_creation;
		this.atm_debitcard_issue = atm_debitcard_issue;
		this.internet_banking = internet_banking;
		this.mobile_banking = mobile_banking;
		this.document_archieval = document_archieval;
		this.signature_upload = signature_upload;
		this.account_maintenance = account_maintenance;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
	}
	public Bacp_WorkFLow_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
