package com.bornfire.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository

public interface AIRep extends JpaRepository<AuditInquiries, String>{
	@Query(value = "select * from BACP_AUDIT_TABLE", nativeQuery = true)
	List<AuditInquiries> getInquirelist();


	@Query(value = "select * from BACP_AUDIT_TABLE where AUDIT_REF_NO =?1  AND AUDIT_KEY_NO =?2 order by entry_time asc", nativeQuery = true)
	List<AuditInquiries> getauditListLocal(String refnumber ,String keynumber);
	
	 
	@Query(value = "select * from BACP_AUDIT_TABLE where AUDIT_KEY_NO =?1", nativeQuery = true)
	List<AuditInquiries> findbyId(String keynumber);


}
