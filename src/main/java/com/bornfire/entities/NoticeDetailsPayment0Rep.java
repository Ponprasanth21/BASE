package com.bornfire.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDetailsPayment0Rep
		extends JpaRepository<NoticeDetailsPayment0Entity, NoticeDetailsPayment0IDCLASS> {

	@Query(value = "SELECT INFOSYS.NOTICE_DETAILS_PAYMENT_SEQ.NEXTVAL AS SRL_NO FROM DUAL", nativeQuery = true)
	String getPaymentSrlNo();
	
	
	@Query(value = "select * from REPAYMENT_SCHEDULE_WORK where del_flg = 'N' and account_no=?1  union all select * from REPAYMENT_SCHEDULE where del_flg = 'N' and account_no=?1", nativeQuery = true)
	NoticeDetailsPayment0Entity getPaymentDetails(String accountNo); 
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from REPAYMENT_SCHEDULE_WORK where account_no=?1 ", nativeQuery = true)
	public void deleteRecord(String accountNo);

	@Modifying
	@Query(value = "COMMIT", nativeQuery = true)
	void commitCmd();

}
