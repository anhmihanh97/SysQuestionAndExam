package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.RoleMenu;
import com.cmcglobal.repository.RoleMenuRepository;

@Service
@Transactional
public class RoleMenuService {
	@Autowired
	private RoleMenuRepository roleMenuRepository;
	
	public List<RoleMenu> getAll(){
		return roleMenuRepository.findAll();
	}
}