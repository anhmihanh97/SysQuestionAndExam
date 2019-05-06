package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer>{
	/**
	 * Create by: HoangLinh
	 * Create date: Mar 13, 2019
	 * Description: ....
	 */
	@Query("FROM Lesson l where l.tags like %:tags% ")
	List<Lesson> findByTags(@Param("tags") String tags);
	
	@Query( value = "SELECT * FROM Lesson l WHERE l.chapter_id = :id", nativeQuery = true )
	List<Lesson> findAllLessonById(@Param("id") int id);
}
