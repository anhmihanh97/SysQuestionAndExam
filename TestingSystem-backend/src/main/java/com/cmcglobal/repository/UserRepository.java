/**
 * Project name: Testing_System
 * Package name: com.cmcglobal.repository
 * File name: UserRepository.java
 * Author: ptphuong.
 * Created date: Feb 19, 2019
 * Created time: 2:40:45 PM
 */

package com.cmcglobal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	//check email
	Boolean existsByEmail(String email);
	
	@Query("FROM User u where u.fullName like %:keyword% ")
	List<User> findByFullname(@Param("keyword") String keyword);
	
	@Modifying
	@Query("Update User u set u.status = 0 where u.userId = :id")
	void deleteUserByID(@Param("id") int id);

}
