package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDetailsSlabDetails0Rep extends JpaRepository<NoticeDetailsSlabDetails0Entity, String> {

	@Query(value = "select * from DDISD0 aa where aa.DEL_FLG = 'N' and aa.dd_notice_ref = ?1 union all select * from DRAWDOWN_NOTICE_DETAILS_INTEREST_SLABSDETAILS bb where bb.del_flg = 'N' and bb.dd_notice_ref = ?1", nativeQuery = true)
	NoticeDetailsSlabDetails0Entity getDrawDownSlabDetByDDref(String ddRef);

	@Query(value = "select * from INFOSYS.DDISD0 aa where aa.DEL_FLG = 'N' and aa.dd_notice_ref = ?1", nativeQuery = true)
	NoticeDetailsSlabDetails0Entity getRecordById(String ddRef);

	@Modifying
	@Query(value = "DELETE FROM INFOSYS.DDISD0 aa WHERE aa.DEL_FLG = 'N' and aa.dd_notice_ref = ?1", nativeQuery = true)
	void deleteById(String dd_notice_ref);

	@Modifying
	@Query(value = "COMMIT", nativeQuery = true)
	void commitCmd();
}