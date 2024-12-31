package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Principle_and_intrest_shedule_Rep extends JpaRepository<Principle_and_intrest_shedule_Entity, BigDecimal>{

	@Query(value = "SELECT INFOSYS.P_AND_I_SCHE_SEQ.NEXTVAL AS SRL_NO FROM DUAL", nativeQuery = true)
	BigDecimal getSrlNo();
	
	@Query(value = "SELECT TOP 1 INSTALLMENT_ID FROM principle_and_interest_schedule_table WHERE LOAN_ACCOUNT_NO = ?1 ORDER BY CAST(INSTALLMENT_ID AS INT) DESC", nativeQuery = true)
	String getInstallmentId(String loanAccount);
	
	@Query(value = "SELECT * FROM principle_and_interest_schedule_table WHERE LOAN_ACCOUNT_NO =?1 AND INSTALLMENT_ID = ?2 ORDER BY CAST(NO_OF_INSTALMENT AS INT) ASC", nativeQuery = true)
	List<Principle_and_intrest_shedule_Entity> getInstallmentrecords(String loanAccount,String inst_id);
	
	@Query(value = "SELECT INSTALLMENT_DATE FROM PRINCIPLE_AND_INTEREST_SCHEDULE_TABLE WHERE LOAN_ACCOUNT_NO=?1 AND INSTALLMENT_DATE =?2 AND INSTALLMENT_ID = (SELECT MAX(A.INSTALLMENT_ID) FROM PRINCIPLE_AND_INTEREST_SCHEDULE_TABLE A where A.LOAN_ACCOUNT_NO=?1)", nativeQuery = true)
	Date getDueDate(String loanAccount,String currentDate);
	
	
}
