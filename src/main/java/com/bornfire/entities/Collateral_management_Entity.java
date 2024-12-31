package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BGLS_COLLATERAL_MANAGEMENT")
public class Collateral_management_Entity 
{
	private String	branch_code;
	private String	branch_name;
	@Id
	private String	customer_id;
	private String	customer_name;
	private String	loan_type;
	private BigDecimal	loan_account_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_loan;
	private String	loan_currency;
	private BigDecimal	amount_sanctioned;
	private BigDecimal	drawing_limit;
	private BigDecimal	disbursement_amount;
	private BigDecimal	loan_outstanding;
	private BigDecimal	loan_period;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	expiry_date;
	private BigDecimal	repayment_terms;
	private String	recovery_method;
	private BigDecimal	collateral_ref_no;
	private BigDecimal	no_of_collaterals;
	private BigDecimal	collateral_serial_no;
	private String	apportionment_flag;
	private String	collateral_type;
	private String	description;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_purchase;
	private BigDecimal	original_value;
	private String	collateral_description;
	private String	ownership;
	private String	location;
	private BigDecimal	date_of_purchase_p;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_valuation;
	private String	valuer_details;
	private BigDecimal	market_value;
	private BigDecimal	insured_value;
	private BigDecimal	max_allowable_amount;
	private BigDecimal	apportionment_amount;
	private String	apportionment_details;
	private String	other_loans;
	private BigDecimal	life_of_property;
	private String	depreciation_flag;
	private String	depreciation_method;
	private String	calculation_type;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	last_depreciation_date;
	private BigDecimal	depreciation_percentage;
	private BigDecimal	depreciation_amount;
	private BigDecimal	accumulated_depreciation;
	private String	collateral_nature;
	private String	valuation_type;
	private String	valuation_method;
	private String	property_details;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	mortgage_date;
	private String	mortgage_details;
	private BigDecimal	mortgage_value;
	private String	remarks_i;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_installation;
	private BigDecimal	commissioning_cost;
	private BigDecimal	holiday_period;
	private BigDecimal	no_of_items;
	private BigDecimal	gross_weight;
	private BigDecimal	net_weight;
	private String	appraiser_name;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	appraisal_date;
	private BigDecimal	appraisal_value;
	private BigDecimal	market_value_v;
	private String	vehicle_type;
	private String	brand;
	private String	make;
	private String	model;
	private String	insurance_company_v;
	private BigDecimal	insured_value_v;
	private BigDecimal	policy_no_v;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	expiry_date_v;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	statement_date;
	private BigDecimal	stock_value;
	private BigDecimal	eligible_stock_value;
	private String	remarks_v;
	private String	insurance_company_b;
	private BigDecimal	insured_value_b;
	private BigDecimal	policy_no_b;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	expiry_date_b;
	private String	company_name_s;
	private BigDecimal	no_of_certificates;
	private BigDecimal	certificate_serial;
	private BigDecimal	face_value;
	private String	guarantor_name;
	private String	network;
	private String	address;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_of_inspection;
	private String	name_of_inspector;
	private String	collateral_location;
	private String	remarks_b;
	private BigDecimal	gen_amount;
	private BigDecimal	gen_book_value;
	private String	gen_delete_flg;
	private BigDecimal	gen_depreciation;
	private String	gen_flow_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	gen_flow_strt_date;
	private String	gen_frequency;
	private String	gen_method;
	private String	gen_modify_flg;
	private BigDecimal	gen_original_cost;
	private String	gen_percentage;
	private String	gen_remarks;
	private String	gen_roll_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	gen_tran_date;
	private String	gen_tran_id;
	private String	gen_verify_flg;
	private String	life_span_months;
	private BigDecimal	original_cost;
	private String	sale_flg;
	private String	transfer_details;
	private String	writeoff_flg;
	private String  book_value;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	year_of_purchase;
	private String	description_g;
	private String	national_id_card;
	private String	entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	entry_time;
	private String	auth_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	auth_time;
	private String	modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	modify_time;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public BigDecimal getLoan_account_no() {
		return loan_account_no;
	}
	public void setLoan_account_no(BigDecimal loan_account_no) {
		this.loan_account_no = loan_account_no;
	}
	public Date getDate_of_loan() {
		return date_of_loan;
	}
	public void setDate_of_loan(Date date_of_loan) {
		this.date_of_loan = date_of_loan;
	}
	public String getLoan_currency() {
		return loan_currency;
	}
	public void setLoan_currency(String loan_currency) {
		this.loan_currency = loan_currency;
	}
	public BigDecimal getAmount_sanctioned() {
		return amount_sanctioned;
	}
	public void setAmount_sanctioned(BigDecimal amount_sanctioned) {
		this.amount_sanctioned = amount_sanctioned;
	}
	public BigDecimal getDrawing_limit() {
		return drawing_limit;
	}
	public void setDrawing_limit(BigDecimal drawing_limit) {
		this.drawing_limit = drawing_limit;
	}
	public BigDecimal getDisbursement_amount() {
		return disbursement_amount;
	}
	public void setDisbursement_amount(BigDecimal disbursement_amount) {
		this.disbursement_amount = disbursement_amount;
	}
	public BigDecimal getLoan_outstanding() {
		return loan_outstanding;
	}
	public void setLoan_outstanding(BigDecimal loan_outstanding) {
		this.loan_outstanding = loan_outstanding;
	}
	public BigDecimal getLoan_period() {
		return loan_period;
	}
	public void setLoan_period(BigDecimal loan_period) {
		this.loan_period = loan_period;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public BigDecimal getRepayment_terms() {
		return repayment_terms;
	}
	public void setRepayment_terms(BigDecimal repayment_terms) {
		this.repayment_terms = repayment_terms;
	}
	public String getRecovery_method() {
		return recovery_method;
	}
	public void setRecovery_method(String recovery_method) {
		this.recovery_method = recovery_method;
	}
	public BigDecimal getCollateral_ref_no() {
		return collateral_ref_no;
	}
	public void setCollateral_ref_no(BigDecimal collateral_ref_no) {
		this.collateral_ref_no = collateral_ref_no;
	}
	public BigDecimal getNo_of_collaterals() {
		return no_of_collaterals;
	}
	public void setNo_of_collaterals(BigDecimal no_of_collaterals) {
		this.no_of_collaterals = no_of_collaterals;
	}
	public BigDecimal getCollateral_serial_no() {
		return collateral_serial_no;
	}
	public void setCollateral_serial_no(BigDecimal collateral_serial_no) {
		this.collateral_serial_no = collateral_serial_no;
	}
	public String getApportionment_flag() {
		return apportionment_flag;
	}
	public void setApportionment_flag(String apportionment_flag) {
		this.apportionment_flag = apportionment_flag;
	}
	public String getCollateral_type() {
		return collateral_type;
	}
	public void setCollateral_type(String collateral_type) {
		this.collateral_type = collateral_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(Date date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}
	public BigDecimal getOriginal_value() {
		return original_value;
	}
	public void setOriginal_value(BigDecimal original_value) {
		this.original_value = original_value;
	}
	public String getCollateral_description() {
		return collateral_description;
	}
	public void setCollateral_description(String collateral_description) {
		this.collateral_description = collateral_description;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public BigDecimal getDate_of_purchase_p() {
		return date_of_purchase_p;
	}
	public void setDate_of_purchase_p(BigDecimal date_of_purchase_p) {
		this.date_of_purchase_p = date_of_purchase_p;
	}
	public Date getDate_of_valuation() {
		return date_of_valuation;
	}
	public void setDate_of_valuation(Date date_of_valuation) {
		this.date_of_valuation = date_of_valuation;
	}
	public String getValuer_details() {
		return valuer_details;
	}
	public void setValuer_details(String valuer_details) {
		this.valuer_details = valuer_details;
	}
	public BigDecimal getMarket_value() {
		return market_value;
	}
	public void setMarket_value(BigDecimal market_value) {
		this.market_value = market_value;
	}
	public BigDecimal getInsured_value() {
		return insured_value;
	}
	public void setInsured_value(BigDecimal insured_value) {
		this.insured_value = insured_value;
	}
	public BigDecimal getMax_allowable_amount() {
		return max_allowable_amount;
	}
	public void setMax_allowable_amount(BigDecimal max_allowable_amount) {
		this.max_allowable_amount = max_allowable_amount;
	}
	public BigDecimal getApportionment_amount() {
		return apportionment_amount;
	}
	public void setApportionment_amount(BigDecimal apportionment_amount) {
		this.apportionment_amount = apportionment_amount;
	}
	public String getApportionment_details() {
		return apportionment_details;
	}
	public void setApportionment_details(String apportionment_details) {
		this.apportionment_details = apportionment_details;
	}
	public String getOther_loans() {
		return other_loans;
	}
	public void setOther_loans(String other_loans) {
		this.other_loans = other_loans;
	}
	public BigDecimal getLife_of_property() {
		return life_of_property;
	}
	public void setLife_of_property(BigDecimal life_of_property) {
		this.life_of_property = life_of_property;
	}
	public String getDepreciation_flag() {
		return depreciation_flag;
	}
	public void setDepreciation_flag(String depreciation_flag) {
		this.depreciation_flag = depreciation_flag;
	}
	public String getDepreciation_method() {
		return depreciation_method;
	}
	public void setDepreciation_method(String depreciation_method) {
		this.depreciation_method = depreciation_method;
	}
	public String getCalculation_type() {
		return calculation_type;
	}
	public void setCalculation_type(String calculation_type) {
		this.calculation_type = calculation_type;
	}
	public Date getLast_depreciation_date() {
		return last_depreciation_date;
	}
	public void setLast_depreciation_date(Date last_depreciation_date) {
		this.last_depreciation_date = last_depreciation_date;
	}
	public BigDecimal getDepreciation_percentage() {
		return depreciation_percentage;
	}
	public void setDepreciation_percentage(BigDecimal depreciation_percentage) {
		this.depreciation_percentage = depreciation_percentage;
	}
	public BigDecimal getDepreciation_amount() {
		return depreciation_amount;
	}
	public void setDepreciation_amount(BigDecimal depreciation_amount) {
		this.depreciation_amount = depreciation_amount;
	}
	public BigDecimal getAccumulated_depreciation() {
		return accumulated_depreciation;
	}
	public void setAccumulated_depreciation(BigDecimal accumulated_depreciation) {
		this.accumulated_depreciation = accumulated_depreciation;
	}
	public String getCollateral_nature() {
		return collateral_nature;
	}
	public void setCollateral_nature(String collateral_nature) {
		this.collateral_nature = collateral_nature;
	}
	public String getValuation_type() {
		return valuation_type;
	}
	public void setValuation_type(String valuation_type) {
		this.valuation_type = valuation_type;
	}
	public String getValuation_method() {
		return valuation_method;
	}
	public void setValuation_method(String valuation_method) {
		this.valuation_method = valuation_method;
	}
	public String getProperty_details() {
		return property_details;
	}
	public void setProperty_details(String property_details) {
		this.property_details = property_details;
	}
	public Date getMortgage_date() {
		return mortgage_date;
	}
	public void setMortgage_date(Date mortgage_date) {
		this.mortgage_date = mortgage_date;
	}
	public String getMortgage_details() {
		return mortgage_details;
	}
	public void setMortgage_details(String mortgage_details) {
		this.mortgage_details = mortgage_details;
	}
	public BigDecimal getMortgage_value() {
		return mortgage_value;
	}
	public void setMortgage_value(BigDecimal mortgage_value) {
		this.mortgage_value = mortgage_value;
	}
	public String getRemarks_i() {
		return remarks_i;
	}
	public void setRemarks_i(String remarks_i) {
		this.remarks_i = remarks_i;
	}
	public Date getDate_of_installation() {
		return date_of_installation;
	}
	public void setDate_of_installation(Date date_of_installation) {
		this.date_of_installation = date_of_installation;
	}
	public BigDecimal getCommissioning_cost() {
		return commissioning_cost;
	}
	public void setCommissioning_cost(BigDecimal commissioning_cost) {
		this.commissioning_cost = commissioning_cost;
	}
	public BigDecimal getHoliday_period() {
		return holiday_period;
	}
	public void setHoliday_period(BigDecimal holiday_period) {
		this.holiday_period = holiday_period;
	}
	public BigDecimal getNo_of_items() {
		return no_of_items;
	}
	public void setNo_of_items(BigDecimal no_of_items) {
		this.no_of_items = no_of_items;
	}
	public BigDecimal getGross_weight() {
		return gross_weight;
	}
	public void setGross_weight(BigDecimal gross_weight) {
		this.gross_weight = gross_weight;
	}
	public BigDecimal getNet_weight() {
		return net_weight;
	}
	public void setNet_weight(BigDecimal net_weight) {
		this.net_weight = net_weight;
	}
	public String getAppraiser_name() {
		return appraiser_name;
	}
	public void setAppraiser_name(String appraiser_name) {
		this.appraiser_name = appraiser_name;
	}
	public Date getAppraisal_date() {
		return appraisal_date;
	}
	public void setAppraisal_date(Date appraisal_date) {
		this.appraisal_date = appraisal_date;
	}
	public BigDecimal getAppraisal_value() {
		return appraisal_value;
	}
	public void setAppraisal_value(BigDecimal appraisal_value) {
		this.appraisal_value = appraisal_value;
	}
	public BigDecimal getMarket_value_v() {
		return market_value_v;
	}
	public void setMarket_value_v(BigDecimal market_value_v) {
		this.market_value_v = market_value_v;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getInsurance_company_v() {
		return insurance_company_v;
	}
	public void setInsurance_company_v(String insurance_company_v) {
		this.insurance_company_v = insurance_company_v;
	}
	public BigDecimal getInsured_value_v() {
		return insured_value_v;
	}
	public void setInsured_value_v(BigDecimal insured_value_v) {
		this.insured_value_v = insured_value_v;
	}
	public BigDecimal getPolicy_no_v() {
		return policy_no_v;
	}
	public void setPolicy_no_v(BigDecimal policy_no_v) {
		this.policy_no_v = policy_no_v;
	}
	public Date getExpiry_date_v() {
		return expiry_date_v;
	}
	public void setExpiry_date_v(Date expiry_date_v) {
		this.expiry_date_v = expiry_date_v;
	}
	public Date getStatement_date() {
		return statement_date;
	}
	public void setStatement_date(Date statement_date) {
		this.statement_date = statement_date;
	}
	public BigDecimal getStock_value() {
		return stock_value;
	}
	public void setStock_value(BigDecimal stock_value) {
		this.stock_value = stock_value;
	}
	public BigDecimal getEligible_stock_value() {
		return eligible_stock_value;
	}
	public void setEligible_stock_value(BigDecimal eligible_stock_value) {
		this.eligible_stock_value = eligible_stock_value;
	}
	public String getRemarks_v() {
		return remarks_v;
	}
	public void setRemarks_v(String remarks_v) {
		this.remarks_v = remarks_v;
	}
	public String getInsurance_company_b() {
		return insurance_company_b;
	}
	public void setInsurance_company_b(String insurance_company_b) {
		this.insurance_company_b = insurance_company_b;
	}
	public BigDecimal getInsured_value_b() {
		return insured_value_b;
	}
	public void setInsured_value_b(BigDecimal insured_value_b) {
		this.insured_value_b = insured_value_b;
	}
	public BigDecimal getPolicy_no_b() {
		return policy_no_b;
	}
	public void setPolicy_no_b(BigDecimal policy_no_b) {
		this.policy_no_b = policy_no_b;
	}
	public Date getExpiry_date_b() {
		return expiry_date_b;
	}
	public void setExpiry_date_b(Date expiry_date_b) {
		this.expiry_date_b = expiry_date_b;
	}
	public String getCompany_name_s() {
		return company_name_s;
	}
	public void setCompany_name_s(String company_name_s) {
		this.company_name_s = company_name_s;
	}
	public BigDecimal getNo_of_certificates() {
		return no_of_certificates;
	}
	public void setNo_of_certificates(BigDecimal no_of_certificates) {
		this.no_of_certificates = no_of_certificates;
	}
	public BigDecimal getCertificate_serial() {
		return certificate_serial;
	}
	public void setCertificate_serial(BigDecimal certificate_serial) {
		this.certificate_serial = certificate_serial;
	}
	public BigDecimal getFace_value() {
		return face_value;
	}
	public void setFace_value(BigDecimal face_value) {
		this.face_value = face_value;
	}
	public String getGuarantor_name() {
		return guarantor_name;
	}
	public void setGuarantor_name(String guarantor_name) {
		this.guarantor_name = guarantor_name;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate_of_inspection() {
		return date_of_inspection;
	}
	public void setDate_of_inspection(Date date_of_inspection) {
		this.date_of_inspection = date_of_inspection;
	}
	public String getName_of_inspector() {
		return name_of_inspector;
	}
	public void setName_of_inspector(String name_of_inspector) {
		this.name_of_inspector = name_of_inspector;
	}
	public String getCollateral_location() {
		return collateral_location;
	}
	public void setCollateral_location(String collateral_location) {
		this.collateral_location = collateral_location;
	}
	public String getRemarks_b() {
		return remarks_b;
	}
	public void setRemarks_b(String remarks_b) {
		this.remarks_b = remarks_b;
	}
	public BigDecimal getGen_amount() {
		return gen_amount;
	}
	public void setGen_amount(BigDecimal gen_amount) {
		this.gen_amount = gen_amount;
	}
	public BigDecimal getGen_book_value() {
		return gen_book_value;
	}
	public void setGen_book_value(BigDecimal gen_book_value) {
		this.gen_book_value = gen_book_value;
	}
	public String getGen_delete_flg() {
		return gen_delete_flg;
	}
	public void setGen_delete_flg(String gen_delete_flg) {
		this.gen_delete_flg = gen_delete_flg;
	}
	public BigDecimal getGen_depreciation() {
		return gen_depreciation;
	}
	public void setGen_depreciation(BigDecimal gen_depreciation) {
		this.gen_depreciation = gen_depreciation;
	}
	public String getGen_flow_id() {
		return gen_flow_id;
	}
	public void setGen_flow_id(String gen_flow_id) {
		this.gen_flow_id = gen_flow_id;
	}
	public Date getGen_flow_strt_date() {
		return gen_flow_strt_date;
	}
	public void setGen_flow_strt_date(Date gen_flow_strt_date) {
		this.gen_flow_strt_date = gen_flow_strt_date;
	}
	public String getGen_frequency() {
		return gen_frequency;
	}
	public void setGen_frequency(String gen_frequency) {
		this.gen_frequency = gen_frequency;
	}
	public String getGen_method() {
		return gen_method;
	}
	public void setGen_method(String gen_method) {
		this.gen_method = gen_method;
	}
	public String getGen_modify_flg() {
		return gen_modify_flg;
	}
	public void setGen_modify_flg(String gen_modify_flg) {
		this.gen_modify_flg = gen_modify_flg;
	}
	public BigDecimal getGen_original_cost() {
		return gen_original_cost;
	}
	public void setGen_original_cost(BigDecimal gen_original_cost) {
		this.gen_original_cost = gen_original_cost;
	}
	public String getGen_percentage() {
		return gen_percentage;
	}
	public void setGen_percentage(String gen_percentage) {
		this.gen_percentage = gen_percentage;
	}
	public String getGen_remarks() {
		return gen_remarks;
	}
	public void setGen_remarks(String gen_remarks) {
		this.gen_remarks = gen_remarks;
	}
	public String getGen_roll_no() {
		return gen_roll_no;
	}
	public void setGen_roll_no(String gen_roll_no) {
		this.gen_roll_no = gen_roll_no;
	}
	public Date getGen_tran_date() {
		return gen_tran_date;
	}
	public void setGen_tran_date(Date gen_tran_date) {
		this.gen_tran_date = gen_tran_date;
	}
	public String getGen_tran_id() {
		return gen_tran_id;
	}
	public void setGen_tran_id(String gen_tran_id) {
		this.gen_tran_id = gen_tran_id;
	}
	public String getGen_verify_flg() {
		return gen_verify_flg;
	}
	public void setGen_verify_flg(String gen_verify_flg) {
		this.gen_verify_flg = gen_verify_flg;
	}
	public String getLife_span_months() {
		return life_span_months;
	}
	public void setLife_span_months(String life_span_months) {
		this.life_span_months = life_span_months;
	}
	public BigDecimal getOriginal_cost() {
		return original_cost;
	}
	public void setOriginal_cost(BigDecimal original_cost) {
		this.original_cost = original_cost;
	}
	public String getSale_flg() {
		return sale_flg;
	}
	public void setSale_flg(String sale_flg) {
		this.sale_flg = sale_flg;
	}
	public String getTransfer_details() {
		return transfer_details;
	}
	public void setTransfer_details(String transfer_details) {
		this.transfer_details = transfer_details;
	}
	public String getWriteoff_flg() {
		return writeoff_flg;
	}
	public void setWriteoff_flg(String writeoff_flg) {
		this.writeoff_flg = writeoff_flg;
	}
	public Date getYear_of_purchase() {
		return year_of_purchase;
	}
	public void setYear_of_purchase(Date year_of_purchase) {
		this.year_of_purchase = year_of_purchase;
	}
	public String getDescription_g() {
		return description_g;
	}
	public void setDescription_g(String description_g) {
		this.description_g = description_g;
	}
	public String getNational_id_card() {
		return national_id_card;
	}
	public void setNational_id_card(String national_id_card) {
		this.national_id_card = national_id_card;
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
	public String getBook_value() {
		return book_value;
	}
	public void setBook_value(String book_value) {
		this.book_value = book_value;
	}
	
	public Collateral_management_Entity(String branch_code, String branch_name, String customer_id,
			String customer_name, String loan_type, BigDecimal loan_account_no, Date date_of_loan, String loan_currency,
			BigDecimal amount_sanctioned, BigDecimal drawing_limit, BigDecimal disbursement_amount,
			BigDecimal loan_outstanding, BigDecimal loan_period, Date expiry_date, BigDecimal repayment_terms,
			String recovery_method, BigDecimal collateral_ref_no, BigDecimal no_of_collaterals,
			BigDecimal collateral_serial_no, String apportionment_flag, String collateral_type, String description,
			Date date_of_purchase, BigDecimal original_value, String collateral_description, String ownership,
			String location, BigDecimal date_of_purchase_p, Date date_of_valuation, String valuer_details,
			BigDecimal market_value, BigDecimal insured_value, BigDecimal max_allowable_amount,
			BigDecimal apportionment_amount, String apportionment_details, String other_loans,
			BigDecimal life_of_property, String depreciation_flag, String depreciation_method, String calculation_type,
			Date last_depreciation_date, BigDecimal depreciation_percentage, BigDecimal depreciation_amount,
			BigDecimal accumulated_depreciation, String collateral_nature, String valuation_type,
			String valuation_method, String property_details, Date mortgage_date, String mortgage_details,
			BigDecimal mortgage_value, String remarks_i, Date date_of_installation, BigDecimal commissioning_cost,
			BigDecimal holiday_period, BigDecimal no_of_items, BigDecimal gross_weight, BigDecimal net_weight,
			String appraiser_name, Date appraisal_date, BigDecimal appraisal_value, BigDecimal market_value_v,
			String vehicle_type, String brand, String make, String model, String insurance_company_v,
			BigDecimal insured_value_v, BigDecimal policy_no_v, Date expiry_date_v, Date statement_date,
			BigDecimal stock_value, BigDecimal eligible_stock_value, String remarks_v, String insurance_company_b,
			BigDecimal insured_value_b, BigDecimal policy_no_b, Date expiry_date_b, String company_name_s,
			BigDecimal no_of_certificates, BigDecimal certificate_serial, BigDecimal face_value, String guarantor_name,
			String network, String address, Date date_of_inspection, String name_of_inspector,
			String collateral_location, String remarks_b, BigDecimal gen_amount, BigDecimal gen_book_value,
			String gen_delete_flg, BigDecimal gen_depreciation, String gen_flow_id, Date gen_flow_strt_date,
			String gen_frequency, String gen_method, String gen_modify_flg, BigDecimal gen_original_cost,
			String gen_percentage, String gen_remarks, String gen_roll_no, Date gen_tran_date, String gen_tran_id,
			String gen_verify_flg, String life_span_months, BigDecimal original_cost, String sale_flg,
			String transfer_details, String writeoff_flg, String book_value, Date year_of_purchase,
			String description_g, String national_id_card, String entry_user, Date entry_time, String auth_user,
			Date auth_time, String modify_user, Date modify_time, String entity_flg, String modify_flg,
			String del_flg) {
		super();
		this.branch_code = branch_code;
		this.branch_name = branch_name;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.loan_type = loan_type;
		this.loan_account_no = loan_account_no;
		this.date_of_loan = date_of_loan;
		this.loan_currency = loan_currency;
		this.amount_sanctioned = amount_sanctioned;
		this.drawing_limit = drawing_limit;
		this.disbursement_amount = disbursement_amount;
		this.loan_outstanding = loan_outstanding;
		this.loan_period = loan_period;
		this.expiry_date = expiry_date;
		this.repayment_terms = repayment_terms;
		this.recovery_method = recovery_method;
		this.collateral_ref_no = collateral_ref_no;
		this.no_of_collaterals = no_of_collaterals;
		this.collateral_serial_no = collateral_serial_no;
		this.apportionment_flag = apportionment_flag;
		this.collateral_type = collateral_type;
		this.description = description;
		this.date_of_purchase = date_of_purchase;
		this.original_value = original_value;
		this.collateral_description = collateral_description;
		this.ownership = ownership;
		this.location = location;
		this.date_of_purchase_p = date_of_purchase_p;
		this.date_of_valuation = date_of_valuation;
		this.valuer_details = valuer_details;
		this.market_value = market_value;
		this.insured_value = insured_value;
		this.max_allowable_amount = max_allowable_amount;
		this.apportionment_amount = apportionment_amount;
		this.apportionment_details = apportionment_details;
		this.other_loans = other_loans;
		this.life_of_property = life_of_property;
		this.depreciation_flag = depreciation_flag;
		this.depreciation_method = depreciation_method;
		this.calculation_type = calculation_type;
		this.last_depreciation_date = last_depreciation_date;
		this.depreciation_percentage = depreciation_percentage;
		this.depreciation_amount = depreciation_amount;
		this.accumulated_depreciation = accumulated_depreciation;
		this.collateral_nature = collateral_nature;
		this.valuation_type = valuation_type;
		this.valuation_method = valuation_method;
		this.property_details = property_details;
		this.mortgage_date = mortgage_date;
		this.mortgage_details = mortgage_details;
		this.mortgage_value = mortgage_value;
		this.remarks_i = remarks_i;
		this.date_of_installation = date_of_installation;
		this.commissioning_cost = commissioning_cost;
		this.holiday_period = holiday_period;
		this.no_of_items = no_of_items;
		this.gross_weight = gross_weight;
		this.net_weight = net_weight;
		this.appraiser_name = appraiser_name;
		this.appraisal_date = appraisal_date;
		this.appraisal_value = appraisal_value;
		this.market_value_v = market_value_v;
		this.vehicle_type = vehicle_type;
		this.brand = brand;
		this.make = make;
		this.model = model;
		this.insurance_company_v = insurance_company_v;
		this.insured_value_v = insured_value_v;
		this.policy_no_v = policy_no_v;
		this.expiry_date_v = expiry_date_v;
		this.statement_date = statement_date;
		this.stock_value = stock_value;
		this.eligible_stock_value = eligible_stock_value;
		this.remarks_v = remarks_v;
		this.insurance_company_b = insurance_company_b;
		this.insured_value_b = insured_value_b;
		this.policy_no_b = policy_no_b;
		this.expiry_date_b = expiry_date_b;
		this.company_name_s = company_name_s;
		this.no_of_certificates = no_of_certificates;
		this.certificate_serial = certificate_serial;
		this.face_value = face_value;
		this.guarantor_name = guarantor_name;
		this.network = network;
		this.address = address;
		this.date_of_inspection = date_of_inspection;
		this.name_of_inspector = name_of_inspector;
		this.collateral_location = collateral_location;
		this.remarks_b = remarks_b;
		this.gen_amount = gen_amount;
		this.gen_book_value = gen_book_value;
		this.gen_delete_flg = gen_delete_flg;
		this.gen_depreciation = gen_depreciation;
		this.gen_flow_id = gen_flow_id;
		this.gen_flow_strt_date = gen_flow_strt_date;
		this.gen_frequency = gen_frequency;
		this.gen_method = gen_method;
		this.gen_modify_flg = gen_modify_flg;
		this.gen_original_cost = gen_original_cost;
		this.gen_percentage = gen_percentage;
		this.gen_remarks = gen_remarks;
		this.gen_roll_no = gen_roll_no;
		this.gen_tran_date = gen_tran_date;
		this.gen_tran_id = gen_tran_id;
		this.gen_verify_flg = gen_verify_flg;
		this.life_span_months = life_span_months;
		this.original_cost = original_cost;
		this.sale_flg = sale_flg;
		this.transfer_details = transfer_details;
		this.writeoff_flg = writeoff_flg;
		this.book_value = book_value;
		this.year_of_purchase = year_of_purchase;
		this.description_g = description_g;
		this.national_id_card = national_id_card;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public Collateral_management_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
