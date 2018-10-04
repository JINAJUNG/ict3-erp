package com.ict.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.test.service.LevelService;
import com.ict.test.vo.LevelInfo;

@Controller
public class LevelInfoController {
	
	@Autowired
	private LevelService ls;
	
	@RequestMapping(value="/levelList",method=RequestMethod.GET)
	public String selectLevel(Model m, @ModelAttribute LevelInfo li ) {/*HttpServletRequest request, @RequestParam Map<String,String> map,@RequestParam("lilevel") Integer lilevel (request,map,단일로 getparam받아오는 방법)*/
		m.addAttribute("list", ls.getLevelList(li));
		return "level/list";
	}

	@RequestMapping(value="/levelList2",method=RequestMethod.GET)
	public ModelAndView selectLevel2(ModelAndView mav, @ModelAttribute LevelInfo li ) {
		mav.setViewName("level/list");
		mav.addObject("list",ls.getLevelList(li));
		return mav;
	}
	
	@RequestMapping(value="/levelview",method=RequestMethod.GET)
	public String viewLevel(Model m, @ModelAttribute LevelInfo li ) {/*HttpServletRequest request, @RequestParam Map<String,String> map,@RequestParam("lilevel") Integer lilevel (request,map,단일로 getparam받아오는 방법)*/
		m.addAttribute("list", ls.getLevel(li));
		return "level/levelview";
	} 
	
	@RequestMapping(value="/levelIn",method=RequestMethod.POST)
	public ModelAndView insertLevel(ModelAndView mav, @ModelAttribute LevelInfo li ) {
		mav.setViewName("level/insert");
		mav.addObject("map",ls.insertLevel(li));
		return mav;
	}
	
	
}
