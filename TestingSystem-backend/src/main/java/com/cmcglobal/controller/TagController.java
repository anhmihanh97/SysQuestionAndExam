/**
 * Create by: User - CMC
 * Create date: Feb 11, 2019
 * Modifier: User
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.QuestionTag;
import com.cmcglobal.service.TagService;
import com.cmcglobal.utils.Api;

/**
 * Create by: thanhtd - CMC Create date: Feb 11, 2019 Modifier: thanhtd Modified
 * date: Feb 11, 2019 Description: .... Version 1.0
 */
@RestController
public class TagController {

	@Autowired
	TagService tagService;

	@RequestMapping(value = Api.Tag.API_URL_TAG_LIST, method = RequestMethod.GET)
	public List<QuestionTag> getAllTag() {
		return tagService.getAllTag();
	}

	@RequestMapping(value = Api.Tag.API_URL_TAG_INSERT, method = RequestMethod.POST)
	public void insert(@RequestBody QuestionTag tag) {
		tagService.insertTag(tag);
	}
}
