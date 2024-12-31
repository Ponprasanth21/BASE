package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandEvalFormRep extends JpaRepository<CandEvalFormEntity, String> {

	@Query(value = "select * from BAJ_CANDI_EVALU_FORM", nativeQuery = true)
	 List<CandEvalFormEntity> getCVFList();
	
	@Query(value = "SELECT DISTINCT ref_no FROM BAJ_CANDI_EVALU_FORM", nativeQuery = true)
	List<String> getCVFLists();

	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1",nativeQuery = true)
	CandEvalFormEntity getCVFform(String ref_no);
	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1", nativeQuery = true)
	List<CandEvalFormEntity> getCvfmail(String ref_no);

	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1", nativeQuery = true)
	CandEvalFormEntity gethashmap(String ref_no);
	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1",nativeQuery = true)
	CandEvalFormEntity getCVFforms(String ref_no);
	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1", nativeQuery = true)
	CandEvalFormEntity getoffer(String ref_no);
	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1",nativeQuery = true)
	CandEvalFormEntity getappointment(String ref_no);


	
}