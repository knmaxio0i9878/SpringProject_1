package com.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProductBean;

@Service
public class ProductFileUpload {

	
	public void fileUpload(MultipartFile masterImage) {
		String path = "C:\\PARTH\\Spring\\SpringProject_1\\src\\main\\webapp\\productimage";
		try {
			byte b[] = masterImage.getBytes();
			File file = new File(path,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, b);
			file.createNewFile();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fileUploadUser(MultipartFile profileImage,String email) {
		String path = "C:\\PARTH\\Spring\\SpringProject_1\\src\\main\\webapp\\ecomuserimage";
		try {
			File dir = new File(path,email);
			dir.mkdir();
			
			byte b[] = profileImage.getBytes();
			File file = new File(dir,profileImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, b);
			file.createNewFile();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
