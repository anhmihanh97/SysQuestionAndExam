package com.cmcglobal.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private int menuId;
	@Column(name = "menu_name")
	private String menuName;
	@Column(name = "menu_description")
	private String menuDescription;
	@Column(name = "menu_function")
	private String menuFunction;
//	@ManyToMany(mappedBy = "menus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("menus")
//	private Set<Role> roles = new HashSet<>();
	@OneToMany(mappedBy="role",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonIgnoreProperties("menu")
    private List<RoleMenu> roleMenus;
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getMenuFunction() {
		return menuFunction;
	}

	public void setMenuFunction(String menuFunction) {
		this.menuFunction = menuFunction;
	}

	public List<RoleMenu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(List<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public Menu(String menuName, String menuDescription, String menuFunction) {
		super();
		this.menuName = menuName;
		this.menuDescription = menuDescription;
		this.menuFunction = menuFunction;
	}

	public Menu() {
		super();
	}

}