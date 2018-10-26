package com.ict.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ict.test.service.UserService;
import com.ict.test.vo.UserInfo;

@Controller
public class UserInfoController {
	@Autowired
	private UserService us;

	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInfo> selectResellList(@ModelAttribute UserInfo ui) {
		return us.selectList(ui);
	}

	@RequestMapping(value = "/userinfo/{uinum}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo selectResell(@PathVariable Integer uinum) {
		UserInfo ui = new UserInfo();
		ui.setUinum(uinum);
		return us.selectUser(ui);
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public @ResponseBody Integer insertResell(@ModelAttribute UserInfo ui) {

		return us.insertUser(ui);
	}

	@RequestMapping(value = "/userinfo/{uinum}", method = RequestMethod.PUT)
	public @ResponseBody Integer updateResell(@PathVariable Integer uinum, @RequestBody UserInfo ui) {
		ui.setUinum(uinum);
		return us.updateUser(ui);
	}

	@RequestMapping(value = "/userinfo/{uinum}", method = RequestMethod.DELETE)
	public @ResponseBody Integer deleteResell(@PathVariable Integer uinum) {
		UserInfo ui = new UserInfo();
		ui.setUinum(uinum);
		return us.deleteUser(ui);
	}
}
