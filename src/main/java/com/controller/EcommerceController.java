package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomBean;
import com.bean.UserBean;
import com.dao.EcomUserDao;
import com.dao.Ecommerce;
import com.service.ProductFileUpload;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcommerceController {
	
	@Autowired 
	Ecommerce edao;
	
	@Autowired
	EcomUserDao eudao;
	
	@Autowired
	ProductFileUpload pupload;
	
	@GetMapping("/ecom")
	public String getEcomSignup() {
		return "EcomSignup";
	}
	
	@PostMapping("/ecomsignup")
	public String insertIntoDb(EcomBean ebean,Model model) {
				
		ebean.setImagePath("ecomuserimage//" + ebean.getEmail() + 
				"//" + ebean.getProfileImage().getOriginalFilename());
		
		System.out.println("Imagename: "+ ebean.getProfileImage().getOriginalFilename());
		
		pupload.fileUploadUser(ebean.getProfileImage(),ebean.getEmail());
	
		edao.insert(ebean);
		return "EcomHome";
	}
	
	@GetMapping("/ecomlogin")
	public String getLogin() {
		return "EcomLogin"; 
	}
	@PostMapping("elogin")
	public String elogin(EcomBean ebean,Model model,HttpSession session) {
		
		EcomBean dbuser = eudao.authenticate(ebean.getEmail(), ebean.getPassword()); 
		if(dbuser == null) {
			model.addAttribute("error","Invalid Credentials");
			return "EcomLogin";
		}
		else {
			session.setAttribute("user",dbuser);
			model.addAttribute("firstname",dbuser.getFirstname());
			model.addAttribute("image",dbuser.getProfilepic());
			return "EcomHome"; 
		}
	}
}
