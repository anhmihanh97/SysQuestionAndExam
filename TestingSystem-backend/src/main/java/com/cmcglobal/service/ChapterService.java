package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.Chapter;

public interface ChapterService {
	
	List<Chapter> findAllByID(int id);
	
	Chapter findChapterById(int id);

	Chapter create(Chapter chapter);
	
	 List findAll();
	
}
