package com.bornfire.entities;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralLedgerRep extends CrudRepository<GeneralLedgerEntity,String> {
	
	public Optional<GeneralLedgerEntity> findById(String refId);
	
	@Query(value = "SELECT * from BGLS_GENERAL_LED WHERE del_flg='N' ", nativeQuery = true)
	List<GeneralLedgerEntity> getRefCodelist();
	
	@Query(value = "SELECT * from BGLS_GENERAL_LED WHERE GL_CODE=?1 ", nativeQuery = true)
	GeneralLedgerEntity getRefMaster(String GL_CODE);
	
	@Query(value = "SELECT * from BGLS_GENERAL_LED WHERE GL_CODE=?1 OR GLSH_CODE=?2", nativeQuery = true)
	GeneralLedgerEntity getsinglevaluedata(String GL_CODE,String glsh_Code);
	
	@Query(value = "SELECT * from BGLS_GENERAL_LED", nativeQuery = true)
	List<GeneralLedgerEntity> getlistvalue();
	
	@Query(value = "SELECT * from BGLS_GENERAL_LED WHERE GLSH_CODE=?1", nativeQuery = true)
	GeneralLedgerEntity getsinglevalue(String glsh_Code);

	@Modifying
	@Transactional
	@Query(value = "UPDATE BGLS_GENERAL_LED " +
            "SET total_balance = COA_SUM.ACCT_BAL " +
            "FROM BGLS_GENERAL_LED " +
            "JOIN (SELECT GLSH_CODE, SUM(ACCT_BAL) AS ACCT_BAL FROM COA GROUP BY GLSH_CODE) AS COA_SUM " +
            "ON BGLS_GENERAL_LED.GLSH_CODE = COA_SUM.GLSH_CODE", 
    nativeQuery = true)
	void getupdateglwork();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE BGLS_GENERAL_LED " +
	               "SET no_acct_opened = updateacct.NO_OF_ACCT_OPENED " +
	               "FROM BGLS_GENERAL_LED " +
	               "JOIN (SELECT GLSH_CODE, COUNT(ACCT_CLS_FLG) AS NO_OF_ACCT_OPENED " +
	                     "FROM COA WHERE ACCT_CLS_FLG = 'N' " +
	                     "GROUP BY GLSH_CODE) AS updateacct " +
	               "ON BGLS_GENERAL_LED.GLSH_CODE = updateacct.GLSH_CODE", 
	       nativeQuery = true)
	void updateNoAcctOpened();	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE BGLS_GENERAL_LED " +
	               "SET no_acct_closed = updateacct.NO_OF_ACCT_CLOSED " +
	               "FROM BGLS_GENERAL_LED " +
	               "JOIN (SELECT GLSH_CODE, COUNT(ACCT_CLS_FLG) AS NO_OF_ACCT_CLOSED " +
	                     "FROM COA WHERE ACCT_CLS_FLG = 'Y' " +
	                     "GROUP BY GLSH_CODE) AS updateacct " +
	               "ON BGLS_GENERAL_LED.GLSH_CODE = updateacct.GLSH_CODE", 
	       nativeQuery = true)
	void updateNoAcctClosed();
}
