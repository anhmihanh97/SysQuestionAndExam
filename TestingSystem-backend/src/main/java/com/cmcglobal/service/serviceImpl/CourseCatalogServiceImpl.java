package com.cmcglobal.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.CourseCatalog;
import com.cmcglobal.entity.Menu;
import com.cmcglobal.repository.CourseCatalogRepository;
import com.cmcglobal.service.CourseCatalogService;

@Service
public class CourseCatalogServiceImpl  implements CourseCatalogService{

	
	
	@Autowired
	private CourseCatalogRepository courseCatalogRepository;
	
	@Override
	public List<CourseCatalog> getAllCourseCatalogs() {
		// TODO Auto-generated method stub
		List<CourseCatalog> list = new ArrayList<>();
		courseCatalogRepository.findAll().forEach(list::add);
		return list;
	}

	@Override
	public Optional<CourseCatalog> findById(int id) {
		// TODO Auto-generated method stub
		Optional<CourseCatalog> courseCatalog = courseCatalogRepository.findById(id);
		return courseCatalog;
	}

	@Override
	public CourseCatalog saveCourseCatalog(CourseCatalog object) {
		// TODO Auto-generated method stub
		return courseCatalogRepository.save(object);
	}

	@Override
	public void deleteCourseCatalogById(int id) {
		// TODO Auto-generated method stub
		courseCatalogRepository.deleteById(id);
	}

	@Override
	public void deleteAllCourseCatalog() {
		// TODO Auto-generated method stub
		courseCatalogRepository.deleteAll();
	}

	@Override
	public List<CourseCatalog> findByCategoryCourseNameContaining(String name) {
		// TODO Auto-generated method stub
		List<CourseCatalog> listcourCatalogs= courseCatalogRepository.findByCategoryCourseNameContaining(name);
		return listcourCatalogs;
	}

	

	@Override
	public CourseCatalog createCourseCatalog(CourseCatalog courseCatalog) {
		// TODO Auto-generated method stub
		CourseCatalog newCourseCatalog = courseCatalogRepository.save(new CourseCatalog(0, courseCatalog.getCategoryCourseName(), courseCatalog.getDescription()));
		return newCourseCatalog;
	}

	

	@Override
	public CourseCatalog findByCategoryCourseId(int categoryCourseId) {
		// TODO Auto-generated method stub
		CourseCatalog courseCatalog = courseCatalogRepository.findByCategoryCourseId(categoryCourseId);
		return courseCatalog;
	}

	@Override
	public List<CourseCatalog> getAll() {
		
		return courseCatalogRepository.findAll();
	}

	


}
