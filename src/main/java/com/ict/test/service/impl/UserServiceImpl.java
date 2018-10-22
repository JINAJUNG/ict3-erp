package com.ict.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.test.dao.UserDAO;
import com.ict.test.service.UserService;
import com.ict.test.vo.UserInfo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO udao;
	
	@Override
	public List<UserInfo> selectList(UserInfo ui) {
		
		return udao.getList(ui);
	}

	@Override
	public UserInfo selectUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return udao.getUser(ui);
	}

	@Override
	public Integer insertUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return udao.insertUser(ui);
	}

	@Override
	public Integer updateUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return udao.updateUser(ui);
	}

	@Override
	public Integer deleteUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return udao.deleteUser(ui);
	}

}
