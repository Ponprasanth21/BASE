package com.bornfire.entities;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Salary_Pay_Rep extends JpaRepository<Salary_Pay_Entity, String>{
	
	@Query(value = "SELECT * FROM BAJ_SAL_STR WHERE del_flg='N' AND emp_no IN (SELECT DISTINCT emp_no FROM BAJ_SAL_STR) ORDER BY emp_no", nativeQuery = true)
    List<Salary_Pay_Entity> getList();

	@Query(value = "SELECT * FROM BAJ_SAL_STR WHERE emp_no =?1", nativeQuery = true)
    Salary_Pay_Entity getaedit(String emp_no );
	
	@Query(value = "select  * from BAJ_CANDI_EVALU_FORM where ref_no= ?1",nativeQuery = true)
	String getsalfromcvf(String ref_no);
	
}