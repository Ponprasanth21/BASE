package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Collateral_management_Repo extends JpaRepository<Collateral_management_Entity, String>
{
	@Query(value = "select * from BGLS_COLLATERAL_MANAGEMENT", nativeQuery = true)
	List<Collateral_management_Entity> getlist();
	
	@Query(value = "select * from BGLS_COLLATERAL_MANAGEMENT where customer_id=?1", nativeQuery = true)
	Collateral_management_Entity getbyid(String customer_id);
}
