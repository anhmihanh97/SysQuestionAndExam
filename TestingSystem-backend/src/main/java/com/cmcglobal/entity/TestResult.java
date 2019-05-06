package com.cmcglobal.entity;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "result_test")
public class TestResult {
	@Id
	@Column(name = "test_result_id")
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "candidate_test_id")
	@JsonIgnoreProperties("testResultList")
	private CandidateTest candidateTest;
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	@Column(name = "answer_id")
	private String answerId;
	public TestResult(int id, CandidateTest candidateTest, Question question, String answerId) {
		this.id = id;
		this.candidateTest = candidateTest;
		this.question = question;
		this.answerId = answerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CandidateTest getCandidateTest() {
		return candidateTest;

	}
	public void setCandidateTest(CandidateTest candidateTest) {
		this.candidateTest = candidateTest;

	}
	public Question getQuestion() {
		return question;

	}
	public void setQuestion(Question question) {
		this.question = question;

	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;

	}

}