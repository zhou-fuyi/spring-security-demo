package com.imooc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;

import io.swagger.annotations.ApiModelProperty;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public interface UserSimpleView{};//自定义返回视图
	
	public interface UserDetailView extends UserSimpleView{};
	
	private String id; 
	@MyConstraint(message = "这是一个测试")
	private String username;
	@NotBlank(message = "密码不能为空")
	private String password;
	@ApiModelProperty(value = "用户年龄")
	@Past(message = "生日必须是过去的时间")
	private Date birthday;
	
	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
