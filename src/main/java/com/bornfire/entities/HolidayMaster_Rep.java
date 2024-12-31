package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HolidayMaster_Rep extends CrudRepository<HolidayMaster_Entity, BigDecimal> {

	@Query(value = "select * from HOLIDAY_MASTER", nativeQuery = true)
	List<HolidayMaster_Entity> getlistofHoliday();
	
	@Query(value = "select * from HOLIDAY_MASTER WHERE record_srl=?1", nativeQuery = true)
	HolidayMaster_Entity getsinglevalue(BigDecimal record_srl);
}
