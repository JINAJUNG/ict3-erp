package com.ict.test.dao;

import java.util.List;

import com.ict.test.vo.LevelInfo;

public interface LevelDAO {
	public List<LevelInfo> selectLevelList(LevelInfo li);
	public int insertLevel(LevelInfo li);
	public LevelInfo selectLevel(LevelInfo li);
}
