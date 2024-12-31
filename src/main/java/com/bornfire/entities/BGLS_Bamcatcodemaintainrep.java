package com.bornfire.entities;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BGLS_Bamcatcodemaintainrep extends JpaRepository<BGLS_Bamcategorycodemain_entity, String>{
	@Query(value = "select * from BGLS_BAMCATEGORY_CODE_MAINTAINANCE where head_code=?1 ", nativeQuery = true)
	BGLS_Bamcategorycodemain_entity getheadcode(String headcode);
	
	@Query(value = "select * from BGLS_BAMCATEGORY_CODE_MAINTAINANCE ", nativeQuery = true)
	List<BGLS_Bamcategorycodemain_entity> getall();
	
	@Query(value = "select * from BGLS_BAMCATEGORY_CODE_MAINTAINANCE where asset_code=?1 ", nativeQuery = true)
	BGLS_Bamcategorycodemain_entity getbyId(String asset_code);
	
	@Query(value = "SELECT * FROM BGLS_BAMCATEGORY_CODE_MAINTAINANCE ORDER BY sl_no", nativeQuery = true)
	List<BGLS_Bamcategorycodemain_entity> findAllOrderedBySlNo(); 
}
