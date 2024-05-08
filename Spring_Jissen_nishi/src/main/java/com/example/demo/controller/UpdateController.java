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
	User user;
	
	//更新画面の表示//
	@GetMapping("/update/{id}")
	public String getUpdate(@PathVariable("id") Integer id,User user,Model model
			) {
		//更新するユーザデータをDBから取得//
		User editUser = userService.selectOne(id);
		
		model.addAttribute("user",editUser);
		return "update";
	}
	
	//更新処理//
	@PostMapping("/update")
	public String postUpdate( Integer id,Model model, @ModelAttribute @Validated User user,
			BindingResult bindingresult) {
		
		//入力エラーのチェック//
		if (bindingresult.hasErrors()) {
			return "update";
		}
		
		//更新処理成否の変数//
		String result;
		
		if (userService.updateOne(user)) {
			result = "更新しました";
		}else {
			result = "更新に失敗しました";
		}
		
		model.addAttribute("result",result);
		return "update";
		
	}
	
}
