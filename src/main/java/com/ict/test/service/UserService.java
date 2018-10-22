package com.ict.test.service;

import java.util.List;

import com.ict.test.vo.UserInfo;

public interface UserService {

	public List<UserInfo> selectList(UserInfo ui);
	public UserInfo selectUser(UserInfo ui);
	public Integer insertUser(UserInfo ui);
	public Integer updateUser(UserInfo ui);
	public Integer deleteUser(UserInfo ui);
}
