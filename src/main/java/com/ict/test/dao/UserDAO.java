package com.ict.test.dao;

import java.util.List;

import com.ict.test.vo.UserInfo;

public interface UserDAO {

	public List<UserInfo> getList(UserInfo ui);
	public UserInfo getUser(UserInfo ui);
	public Integer insertUser(UserInfo ui);
	public Integer updateUser(UserInfo ui);
	public Integer deleteUser(UserInfo ui);
}
