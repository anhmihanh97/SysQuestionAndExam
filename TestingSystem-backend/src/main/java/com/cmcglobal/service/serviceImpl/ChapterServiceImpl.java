package com.cmcglobal.service.serviceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Chapter;
import com.cmcglobal.repository.ChapterRepository;
import com.cmcglobal.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService{

	//public final Logger logger = Logger.getLogger(LessonServiceImpl.class);
	
	@Autowired
	public ChapterRepository chapterRepository;
	
	@Value("${LOG4J_WARM}")
	String LOG4J_WARM;
	@Value("${LOG4J_ERROR}")
	String LOG4J_ERROR;
	
	@Override
	public Chapter create(Chapter chapter) {
		return chapterRepository.save(chapter);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return chapterRepository.findAll();
	}

	@Override
	public List<Chapter> findAllByID(int id) {
		// TODO Auto-generated method stub
		try {
			return chapterRepository.listChapter(id);
		} catch (Exception e) {
			// TODO: handle excepti
			e.printStackTrace();
		//	logger.warn(LOG4J_WARM + e);
		}
		return new LinkedList<Chapter>();
	}

	@Override
	public Chapter findChapterById(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<Chapter> currentChapter = chapterRepository.findById(id);
			if (currentChapter.isPresent() == true) {
				return currentChapter.get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		//	logger.error(LOG4J_ERROR + e);
		}
		return null;
	}

	
	
}
