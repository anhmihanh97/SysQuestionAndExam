
package com.cmcglobal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.CourseCatalog;
import com.cmcglobal.service.serviceImpl.CourseCatalogServiceImpl;
import com.cmcglobal.utils.Api;





@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RestController
@RequestMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS)
public class CourseCatalogController {
	
    @Autowired
	
	private CourseCatalogServiceImpl courseCatalogService;
	
	@GetMapping(value = Api.CourseCatalog.API_URL_LIST_COURSECATALOGS)
	public List<CourseCatalog> getAllCourseCatalogs() {
		System.out.println("Get all CourseCatalog...");
		return courseCatalogService.getAllCourseCatalogs();
	}
	

	@PutMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS_UPDATE)
	public ResponseEntity<CourseCatalog> updateCourseCatalog(@PathVariable("id") int id, @RequestBody CourseCatalog courseCatalogs) {
		System.out.println("Update CourseCatalog with ID = " + id + "...");
 
		Optional<CourseCatalog> courseCatalogData = courseCatalogService.findById(id);
 
		if (courseCatalogData.isPresent()) {
			CourseCatalog courseCatalog = courseCatalogData.get();
			courseCatalog.setCategoryCourseName(courseCatalogs.getCategoryCourseName());
			courseCatalog.setDescription(courseCatalogs.getDescription());
			
			
			return new ResponseEntity<>(courseCatalogService.saveCourseCatalog(courseCatalog), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS_ADD)
	public CourseCatalog createCourseCatalog(@RequestBody CourseCatalog courseCatalog) {

		return courseCatalogService.createCourseCatalog(courseCatalog);
	}
	
	@DeleteMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS_DELETE)
	public ResponseEntity<String> deleteCourseCatalog(@PathVariable("id") int id) {
		System.out.println("Delete Course Catalog with ID = " + id + "...");

		courseCatalogService.deleteCourseCatalogById(id);

		return new ResponseEntity<>("Course Catalog has been deleted!", HttpStatus.OK);
	}
	

	@DeleteMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS_DELETE_ALL)
	public ResponseEntity<String> deleteAllCourseCatalog() {
		System.out.println("Delete All Course Catalog...");

		courseCatalogService.deleteAllCourseCatalog();

		return new ResponseEntity<>("All course catalog have been deleted!", HttpStatus.OK);
	}
	

	@GetMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS_DETAIL)
	public CourseCatalog getCourseCatalogById(@PathVariable("id") int id) {
		System.out.println("Get CourseCatalog By Id..." + id + "...");

		return courseCatalogService.findByCategoryCourseId(id);
	}
	
	@GetMapping(value = Api.CourseCatalog.API_URL_COURSECATALOGS_SEARCH_BY_NAME)
	public List<CourseCatalog> findByCategoryCourseNameContaining(@PathVariable("name") String name) {
		return courseCatalogService.findByCategoryCourseNameContaining(name);
	}

	 @GetMapping(value="/course-catalog/list")
		public List<CourseCatalog> getAll(){
			return courseCatalogService.getAll();
		}
}
