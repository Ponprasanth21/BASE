package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BAJAccountLedgerRepo extends JpaRepository<BAJAccountLedger_Entity, String>{

	@Query(value = "select * from COA_VIEW where ENTITY_FLG='Y' and DEL_FLG='N' ORDER BY ACCT_NUM ASC", nativeQuery = true)
	List<BAJAccountLedger_Entity> getList();
	
	@Query(value = "Select * From COA_VIEW Where acct_num =?1 ", nativeQuery = true)
	BAJAccountLedger_Entity getaccno(String acct_num);
	
	@Query(value = "Select * From COA_VIEW Where acct_num =?1 ", nativeQuery = true)
	List<BAJAccountLedger_Entity> getaccnodata(String acct_num);
}
