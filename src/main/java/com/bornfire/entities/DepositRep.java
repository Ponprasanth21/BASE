package com.bornfire.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRep extends JpaRepository<DepositEntity, String> {


	@Query(value="SELECT * FROM BGLS_DEPOSIT_WORK", nativeQuery = true)
	List<DepositEntity> getdata();
	
	@Query(value="SELECT * FROM BGLS_DEPOSIT_WORK WHERE CUST_ID =?1", nativeQuery = true)
	DepositEntity getCustdata(String cust_id);
	
	@Query(value="SELECT DEPO_ACTNO FROM BGLS_DEPOSIT_WORK order by DEPO_ACTNO", nativeQuery = true)
	List<String> getexistingData();
	
	@Query(value="SELECT * FROM BGLS_DEPOSIT_WORK WHERE DEPO_ACTNO =?1", nativeQuery = true)
	DepositEntity getCustdataact(String DEPO_ACTNO);
	
	@Query(value="SELECT * FROM BGLS_DEPOSIT_WORK", nativeQuery = true)
	List<DepositEntity> getdatavalues();
	
	@Query(value="SELECT * FROM BGLS_DEPOSIT_WORK WHERE DEPO_ACTNO =?1", nativeQuery = true)
	DepositEntity getCustdataactval(String AccountNO);
	
	@Query(value="SELECT cust_name FROM BGLS_DEPOSIT_WORK WHERE DEPO_ACTNO =?1", nativeQuery = true)
	String getCustName(String AccountNO);
	
	@Query(value="SELECT cust_id FROM BGLS_DEPOSIT_WORK WHERE DEPO_ACTNO =?1", nativeQuery = true)
	String getCustId(String AccountNO);
	
	@Query(value = "select a.cust_id, a.depo_actno,a.cust_name,a.deposit_date,a.deposit_amt, a.deposit_period,a.rate_of_int,a.maturity_date,b.ACCT_BAL  from BGLS_DEPOSIT_WORK a , coa b where \r\n" + 
			" b.ACCT_NUM =a.depo_actno  and a.deposit_date = CONVERT(DATE, ?1, 105) ", nativeQuery = true)
	List<Object[]> getDepositBalTran(Date TRANDATE);
	
	@Query(value = "select a.cust_id, a.depo_actno,a.cust_name,a.deposit_date,a.deposit_amt, a.deposit_period,a.rate_of_int,a.maturity_date  from BGLS_DEPOSIT_WORK a where \r\n" + 
			"a.deposit_date = CONVERT(DATE, ?1, 105) ", nativeQuery = true)
	List<Object[]> getDepositBal(Date deposit_period);

}
