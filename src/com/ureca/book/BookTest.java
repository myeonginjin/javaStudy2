package com.ureca.book;

import com.ureca.book.dao.BookDao;
import com.ureca.book.dao.BookDaoList;
import com.ureca.book.dto.Book;

public class BookTest {

	public static void main(String[] args) {
		
		BookDao dao = BookDaoList.getInstance();
		
		
		Book b1 = new Book("1004","운영체제론",15000);
		Book b2 = new Book("1005","데이터베이스",19000);
		Book b3 = new Book("1006","네트워크",17000);
		
		dao.insert(b1);
		dao.insert(b2);
		dao.insert(b3);
		
		dao.delete("1005");
		dao.update(new Book("1006","네트워크",25000));
		
//		Book temp = dao.select("1004");
//		System.out.println(temp+" find");
		
		Book b4 = new Book("1006","네트워크",90000);
		dao.insert(b4);
		
		
		for (Book b : dao.selectAll()) System.out.println(b);
		
		

	}

}
