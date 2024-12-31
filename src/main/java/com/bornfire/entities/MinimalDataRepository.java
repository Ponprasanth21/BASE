package com.bornfire.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MinimalDataRepository extends JpaRepository<EKYCMinimalData, String> {

	

	@Query(value = "select * from EKYC_MINIMAL_DATA  where del_flg='N'", nativeQuery = true)
	Page<EKYCMinimalData> alertlist(Pageable page);

	@Modifying
	@Query(value = "UPDATE AMT u set u.DEL_FLG ='Y' where u.NATIONAL_ID =?1", nativeQuery = true)
	int findByfgdg1(String national_id);

	@Query(value = "select * from AMT where national_id=?1", nativeQuery = true)
	Page<EKYCMinimalData> findAllIdCustom(String nationalid, Pageable pageable);

	@Query(value = "SELECT ARN_NO.NEXTVAL FROM DUAL", nativeQuery = true)
	String ARNNO();
	
	@Query(value = "SELECT MAX(CAST(numeric_part AS INT)) AS max_numeric_part\r\n" + 
			"FROM (\r\n" + 
			"    SELECT REPLACE(REPLACE(REPLACE(cif_id, 'CIF', ''), '-', ''), '.', '') AS numeric_part\r\n" + 
			"    FROM BACP_MINIMAL_DATA\r\n" + 
			"    WHERE REGEXP_LIKE(REPLACE(REPLACE(REPLACE(cif_id, 'CIF', ''), '-', ''), '.', ''), '^\\d+$')\r\n" + 
			")", nativeQuery = true)
	String getCifId();

	
	@Query(value = "SELECT APPL_REF_NO, MAX(cust_grp) AS cust_grp, MAX(acc_type) AS acc_type, MAX(full_name) AS full_name, MAX(national_id) AS national_id FROM BACP_MINIMAL_DATA WHERE status = 'HOLD' AND STS_FLG = 'N' GROUP BY APPL_REF_NO", nativeQuery = true)
	List<Object[]> holdlist();

	@Query(value = "select * from BACP_MINIMAL_DATA order by appl_ref_no asc", nativeQuery = true)
	List<EKYCMinimalData> getInquirelist();

	@Query(value = "select * from BACP_MINIMAL_DATA where appl_ref_no =?1", nativeQuery = true)
	EKYCMinimalData findByapplref(String ApprefNO);
	
	@Query(value = "select * from BACP_MINIMAL_DATA where appl_ref_no =?1", nativeQuery = true)
	EKYCMinimalData findByapplref1(String keynumber);

	@Query(value = "select * from BACP_MINIMAL_DATA order by appl_ref_no asc", nativeQuery = true)
	List<EKYCMinimalData> findByapplref();

	@Query(value = "select * from BACP_MINIMAL_DATA", nativeQuery = true)
	List<EKYCMinimalData> getauditListLocal1(Date Fromdate, Date Todate);
	
	@Query(value = "select * from BACP_MINIMAL_DATA from doc_type ", nativeQuery = true)
	EKYCMinimalData findByDoc(String docType);
	
	@Query(value = "select * from BACP_MINIMAL_DATA where appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByapplref2(String apprefNO);

	@Query(value = "SELECT COUNT(*) AS APPL_REF_NO from BACP_MINIMAL_DATA where appl_ref_no =?1", nativeQuery = true)
    Integer findByapplrefcount(String apprefNO);
	
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 1 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplrefsecond(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 2 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplrefthird(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 3 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplreffourth(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 4 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplreffifth(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 5 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplrefsix(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 6 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplrefsev(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 7 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplrefeight(String ApprefNO);
	@Query(value = " select * from BACP_MINIMAL_DATA  WHERE appl_ref_no =?1 OFFSET 8 ROW FETCH NEXT 1 ROWS ONLY ", nativeQuery = true)
	EKYCMinimalData findByapplrefnine(String ApprefNO);
	
	

	@Query(value = "select * from BACP_MINIMAL_DATA where appl_ref_no= ?1 AND rec_no= ?2", nativeQuery = true)
	EKYCMinimalData findByref_norec(String appl_ref_no,String rec_no);
	
	/*
	 * @Query(value = "select * from BACP_MINIMAL_DATA ", nativeQuery = true)
	 * List<String> (String );
	 */
	
	
	
}
