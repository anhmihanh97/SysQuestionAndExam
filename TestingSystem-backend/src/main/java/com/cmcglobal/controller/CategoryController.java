
package com.cmcglobal.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Category;
import com.cmcglobal.service.CategoryService;
import com.cmcglobal.utils.Api;

/**
 * Create by: thanhtd - CMC Create date: Feb 11, 2019 Modifier: thanhtd Modified
 * date: Feb 11, 2019 Description: .... Version 1.0
 */
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = Api.Category.API_URL_SUM_CATEGORY, method = RequestMethod.GET)
	private void sumCategory(HttpServletResponse responseHeaders) {
		responseHeaders.addHeader("SumCategory", categoryService.countQuestionCategory());
	}

	@RequestMapping(value = Api.Category.API_URL_COUNT_CATEGORY, method = RequestMethod.GET)
	private void countCategory(HttpServletResponse responseHeaders, @RequestParam String content) {
		responseHeaders.addHeader("CountSearchCategory", categoryService.countSearchCategory(content));
	}

	@RequestMapping(value = Api.Category.API_URL_GET_PAGE_CATEGORY, method = RequestMethod.GET)
	private List<Category> getPageCategory(
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.pageQuestionCategory(pageable);
	}

	@RequestMapping(value = Api.Category.API_URL_GET_ALL_CATEGORY, method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryService.getAllCategory();
	}

	@RequestMapping(value = Api.Category.API_URL_GET_CBYID, method = RequestMethod.GET)
	public Category getCById(@PathVariable("id") Integer id) {
		return categoryService.findById(id);
	}

	@RequestMapping(value = Api.Category.API_URL_SEARCHBYCONTENT, method = RequestMethod.GET)
	private List<Category> searchByContent(@RequestParam(defaultValue = "") String contentSearch,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		String content = contentSearch.trim();
		if (content.equals("")) {
			return categoryService.pageQuestionCategory(pageable);
		}
		return categoryService.searchByContent(content, pageable);
	}

	@RequestMapping(value = Api.Category.API_URL_INSERT, method = RequestMethod.POST)
	public void insert(@RequestBody Category category) {
		categoryService.insertCategory(category);
	}

	@RequestMapping(value = Api.Category.API_URL_DELETE_CATEGORY, method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deletebyId(id);
	}

	@RequestMapping(value = Api.Category.API_URL_EDIT_CATEGORY_ID, method = RequestMethod.PATCH)
	private String editCategory(@PathVariable("id") Integer id, @RequestBody Category newCategory) {
		return categoryService.editCategory(id, newCategory);
	}

	@PutMapping(value = Api.Category.API_URL_EDIT_CATEGORY_EDIT)
	private String editCategory(@RequestBody Category newCategory) {
		return categoryService.editCate(newCategory);
	}

	@RequestMapping(value = Api.Category.API_URL_LIST_CATEGORYS)
	public List<Category> listCategories() {

		return categoryService.findAll();
	}

	/**
	 * Author: ptphuong. Created date: Feb 22, 2019 Created time: 2:25:30 PM
	 * Description: TODO - .
	 * 
	 * @param categoryName
	 * @return
	 */
	@RequestMapping(value = Api.Category.API_URL_GETONE_CATEGORY)
	public Category getOne(@PathVariable String categoryName) {
		return categoryService.getOne(categoryName);
	}

}
