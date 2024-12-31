package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_ACCESS_ROLE_TABLE")
public class Access_Role_Entity {

	@Id
	private String user_id;
	private String role_id;
	private String role_desc;
	private String permissions;
	private String work_class;
	private String admin;
	private String orgnaization_details;
	private String head_office;
	private String branches;
	private String exception;
	private String user_controls;
	private String user_profile;
	private String employee_profile;
	private String reference_code_maintenance;
	private String reference_code;
	private String gl_structure;
	private String scheme_codes;
	private String chart_of_accounts;
	private String account_ledgers;
	private String parameters;
	private String general_parameters;
	private String lease_parameters;
	private String deposit_parameters;
	private String audit_trail;
	private String maintenance_activities;
	private String business_operations;
	private String budget_controls;
	private String customer_on_boarding;
	private String customer;
	private String account;
	private String maintenance;
	private String customer_master_maintenance;
	private String account_master_maintenance;
	private String lease_accounts;
	private String deposit_accounts_c;
	private String office_accounts;
	private String document_maintenance;
	private String kyc_norms;
	private String transaction_maintenance;
	private String journal_entries;
	private String account_ledger_posting;
	private String account_ledger;
	private String trial_balance_t;
	private String profit_and_loss_account_t;
	private String lease_loans;
	private String account_maintenance_l;
	private String account_statements_l;
	private String flow_details_l;
	private String deposit_accounts;
	private String account_maintenance_d;
	private String account_statements_d;
	private String flow_details_d;
	private String inquiries_and_reports;
	private String journal_book;
	private String account_ledgers_i;
	private String trial_balance_i;
	private String general_ledger;
	private String profit_and_loss_account_i;
	private String balance_sheet;
	private String entity_flg;
	private String auth_flg;
	private String modify_flg;
	private String del_flg;
	private String entry_user;
	private String modify_user;
	private String auth_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date modify_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date auth_time;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getWork_class() {
		return work_class;
	}

	public void setWork_class(String work_class) {
		this.work_class = work_class;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getOrgnaization_details() {
		return orgnaization_details;
	}

	public void setOrgnaization_details(String orgnaization_details) {
		this.orgnaization_details = orgnaization_details;
	}

	public String getHead_office() {
		return head_office;
	}

	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}

	public String getBranches() {
		return branches;
	}

	public void setBranches(String branches) {
		this.branches = branches;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getUser_controls() {
		return user_controls;
	}

	public void setUser_controls(String user_controls) {
		this.user_controls = user_controls;
	}

	public String getUser_profile() {
		return user_profile;
	}

	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}

	public String getEmployee_profile() {
		return employee_profile;
	}

	public void setEmployee_profile(String employee_profile) {
		this.employee_profile = employee_profile;
	}

	public String getReference_code_maintenance() {
		return reference_code_maintenance;
	}

	public void setReference_code_maintenance(String reference_code_maintenance) {
		this.reference_code_maintenance = reference_code_maintenance;
	}

	public String getReference_code() {
		return reference_code;
	}

	public void setReference_code(String reference_code) {
		this.reference_code = reference_code;
	}

	public String getGl_structure() {
		return gl_structure;
	}

	public void setGl_structure(String gl_structure) {
		this.gl_structure = gl_structure;
	}

	public String getScheme_codes() {
		return scheme_codes;
	}

	public void setScheme_codes(String scheme_codes) {
		this.scheme_codes = scheme_codes;
	}

	public String getChart_of_accounts() {
		return chart_of_accounts;
	}

	public void setChart_of_accounts(String chart_of_accounts) {
		this.chart_of_accounts = chart_of_accounts;
	}

	public String getAccount_ledgers() {
		return account_ledgers;
	}

	public void setAccount_ledgers(String account_ledgers) {
		this.account_ledgers = account_ledgers;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getGeneral_parameters() {
		return general_parameters;
	}

	public void setGeneral_parameters(String general_parameters) {
		this.general_parameters = general_parameters;
	}

	public String getLease_parameters() {
		return lease_parameters;
	}

	public void setLease_parameters(String lease_parameters) {
		this.lease_parameters = lease_parameters;
	}

	public String getDeposit_parameters() {
		return deposit_parameters;
	}

	public void setDeposit_parameters(String deposit_parameters) {
		this.deposit_parameters = deposit_parameters;
	}

	public String getAudit_trail() {
		return audit_trail;
	}

	public void setAudit_trail(String audit_trail) {
		this.audit_trail = audit_trail;
	}

	public String getMaintenance_activities() {
		return maintenance_activities;
	}

	public void setMaintenance_activities(String maintenance_activities) {
		this.maintenance_activities = maintenance_activities;
	}

	public String getBusiness_operations() {
		return business_operations;
	}

	public void setBusiness_operations(String business_operations) {
		this.business_operations = business_operations;
	}

	public String getBudget_controls() {
		return budget_controls;
	}

	public void setBudget_controls(String budget_controls) {
		this.budget_controls = budget_controls;
	}

	public String getCustomer_on_boarding() {
		return customer_on_boarding;
	}

	public void setCustomer_on_boarding(String customer_on_boarding) {
		this.customer_on_boarding = customer_on_boarding;
	}

	public String getCustomer_master_maintenance() {
		return customer_master_maintenance;
	}

	public void setCustomer_master_maintenance(String customer_master_maintenance) {
		this.customer_master_maintenance = customer_master_maintenance;
	}

	public String getAccount_master_maintenance() {
		return account_master_maintenance;
	}

	public void setAccount_master_maintenance(String account_master_maintenance) {
		this.account_master_maintenance = account_master_maintenance;
	}

	public String getLease_accounts() {
		return lease_accounts;
	}

	public void setLease_accounts(String lease_accounts) {
		this.lease_accounts = lease_accounts;
	}

	public String getDeposit_accounts_c() {
		return deposit_accounts_c;
	}

	public void setDeposit_accounts_c(String deposit_accounts_c) {
		this.deposit_accounts_c = deposit_accounts_c;
	}

	public String getOffice_accounts() {
		return office_accounts;
	}

	public void setOffice_accounts(String office_accounts) {
		this.office_accounts = office_accounts;
	}

	public String getDocument_maintenance() {
		return document_maintenance;
	}

	public void setDocument_maintenance(String document_maintenance) {
		this.document_maintenance = document_maintenance;
	}

	public String getKyc_norms() {
		return kyc_norms;
	}

	public void setKyc_norms(String kyc_norms) {
		this.kyc_norms = kyc_norms;
	}

	public String getTransaction_maintenance() {
		return transaction_maintenance;
	}

	public void setTransaction_maintenance(String transaction_maintenance) {
		this.transaction_maintenance = transaction_maintenance;
	}

	public String getJournal_entries() {
		return journal_entries;
	}

	public void setJournal_entries(String journal_entries) {
		this.journal_entries = journal_entries;
	}

	public String getAccount_ledger_posting() {
		return account_ledger_posting;
	}

	public void setAccount_ledger_posting(String account_ledger_posting) {
		this.account_ledger_posting = account_ledger_posting;
	}

	public String getAccount_ledger() {
		return account_ledger;
	}

	public void setAccount_ledger(String account_ledger) {
		this.account_ledger = account_ledger;
	}

	public String getTrial_balance_t() {
		return trial_balance_t;
	}

	public void setTrial_balance_t(String trial_balance_t) {
		this.trial_balance_t = trial_balance_t;
	}

	public String getProfit_and_loss_account_t() {
		return profit_and_loss_account_t;
	}

	public void setProfit_and_loss_account_t(String profit_and_loss_account_t) {
		this.profit_and_loss_account_t = profit_and_loss_account_t;
	}

	public String getLease_loans() {
		return lease_loans;
	}

	public void setLease_loans(String lease_loans) {
		this.lease_loans = lease_loans;
	}

	public String getAccount_maintenance_l() {
		return account_maintenance_l;
	}

	public void setAccount_maintenance_l(String account_maintenance_l) {
		this.account_maintenance_l = account_maintenance_l;
	}

	public String getAccount_statements_l() {
		return account_statements_l;
	}

	public void setAccount_statements_l(String account_statements_l) {
		this.account_statements_l = account_statements_l;
	}

	public String getFlow_details_l() {
		return flow_details_l;
	}

	public void setFlow_details_l(String flow_details_l) {
		this.flow_details_l = flow_details_l;
	}

	public String getDeposit_accounts() {
		return deposit_accounts;
	}

	public void setDeposit_accounts(String deposit_accounts) {
		this.deposit_accounts = deposit_accounts;
	}

	public String getAccount_maintenance_d() {
		return account_maintenance_d;
	}

	public void setAccount_maintenance_d(String account_maintenance_d) {
		this.account_maintenance_d = account_maintenance_d;
	}

	public String getAccount_statements_d() {
		return account_statements_d;
	}

	public void setAccount_statements_d(String account_statements_d) {
		this.account_statements_d = account_statements_d;
	}

	public String getFlow_details_d() {
		return flow_details_d;
	}

	public void setFlow_details_d(String flow_details_d) {
		this.flow_details_d = flow_details_d;
	}

	public String getInquiries_and_reports() {
		return inquiries_and_reports;
	}

	public void setInquiries_and_reports(String inquiries_and_reports) {
		this.inquiries_and_reports = inquiries_and_reports;
	}

	public String getJournal_book() {
		return journal_book;
	}

	public void setJournal_book(String journal_book) {
		this.journal_book = journal_book;
	}

	public String getAccount_ledgers_i() {
		return account_ledgers_i;
	}

	public void setAccount_ledgers_i(String account_ledgers_i) {
		this.account_ledgers_i = account_ledgers_i;
	}

	public String getTrial_balance_i() {
		return trial_balance_i;
	}

	public void setTrial_balance_i(String trial_balance_i) {
		this.trial_balance_i = trial_balance_i;
	}

	public String getGeneral_ledger() {
		return general_ledger;
	}

	public void setGeneral_ledger(String general_ledger) {
		this.general_ledger = general_ledger;
	}

	public String getProfit_and_loss_account_i() {
		return profit_and_loss_account_i;
	}

	public void setProfit_and_loss_account_i(String profit_and_loss_account_i) {
		this.profit_and_loss_account_i = profit_and_loss_account_i;
	}

	public String getBalance_sheet() {
		return balance_sheet;
	}

	public void setBalance_sheet(String balance_sheet) {
		this.balance_sheet = balance_sheet;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public String getAuth_flg() {
		return auth_flg;
	}

	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
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

	public String getAuth_user() {
		return auth_user;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
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

	public Date getAuth_time() {
		return auth_time;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	public Access_Role_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
