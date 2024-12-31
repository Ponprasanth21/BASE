package com.bornfire.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BGLS_FLOW_ASSETS")
public class BGLS_BAMAssetFlows_Entity {
	  @Id
	    private BigDecimal  srl_no;
	    private String asset_serial_no;
	    private String asset_name;
	    private String asset_currency;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date date_of_purchase;
	    private BigDecimal year_of_purchase;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date asst_exp_date;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date acquis_date;
	    private String life_span_months;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date depreciation_start_date;
	    private String  asset_type;
	    private BigDecimal original_cost;
	    private String accum_depres;
	    private BigDecimal curr_book_value;
	    private String depreciation_flg;
	    private String depreciation_method;
	    private String depreciation_percentage;
	    private String depreciation_frequency;
	    private String transfer_details;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date date_of_last_depreciation;
	    private String gen_roll_no;
	    private String gen_flow_id;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date gen_flow_strt_date;
	    private String gen_frequncy;
	    private String  gen_method;
	    private String  gen_percentage;
	    private BigDecimal gen_original_cost;
	    private BigDecimal gen_depreciation;
	    private BigDecimal gen_book_value;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date gen_tran_date;
	    private String gen_tran_id;
	    private BigDecimal  gen_amount;
	    private String gen_remarks;
	    private String gen_modify_flg;
	    private String gen_delete_flg;
	    private String gen_verify_flg;
	    private String sale_flg;
	    private String writeoff_flg;
		public BigDecimal getSrl_no() {
			return srl_no;
		}
		public void setSrl_no(BigDecimal srl_no) {
			this.srl_no = srl_no;
		}
		public String getAsset_serial_no() {
			return asset_serial_no;
		}
		public void setAsset_serial_no(String asset_serial_no) {
			this.asset_serial_no = asset_serial_no;
		}
		public String getAsset_name() {
			return asset_name;
		}
		public void setAsset_name(String asset_name) {
			this.asset_name = asset_name;
		}
		public String getAsset_currency() {
			return asset_currency;
		}
		public void setAsset_currency(String asset_currency) {
			this.asset_currency = asset_currency;
		}
		public Date getDate_of_purchase() {
			return date_of_purchase;
		}
		public void setDate_of_purchase(Date date_of_purchase) {
			this.date_of_purchase = date_of_purchase;
		}
		public BigDecimal getYear_of_purchase() {
			return year_of_purchase;
		}
		public void setYear_of_purchase(BigDecimal year_of_purchase) {
			this.year_of_purchase = year_of_purchase;
		}
		public Date getAsst_exp_date() {
			return asst_exp_date;
		}
		public void setAsst_exp_date(Date asst_exp_date) {
			this.asst_exp_date = asst_exp_date;
		}
		public Date getAcquis_date() {
			return acquis_date;
		}
		public void setAcquis_date(Date acquis_date) {
			this.acquis_date = acquis_date;
		}
		public String getLife_span_months() {
			return life_span_months;
		}
		public void setLife_span_months(String life_span_months) {
			this.life_span_months = life_span_months;
		}
		public Date getDepreciation_start_date() {
			return depreciation_start_date;
		}
		public void setDepreciation_start_date(Date depreciation_start_date) {
			this.depreciation_start_date = depreciation_start_date;
		}
		public String getAsset_type() {
			return asset_type;
		}
		public void setAsset_type(String asset_type) {
			this.asset_type = asset_type;
		}
		public BigDecimal getOriginal_cost() {
			return original_cost;
		}
		public void setOriginal_cost(BigDecimal original_cost) {
			this.original_cost = original_cost;
		}
		public String getAccum_depres() {
			return accum_depres;
		}
		public void setAccum_depres(String accum_depres) {
			this.accum_depres = accum_depres;
		}
		public BigDecimal getCurr_book_value() {
			return curr_book_value;
		}
		public void setCurr_book_value(BigDecimal curr_book_value) {
			this.curr_book_value = curr_book_value;
		}
		public String getDepreciation_flg() {
			return depreciation_flg;
		}
		public void setDepreciation_flg(String depreciation_flg) {
			this.depreciation_flg = depreciation_flg;
		}
		public String getDepreciation_method() {
			return depreciation_method;
		}
		public void setDepreciation_method(String depreciation_method) {
			this.depreciation_method = depreciation_method;
		}
		public String getDepreciation_percentage() {
			return depreciation_percentage;
		}
		public void setDepreciation_percentage(String depreciation_percentage) {
			this.depreciation_percentage = depreciation_percentage;
		}
		public String getDepreciation_frequency() {
			return depreciation_frequency;
		}
		public void setDepreciation_frequency(String depreciation_frequency) {
			this.depreciation_frequency = depreciation_frequency;
		}
		public String getTransfer_details() {
			return transfer_details;
		}
		public void setTransfer_details(String transfer_details) {
			this.transfer_details = transfer_details;
		}
		public Date getDate_of_last_depreciation() {
			return date_of_last_depreciation;
		}
		public void setDate_of_last_depreciation(Date date_of_last_depreciation) {
			this.date_of_last_depreciation = date_of_last_depreciation;
		}
		public String getGen_roll_no() {
			return gen_roll_no;
		}
		public void setGen_roll_no(String gen_roll_no) {
			this.gen_roll_no = gen_roll_no;
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
		public String getGen_frequncy() {
			return gen_frequncy;
		}
		public void setGen_frequncy(String gen_frequncy) {
			this.gen_frequncy = gen_frequncy;
		}
		public String getGen_method() {
			return gen_method;
		}
		public void setGen_method(String gen_method) {
			this.gen_method = gen_method;
		}
		public String getGen_percentage() {
			return gen_percentage;
		}
		public void setGen_percentage(String gen_percentage) {
			this.gen_percentage = gen_percentage;
		}
		public BigDecimal getGen_original_cost() {
			return gen_original_cost;
		}
		public void setGen_original_cost(BigDecimal gen_original_cost) {
			this.gen_original_cost = gen_original_cost;
		}
		public BigDecimal getGen_depreciation() {
			return gen_depreciation;
		}
		public void setGen_depreciation(BigDecimal gen_depreciation) {
			this.gen_depreciation = gen_depreciation;
		}
		public BigDecimal getGen_book_value() {
			return gen_book_value;
		}
		public void setGen_book_value(BigDecimal gen_book_value) {
			this.gen_book_value = gen_book_value;
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
		public BigDecimal getGen_amount() {
			return gen_amount;
		}
		public void setGen_amount(BigDecimal gen_amount) {
			this.gen_amount = gen_amount;
		}
		public String getGen_remarks() {
			return gen_remarks;
		}
		public void setGen_remarks(String gen_remarks) {
			this.gen_remarks = gen_remarks;
		}
		public String getGen_modify_flg() {
			return gen_modify_flg;
		}
		public void setGen_modify_flg(String gen_modify_flg) {
			this.gen_modify_flg = gen_modify_flg;
		}
		public String getGen_delete_flg() {
			return gen_delete_flg;
		}
		public void setGen_delete_flg(String gen_delete_flg) {
			this.gen_delete_flg = gen_delete_flg;
		}
		public String getGen_verify_flg() {
			return gen_verify_flg;
		}
		public void setGen_verify_flg(String gen_verify_flg) {
			this.gen_verify_flg = gen_verify_flg;
		}
		public String getSale_flg() {
			return sale_flg;
		}
		public void setSale_flg(String sale_flg) {
			this.sale_flg = sale_flg;
		}
		public String getWriteoff_flg() {
			return writeoff_flg;
		}
		public void setWriteoff_flg(String writeoff_flg) {
			this.writeoff_flg = writeoff_flg;
		}
		@Override
		public String toString() {
			return "BGLS_BAMAssetFlows_Entity [srl_no=" + srl_no + ", asset_serial_no=" + asset_serial_no
					+ ", asset_name=" + asset_name + ", asset_currency=" + asset_currency + ", date_of_purchase="
					+ date_of_purchase + ", year_of_purchase=" + year_of_purchase + ", asst_exp_date=" + asst_exp_date
					+ ", acquis_date=" + acquis_date + ", life_span_months=" + life_span_months
					+ ", depreciation_start_date=" + depreciation_start_date + ", asset_type=" + asset_type
					+ ", original_cost=" + original_cost + ", accum_depres=" + accum_depres + ", curr_book_value="
					+ curr_book_value + ", depreciation_flg=" + depreciation_flg + ", depreciation_method="
					+ depreciation_method + ", depreciation_percentage=" + depreciation_percentage
					+ ", depreciation_frequency=" + depreciation_frequency + ", transfer_details=" + transfer_details
					+ ", date_of_last_depreciation=" + date_of_last_depreciation + ", gen_roll_no=" + gen_roll_no
					+ ", gen_flow_id=" + gen_flow_id + ", gen_flow_strt_date=" + gen_flow_strt_date + ", gen_frequncy="
					+ gen_frequncy + ", gen_method=" + gen_method + ", gen_percentage=" + gen_percentage
					+ ", gen_original_cost=" + gen_original_cost + ", gen_depreciation=" + gen_depreciation
					+ ", gen_book_value=" + gen_book_value + ", gen_tran_date=" + gen_tran_date + ", gen_tran_id="
					+ gen_tran_id + ", gen_amount=" + gen_amount + ", gen_remarks=" + gen_remarks + ", gen_modify_flg="
					+ gen_modify_flg + ", gen_delete_flg=" + gen_delete_flg + ", gen_verify_flg=" + gen_verify_flg
					+ ", sale_flg=" + sale_flg + ", writeoff_flg=" + writeoff_flg + ", getSrl_no()=" + getSrl_no()
					+ ", getAsset_serial_no()=" + getAsset_serial_no() + ", getAsset_name()=" + getAsset_name()
					+ ", getAsset_currency()=" + getAsset_currency() + ", getDate_of_purchase()="
					+ getDate_of_purchase() + ", getYear_of_purchase()=" + getYear_of_purchase()
					+ ", getAsst_exp_date()=" + getAsst_exp_date() + ", getAcquis_date()=" + getAcquis_date()
					+ ", getLife_span_months()=" + getLife_span_months() + ", getDepreciation_start_date()="
					+ getDepreciation_start_date() + ", getAsset_type()=" + getAsset_type() + ", getOriginal_cost()="
					+ getOriginal_cost() + ", getAccum_depres()=" + getAccum_depres() + ", getCurr_book_value()="
					+ getCurr_book_value() + ", getDepreciation_flg()=" + getDepreciation_flg()
					+ ", getDepreciation_method()=" + getDepreciation_method() + ", getDepreciation_percentage()="
					+ getDepreciation_percentage() + ", getDepreciation_frequency()=" + getDepreciation_frequency()
					+ ", getTransfer_details()=" + getTransfer_details() + ", getDate_of_last_depreciation()="
					+ getDate_of_last_depreciation() + ", getGen_roll_no()=" + getGen_roll_no() + ", getGen_flow_id()="
					+ getGen_flow_id() + ", getGen_flow_strt_date()=" + getGen_flow_strt_date() + ", getGen_frequncy()="
					+ getGen_frequncy() + ", getGen_method()=" + getGen_method() + ", getGen_percentage()="
					+ getGen_percentage() + ", getGen_original_cost()=" + getGen_original_cost()
					+ ", getGen_depreciation()=" + getGen_depreciation() + ", getGen_book_value()="
					+ getGen_book_value() + ", getGen_tran_date()=" + getGen_tran_date() + ", getGen_tran_id()="
					+ getGen_tran_id() + ", getGen_amount()=" + getGen_amount() + ", getGen_remarks()="
					+ getGen_remarks() + ", getGen_modify_flg()=" + getGen_modify_flg() + ", getGen_delete_flg()="
					+ getGen_delete_flg() + ", getGen_verify_flg()=" + getGen_verify_flg() + ", getSale_flg()="
					+ getSale_flg() + ", getWriteoff_flg()=" + getWriteoff_flg() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		public BGLS_BAMAssetFlows_Entity(BigDecimal srl_no, String asset_serial_no, String asset_name,
				String asset_currency, Date date_of_purchase, BigDecimal year_of_purchase, Date asst_exp_date,
				Date acquis_date, String life_span_months, Date depreciation_start_date, String asset_type,
				BigDecimal original_cost, String accum_depres, BigDecimal curr_book_value, String depreciation_flg,
				String depreciation_method, String depreciation_percentage, String depreciation_frequency,
				String transfer_details, Date date_of_last_depreciation, String gen_roll_no, String gen_flow_id,
				Date gen_flow_strt_date, String gen_frequncy, String gen_method, String gen_percentage,
				BigDecimal gen_original_cost, BigDecimal gen_depreciation, BigDecimal gen_book_value,
				Date gen_tran_date, String gen_tran_id, BigDecimal gen_amount, String gen_remarks,
				String gen_modify_flg, String gen_delete_flg, String gen_verify_flg, String sale_flg,
				String writeoff_flg) {
			super();
			this.srl_no = srl_no;
			this.asset_serial_no = asset_serial_no;
			this.asset_name = asset_name;
			this.asset_currency = asset_currency;
			this.date_of_purchase = date_of_purchase;
			this.year_of_purchase = year_of_purchase;
			this.asst_exp_date = asst_exp_date;
			this.acquis_date = acquis_date;
			this.life_span_months = life_span_months;
			this.depreciation_start_date = depreciation_start_date;
			this.asset_type = asset_type;
			this.original_cost = original_cost;
			this.accum_depres = accum_depres;
			this.curr_book_value = curr_book_value;
			this.depreciation_flg = depreciation_flg;
			this.depreciation_method = depreciation_method;
			this.depreciation_percentage = depreciation_percentage;
			this.depreciation_frequency = depreciation_frequency;
			this.transfer_details = transfer_details;
			this.date_of_last_depreciation = date_of_last_depreciation;
			this.gen_roll_no = gen_roll_no;
			this.gen_flow_id = gen_flow_id;
			this.gen_flow_strt_date = gen_flow_strt_date;
			this.gen_frequncy = gen_frequncy;
			this.gen_method = gen_method;
			this.gen_percentage = gen_percentage;
			this.gen_original_cost = gen_original_cost;
			this.gen_depreciation = gen_depreciation;
			this.gen_book_value = gen_book_value;
			this.gen_tran_date = gen_tran_date;
			this.gen_tran_id = gen_tran_id;
			this.gen_amount = gen_amount;
			this.gen_remarks = gen_remarks;
			this.gen_modify_flg = gen_modify_flg;
			this.gen_delete_flg = gen_delete_flg;
			this.gen_verify_flg = gen_verify_flg;
			this.sale_flg = sale_flg;
			this.writeoff_flg = writeoff_flg;
		}
		public BGLS_BAMAssetFlows_Entity() {
			super();
			// TODO Auto-generated constructor stub
		}
}

