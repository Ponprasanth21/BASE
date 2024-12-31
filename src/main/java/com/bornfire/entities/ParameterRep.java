package com.bornfire.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ParameterRep extends JpaRepository<ParametersDetails, String> {

	public Optional<ParametersDetails> findByrefnumber(String refnumber);

	@Query(value = "select * from BACP_PARAMETER where REF_NUMBER =?1", nativeQuery = true)
	ParametersDetails findbyId(String refnumber);
	
	@Query(value = "select * from BACP_PARAMETER where schm_code =?1", nativeQuery = true)
	ParametersDetails findbyIdschmcode(String schmcode);
	
	@Query(value = "select * from BACP_PARAMETER where del_flg = 'N' ", nativeQuery = true)
	List<ParametersDetails> listofvalue();

	@Query(value = "SELECT MAX(TO_NUMBER(numeric_part)) AS max_numeric_part\r\n" + 
			"FROM (\r\n" + 
			"    SELECT REPLACE(REPLACE(REPLACE(REF_NUMBER, 'REF', ''), '-', ''), '.', '') AS numeric_part\r\n" + 
			"    FROM BACP_PARAMETER\r\n" + 
			"    WHERE REGEXP_LIKE(REPLACE(REPLACE(REPLACE(REF_NUMBER, 'REF', ''), '-', ''), '.', ''), '^[0-9]+')\r\n" + 
			") numeric_parts", nativeQuery = true)
	String getParamRef();

}
