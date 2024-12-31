package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Assosiate_Profile_Repo extends JpaRepository<Assosiate_Profile_Entity, String>{
	
	@Query(value = "select * from BAJ_RESOURCE_MASTER", nativeQuery = true)
	 List<Assosiate_Profile_Entity> getAssosiateList();
	 
	 @Query(value = "select  * from BAJ_RESOURCE_MASTER where resource_id= ?1",nativeQuery = true)
	 Assosiate_Profile_Entity getSingleIdData(String resource_id);


}
