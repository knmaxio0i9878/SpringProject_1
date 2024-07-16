package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomBean;
import com.bean.EcomCartBean;
import com.dao.EcomCartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	EcomCartDao cdao;
	
	@GetMapping("addtocart")
	public String addtocart(@RequestParam("productId") Integer productId,HttpSession session) {
		EcomBean ebean = (EcomBean)session.getAttribute("user");
		String userId = ebean.getId();
		EcomCartBean cbean= new EcomCartBean();
		cbean.setProductId(productId);
		cbean.setUserId(userId);
		cdao.addToCart(cbean);
		
		return "redirect:/list";
	}
}
