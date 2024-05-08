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

	//usersテーブルの全データを取得//
	@Override
	public List<User> selectAll() {
		//DBから全データ取得実行//
		List<Map<String,Object>> getList = jdbc.queryForList("select * from users");
		
		//返却用のUser型のリスト作成//
		List<User> usersList = new ArrayList<>();
		
		//取得したデータを結果返却用Listに収納していく//
		for (Map<String,Object> map : getList) {
			//**取得したデータをUser型に入れる**//
			User user = new User();
			user.setId((Integer) map.get("id"));
			user.setUserName((String) map.get("name"));
			user.setMail((String) map.get("mail"));
			user.setAge((Integer) map.get("age"));
			
			usersList.add(user);
		}
		//User型リストを返す//
		return usersList;
	}

	//**userテーブルに一件登録**//
	@Override
	public int insertOne(User user) {
		//DBに１件登録処理実行//
		int rowNumber = jdbc.update(
				"insert into users(id," + "name," + "mail," + "age)"
						+ "values(?,?,?,?)",
				user.getId(),user.getUserName(),user.getMail(),user.getAge()	
				);
		return rowNumber;
	}

	//DBからユーザデータを１件取得//
	@Override
	public User selectOne(Integer id) {
		Map<String,Object> map = jdbc.queryForMap("select * from users " + 
				"where id = ?",id);
		//取得したデータをUser型に入れる//
		User user = new User();
		user.setId((Integer)map.get("id"));
		user.setUserName((String)map.get("name"));
		user.setMail((String)map.get("mail"));
		user.setAge((Integer)map.get("age"));
		
		//１件取得データ返却//
		return user;
	}
	
	//DBのデータを1件更新//
	@Override
	public int updateOne(User user) {
		int rowNumber = jdbc.update(
				"update users" + " set" + " name = ?," + "mail = ?," + "age = ?" +
				" where id = ?",
					user.getUserName(),user.getMail(),user.getAge(),user.getId());
		return rowNumber;
	}

	//DBのデータを１件削除//
	@Override
	public int deleteOne(Integer id) {
		int rowNumber = jdbc.update(
				"delete from users where id = ?",id);
		return rowNumber;
	}

}
