package com.bornfire.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRep extends CrudRepository<UserProfile, String> {

	public Optional<UserProfile> findByusername(String userName);

	@Query(value = "SELECT * FROM BGLS_USER_PROFILE_TABLE WHERE DEL_FLG = 'N' ORDER BY REGEXP_SUBSTR(USER_ID, '^[^0-9]+'), TO_NUMBER(REGEXP_SUBSTR(USER_ID, '[0-9]+'))", nativeQuery = true)
	List<UserProfile> getAllList();
	
	@Query(value = "select * from BGLS_USER_PROFILE_TABLE where USER_ID=?1", nativeQuery = true)
	UserProfile getRole(String userId);
	
	@Query(value = "SELECT MAX(CAST(numeric_part AS INT)) AS max_numeric_part\r\n"
			+ "FROM (\r\n"
			+ "    SELECT CAST(\r\n"
			+ "        CASE \r\n"
			+ "            WHEN PATINDEX('%[0-9]%', USER_ID) > 0 \r\n"
			+ "            THEN REPLACE(REPLACE(REPLACE(REPLACE(USER_ID, 'U', ''), 'S', ''), 'E', ''), 'R', '') \r\n"
			+ "            ELSE '0' \r\n"
			+ "        END AS INT\r\n"
			+ "    ) AS numeric_part\r\n"
			+ "    FROM BGLS_USER_PROFILE_TABLE\r\n"
			+ ") AS subquery", nativeQuery = true)
	String getUSERIDNumMax();
	
	
	@Query(value = "DELETE from BGLS_USER_PROFILE_TABLE where USER_ID=?1", nativeQuery = true)
	void deleteRecord(String userId);
	
	@Query(value = "SELECT * FROM BGLS_USER_PROFILE_TABLE WHERE DEL_FLG='N' and role_id ='ADM'", nativeQuery = true)
	List<UserProfile> getUserId();
	
	@Query(value = "select user_name,email_id,mob_number from BGLS_USER_PROFILE_TABLE where USER_ID=?1", nativeQuery = true)
	Object[] getdetailsforalert(String userid);

}
