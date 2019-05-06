
/**
 * Project name: Testing_System
 * Package name: com.cmcglobal.service.serviceImpl
 * File name: CategoryServiceImpl.java
 * Author: ptphuong.
 * Created date: Feb 15, 2019
 * Created time: 1:18:14 PM
 */

package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Category;
import com.cmcglobal.repository.CategoryRepository;
import com.cmcglobal.service.CategoryService;

/*
 * @author ptphuong.
 * Created date: Feb 15, 2019
 * Created time: 1:18:14 PM
 * Description: TODO - 
 */

/**
 * Create by: thanhtd - CMC Create date: Feb 11, 2019 Modifier: thanhtd Modified
 * date: Feb 11, 2019 Description: .... Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired

	EntityManager entityManager;

	@Autowired
	CategoryRepository categoryRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * @see com.cmcglobal.service.CategoryService#getAllCategory()
	 */
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.getListCategory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.CategoryService#insertCategory(com.cmcglobal.entity.
	 * QuestionCategory)
	 */
	@Override
	public void insertCategory(Category category) {
		categoryRepository.save(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#deletebyId(java.lang.String)
	 */
	@Override
	public void deletebyId(Integer id) {
		categoryRepository.deleteById(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#editCategory(java.lang.String,
	 * com.cmcglobal.entity.Question)
	 */
	@Override
	public String editCategory(Integer id, Category newCategory) {
		Boolean existC = categoryRepository.existsById(id);
		if (!existC) {
			return "No category with id above";
		} else {
			newCategory.setCategoryId(id);
			categoryRepository.save(newCategory);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#findById(java.lang.Integer)
	 */
	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#searchByContent(java.lang.String)
	 */
	@Override
	public List<Category> searchByContent(String contentSearch, Pageable pageable) {
		contentSearch = "%" + contentSearch + "%";
		return categoryRepository.findByCategoryNameContaining(contentSearch, pageable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#pageQuestionCategory(org.
	 * springframework.data.domain.Pageable)
	 */
	@Override
	public List<Category> pageQuestionCategory(Pageable pageable) {

		return categoryRepository.pageQuestionCategory(pageable);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#countQuestionCategory()
	 */
	@Override
	public String countQuestionCategory() {
		return categoryRepository.questionCategorySum();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.CategoryService#countSearchCategory(java.lang.String)
	 */
	@Override
	public String countSearchCategory(String content) {
		// TODO Auto-generated method stub
		content = "%" + content + "%";
		return categoryRepository.countSearchCategory(content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#getOneById(int)
	 */
	@Override
	public Category getOneById(int categoryId) {
		// TODO Auto-generated method stub
		return entityManager.find(Category.class, categoryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.CategoryService#editCate(com.cmcglobal.entity.Category)
	 */
	@Override
	public String editCate(Category newCategory) {
		// TODO Auto-generated method stub
		categoryRepository.saveAndFlush(newCategory);
		return "Seccuss";
	}

	@Override
	public Category getOne(String categoryName) {
		return categoryRepository.findByName(categoryName);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

}
