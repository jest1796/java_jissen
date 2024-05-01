package com.example.demo.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.repository.UserDao;

@Repository("UserDaoJdbc")
public class UserDaoJdbc implements UserDao{
	
	@Autowired
	JdbcTemplate jdbc;

	//**usersテーブルの全データを取得**//
	@Override
	public List<User> selectAll() {
		List<Map<String,Object>> getList = jdbc.queryForList("select * from users");
		List<User> usersList = new ArrayList<>();
		
		//**取得したデータを結果返却用Listに収納していく**//
		for (Map<String,Object> map : getList) {
			//**User型インスタンスの生成**//
			User user = new User();
			
			user.setId((Integer) map.get("id"));
			user.setUserName((String) map.get("name"));
			user.setMail((String) map.get("mail"));
			user.setAge((Integer) map.get("age"));
			
			usersList.add(user);
		}
		return usersList;
	}

	//**userテーブルに一件登録**//
	@Override
	public int insertOne(User user) {
		int rowNumber = jdbc.update(
				"insert into users(id," + "name," + "mail," + "age)"
						+ "values(?,?,?,?)",
				user.getId(),user.getUserName(),user.getMail(),user.getAge()	
				);
		return rowNumber;
	}

	//**DBからユーザデータを１件取得**//
	@Override
	public User selectOne(Integer id) {
		Map<String,Object> map = jdbc.queryForMap("select * from users " + 
				"where id = ?",id);
		//**取得したデータをUser型に入れる**//
		User user = new User();
		user.setId((Integer)map.get("id"));
		user.setUserName((String)map.get("name"));
		user.setMail((String)map.get("mail"));
		user.setAge((Integer)map.get("age"));
		
		return user;
	}
	@Override
	public int updateOne(User user) {
		
		return 0;
	}

	

}
