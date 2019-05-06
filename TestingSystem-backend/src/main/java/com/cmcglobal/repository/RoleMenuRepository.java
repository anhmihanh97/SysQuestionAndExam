package com.cmcglobal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.entity.RoleMenu;
import com.cmcglobal.utils.RoleName;



public interface RoleMenuRepository extends JpaRepository<RoleMenu, Integer> {
	@Query("select rm from RoleMenu rm join rm.role r where r.roleName = ?1")
	public List<RoleMenu> fillByRole(RoleName name);

	
	@Modifying
	@Transactional
	@Query(value ="delete from role_menu where role_id = ?1 and menu_id = ?2", nativeQuery = true)
	public void deleteRoleMenu(int roleId,int menuId);
	
	@Modifying
	@Transactional
	@Query(value ="INSERT INTO role_menu (role_id,menu_id) VALUES (?1,?2)", nativeQuery = true)
	public void addRoleMenu(int roleId,int menuId);
}