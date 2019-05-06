package com.cmcglobal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.Role;
import com.cmcglobal.utils.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRoleName(RoleName roleName);
	
	@Query("select r from Role r where r.roleName = ?1")
	Role findByName(RoleName name);
}
