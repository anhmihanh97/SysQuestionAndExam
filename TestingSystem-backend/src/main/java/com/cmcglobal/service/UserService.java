package com.cmcglobal.service;

import java.util.List;
import java.util.Optional;

import com.cmcglobal.entity.User;

public interface UserService {
    ServiceResult getSemseterListByUserId(String id);

    ServiceResult getExamBySemesterExamId(String id);
//
//    /**
//     * Author: ptphuong. Created date: Feb 19, 2019 Created time: 2:44:39 PM
//     * Description: TODO - .
//     * 
//     * @return
//     */
//    public List<User> findAll();

    /**
     * Author: ptphuong. Created date: Feb 20, 2019 Created time: 5:04:26 AM
     * Description: TODO - .
     * 
     * @param id
     * @return
     */
    public User findByID(int id);
    
    /**
     * Create by: HoangLinh - CMC
     * Create date: Feb 25, 2019
     * Modified date: Feb 25, 2019
     * Description: show list user
     */
    List<User> findAll();
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: get user by id
	 */
	User findUserById(int id);
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: add user
	 */
	boolean addUser(User user);
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: edit user
	 */
	User editUser(User user,int id);
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: delete user by id
	 */
	void deleteUser(int id);
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: search user by fullname
	 */
	List<User> findByFullName(String keyword);
	
	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: ....
	 */
	Optional<User> findByEmail(String email);

	/**
	 * Create by: HoangLinh - CMC
	 * Create date: Feb 25, 2019
	 * Modified date: Feb 25, 2019
	 * Description: ....
	 */
	Boolean existsByEmail(String email);
	
	public void updateUserRole(User user);
    
}
