package com.ureca.book;

import java.sql.SQLException;

import com.ureca.book.dao.BookDao;
import com.ureca.book.dao.BookDaoImpl;
import com.ureca.book.dao.BookDaoList;
import com.ureca.book.dto.Book;

public class BookTest {

	public static void main(String[] args) throws SQLException {  //코테나 이렇게 하지 개발에서는 이렇게 메인 메소드에 쓰로주거는게 아니라 몸채 내부에서 나 트라이 캐치 걸어줘야함
		
		BookDao dao = BookDaoImpl.getInstance();
		
		dao.deleteAll();
		
		Book b1 = new Book("13434","운영체제론",15000);
		Book b2 = new Book("323424","데이터베이스",19000);
		Book b3 = new Book("6324234","네트워크",17000);
		
		dao.insert(b1);
		dao.insert(b2);
		dao.insert(b3);
//		
		dao.delete("13434");
		dao.delete("15");
		dao.delete("16");
//
		dao.update(new Book("323424","데이터베이스",11));
//		
		dao.select("6324234");
		dao.select("10");
//		
//		Book b4 = new Book("1006","네트워크",90000);
//		dao.insert(b4);
//		
//		
		for (Book b : dao.selectAll()) System.out.println(b);
		
		

	}

}
