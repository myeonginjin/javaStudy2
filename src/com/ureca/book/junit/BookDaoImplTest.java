package com.ureca.book.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ureca.book.dao.BookDao;
import com.ureca.book.dao.BookDaoImpl;
import com.ureca.book.dto.Book;

@DisplayName("BookDaoImpl 확인")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //순서를 적절히 배치해서 테스트 연속으로 돌려도 계속 패스하도록 했음 만든거 수정하고 삭제하고 조회는 삭제 후 기존 테이블
class BookDaoImplTest {
	private static BookDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = BookDaoImpl.getInstance();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	//@Disabled
	@Order(1)
	@DisplayName("Book 등록")
	void testInsert() throws SQLException {
		Book b = new Book("104","소셜",4000);
		assertEquals(dao.insert(b), 1);
		
		//에셉션이 발생하는지 검사하는 것도 아래처럼 가능
		assertThrows(SQLException.class,()-> dao.insert(b));
		
		Book selected = dao.select("104");
		assertEquals(selected.getTitle(), b.getTitle());
		assertEquals(selected.getTitle(), b.getTitle());
	}

	@Test
	//@Disabled
	@Order(2)
	@DisplayName("Book 변경")
	void testUpdate() throws SQLException {
		Book b = new Book("104","수필",4440);
		assertEquals(dao.update(b), 1);
		
		Book selected = dao.select("104");
		assertEquals(selected.getTitle(), b.getTitle());
		assertEquals(selected.getTitle(), b.getTitle());
	}

	@Test
	//@Disabled
	@Order(3)
	@DisplayName("Book 삭제")
	void testDelete() throws SQLException {
		Book b = dao.select("104");
		assertNotNull(b);
		
		assertEquals(dao.delete("104"), 1);
		
		Book deleted = dao.select("104");
		assertNull(deleted);
	}

	@Test
	//@Disabled
	@DisplayName("Book 조회")
	@Order(4)
	void testSelect() throws SQLException {
		List<Book> bs = dao.selectAll();
		assertEquals(bs.size(),3);
		assertEquals(bs.get(0).getTitle(),"자바");
	}

	@Test
	//@Disabled
	@Order(5)
	@DisplayName("Book 목록")
	void testSelectAll() throws SQLException {
		List<Book> bs = dao.selectAll();
		assertEquals(bs.size(),3);
		assertEquals(bs.get(0).getTitle(),"자바");
	}

}
