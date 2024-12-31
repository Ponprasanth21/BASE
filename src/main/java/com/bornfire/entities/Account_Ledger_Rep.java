package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.icu.math.BigDecimal;

@Repository
public interface Account_Ledger_Rep extends JpaRepository<Account_Ledger_Entity, journalentries_embededid> {

	
	@Query(value = "SELECT TRAN_DATE,TRAN_ID + '/' + CAST(PART_TRAN_ID AS VARCHAR(50)) AS TRANSACTION_ID, TRAN_PARTICULAR,ACCT_CRNCY, TRAN_AMT,CASE PART_TRAN_TYPE WHEN 'debit' THEN TRAN_AMT ELSE 0 END as Credit,CASE PART_TRAN_TYPE  WHEN 'credit' THEN TRAN_AMT ELSE 0 END as Debit FROM BGLS_JOURNAL_ENTRIES WHERE acct_num =?1 ORDER BY TRAN_DATE", nativeQuery = true)
	List<Object[]> getList(@Param("acct_num") String acct_num);

	@Query(value = "select  * from BGLS_JOURNAL_ENTRIES ", nativeQuery = true)
	List<Account_Ledger_Entity> findByjournal();

	@Query(value = "select  * from BGLS_JOURNAL_ENTRIES where TRAN_STATUS = 'ENTERED'", nativeQuery = true)
	List<Account_Ledger_Entity> findByjournalval();

	@Query(value = "SELECT * FROM BGLS_JOURNAL_ENTRIES WHERE acct_num =?1", nativeQuery = true)
	Account_Ledger_Entity getjourform(String acct_num);

	@Query(value = "SELECT * FROM BGLS_JOURNAL_ENTRIES  WHERE acct_name LIKE '%GST%' ORDER BY TRAN_ID", nativeQuery = true)
	List<Account_Ledger_Entity> findByjournalgst();

	@Query(value = "SELECT * FROM BGLS_JOURNAL_ENTRIES  ORDER BY tran_id", nativeQuery = true)
	List<Account_Ledger_Entity> popup();

	// @Query(value = "select * from INFOSYS.BDD01 aa where aa.srl_no =?2 and
	// aa.syn_loan_ref = ?1 union all select * from INFOSYS.GUARANTOR_DETAILS bb
	// where bb.srl_no =?2 and bb.syn_loan_ref = ?1", nativeQuery = true)
	// Account_Ledger_Entity getValueByLoanRefAndSrlNo(String syn_loan_ref, String
	// srl_no);

	@Query(value = "select * from BGLS_JOURNAL_ENTRIES aa where aa.part_tran_id =?3 and aa.tran_id =?1 and aa.acct_num = ?2 ", nativeQuery = true)
	Account_Ledger_Entity getValuepop(String tran_id, String acct_num, String part_tran_id);

	@Query(value = "SELECT TOP 1 tran_id FROM BGLS_JOURNAL_ENTRIES ORDER BY entry_time DESC", nativeQuery = true)
	String getlast();

	@Query(value = "select SRL_NO_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String getsrlNo();

	@Query(value = "SELECT * FROM BGLS_JOURNAL_ENTRIES WHERE ACCT_NUM = ?1 AND CAST(TRAN_DATE AS DATE) BETWEEN CAST(?2 AS DATE) AND CAST(?3 AS DATE)", nativeQuery = true)
	List<Account_Ledger_Entity> getTranList(String acct_num, String fromdate, String todate);

	@Query(value = "select  * from BGLS_JOURNAL_ENTRIES where tran_id = ?1", nativeQuery = true)
	List<Account_Ledger_Entity> findByjournalvalues(String tran_id);

	@Query(value = "select tran_amt from BGLS_JOURNAL_ENTRIES WHERE part_tran_type = 'CREDIT' AND TRAN_ID = ?1", nativeQuery = true)
	List<String> getcredit(String tran_id);

	@Query(value = "select tran_amt from BGLS_JOURNAL_ENTRIES WHERE part_tran_type = 'DEBIT' AND TRAN_ID = ?1", nativeQuery = true)
	List<String> getdebit(String tran_id);

	@Query(value = "select  * from BGLS_JOURNAL_ENTRIES where tran_id = ?1 and part_tran_type = ?2", nativeQuery = true)
	List<Account_Ledger_Entity> getalldetails(String tran_id, String part_tran_type);

	@Query(value = "select  acct_num from BGLS_JOURNAL_ENTRIES where tran_id = ?1 and part_tran_type = 'CREDIT'", nativeQuery = true)
	List<Account_Ledger_Entity> getcreditaccount(String tran_id);

	@Query(value = "select  acct_num from BGLS_JOURNAL_ENTRIES where tran_id = ?1 and part_tran_type = 'DEBIT'", nativeQuery = true)
	List<Account_Ledger_Entity> getdebitaccount(String tran_id);
}