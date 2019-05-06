package com.cmcglobal.entity;

public class SemesterInformation {
	private SemesterExam semesterExam;

	private int total_number_exam;

	private int total_number_question;

	private int total_user_join;

	private int total_user_test;

	private String status;

	private float mean_mark;

	private String[] rate_title;

	private int[] rate_mark;

	public int[] getRate_mark() {

		return rate_mark;

	}

	public void setRate_mark(int[] rate_mark) {

		this.rate_mark = rate_mark;

	}

	public String[] getRate_title() {

		return rate_title;

	}

	public void setRate_title(String[] rate_title) {

		this.rate_title = rate_title;

	}

	public String getStatus() {

		return status;

	}

	public void setStatus(String status) {

		this.status = status;

	}

	public SemesterInformation() {

		super();

		// TODO Auto-generated constructor stub

	}

	public SemesterExam getSemesterExam() {

		return semesterExam;

	}

	public void setSemesterExam(SemesterExam semesterExam) {

		this.semesterExam = semesterExam;

	}

	public int getTotal_number_exam() {

		return total_number_exam;

	}

	public void setTotal_number_exam(int total_number_exam) {

		this.total_number_exam = total_number_exam;

	}

	public int getTotal_number_question() {

		return total_number_question;

	}

	public void setTotal_number_question(int total_number_question) {

		this.total_number_question = total_number_question;

	}

	public int getTotal_user_join() {

		return total_user_join;
	}

	public void setTotal_user_join(int total_user_join) {

		this.total_user_join = total_user_join;

	}

	public float getMean_mark() {

		return mean_mark;

	}

	public void setMean_mark(float mean_mark) {

		this.mean_mark = mean_mark;

	}

	public int getTotal_user_test() {

		return total_user_test;

	}

	public void setTotal_user_test(int total_user_test) {

		this.total_user_test = total_user_test;

	}

}
