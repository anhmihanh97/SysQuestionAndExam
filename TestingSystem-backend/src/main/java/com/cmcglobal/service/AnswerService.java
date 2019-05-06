package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.Answer;

public interface AnswerService {
	/**
	 * @return
	 */
	List<Answer> getAllAnswer();

	/**
	 * @param id
	 * @return
	 */
	Answer findById(String id);

	/**
	 * @param answer
	 */
	void insertAnswer(Answer answer);

	/**
	 * @param id
	 */
	void deletebyId(String id);

	/**
	 * @param id
	 * @param newAnswer
	 * @return
	 */
	String editAnswer(String id, Answer newAnswer);
}
