package com.cmcglobal.service;

import java.util.Date;
import java.util.List;

import com.cmcglobal.entity.SemesterExam;

public interface SemesterExamService {
	public abstract ServiceResult getAllSemesterExam();

	public abstract ServiceResult search(String keyword);

	public ServiceResult create(SemesterExam keyword);

	public ServiceResult delete(String id);

	public ServiceResult findById(String id);

	public ServiceResult filter(String name, Integer status, String fullname, Date startTime, Date endTime);

	/**
	 * Create by: nvdiem - CMC Create date: Feb 23, 2019 Modifier: nvdiem -CMC
	 * Modified date: Feb 23, 2019 Description: .... Version 1.0
	 * 
	 * @param id this is user's id
	 * @return
	 */
	ServiceResult getSemesterListByUserId(int id);

	public List<SemesterExam> getAll(SemesterExam semesterExam);
}
