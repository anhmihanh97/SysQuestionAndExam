package com.cmcglobal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Menu;
import com.cmcglobal.service.MenuService;
import com.cmcglobal.utils.Api;


@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RestController
@RequestMapping(value = Api.Menu.API_URL_MENUS)
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping(value = Api.Menu.API_URL_LIST_MENUS)
	public List<Menu> getAllMenu() {
		System.out.println("Get all Menu...");
		return menuService.getAllMenu();
	}
	
	@PutMapping(value = Api.Menu.API_URL_MENUS_UPDATE)
	public ResponseEntity<Menu> updateMenu(@PathVariable("id") int id, @RequestBody Menu menus) {
		System.out.println("Update Menu with ID = " + id + "...");
 
		Optional<Menu> menuData = menuService.findById(id);
 
		if (menuData.isPresent()) {
			Menu menu = menuData.get();
			menu.setMenuName(menus.getMenuName());
			menu.setMenuDescription(menus.getMenuDescription());
			menu.setMenuFunction(menus.getMenuFunction());
			
			return new ResponseEntity<>(menuService.saveMenu(menu), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = Api.Menu.API_URL_MENUS_ADD)
	public Menu createMenu(@RequestBody Menu menu) {

		return menuService.createMenu(menu);
	}
	
	@DeleteMapping(value = Api.Menu.API_URL_MENUS_DELETE)
	public ResponseEntity<String> deleteMenu(@PathVariable("id") int id) {
		System.out.println("Delete Menu with ID = " + id + "...");

		menuService.deleteMenuById(id);

		return new ResponseEntity<>("Menur has been deleted!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = Api.Menu.API_URL_MENUS_DELETE_ALL)
	public ResponseEntity<String> deleteAllGroupUsers() {
		System.out.println("Delete All Menu...");

		menuService.deleteAllMenu();

		return new ResponseEntity<>("All menu have been deleted!", HttpStatus.OK);
	}
	
	@GetMapping(value = Api.Menu.API_URL_MENUS_DETAIL)
	public Menu getMenuById(@PathVariable("id") int id) {
		System.out.println("Get Menu By Id..." + id + "...");

		return menuService.findByMenuId(id);
	}
	
	@GetMapping(value = Api.Menu.API_URL_MENUS_SEARCH_BY_NAME)
	public List<Menu> findByMenuNameContaining(@PathVariable("name") String name) {
		return menuService.findByMenuNameContaining(name);
	}
}
