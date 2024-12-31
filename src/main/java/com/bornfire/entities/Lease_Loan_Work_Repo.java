package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Lease_Loan_Work_Repo  extends JpaRepository<Lease_Loan_Work_Entity, String>  {
	
	@Query(value = "SELECT * FROM ( SELECT * FROM Loan_AccountMaster_Work WHERE del_flg = 'N' UNION ALL SELECT * FROM Loan_AccountMaster WHERE del_flg = 'N')ORDER BY LOAN_ACCOUNTNO", nativeQuery = true)
	List<Lease_Loan_Work_Entity> getLeaseAccountList();
	
	@Query(value = "select * from Loan_AccountMaster_Work where del_flg = 'N' and loan_accountno=?1  union all select * from Loan_AccountMaster where del_flg = 'N' and loan_accountno=?1", nativeQuery = true)
	Lease_Loan_Work_Entity getLeaseAccount(String accountNo); 
	
	@Query(value = "SELECT customer_id, customer_name FROM Loan_AccountMaster_Work WHERE del_flg = 'N' AND loan_accountno = ?1 UNION ALL SELECT customer_id, customer_name FROM Loan_AccountMaster WHERE del_flg = 'N' AND loan_accountno = ?1;", nativeQuery = true)
    String Custidname(String acct_num );
	
	@Query(value =
			 "SELECT customer_id FROM Loan_AccountMaster_Work WHERE del_flg = 'N' AND loan_accountno = ?1 UNION ALL SELECT customer_id, customer_name FROM Loan_AccountMaster WHERE del_flg = 'N' AND loan_accountno = ?1;"
			  , nativeQuery = true) String getCustid(String acct_num );
			
			 @Query(value =
					 "SELECT customer_name FROM Loan_AccountMaster_Work WHERE del_flg = 'N' AND loan_accountno = ?1 UNION ALL SELECT customer_id, customer_name FROM Loan_AccountMaster WHERE del_flg = 'N' AND loan_accountno = ?1;"
					  , nativeQuery = true) String getCustname(String acct_num );
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from Loan_AccountMaster_Work where loan_accountno=?1 ", nativeQuery = true)
	public void deleteRecord(String accountNo);
	
	@Query(value = "select loan_accountno from Loan_AccountMaster_Work where del_flg = 'N' AND entity_flg = 'Y' union all select loan_accountno from Loan_AccountMaster where del_flg = 'N' AND entity_flg = 'Y' order by LOAN_ACCOUNTNO", nativeQuery = true)
	List<String> getActNo();

}
