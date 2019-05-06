
package com.cmcglobal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@Table(name = "category", schema = "TESTING_SYSTEM_DATABASE_3")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", nullable = false, unique = true)
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "status")
	private int status;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_created")
	User userCategory;

	@OneToMany(mappedBy="category",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties("category")
    private List<Exam> exams;
	
	public Category(int categoryId, String categoryName, Date dateCreated, int status, User userCategory) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.dateCreated = dateCreated;
		this.status = status;
		this.userCategory = userCategory;
	}

	public Category() {
		super();
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(User userCategory) {
		this.userCategory = userCategory;
	}

}

