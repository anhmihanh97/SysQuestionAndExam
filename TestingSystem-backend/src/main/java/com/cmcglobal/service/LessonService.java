package com.cmcglobal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.cmcglobal.entity.Chapter;
import com.cmcglobal.entity.Lesson;
import com.cmcglobal.entity.Test;
import com.cmcglobal.entity.User;

public interface LessonService {
	/**
	 * Create by: HoangLinh
	 * Create date: Mar 13, 2019
	 * Description: ....
	 */
	
	List<Lesson> findAllLessonById(int chapterId) throws Exception;
	
	Lesson findLessonById(int id);
	
	boolean addLesson(Lesson lesson);
	
	Lesson editLesson(Lesson lesson,int id);
	
	void deleteLessonById(int id);
	
	List<Lesson> findByTags(String tags);
	
}
