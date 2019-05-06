package com.cmcglobal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcglobal.entity.Course;
import com.cmcglobal.entity.CourseCatalog;
import com.cmcglobal.repository.CourseCatalogRepository;
import com.cmcglobal.repository.CourseRepository;
import com.cmcglobal.service.CourseService;
import com.cmcglobal.service.UploadFileService;
import com.cmcglobal.utils.Api;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository repo;

	@Autowired
	private CourseCatalogRepository cataRepo;

	@Autowired
	private UploadFileService uploadFileService;

	List<String> files = new ArrayList<>();

	@GetMapping(value = "/courses/{id}")
	public Course findById(@PathVariable int id) {
		return courseService.findById(id);
	}

	@DeleteMapping(value = "/courses/delete/{id}")
	public void deleteCourseById(@PathVariable int id) {
		courseService.deleteCourse(id);
	}

	@PutMapping(value = "/courses/edit")
	public void updateCourse(@RequestParam("course") String course, @RequestParam(value="fileVideo",required=false) MultipartFile fileVideo,
			@RequestParam(value="fileImage",required=false) MultipartFile fileImage)
{
		String message = "";
		JSONObject jsonObject = new JSONObject(course);
		JSONObject jsonCatalog = jsonObject.getJSONObject("courseCatalog");
		Course newCourse = new Course();
		if (fileImage != null) {
			uploadFileService.uploadFile(fileImage);
			files.add(fileImage.getOriginalFilename());
			message = "successfully uploaded" + fileImage.getOriginalFilename() + "!";
			newCourse.setImage(fileImage.getOriginalFilename());
			
		}
		// save file

		if (fileVideo != null) {
			uploadFileService.uploadFile(fileVideo);
			files.add(fileVideo.getOriginalFilename());
			message = "successfully uploaded" + fileVideo.getOriginalFilename() + "!";
			newCourse.setVideo(fileVideo.getOriginalFilename());
		}

		CourseCatalog catalog = cataRepo.findByCategoryCourseId(jsonCatalog.getInt("categoryCourseId"));
		newCourse.setCourseId(jsonObject.getInt("courseId"));
		newCourse.setCourseName(jsonObject.getString("courseName"));
		newCourse.setDescription(jsonObject.getString("description"));
		newCourse.setTags(jsonObject.getString("tags"));
		newCourse.setPrice(jsonObject.getDouble("price"));
		newCourse.setStatus(jsonObject.getString("status"));
		newCourse.setTitle(jsonObject.getString("title"));

		newCourse.setCourseCatalog(catalog);
		courseService.editCourse(newCourse);
	}

	@PostMapping(value = "/courses/add")
	public void addCourse(@RequestParam("course") String course, @RequestParam("fileVideo") MultipartFile fileVideo,
			@RequestParam("fileImage") MultipartFile fileImage)
			throws JsonParseException, JsonMappingException, IOException {
		String message = "";
		JSONObject jsonObject = new JSONObject(course);
		Course newCourse = new Course();

		// save file
		uploadFileService.uploadFile(fileImage);
		files.add(fileImage.getOriginalFilename());
		message = "successfully uploaded" + fileImage.getOriginalFilename() + "!";

		uploadFileService.uploadFile(fileVideo);
		files.add(fileVideo.getOriginalFilename());
		message = "successfully uploaded" + fileVideo.getOriginalFilename() + "!";

		CourseCatalog catalog = cataRepo.findByCategoryCourseId(jsonObject.getInt("courseCatalog"));
		newCourse.setCourseName(jsonObject.getString("courseName"));
		newCourse.setDescription(jsonObject.getString("description"));
		newCourse.setTags(jsonObject.getString("tags"));
		newCourse.setPrice(jsonObject.getDouble("price"));
		newCourse.setStatus(jsonObject.getString("status"));
		newCourse.setTitle(jsonObject.getString("title"));
		newCourse.setImage(fileImage.getOriginalFilename());
		newCourse.setVideo(fileVideo.getOriginalFilename());
		newCourse.setCourseCatalog(catalog);
		courseService.addCourse(newCourse);
	}

	@RequestMapping(value = "/courses/sum", method = RequestMethod.GET)
	private String sumCourse() {
		return courseService.sumCourse();
	}

	@RequestMapping(value = "/courses/pagination", method = RequestMethod.GET)
	private List<Course> getPageCourse(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return courseService.pageCourse(pageable);
	}

	@RequestMapping(value = "/courses/search-by-content", method = RequestMethod.GET)
	private List<Course> getSearchPageCourse(@RequestParam(defaultValue = "") String contentSearch,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);

		return courseService.pageSearchCourse(contentSearch, pageable);
	}

	@RequestMapping(value = "/courses/sumSearch", method = RequestMethod.GET)
	private String sumSearchCourse(@RequestParam(defaultValue = "") String contentSearch) {
		return courseService.courseSearchSum(contentSearch);
	}
	
	@RequestMapping(value = "/courses/filterCatalog", method = RequestMethod.GET)
	private List<Course> getfilterPageCourse(@RequestParam int idCatalog,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);

		return repo.pagefilterCourse(idCatalog, pageable);
	}
	
	@RequestMapping(value = "/courses/countFilter", method = RequestMethod.GET)
	private String sumFilterCourse(@RequestParam int idCatalog) {
		return repo.countCatalogCourse(idCatalog);
	}

}
