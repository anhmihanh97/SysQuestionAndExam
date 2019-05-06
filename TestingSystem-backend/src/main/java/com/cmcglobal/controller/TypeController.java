/**
 * Create by: User - CMC
 * Create date: Feb 15, 2019
 * Modifier: User
 * Modified date: Feb 15, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.QuestionType;
import com.cmcglobal.service.TypeSevice;
import com.cmcglobal.utils.Api;

/**
 * Create by: thanhtd - CMC Create date: Feb 15, 2019 Modifier: thanhtd Modified
 * date: Feb 15, 2019 Description: .... Version 1.0
 */
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
@RestController
public class TypeController {

	@Autowired
	TypeSevice typeService;

	@GetMapping(value = Api.Type.API_URL_GET_ALL_TYPE)
	public List<QuestionType> getAllType() {
		return typeService.getAllType();

	}
}
