package com.cmcglobal.service;

import java.util.Map;

import com.cmcglobal.entity.TestingDataSubmit;

public interface TestingService {

	/**
	 * Create by: nvdiem - CMC
	 * Create date: Feb 24, 2019
	 * Modifier: nvdiem -CMC
	 * Modified date: Feb 24, 2019
	 * Description: ....
	 * Version 1.0
	 * 
	 * @param dataSubmit
	 * @return
	 */
	Map<String, Float> mark(TestingDataSubmit dataSubmit);

}
