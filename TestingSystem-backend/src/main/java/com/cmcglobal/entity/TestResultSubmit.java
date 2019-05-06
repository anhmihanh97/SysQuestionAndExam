package com.cmcglobal.entity;

import java.util.List;

public class TestResultSubmit {
	private String questionId;
	private List<String> answerIds;

	public TestResultSubmit(String questionId, List<String> answerIds) {
		this.questionId = questionId;
		this.answerIds = answerIds;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public List<String> getAnswerIds() {
		return answerIds;
	}

	public void setAnswerIds(List<String> answerIds) {
		this.answerIds = answerIds;
	}

}
