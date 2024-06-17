package com.ureca.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ureca.book.dto.Book;

//DAO는 Data Access Object의 약자로, DB의 데이터에 접근하기 위한 객체를 가리킨다
//직접 DB에 접근하여 data를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행한다.


//CRUD 서버 개발용 인터페이스 

public interface BookDao2 {
	int insert(String num, String title ,int price);
	int update(String num, String title ,int price);
	int delete(String num);
	StringBuilder read(String num);
	StringBuilder readAll();
	
	default void deleteAll() {
	    String sql = "delete from book";
	    
	    try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC", "ureca", "ureca");
	            PreparedStatement ps = con.prepareStatement(sql)) {
	        
	        int deletedRows = ps.executeUpdate();
	        System.out.println("총 " + deletedRows + "개의 레코드가 삭제되었습니다.");
	        
	    } catch (SQLException e) {
	        System.out.println("데이터 삭제 중 오류가 발생했습니다.");
	        e.printStackTrace();
	    }
	}

}
