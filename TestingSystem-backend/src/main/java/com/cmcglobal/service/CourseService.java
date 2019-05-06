package com.cmcglobal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.cmcglobal.entity.Course;
import com.cmcglobal.entity.CourseCatalog;
import com.cmcglobal.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public void deleteCourse(int id) {
		courseRepository.deleteCourse(id);
	}
	public Course findById(int id) {
		return courseRepository.findById(id).get();
	}
	
	public void editCourse(Course course) {
		Course co = courseRepository.findById(course.getCourseId()).get();
		if (co !=null) {
			co.setCourseId(course.getCourseId());
			co.setCourseCatalog(course.getCourseCatalog());
			co.setCourseName(course.getCourseName());
			co.setPrice(course.getPrice());
			co.setStatus(course.getStatus());
			co.setTags(course.getTags());
			if(course.getVideo()!=null) {
				co.setVideo(course.getVideo());
			}
			if(course.getImage()!=null) {
				co.setImage(course.getImage());
			}
			co.setTitle(course.getTitle());
			co.setDescription(course.getDescription());
			
			courseRepository.save(co);
		}
		
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	public List<Course> pageCourse(Pageable pageable) {

		return courseRepository.pageCourse(pageable);

	}
	
	public String sumCourse() {
		return courseRepository.countCourse();
	}
	
	public List<Course> pageSearchCourse(String courseName,Pageable pageable){
		return courseRepository.pageSearchCourse( courseName, pageable);
	}
	
	public String courseSearchSum(String courseName) {
		return courseRepository.courseSearchSum(courseName);
	}
}
