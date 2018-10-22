package com.ict.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.test.dao.UserDAO;
import com.ict.test.vo.UserInfo;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SqlSession ss;
	
	@Override
	public List<UserInfo> getList(UserInfo ui) {
		// TODO Auto-generated method stub
		return ss.selectList("SQL.USERINFO.selectUser", ui);
	}

	@Override
	public UserInfo getUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return ss.selectOne("SQL.USERINFO.selectUser", ui);
	}

	@Override
	public Integer insertUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return ss.insert("SQL.USERINFO.inserUser", ui);
	}

	@Override
	public Integer updateUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return ss.update("SQL.USERINFO.updateUser",ui);
	}

	@Override
	public Integer deleteUser(UserInfo ui) {
		// TODO Auto-generated method stub
		return ss.delete("SQL.USERINFO.deleteUser",ui);
	}

}
