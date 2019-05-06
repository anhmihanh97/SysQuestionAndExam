package com.cmcglobal.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cmcglobal.entity.Menu;
import com.cmcglobal.entity.Role;
import com.cmcglobal.entity.RoleMenu;
import com.cmcglobal.repository.RoleMenuRepository;
import com.cmcglobal.service.serviceImpl.RoleMenuService;
import com.cmcglobal.service.serviceImpl.RoleServiceImpl;
import com.cmcglobal.utils.Api;
@RestController
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class RoleController {

	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private RoleMenuService rolemenuService;

	@Autowired
	private RoleMenuRepository roleMenuRepository;
   
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/role/list/{name}", method = RequestMethod.GET)
	public List<Menu> findbyname(@PathVariable String name) {
		List<Menu> menus = new ArrayList<Menu>();
		List<Role> roles = roleService.findAll();
		String[] arr = name.split(",");
		for (int i = 0; i < arr.length; i++) {
			for (Role role : roles) {
				if (arr[i].equals(role.getRoleName())) {
					for (RoleMenu roleMenu : role.getRoleMenus()) {
						menus.add(roleMenu.getMenu());
					}
				}
			}
		}
		Set r=new HashSet<>();
		menus.removeIf(name1 ->!r.add(name1.getMenuName()));
		return menus;
	}

	@RequestMapping(value = "/role/list", method = RequestMethod.GET)
	public List<Role> viewListRole() {
		return roleService.findAll();
	}

	@RequestMapping(value = "/roleMenu/list", method = RequestMethod.GET)
	public List<RoleMenu> viewListRoleMenu() {
		return rolemenuService.getAll();
	}

	@PutMapping(value = "/roleMenu/delete")
	public void deleteRoleMenu(@RequestBody RoleMenu roleMenu) {
		roleMenuRepository.deleteRoleMenu(roleMenu.getRole().getRoleId(), roleMenu.getMenu().getMenuId());
	}

	@PostMapping(value = "/roleMenu/add")
	public void addRoleMenu(@RequestBody RoleMenu roleMenu) {
		roleMenuRepository.addRoleMenu(roleMenu.getRole().getRoleId(), roleMenu.getMenu().getMenuId());
	}

}