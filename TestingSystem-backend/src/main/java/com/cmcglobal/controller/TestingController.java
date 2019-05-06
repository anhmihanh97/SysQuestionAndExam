package com.cmcglobal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Candidate;
import com.cmcglobal.entity.CandidateTest;
import com.cmcglobal.entity.Test;
import com.cmcglobal.entity.TestingDataSubmit;
import com.cmcglobal.service.CandidateService;
import com.cmcglobal.service.CandidateTestService;
import com.cmcglobal.service.ServiceResult;
import com.cmcglobal.service.TestService;
import com.cmcglobal.service.TestingService;
import com.cmcglobal.utils.Api;
import com.cmcglobal.utils.TestingConstant;

@RestController
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class TestingController {
	@Autowired
	private TestService testService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private TestingService testingService;
	@Autowired
	private CandidateTestService candidateTestService;

	/**
	 * Create by: nvdiem - CMC Create date: Feb 24, 2019 Modifier: nvdiem -CMC
	 * Modified date: Feb 24, 2019 Description: .... Version 1.0
	 * 
	 * @param dataSubmit
	 * @param testId
	 * @param userId
	 * @return
	 */
	@PostMapping(value = Api.Testing.API_URL_SUBMIT_RESULT_TEST)
	ResponseEntity<ServiceResult> submitResultTest(@RequestBody TestingDataSubmit dataSubmit,
			@PathVariable("testId") int testId, @PathVariable("userId") int userId) {
		Test test = testService.findOne(testId);
		Candidate candidate = candidateService.getCandidateByUserIdAndSemesterId(userId,
				test.getSemesterExam().getId());
		if (candidateTestService.isExistCandidateTest(candidate.getId(), test.getTestID())) {
			return new ResponseEntity<ServiceResult>(new ServiceResult(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Map<String, Float> marker = testingService.mark(dataSubmit);

		CandidateTest candidateTest = new CandidateTest();
		candidateTest.setCandidates(candidate);
		candidateTest.setTests(test);
		candidateTest.setMark(marker.get(TestingConstant.MARK_OF_TEST));
		candidateTest.setCorrect_number(Math.round(marker.get(TestingConstant.CORRECT_ANSWER_AMOUT)));
		candidateTest.setStart_time(dataSubmit.getStartTime());
		candidateTest.setEnd_time(dataSubmit.getEndTime());
		CandidateTest test2 = candidateTestService.insertCandidateTest(candidateTest);
		ServiceResult result = new ServiceResult();
		result.setData(test2);
		result.setHttpStatus(HttpStatus.OK);
		return new ResponseEntity<ServiceResult>(result, result.getHttpStatus());
	}

	@GetMapping(value = Api.Testing.API_URL_SUBMIT_RESULT_TEST)
	ResponseEntity<ServiceResult> getResultTest(@PathVariable("userId") int userId,
			@PathVariable("semesterId") String semesterId, @PathVariable("examId") String examId) {
		ServiceResult result = new ServiceResult();
		Candidate candidate = candidateService.getCandidateByUserIdAndSemesterId(userId, semesterId);
		Test test = (Test) testService.getTestBySemesterIdAndExamId(semesterId, examId).getData();
		CandidateTest candidateTest = candidateTestService.getCandidateTestByCandidateAndTest(candidate, test);
		result.setData(candidateTest);
		result.setHttpStatus(HttpStatus.OK);
		return new ResponseEntity<ServiceResult>(result, result.getHttpStatus());
	}
}
