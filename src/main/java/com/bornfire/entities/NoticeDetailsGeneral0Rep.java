package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDetailsGeneral0Rep extends JpaRepository<NoticeDetailsGeneral0Entity, String> {

	@Query(value = "select * from DDGD0 aa where aa.DEL_FLG = 'N' union all select * from DRAWDOWN_NOTICE_DETAILS_GENERAL bb where bb.del_flg = 'N'", nativeQuery = true)
	List<NoticeDetailsGeneral0Entity> getDrawDownList();

	@Query(value = "select * from DDGD0 aa where aa.DEL_FLG = 'N' and aa.dd_notice_ref = ?1 union all select * from DRAWDOWN_NOTICE_DETAILS_GENERAL bb where bb.del_flg = 'N' and bb.dd_notice_ref = ?1", nativeQuery = true)
	NoticeDetailsGeneral0Entity getDrawDowngeneralByDDref(String ddRef);

	@Query(value = "select * from INFOSYS.DDGD0 aa where aa.DEL_FLG = 'N' and aa.dd_notice_ref = ?1", nativeQuery = true)
	NoticeDetailsGeneral0Entity getRecordById(String ddRef);

	@Modifying
	@Query(value = "DELETE FROM INFOSYS.DDGD0 aa WHERE aa.DEL_FLG = 'N' and aa.dd_notice_ref = ?1", nativeQuery = true)
	void deleteById(String dd_notice_ref);

	@Modifying
	@Query(value = "COMMIT", nativeQuery = true)
	void commitCmd();

}