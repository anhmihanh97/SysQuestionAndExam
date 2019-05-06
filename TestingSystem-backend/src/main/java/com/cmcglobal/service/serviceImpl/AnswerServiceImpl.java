package com.cmcglobal.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Answer;
import com.cmcglobal.repository.AnswerRepository;
import com.cmcglobal.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Override
	public List<Answer> getAllAnswer() {
		// TODO Auto-generated method stub
		return answerRepository.findAll();
	}

	@Override
	public Answer findById(String id) {
		// TODO Auto-generated method stub
		return answerRepository.findById(id).get();
	}

	@Override
	public void insertAnswer(Answer answer) {
		answerRepository.save(answer);
		
	}

	@Override
	public void deletebyId(String id) {	
		answerRepository.deleteById(id);
	}

	@Override
	public String editAnswer(String id, Answer newAnswer) {
		Boolean existA = answerRepository.existsById(id);
		if(!existA) {
			return "No question with id above";
		} else {
			newAnswer.setAnswerId(id);
			answerRepository.saveAndFlush(newAnswer);
			return "Update success";
		}
	}

}
