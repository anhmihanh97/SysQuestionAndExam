package com.cmcglobal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cmcglobal.entity.CourseCatalog;


public interface CourseCatalogRepository extends JpaRepository<CourseCatalog,Integer>{
@Query("select  c from CourseCatalog c where c.categoryCourseName like %:name% or c.description like %:name%")
	
	List<CourseCatalog> findByCategoryCourseNameContaining(String name);
	
	CourseCatalog findByCategoryCourseId(int id);
}
