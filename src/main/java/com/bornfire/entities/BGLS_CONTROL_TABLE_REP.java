package com.bornfire.entities;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BGLS_CONTROL_TABLE_REP extends JpaRepository<BGLS_Control_Table, Date>{
	@Query(value="SELECT * FROM BGLS_CONTROL_TABLE", nativeQuery = true)
	BGLS_Control_Table getTranDate();

}
