package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomBean;
import com.bean.EcomCartBean;
import com.bean.ProductBean;
import com.dao.EcomCartDao;
import com.dao.ProductDao;

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

	@Autowired
	EcomCartDao ecdao;

	@Autowired
	ProductDao pdao;
	


	
	@GetMapping("yourcart")
	public String yourCart(HttpSession session,Model model,EcomCartBean ecbean) {

		EcomBean ebean = (EcomBean)session.getAttribute("user");
		
		if(ebean!=null) {
			String userId = ebean.getId();
			System.out.println(userId);
			List<ProductBean> product = ecdao.yourCart(userId);
			model.addAttribute("product", product);
			model.addAttribute("cart", ecbean);
			return "Cart";
		}
		else {
			return	"redirect:/";
		}
	}
	
	@GetMapping("/removecart")
	public String removeCart(@RequestParam("productId") Integer productId) { 
		ecdao.removeFromCart(productId);
		return "redirect:/yourcart";
	}
	
	
}
