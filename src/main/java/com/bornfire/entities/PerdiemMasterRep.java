package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerdiemMasterRep extends JpaRepository<PerdiemMasterEntity, String>{
	
	@Query(value = "select * from BAJ_STAFF_PERDIEM", nativeQuery = true)
	 List<PerdiemMasterEntity> getPerMasList();
	
	@Query(value = "select * from BAJ_STAFF_PERDIEM  where emp_no= ?1",nativeQuery = true)
	PerdiemMasterEntity getPerMasform(String emp_no);
	
	//@Query(value = "select * from BAJ_STAFF_PERDIEM  where emp_no= ?1",nativeQuery = true)
	//List<Object[]> getPerMasList3(String emp_no);
	
	@Query(value = "select month, period_from, period_to, no_of_days, amount_usd, amount_inr, date_disb, payment_mode, bank_acct_no from BAJ_STAFF_PERDIEM  where emp_no= ?1",nativeQuery = true)
	List<String[]> getPerMasList3(String emp_no);
}
