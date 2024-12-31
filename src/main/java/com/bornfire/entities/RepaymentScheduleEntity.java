package com.bornfire.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RepaymentScheduleEntity {
	private int scheduleNo;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date originalDemandDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date demandDate;
	private String demandType;
	private String demandId;
	private double demandAmount;
	private int installmentNo;
	private String remarks;

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public Date getOriginalDemandDate() {
		return originalDemandDate;
	}

	public void setOriginalDemandDate(Date originalDemandDate) {
		this.originalDemandDate = originalDemandDate;
	}

	public Date getDemandDate() {
		return demandDate;
	}

	public void setDemandDate(Date demandDate) {
		this.demandDate = demandDate;
	}

	public String getDemandType() {
		return demandType;
	}

	public void setDemandType(String demandType) {
		this.demandType = demandType;
	}

	public String getDemandId() {
		return demandId;
	}

	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}

	public double getDemandAmount() {
		return demandAmount;
	}

	public void setDemandAmount(double demandAmount) {
		this.demandAmount = demandAmount;
	}

	public int getInstallmentNo() {
		return installmentNo;
	}

	public void setInstallmentNo(int installmentNo) {
		this.installmentNo = installmentNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public RepaymentScheduleEntity(int scheduleNo, Date originalDemandDate, Date demandDate, String demandType,
			String demandId, double demandAmount, int installmentNo, String remarks) {
		super();
		this.scheduleNo = scheduleNo;
		this.originalDemandDate = originalDemandDate;
		this.demandDate = demandDate;
		this.demandType = demandType;
		this.demandId = demandId;
		this.demandAmount = demandAmount;
		this.installmentNo = installmentNo;
		this.remarks = remarks;
	}

	public RepaymentScheduleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
