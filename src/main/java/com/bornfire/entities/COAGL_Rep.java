package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface COAGL_Rep extends JpaRepository<COAGL_Entity, String>{

	@Query(value = "SELECT * FROM BGLS_COAGL WHERE del_flg='N' ORDER BY CLASSIFICATION ASC", nativeQuery = true)
    List<Chart_Acc_Entity> getList();
}
