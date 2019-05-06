/**
 * Create by: User - CMC
 * Create date: Feb 11, 2019
 * Modifier: User
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.QuestionTag;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
public interface TagService {
	List<QuestionTag> getAllTag();

	void insertTag(QuestionTag tag);

	void createTag(QuestionTag tag);
	
	public QuestionTag getOneById(int tagId); //yen
}
