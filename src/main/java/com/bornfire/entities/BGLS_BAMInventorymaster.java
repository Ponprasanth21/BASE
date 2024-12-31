package com.bornfire.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BGLS_BAMINVENTORY_MASTER")
public class BGLS_BAMInventorymaster {
	@Id
	private String	asst_srl_no;
	private String	asst_name;
	private String	acc_number;
	private String	asset_head;
	private String	asset_category;
	private String	asset_sub_category;
	private String	category_desc;
	private String	asset_type;
	private String	asst_crncy;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	date_of_purchase;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	year_of_purchase;
	private BigDecimal	org_cost;
	private BigDecimal	life_span_mth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	asst_exp_date;
	private String	asst_rmks;
	private String vender_name;
	private String purchase_details;
	private String	depr_flag;
	private String	depr_freq;
	private String	depr_method;
	private BigDecimal	depr_percent;
	private BigDecimal	acc_depr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	date_of_last_depr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	date_of_acqn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	date_of_last_tfr;
	private BigDecimal	cur_book_value;
	private BigDecimal	mkt_value;
	private String	loc_type;
	private String	sol_id;
	private String	emp_id;
	private String	dept_div_name;
	private String	loca_addr;
	private String	loc_rmks;
	private String	gtee_amt;
	private BigDecimal	gtee_amt_percent;
	private BigDecimal	nom_depr_amt;
	private String	depr_rmks;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	auth_time;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private String sale_flg;
	private String write_off_flg;
	private String verify_flg;
	private String verify_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date verify_time;
	public String getAsst_srl_no() {
		return asst_srl_no;
	}
	public void setAsst_srl_no(String asst_srl_no) {
		this.asst_srl_no = asst_srl_no;
	}
	public String getAsst_name() {
		return asst_name;
	}
	public void setAsst_name(String asst_name) {
		this.asst_name = asst_name;
	}
	public String getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}
	public String getAsset_head() {
		return asset_head;
	}
	public void setAsset_head(String asset_head) {
		this.asset_head = asset_head;
	}
	public String getAsset_category() {
		return asset_category;
	}
	public void setAsset_category(String asset_category) {
		this.asset_category = asset_category;
	}
	public String getAsset_sub_category() {
		return asset_sub_category;
	}
	public void setAsset_sub_category(String asset_sub_category) {
		this.asset_sub_category = asset_sub_category;
	}
	public String getCategory_desc() {
		return category_desc;
	}
	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}
	public String getAsset_type() {
		return asset_type;
	}
	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	public String getAsst_crncy() {
		return asst_crncy;
	}
	public void setAsst_crncy(String asst_crncy) {
		this.asst_crncy = asst_crncy;
	}
	public Date getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(Date date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}
	public Date getYear_of_purchase() {
		return year_of_purchase;
	}
	public void setYear_of_purchase(Date year_of_purchase) {
		this.year_of_purchase = year_of_purchase;
	}
	public BigDecimal getOrg_cost() {
		return org_cost;
	}
	public void setOrg_cost(BigDecimal org_cost) {
		this.org_cost = org_cost;
	}
	public BigDecimal getLife_span_mth() {
		return life_span_mth;
	}
	public void setLife_span_mth(BigDecimal life_span_mth) {
		this.life_span_mth = life_span_mth;
	}
	public Date getAsst_exp_date() {
		return asst_exp_date;
	}
	public void setAsst_exp_date(Date asst_exp_date) {
		this.asst_exp_date = asst_exp_date;
	}
	public String getAsst_rmks() {
		return asst_rmks;
	}
	public void setAsst_rmks(String asst_rmks) {
		this.asst_rmks = asst_rmks;
	}
	public String getVender_name() {
		return vender_name;
	}
	public void setVender_name(String vender_name) {
		this.vender_name = vender_name;
	}
	public String getPurchase_details() {
		return purchase_details;
	}
	public void setPurchase_details(String purchase_details) {
		this.purchase_details = purchase_details;
	}
	public String getDepr_flag() {
		return depr_flag;
	}
	public void setDepr_flag(String depr_flag) {
		this.depr_flag = depr_flag;
	}
	public String getDepr_freq() {
		return depr_freq;
	}
	public void setDepr_freq(String depr_freq) {
		this.depr_freq = depr_freq;
	}
	public String getDepr_method() {
		return depr_method;
	}
	public void setDepr_method(String depr_method) {
		this.depr_method = depr_method;
	}
	public BigDecimal getDepr_percent() {
		return depr_percent;
	}
	public void setDepr_percent(BigDecimal depr_percent) {
		this.depr_percent = depr_percent;
	}
	public BigDecimal getAcc_depr() {
		return acc_depr;
	}
	public void setAcc_depr(BigDecimal acc_depr) {
		this.acc_depr = acc_depr;
	}
	public Date getDate_of_last_depr() {
		return date_of_last_depr;
	}
	public void setDate_of_last_depr(Date date_of_last_depr) {
		this.date_of_last_depr = date_of_last_depr;
	}
	public Date getDate_of_acqn() {
		return date_of_acqn;
	}
	public void setDate_of_acqn(Date date_of_acqn) {
		this.date_of_acqn = date_of_acqn;
	}
	public Date getDate_of_last_tfr() {
		return date_of_last_tfr;
	}
	public void setDate_of_last_tfr(Date date_of_last_tfr) {
		this.date_of_last_tfr = date_of_last_tfr;
	}
	public BigDecimal getCur_book_value() {
		return cur_book_value;
	}
	public void setCur_book_value(BigDecimal cur_book_value) {
		this.cur_book_value = cur_book_value;
	}
	public BigDecimal getMkt_value() {
		return mkt_value;
	}
	public void setMkt_value(BigDecimal mkt_value) {
		this.mkt_value = mkt_value;
	}
	public String getLoc_type() {
		return loc_type;
	}
	public void setLoc_type(String loc_type) {
		this.loc_type = loc_type;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getDept_div_name() {
		return dept_div_name;
	}
	public void setDept_div_name(String dept_div_name) {
		this.dept_div_name = dept_div_name;
	}
	public String getLoca_addr() {
		return loca_addr;
	}
	public void setLoca_addr(String loca_addr) {
		this.loca_addr = loca_addr;
	}
	public String getLoc_rmks() {
		return loc_rmks;
	}
	public void setLoc_rmks(String loc_rmks) {
		this.loc_rmks = loc_rmks;
	}
	public String getGtee_amt() {
		return gtee_amt;
	}
	public void setGtee_amt(String gtee_amt) {
		this.gtee_amt = gtee_amt;
	}
	public BigDecimal getGtee_amt_percent() {
		return gtee_amt_percent;
	}
	public void setGtee_amt_percent(BigDecimal gtee_amt_percent) {
		this.gtee_amt_percent = gtee_amt_percent;
	}
	public BigDecimal getNom_depr_amt() {
		return nom_depr_amt;
	}
	public void setNom_depr_amt(BigDecimal nom_depr_amt) {
		this.nom_depr_amt = nom_depr_amt;
	}
	public String getDepr_rmks() {
		return depr_rmks;
	}
	public void setDepr_rmks(String depr_rmks) {
		this.depr_rmks = depr_rmks;
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
	public String getSale_flg() {
		return sale_flg;
	}
	public void setSale_flg(String sale_flg) {
		this.sale_flg = sale_flg;
	}
	public String getWrite_off_flg() {
		return write_off_flg;
	}
	public void setWrite_off_flg(String write_off_flg) {
		this.write_off_flg = write_off_flg;
	}
	public String getVerify_flg() {
		return verify_flg;
	}
	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	@Override
	public String toString() {
		return "BGLS_BAMInventorymaster [asst_srl_no=" + asst_srl_no + ", asst_name=" + asst_name + ", acc_number="
				+ acc_number + ", asset_head=" + asset_head + ", asset_category=" + asset_category
				+ ", asset_sub_category=" + asset_sub_category + ", category_desc=" + category_desc + ", asset_type="
				+ asset_type + ", asst_crncy=" + asst_crncy + ", date_of_purchase=" + date_of_purchase
				+ ", year_of_purchase=" + year_of_purchase + ", org_cost=" + org_cost + ", life_span_mth="
				+ life_span_mth + ", asst_exp_date=" + asst_exp_date + ", asst_rmks=" + asst_rmks + ", vender_name="
				+ vender_name + ", purchase_details=" + purchase_details + ", depr_flag=" + depr_flag + ", depr_freq="
				+ depr_freq + ", depr_method=" + depr_method + ", depr_percent=" + depr_percent + ", acc_depr="
				+ acc_depr + ", date_of_last_depr=" + date_of_last_depr + ", date_of_acqn=" + date_of_acqn
				+ ", date_of_last_tfr=" + date_of_last_tfr + ", cur_book_value=" + cur_book_value + ", mkt_value="
				+ mkt_value + ", loc_type=" + loc_type + ", sol_id=" + sol_id + ", emp_id=" + emp_id
				+ ", dept_div_name=" + dept_div_name + ", loca_addr=" + loca_addr + ", loc_rmks=" + loc_rmks
				+ ", gtee_amt=" + gtee_amt + ", gtee_amt_percent=" + gtee_amt_percent + ", nom_depr_amt=" + nom_depr_amt
				+ ", depr_rmks=" + depr_rmks + ", entry_user=" + entry_user + ", modify_user=" + modify_user
				+ ", auth_user=" + auth_user + ", entry_time=" + entry_time + ", modify_time=" + modify_time
				+ ", auth_time=" + auth_time + ", del_flg=" + del_flg + ", entity_flg=" + entity_flg + ", modify_flg="
				+ modify_flg + ", sale_flg=" + sale_flg + ", write_off_flg=" + write_off_flg + ", verify_flg="
				+ verify_flg + ", verify_user=" + verify_user + ", verify_time=" + verify_time + ", getAsst_srl_no()="
				+ getAsst_srl_no() + ", getAsst_name()=" + getAsst_name() + ", getAcc_number()=" + getAcc_number()
				+ ", getAsset_head()=" + getAsset_head() + ", getAsset_category()=" + getAsset_category()
				+ ", getAsset_sub_category()=" + getAsset_sub_category() + ", getCategory_desc()=" + getCategory_desc()
				+ ", getAsset_type()=" + getAsset_type() + ", getAsst_crncy()=" + getAsst_crncy()
				+ ", getDate_of_purchase()=" + getDate_of_purchase() + ", getYear_of_purchase()="
				+ getYear_of_purchase() + ", getOrg_cost()=" + getOrg_cost() + ", getLife_span_mth()="
				+ getLife_span_mth() + ", getAsst_exp_date()=" + getAsst_exp_date() + ", getAsst_rmks()="
				+ getAsst_rmks() + ", getVender_name()=" + getVender_name() + ", getPurchase_details()="
				+ getPurchase_details() + ", getDepr_flag()=" + getDepr_flag() + ", getDepr_freq()=" + getDepr_freq()
				+ ", getDepr_method()=" + getDepr_method() + ", getDepr_percent()=" + getDepr_percent()
				+ ", getAcc_depr()=" + getAcc_depr() + ", getDate_of_last_depr()=" + getDate_of_last_depr()
				+ ", getDate_of_acqn()=" + getDate_of_acqn() + ", getDate_of_last_tfr()=" + getDate_of_last_tfr()
				+ ", getCur_book_value()=" + getCur_book_value() + ", getMkt_value()=" + getMkt_value()
				+ ", getLoc_type()=" + getLoc_type() + ", getSol_id()=" + getSol_id() + ", getEmp_id()=" + getEmp_id()
				+ ", getDept_div_name()=" + getDept_div_name() + ", getLoca_addr()=" + getLoca_addr()
				+ ", getLoc_rmks()=" + getLoc_rmks() + ", getGtee_amt()=" + getGtee_amt() + ", getGtee_amt_percent()="
				+ getGtee_amt_percent() + ", getNom_depr_amt()=" + getNom_depr_amt() + ", getDepr_rmks()="
				+ getDepr_rmks() + ", getEntry_user()=" + getEntry_user() + ", getModify_user()=" + getModify_user()
				+ ", getAuth_user()=" + getAuth_user() + ", getEntry_time()=" + getEntry_time() + ", getModify_time()="
				+ getModify_time() + ", getAuth_time()=" + getAuth_time() + ", getDel_flg()=" + getDel_flg()
				+ ", getEntity_flg()=" + getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getSale_flg()="
				+ getSale_flg() + ", getWrite_off_flg()=" + getWrite_off_flg() + ", getVerify_flg()=" + getVerify_flg()
				+ ", getVerify_user()=" + getVerify_user() + ", getVerify_time()=" + getVerify_time() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public BGLS_BAMInventorymaster(String asst_srl_no, String asst_name, String acc_number, String asset_head,
			String asset_category, String asset_sub_category, String category_desc, String asset_type,
			String asst_crncy, Date date_of_purchase, Date year_of_purchase, BigDecimal org_cost,
			BigDecimal life_span_mth, Date asst_exp_date, String asst_rmks, String vender_name, String purchase_details,
			String depr_flag, String depr_freq, String depr_method, BigDecimal depr_percent, BigDecimal acc_depr,
			Date date_of_last_depr, Date date_of_acqn, Date date_of_last_tfr, BigDecimal cur_book_value,
			BigDecimal mkt_value, String loc_type, String sol_id, String emp_id, String dept_div_name, String loca_addr,
			String loc_rmks, String gtee_amt, BigDecimal gtee_amt_percent, BigDecimal nom_depr_amt, String depr_rmks,
			String entry_user, String modify_user, String auth_user, Date entry_time, Date modify_time, Date auth_time,
			String del_flg, String entity_flg, String modify_flg, String sale_flg, String write_off_flg,
			String verify_flg, String verify_user, Date verify_time) {
		super();
		this.asst_srl_no = asst_srl_no;
		this.asst_name = asst_name;
		this.acc_number = acc_number;
		this.asset_head = asset_head;
		this.asset_category = asset_category;
		this.asset_sub_category = asset_sub_category;
		this.category_desc = category_desc;
		this.asset_type = asset_type;
		this.asst_crncy = asst_crncy;
		this.date_of_purchase = date_of_purchase;
		this.year_of_purchase = year_of_purchase;
		this.org_cost = org_cost;
		this.life_span_mth = life_span_mth;
		this.asst_exp_date = asst_exp_date;
		this.asst_rmks = asst_rmks;
		this.vender_name = vender_name;
		this.purchase_details = purchase_details;
		this.depr_flag = depr_flag;
		this.depr_freq = depr_freq;
		this.depr_method = depr_method;
		this.depr_percent = depr_percent;
		this.acc_depr = acc_depr;
		this.date_of_last_depr = date_of_last_depr;
		this.date_of_acqn = date_of_acqn;
		this.date_of_last_tfr = date_of_last_tfr;
		this.cur_book_value = cur_book_value;
		this.mkt_value = mkt_value;
		this.loc_type = loc_type;
		this.sol_id = sol_id;
		this.emp_id = emp_id;
		this.dept_div_name = dept_div_name;
		this.loca_addr = loca_addr;
		this.loc_rmks = loc_rmks;
		this.gtee_amt = gtee_amt;
		this.gtee_amt_percent = gtee_amt_percent;
		this.nom_depr_amt = nom_depr_amt;
		this.depr_rmks = depr_rmks;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.sale_flg = sale_flg;
		this.write_off_flg = write_off_flg;
		this.verify_flg = verify_flg;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
	}
	public BGLS_BAMInventorymaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
