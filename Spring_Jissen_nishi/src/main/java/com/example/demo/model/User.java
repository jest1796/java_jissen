package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
	private int id;
	
	@NotBlank(message = "名前が未記入です")
	private String userName;
	
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスを入力してください")
	private String mail;
	
	@Min(0)
	@Max(120)
	@NotNull(message = "年齢を入力してください")
	private Integer age;
}
