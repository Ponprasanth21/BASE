package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Loan_Repayment_Master_Repo extends JpaRepository<Loan_Repayment_Master_Entity, LoanMasterPaymentIDCLASS> {

}
