package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "HOLIDAY_MASTER")
public class HolidayMaster_Entity {

	@Id
	private BigDecimal record_srl;
	private String orgn;
	private String location;
	private String cal_year;
	private String cal_month;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date record_date;
	private String holiday_desc;
	private String holiday_remarks;
	private String holiday_flg;
	private String entry_user;
	private String modify_user;
	private String auth_user;
	private Date entry_time;
	private Date modify_time;
	private Date auth_time;
	private String del_flg;
	private String entity_flg;
	private String modify_flg;
	private String record_status;
	public BigDecimal getRecord_srl() {
		return record_srl;
	}
	public void setRecord_srl(BigDecimal record_srl) {
		this.record_srl = record_srl;
	}
	public String getOrgn() {
		return orgn;
	}
	public void setOrgn(String orgn) {
		this.orgn = orgn;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCal_year() {
		return cal_year;
	}
	public void setCal_year(String cal_year) {
		this.cal_year = cal_year;
	}
	public String getCal_month() {
		return cal_month;
	}
	public void setCal_month(String cal_month) {
		this.cal_month = cal_month;
	}
	public Date getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}
	public String getHoliday_desc() {
		return holiday_desc;
	}
	public void setHoliday_desc(String holiday_desc) {
		this.holiday_desc = holiday_desc;
	}
	public String getHoliday_remarks() {
		return holiday_remarks;
	}
	public void setHoliday_remarks(String holiday_remarks) {
		this.holiday_remarks = holiday_remarks;
	}
	public String getHoliday_flg() {
		return holiday_flg;
	}
	public void setHoliday_flg(String holiday_flg) {
		this.holiday_flg = holiday_flg;
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
	public String getRecord_status() {
		return record_status;
	}
	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}
	public HolidayMaster_Entity(BigDecimal record_srl, String orgn, String location, String cal_year, String cal_month,
			Date record_date, String holiday_desc, String holiday_remarks, String holiday_flg, String entry_user,
			String modify_user, String auth_user, Date entry_time, Date modify_time, Date auth_time, String del_flg,
			String entity_flg, String modify_flg, String record_status) {
		super();
		this.record_srl = record_srl;
		this.orgn = orgn;
		this.location = location;
		this.cal_year = cal_year;
		this.cal_month = cal_month;
		this.record_date = record_date;
		this.holiday_desc = holiday_desc;
		this.holiday_remarks = holiday_remarks;
		this.holiday_flg = holiday_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.record_status = record_status;
	}
	public HolidayMaster_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
