package com.ict.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ict.test.service.LevelService;
import com.ict.test.vo.LevelInfo;

@Controller
public class LevelInfoController {
	
	@Autowired
	private LevelService ls;
	
	@RequestMapping(value="/linum", method=RequestMethod.GET)
	public @ResponseBody Integer getLinum(){ //무조건 {} url path에 대한 valriable
		return ls.selectlinum();
	}
	
	@RequestMapping(value="/levelList", method=RequestMethod.GET) //method와 1:1맵핑  value는 같아도 되는데 method 까지 같은게 두개가 되면 err
	public @ResponseBody List<LevelInfo> getLevelList(@ModelAttribute LevelInfo li){//form data방식이어야함
		System.out.println(ls.getLevelList(li));
		return ls.getLevelList(li);
	}
	
	@RequestMapping(value="/levelList/{linum}", method=RequestMethod.GET)
	public @ResponseBody LevelInfo getLevel(@PathVariable Integer linum){ //무조건 {} url path에 대한 valriable
		return ls.getLevel(linum);
	}
	
	@RequestMapping(value="/levelList", method=RequestMethod.POST)
	@ResponseBody //forwoerd와 비슷한 역할을 하는 것 spring은 viewresolver가 그역할을 한다
	//jackson이 없으면 return type이 String이 아닌면 err
	public Integer insertLevel(@RequestBody LevelInfo li){ //json과 xml이 아니면 파싱 불가
		return ls.insertLevel(li);
	}

	@RequestMapping(value="/levelList/{linum}", method=RequestMethod.PUT)
	@ResponseBody 
	public Integer updateLevel(/*@RequestBody */@ModelAttribute LevelInfo li, @PathVariable Integer linum){
		li.setLinum(linum);
		return ls.updateLevel(li);
	}
	
	@RequestMapping(value="/levelList/{linum}", method=RequestMethod.DELETE)
	@ResponseBody 
	public Integer deleteLevel(@PathVariable Integer linum){
		return ls.deleteLevel(linum);
	}
	
	
	
	
/*	@RequestMapping(value="/levelList",method=RequestMethod.GET)
	public String selectLevel(Model m, @ModelAttribute LevelInfo li ) {HttpServletRequest request, @RequestParam Map<String,String> map,@RequestParam("lilevel") Integer lilevel (request,map,단일로 getparam받아오는 방법)
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
	public String viewLevel(Model m, @ModelAttribute LevelInfo li ) {HttpServletRequest request, @RequestParam Map<String,String> map,@RequestParam("lilevel") Integer lilevel (request,map,단일로 getparam받아오는 방법)
		m.addAttribute("lev", ls.getLevel(li));
		return "level/levelview";
	} 
	
	@RequestMapping(value="/levelIn",method=RequestMethod.POST)
	public ModelAndView insertLevel(ModelAndView mav, @ModelAttribute LevelInfo li ) {
		mav.setViewName("level/insert");
		mav.addObject("map",ls.insertLevel(li));
		return mav;
	}
	
	@RequestMapping(value="/levelList2",method=RequestMethod.POST)
	public @ResponseBody List<LevelInfo> getLevelList1(@RequestBody LevelInfo li ) {
		return ls.getLevelList(li);
	}*/
}
