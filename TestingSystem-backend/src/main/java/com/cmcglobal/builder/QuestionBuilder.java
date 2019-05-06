package com.cmcglobal.builder;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class QuestionBuilder {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:MM:SS";
	private String categoryName;
	private String roleName;
	private String dateCreated;
	private String tagName;
	private String levelName;
	private String typeName;

	public String getQuestionTag() {
		return tagName;
	}

	public String getQuestionLevel() {
		return levelName;
	}

	public String getQuestionType() {
		return typeName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getUserQuestion() {
		return roleName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * Author: ndvan. Created date: Feb 23, 2019 Created time: 9:37:17 AM
	 * Description: - .
	 * 
	 * @param builder - Builder.
	 */
	public QuestionBuilder(Builder builder) {

		this.categoryName = builder.categoryName;
		this.roleName = builder.roleName;
		this.dateCreated = builder.dateCreated;
		this.levelName = builder.levelName;
		this.tagName = builder.tagName;
		this.typeName = builder.typeName;
	}

	public static class Builder {
		private String categoryName;
		private String roleName;
		private String dateCreated;
		private String tagName;
		private String levelName;
		private String typeName;

		public Builder setCaterogyName(String categoryName) {
			this.categoryName = categoryName;
			return this;
		}

		public Builder setUserQuestion(String roleName) {
			this.roleName = roleName;
			return this;
		}

		public Builder setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
			return this;
		}

		public Builder setQuestionTag(String tagName) {
			this.tagName = tagName;
			return this;
		}

		public Builder setQuestionLevel(String levelName) {
			this.levelName = levelName;
			return this;

		}

		public Builder setQuestionType(String typeName) {
			this.typeName = typeName;
			return this;
		}

		public QuestionBuilder builder() {
			return new QuestionBuilder(this);
		}

	}
}
