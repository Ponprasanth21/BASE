package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Baj_Work_Repo extends JpaRepository<Baj_Sal_Work_Entity, String> {
	 @Query(value = "SELECT * FROM BAJ_SAL_WORK WHERE salary_month=?1 ", nativeQuery = true)
	    List<Baj_Sal_Work_Entity> getpays(String salary_month);
	    
	    @Query(value = "SELECT * FROM BAJ_SAL_WORK WHERE salary_month=?1 ", nativeQuery = true)
	    List<Baj_Sal_Work_Entity> getpayss(String salary_month);
	    
	    @Query(value = "SELECT * FROM BAJ_SAL_WORK where uniqueid=?1 ", nativeQuery = true)

	    Baj_Sal_Work_Entity getlisttab1(String uniqueid );
	    
	    @Query(value = "SELECT * FROM BAJ_SAL_WORK WHERE salary_month=?1 ", nativeQuery = true)
	    List<Baj_Sal_Work_Entity> getswap(String salary_month);
		

	

}
