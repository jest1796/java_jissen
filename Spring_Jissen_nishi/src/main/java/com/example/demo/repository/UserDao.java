package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.User;

public interface UserDao {
	//**登録データ一覧取得**//
	public List<User> selectAll();
	
	//**データ1件新規登録**//
	public int insertOne(User user);
	
	//**登録データ1件取得**//
	public User selectOne(Integer id);
	
	//**データ１件更新**//
	public int updateOne(User user);
	
}
