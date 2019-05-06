/**
 * Create by: User - CMC
 * Create date: Feb 11, 2019
 * Modifier: User
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.QuestionTag;
import com.cmcglobal.repository.QuestionTagRepository;
import com.cmcglobal.service.TagService;

/**
 * Create by: thanhtd - CMC Create date: Feb 11, 2019 Modifier: thanhtd Modified
 * date: Feb 11, 2019 Description: .... Version 1.0
 */
@Service
public class TagServiceImpl implements TagService {
	@Autowired
	EntityManager entityManager;

	@Autowired
	QuestionTagRepository tagRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.TagService#getAllTag()
	 */
	@Override
	public List<QuestionTag> getAllTag() {
		// TODO Auto-generated method stub
		return tagRepository.findAll();
	}

	@Override
	public void insertTag(QuestionTag tag) {
		if (!"".equals(tag.getTagName())) {

			tagRepository.save(tag);
		} else {
			System.out.println("không được để trống nameTag");
		}
	}

	@Override
	public void createTag(QuestionTag tag) {
		// TODO Auto-generated method stub
		tagRepository.save(tag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.TagService#getOneById(int)
	 */
	@Override
	public QuestionTag getOneById(int tagId) {
		// TODO Auto-generated method stub
		return entityManager.find(QuestionTag.class, tagId);
	}

}