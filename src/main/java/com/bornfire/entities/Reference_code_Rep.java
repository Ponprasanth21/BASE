package com.bornfire.entities;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Reference_code_Rep extends JpaRepository<Reference_Code_Entity, String>{ 

	@Query(value="SELECT * FROM BGLS_REF_MASTER where DEL_FLG='N' order by REF_TYPE", nativeQuery = true)
	List<Reference_Code_Entity> getRefList(); 
	
	@Query(value="SELECT Distinct REF_TYPE FROM BGLS_REF_MASTER where DEL_FLG='N' order by REF_TYPE", nativeQuery = true)
	List<String> getReferenceType();
	
	@Query(value="SELECT REF_TYPE_DESC,MODULE_ID FROM BGLS_REF_MASTER where REF_TYPE =?1 AND DEL_FLG='N'", nativeQuery = true)
	List<Object[]> getTypeDesc(String ref_type);
	
	@Query(value="SELECT REF_ID_DESC FROM BGLS_REF_MASTER where REF_TYPE =?1 AND DEL_FLG='N'", nativeQuery = true)
	List<String> getReferenceCode(String ref_type);
	
	@Query(value="SELECT REF_ID FROM BGLS_REF_MASTER where REF_TYPE =?1 AND DEL_FLG='N'", nativeQuery = true)
	List<String> getRefCode(String ref_type);
	
	 @Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='BRANCH_ID' AND DEL_FLG='N'", nativeQuery = true) 
	 List<Reference_Code_Entity> getBranch_Id();
	
	
	/*
	 * @Query(value = "SELECT * FROM BGLS_ORG_BRANCH where DEL_FLG='N' ",
	 * nativeQuery = true) List<Reference_Code_Entity> getBranch_Id();
	 */	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='SCHEME_TYPE1' AND REF_TYPE='PAR' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getSchme_Type();
	
	
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='SCHEME_TYPE' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getScheme_Type();
	
	@Query(value = "select REF_ID_DESC from BGLS_REF_MASTER where REF_ID=?1", nativeQuery = true)
	Object[] getbranchDesc(String refid);
	
	@Query(value = "select REF_ID_DESC,REMARKS from BGLS_REF_MASTER where REF_ID =?1", nativeQuery = true)
	Object[] getscheme(String refid);
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='SCHME_CODE' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getSchme_Code();
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='GL_CODE' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getGL_CODE();
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='Document Type' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getdoctype();
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE='Document Type' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getcorpdoctype();
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='GLSH' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getGLSH();
	
	@Query(value="SELECT * FROM BGLS_REF_MASTER where REF_TYPE_DESC='MULTI_CURR' AND DEL_FLG='N'", nativeQuery = true)
	List<Reference_Code_Entity> getMulti_Curr();
	
	@Query(value="SELECT REF_ID, REF_ID_DESC FROM BGLS_REF_MASTER where REF_TYPE_DESC='CURR' AND DEL_FLG='N'", nativeQuery = true)
	List<String> getCurr();
}
