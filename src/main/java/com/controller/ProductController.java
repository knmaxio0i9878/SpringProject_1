package com.controller;

import java.io.File;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProductBean;
import com.dao.ProductDao;
import com.service.ProductFileUpload;

import ch.qos.logback.core.util.FileUtil;

@Controller
public class ProductController {

	@Autowired
	ProductDao pdao;

	@Autowired
	ProductFileUpload pupload;

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
	public String addProduct(ProductBean pbean, Model model) {

		pbean.setProductimgpath("productimage\\"+pbean.getMasterImage().getOriginalFilename());

		System.out.println("MasterImageName :-" + pbean.getMasterImage().getOriginalFilename());

		pupload.fileUpload(pbean.getMasterImage());
		pdao.addProduct(pbean);

		return "redirect:/products";
	}

	@Autowired
	JdbcTemplate stmt;

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") Integer id) {
		System.out.println("DeletedId:=	" + id);
		pdao.deleteProduct(id);

		return "redirect:/products";
	}

	@GetMapping("/name")
	public String nameDeleteGet() {
		return "DeleteByNameProduct";
	}

	@PostMapping("/namedelete")
	public String deleteName(ProductBean pbean) {
		System.out.println("Delete Named Product:-" + pbean.getProductName());
		pdao.deleteProductName(pbean.getProductName());
		return "redirect:/products";
	}

	@GetMapping("/getdetails")
	public String getDetails(@RequestParam("productId") Integer productId, Model model) {
		ProductBean pbean = pdao.getSingleProductName(productId);
		model.addAttribute("singleProduct", pbean);
		return "EcomGetDetails";
	}
	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId, Model model) {
		ProductBean pbean = pdao.getSingleProductName(productId);
		model.addAttribute("singleProduct", pbean);
		return "EcomGetDetails";
	}
	
	

	@GetMapping("/list")
	public String listProducts(Model model) {
		List<ProductBean> product = pdao.getAllProduct();
		model.addAttribute("product", product);
		return "ListinngProducts";
	}

	
}
