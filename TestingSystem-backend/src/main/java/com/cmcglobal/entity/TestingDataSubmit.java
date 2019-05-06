package com.cmcglobal.entity;

import java.util.Date;

import java.util.HashMap;

public class TestingDataSubmit {
	private Date startTime;
	private Date endTime;
	private int numberOfQuestion;
	private HashMap<String, HashMap<String, Boolean>> data;

	public TestingDataSubmit() {
	}

	public TestingDataSubmit(Date startTime, Date endTime, int numberOfQuestion,
			HashMap<String, HashMap<String, Boolean>> data) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.numberOfQuestion = numberOfQuestion;
		this.data = data;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;

	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {

		this.endTime = endTime;

	}

	public HashMap<String, HashMap<String, Boolean>> getData() {
		return data;
	}

	public void setData(HashMap<String, HashMap<String, Boolean>> data) {
		this.data = data;
	}

	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	@Override
	public String toString() {
		return "TestingDataSubmit [startTime=" + startTime + ", endTime=" + endTime + ", numberOfQuestion="
				+ numberOfQuestion + ", data=" + data + "]";
	}

}
