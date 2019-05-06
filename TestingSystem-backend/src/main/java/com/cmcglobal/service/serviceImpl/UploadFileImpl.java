package com.cmcglobal.service.serviceImpl;

import com.cmcglobal.service.UploadFileService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileImpl implements UploadFileService {
	private final Path rootLocation = Paths.get("files");

	@Autowired
	private ServletContext servletContext;

	@Async
	@Override
	public String saveFile(MultipartFile file) {
		try {
			File files = new File(rootLocation + "/" + file.getOriginalFilename());
			if (files.exists())
				return "Success";
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			return "Success";
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	@Override
	public String saveFileVer(MultipartFile file, String pathSave) {
		String pathToSave = servletContext.getRealPath(pathSave);
		File fileTranfer = new File(pathToSave + "/" + file.getOriginalFilename());
		try {
			// transfer the received file to the given destination file
			file.transferTo(fileTranfer);
		} catch (IllegalStateException e) {
		} catch (IOException e) {
		}
		return file.getOriginalFilename();
	}

	@Override
	public Resource findFileByName(String nameFile) {
		// TODO Auto-generated method stub
		try {
			Path filePath = this.rootLocation.resolve(nameFile).normalize();
			Resource resource = (Resource) new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public String getPathFile(MultipartFile file) {
		File filePath = new File("files");
		String pathToSave = filePath.getAbsolutePath();
		System.out.println(pathToSave);

		File fileTranfer = new File(pathToSave + "/" + file.getOriginalFilename());
		// try {
		// file.transferTo(fileTranfer);
		// } catch (IllegalStateException e) {
		// return null;
		// } catch (IOException e) {
		// return null;
		// }
		System.out.println(file.getOriginalFilename());
		return fileTranfer.toString();
	}

	@Override
	public boolean checkExtension(MultipartFile file) {
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if (!(("xlsx".equals(extension)) || ("xls".equals(extension)))) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.UploadFileService#loadFile(java.lang.String)
	 * Author: Sanero.
	 * 
	 * @param filename - filename. Created date: Feb 23, 2019 Created time: 6:36:52
	 * PM
	 */
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	@Override
	public String uploadFile(MultipartFile file) {
		File uploadedFile = new File(rootLocation + "/" + file.getOriginalFilename());

		try {
			uploadedFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
			return "Sucssec";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
