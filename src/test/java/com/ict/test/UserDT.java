package com.ict.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.test.dao.LevelDAO;
import com.ict.test.vo.LevelInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserDT {
	
	@Autowired
	LevelDAO ld;
	@Autowired
	LevelInfo li;
	
	@Test
	public void selectList() {
		assertEquals(3, ld.selectLevelList(li));
	}
	
	@Test
	public void selectLevel() {
		li.setLinum(21);
		assertNull(ld.selectLevel(li.getLinum()));
	}
	
	@Test
	public void inTest() {
		li.setLiname("lsTest");
		li.setLilevel(15);
		li.setLidesc("lsDeTest");
		assertEquals(1, (int)ld.insertLevel(li));
	}

	@Test
	public void upTest() {
		li.setLinum(1);
		li.setLiname("upTest");
		li.setLilevel(23);
		li.setLidesc("lsDeup");
		assertEquals(1, (int)ld.updateLevel(li));
	}
	
	@Test
	public void deTest() {	
		li.setLinum(2);
		assertEquals(1, (int)ld.deleteLevel(li.getLinum()));
	}

}
