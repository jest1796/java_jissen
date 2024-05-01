package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	//**全データ取得**//
	public List<User> selectAll(){
		return dao.selectAll();	
	}
	
	//**1件登録**//
	public boolean insertOne(User user) {
		int rowNumber = dao.insertOne(user);
		
		//**判定用変数**//
		boolean result = false;
		if (rowNumber > 0) {
			//**insert成功**//
			result = true;
		}
		
		return result;
	}
	
	//**1件取得**//
	public User selectOne(Integer id) {
		return dao.selectOne(id);
		
	}
}
