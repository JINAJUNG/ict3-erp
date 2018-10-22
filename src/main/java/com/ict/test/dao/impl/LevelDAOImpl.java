package com.ict.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.test.dao.LevelDAO;
import com.ict.test.vo.LevelInfo;

@Repository
public class LevelDAOImpl implements LevelDAO{

	@Autowired
	private SqlSession sst;

	@Override
	public List<LevelInfo> selectLevelList(LevelInfo li) {
		return sst.selectList("SQL.LEVELINFO.selectLevelInfo", li);
	}

	@Override
	public int insertLevel(LevelInfo li) {
		return sst.insert("SQL.LEVELINFO.insertLevelInfo", li);
	}

	@Override
	public LevelInfo selectLevel(Integer linum) {
		LevelInfo l = new LevelInfo();
		l.setLinum(linum);
		return sst.selectOne("SQL.LEVELINFO.selectLevelInfo", l);
	}

	@Override
	public Integer updateLevel(LevelInfo li) {
		return sst.update("SQL.LEVELINFO.updateLevelInfo", li);
	}

	@Override
	public Integer deleteLevel(Integer linum) {
		LevelInfo l = new LevelInfo();
		l.setLinum(linum);
		return sst.delete("SQL.LEVELINFO.deleteLevelInfo",linum);
	}

}
