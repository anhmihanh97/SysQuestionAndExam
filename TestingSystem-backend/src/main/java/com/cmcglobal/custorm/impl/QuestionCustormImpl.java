package com.cmcglobal.custorm.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.builder.QuestionBuilder;
import com.cmcglobal.custorm.QuestionCustorm;
import com.cmcglobal.entity.Question;

@Repository
@Transactional
public class QuestionCustormImpl implements QuestionCustorm {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAll(QuestionBuilder questionBuilder) {

		StringBuilder builder = new StringBuilder("SELECT qs FROM Question qs");
		if (StringUtils.isNotBlank(questionBuilder.getCategoryName())) {
			builder.append(" join qs.category ca");
		}
		if (StringUtils.isNotBlank(questionBuilder.getQuestionTag())) {
			builder.append(" join qs.questionTag qt");
		}
		if (StringUtils.isNotBlank(questionBuilder.getQuestionType())) {
			builder.append(" join qs.questionType qty");
		}
		if (StringUtils.isNotBlank(questionBuilder.getQuestionLevel())) {
			builder.append(" join qs.questionLevel ql");
		}
		if (StringUtils.isNotBlank(questionBuilder.getUserQuestion())) {
			builder.append(" join qs.userQuestion u join u.roles r");
		}

		builder.append(" WHERE 1=1 ");
		builder = buildQuery(builder, questionBuilder);
		Query query = entityManager.createQuery(builder.toString());
		return query.getResultList();
	}

	private StringBuilder buildQuery(StringBuilder sql, QuestionBuilder questionBuilder) {
		Field[] fields = QuestionBuilder.class.getDeclaredFields();
		for (Field field : fields) {
			if (!field.getName().equals("categoryName")) {

				// get Type
				String fieldType = field.getType().getName();

				if ("java.lang.String".equals(fieldType)) {

					String value = getValueFiled(field, questionBuilder, String.class);

					if (StringUtils.isNotBlank(value)) {
						sql.append(" AND LOWER(qs." + field.getName() + ") LIKE '%" + value.toLowerCase() + "%'");
					}

				} 
			}
		}
		// bang khac cho xuong duoi

		if (StringUtils.isNotBlank(questionBuilder.getCategoryName())) {
			sql.append(" AND ca.categoryName = '" + questionBuilder.getCategoryName() + "'");
		}
		if (StringUtils.isNotBlank(questionBuilder.getQuestionTag())) {
			sql.append(" AND qt.tagName = '" + questionBuilder.getQuestionTag() + "'");
		}
		if (StringUtils.isNotBlank(questionBuilder.getQuestionType())) {
			sql.append(" AND qty.typeName = '" + questionBuilder.getQuestionType() + "'");
		}
		if (StringUtils.isNotBlank(questionBuilder.getQuestionLevel())) {
			sql.append(" AND ql.levelName = '" + questionBuilder.getQuestionLevel() + "'");
		}
		if (StringUtils.isNotBlank(questionBuilder.getUserQuestion())) {
			sql.append(" AND r.roleName = '" + questionBuilder.getUserQuestion() + "'");
		}

		return sql;
	}

	private <T> T getValueFiled(Field field, QuestionBuilder userBuilder, Class<T> type) {
		Object result = null;
		Method getter = getGetter(field, userBuilder);
		if (getter != null) {
			try {
				result = getter.invoke(userBuilder);
			} catch (IllegalAccessException | InvocationTargetException e) {

			}
		}
		return type.cast(result);
	}

	private Method getGetter(Field field, QuestionBuilder builder) {
		String getterMethod = "get" + StringUtils.capitalize(field.getName());
		try {
			return builder.getClass().getMethod(getterMethod);
		} catch (Exception e) {
			return null;
		}
	}

}
