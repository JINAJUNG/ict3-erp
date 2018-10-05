package com.ict.test.dao;

import java.util.List;

import com.ict.test.vo.LevelInfo;

public interface LevelDAO {
	public List<LevelInfo> selectLevelList(LevelInfo li);
	public int insertLevel(LevelInfo li);
	public LevelInfo selectLevel(Integer linum);
	public Integer updateLevel(LevelInfo li);
	public Integer deleteLevel(Integer linum);
}
