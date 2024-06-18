package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.ProductBean;
import com.dao.ProductDao;

@Controller
public class ProductController {

	@GetMapping("/getproduct")
	public String getProduct() {
		
		return "EcomProduct";
	}
	
	@Autowired
	ProductDao pdao;
	
	@PostMapping("/saveproduct")
	public String addProduct(ProductBean pbean) {

		System.out.println("Product-Name:"+pbean.getProductName());
		
		pdao.addProduct(pbean);
		
		return "EcomHome";
	}
}
