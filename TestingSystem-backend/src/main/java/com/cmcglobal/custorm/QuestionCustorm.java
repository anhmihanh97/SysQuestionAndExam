package com.cmcglobal.custorm;

import java.util.List;

import com.cmcglobal.builder.QuestionBuilder;
import com.cmcglobal.entity.Question;

public interface QuestionCustorm {
public List<Question> getAll(QuestionBuilder questionBuilder);
}
