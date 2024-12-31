package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipatingBanks_Repo extends JpaRepository<ParticipatingBanks_Entity, String>{
	
	@Query(value = "SELECT * FROM BANK_BRANCH_TABLE ", nativeQuery = true)
    List<ParticipatingBanks_Entity> getList();
    
    @Query(value = "SELECT  * FROM  BANK_BRANCH_TABLE WHERE settlement_account_no=?1", nativeQuery = true)
    ParticipatingBanks_Entity getList(String acct_num);
	
}
