package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BAJ_DABView_Rep extends JpaRepository<BAJ_DABView_Entity,String >{

	@Query(value = "SELECT TRAN_DATE, TRAN_DATE_BAL FROM ( " +
            "SELECT TRAN_DATE, TRAN_DATE_BAL " +
            "FROM  DAB_VIEW " +
            "WHERE ACCT_NUM = :acct_num " +
            "AND TO_DATE(:fromdateref, 'DD-MM-YYYY') - 1 BETWEEN TRAN_DATE AND END_TRAN_DATE " +
            "UNION ALL " +
            "SELECT TRAN_DATE, TRAN_DATE_BAL " +
            "FROM  DAB_VIEW " +
            "WHERE ACCT_NUM = :acct_num " +
            "AND TRAN_DATE_BAL IS NOT NULL " +
            "AND TRAN_DATE < TO_DATE(:fromdateref, 'DD-MM-YYYY') " +
            "ORDER BY TRAN_DATE DESC " +
            "FETCH FIRST 1 ROW ONLY) " +
            "FETCH FIRST 1 ROW ONLY", nativeQuery = true)
Object[] getTranlst(@Param("acct_num") String acct_num, @Param("fromdateref") String fromdateref);
	
@Query(value = "SELECT TRAN_DATE, TRAN_DATE_BAL FROM ( " +
            "SELECT TRAN_DATE, TRAN_DATE_BAL " +
            "FROM  DAB_VIEW " +
            "WHERE ACCT_NUM = :acct_num " +
            "AND TO_DATE('01-04-2024', 'DD-MM-YYYY') - 1 BETWEEN TRAN_DATE AND END_TRAN_DATE " +
            "UNION ALL " +
            "SELECT TRAN_DATE, TRAN_DATE_BAL " +
            "FROM  DAB_VIEW " +
            "WHERE ACCT_NUM = :acct_num " +
            "AND TRAN_DATE_BAL IS NOT NULL " +
            "AND TRAN_DATE < TO_DATE('01-04-2024', 'DD-MM-YYYY') " +
            "ORDER BY TRAN_DATE DESC " +
            "FETCH FIRST 1 ROW ONLY) " +
            "FETCH FIRST 1 ROW ONLY", nativeQuery = true)
Object[] getTranlst2(@Param("acct_num") String acct_num);





	
}
