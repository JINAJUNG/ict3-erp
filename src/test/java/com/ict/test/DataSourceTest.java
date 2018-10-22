package com.ict.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.test.service.LevelService;
import com.ict.test.service.impl.LevelServiceImpl;
import com.ict.test.vo.LevelInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //test/resources에 파일을 넣으 경우
//@ContextConfiguration("file:./src/main/webapp/WEB-INF/spring/root-context.xml") test/resources에 파일을 넣지 않은 경우 경로를 다 주어야 한다.
public class DataSourceTest {
	
	@Autowired
	@Qualifier("dataSourceProxy")
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Autowired
	private SqlSession ss;
	
	@Test
	public void test() {
		try {
			Connection con = ds.getConnection();
			System.out.println("db접속 test완료");
		}catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void ssfTest() {
		try(SqlSession ss = ssf.openSession()){
			System.out.println("Sql Session 생성 테스트 완료");
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void ssTest() {
		assertNotNull(ss);
		List<LevelInfo> list= ss.selectList("SQL.LEVELINFO.selectLevelInfo");
		assertEquals(list.size(), 4);
	}
//
//	@Test
//	public void insertTest() {
//		LevelInfo li = new LevelInfo();
//		li.setLilevel(4);
//		li.setLiname("test");
//		li.setLidesc("test데이터");
//	//	assertEquals(ss.insert("SQL.LEVELINFO.insertLevelInfo",li), 1);
//	}
//	
//	@Test
//	public void updateTest() {
//		LevelInfo li = new LevelInfo();
//		li.setLinum(21);
//		li.setLiname("update test");
//		li.setLidesc("update test데이터");
//	//	assertEquals(ss.update("SQL.LEVELINFO.updateLevelInfo", li), 1);
//	}
//	
//	@Test
//	public void deleteTest() {
//		LevelInfo li = new LevelInfo();
//		li.setLinum(21);
//		assertEquals(ss.delete("SQL.LEVELINFO.deleteLevelInfo", li), 1);
//	}
}
