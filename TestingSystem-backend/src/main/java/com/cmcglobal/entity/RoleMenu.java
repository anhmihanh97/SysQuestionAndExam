package com.cmcglobal.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class RoleMenu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "role_id")
	@JsonIgnoreProperties("roleMenus")
	private Role role;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "menu_id")
	@JsonIgnoreProperties("roleMenus")
	private Menu menu;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public RoleMenu(Role role, Menu menu) {
		super();
		this.role = role;
		this.menu = menu;
	}
	public RoleMenu() {
		super();
	}
	
}