package com.ict.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.test.service.LevelService;
import com.ict.test.vo.LevelInfo;


//service와 dao가 못 읽어온 이유는! 얘는 root-context만 읽고 servlet-context안읽으니까 아래를 root-context에 추가해야해
/*<context:component-scan base-package="com.ict.test.service" />
<context:component-scan base-package="com.ict.test.vo" />
<context:component-scan base-package="com.ict.test.dao" />*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserT {

	@Autowired
	LevelService ls;
	@Autowired
	LevelInfo li;
	
	@Test
	public void selectList() {
		assertEquals(3, ls.getLevelList(li));
	}
	
	@Test
	public void selectLevel() {
		li.setLinum(1);
		assertNull(ls.getLevel(li.getLinum()));
	}
	
	@Test
	public void inTest() {
		li.setLiname("lsTest");
		li.setLilevel(3);
		li.setLidesc("lsSeTest");
		assertEquals(1, (int)ls.insertLevel(li));
	}

	@Test
	public void upTest() {
		li.setLiname("upTest");
		li.setLilevel(16);
		li.setLidesc("lsDeup");
		li.setLinum(24);
		assertEquals(1, (int)ls.updateLevel(li));
	}
	
	@Test
	public void deTest() {	
		li.setLinum(22);
		assertEquals(1, (int)ls.deleteLevel(li.getLinum()));
	}

}
