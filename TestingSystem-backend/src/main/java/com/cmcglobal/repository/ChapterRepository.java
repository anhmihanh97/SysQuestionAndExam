package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cmcglobal.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
	
	@Query( value = "SELECT * FROM Chapter ch WHERE ch.course_id = :id", nativeQuery = true )
	List<Chapter> listChapter(@Param("id") int id);
}
