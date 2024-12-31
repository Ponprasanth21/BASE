package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.icu.math.BigDecimal;

@Repository
public interface Collection_Process_Repo extends JpaRepository<Collection_Process_Entity, String>{

	@Query(value = "SELECT * from COLLECTION_PROCESS", nativeQuery = true)
	List<Collection_Process_Entity> getlistvalue();

}
