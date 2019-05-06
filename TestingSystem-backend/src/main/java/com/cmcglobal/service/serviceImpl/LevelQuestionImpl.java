/**
 * 
 */
package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.QuestionLevel;
import com.cmcglobal.repository.QuestionLevelRepository;
import com.cmcglobal.service.LevelService;

/**
 * @author User
 *
 */
@Service
public class LevelQuestionImpl implements LevelService {
	@Autowired
	EntityManager entityManager;

	@Autowired
	QuestionLevelRepository levelRepository;

	@Override
	public List<QuestionLevel> getAllQuestionLevel() {
		// TODO Auto-generated method stub
		return levelRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.LevelService#getOneById(int)
	 */
	@Override
	public QuestionLevel getOneById(int levelId) {
		// TODO Auto-generated method stub
		return entityManager.find(QuestionLevel.class, levelId);
	}

}