package com.ict.test.dao.impl;

import java.util.List;

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
	public List<LevelInfo> selectLevelList(LevelInfo li) {
		return sst.selectList("SQL.LEVELINFO.selectLevelInfo", li);
	}

	@Override
	public int insertLevel(LevelInfo li) {
		return sst.insert("SQL.LEVELINFO.insertLevelInfo", li);
	}

	@Override
	public LevelInfo selectLevel(LevelInfo li) {
		return sst.selectOne("SQL.LEVELINFO.selectLevelInfo", li);
	}

}
