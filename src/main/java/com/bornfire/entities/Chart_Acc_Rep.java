package com.bornfire.entities;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Chart_Acc_Rep extends JpaRepository<Chart_Acc_Entity, String>{
	


	@Query(value = "SELECT SUM(CASE WHEN TO_NUMBER(total_balance) < 0 THEN TO_NUMBER(total_balance) ELSE 0 END) FROM BGLS_GL_WORK WHERE total_balance IS NOT NULL", nativeQuery = true)
	String getacctbaldebit();

	@Query(value = "SELECT SUM(CASE WHEN TO_NUMBER(total_balance) > 0 THEN TO_NUMBER(total_balance) ELSE 0 END) FROM BGLS_GL_WORK WHERE total_balance IS NOT NULL", nativeQuery = true)
	String getacctbalcredit();
	
	@Query(value = "SELECT SUM(ACCT_BAL) FROM COA WHERE ACCT_BAL <0", nativeQuery = true)
    String getGLbaldebit();
	
	@Query(value = "SELECT SUM(ACCT_BAL) FROM COA WHERE ACCT_BAL >0", nativeQuery = true)
    String getGLbalcredit();
	
	@Query(value = "SELECT COUNT(ACCT_BAL) AS ACCT_BAL,SUM(ACCT_BAL) AS SUM_BAL FROM BGLS_CHART_OF_ACCOUNTS WHERE ACCT_CLS_FLG='N'", nativeQuery = true)
    Object[] getaccbalance();

	
	@Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS WHERE acct_num IN (:accountNumbers)", nativeQuery = true)
	List<Chart_Acc_Entity> getcoaaccunt_num(@Param("accountNumbers") List<String> accountNumbers);

	
	@Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N' ORDER BY ACCT_NUM, CLASSIFICATION ASC", nativeQuery = true)
    List<Chart_Acc_Entity> getList();
    
    @Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N'   AND ACCT_NUM NOT LIKE '%la%'  ORDER BY ACCT_NUM, CLASSIFICATION ASC", nativeQuery = true)
    List<Chart_Acc_Entity> getListoffice();
	
	
    @Query(value = "SELECT GLSH_CODE, GLSH_DESC,COUNT(GLSH_CODE) as sum, acct_crncy, SUM(ACCT_BAL) FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N' AND classification='Asset' GROUP BY GLSH_CODE, GLSH_DESC, acct_crncy ORDER BY GLSH_CODE ASC", nativeQuery = true)
    List<Object[]> getList1();

    
    @Query(value = "SELECT GLSH_CODE, GLSH_DESC, COUNT(GLSH_CODE) as sum, acct_crncy, SUM(ACCT_BAL) FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N' AND classification='Liability' GROUP BY GLSH_CODE, GLSH_DESC, acct_crncy ORDER BY GLSH_CODE ASC", nativeQuery = true)
    List<Object[]> getList2();
    
    @Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N' AND classification='Income' ORDER BY CLASSIFICATION ASC", nativeQuery = true)
    List<Chart_Acc_Entity> getList3();
    
    @Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N' AND classification='Expenses' ORDER BY CLASSIFICATION ASC", nativeQuery = true)
    List<Chart_Acc_Entity> getList4();
    
    @Query(value = "SELECT * FROM BGLS_DAILY_ACCT_BAL WHERE :balancedate BETWEEN TRAN_DATE AND END_TRAN_DATE", nativeQuery = true)
	List<Chart_Acc_Entity> getfilteredrec(@Param("balancedate") Date balancedate);
    
    
    @Query(value = "SELECT ACCT_NUM FROM BGLS_CHART_OF_ACCOUNTS WHERE del_flg='N'", nativeQuery = true)
    List<String> getexistingData();
    
    @Query(value = "select acct_bal from bgls_chart_of_accounts where acct_num =?1", nativeQuery = true)
    BigDecimal getacctbal(String acct_num );
    
    @Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS WHERE acct_num =?1", nativeQuery = true)
    Chart_Acc_Entity getaedit(String acct_num );
    
    @Query(value = "select * from BGLS_CHART_OF_ACCOUNTS aa where aa.classification =?3 and aa.gl_code =?1 and aa.acct_num = ?2 ", nativeQuery = true)
	Chart_Acc_Entity getValuepop(String gl_code, String acct_num,String classification);
    
    @Query(value = "select * from BGLS_CHART_OF_ACCOUNTS aa where aa.acct_num = ?1 ", nativeQuery = true)
    List<Chart_Acc_Entity> getValuepoplist(String acct_num);
    
    @Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS ORDER BY acct_num ", nativeQuery = true)
    List<Chart_Acc_Entity> getlistpopup();
    
    @Query(value = "SELECT * FROM BGLS_CHART_OF_ACCOUNTS where acct_num = ?1 ", nativeQuery = true)
    Chart_Acc_Entity getlistpopupvalues(String acct_num);
    
    @Query(value = "select * from BGLS_CHART_OF_ACCOUNTS aa where aa.acct_num = ?1", nativeQuery = true)
	Chart_Acc_Entity getValuepopval(String acct_num);
    
    @Query(value = "select acct_bal from BGLS_CHART_OF_ACCOUNTS aa where aa.acct_num = ?1", nativeQuery = true)
	BigDecimal getbal(String acct_num);
    
    @Query(value = "SELECT SUM(CR_AMT) as TRANAMT, SUM(DR_AMT) as TRANAMT1  FROM BGLS_CHART_OF_ACCOUNTS", nativeQuery = true)
   	Object[] getcheck2();
    
    @Query(value = "select  * FROM BGLS_CHART_OF_ACCOUNTS  where GLSH_CODE=?1", nativeQuery = true)
    List<Chart_Acc_Entity> getglsh(String glshCode);
	
    @Query(value = "SELECT DISTINCT GLSH_CODE, CLASSIFICATION, GL_DESC, ACCT_CRNCY, GL_CODE, GLSH_DESC, " +
            "COUNT(GLSH_CODE) AS total_count, " +
            "SUM(CASE WHEN acct_bal > 0 THEN acct_bal ELSE 0 END) AS cr_amt, " +
            "SUM(CASE WHEN acct_bal < 0 THEN ABS(acct_bal) ELSE 0 END) AS dr_amt " +
            "FROM BGLS_CHART_OF_ACCOUNTS " +
            "WHERE del_flg = 'N' " +
            "GROUP BY GLSH_CODE, CLASSIFICATION, GL_DESC, ACCT_CRNCY, GL_CODE, GLSH_DESC " +
            "ORDER BY GLSH_CODE ASC", nativeQuery = true)
Object[] getglcode();


    

    @Query(value = "select MODIFY_TIME from BGLS_CHART_OF_ACCOUNTS WHERE acct_num=?1 AND MODIFY_TIME=?2", nativeQuery = true)
	Object getaccnum(String acct_num,Date MODIFY_TIME);
    
    
    @Query(value = "select ACCT_BAL from BGLS_CHART_OF_ACCOUNTS WHERE ACCT_NUM=?1", nativeQuery = true)
    Object getaccbal(String acc_num);
    
    @Query(value = "SELECT acct_partition FROM COA WHERE ACCT_NUM=?1", nativeQuery = true)
    String getpartitionFlag(String accountNum);
    
    @Query(value = "SELECT add_det_flg FROM COA WHERE ACCT_NUM=?1", nativeQuery = true)
    String getpointingDetail(String accountNum);



}
