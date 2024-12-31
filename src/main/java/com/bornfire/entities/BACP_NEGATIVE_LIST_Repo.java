package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface BACP_NEGATIVE_LIST_Repo extends JpaRepository<BACP_NEGATIVE_LIST, String>{
	
	@Query(value = "select * from BACP_NEGATIVE_LIST where national_id=?1", nativeQuery = true)
	BACP_NEGATIVE_LIST findTHIS(String id);
	@Query(value = "select corporateName from BACP_NEGATIVE_LIST where corporateName is not null", nativeQuery = true)
	List<String> getcor_nameList();
	
	@Query(value = "select certificate_incorporation from BACP_NEGATIVE_LIST where certificate_incorporation is not null", nativeQuery = true)
	List<String> findcer_od_incop();
	
	@Query(value = "select business_registration from BACP_NEGATIVE_LIST where business_registration is not null", nativeQuery = true)
	List<String> findbuss_ref_no();
	
	@Query(value = "select landlineNo from BACP_NEGATIVE_LIST where landlineNo is not null", nativeQuery = true)
	List<String> findlno();
//for retail
	@Query(value = "select full_name from BACP_NEGATIVE_LIST where full_name is not null", nativeQuery = true)
	List<String> getfull_name();
	
	@Query(value = "select mbl_num from BACP_NEGATIVE_LIST where mbl_num is not null", nativeQuery = true)
	List<String> findmbl_num();
	
	@Query(value = "select passport from BACP_NEGATIVE_LIST where passport is not null", nativeQuery = true)
	List<String> findpassport();
	
	@Query(value = "select national_id from BACP_NEGATIVE_LIST where national_id is not null", nativeQuery = true)
	List<String> findnationality();



}
