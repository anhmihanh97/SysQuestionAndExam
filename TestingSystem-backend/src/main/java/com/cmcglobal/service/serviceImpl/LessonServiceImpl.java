package com.cmcglobal.service.serviceImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

//import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cmcglobal.entity.Lesson;
import com.cmcglobal.repository.LessonRepository;
import com.cmcglobal.service.LessonService;

@Service
@PropertySource("classpath:constants.properties")
@Transactional
public class LessonServiceImpl implements LessonService{
	
	//public final Logger logger = Logger.getLogger(LessonServiceImpl.class);
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Value("${LOG4J_WARM}")
	String LOG4J_WARM;
	@Value("${LOG4J_ERROR}")
	String LOG4J_ERROR;
	
	@Override
	public List<Lesson> findAllLessonById(int chapterId) throws Exception{
			return lessonRepository.findAllLessonById(chapterId);
		
	}

	@Override
	public Lesson findLessonById(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<Lesson> currentLesson = lessonRepository.findById(id);
			if(currentLesson.isPresent() == true) {
				return currentLesson.get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		//	logger.error(LOG4J_ERROR + e);
		}
		return null;
	}

	@Override
	public boolean addLesson(Lesson lesson) {
		// TODO Auto-generated method stub
		try {
			lessonRepository.save(lesson);
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		//	logger.error(LOG4J_ERROR + e);
		}
		return false;
	}

	@Override
	public Lesson editLesson(Lesson lesson, int id) {
		// TODO Auto-generated method stub
		try {
			Lesson currentLesson = lessonRepository.getOne(id);
			currentLesson.setLessonName(lesson.getLessonName());
			currentLesson.setTags(lesson.getTags());
			currentLesson.setCondition(lesson.getCondition());
			currentLesson.setContent(lesson.getContent());
			currentLesson.setStatus(lesson.getStatus());
			currentLesson.setVideo(lesson.getVideo());
			currentLesson.setAudio(lesson.getAudio());
			currentLesson.setLinkDocument(lesson.getLinkDocument());
			currentLesson.setDescription(lesson.getDescription());
			//currentLesson.setChapter(lesson.getChapter());
			//currentLesson.setTest(lesson.getTest());
			
			lessonRepository.save(currentLesson);
			return currentLesson;
		} catch (EntityNotFoundException e){
		//	logger.warn(LOG4J_WARM + e); 
			
		} catch (Exception e) {
			// TODO: handle exception
		//	logger.error(LOG4J_ERROR + e);
		}
		return null;
	}

	@Override
	public void deleteLessonById(int id) {
		// TODO Auto-generated method stub
		try {
			lessonRepository.deleteById(id);
		} catch (EntityNotFoundException e){
		//	logger.warn(LOG4J_WARM + e); 
			
		} catch (Exception e) {
			// TODO: handle exception
		//	logger.error(LOG4J_ERROR + e);
		}
	}

	@Override
	public List<Lesson> findByTags(String tags) {
		// TODO Auto-generated method stub
		try {
			return lessonRepository.findByTags(tags);
		} catch (Exception e) {
			// TODO: handle excepti
	//		logger.warn(LOG4J_WARM + e);
		}
		return new LinkedList<Lesson>();
	}
	
	

}
