package com.cmcglobal.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.custorm.QuestionCustorm;
import com.cmcglobal.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String>,QuestionCustorm {
	List<Question> findByContentContaining(String contentSearch);

	@Query(value = "update question set category_id=?1, level_id=?2, tag_id=?3 where question_id=?4", nativeQuery = true)
	void updateMultiQuestion(String category_id, String level_id, String tag_id, String question_id);

	@Modifying
	@Transactional
	@Query(value = "update question set status = ?1 where question_id=?2", nativeQuery = true)
	void editStatus(int status,String questionId);
	
	// Team01
	@Query(value = "select q FROM Question q where category_id = ?1")
	List<Question> findByCategoryId(int categoryId);

	@Query(value = "select count(q.question_id) FROM Question q where category_id = ?1", nativeQuery = true)
	long countByCategoryId(int categoryId);

	// End Team01
	@Query("select q from Question q where q.questionId = ?1 ")
	Question getOne(String id);

	@Query("SELECT q FROM Question q WHERE q.content LIKE %?1%")
	List<Question> findByContentContaining(String contentSearch, Pageable pageable);

	@Query("SELECT q FROM Question q")
	List<Question> pageQuestion(Pageable pageable);

	@Query("select count(questionId) from Question")
	String questionSum();

	@Query("select count(questionId) from Question where content like ?1")
	String countSearchQuestion(String content);

	List<Question> filterQuestion(String userName, Date dateCreated, Integer tagId, Integer levelId, Integer categoryId,
			Integer typeId, Pageable pageable);

}
