package com.cmcglobal.custorm.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.builder.SemesterExamBuilder;
import com.cmcglobal.custorm.SemesterExamCustorm;
import com.cmcglobal.entity.SemesterExam;

@Repository
@Transactional
public class SemesterExamCustormImpl implements SemesterExamCustorm {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterExam> getAll(SemesterExamBuilder semesterExamBuilder) {

		StringBuilder builder = new StringBuilder("SELECT s FROM SemesterExam s ");
		if (StringUtils.isNotBlank(semesterExamBuilder.getRoleName())) {
			builder.append(" JOIN s.user u join u.roles r");
		}
		builder.append(" WHERE 1=1 ");
		builder = buildQuery(builder, semesterExamBuilder);
		Query query = entityManager.createQuery(builder.toString());
		return query.getResultList();
	}

	private StringBuilder buildQuery(StringBuilder sql, SemesterExamBuilder semesterExamBuilder) {
		Field[] fields = SemesterExamBuilder.class.getDeclaredFields();
		for (Field field : fields) {
			if (!field.getName().equals("roleName")) {

				// get Type
				String fieldType = field.getType().getName();

				if ("java.lang.String".equals(fieldType)) {

					String value = getValueFiled(field, semesterExamBuilder, String.class);

					if (StringUtils.isNotBlank(value)) {
						sql.append("AND LOWER(s." + field.getName() + ") LIKE '%" + value.toLowerCase() + "%'");
					}

				}

			}
		}

		if (StringUtils.isNotBlank(semesterExamBuilder.getRoleName())) {
			sql.append(" AND r.roleName = '" + semesterExamBuilder.getRoleName() + "'");
		}

		return sql;
	}

	private <T> T getValueFiled(Field field, SemesterExamBuilder semesterExamBuilder, Class<T> type) {
		Object result = null;
		Method getter = getGetter(field, semesterExamBuilder);
		if (getter != null) {
			try {
				result = getter.invoke(semesterExamBuilder);
			} catch (IllegalAccessException | InvocationTargetException e) {

			}
		}
		return type.cast(result);
	}

	private Method getGetter(Field field, SemesterExamBuilder builder) {
		String getterMethod = "get" + StringUtils.capitalize(field.getName());
		try {
			return builder.getClass().getMethod(getterMethod);
		} catch (Exception e) {
			return null;
		}
	}

}
