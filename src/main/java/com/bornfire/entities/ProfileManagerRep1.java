package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileManagerRep1 extends JpaRepository<ProfileManagerEntity1, String> {

	@Query(value = "select * from BAJ_PROFILE_MANAGER", nativeQuery = true)
	 List<ProfileManagerEntity1> getPMList();
	
	@Query(value = "select  * from BAJ_PROFILE_MANAGER where emp_id= ?1",nativeQuery = true)
	ProfileManagerEntity1 getPMform(String emp_id);
	

	//@Query(value = "SELECT prev_orgn_1, prev_orgn_2, prev_orgn_3, prev_orgn_4, prev_orgn_5, prev_orgn_6, prev_orgn_7, prev_orgn_8, prev_orgn_9, prev_orgn_10 FROM BAJ_PROFILE_MANAGER WHERE emp_id = ?1", nativeQuery = true)
	//List<String> getPMforms(String emp_id);
	
	//@Query(value = "SELECT proj_det_1, proj_det_2, proj_det_3, proj_det_4, proj_det_5, proj_det_6, proj_det_7, proj_det_8, proj_det_9, proj_det_10, proj_det_11, proj_det_12, proj_det_13, proj_det_14, proj_det_15, proj_det_16, proj_det_17, proj_det_18, proj_det_19, proj_det_20 FROM BAJ_PROFILE_MANAGER WHERE emp_id = ?1", nativeQuery = true)
	//List<String> getPMforms2(String emp_id);
	
	@Query(value = "SELECT PROJ_DET_1 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_1 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_2 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_2 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_3 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_3 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_4 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_4 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_5 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_5 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_6 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_6 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_7 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_7 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_8 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_8 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_9 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_9 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_10 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_10 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_11 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_11 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_12 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_12 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_13 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_13 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_14 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_14 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_15 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_15 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_16 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_16 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_17 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_17 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_18 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_18 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_19 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_19 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PROJ_DET_20 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PROJ_DET_20 IS NOT NULL ",
    nativeQuery = true)
List<String> getPMforms2(String emp_id);
	
	
	
	@Query(value = "SELECT PREV_ORGN_1 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_1 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_2 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_2 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_3 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_3 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_4 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_4 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_5 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_5 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_6 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_6 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_7 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_7 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_8 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_8 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_9 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_9 IS NOT NULL " +
            "UNION ALL " +
            "SELECT PREV_ORGN_10 AS FieldValue FROM BAJ_PROFILE_MANAGER WHERE EMP_ID = ?1 AND PREV_ORGN_10 IS NOT NULL ",
    nativeQuery = true)
List<String> getPMforms(String emp_id);



	 
}