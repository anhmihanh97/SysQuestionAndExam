package com.cmcglobal.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.cmcglobal.entity.Question;

public interface QuestionService {

	Question findById(String id);

	void insertQuestion(Question question);

	void deletebyId(String id);

	String editQuestion(String id, Question newQuestion);

	String editQuestion1(Question newQuestion);

	List<Question> searchByContent(String contentSearch, Pageable pageable);

	List<Question> pageQuestion(Pageable pageable);

	String countQuestion();

	String countSearchQuestion(String content);
	/**
	 ** Yen Trinh
	 * 
	 * @return
	 */
	String createId();

	/**
	 * Yen Trinh
	 * 
	 * @param exelFilePath
	 * @return
	 */
	List<Question> readExcel(String exelFilePath);

	List<Question> findAll(); // Yen
	
	List<Question> filterQuestion(String userName, Date dateCreated, Integer tagId, 
			Integer levelId, Integer categoryId,Integer typeId, Pageable pageable);
	  List<Question> getAllQuestion();



	  List<Question> searchByContent(String contentSearch);

	  void updateMultiQuestion(String category_id, String level_id, String tag_id,
	      String question_id);

	
	  // Team01
	  List<Question> findByCategoryId(int categoryId);
	  
	  long countByCategoryId(int categoryId);
	  // End Team01
	  
	  public List<Question> filter(Question question);
}
