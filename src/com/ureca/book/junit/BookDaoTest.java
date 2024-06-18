package com.ureca.book.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ureca.book.dao.BookDao;
import com.ureca.book.dao.BookDaoList;

@DisplayName("Junit 5확인")
class BookDaoTest {
	
	static BookDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = BookDaoList.getInstance();
		System.out.println("@BeforeAll 생정자 init()");
	}

	@BeforeEach //메서드 실행 전 계속 호출되는 얘
	void setUp() throws Exception {
		System.out.println(" @BeforeEach 매번 @Test 이전에");
	}

	@AfterEach //메서드 종료 후 계속 호출되는 얘
	void tearDown() throws Exception {
		System.out.println(" @AfterEach 매번 @Test 이후에");
	}

	@Test
	@DisplayName("생성 확인") //출력 이름 변경
	@Disabled //숨기기 실행을 막음
	void testGetInstance() {
		//fail("Not yet implemented");
		System.out.println("  Book확인: "+dao);
		assertNotNull(dao);
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
		System.out.println("@BeforeAll 소멸자 destory()");
	}

}
