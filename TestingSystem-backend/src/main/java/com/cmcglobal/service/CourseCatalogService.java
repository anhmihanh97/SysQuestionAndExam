
package com.cmcglobal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cmcglobal.entity.CourseCatalog;

import com.cmcglobal.repository.CourseCatalogRepository;


public interface CourseCatalogService {
	
	

	List<CourseCatalog> getAllCourseCatalogs();
	
	Optional<CourseCatalog> findById(int id);
	
	CourseCatalog saveCourseCatalog(CourseCatalog object);
	
	void deleteCourseCatalogById(int id);
	
	void deleteAllCourseCatalog();
	
	List<CourseCatalog> findByCategoryCourseNameContaining(String name);
		
	CourseCatalog findByCategoryCourseId(int categoryCourseId);
	
	CourseCatalog createCourseCatalog(@RequestBody CourseCatalog courseCatalog);
	
	 List<CourseCatalog> getAll();
}
