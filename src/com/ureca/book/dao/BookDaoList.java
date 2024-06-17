package com.ureca.book.dao;

import java.util.ArrayList;
import java.util.List;


//DAO는 Data Access Object의 약자로, DB의 데이터에 접근하기 위한 객체를 가리킨다
//직접 DB에 접근하여 data를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행한다.

import com.ureca.book.dto.Book;

public class BookDaoList implements BookDao {
	
	private static BookDao instance = new BookDaoList();
	
	//BookDaoList가 싱글톤이라 BA리스트도 단 한개만 존재하게됨
	private List<Book> ba;
	
	//만약에  private List<Book> ba = new ArrayList<>(); 이렇게 해줬는데 BookDao instance = new BookDaoList();가 더 위에 오면 에러임.
	//BookDaoList()가 먼저 실행되는데 거기서 아직 초기화되지않은 ba를 참조하니까
	
	//for문 돌려서 인덱스 찾아주는거 다 this.select사용해서 코드 중복 피해주기	
	private BookDaoList() {
		ba = new ArrayList<>();
		Book b1 = new Book("104","운영체제론",15000);
		Book b2 = new Book("105","데이터베이스",19000);
		Book b3 = new Book("106","네트워크",17000);
		
		ba.add(b1);
		ba.add(b2);
		ba.add(b3);
	}
	
	public static BookDao getInstance() {
		return instance;
	}

	@Override
	public int insert(Book b) {
//		int findIndex = -1;
//		int curIndex = 0;
//		for (Book elm : ba) {
//			if (elm.getNum().equals(b.getNum())) findIndex = curIndex;
//			curIndex++;
//		}
//		
//		if (findIndex == -1) {
//			ba.add(b);
//		}
//		else {
//			update(b);
//		}
//		
//		
//		return 0;
		
		//강사님 코드
		if(select(b.getNum())!=null) {
			return 0;
		}
		this.ba.add(b);
		return 1;
	}

	@Override
	public int update(Book b) {
//		int findIndex = -1;
//		int curIndex = 0;
//		for (Book elm : ba) {
//			if (elm.getNum().equals(b.getNum())) findIndex = curIndex;
//			curIndex++;
//		}
//		
//		if(findIndex > -1 && findIndex < ba.size()) {
//			ba.set(findIndex, b);
//		}
//		
//		return findIndex;
		
		//강사님 코드
		Book t = select(b.getNum());
		if(t != null) {
			ba.set(ba.indexOf(t), b);
			return 1;
		}
		return 0;
		
	}

	@Override
	public int delete(String num) {
//		int findIndex = -1;
//		int curIndex = 0;
//		for (Book elm : ba) {
//			if (elm.getNum().equals(num)) findIndex = curIndex;
//			curIndex++;
//		}
//		
//		if(findIndex > -1 && findIndex < ba.size() ) {
//			ba.remove(findIndex);
//		}
//		
//		return findIndex;
		
		
		//
		Book t = select(num);
		if(t!=null) {
			ba.remove(t);
			return 1;
		}
		
		return 0;
	}

	@Override
	public Book select(String num) {
//		int findIndex = -1;
//		int curIndex = 0;
//		for (Book elm : ba) {
//			if (elm.getNum().equals(num)) findIndex = curIndex;
//			curIndex++;
//		}
//		
//		if (findIndex > -1 && findIndex < ba.size()) {
//			return ba.get(findIndex);
//		}
//			
//		return null;
		
		//강사님 답안
		for (Book b : ba) {
			if(b.getNum().equals(num)) return b;
		}
		return null;
	}

	@Override
	public List<Book> selectAll() {
		// TODO Auto-generated method stub
		
		//기존 기본 북 리스트의 원본값을 변경할수도있으니 복사한 리스트를 넘겨주기
		return ba.subList(0, ba.size());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(ba);
		return super.toString();
	}
	

}
