package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DMD_TABLE_REPO extends JpaRepository<DMD_TABLE, DMD_TABLE_IDclass> {

	@Query(value = "select * from DEMAND_TBL aa where aa.loan_acct_no = ?1 and aa.flow_date<=?2  AND aa.FLOW_CODE NOT IN ('DISBT')", nativeQuery = true)
	List<DMD_TABLE> getdemand(String acct_num,Date flow);
	
	@Query(value = "select TOP 2* from DEMAND_TBL aa where aa.loan_acct_no=?1 and aa.flow_date>=?2 order by FLOW_ID", nativeQuery = true)
	List<DMD_TABLE> getAlldemand(String acct_num,Date flow);
	
	@Query(value = "SELECT DMD_SRL_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	BigDecimal getSrlNo();

	@Query(value = "select * from DEMAND_TBL aa where aa.loan_acct_no = ?1", nativeQuery = true)
	DMD_TABLE gettranpopvalues(String acct_num);

	@Query(value = "SELECT * FROM DEMAND_TBL aa WHERE aa.loan_acct_no = ?1 AND aa.flow_frq <> 'DISBT'", nativeQuery = true)
	List<DMD_TABLE> gettranpopvalues1(String acct_num);

	@Query(value = "SELECT * FROM DEMAND_TBL aa WHERE  aa.flow_date BETWEEN ?1 AND ?2 AND aa.FLOW_CODE NOT IN ('DISBT', 'PRDEM') AND (aa.LOAN_ACCT_NO = ?3 OR ?3 IS NULL OR ?3 = '') ORDER BY aa.FLOW_DATE", nativeQuery = true)
	List<DMD_TABLE> getloanflows(Date fromDate, Date todate, String accountNum);
	
	@Query(value = "SELECT * FROM DEMAND_TBL aa WHERE  aa.flow_date BETWEEN ?1 AND ?2 AND aa.FLOW_CODE NOT IN ('DISBT') AND (aa.LOAN_ACCT_NO = ?3 OR ?3 IS NULL OR ?3 = '') ORDER BY aa.FLOW_DATE", nativeQuery = true)
	List<DMD_TABLE> getloanflows1(Date fromDate, Date todate, String accountNum);

	@Query(value = "select * from DEMAND_TBL where loan_acct_no = ?1 and flow_code=?2 and flow_id=?3", nativeQuery = true)
	DMD_TABLE getDemandData(String acct_num, String flowCode, String flowid);
	
	@Query(value = "SELECT * FROM DEMAND_TBL WHERE loan_acct_no =?1 AND FLOW_DATE =?2", nativeQuery = true)
	DMD_TABLE getflowcode(String acid, Date flow_date);
	
	@Query(value = "SELECT TOP 1 *\r\n"
			+ "FROM DEMAND_TBL\r\n"
			+ "WHERE loan_acct_no =?1 AND FLOW_DATE > ?2 AND FLOW_CODE!='DIBST'\r\n"
			+ "ORDER BY FLOW_DATE ASC ;", nativeQuery = true)
	DMD_TABLE getPreviousFlowCode(String acid, Date flow_date);
	
	@Query(value = "SELECT * FROM DEMAND_TBL aa WHERE aa.FLOW_CODE NOT IN ('DISBT') AND aa.LOAN_ACCT_NO =?1 and aa.FLOW_DATE <= ?2 ORDER BY aa.FLOW_DATE,aa.flow_id,aa.flow_code", nativeQuery = true)
	List<DMD_TABLE> getloanposition(String accountNum,Date tranDate);

}
