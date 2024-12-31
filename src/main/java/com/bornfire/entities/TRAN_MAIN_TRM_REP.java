package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TRAN_MAIN_TRM_REP extends JpaRepository<TRAN_MAIN_TRM_ENTITY, String>{
	@Query(value = "SELECT OrderIDSequence.NEXTVAL FROM DUAL", nativeQuery = true)
	String gettrmRefUUID();
	
	@Query(value = "SELECT TRAN_ID_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
	String gettrmRefUUID1();
}
