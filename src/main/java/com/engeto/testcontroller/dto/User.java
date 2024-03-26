package com.engeto.testcontroller.dto;

public class User {

	private String name;
	private String lastName;
	private Long userId;
	private String nickname;

	public User() {
	}

	public User(String name, String lastName, Long userId, String nickname) {
		this.name = name;
		this.lastName = lastName;
		this.userId = userId;
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
