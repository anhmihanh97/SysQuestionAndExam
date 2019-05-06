package com.cmcglobal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.cmcglobal.entity.Menu;

public interface MenuService {

	List<Menu> getAllMenu();
	
	Optional<Menu> findById(int id);
	
	Menu saveMenu(Menu object);
	
	void deleteMenuById(int id);
	
	void deleteAllMenu();
	
	List<Menu> findByMenuNameContaining(String name);
		
	Menu findByMenuId(int menuId);
	
	Menu createMenu(@RequestBody Menu menu);
}
