package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Calender_Master_Repo extends JpaRepository<Calender_Master_Entity,String>{
	
	

}
