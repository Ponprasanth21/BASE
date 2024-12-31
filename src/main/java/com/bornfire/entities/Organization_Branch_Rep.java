package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Organization_Branch_Rep extends CrudRepository<Organization_Branch_Entity, String>{

	 @Query(value = "SELECT BRANCH_NAME FROM BGLS_ORG_BRANCH", nativeQuery = true)
	 List<String> getexistingData();
	 
	 @Query(value = "SELECT * FROM BGLS_ORG_BRANCH WHERE DEL_FLG ='N'", nativeQuery = true)
	 List<Organization_Branch_Entity> getbranchlist();
	 
	 @Query(value = "SELECT * FROM BGLS_ORG_BRANCH where BRANCH_NAME =?1 ", nativeQuery = true)
	 Organization_Branch_Entity getOrgBranch(String branch_name);
	 
	 @Query(value = "SELECT branch_code FROM BGLS_ORG_BRANCH", nativeQuery = true)
	 List<String> getbranchid();
		 
}