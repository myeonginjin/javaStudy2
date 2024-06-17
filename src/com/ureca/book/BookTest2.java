package com.ureca.book;

import com.ureca.book.dao.BookDao2;
import com.ureca.book.dao.BookDaoImpl2;

public class BookTest2 {
	public static void main(String[] args) {
		BookDao2 dao = BookDaoImpl2.getInstance();
		StringBuilder sb = new StringBuilder();
		
		dao.deleteAll();
		
		dao.insert("1","운영체제론",100);
		dao.insert("2","데이터베이스",2000);
		dao.insert("3","네트워크",34500);
		
		sb = dao.readAll(); 
		System.out.println(sb);
		System.out.println("==============");
		
		dao.delete("2");

		sb = dao.readAll(); 
		System.out.println(sb);
		System.out.println("==============");
		
		dao.update("1","운영체제론",25000);
		
		sb = dao.readAll(); 
		System.out.println(sb);
		System.out.println("==============");
		
		sb = dao.read("1"); 
		System.out.println(sb);
		System.out.println("==============");

		
		sb = dao.readAll(); 
		System.out.println(sb);
		System.out.println("==============");
	}
}
