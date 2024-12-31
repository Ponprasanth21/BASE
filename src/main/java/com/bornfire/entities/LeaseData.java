package com.bornfire.entities;

public class LeaseData {

	private Lease_Loan_Work_Entity loanDetails;
	private NoticeDetailsPayment0Entity repaymentDetails;

	public Lease_Loan_Work_Entity getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(Lease_Loan_Work_Entity loanDetails) {
		this.loanDetails = loanDetails;
	}

	public NoticeDetailsPayment0Entity getRepaymentDetails() {
		return repaymentDetails;
	}

	public void setRepaymentDetails(NoticeDetailsPayment0Entity repaymentDetails) {
		this.repaymentDetails = repaymentDetails;
	}

}
