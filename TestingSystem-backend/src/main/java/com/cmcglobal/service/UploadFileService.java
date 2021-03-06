package com.cmcglobal.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
	public String saveFile(MultipartFile file);

	Resource findFileByName(String nameFile);

	public String saveFileVer(MultipartFile file, String pathToSave);

	String getPathFile(MultipartFile file);

	boolean checkExtension(MultipartFile file);

	public Resource loadFile(String filename);
	
	String uploadFile(MultipartFile file);
}
