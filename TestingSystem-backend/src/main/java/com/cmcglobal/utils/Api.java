/**
 * Project name: Testing_System
 * Package name: com.cmcglobal.utils
 * File name: Api.java
 * Author: Sanero.
 * Created date: Feb 20, 2019
 * Created time: 10:56:12 AM
 */

package com.cmcglobal.utils;

/*
 * @author Sanero.
 * Created date: Feb 20, 2019
 * Created time: 10:56:12 AM
 * Description: TODO - API.
 */

public interface Api {
	public static final String BASE_URL_CORS = "http://localhost:4200";

	/*
	 * @author Sanero. Created date: Feb 20, 2019 Created time: 10:56:37 AM
	 * Description: TODO - API of Exam Module.
	 */
	interface Exam {
		public static final String BASE_URL = "/exam";
		public static final String CREATE = "/create";
		public static final String GET_ALL = "/listExams";
		public static final String GET_BY_PAGE = "listExams/pagination";
		public static final String EXPORT = "/export/{id}";
		public static final String GET_ONE = "/{id}";
		public static final String APPROVE = "/approve";
		public static final String REMOVE_QUESTION = "/remove-question";
		public static final String ADD_QUESTION = "/add-question";
		public static final String RANDOM_QUESTION = "/random-question";
		public static final String IS_EMPTY_QUESTION = "/is-empty/{examId}";
		public static final String FILTER = "/filter";
		public static final String UPDATE_COMMON = "/update/update-common/{examId}";
		public static final String IMPORT_EXCEL = "/import-excel-file";
	}

	/**
	 * @author HoangLinh Create date: Feb 24, 2019
	 */
	interface User {
		public final static String API_URL_USERS = "/admin/user";
		public final static String API_URL_LIST_USERS = "/list";
		public final static String API_URL_USERS_ADD = "/add";
		public final static String API_URL_USERS_UPDATE = "/{id}/edit";
		public final static String API_URL_USERS_DELETE = "/{id}/delete";
		public final static String API_URL_USERS_INFOR = "/{id}/infor";
		public final static String API_URL_USERS_SEARCH_BY_NAME = "/search/{keyword}";
		public final static String API_URL_LIST_ROLES = "/role";

		public final static String API_URL_GET_SEMESTER_LIST_BY_USER_ID = "/{id}/semesters";
		public final static String API_URL_GET_TEST_LIST_OF_USER = "/semesters/{semesterId}/tests/";
		public final static String API_URL_LIST_USER = "/user/listUsers";
		public final static String API_URL_GET_USER = "/{id}";

	}

	interface Group {
		public final static String API_URL_GROUPS = "/admin/group";
		public final static String API_URL_LIST_GROUPS = "/list";
		public final static String API_URL_GROUPS_ADD = "/add";
		public final static String API_URL_GROUPS_UPDATE = "/{id}/edit";
		public final static String API_URL_GROUPS_DELETE = "/{id}/delete";
		public final static String API_URL_GROUPS_DETAIL = "/{id}/detail";
		public final static String API_URL_GROUPS_SEARCH_BY_NAME = "/search/{name}";
		public final static String API_URL_GROUPS_DELETE_ALL = "/delete";

	}

	interface Menu {
		public final static String API_URL_MENUS = "/admin/menu";
		public final static String API_URL_LIST_MENUS = "/list";
		public final static String API_URL_MENUS_ADD = "/add";
		public final static String API_URL_MENUS_UPDATE = "/{id}/edit";
		public final static String API_URL_MENUS_DELETE = "/{id}/delete";
		public final static String API_URL_MENUS_DETAIL = "/{id}/detail";
		public final static String API_URL_MENUS_SEARCH_BY_NAME = "/search/{name}";
		public final static String API_URL_MENUS_DELETE_ALL = "/delete";
	}

	interface Answer {
		public final static String API_URL_LIST_ANSWER = "/answer";
		public final static String API_URL_DETAIL_ANSWER = "/answer/{id}";
		public final static String API_URL_ADD_ANSWER = "/answer/add";
		public final static String API_URL_DELETE_ANSWER = "/answer/delete/{answerID}";
		public final static String API_URL_EDIT_ANSWER = "/answer/edit/{answerID}";

	}

	interface AuthRestAPIs {
		public final static String API_URL_START = "/user";
		public final static String API_URL_SIGNUP = "/signup";

	}

	interface Category {
		public final static String API_URL_SUM_CATEGORY = "/category/sum";
		public final static String API_URL_COUNT_CATEGORY = "/category/count-search-category";
		public final static String API_URL_GET_PAGE_CATEGORY = "/category/pagination";
		public final static String API_URL_GET_ALL_CATEGORY = "/category";
		public final static String API_URL_GET_CBYID = "/category/{id}";
		public final static String API_URL_SEARCHBYCONTENT = "/category/search-by-content";
		public final static String API_URL_INSERT = "/category";
		public final static String API_URL_DELETE_CATEGORY = "/category/{id}";
		public final static String API_URL_EDIT_CATEGORY_ID = "/category/{id}";
		public final static String API_URL_EDIT_CATEGORY_EDIT = "/category/editt";
		public final static String API_URL_LIST_CATEGORYS = "/category/listCategories";
		public final static String API_URL_GETONE_CATEGORY = "/{categoryName}";

	}

	interface Level {
		public final static String API_CROSS_ORIGIN = "http://localhost:4200";
		public final static String API_URL_GET_ALL_LEVEL = "/level";
	}

	interface Login {
		public final static String API_CROSS_ORIGIN = "http://localhost:4200";
		public final static String API_URL_lOGIN_START = "/api/auth";
		public final static String API_URL_lOGIN_SIGNIN = "/signin";
		public final static String API_URL_lOGOUT_SUCCESSFUL = "/logoutSuccessful";
	}

	interface Question {
		public final static String API_URL_SUM_QUESTION = "/question/sum";
		public final static String API_URL_COUNT_QUESTION = "/question/count-search-question";
		public final static String API_URL_GET_PAGE_QUESTION = "/question/pagination";
		public final static String API_URL_GET_QBYID = "/question/{id}";
		public final static String API_URL_SEARCH_BYCONTENT = "/question/search-by-content";
		public final static String API_URL_INSERT = "/question";
		public final static String API_URL_EDIT_QUESTION = "/question/edit/{questionID}";
		public final static String API_URL_EDIT_QUESTION1 = "/question/edit";
		public final static String API_URL_READ_EXCEL_FILE = "/question/importlist";
		public final static String API_URL_FILTER_QUESTION = "/question/filterQuestion";
		public final static String API_URL_ADD_QUESTION = "/question/add";
		public final static String API_URL_GET_ALL_QUESTION = "/question/all";
		public final static String API_URL_DELETE_QUESTION = "/question/delete/{questionID}";
		public final static String API_URL_UPDATE_MULTI_QUESTION = "/question/updateMT/{questionID}";
	}

	public interface SemesterExamCode {
		public final static String API_URL_GET_SEMESTER_EXAM_CODE = "/semester-code/{code}";
	}

	public interface SemesterExam {
		public final static String API_URL_SEMESTER_EXAM_START = "/semesterexam";
		public final static String API_URL_FILL_ALL_SEMESTER_EXAM = "/all";
		public final static String API_URL_CREATE_SEMESTER_EXAM = "/add";
		public final static String API_URL_SEARCH_SEMESTER_EXAM = "/search";
		public final static String API_URL_DELETE_SEMESTER_EXAM = "/delete";
		public final static String API_URL_GET_ONE_SEMESTER_EXAM = "/getone/{id}";
		public final static String API_URL_FILTER_SEMESTER_EXAM = "/filter";
		public final static String API_URL_REPORT_SEMESTER_EXAM = "/report/{id}";
		public final static String API_URL_GET_SEMESTER_LIST_BY_USER_ID = "/users/{id}/semesters";
	}

	public interface Tag {
		public final static String API_URL_TAG_LIST = "/tag";
		public final static String API_URL_TAG_INSERT = "/tag/add";
	}

	public interface Test {
		public final static String API_URL_SEMESTER_TEST_START = "/test";
		public final static String API_URL_LIST_TEST = "/listTest";
		public final static String API_URL_LIST_BY_SEMESTER = "/listBySemester/{id}";
		public final static String API_URL_INSERT_SEMESTER = "/add";
		public final static String API_URL_DELETE_SEMESTER = "/delete/{id}";
		public final static String API_URL_GET_TEST_BYID = "/semesters/{semesterId}/tests/{examId}";
		public final static String API_URL_GET_TEST_OF_SEMESTER_OF_USER = "/users/{userId}/semesters/{semesterId}/tests/";

	}

	public interface Testing {
		public final static String API_URL_SUBMIT_RESULT_TEST = "/users/{userId}/tests/{testId}";
		public final static String API_URL_GET_RESULT_TEST = "/users/{userId}/semesters/{semesterId}/result/{examId}";

	}

	public interface Type {
		public final static String API_URL_GET_ALL_TYPE = "/type";
	}

	public interface UploadFile {
		public final static String API_URL_HANDLE_FILE_UPLOAD = "/uploadfile";
		public final static String API_URL_GET_LIST_FILES = "/getallfiles";
		public final static String API_URL_GET_FILE = "/files/{filename:.+}";
	}

	public interface Candidate {
		public final static String API_URL_CANDIDATE_START = "/candidate";
		public final static String API_URL_LIST_CANDIDATE = "/listCandidate";
		public final static String API_URL_LIST_CANDIDATE_ID = "/listCandidate/{id}";
		public final static String API_URL_LIST_BY_CANDIDATE_ID = "/listCandidate/{id}";
		public final static String API_URL_LIST_BY_SEMESTER_ID = "/listBySemester/{id}";
		public final static String API_URL_ADD_CANDIDATE = "/add";
		public final static String API_URL_DELETE_CANDIDATE = "/delete/{id}";
	}

	interface Lesson {
		public final static String API_URL_LESSONS = "/lesson";
		public final static String API_URL_LIST_LESSONS = "/{chapterId}/list";
		public final static String API_URL_LESSONS_ADD = "/{chapterId}/add";
		public final static String API_URL_LESSONS_UPDATE = "/{chapterId}/{lessonId}/edit";
		public final static String API_URL_LESSONS_DELETE = "/{lessonId}/delete";
		public final static String API_URL_LESSONS_INFOR = "/{chapterId}/{lessonId}/infor";
		public final static String API_URL_LESSONS_SEARCH_BY_TAGS = "/search/{keyword}";
	}
	
	interface CourseCatalog {
		public final static String API_URL_COURSECATALOGS = "/admin/courseCatalog";
		public final static String API_URL_LIST_COURSECATALOGS = "/list";
		public final static String API_URL_COURSECATALOGS_ADD = "/add";
		public final static String API_URL_COURSECATALOGS_UPDATE = "/{id}/edit";
		public final static String API_URL_COURSECATALOGS_DELETE = "/{id}/delete";
		public final static String API_URL_COURSECATALOGS_DETAIL = "/{id}/detail";
		public final static String API_URL_COURSECATALOGS_SEARCH_BY_NAME = "/search/{name}";
		public final static String API_URL_COURSECATALOGS_DELETE_ALL = "/delete";
	}


	interface Chapter {
		public final static String API_URL_CHAPTERS = "/chapter";
		public final static String API_URL_LIST_CHAPTERS = "/{courseId}/list";
		public final static String API_URL_CHAPTERS_ADD = "/{courseId}/add";
		public final static String API_URL_CHAPTERS_UPDATE = "/{courseId}/{chapterId}/edit";
		public final static String API_URL_CHAPTERS_DELETE = "/{courseId}/{chapterId}/delete";
		public final static String API_URL_CHAPTERS_INFOR = "/{courseId}/{chapterId}/infor";
		public final static String API_URL_CHAPTERS_SEARCH_BY_TAGS = "/{courseId}/search/{keyword}";
	} 
}
