package com.ureca.book;

import com.ureca.book.dao.BookDao;
import com.ureca.book.dao.BookDaoList;
import com.ureca.book.dto.Book;

public class BookTest {

	public static void main(String[] args) {
		
		BookDao dao = BookDaoList.getInstance();
		
		
		Book b1 = new Book("104","운영체제론",00);
		Book b2 = new Book("105","데이터베이스",000);
		Book b3 = new Book("1060","네트워크",00);
		
		dao.insert(b1);
		dao.insert(b2);
		dao.insert(b3);
		
		dao.delete("105");
		dao.delete("104");
		dao.delete("106");
		
		dao.update(new Book("1060","네트워크",25000));
//		
//		Book temp = dao.select("1004");
//		System.out.println(temp+" find");
//		
//		Book b4 = new Book("1006","네트워크",90000);
//		dao.insert(b4);
//		
		
		for (Book b : dao.selectAll()) System.out.println(b);
		
		

	}

}
