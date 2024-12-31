package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Bacp_Signature_masterRepo extends JpaRepository<Bacp_Signature_master, String>{

	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no= ?1 and del_flg ='N'", nativeQuery = true)
	List<Bacp_Signature_master> findByref_no(String appl_ref_no);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where cif_id= ?1 and del_flg ='N'", nativeQuery = true)
	List<Bacp_Signature_master> findBycif_id(String cif_id);

	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no= ?1 and del_flg ='N'", nativeQuery = true)
	Bacp_Signature_master findByref_no1(String appl_ref_no);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no= ?1 and del_flg ='N'", nativeQuery = true)
	Optional<Bacp_Signature_master> findByref_no11(String appl_ref_no);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no=?1 and del_flg ='N' ", nativeQuery = true)
	 Bacp_Signature_master findByAppl_ref_no(String applRefNo);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no=?1 and rec_no=?2 and del_flg ='N'", nativeQuery = true)
	 Bacp_Signature_master findByAppl_ref_noRecNo(String applRefNo,String rec_no);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no= ?1 and del_flg ='N'", nativeQuery = true)
	 Bacp_Signature_master getty(String applRefNo);
	
	@Query(value = "select SIGN_ID.NEXTVAL FROM DUAL", nativeQuery = true)
	Integer srlnum();
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no= ?1 AND rec_no= ?2 and del_flg ='N'", nativeQuery = true)
	Bacp_Signature_master findByref_norec(String appl_ref_no,String rec_no);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no=?1 and rec_no=?2 and del_flg ='N'", nativeQuery = true)
	Bacp_Signature_master findbyrec_no(String appl_ref_no,String rec_no);
	
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where appl_ref_no =?1 and del_flg ='N'", nativeQuery = true)
	List<Bacp_Signature_master> findsrl_no(String srl_no);
	
	@Query(value = "select * from BACP_SIGNATURE_MASTER where srl_no =?1 and del_flg ='N'", nativeQuery = true)
	Bacp_Signature_master findsrl_no1(String srl_no);
}