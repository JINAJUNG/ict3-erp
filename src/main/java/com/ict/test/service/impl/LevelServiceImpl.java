package com.ict.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.test.dao.LevelDAO;
import com.ict.test.service.LevelService;
import com.ict.test.vo.LevelInfo;

@Service
public class LevelServiceImpl implements LevelService{

	@Autowired
	private LevelDAO ldao;
	
	@Override
	public List<LevelInfo> getLevelList(LevelInfo li) {
	
		return ldao.selectLevelList(li);
	}

	@Override
	public Integer insertLevel(LevelInfo li) {
		return ldao.insertLevel(li);
	}

	@Override
	public LevelInfo getLevel(Integer linum) {
		return ldao.selectLevel(linum);
	}

	@Override
	public Integer updateLevel(LevelInfo li) {
		return ldao.updateLevel(li);
	}

	@Override
	public Integer deleteLevel(Integer linum) {
		return ldao.deleteLevel(linum);
	}

	@Override
	public Integer selectlinum() {
		return ldao.selectlinum();
	}

}
