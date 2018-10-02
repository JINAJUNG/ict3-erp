package com.ict.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.test.dao.LevelDAO;
import com.ict.test.vo.LevelInfo;

@Repository
public class LevelDAOImpl implements LevelDAO{

	@Autowired
	private SqlSessionTemplate sst;
	
	@Override
	public List<LevelInfo> selectLevel() {
		LevelInfo li = new LevelInfo();
		return sst.selectList("SQL.LEVELINFO.selectLevelInfo", li);
	}

}
