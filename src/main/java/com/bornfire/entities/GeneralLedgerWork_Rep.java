package com.bornfire.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralLedgerWork_Rep extends CrudRepository<GeneralLedgerWork_Entity,String> {

	@Query(value = "SELECT * from BGLS_GL_WORK ", nativeQuery = true)
	List<GeneralLedgerWork_Entity> getlistvalue();
	

	
}
