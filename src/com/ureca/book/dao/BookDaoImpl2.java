package com.ureca.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.ureca.book.dto.Book;

public class BookDaoImpl2 implements BookDao2 {
	
	private static BookDao2 instance = new BookDaoImpl2();
			
	private BookDaoImpl2() {
	}
	
	public static BookDao2 getInstance() {
		return instance;
	}

	@Override
	public int insert(String num, String title, int price) {
		

		String sql = "insert into book values (?,?,?)";
		
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,num);
			ps.setString(2,title);
			ps.setInt(3,price);
			
            ps.setString(1, num);
            ps.setString(2, title);
            ps.setInt(3, price);
			int r = ps.executeUpdate();
			
			System.out.println("등록완료: "+r);
			
			return 1;
		} catch (SQLException e ){
			System.out.println(e);
			
			return 0;
		}
		
		
	}

	@Override
	public int update(String num, String title, int price) {
		String sql = "update book set title=?, price=? where num=?";
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,title);
			ps.setInt(2,price);
			ps.setString(3, num);
			int r = ps.executeUpdate();
			
			System.out.println("수정완료: "+r);
			return 1;
		} catch (SQLException e ){
			System.out.println(e.getStackTrace());
			return 0;
		}
		
	}

	@Override
	public int delete(String num) {
		String sql = "delete from book where num=?";
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1,num);
			int r = ps.executeUpdate();
			
			System.out.println("삭제완료: "+r);
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public StringBuilder read(String num) {
		String sql = "select * from book where num=?";
		StringBuilder sb = new StringBuilder();
		try (Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC","ureca","ureca");
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, num);
			
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					sb.append(rs.getString("num") + " " + rs.getString(2) + " " + rs.getInt("price"));
					return sb;
				}
			
			}
			sb.append("null point DB -> num:"+num);
			return sb;
		}catch (SQLException e) {
			e.printStackTrace();
			sb.append("null point DB -> num:"+num);
			return sb;
			}
		}

	@Override
	public StringBuilder readAll() {
	    String sql = "select * from book";
	    StringBuilder sb = new StringBuilder();
	    
	    try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC", "ureca", "ureca");
	            PreparedStatement ps = con.prepareStatement(sql)) {
	           
	           try (ResultSet rs = ps.executeQuery()) {
	               while (rs.next()) {
	                   sb.append(rs.getString("num"))
	                     .append(" ")
	                     .append(rs.getString("title"))
	                     .append(" ")
	                     .append(rs.getInt("price"))
	                     .append("\n"); // Assuming each record is appended on a new line
	               }
	           }
	    	
	        	  
	       } catch (SQLException e) {
	           e.printStackTrace();
	           sb.append("Failed to retrieve records from the database.");
	       }
	       
	       return sb;
	}



}
