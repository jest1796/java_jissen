package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UpdateController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/update/{id}")
	public String getUpdate(@PathVariable("id") Integer id,Model model,
			User user) {
		//**更新するユーザデータをDBから取得**//
		User editUser = userService.selectOne(id);
		model.addAttribute("user",editUser);
		return "update";
	}
	
	@PostMapping("/update")
	public String postUpdate(Model model,@Validated @ModelAttribute User user,
			BindingResult bindingresult) {
		
//		if (bindingresult.hasErrors()) {
//			return getUpdate(user, model);
//		}
		
		return "update";
		
	}
	
}
