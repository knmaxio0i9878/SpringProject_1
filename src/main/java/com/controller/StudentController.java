package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.BoxBean;

@Controller
public class StudentController {

	@GetMapping("/boxreg")
	public String boxRegistration() {
		return "BoxCricketReg";
	}
	
	@PostMapping("/savereg")
	public String saveRegistration(BoxBean bbean,Model model) {
		
		System.out.println("Name:"+bbean.getName());
		System.out.println("PlayerType:"+bbean.getPlayertype());
		System.out.println("FoodType:"+bbean.getFoodtype());
		System.out.println("ColdDrink:"+bbean.getColddrink());
		
		boolean isError=false;
		String alphaRegex = "[A-za-z]+";
		
		if(bbean.getName() == null || bbean.getName().trim().length() == 0) {
			
			isError=true;
			model.addAttribute("nameError","Please Enter Name !");
			
		}
		else if(bbean.getName().matches(alphaRegex) == false){
			model.addAttribute("nameError","Please Enter Valid Student Name !");
		}
		else {
			model.addAttribute("nameValue",bbean.getName());
		}
		
		
		if(bbean.getPlayertype() == null ) {
			isError=true;
			model.addAttribute("playerError","Please Select Playing Type !");
		}
		else {
			model.addAttribute("playerValue",bbean.getPlayertype());
		}
		
		if(bbean.getFoodtype().equals("-1")) {
			isError=true;
			model.addAttribute("foodError","Please Select FoodType !");
		}
		else {
			model.addAttribute("foodValue",bbean.getFoodtype());
		}
		
		
		
		if(bbean.getColddrink() == null ) {
			isError=true;
			model.addAttribute("drinkError","Please Select your Drink !");
		}
		else {
			model.addAttribute("drinkValue",bbean.getColddrink());
		}
		
		if(isError) {
			return "BoxCricketReg";
		}
		else {			
			model.addAttribute("box", bbean);
			return "Home";
		}
	}
}
