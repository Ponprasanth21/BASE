package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Templates_Data_Rep extends JpaRepository<Templates_Data_Entity, String>{
	@Query(value = "select * from TEMPLATE_TABLE where template_id=?1", nativeQuery = true)
	Templates_Data_Entity getRole(String template_id);
}
