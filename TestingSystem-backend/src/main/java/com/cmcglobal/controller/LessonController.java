package com.cmcglobal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cmcglobal.entity.Chapter;
import com.cmcglobal.entity.Lesson;
import com.cmcglobal.entity.Test;
import com.cmcglobal.entity.User;
import com.cmcglobal.service.ChapterService;
import com.cmcglobal.service.LessonService;
import com.cmcglobal.service.TestService;
import com.cmcglobal.service.UploadFileService;
import com.cmcglobal.utils.Api;

@RestController
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RequestMapping(Api.Lesson.API_URL_LESSONS)
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	List<String> files = new ArrayList<>();
	
	@GetMapping(value = Api.Lesson.API_URL_LIST_LESSONS)
	public ResponseEntity<List<Lesson>> viewListLesson(@PathVariable("chapterId") int chapterId) throws Exception{
		return new ResponseEntity<List<Lesson>>(lessonService.findAllLessonById(chapterId),HttpStatus.OK);
	}
	
	@GetMapping(value = Api.Lesson.API_URL_LESSONS_INFOR)
	public ResponseEntity<Lesson> getLesson(@PathVariable int id) {
		if(lessonService.findLessonById(id) == null) {
			return new ResponseEntity<Lesson>(lessonService.findLessonById(id),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Lesson>(lessonService.findLessonById(id),HttpStatus.OK);
		}
	}
	
	@PostMapping(value = Api.Lesson.API_URL_LESSONS_ADD)
	public ResponseEntity<String> addLesson(@PathVariable("chapterId") int chapterId,@RequestParam("testId") int testId,@RequestParam("lesson") String lesson,  @RequestParam("fileVideo") MultipartFile fileVideo,@RequestParam("fileDocument") MultipartFile fileDocument,@RequestParam("fileAudio") MultipartFile fileAudio) throws JsonParseException, JsonMappingException, IOException{
		String message = "";
		//Lesson newsLesson = new ObjectMapper().readValue(lesson, Lesson.class);
		 JSONObject jsonObject = new JSONObject(lesson);
		 Lesson newsLesson = new Lesson();
		try {
			
			//save file
			uploadFileService.uploadFile(fileDocument);
			files.add(fileDocument.getOriginalFilename());
			message = "successfully uploaded" + fileDocument.getOriginalFilename() + "!";
			
			uploadFileService.uploadFile(fileAudio);
			files.add(fileAudio.getOriginalFilename());
			message = "successfully uploaded" + fileAudio.getOriginalFilename() + "!";
			
			uploadFileService.uploadFile(fileVideo);
			files.add(fileVideo.getOriginalFilename());
			message = "successfully uploaded" + fileVideo.getOriginalFilename() + "!";
			
			Chapter chapter = chapterService.findChapterById(chapterId);
			Test test = testService.findOne(testId);
			newsLesson.setLessonName(jsonObject.getString("lessonName"));
			newsLesson.setDescription(jsonObject.getString("description"));
			newsLesson.setTags(jsonObject.getString("tags"));
			newsLesson.setCondition(jsonObject.getString("condition"));
			newsLesson.setContent(jsonObject.getString("content"));
			newsLesson.setStatus(jsonObject.getString("status"));
			newsLesson.setAudio(fileAudio.getOriginalFilename());
			newsLesson.setVideo(fileVideo.getOriginalFilename());
			newsLesson.setLinkDocument(fileDocument.getOriginalFilename());
			newsLesson.setChapter(chapter);
			newsLesson.setTest(test);
			lessonService.addLesson(newsLesson);
			
			return ResponseEntity.status(HttpStatus.OK).body("Add Lesson Success!");
		} catch (Exception e) {
			message = "ERROR! can't upload " + fileDocument.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(message);
		}
		
		//return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = Api.Lesson.API_URL_LESSONS_UPDATE)
	public ResponseEntity<Lesson> editLesson(@PathVariable("lessonId") int lessonId,@PathVariable("chapterId") int chapterId,@RequestParam("testId") int testId,@RequestParam("lesson") String lesson,  @RequestParam("fileVideo") MultipartFile fileVideo,@RequestParam("fileDocument") MultipartFile fileDocument,@RequestParam("fileAudio") MultipartFile fileAudio) {
		JSONObject jsonObject = new JSONObject(lesson);
		 Lesson newsLesson = new Lesson();
		if(lessonService.findLessonById(lessonId) == null) {
			return new ResponseEntity<Lesson>(newsLesson,HttpStatus.NOT_FOUND);
		}else {
			String message = "";
			try {
				uploadFileService.saveFile(fileDocument);
				files.add(fileDocument.getOriginalFilename());
				message = "successfully uploaded" + fileDocument.getOriginalFilename() + "!";
				return new ResponseEntity<Lesson>(lessonService.editLesson(newsLesson, lessonId),HttpStatus.OK);
			} catch (Exception e) {
				message = "ERROR! can't upload " + fileDocument.getOriginalFilename() + "!";
				return new ResponseEntity<Lesson>(lessonService.editLesson(newsLesson, lessonId),HttpStatus.NOT_IMPLEMENTED);
			}
			
		}
	}
	
	
	@DeleteMapping(value = Api.Lesson.API_URL_LESSONS_DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("lessonId") int lessonId) {
		if(lessonService.findLessonById(lessonId)  == null) {
			lessonService.deleteLessonById(lessonId);
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}else {
			lessonService.deleteLessonById(lessonId);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = Api.User.API_URL_USERS_SEARCH_BY_NAME)
	public ResponseEntity<List<Lesson>> searchUserByName(@PathVariable("keyword") String keyword){
		return new ResponseEntity<List<Lesson>>(lessonService.findByTags(keyword),HttpStatus.OK);
	}
	
	
}
