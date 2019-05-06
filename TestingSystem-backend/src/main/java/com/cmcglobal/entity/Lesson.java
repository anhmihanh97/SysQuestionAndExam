package com.cmcglobal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Lesson implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int lessonId;
	@Column(name = "lesson_name")
	private String lessonName;
	private String description;
	private String tags;
	@Column(name = "`condition`")
	private String condition;
	private String content;
	private String status;
	private String video;
	private String audio;
	@Column(name = "link_document")
	private String linkDocument;
	@ManyToOne
	@JoinColumn(name = "chapter_id")
	private Chapter chapter;
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getLinkDocument() {
		return linkDocument;
	}

	public void setLinkDocument(String linkDocument) {
		this.linkDocument = linkDocument;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}


	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Lesson() {
		super();
	}

	public Lesson(String lessonName, String description, String tags, String condition, String content, String status,
			String video, String audio, String linkDocument) {
		super();
		this.lessonName = lessonName;
		this.description = description;
		this.tags = tags;
		this.condition = condition;
		this.content = content;
		this.status = status;
		this.video = video;
		this.audio = audio;
		this.linkDocument = linkDocument;
	}
	

}
