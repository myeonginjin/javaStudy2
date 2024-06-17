package com.ureca.book.dao;

import java.util.List;

import com.ureca.book.dto.Book;

//DAO는 Data Access Object의 약자로, DB의 데이터에 접근하기 위한 객체를 가리킨다
//직접 DB에 접근하여 data를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행한다.


public interface BookDao {
	int insert(Book b);
	int update(Book b);
	int delete(String num);
	Book select(String num);
	List<Book> selectAll();

}
