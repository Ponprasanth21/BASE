package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface BACP_CUS_PROFILE_REPO extends JpaRepository<CustomerRequest,String>{
	
	/*
	 * @Query(value =
	 * "select * from BACP_CUS_PROFILE where appl_ref_no= ?1 and rec_no=?2",
	 * nativeQuery = true) CustomerRequest findByref_no_rec_no_val(String
	 * appl_ref_no,String rec_no);
	 */
	
	@Query(value = "select cif_id from BACP_CUS_PROFILE where	ca_idenditification_number= ?1", nativeQuery = true)
	String findBynic(String nic);
	
	@Query(value = "SELECT CA_Cif_Id_1, CA_Cif_Id_2, CA_Cif_Id_3, CA_Cif_Id_4, CA_Cif_Id_5, CA_Cif_Id_6, CA_Cif_Id_7, CA_Cif_Id_8, CA_Cif_Id_9, CA_Cif_Id_10 FROM BACP_CUS_PROFILE WHERE CA_Cif_Id_1 IN (?1) OR CA_Cif_Id_2 IN (?1) OR CA_Cif_Id_3 IN (?1) OR CA_Cif_Id_4 IN (?1) OR CA_Cif_Id_5 IN (?1) OR CA_Cif_Id_6 IN (?1) OR CA_Cif_Id_7 IN (?1) OR CA_Cif_Id_8 IN (?1) OR CA_Cif_Id_9 IN (?1) OR CA_Cif_Id_10 IN (?1)", nativeQuery = true)
    List<String[]> getExistingCifIds(List<String> cifIds);
	
	@Query(value = "select * from BACP_CUS_PROFILE where appl_ref_no= ?1", nativeQuery = true)
	CustomerRequest findByref_no(String appl_ref_no);
	
	@Query(value = "select count(*) from BACP_CUS_PROFILE where appl_ref_no=?1 ", nativeQuery = true)
	String getusercount(String appl_ref_no);
	
	@Query(value = "select * from BACP_CUS_PROFILE where appl_ref_no= ?1", nativeQuery = true)
	CustomerRequest findByIdCustom(String Id);

	@Query(value = "select * from BACP_CUS_PROFILE where appl_ref_no= ?1", nativeQuery = true)
	CustomerRequest getCS(String appl_ref_no);
	
	@Query(value = "select * from BACP_CUS_PROFILE where appl_ref_no=?1", nativeQuery = true)
		CustomerRequest getuser(String appl_ref_no);
	
	@Query(value = "select * from BACP_CUS_PROFILE  where STATUS!='REJECT' and  STATUS!='HOLD' ", nativeQuery = true)
	List<CustomerRequest> getCSlist();
	@Query(value = "select * from BACP_CUS_PROFILE where status='HOLD'", nativeQuery = true)
	List<CustomerRequest> getCSlist1();
	@Query(value = "select * from BACP_CUS_PROFILE ", nativeQuery = true)
	List<CustomerRequest> getcustlist();
	
	@Query(value = "select * from BACP_CUS_PROFILE where ca_customer_type='RETAIL'", nativeQuery = true)
	List<CustomerRequest> getretaillist();
	
	@Query(value = "select * from BACP_CUS_PROFILE where ca_customer_type='CORPORATE'", nativeQuery = true)
	List<CustomerRequest> getcorplist();
	
	//for approval screen
	@Query(value = "SELECT * FROM BACP_CUS_PROFILE WHERE status IN ('APPROVED', 'NOT APPROVED')", nativeQuery = true)
	List<CustomerRequest> getApprovelist();
	@Query(value = "select * from BACP_CUS_PROFILE  where STATUS='APPROVED' ", nativeQuery = true)
	List<CustomerRequest> getapproved();
	
	@Query(value = "select * from BACP_CUS_PROFILE  where STATUS = 'NOT APPROVED' ", nativeQuery = true)
	List<CustomerRequest> getnotapproved();
	
	
	@Query(value = "SELECT * FROM BACP_CUS_PROFILE  WHERE KYC_FLG = 'N' AND status NOT IN ('REJECT', 'HOLD')\r\n" + 
			"", nativeQuery = true)
	List<CustomerRequest> getkyclist();
	@Query(value = "select * from BACP_CUS_PROFILE where status in ('HOLD','REJECT') order by entry_time desc", nativeQuery = true)
	List<CustomerRequest> findholdandrejectlist();
	@Query(value = "select * from BACP_CUS_PROFILE where entry_user ='User1' AND status IN ('HOLD', 'REJECT')", nativeQuery = true)
	List<CustomerRequest> finduser1list();
	@Query(value = "SELECT * FROM BACP_CUS_PROFILE WHERE entry_user = 'SYSTEM' AND status IN ('HOLD', 'REJECT')", nativeQuery = true)
	List<CustomerRequest> findSystemList();
	@Query(value = "SELECT * FROM BACP_CUS_PROFILE WHERE channel_id  = 'CH1' ", nativeQuery = true)
	List<CustomerRequest> findchannellist();
	@Query(value = "SELECT * FROM BACP_CUS_PROFILE WHERE channel_id  = 'CH2' ", nativeQuery = true)
	List<CustomerRequest> findchannellist2();
	@Query(value = "select * from BACP_MINIMAL_DATA where appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByapplrefs(String ApprefNO);

	/********************************** DASHBOARD ******************************************************************/
	
	@Query(value = "select count(*) from BACP_CUS_PROFILE where status='HOLD'", nativeQuery = true)
	Integer getACHOLDcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE where status='REJECT'", nativeQuery = true)
	Integer getACREJcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE where status='INITIATED'", nativeQuery = true)
	Integer getACINIcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE where status='APPROVED'", nativeQuery = true)
	Integer getACAPPcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE where status='IN-PROGRESS'", nativeQuery = true)
	Integer getACINPcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE where status='ACTIVATED'", nativeQuery = true)
	Integer getACACTcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE WHERE STATUS='HOLD'", nativeQuery = true)
	Integer getACPENDINGcount();
	@Query(value = "select count(*) from BACP_CUS_PROFILE WHERE KYC_FLG='Y' AND STATUS='HOLD' ", nativeQuery = true)
	Integer getACINBANKcount();


	
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByapp(String ApprefNO);
	
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1 ", nativeQuery = true)
	CustomerRequest findByappone(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByapptwo(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByappthree(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1 ", nativeQuery = true)
	CustomerRequest findByappfour(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByappfive(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1 ", nativeQuery = true)
	CustomerRequest findByappsix(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1 ", nativeQuery = true)
	CustomerRequest findByappseven(String ApprefNO);
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE appl_ref_no =?1", nativeQuery = true)
	CustomerRequest findByappeight(String ApprefNO);

     @Query(value = " select * from BACP_CUS_PROFILE", nativeQuery = true)
	 List<CustomerRequest>  gettabstatus();
	 @Query(value = "select * from BACP_CUS_PROFILE  WHERE STATUS='HOLD' ", nativeQuery = true)
	 List<CustomerRequest> gettabpending();
	 @Query(value = "select * from BACP_CUS_PROFILE  WHERE STATUS='ACTIVATED' ", nativeQuery = true)
	 List<CustomerRequest> gettabcompleted();


	 @Query(value = "select count(*) from BACP_CUS_PROFILE  WHERE KYC_HOLD_FLG='Y' ", nativeQuery = true)
	 Integer getAVcount();
	 @Query(value = " select * from BACP_CUS_PROFILE  WHERE KYC_HOLD_FLG='N'", nativeQuery = true)
	 List<CustomerRequest>  gettabAVN();
	 @Query(value = " select * from BACP_CUS_PROFILE  WHERE KYC_HOLD_FLG='Y'", nativeQuery = true)
	 List<CustomerRequest>  gettabAVY();
 
	 @Query(value = "select * from BACP_CUS_PROFILE where KYC_FLG='Y' ", nativeQuery = true)
	 List<CustomerRequest> getkycY();
	 @Query(value = "select * from BACP_CUS_PROFILE where KYC_FLG='N' ", nativeQuery = true)
	 List<CustomerRequest> getkycN();
	 @Query(value = "select * from BACP_CUS_PROFILE ", nativeQuery = true)
	 List<CustomerRequest> getkycall();
	 @Query(value = "select count(*) from BACP_CUS_PROFILE where KYC_FLG='Y'", nativeQuery = true)
	 Integer getkyccountY();
	 @Query(value = "select count(*) from BACP_CUS_PROFILE where KYC_FLG='N'", nativeQuery = true)
	 Integer getkyccountN();
	 @Query(value = "select count(*) from BACP_CUS_PROFILE ", nativeQuery = true)
	 Integer getkyccountall();
	 
	 @Query(value = "select * from BACP_CUS_PROFILE where appl_ref_no= ?1 AND rec_no= ?2", nativeQuery = true)
		CustomerRequest findByref_norec(String appl_ref_no,String rec_no);
	 @Query(value = "select * from BACP_CUS_PROFILE where appl_ref_no= ?1 ", nativeQuery = true)
		CustomerRequest findByappl(String appl_ref_no );
	 
		@Query(value = "select CIF_ID.NEXTVAL FROM DUAL", nativeQuery = true)
		Integer cif_id();
		@Query(value = "select ACC_ID.NEXTVAL FROM DUAL", nativeQuery = true)
		Integer Acc_id(); 
		@Query(value = "select LEASE_ACCOUNT_COR.NEXTVAL FROM DUAL", nativeQuery = true)
		Integer GetLEASE_ACCOUNT_COR(); 
		
	@Query(value = "SELECT DISTINCT(CIF_ID) FROM BACP_CUS_PROFILE", nativeQuery = true)
	List<String> getcustid();
	
	
	@Query(value = "SELECT * FROM BACP_CUS_PROFILE", nativeQuery = true)
	List<CustomerRequest> getcustidret();
	
	@Query(value = "SELECT CA_SOLID, BRANCH_DESC, CA_PREFERRED_NAME, la_glcode, la_gldesc, la_glshcode,la_glshdesc,ca_acct_type,appl_ref_no,rec_no,CIF_ID FROM BACP_CUS_PROFILE WHERE cif_id= ?1", nativeQuery = true)
	Object[] getCustList(String CIF_ID);

	@Query(value = "SELECT CA_PRIMARY_BRANCH_1, CA_BRANCH_NAME_1, CA_FULL_NAME_1, la_glcode, la_gldesc, la_glshcode,la_glshdesc,ca_acct_type,appl_ref_no,rec_no,ca_cif_id_1 FROM BACP_CUS_PROFILE WHERE ca_cif_id_1= ?1", nativeQuery = true)
	Object[] getCustList1(String CIF_ID);
	
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE la_loan_accountno =?1", nativeQuery = true)
	CustomerRequest FindByLeaseAccount(String AccountNO2);
		
	@Query(value = " select * from BACP_CUS_PROFILE  WHERE td_deposit_accountno =?1", nativeQuery = true)
	CustomerRequest FindByDepositAccount(String AccountNO1);

		  /*praveen*/
		  @Query(value = "select la_loan_accountno from BACP_CUS_PROFILE where cif_id=?1 AND status='APPROVED'", nativeQuery = true)
			String getloanAccountNumber(String custId);
		  
		  @Query(value = "select la_loan_accountno from BACP_CUS_PROFILE where ca_cif_id_1=?1 AND status='APPROVED'", nativeQuery = true)
			String getloanAccountNumber1(String custId);
		  
		  @Query(value = "select * from BACP_CUS_PROFILE where cif_id= ?1", nativeQuery = true)
			CustomerRequest findByCustId(String custID);

		  @Query(value = "select * from BACP_CUS_PROFILE where ca_cif_id_1= ?1", nativeQuery = true)
			CustomerRequest findByCustIdCor(String custID);

		 
}