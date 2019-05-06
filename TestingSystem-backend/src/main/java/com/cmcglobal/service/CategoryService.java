
package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.Category;

/*
 * @author ptphuong.
 * Created date: Feb 15, 2019
 * Created time: 1:16:43 PM
 * Description: TODO - 
 */

import org.springframework.data.domain.Pageable;

/**
 * Create by: thanhtd - CMC Create date: Feb 11, 2019 Modifier: thanhtd Modified
 * date: Feb 11, 2019 Description: .... Version 1.0
 */

public interface CategoryService {
	public List<Category> getAllCategory();

	void insertCategory(Category category);

	void deletebyId(Integer id);

	Category findById(Integer id);

	String editCategory(Integer id, Category newCategory);

	List<Category> searchByContent(String contentSearch, Pageable pageable);

	List<Category> pageQuestionCategory(Pageable pageable);

	String countQuestionCategory();

	String countSearchCategory(String content);

	Category getOneById(int categoryId);

	String editCate(Category newCategory);

	public Category getOne(String categoryName);

	List<Category> findAll();

	public List<Category> getAll();

}
