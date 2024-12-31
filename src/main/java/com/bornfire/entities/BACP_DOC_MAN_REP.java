package com.bornfire.entities;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;



@Repository
public interface BACP_DOC_MAN_REP extends JpaRepository<BACP_DOC_MAN_ENTITY, BACP_DOC_MAN_ENTITY_PRIMARY_ID>{
	
	
	@Query(value = "select  document_type,document_code,document_type_desc,place_of_issue,unique_id,issue_date,expiry_date from BACP_DOC_MAN where cif_id= ?1 AND DEL_FLG='N'",nativeQuery = true)
	List<Object[]> findByCIFID(String cif_id);
	
	@Query(value = "select  * from  BACP_DOC_MAN  where cif_id= ?1 AND DEL_FLG='N'",nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findByCIFIDs(String cif_id);
	
	/*@Query(value = "select  document_type,document_code,document_type_desc,place_of_issue,unique_id,issue_date,expiry_date from BACP_DOC_MAN where document_type= ?1",nativeQuery = true)
	List<Object[]> findByDOC(String document_type);*/
	
	@Query(value = "select * from BACP_DOC_MAN where cif_id= ?1 and DOCUMENT_TYPE = ?2 AND DEL_FLG='N'",nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findByDOCID(String cif_id, String doc_type);	
	
	@Query(value = "select * from BACP_DOC_MAN where appl_ref_no= ?1 AND DEL_FLG='N'", nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findBy(String appl_ref_no);

	@Query(value = "select * from BACP_DOC_MAN where appl_ref_no= ?1 and unique_id = ?2 AND DEL_FLG='N'", nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findBy1(String appl_ref_no,String doc_type);
	
	@Query(value = "select * from bacp_doc_man where appl_ref_no='ARN00785' and rec_no='2' AND DEL_FLG='N'", nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findBycif();
	
	@Query(value = "select * from BACP_DOC_MAN where cif_id= ?1",nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findByID(String cif_id);

	@Query(value = "select * from BACP_DOC_MAN where appl_ref_no= ?1 AND unique_id= ?2 OR unique_id= ?3 AND DEL_FLG='N' ", nativeQuery = true)
	List<Object[]> findByApprno(String appl_ref_no,String nationalid, String passno);

	@Query(value = "select * from BACP_DOC_MAN where appl_ref_no= ?1 AND DEL_FLG='N'", nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findByAppl( String appl_ref_no);

	@Query(value = "select * from BACP_DOC_MAN where cif_id= ?1 and unique_id=?2 AND DEL_FLG='N'", nativeQuery = true)
	BACP_DOC_MAN_ENTITY findByApplAndUnquie(String cif_id,String unique_id);
	
	@Query(value = "select * from BACP_DOC_MAN where appl_ref_no= ?1 and unique_id=?2 AND DEL_FLG='N'", nativeQuery = true)
	BACP_DOC_MAN_ENTITY findByApplAndUnquieimg(String appl_ref_no,String unique_id);

	@Modifying
	@Query(value = "delete from BACP_DOC_MAN where cif_id = ?1 AND DEL_FLG='N'", nativeQuery = true)
	void removeData(String cif_id);
	
	@Query(value = "select * from BACP_DOC_MAN where appl_ref_no= ?1 AND rec_no= ?2 AND DEL_FLG='N'", nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findByref_norec(String appl_ref_no,String rec_no);
	

@Query(value = "select * from BACP_DOC_MAN where cif_id= ?1 and document_type = ?2 AND DEL_FLG='N'", nativeQuery = true)
	List<BACP_DOC_MAN_ENTITY> findBy2(String cif_id,String doc_type);
	
	@Query(value = "select * from BACP_DOC_MAN where unique_id = ?1 AND DEL_FLG='N'", nativeQuery = true)
	BACP_DOC_MAN_ENTITY findByUnique1(String unique_id);

}
