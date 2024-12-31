package com.bornfire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CAL_MASTER_1")
public class Calender_Master_Entity {

		@Id
	 	private String month;
	    private String date;
	    private String day;
	    private String weeklyHoliday;
	    private String publicHoliday;
	    private String holidayStrings;
	    private Date entryTime;
	    private Date modifyTime;
	    private String delFlg;
	    private String entityFlg;
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getDay() {
			return day;
		}
		public void setDay(String day) {
			this.day = day;
		}
		public String getWeeklyHoliday() {
			return weeklyHoliday;
		}
		public void setWeeklyHoliday(String weeklyHoliday) {
			this.weeklyHoliday = weeklyHoliday;
		}
		public String getPublicHoliday() {
			return publicHoliday;
		}
		public void setPublicHoliday(String publicHoliday) {
			this.publicHoliday = publicHoliday;
		}
		public String getHolidayStrings() {
			return holidayStrings;
		}
		public void setHolidayStrings(String holidayStrings) {
			this.holidayStrings = holidayStrings;
		}
		public Date getEntryTime() {
			return entryTime;
		}
		public void setEntryTime(Date entryTime) {
			this.entryTime = entryTime;
		}
		public Date getModifyTime() {
			return modifyTime;
		}
		public void setModifyTime(Date modifyTime) {
			this.modifyTime = modifyTime;
		}
		public String getDelFlg() {
			return delFlg;
		}
		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}
		public String getEntityFlg() {
			return entityFlg;
		}
		public void setEntityFlg(String entityFlg) {
			this.entityFlg = entityFlg;
		}
		public Calender_Master_Entity(String month, String date, String day, String weeklyHoliday, String publicHoliday,
				String holidayStrings, Date entryTime, Date modifyTime, String delFlg, String entityFlg) {
			super();
			this.month = month;
			this.date = date;
			this.day = day;
			this.weeklyHoliday = weeklyHoliday;
			this.publicHoliday = publicHoliday;
			this.holidayStrings = holidayStrings;
			this.entryTime = entryTime;
			this.modifyTime = modifyTime;
			this.delFlg = delFlg;
			this.entityFlg = entityFlg;
		}
		public Calender_Master_Entity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
