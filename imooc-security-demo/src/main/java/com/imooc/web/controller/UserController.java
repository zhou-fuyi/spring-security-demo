package com.imooc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult errors) {
		if(errors.hasErrors()) {
			errors.getAllErrors().forEach(err -> System.out.println(err.getDefaultMessage()));
		}
		user.setId("1");
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		return user;
	}

	@JsonView(User.UserSimpleView.class)
	@GetMapping
	@ApiOperation(value = "用户列表查询")
	public List<User> query(@RequestParam(defaultValue = "jojo", required = false) String username){
		System.out.println(username);
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		System.out.println(users);
//		throw new RuntimeException("000");
		return users;
	}
	
	//正则, 限制只能是数字
	@JsonView(User.UserDetailView.class)
	@GetMapping("/{id:\\d+}")
	public User queryUserById(@ApiParam(value = "用户Id") @PathVariable String id) {
		System.out.println("进入GetInfo服务");
		User user = new User();
		user.setUsername("tom");
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		return user;
	}
	
	@PutMapping("/{id:\\d+}")
	public User updateUserById(@Valid @RequestBody User user, BindingResult errors) {
		user.setId("1");
		if(errors.hasErrors()) {
			
			errors.getAllErrors().forEach(err -> {
				//处理打印消息
//				System.out.println(((FieldError)err).getField() + " " + err.getDefaultMessage() );
				System.out.println(err.getDefaultMessage());
			});
		}
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		return user;
	}
	
}
