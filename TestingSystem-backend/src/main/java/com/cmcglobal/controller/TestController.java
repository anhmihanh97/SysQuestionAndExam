package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Test;
import com.cmcglobal.service.ServiceResult;
import com.cmcglobal.service.TestService;
import com.cmcglobal.utils.Api;

@RestController
@RequestMapping(Api.Test.API_URL_SEMESTER_TEST_START)
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class TestController {

	@Autowired
	TestService testService;

	/**
	 * Create by: VuThuy - CMC Create date: Feb 19, 2019 Modifier: VuThuy Modified
	 * date: Feb 19, 2019 Description: List table test. Version 1.0
	 * 
	 * @return
	 */
	@GetMapping(value = Api.Test.API_URL_LIST_TEST)
	public List<Test> listTest() {
		return testService.findAll();
	}

	/**
	 * Create by: VuThuy - CMC Create date: Feb 19, 2019 Modifier: VuThuy Modified
	 * date: Feb 19, 2019 Description: listBySemester in table test Version 1.0
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = Api.Test.API_URL_LIST_BY_SEMESTER)
	public List<Test> listBySemester(@PathVariable("id") String id) {
		return testService.findBySemesterID(id);
	}

	/**
	 * Create by: VuThuy - CMC
	 * Create date: Feb 19, 2019
	 * Modifier: VuThuy
	 * Modified date: Feb 19, 2019
	 * Description: ....
	 * Version 1.0
	 * 
	 * @param test
	 * @return
	 */
	@PostMapping(value = Api.Test.API_URL_INSERT_SEMESTER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResult> insertTest(@RequestBody Test test) {
		return new ResponseEntity<ServiceResult>(testService.insertTest(test), HttpStatus.OK);
	}

	/**
	 * Create by: VuThuy - CMC
	 * Create date: Feb 19, 2019
	 * Modifier: VuThuy
	 * Modified date: Feb 19, 2019
	 * Description: ....
	 * Version 1.0
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = Api.Test.API_URL_DELETE_SEMESTER)
	public ResponseEntity<ServiceResult> deleteTest(@PathVariable Integer id) {
		return new ResponseEntity<ServiceResult>(testService.deleteTest(id), HttpStatus.OK);
	}

	/**
	 * Create by: nvdiem - CMC
	 * Create date: Feb 23, 2019
	 * Modifier: nvdiem -CMC
	 * Modified date: Feb 23, 2019
	 * Description: ....
	 * Version 1.0
	 * 
	 * @param semesterId
	 * @param examId
	 * @return
	 */
	@RequestMapping(value = Api.Test.API_URL_GET_TEST_BYID)
	public ResponseEntity<ServiceResult> getTestById(@PathVariable("semesterId") String semesterId,
			@PathVariable("examId") String examId) {
		ServiceResult result = testService.getTestBySemesterIdAndExamId(semesterId, examId);
		return new ResponseEntity<ServiceResult>(result, result.getHttpStatus());
	}

	/**
	 * Create by: nvdiem - CMC
	 * Create date: Feb 23, 2019
	 * Modifier: nvdiem -CMC
	 * Modified date: Feb 23, 2019
	 * Description: ....
	 * Version 1.0
	 * 
	 * @param userId
	 * @param semesterId
	 * @return
	 */
	@RequestMapping(value = Api.Test.API_URL_GET_TEST_OF_SEMESTER_OF_USER)
	public ResponseEntity<ServiceResult> getTestsOfSemesterOfUser(@PathVariable("userId") int userId,
			@PathVariable("semesterId") String semesterId) {
		ServiceResult result = new ServiceResult();
		result.setData(testService.getTestsOfSemesterOfUser(userId, semesterId));
		return new ResponseEntity<ServiceResult>(result, HttpStatus.OK);
	}
}