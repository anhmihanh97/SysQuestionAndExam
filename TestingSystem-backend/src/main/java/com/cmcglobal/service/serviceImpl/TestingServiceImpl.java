package com.cmcglobal.service.serviceImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.TestingDataSubmit;
import com.cmcglobal.repository.AnswerRepository;
import com.cmcglobal.service.TestingService;
import com.cmcglobal.utils.TestingConstant;

@Service
@Transactional
@SuppressWarnings("rawtypes")
public class TestingServiceImpl implements TestingService {
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Map<String, Float> mark(TestingDataSubmit dataSubmit) {
		HashMap<String, Float> result = new HashMap<>();
		HashMap<String, HashMap<String, Boolean>> data = dataSubmit.getData();
		float correctNumber = 0;
		float mark = 0;
		Iterator iter = data.entrySet().iterator();
		while (iter.hasNext()) {
			boolean isCorrect = true;
			Map.Entry pair = (Map.Entry) iter.next();
			HashMap<String, Boolean> answer = data.get(pair.getKey());
			Iterator iter2 = answer.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry pair2 = (Map.Entry) iter2.next();
				String answerId = (String) pair2.getKey();
				if (answerRepository.getOne(answerId).isTrue() != Boolean
						.parseBoolean(String.valueOf(answer.get(pair2.getKey())))) {
					isCorrect = false;
				}
			}
			if (isCorrect) {
				correctNumber++;
			}
			isCorrect = true;
		}
		mark = (float) (Math.round((correctNumber / dataSubmit.getNumberOfQuestion()) * 1000.0f) / 100.0f);
		System.err.println(correctNumber + "::" + mark);
		result.put(TestingConstant.CORRECT_ANSWER_AMOUT, correctNumber);
		result.put(TestingConstant.MARK_OF_TEST, mark);
		return result;
	}

}
