package com.ict.test.service.impl;

import java.util.List;

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
	public List<LevelInfo> getLevelList() {
		
		return ldao.selectLevel();
	}

}
