package com.cmcglobal.service;

import java.util.List;
import java.util.Optional;

import com.cmcglobal.entity.Role;
import com.cmcglobal.utils.RoleName;

public interface RoleService {
	/**
	 * Create by: HoangLinh
	 * Create date: Feb 25, 2019
	 * Description: ....
	 */
	Optional<Role> findByRoleName(RoleName roleName);
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: ....
	 */
	List<Role> findAll();
}
