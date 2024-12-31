package com.bornfire.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Transaction_Pointing_Table_Repo extends JpaRepository<Transaction_Pointing_Table_Entity, String> {

	@Query(value = "select * from BGLS_TPT_TRANSACTIONS WHERE org_acct_num=?1 AND bal_outstd_amt != 0", nativeQuery = true)
	List<Transaction_Pointing_Table_Entity> getTranRefRecords(String accountNum);
}
