package com.bornfire.entities;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface BGLS_BAMAssetFlows_Rep extends CrudRepository<BGLS_BAMAssetFlows_Entity, BigDecimal>{
	
	@Query(value = "WITH CTE AS (" +
            "    SELECT *, " +
            "           ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS pseudo_rowid " +
            "    FROM BGLS_FLOW_ASSETS " +
            "    WHERE gen_delete_flg IS NULL AND sale_flg IS NULL" +
            ")" +
            "SELECT * " +
            "FROM CTE " +
            "WHERE pseudo_rowid IN (" +
            "    SELECT MIN(pseudo_rowid) " +
            "    FROM CTE " +
            "    GROUP BY asset_name" +
            ")", nativeQuery = true)
List<BGLS_BAMAssetFlows_Entity> getdata();
		/*
		 * @Query(value = "SELECT * FROM BGLS_FLOW_ASSETS b " + "WHERE b.id IN (" +
		 * "    SELECT MIN(sub.rowid) " + "    FROM (" +
		 * "        SELECT ROW_NUMBER() OVER (PARTITION BY asset_name ORDER BY (SELECT NULL)) AS rowid, id "
		 * + "        FROM BGLS_FLOW_ASSETS " +
		 * "        WHERE gen_delete_flg IS NULL AND sale_flg IS NULL" + "    ) sub " +
		 * "    GROUP BY sub.asset_name" + ")", nativeQuery = true)
		 * List<BGLS_BAMAssetFlows_Entity> getdata();
		 */

@Query(value = "SELECT ASSET_SERIAL_NO, ASSET_NAME, ASSET_TYPE, ORIGINAL_COST, DEPRECIATION_METHOD, DEPRECIATION_PERCENTAGE, DEPRECIATION_FREQUENCY " +
        "FROM BGLS_FLOW_ASSETS WHERE gen_roll_no = '1'", nativeQuery = true)
List<Object[]> findAssetsWithMinGenRollNo();



 
@Query(value = "SELECT DISTINCT asset_serial_no FROM BGLS_FLOW_ASSETS", nativeQuery = true)
List<String> getlistdepreciationSS();

	  
	  @Query(value = "SELECT * from BGLS_FLOW_ASSETS where asset_serial_no = ?1 ",nativeQuery = true) 
	  List<BGLS_BAMAssetFlows_Entity>  getview(String asset_serial_no);
	  
	  
	  
	  
	  @Query(value = "SELECT DISTINCT asset_serial_no FROM BGLS_FLOW_ASSETS", nativeQuery = true)
	    List<String>  getdatas();

	    @Query(value = "SELECT * FROM BGLS_FLOW_ASSETS WHERE TO_CHAR(gen_flow_strt_date, 'dd-MM-yyyy') = :currentDate", nativeQuery = true)
	  List<BGLS_BAMAssetFlows_Entity> getDep(LocalDate currentDate);
	  
	  @Query(value = "SELECT * from FLOW_ASSETS where srl_no = ?1 ",nativeQuery = true) 
	  BGLS_BAMAssetFlows_Entity srl_noget(String srl_no);
	  
	  @Query(value = "SELECT * from BGLS_FLOW_ASSETS where gen_tran_id = ?1 ",nativeQuery = true) 
	  BGLS_BAMAssetFlows_Entity gettranview(String gen_tran_id);
	  
	  
	  @Query(value = "Select *from BGLS_FLOW_ASSETS where gen_tran_id! ='0'",nativeQuery = true) 
	  List<BGLS_BAMAssetFlows_Entity> gettrandata();
	  

	  @Query(value = "Select *from BGLS_FLOW_ASSETS where TO_CHAR(gen_flow_strt_date, 'dd-MM-yyyy') < :currentDate AND GEN_FLOW_ID='DEPR'",nativeQuery = true) 
	  List<BGLS_BAMAssetFlows_Entity> getprevbatchjobs(LocalDate currentDate);
	  
	  @Query(value = "Select count(*)from BGLS_FLOW_ASSETS where gen_flow_strt_date >=TO_DATE(?1,'dd-MM-YYYY') AND gen_flow_strt_date <=TO_DATE(?2,'dd-MM-YYYY') AND GEN_FLOW_ID='ACQN'",nativeQuery = true) 
	  int gettotal(String stryear,String endyear);
	  
	  @Query(value = "Select count(*)from BGLS_FLOW_ASSETS where TO_CHAR(gen_flow_strt_date,'MM-YYYY')=?1 AND GEN_FLOW_ID='DEPR'",nativeQuery = true) 
	  int getdep(String monthyear);
	  
	  @Query(value = "Select NVL(sum(gen_original_cost),0)from BGLS_FLOW_ASSETS where TO_CHAR(gen_flow_strt_date,'MM-YYYY')=?1 AND GEN_FLOW_ID='DEPR'",nativeQuery = true) 
	  int getintialcost(String monthyear);
	  
	  @Query(value = "Select NVL(sum(gen_book_value),0)from BGLS_FLOW_ASSETS where TO_CHAR(gen_flow_strt_date,'MM-YYYY')=?1 AND GEN_FLOW_ID='DEPR'",nativeQuery = true) 
	  int getbookvalue(String monthyear);
	  
	  @Query(value = "SELECT * FROM BGLS_FLOW_ASSETS WHERE asset_serial_no = ?1", nativeQuery = true) 
	  List<BGLS_BAMAssetFlows_Entity> findBySrlNo(String asset_serial_no);

	    @Query(value = "SELECT * FROM BGLS_FLOW_ASSETS WHERE asset_serial_no = ?1 ORDER BY srl_no DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	    List<BGLS_BAMAssetFlows_Entity> findLatestByAssetSerialNo(String asset_serial_no);  
}
