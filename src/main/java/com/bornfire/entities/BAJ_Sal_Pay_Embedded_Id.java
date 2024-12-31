package com.bornfire.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class BAJ_Sal_Pay_Embedded_Id implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	private String emp_no;
	@Id
	private String salary_month;
	@Id
	private String emp_name;
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getSalary_month() {
		return salary_month;
	}
	public void setSalary_month(String salary_month) {
		this.salary_month = salary_month;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
