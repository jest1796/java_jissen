package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;



@Controller
public class RegistController {
	
	@Autowired
	UserService userService;
	User user;
	
	@GetMapping("/regist")
	public String getRegist(User user,Model model) {
		
		return "regist";
		
	}
	
	@PostMapping("/regist")
	public String postRegist(Model model,@Validated @ModelAttribute User user,
			BindingResult bindingresult) {
		
		if (bindingresult.hasErrors()) {
			return getRegist(user, model);
		}
		
		String result;
		if (userService.insertOne(user)) {
			result = "登録が完了しました";
		} else {
			result ="登録が失敗しました";
		}
		
		model.addAttribute("result", result);
		
		return "regist";
		
	}
}
