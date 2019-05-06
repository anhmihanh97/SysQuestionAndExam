/**
 * 
 */
package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.QuestionLevel;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
public interface LevelService {
	List<QuestionLevel> getAllQuestionLevel();
	public QuestionLevel getOneById(int levelId); //Yen 
}
