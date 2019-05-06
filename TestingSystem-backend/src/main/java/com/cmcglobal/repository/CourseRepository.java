package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.entity.Course;
import com.cmcglobal.entity.CourseCatalog;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	
	@Query("SELECT c FROM Course c join c.courseCatalog cc ")
	List<Course> pageCourse(Pageable pageable);
	
	@Query("select count(c.courseId)  from Course c  where  c.courseName like %?1%")
	String courseSearchSum(String courseName);
	
	@Query("SELECT c FROM Course c  where  c.courseName like %?1%")
	List<Course> pageSearchCourse(String courseName,Pageable pageable);
	
	@Query("select count(courseId)  from Course")
	String countCourse();
	
	@Modifying
	@Transactional
	@Query(value ="delete from Course where course_id = ?1", nativeQuery = true)
	public void deleteCourse(int id);
	
	@Query("SELECT c FROM Course c join c.courseCatalog cc  where cc.categoryCourseId = ?1 ")
	List<Course> pagefilterCourse(int idCatalog,Pageable pageable);
	
	@Query("select count(c.courseId)  from Course  c join c.courseCatalog cc  where cc.categoryCourseId = ?1")
	String countCatalogCourse(int idCatalog);
}
