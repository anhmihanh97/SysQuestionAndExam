package com.cmcglobal.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Menu;
import com.cmcglobal.repository.MenuRepository;
import com.cmcglobal.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> list = new ArrayList<>();
		menuRepository.findAll().forEach(list::add);
		return list;
	}

	@Override
	public Optional<Menu> findById(int id) {
		// TODO Auto-generated method stub
		Optional<Menu> menu = menuRepository.findById(id);
		return menu;
	}

	@Override
	public Menu saveMenu(Menu object) {
		// TODO Auto-generated method stub
		return menuRepository.save(object);
	}

	@Override
	public void deleteMenuById(int id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);
	}

	@Override
	public void deleteAllMenu() {
		// TODO Auto-generated method stub
		menuRepository.deleteAll();
	}

	@Override
	public List<Menu> findByMenuNameContaining(String name) {
		// TODO Auto-generated method stub
		List<Menu> listmenu= menuRepository.findByMenuNameContaining(name);
		return listmenu;
	}

	@Override
	public Menu findByMenuId(int menuId) {
		// TODO Auto-generated method stub
		Menu menu = menuRepository.findByMenuId(menuId);
		return menu;
	}

	@Override
	public Menu createMenu(Menu menu) {
		// TODO Auto-generated method stub
		Menu newMenu = menuRepository.save(new Menu(menu.getMenuName(), menu.getMenuDescription(), menu.getMenuFunction()));
		return newMenu;
	}

}
