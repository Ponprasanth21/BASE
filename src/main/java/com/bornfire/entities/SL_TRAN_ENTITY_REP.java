package com.bornfire.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SL_TRAN_ENTITY_REP extends JpaRepository<SL_TRAN_TABLE_ENTITY, TRANIDCLASS> {

	@Query(value = "SELECT * FROM INFOSYS.SL_TRAN_TABLE WHERE TO_CHAR(TRAN_DATE, 'DD-MM-YY') <> ?1", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> getOutDateRecord(String currentDate);
	
	@Query(value = "SELECT * FROM INFOSYS.SL_TRAN_TABLE", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> getAllRecord();
	
	@Query(value = "SELECT * FROM INFOSYS.SL_TRAN_TABLE WHERE srl_no = ?1", nativeQuery = true)
	SL_TRAN_TABLE_ENTITY getDetailsBySrlNo(String srl_no);
	
	@Query(value = "select tran_date,value_date,tran_id,tran_particular, CASE WHEN part_tran_type = 'Cr' THEN tran_amt END AS credit_tran_amount,CASE WHEN part_tran_type = 'Dr' THEN tran_amt END AS debit_tran_amount ,flow_amt,tran_remarks,acct_num \r\n"
			+ "from INFOSYS.SL_TRAN_TABLE where acct_num = ?1 and tran_date between ?2 and ?3 ORDER BY TRAN_DATE", nativeQuery = true)
	List<Object[]> getRecordFromSLTran(String loan_acct_no, Date start_date, Date end_date);
	
	@Query(value = "select  * from INFOSYS.SL_TRAN_TABLE where tran_id= ?1 and part_tran_id=?2", nativeQuery = true)
	SL_TRAN_TABLE_ENTITY findBytrain(String tran_id, String part);

	@Query(value = "SELECT COUNT(*) FROM INFOSYS.SL_TRAN_TABLE WHERE Tran_id= ?1", nativeQuery = true)
	String findCount(String tran_id);

	@Query(value = "select * from INFOSYS.SL_TRAN_TABLE", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> getlist();

	@Query(value = "SELECT tran_id FROM INFOSYS.SL_TRAN_TABLE FETCH FIRST 1 ROW ONLY", nativeQuery = true)
	String getlast();

	@Query(value = "SELECT PART_TRAN_ID FROM INFOSYS.SL_TRAN_TABLE order by PART_TRAN_ID desc FETCH FIRST 1 ROW ONLY", nativeQuery = true)
	String getparttran();

	@Query(value = "select * from  INFOSYS.SL_TRAN_TABLE where tran_id=?1", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> gettone(String tran_id);

	@Query(value = "select tran_date,value_date,tran_id,tran_particular, CASE WHEN part_tran_type = 'C' THEN tran_amt END AS credit_tran_amount,CASE WHEN part_tran_type = 'D' THEN tran_amt END AS debit_tran_amount ,flow_amt,tran_remarks,acct_num from INFOSYS.SL_TRAN_TABLE ORDER BY TRAN_DATE", nativeQuery = true)
	List<Object[]> getTransactionList();

	@Query(value = "select  distinct acct_num,acct_name from SL_TRAN_TABLE where flow_id is not null union select distinct acct_num,acct_name from SL_TRAN_HIST where flow_id is not null", nativeQuery = true)
	List<Object[]> getAccountNumberList();

	@Query(value = "SELECT * FROM INFOSYS.SL_TRAN_TABLE WHERE validate_flg = 'Y'", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> getVerifiedRecord();

	@Query(value = "SELECT part_tran_id FROM (SELECT * FROM INFOSYS.SL_TRAN_TABLE WHERE acct_num = ?1 AND flow_id = 'PDCOL' ORDER BY PART_TRAN_ID DESC) WHERE ROWNUM = 1", nativeQuery = true)
	Integer getPartTranId(String acctNum);

	@Query(value = "SELECT MAX(TO_NUMBER(numeric_part)) AS max_numeric_part FROM (SELECT REGEXP_REPLACE(tran_id, '[^[:digit:]]', '') AS numeric_part FROM sl_tran_table UNION ALL SELECT REGEXP_REPLACE(tran_id, '[^[:digit:]]', '') AS numeric_part FROM sl_tran_hist)", nativeQuery = true)
	String getTranId();

	@Query(value = "SELECT * FROM INFOSYS.SL_TRAN_TABLE where flow_id = 'PDCOL' and validate_flg = 'N' ORDER BY tran_id", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> getAllTran();

	@Query(value = "SELECT * FROM INFOSYS.SL_TRAN_TABLE where tran_id = ?1 and validate_flg = 'N'", nativeQuery = true)
	List<SL_TRAN_TABLE_ENTITY> getAllTranByTranId(String tranId);
	
	@Modifying
	@Query(value = "DELETE FROM INFOSYS.SL_TRAN_TABLE aa WHERE aa.DEL_FLG = 'N' and aa.tran_id = ?1", nativeQuery = true)
	void deleteById(String tran_id);
	
	@Modifying
	@Query(value = "DELETE FROM INFOSYS.SL_TRAN_TABLE aa WHERE aa.tran_id = ?1", nativeQuery = true)
	void deleteByIdInRecovery(String tran_id);
	
	@Modifying
    @Query(value = "COMMIT", nativeQuery = true)
	void commitCmd();

}

