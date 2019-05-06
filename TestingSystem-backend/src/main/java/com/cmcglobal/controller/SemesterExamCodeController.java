package com.cmcglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.SemesterExamCode;
import com.cmcglobal.service.ServiceResult;
import com.cmcglobal.service.UserService;
import com.cmcglobal.service.serviceImpl.SemesterExamCodeServiceImpl;
import com.cmcglobal.utils.Api;

@RestController
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class SemesterExamCodeController {
	@Autowired
	SemesterExamCodeServiceImpl semesterExamCodeServiceImpl;
	@Autowired
	private UserService userService;

	@GetMapping(value = Api.SemesterExamCode.API_URL_GET_SEMESTER_EXAM_CODE)
	public ResponseEntity<ServiceResult> getSemesterByCode(@PathVariable String code) {
		SemesterExamCode sec = semesterExamCodeServiceImpl.findByCode(code);
		return new ResponseEntity<ServiceResult>(userService.getExamBySemesterExamId(sec.getSemesterExamId()),
				HttpStatus.OK);
	}
}
