package com.ureca.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ureca.book.dto.Book;
import com.ureca.book.util.DBUtil;

public class BookDaoImpl implements BookDao {
	
	
	//상수로 뺴고 싶은 변수 드래그 후 리펙터에서 기능 찾기 , 현재는 아예 클래스로 빼줫음
//	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC";
//	private static final String ID = "ureca";
//	private static final String PASSWORD = "ureca";
	
	private static BookDao instance = new BookDaoImpl();
	//private static BookDao instance = null;    <----  이렇게 하는 경우도 있음
	
	private BookDaoImpl() {
		
	}
	
	public static BookDao getInstance() {
		// if(instance = null) instance = new BookDaoImpl();   <---- 이렇게, getInstance가 호출될때까지 싱글톤 객체를 만들지 않고 호출되고 나서야 만드는 방법
		return instance;
	}
	
	private DBUtil util = DBUtil.getInstance();

	@Override
	public int insert(Book b) throws SQLException {  //인터페이스에 스루즈 추가돼서 트라이 캐치 지우고 이렇게 바꿔줘야됨
		
		//int r = 0; 
		String sql = "insert into book values (?,?,?)";
		
		try (Connection con = util.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,b.getNum());
			ps.setString(2,b.getTitle());
			ps.setInt(3,b.getPrice());
			
			return ps.executeUpdate();
			
		}
		
		
	}

	//게터로 뺴고 싶은 부분 드래그 후 리펙터 -> 기능 찾기  현재는 클래스로 메서드로 빼줫음
//	private Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(URL,ID,PASSWORD);
//	}	

	@Override
	public int update(Book b) throws SQLException{
		
		// int r = 0;
		
		String sql = "update book set title=?, price=? where num=?";
		
		try (Connection con = util.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,b.getTitle());
			ps.setInt(2,b.getPrice());
			ps.setString(3,b.getNum());

			return ps.executeUpdate();
			
			// r = ps.executeUpdate(); 한번쓰고 버리니까 그냥 지우자 
		}  
		//return r


	}

	@Override
	public int delete(String num) throws SQLException{
		
		String sql = "delete from book where num=?";
		
		
		try (Connection con = util.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1,num);
			return ps.executeUpdate();
			
			
		} 
		
	}

	@Override
	public Book select(String num) throws SQLException{
		String sql = "select * from book where num=?";
		Book b = null;
		
		try (Connection con = util.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1,num);
			
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					b = new Book(rs.getString("num"), rs.getString(2),rs.getInt("price"));
				}
			}
		} 
		
		return b;
		}

	@Override
	public List<Book> selectAll() throws SQLException {
		
		List<Book> bs = new ArrayList<>();
		String sql = "select * from book";

		try (Connection con= util.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					bs.add(new Book(rs.getString("num"), rs.getString(2),rs.getInt("price")));
				}
			}
		}
		
		//이렇게 해야되는거 위로 축소한거임
//		Connection con= null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			con= util.getConnection();
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			
//				while(rs.next()) {
//					bs.add(new Book(rs.getString("num"), rs.getString(2),rs.getInt("price")));
//				}
//				
//		} finally {
//			//util.close(ps,con);
//			con.close();
//			ps.close();
//			rs.close();
//			
//		}
		
		return bs;
	}

}
