package com.cmcglobal.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category_course")
public class CourseCatalog implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_course_id")
	private int categoryCourseId;
	@Column(name = "category_course_name")
	private String categoryCourseName;
	private String description;
	@OneToMany(mappedBy = "courseCatalog", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("courseCatalog")
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getCategoryCourseId() {
		return categoryCourseId;
	}

	public void setCategoryCourseId(int categoryCourseId) {
		this.categoryCourseId = categoryCourseId;
	}

	public String getCategoryCourseName() {
		return categoryCourseName;
	}

	public void setCategoryCourseName(String categoryCourseName) {
		this.categoryCourseName = categoryCourseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public CourseCatalog() {
		// TODO Auto-generated constructor stub
	}
	
	public CourseCatalog(int categoryCourseId, String categoryCourseName, String description) {

		this.categoryCourseId = categoryCourseId;
		this.categoryCourseName = categoryCourseName;
		this.description = description;

	}

}
