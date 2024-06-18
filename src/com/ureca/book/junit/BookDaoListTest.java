package com.ureca.book.junit;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ureca.book.dto.Book;

import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.ureca.book.dao.BookDao;
import com.ureca.book.dao.BookDaoList;

@DisplayName("BookDaoList 확인")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   //order걸기 위해서 명시
class BookDaoListTest {
	static BookDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = BookDaoList.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println(" ");
	}

	@Test
	@Order(1) //실행순서 운선순위 부여
	//@Disabled
	@DisplayName("Book 등록")
	void testInsert() throws SQLException {
		Book b = new Book("101","소셜",4000);
		assertEquals(dao.insert(b), 1);
		
		Book selected = dao.select("101");
		assertEquals(selected.getTitle(), b.getTitle());
		assertEquals(selected.getPrice(), b.getPrice());
	}

	@Test
	@Order(2) // 근데 이 방법은 비추 순서 안주고 그냥 쭈욱 실행시키는게 더 좋은 코드야
	//@Disabled
	@DisplayName("Book 변경")
	void testUpdate() throws SQLException {
		Book b = new Book("104","소셜",4444);
		assertEquals(dao.update(b), 1);
		
		Book selected = dao.select("104");
		assertEquals(selected.getTitle(), b.getTitle());
		assertEquals(selected.getPrice(), b.getPrice());
	}

	@Test
	@Order(3)
	//@Disabled
	@DisplayName("Book 삭제")
	void testDelete() throws SQLException {
		Book b = dao.select("105");
		assertNotNull(b);
		
		assertEquals(dao.delete("105"), 1);
		
		Book deleted = dao.select("105");
		assertNull(deleted);
	}

	@Test
	@Order(4)
	//@Disabled
	@DisplayName("Book 조회")
	void testSelect() throws SQLException {
		Book b = dao.select("101");
		assertEquals(b.getTitle(), "소셜");
		assertEquals(b.getPrice(), 4000);
	}

	@Test
	@Order(5)
	//@Disabled
	@DisplayName("Book 목록")
	void testSelectAll() throws SQLException {
		List<Book> bs = dao.selectAll();
		assertEquals(bs.size(),3);
		assertEquals(bs.get(0).getTitle(),"소셜");
	}


}
