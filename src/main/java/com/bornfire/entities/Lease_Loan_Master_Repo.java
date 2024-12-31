package com.bornfire.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Lease_Loan_Master_Repo extends JpaRepository<Lease_Loan_Master_Entity, String> {
	@Query(value = "select * from Loan_AccountMaster", nativeQuery = true)
	List<Lease_Loan_Master_Entity> getCSlist();
	
	@Query(value = "select * from Loan_AccountMaster where customer_id=?1", nativeQuery = true)
	List<Lease_Loan_Master_Entity> getcusrecords(String cus_id);
	
	@Query(value = "select * from Loan_AccountMaster where loan_accountno= ?1", nativeQuery = true)
	Lease_Loan_Master_Entity findByref_no(String acid);
	
	@Query(value = "select customer_name from Loan_AccountMaster where loan_accountno= ?1", nativeQuery = true)
	String accountName(String acid);
	

	@Query(value = "select a.customer_id, a.loan_accountno,a.customer_name,a.date_of_loan,a.loan_sanctioned ,b.ACCT_BAL  from Loan_AccountMaster a , coa b where \r\n" + 
			" b.ACCT_NUM =a.Loan_AccountNo order by a.loan_accountno", nativeQuery = true)
	List<Object[]> getLeaseBalTran(Date TRANDATE);
	
	@Query(value = "select a.customer_id, a.loan_accountno,a.customer_name,a.date_of_loan,a.loan_sanctioned ,b.ACCT_BAL  from Loan_AccountMaster a , coa b where \r\n" + 
			" b.ACCT_NUM =a.Loan_AccountNo order by a.loan_accountno", nativeQuery = true)
	List<Object[]> getLeaseBal(Date date_of_loan);
	
	@Query(value = "select * from Loan_AccountMaster Order by loan_accountno", nativeQuery = true)
	List<Lease_Loan_Master_Entity> getfewvalue();
	
}
