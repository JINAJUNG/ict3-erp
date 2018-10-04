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
	public Map<String,Object> insertLevel(LevelInfo li) {
		int cnt =ldao.insertLevel(li);
		Map<String, Object> map = new HashMap<>();
		map.put("cnt", cnt);
		map.put("msg", "fail");
		if(cnt==1) {
			map.put("msg","success");
		}
		return map;
	}

	@Override
	public LevelInfo getLevel(LevelInfo li) {
		return ldao.selectLevel(li);
	}

}
