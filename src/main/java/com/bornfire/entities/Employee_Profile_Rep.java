package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_Profile_Rep extends JpaRepository<Employee_Profile, String>{
	
	@Query(value="SELECT EMPLOYEE_ID FROM BGLS_EMPLOYEE_PROFILE", nativeQuery = true)
	List<String> getexistingData();
	
	@Query(value="SELECT * FROM BGLS_EMPLOYEE_PROFILE", nativeQuery = true)
	List<Employee_Profile> getEmployeeList();
	
	@Query(value="SELECT * FROM BGLS_EMPLOYEE_PROFILE WHERE EMPLOYEE_ID =?1", nativeQuery = true)
	Employee_Profile getEmployeeData(String employee_id);
	
	@Query(value="SELECT branch_desc FROM BGLS_EMPLOYEE_PROFILE where BRANCH_ID =?1 AND DEL_FLG='N'", nativeQuery = true)
	String getBranchName(String branch_id);
	
	@Query(value = "SELECT MAX(CAST(\r\n" + 
			"    CASE \r\n" + 
			"        WHEN REGEXP_INSTR(EMPLOYEE_ID, '[0-9]') > 0 \r\n" + 
			"        THEN SUBSTR(EMPLOYEE_ID, REGEXP_INSTR(EMPLOYEE_ID, '[0-9]')) \r\n" + 
			"        ELSE '0' \r\n" + 
			"    END AS NUMBER)) AS max_numeric_part\r\n" + 
			"FROM BGLS_EMPLOYEE_PROFILE", nativeQuery = true)
	String getSrlNo();

	@Query(value="SELECT * FROM BGLS_EMPLOYEE_PROFILE where entity_flg='Y'", nativeQuery = true)
	List<Employee_Profile> getEmployeeVeifiedList();

	
}
