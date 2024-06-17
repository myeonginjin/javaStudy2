package com.ureca.book.dto;
import lombok.*;

//DTO는 Data Transfer Object의 약자로, 계층 간(Controlelr, View, Business Layer) 데이터 교환을 위한 Java Bean를 의미한다. 
//DTO는 로직을 가지지 않는 데이터 객체이고, getter, setter 메소드만 가진 클래스를 의미한다.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	private String num;
	private String title;
	private int price;
	
	
//	public Book(String num, String title, int price) {
//		this.num = num;
//		this.title = title;
//		this.price = price;
//	}
//		
//	public String getNum() {
//		return num;
//	}
//	public void setNum(String num) {
//		this.num = num;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
	
}
