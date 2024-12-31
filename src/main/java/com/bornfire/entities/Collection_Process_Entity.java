package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "COLLECTION_PROCESS")
public class Collection_Process_Entity {

	private String	bank;
	private String	branch;
	private String	settlement_accountString;
	
	private BigDecimal	settlement_account_amount;
	private String	customer_name;
	
	private String	account_no;
	private String	mobile_no;
	private BigDecimal	customer_account_amount;
	
	private String	loan_acct_no;
	private String	amount_adjusted;
	private String	date_of_adjustment;
	@Id
	private String	nic_number;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSettlement_accountString() {
		return settlement_accountString;
	}
	public void setSettlement_accountString(String settlement_accountString) {
		this.settlement_accountString = settlement_accountString;
	}
	public BigDecimal getSettlement_account_amount() {
		return settlement_account_amount;
	}
	public void setSettlement_account_amount(BigDecimal settlement_account_amount) {
		this.settlement_account_amount = settlement_account_amount;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public BigDecimal getCustomer_account_amount() {
		return customer_account_amount;
	}
	public void setCustomer_account_amount(BigDecimal customer_account_amount) {
		this.customer_account_amount = customer_account_amount;
	}
	public String getLoan_acct_no() {
		return loan_acct_no;
	}
	public void setLoan_acct_no(String loan_acct_no) {
		this.loan_acct_no = loan_acct_no;
	}
	public String getAmount_adjusted() {
		return amount_adjusted;
	}
	public void setAmount_adjusted(String amount_adjusted) {
		this.amount_adjusted = amount_adjusted;
	}
	public String getDate_of_adjustment() {
		return date_of_adjustment;
	}
	public void setDate_of_adjustment(String date_of_adjustment) {
		this.date_of_adjustment = date_of_adjustment;
	}
	public String getNic_number() {
		return nic_number;
	}
	public void setNic_number(String nic_number) {
		this.nic_number = nic_number;
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
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
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
	public Collection_Process_Entity(String bank, String branch, String settlement_accountString,
			BigDecimal settlement_account_amount, String customer_name, String account_no, String mobile_no,
			BigDecimal customer_account_amount, String loan_acct_no, String amount_adjusted, String date_of_adjustment,
			String nic_number, String del_flg, String entity_flg, String modify_flg, String entry_user,
			String modify_user, String verify_user, Date entry_time, Date modify_time, Date verify_time) {
		super();
		this.bank = bank;
		this.branch = branch;
		this.settlement_accountString = settlement_accountString;
		this.settlement_account_amount = settlement_account_amount;
		this.customer_name = customer_name;
		this.account_no = account_no;
		this.mobile_no = mobile_no;
		this.customer_account_amount = customer_account_amount;
		this.loan_acct_no = loan_acct_no;
		this.amount_adjusted = amount_adjusted;
		this.date_of_adjustment = date_of_adjustment;
		this.nic_number = nic_number;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
	}
	public Collection_Process_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
