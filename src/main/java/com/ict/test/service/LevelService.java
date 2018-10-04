package com.ict.test.service;

import java.util.List;
import java.util.Map;

import com.ict.test.vo.LevelInfo;

public interface LevelService {

	public List<LevelInfo> getLevelList(LevelInfo li);
	public LevelInfo getLevel(LevelInfo li);
	public Map<String,Object> insertLevel(LevelInfo li);
}
