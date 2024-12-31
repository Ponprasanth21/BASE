package com.bornfire.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TRAN_MAIN_TRM_WRK_REP extends JpaRepository<TRAN_MAIN_TRM_WRK_ENTITY, String>{
	
	
	
	/*Barath*/



	/*
	@Modifying
	@Query(value = "INSERT INTO BGLS_DAILY_ACCT_BAL " +
	               "(GL_CODE, GL_DESC, GLSH_CODE, GLSH_DESC, ACCT_NUM, ACCT_NAME, ACCT_CRNCY, " +
	               "TRAN_DR_BAL, TRAN_CR_BAL, TRAN_DATE_BAL, TRAN_DATE, TRAN_TOT_NET, END_TRAN_DATE, " +
	               "ENTRY_USER_ID, ENTRY_TIME, DEL_FLG) " +
	               "VALUES ('1000', 'ASSET', '1100', 'CASH AND BANK BALANCES', :accountNum, 'BANK ACCOUNT', 'SCR', " +
	               "0.0000, 0.0000, " +
	               "CASE WHEN CAST(:netAmount AS DECIMAL) < 0 THEN -ABS(CAST(:netAmount AS DECIMAL)) ELSE ABS(CAST(:netAmount AS DECIMAL)) END, " +
	               "GETDATE(), :netAmount, '2099-12-31', 'SYSTEM', GETDATE(), 'N')", nativeQuery = true)
	void insertNewAccountBalance(@Param("accountNum") String accountNum, @Param("netAmount") String netAmount);
	
	*/
	
/*	@Query(value = "SELECT TOP 1 TRAN_DATE_BAL FROM BGLS_DAILY_ACCT_BAL " +
		       "WHERE ACCT_NUM = :accountNum " +
		       "ORDER BY TRAN_DATE DESC", nativeQuery = true)
		List<BigDecimal> findTRAN_DATE_BALByAccountNumber(@Param("accountNum") String accountNum);
		
		*/
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END " +
            "FROM BGLS_TRM_WRK_TRANSACTIONS " +
            "WHERE acct_num = :accountNum AND TRAN_DATE = CAST(:tranDate AS DATE)", nativeQuery = true)
int checkTransactionDateExists(@Param("accountNum") String accountNum, @Param("tranDate") String tranDate);


	
	
	@Query(value = "SELECT TRAN_DATE_BAL FROM BGLS_DAILY_ACCT_BAL " +
            "WHERE ACCT_NUM = :accountNum " +
            "AND TRAN_DATE = (SELECT MAX(TRAN_DATE) FROM BGLS_DAILY_ACCT_BAL WHERE ACCT_NUM = :accountNum)", 
            nativeQuery = true)
List<BigDecimal> findLatestTRAN_DATE_BALByAccountNumber(@Param("accountNum") String accountNum);
	
	
/*
 * @Query(value = "SELECT TRAN_DATE_BAL FROM BGLS_DAILY_ACCT_BAL " +
 * "WHERE ACCT_NUM = :accountNum " + "AND TRAN_DATE = :trandate", nativeQuery =
 * true) List<BigDecimal>
 * findLatestTRAN_DATE_BALByAccountNumber(@Param("accountNum") String
 * accountNum, @Param("trandate") String trandate);
 * 
 */

	
	@Modifying
	@Transactional
	@Query(value = "UPDATE BGLS_DAILY_ACCT_BAL SET end_tran_date = :endDate " +
	               "WHERE ACCT_NUM = :accountNum AND END_TRAN_DATE = '2099-12-31'", nativeQuery = true)
	void updateEndDateToYesterday1(@Param("accountNum") String accountNum, @Param("endDate") LocalDate endDate);

	
	
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE BGLS_DAILY_ACCT_BAL SET end_tran_date = 'yesterday' " +
	    "WHERE ACCT_NUM = :accountNum AND END_TRAN_DATE = '2099-12-31'", nativeQuery = true)
	void updateEndDateToYesterday(@Param("accountNum") String accountNum);

	
/*	@Modifying
	@Transactional
	@Query(value = "INSERT INTO BGLS_DAILY_ACCT_BAL " +
	               "(GL_CODE, GL_DESC, GLSH_CODE, GLSH_DESC, ACCT_NUM, ACCT_NAME, ACCT_CRNCY, " +
	               "TRAN_DR_BAL, TRAN_CR_BAL, TRAN_DATE_BAL, TRAN_DATE, TRAN_TOT_NET, END_TRAN_DATE, " +
	               "ENTRY_USER_ID, ENTRY_TIME, DEL_FLG) " +
	               "VALUES ('1000', 'ASSET', '1100', 'CASH AND BANK BALANCES', :accountNum, 'BANK ACCOUNT', 'SCR', " +
	               "0.0000, 0.0000, :tranDateBal, GETDATE(), :netAmount, '2099-12-31', 'SYSTEM', GETDATE(), 'N')", nativeQuery = true)
	void insertNewAccountBalance(@Param("accountNum") String accountNum, 
	                             @Param("tranDateBal") BigDecimal tranDateBal,
	                             @Param("netAmount") BigDecimal netAmount);
	                             */
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO BGLS_DAILY_ACCT_BAL " +
	               "(GL_CODE, GL_DESC, GLSH_CODE, GLSH_DESC, ACCT_NUM, ACCT_NAME, ACCT_CRNCY, " +
	               "TRAN_DR_BAL, TRAN_CR_BAL, TRAN_DATE_BAL, TRAN_DATE, TRAN_TOT_NET, END_TRAN_DATE, " +
	               "ENTRY_USER_ID, ENTRY_TIME, DEL_FLG) " +
	               "VALUES (:glCode, :glDesc, :glshCode, :glshDesc, :accountNum, :acctName, :acctCrncy, " +
	               ":totalDebit, :totalCredit, :tranDateBal, :tranDate, :netAmount, '2099-12-31', 'SYSTEM', GETDATE(), 'N')", 
	               nativeQuery = true)
	void insertNewAccountBalance(@Param("glCode") String glCode,
	                             @Param("glDesc") String glDesc,
	                             @Param("glshCode") String glshCode,
	                             @Param("glshDesc") String glshDesc,
	                             @Param("accountNum") String accountNum, 
	                             @Param("acctName") String acctName,
	                             @Param("acctCrncy") String acctCrncy,
	                             @Param("tranDateBal") BigDecimal tranDateBal,
	                             @Param("tranDate") String tranDate, // Corrected parameter name
	                             @Param("netAmount") BigDecimal netAmount,
	                             @Param("totalDebit") BigDecimal totalDebit,
	                             @Param("totalCredit") BigDecimal totalCredit);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO BGLS_DAILY_ACCT_BAL " +
	               "(GL_CODE, GL_DESC, GLSH_CODE, GLSH_DESC, ACCT_NUM, ACCT_NAME, ACCT_CRNCY, " +
	               "TRAN_DR_BAL, TRAN_CR_BAL, TRAN_DATE_BAL, TRAN_DATE, TRAN_TOT_NET, END_TRAN_DATE, " +
	               "ENTRY_USER_ID, ENTRY_TIME, DEL_FLG) " +
	               "VALUES (:glCode, :glDesc, :glshCode, :glshDesc, :accountNum, :acctName, :acctCrncy, " +
	               ":totalDebit, :totalCredit, :tranDateBal, DATEADD(day, 3, GETDATE()), :netAmount, '2099-12-31', 'SYSTEM', GETDATE(), 'N')", 
	               nativeQuery = true)
	void insertNewAccountBalance1(@Param("glCode") String glCode,
	                             @Param("glDesc") String glDesc,
	                             @Param("glshCode") String glshCode,
	                             @Param("glshDesc") String glshDesc,
	                             @Param("accountNum") String accountNum, 
	                             @Param("acctName") String acctName,
	                             @Param("acctCrncy") String acctCrncy,
	                             @Param("tranDateBal") BigDecimal tranDateBal,
	                             @Param("netAmount") BigDecimal netAmount,
	                             @Param("totalDebit") BigDecimal totalDebit,
	                             @Param("totalCredit") BigDecimal totalCredit);


	
	
@Query(value = "SELECT COUNT(TRAN_AMT) AS COUNTAMT, SUM(TRAN_AMT) AS TRANAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND PART_TRAN_TYPE = 'debit' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(SYSDATE)", nativeQuery = true)
List<Object[]> getWoforDebitValues();

	
@Query(value = "SELECT COUNT(TRAN_AMT) AS COUNTAMT, SUM(TRAN_AMT) AS TRANAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND PART_TRAN_TYPE = 'credit' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(SYSDATE)", nativeQuery = true)
List<Object[]> getWoforcreditValues();


	
@Query(value = "SELECT COUNT(DISTINCT acct_num) AS COUNTACCTNUM,COUNT(TRAN_AMT) AS COUNTAMT,SUM(TRAN_AMT) AS TRANAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(SYSDATE)", nativeQuery = true)
Object[] getWoforTotalValues();



@Query(value = "SELECT acct_num,acct_name,COUNT(TRAN_AMT) AS COUNTAMT,SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT ELSE 0 END) AS TOTAL_CREDIT, SUM(CASE WHEN PART_TRAN_TYPE = 'debit' THEN TRAN_AMT ELSE 0 END) AS TOTAL_DEBIT, SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT WHEN PART_TRAN_TYPE = 'debit' THEN -TRAN_AMT ELSE 0 END) AS NETAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(TO_DATE(:tranDate, 'YYYY-MM-DD')) GROUP BY acct_num, acct_name",  // Group by acct_name as well
        nativeQuery = true)
List<Object[]> getNetDebitCreditWithCountForCurrentDate(@Param("tranDate") String tranDate);

@Query(value = "SELECT acct_num, " +
        "acct_name, " +  // Include acct_name
        "COUNT(TRAN_AMT) AS COUNTAMT, " +
        "SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT ELSE 0 END) AS TOTAL_CREDIT, " +
        "SUM(CASE WHEN PART_TRAN_TYPE = 'debit' THEN TRAN_AMT ELSE 0 END) AS TOTAL_DEBIT, " +
        "SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT " +
        "          WHEN PART_TRAN_TYPE = 'debit' THEN -TRAN_AMT " +
        "          ELSE 0 END) AS NETAMT " +
        "FROM BGLS_TRM_WRK_TRANSACTIONS " +
        "WHERE DEL_FLG != 'Y' " +
        "AND TRAN_STATUS = 'ENTERED' " +
        "AND CAST(TRAN_DATE AS DATE) = CAST(:tranDate AS DATE) " +
        "GROUP BY acct_num, acct_name",  // Group by acct_name as well
        nativeQuery = true)
List<Object[]> getNetDebitCreditWithCountForCurrentDatedemo(@Param("tranDate") String tranDate);

@Query(value = "SELECT acct_num, " +
        "COUNT(TRAN_AMT) AS COUNTAMT, " +
        "SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT ELSE 0 END) AS TOTAL_CREDIT, " +
        "SUM(CASE WHEN PART_TRAN_TYPE = 'debit' THEN TRAN_AMT ELSE 0 END) AS TOTAL_DEBIT, " +
        "SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT " +
        "          WHEN PART_TRAN_TYPE = 'debit' THEN -TRAN_AMT " +
        "          ELSE 0 END) AS NETAMT " +
        "FROM BGLS_TRM_WRK_TRANSACTIONS " +
        "WHERE DEL_FLG != 'Y' " +
        "AND TRAN_STATUS = 'ENTERED' " +
        "AND CAST(TRAN_DATE AS DATE) = CAST(DATEADD(day, 3, GETDATE()) AS DATE) " +
        "GROUP BY acct_num", nativeQuery = true)
List<Object[]> getNetDebitCreditWithCountForCurrentDate1();




@Query(value = "SELECT SUM(CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT ELSE 0 END) - SUM(CASE WHEN PART_TRAN_TYPE = 'debit' THEN TRAN_AMT ELSE 0 END) AS NET_TOTAL FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(TO_DATE(:tranDate, 'YYYY-MM-DD'))", nativeQuery = true)
BigDecimal getTotalValues(@Param("tranDate") String tranDate);



@Query(value = "SELECT SUM(COUNTAMT) AS TOTAL_COUNT " +
        "FROM ( " +
        "    SELECT COUNT(TRAN_AMT) AS COUNTAMT " +
        "    FROM BGLS_TRM_WRK_TRANSACTIONS " +
        "    WHERE DEL_FLG != 'Y' " +
        "    AND TRAN_STATUS = 'POSTED' " +
        "    GROUP BY acct_num " +
        ") AS AccountCounts", nativeQuery = true)
BigDecimal getTotalTransactionCount1();


@Query(value = "SELECT SUM(COUNTAMT) AS TOTAL_COUNT " +
        "FROM ( " +
        "    SELECT COUNT(TRAN_AMT) AS COUNTAMT " +
        "    FROM BGLS_TRM_WRK_TRANSACTIONS " +
        "    WHERE DEL_FLG != 'Y' " +
        "    AND TRAN_STATUS = 'POSTED' " +
        "    AND CAST(TRAN_DATE AS DATE) = CAST(GETDATE() AS DATE) " +  // Filtering by current date
        "    GROUP BY acct_num " +
        ") AS AccountCounts", nativeQuery = true)
BigDecimal getTotalTransactionCount_before();

@Query(value = "SELECT SUM(COUNTAMT) AS TOTAL_COUNT FROM ( SELECT COUNT(TRAN_AMT) AS COUNTAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(TO_DATE(:tranDate, 'YYYY-MM-DD')) GROUP BY acct_num) AccountCounts", nativeQuery = true)
Object getTotalTransactionCount(@Param("tranDate") String tranDate);



@Query(value = "SELECT SUM(TRAN_AMT) AS TOTAL_CREDIT " +
        "FROM BGLS_TRM_WRK_TRANSACTIONS " +
        "WHERE DEL_FLG != 'Y' " +
        "AND PART_TRAN_TYPE = 'credit' " +
        "AND TRAN_STATUS = 'POSTED' " +
        "AND CAST(TRAN_DATE AS DATE) = CAST(GETDATE() AS DATE)", nativeQuery = true)
BigDecimal getTotalCredit_before();

@Query(value = "SELECT SUM(TRAN_AMT) AS TOTAL_CREDIT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND PART_TRAN_TYPE = 'credit' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(TO_DATE(:tranDate, 'YYYY-MM-DD'))", nativeQuery = true)
BigDecimal getTotalCredit(@Param("tranDate") String tranDate);



@Query(value = "SELECT SUM(TRAN_AMT * -1) AS TOTAL_DEBIT " +
        "FROM BGLS_TRM_WRK_TRANSACTIONS " +
        "WHERE DEL_FLG != 'Y' " +
        "AND PART_TRAN_TYPE = 'debit' " +
        "AND TRAN_STATUS = 'POSTED' " +
        "AND CAST(TRAN_DATE AS DATE) = CAST(GETDATE() AS DATE)", 
nativeQuery = true)
BigDecimal getTotalDebit_before();

@Query(value = "SELECT SUM(TRAN_AMT * -1) AS TOTAL_DEBIT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND PART_TRAN_TYPE = 'debit' AND TRAN_STATUS = 'POSTED' AND TRUNC(TRAN_DATE) = TRUNC(TO_DATE(:tranDate, 'YYYY-MM-DD'))", 
        nativeQuery = true)
BigDecimal getTotalDebit(@Param("tranDate") String tranDate);



@Query(value = "select  * from BGLS_TRM_WRK_TRANSACTIONS where  acct_num IN (:acctnum) ", nativeQuery = true)
List<TRAN_MAIN_TRM_WRK_ENTITY> set_dab_acc_num(@Param("acctnum") List<String> acctnum);
/*till this Barath*/
	
	@Query(value = "SELECT COUNT(TRAN_AMT) as COUNTAMT,SUM(TRAN_AMT) AS TRANAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG !='Y' AND PART_TRAN_TYPE='debit' AND TRAN_STATUS='POSTED'", nativeQuery = true)
	Object[] getwofordebitvalues();

	@Query(value = "SELECT COUNT(TRAN_AMT) as COUNTAMT,SUM(TRAN_AMT) AS TRANAMT FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG !='Y' AND PART_TRAN_TYPE='credit' AND TRAN_STATUS='POSTED'", nativeQuery = true)
	Object[] getwoforcreditvalues();

	@Query(value = "SELECT COUNT(TRAN_AMT) AS COUNTAMT, SUM(CASE WHEN PART_TRAN_TYPE = 'Debit' THEN -1 * TRAN_AMT  WHEN PART_TRAN_TYPE = 'Credit' THEN 1 * TRAN_AMT ELSE 0 END) AS TRANAMT  FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG != 'Y' AND TRAN_STATUS = 'POSTED'", nativeQuery = true)
	Object[] getTransactionValues();
	
	@Query(value = "SELECT COUNT(PART_TRAN_TYPE) as TRAN_TYPE FROM BGLS_TRM_WRK_TRANSACTIONS WHERE DEL_FLG='Y'", nativeQuery = true)
	Object getdelvalues();

	@Query(value = "SELECT COUNT(DISTINCT(TRAN_ID)) as ID FROM BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_STATUS='ENTERED'", nativeQuery = true)
	Object getunpostedvalues();

	
	@Query(value = "SELECT OrderIDSequence.NEXTVAL FROM DUAL", nativeQuery = true)
	String gettrmRefUUID();
	
	@Query(value = "SELECT TRAN_ID_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
	String gettrmRefUUID1();
	
	@Query(value = "select  * from BGLS_TRM_WRK_TRANSACTIONS order by TRAN_DATE,TRAN_ID,PART_TRAN_ID ", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> findByjournal();
	
	@Query(value = "select  * from BGLS_TRM_WRK_TRANSACTIONS where tran_date=?1 order by TRAN_DATE,TRAN_ID,PART_TRAN_ID  ", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> findByjournal1(Date date);
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS aa where aa.part_tran_id =?2 and aa.tran_id =?1 ", nativeQuery = true)
	TRAN_MAIN_TRM_WRK_ENTITY getmodifyjournal(String tran_id, String part_tran_id);
	
	@Query(value = "select  * from BGLS_TRM_WRK_TRANSACTIONS where tran_id=?1", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> findByjournalmodify();
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS aa where aa.part_tran_id =?2 and aa.tran_id =?1 ", nativeQuery = true)
	TRAN_MAIN_TRM_WRK_ENTITY getValuepop(String tran_id, String part_tran_id);
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS aa where aa.part_tran_id =?3 and aa.tran_id =?1 and aa.acct_num = ?2 ", nativeQuery = true)
	TRAN_MAIN_TRM_WRK_ENTITY getValuepopvalues(String tran_id, String acct_num, String part_tran_id);
	
	@Query(value = "select  * from BGLS_TRM_WRK_TRANSACTIONS where tran_id = ?1", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> findByjournalvalues(String tran_id);
	
	@Query(value = "select tran_id,Part_tran_id from BGLS_TRM_WRK_TRANSACTIONS aa where aa.acct_num = ?1", nativeQuery = true)
	TRAN_MAIN_TRM_WRK_ENTITY gettranpopvalues(String acct_num);
	
	@Query(value = "select tran_amt from BGLS_TRM_WRK_TRANSACTIONS WHERE part_tran_type = 'Credit' AND TRAN_ID = ?1 AND PART_TRAN_ID=?2", nativeQuery = true)
	BigDecimal getcredit(String tran_id,BigDecimal partTranID);
	
	@Query(value = "select tran_amt from BGLS_TRM_WRK_TRANSACTIONS WHERE part_tran_type = 'Debit' AND TRAN_ID = ?1 AND PART_TRAN_ID=?2", nativeQuery = true)
	BigDecimal getdebit(String tran_id,BigDecimal partTranID);
	
	@Query(value = "SELECT TRAN_DATE,TRAN_ID || '/' || TO_CHAR(PART_TRAN_ID) AS TRANSACTION_ID,TRAN_PARTICULAR,ACCT_CRNCY,TRAN_AMT,CASE WHEN PART_TRAN_TYPE = 'credit' THEN TRAN_AMT ELSE 0 END AS Credit,CASE WHEN PART_TRAN_TYPE = 'debit' THEN TRAN_AMT ELSE 0 END AS Debit FROM BGLS_TRM_WRK_TRANSACTIONS WHERE ACCT_NUM = '1500001000' AND TRAN_STATUS = 'POSTED' ORDER BY TRAN_DATE, TRAN_ID, PART_TRAN_ID", nativeQuery = true)
	List<Object[]> getList(@Param("acct_num") String acct_num);
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS aa where aa.acct_num = ?1", nativeQuery = true)
	TRAN_MAIN_TRM_WRK_ENTITY gettranpopvaluesdata(String acct_num);
	
	@Query(value = "SELECT MAX(part_tran_id) AS part_tran_id FROM BGLS_TRM_WRK_TRANSACTIONS WHERE tran_id =?1", nativeQuery = true)
	String  maxPartranID(String tranId);
	
	@Query(value = "SELECT MIN(part_tran_id) AS part_tran_id FROM BGLS_TRM_WRK_TRANSACTIONS WHERE tran_id = ?1", nativeQuery = true)
	String minPartTranID(String tranId);
	
	@Query(value = "SELECT COUNT(DISTINCT part_tran_id) FROM BGLS_TRM_WRK_TRANSACTIONS WHERE tran_id = ?1", nativeQuery = true)
	Integer countPartTranIDs(String tranId);

	@Query(value = "SELECT DISTINCT part_tran_id FROM BGLS_TRM_WRK_TRANSACTIONS WHERE tran_id = ?1", nativeQuery = true)
	List<Integer> currentTableRecords(String tranId);


	
	@Query(value = "SELECT * FROM BGLS_TRM_WRK_TRANSACTIONS WHERE ACCT_NUM = ?1 AND TRAN_DATE BETWEEN CAST(?2 AS DATE) AND CAST(?3 AS DATE) AND TRAN_STATUS='POSTED' ORDER BY TRAN_ID", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> getTranList(String acct_num, String fromdate, String todate);
	
	@Query(value = "SELECT TRAN_DATE_BAL FROM BGLS_TRM_WRK_TRANSACTIONS " +
            "WHERE ACCT_NUM = ?1 " +
            "AND TRAN_DATE = DATEADD(day, -1, CAST(?2 AS DATE))", 
    nativeQuery = true)
	BigDecimal getTranDateBAlance(String acct_num, String fromdateref);
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS WHERE acct_num =?1 AND TRAN_STATUS='POSTED' ORDER BY TRAN_DATE", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> findbyacctno(String acct_num);
	
	/*
	 * @Query(value =
	 * "SELECT * FROM BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_DATE = :current",
	 * nativeQuery = true) List<TRAN_MAIN_TRM_WRK_ENTITY> passdate(@Param("current")
	 * Date current);
	 */
	
	/*Thanveer Consistency check*/
	
	@Query(value = "SELECT " +
            "SUM(CASE WHEN PART_TRAN_TYPE = 'CREDIT' THEN TRAN_AMT ELSE 0 END) AS TRANAMT_CREDIT, " +
            "SUM(CASE WHEN PART_TRAN_TYPE = 'DEBIT' THEN TRAN_AMT ELSE 0 END) AS TRANAMT_DEBIT " +
            "FROM BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_STATUS= 'POSTED'", 
    nativeQuery = true)
Object[] getcheck1();

	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_DATE=?1 AND ENTRY_USER=?2 AND ACCT_NUM LIKE '%LA%' ORDER BY TRAN_ID", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> getTransactionRecords(Date con_date,String user);
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_DATE=?1", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> getvalueusingdate(Date date);
	
	
	
	@Query(value = "select * from BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_DATE=?1 AND tran_status='POSTED'", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> getswiftvalues(Date date);
	

	@Query(value = "SELECT * FROM  BGLS_TRM_WRK_TRANSACTIONS WHERE TRAN_DATE=?1", nativeQuery = true)
	List<TRAN_MAIN_TRM_WRK_ENTITY> getbalance( Date selectedDate);	
}
