package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.UserService;

@Controller
public class DeleteController {

	@Autowired
	UserService userService;
	
	@GetMapping("/delete/{id}")
	public String deleteOne(@PathVariable("id") Integer id) {
		
		//データ削除実行//
		userService.deleteOne(id);
		
		//一覧画面へ//
		return "redirect:/index";
		
	}
}
