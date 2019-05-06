package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	@Query("select m from Menu m where m.menuName like %:name% or m.menuDescription like %:name% or m.menuFunction like %:name%")
	List<Menu> findByMenuNameContaining(String name);
	
	Menu findByMenuId(int id);
}
