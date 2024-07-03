package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomBean;
import com.dao.Ecommerce;

@Controller
public class EcommerceController {
	
	@Autowired 
	Ecommerce edao;
	
	@GetMapping("/ecom")
	public String getEcomLogin() {
		return "EcomLogin";
	}
	
	@PostMapping("/ecomlogin")
	public String insertIntoDb(EcomBean ebean,Model model) {
		
		edao.insert(ebean);
		return "EcomHome";
	}
}
