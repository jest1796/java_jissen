package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class IndexController {

	@Autowired
	UserService userService;
	User user;
	
	//一覧画面表示//
	@GetMapping("/index")
	public String selectAll(Model model){
		//データ一覧取得//
		List<User> usersList= userService.selectAll();  
		
		model.addAttribute("usersList",usersList);
		
		return "index";
		
	}
}
