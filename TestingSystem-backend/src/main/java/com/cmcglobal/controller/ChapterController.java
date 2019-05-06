package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Chapter;
import com.cmcglobal.service.ChapterService;
import com.cmcglobal.utils.Api;

@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RestController
@RequestMapping(value="/chapter")
public class ChapterController {

	@Autowired
    private ChapterService chapterService;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Chapter create(@RequestBody Chapter chapter){
        return chapterService.create(chapter);
    }
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<Chapter> findAll(){
        return chapterService.findAll();
    }
    
    @GetMapping(value = Api.Chapter.API_URL_LIST_CHAPTERS)
	public ResponseEntity<List<Chapter>> viewListChapter(@PathVariable("courseId") int id){
		return new ResponseEntity<List<Chapter>>(chapterService.findAllByID(id),HttpStatus.OK);
	}
	
	@GetMapping(value = Api.Chapter.API_URL_CHAPTERS_INFOR)
	public ResponseEntity<Chapter> getChapter(@PathVariable("courseId") int courseId,@PathVariable("chapterId") int chapterId) {
		if(chapterService.findChapterById(chapterId) == null) {
			return new ResponseEntity<Chapter>(chapterService.findChapterById(chapterId),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Chapter>(chapterService.findChapterById(chapterId),HttpStatus.OK);
		}
	}
}
