package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Answer;
import com.cmcglobal.service.serviceImpl.AnswerServiceImpl;
import com.cmcglobal.utils.Api;

@RestController
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class AnswerController {
	@Autowired
	private AnswerServiceImpl answerServiceImpl;

	@RequestMapping(value = Api.Answer.API_URL_LIST_ANSWER, method = RequestMethod.GET)
	private List<Answer> getAllAnswer() {
		return answerServiceImpl.getAllAnswer();
	}

	@RequestMapping(value = Api.Answer.API_URL_DETAIL_ANSWER, method = RequestMethod.GET)
	public Answer getAById(@PathVariable("id") String id) {
		return answerServiceImpl.findById(id);
	}

	@RequestMapping(value = Api.Answer.API_URL_ADD_ANSWER, method = RequestMethod.POST)
	public void insert(@RequestBody Answer answer) {
		answerServiceImpl.insertAnswer(answer);
	}

	@RequestMapping(value = Api.Answer.API_URL_DELETE_ANSWER, method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("answerID") String answerID) {
		answerServiceImpl.deletebyId(answerID);
	}

	@PutMapping(value = Api.Answer.API_URL_EDIT_ANSWER)
	private String editAnswer(@PathVariable("answerID") String answerID, @RequestBody Answer newAnswer) {
		return answerServiceImpl.editAnswer(answerID, newAnswer);

	}

}
