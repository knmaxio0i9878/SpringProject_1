package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AddtionBean;
import com.bean.UserBean;


@Controller
public class SessionController {

	
	@GetMapping("/login")
	public String login(){
																													
		return "Login";
	}
	
	@GetMapping("/signup")
	public String signup(){
		
		return "Signup";
	}
	
	@GetMapping("/fp")
	public String forgotPassword(){
		
		return "ForgotPassword";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(UserBean ubean,Model model){
		
		System.out.println("Name:"+ubean.getFirstname());
		System.out.println("Email:"+ubean.getEmail());
		System.out.println("Password:"+ubean.getPassword());
		
		model.addAttribute("user",ubean);
		
		return "Home";
	}
	
	@GetMapping("/add")
		public String AddNumbers(){
		return "Addition";
	}
	
	@PostMapping("/ans")
	public String Add(AddtionBean abean,Model model) {
		
		System.out.println("no1:"+abean.getNo1());
		System.out.println("no2:"+abean.getNo2());
		
		model.addAttribute("nos", abean);
		
		return "Ans";
	}
	
}


