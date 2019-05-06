
package com.cmcglobal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer", schema = "TESTING_SYSTEM_DATABASE")

public class Answer {

	@Id
	@Column(name = "answer_id", nullable = false, unique = true)
	private String answerId;

	@Column(name = "content")
	private String content;

	@Column(name = "is_true")
	private boolean isTrue;

	@Column(name = "status")
	private int status;

	@Column(name = "question_id")
	private String questionId;
	/**
	 * 
	 */
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param answerId
	 * @param content
	 * @param isTrue
	 * @param status
	 * @param questionId
	 */
	public Answer(String answerId, String content, boolean isTrue, int status, String questionId) {
		super();
		this.answerId = answerId;
		this.content = content;
		this.isTrue = isTrue;
		this.status = status;
		this.questionId = questionId;
	}

	/**
	 * @return the answerId
	 */
	public String getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the isTrue
	 */
	

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the questionId
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

}

