package com.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProductBean;

@Service
public class ProductFileUpload {

	
	public void fileUpload(MultipartFile masterImage) {
		String path = "C:\\PARTH\\Spring\\ProductsImage";
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
}
