/**
 * Create by: User - CMC
 * Create date: Feb 23, 2019
 * Modifier: User
 * Modified date: Feb 23, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.cmcglobal.entity.Question;

/**
 * Create by: thanhtd - CMC Create date: Feb 23, 2019 Modifier: thanhtd Modified
 * date: Feb 23, 2019 Description: .... Version 1.0
 */
public class QuestionRepositoryImpl {
	@Autowired
	EntityManager entityManager;
	
	public List<Question> filterQuestion(String userName, Date dateCreated, Integer tagId, Integer levelId,
	        Integer categoryId, Integer typeId, Pageable pageable) {			
		int check = 0;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select q from " + Question.class.getName() + " q ");
		if (userName != null) {
			stringBuffer.append(" where q.userQuestion.fullName like '%" + userName + "%'");
			check++;
		}
		if (dateCreated != null) {
			if (check == 0) {
				stringBuffer.append(" where q.dateCreated like '%" + dateCreated + "%'");
				check++;
			} else {
				stringBuffer.append(" and q.dateCreated like '%" + dateCreated + "%'");
			}
		}
		if (tagId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.questionTag.tagId =" + tagId);
				check++;
			} else {
				stringBuffer.append(" and q.questionTag.tagId =" + tagId);
			}
		}
		if (levelId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.questionLevel.levelId =" + levelId);
				check++;
			} else {
				stringBuffer.append(" and q.questionLevel.levelId =" + levelId);
			}
		}
		if (categoryId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.category.categoryId =" + categoryId);
				check++;
			} else {
				stringBuffer.append(" and q.category.categoryId =" + categoryId);
			}
		}
		if (typeId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.questionType.typeId =" + typeId);
				check++;
			} else {
				stringBuffer.append(" and q.questionType.typeId =" + typeId);
			}
		}
		String sql = stringBuffer.toString();
		System.out.println(sql);	
		Query query = entityManager.createQuery(sql, Question.class);
		return query.getResultList();
	}

}
