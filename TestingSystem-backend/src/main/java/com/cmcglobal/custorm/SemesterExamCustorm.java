package com.cmcglobal.custorm;

import java.util.List;

import com.cmcglobal.builder.SemesterExamBuilder;
import com.cmcglobal.entity.SemesterExam;

public interface SemesterExamCustorm {
	public List<SemesterExam> getAll(SemesterExamBuilder semesterExamBuilder);
}
