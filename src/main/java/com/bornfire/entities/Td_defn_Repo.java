package com.bornfire.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Td_defn_Repo extends JpaRepository<Td_defn_table, String> {

	@Query(value = "SELECT * FROM BGLS_TD_DEFN_TABLE WHERE CUST_ID =?1", nativeQuery = true)
	List<Td_defn_table> getdata1(String cust_id);

	@Query(value = "SELECT * FROM BGLS_TD_DEFN_TABLE WHERE ACID =?1", nativeQuery = true)
	List<Td_defn_table> getactList(String acid);

	@Query(value = "SELECT MAX(SRL_NO) FROM BGLS_TD_DEFN_TABLE", nativeQuery = true)
	String getTranNo();

	@Query(value = "SELECT * FROM BGLS_TD_DEFN_TABLE WHERE ACID =?1 AND FLOW_CODE = 'PO'", nativeQuery = true)
	Td_defn_table getactListval(String acid);

	@Query(value = "SELECT * FROM BGLS_TD_DEFN_TABLE WHERE ACID =?1 AND FLOW_DATE =?2 AND FLOW_CODE NOT IN ('PI', 'PO', 'TO')", nativeQuery = true)
	Td_defn_table getflowcode(String acid, Date flow_date);

		@Query(value = "SELECT TOP 1 *\r\n"
				+ "FROM BGLS_TD_DEFN_TABLE\r\n"
				+ "WHERE ACID =?1 AND FLOW_DATE > ?2 AND FLOW_CODE NOT IN ('PI', 'PO' , 'TO')\r\n"
				+ "ORDER BY FLOW_DATE ASC ;", nativeQuery = true)
		Td_defn_table getPreviousFlowCode(String acid, Date flow_date);

	@Query(value = "SELECT * FROM BGLS_TD_DEFN_TABLE aa WHERE  aa.flow_date BETWEEN ?1 AND ?2 AND aa.flow_code NOT IN ('PI', 'PO', 'TO') AND (aa.acid = ?3 OR ?3 IS NULL OR ?3 = '') ORDER BY aa.flow_date", nativeQuery = true)
	List<Td_defn_table> getDepositflows(Date fromDate, Date todate, String accountNum);

	@Query(value = "SELECT * FROM BGLS_TD_DEFN_TABLE WHERE ACID =?1 AND FLOW_CODE =?2 and flow_id=?3", nativeQuery = true)
	Td_defn_table getFlowrecords(String acid, String flowcode, String flowid);

}
