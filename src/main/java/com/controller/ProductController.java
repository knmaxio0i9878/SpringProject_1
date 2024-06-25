package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ProductBean;
import com.dao.ProductDao;

@Controller
public class ProductController {
	
	
	
	@Autowired
	ProductDao pdao;

	@GetMapping("/getproduct")
	public String getProduct() {
		
		return "EcomProduct";
	}
	@GetMapping("/products")
	public String Products(Model model) {
		
		List<ProductBean> product = pdao.getAllProduct();
		model.addAttribute("product", product);
		return "EcomDetails";
	}
	
	
	@PostMapping("/saveproduct")
	public String addProduct(ProductBean pbean,Model model) {
		pdao.addProduct(pbean);
		
		return "redirect:/EcomDetalis";
	}
	
	@Autowired
	JdbcTemplate stmt;
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") Integer id) {
		System.out.println("DeletedId:=	"+id);	
		pdao.deleteProduct(id);
			
		return "redirect:/products";
	}
	
	@GetMapping("/name")
	public String nameDeleteGet() {
		return "DeleteByNameProduct";
	}
	
	@PostMapping("/namedelete")
	public String deleteName(ProductBean pbean) {
		
		System.out.println("Delete Named Product:-"+pbean.getProductName());
		
		
		
		pdao.deleteProductName(pbean.getProductName());
		
		return "redirect:/products";
	}
	
}
