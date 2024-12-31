package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Budget_Maintanance_Repo  extends JpaRepository<Budget_Maintanace_Entity, String> {
	
	@Query(value = "SELECT * FROM BGLS_BUDGET_TABLE ORDER BY CLASSIFICATION DESC", nativeQuery = true)
    List<Budget_Maintanace_Entity> getList();

}
