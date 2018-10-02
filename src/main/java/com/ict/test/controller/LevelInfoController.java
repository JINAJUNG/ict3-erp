package com.ict.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ict.test.service.LevelService;

@Controller
public class LevelInfoController {
	
	@Autowired
	private LevelService ls;
	
	@RequestMapping(value="/levelList",method=RequestMethod.GET)
	public String selectLevel(Model m) {
		System.out.println(ls.getLevelList());
		m.addAttribute("list", ls.getLevelList());
		return "level/list";
	}
}
