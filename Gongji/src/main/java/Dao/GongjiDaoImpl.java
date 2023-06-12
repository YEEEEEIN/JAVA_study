package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import Domain.Gongji;

public class GongjiDaoImpl implements GongjiDao {

	@Override
	public String makeData() {
		try { // try문 시작
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행

			stmt.execute("create table gongji(" // 공지사항 테이블
					+ "id int not null primary key auto_increment, " // 게시글 id
					+ "title varchar(70), " // 제목
					+ "date date, " // 입력일자
					+ "content text)"); // 내용
			
			for (int i = 0; i < 210; i++) {
	               String title = "공지사항" + (i+1);
	               java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	               String content = "공지사항내용" + (i+1);

	               String insertQuery = "INSERT INTO gongji (title, date, content) VALUES ('" 
	            		   + title + "', '" + date + "', '" + content + "')";

	               stmt.executeUpdate(insertQuery);
	            }
			
			stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
			conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) { // Exception 에러 잡기
			e.printStackTrace(); // 에러 내용 찾기
			return e.toString();
		}
		
		return "createTable"; // 오류가 없으면 해당 문구 리턴
	}
	
	@Override
	public int insertGongji(Gongji gongji) { // 객체 중에서 title, content 필요
		int id = 1;
	    try {
	         Class.forName("com.mysql.cj.jdbc.Driver");  // jdbc드라이버 로드하여 데이터 베이스와 연결
	         Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	         Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	         
	         String insertQuery = "INSERT INTO gongji (title, date, content) VALUES ('" + gongji.getTitle() + "', NOW(), '" + gongji.getContent() + "')";
	         stmt.executeUpdate(insertQuery); // INSERT 문을 실행하여 데이터를 gongji 테이블에 삽입합니다.
	         
	         ResultSet rset = stmt.executeQuery("select max(id) from gongji;");
	         
	         if (rset.next()) {
	            id = rset.getInt(1);
	         }

		     stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		     conn.close(); // 객체 닫고 반환하여 자원 소모 방지
	      } catch (Exception e) {
	         e.printStackTrace(); // 에러 내용 찾기
	         System.out.println(e);
	      }
	      return id; // 객체 리턴
	}
	
	@Override
	public int deleteOneGongji(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			stmt.executeUpdate("delete from gongji where id = '" + id + "';"); // studentid가 같은 조건에서 delete하는 쿼리문 실행
			
	        stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	        conn.close(); // 객체 닫고 반환하여 자원 소모 방지
			
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return 1; // 객체 반환
	}
	

	@Override
	public Gongji updateGongji(Gongji gongji) { // 객체 중에서 id, title, content 필요
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에																											// 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			
			// SQL 쿼리문을 실행하기 위해 executeUpdate 메서드를 호출합니다.
			// 현재시간을 사용하려면 NOW() 함수를 사용
			String updateQuery = "UPDATE gongji SET " + "title = '" + gongji.getTitle() + "', " + "date = NOW(), "
					+ "content = '" + gongji.getContent() + "' " + "WHERE id = " + gongji.getId();

			stmt.executeUpdate(updateQuery);
			
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
			System.out.println(e);
			
		}
		return gongji;// 업데이트된 객체를 반환
	}

	@Override
	public Gongji selectOneGongji(int id) {
		Gongji gongji = new Gongji(); // 객체 생성
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery( // studentid가 같은 조건의 쿼리문 실행
					"select * from gongji where id = " + id);

			
			
			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				gongji.setId(rset.getInt(1)); // rset에 저장된 1번째 열 값을 가져오고
				gongji.setTitle(rset.getString(2)); // rset에 저장된 1번째 열 값을 가져오고
				gongji.setDate(rset.getString(3)); // rset에 저장된 1번째 열 값을 가져오고
				gongji.setContent(rset.getString(4)); // rset에 저장된 1번째 열 값을 가져오고

			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return gongji; // 객체 반환
	}

	@Override
	public List<Gongji> selectAll(int page, int countPerPage) {
		List<Gongji> gongjies = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery( // LIMIT(범위)가 있는 쿼리문 실행
					"select * from gongji order by id desc LIMIT " + (page - 1) * countPerPage + "," + countPerPage + ";"); // LIMIT는

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				Gongji gongji = new Gongji(); // 객체 생성
				gongji.setId(rset.getInt(1)); // rset에 저장된 1번째 열 값을 가져오고
				gongji.setTitle(rset.getString(2)); // rset에 저장된 1번째 열 값을 가져오고
				gongji.setDate(rset.getString(3)); // rset에 저장된 1번째 열 값을 가져오고
				gongji.setContent(rset.getString(4)); // rset에 저장된 1번째 열 값을 가져오고
	
				gongjies.add(gongji); // 객체를 리스터형 객체에 더한다
			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
			return null;
		}

		return gongjies; // 객체 반환
	}


	@Override
	public int count() {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery("select count(*) from gongji;"); // ResultSet 객체 rset을 선언하여 쿼리를 실행

			if (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				count = rset.getInt(1); // getInt(1)을 호출하여 현재 행의 첫 번째 열 값을 가져와서 count 변수에 할당
			}

			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
	        stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	        conn.close(); // 객체 닫고 반환하여 자원 소모 방지 

		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
			System.out.println(e);
		}
		return count;
	}

	@Override
	public int getCurrentPage(int id, int countPerPage) {
		int cnt = 0; // 변수 cnt int 선언
	       try {
	           Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
	           Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	           Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	           ResultSet rset = stmt.executeQuery("select * from gongji order by id desc;"); // 쿼리문을 실행하고 실행 결과를 rset에 저장

	           while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
	              cnt ++; // cnt 증가
	              if(id == rset.getInt(1)) { // getInt(2)을 호출하여 현재 행의 2 번째 열 값을 가져온게 studentid와 같으면
	               break; // while 탈출
	              }
	           }
	           rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
	           stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	           conn.close(); // 객체 닫고 반환하여 자원 소모 방지 
	          
	       } catch (Exception e) {
	           e.printStackTrace(); // 에러 내용 찾기
	           System.out.println(e);
	           return -1; // 에러시 -1 리턴
	       }
	       
	       int currentpage = cnt % countPerPage == 0 ? (cnt / countPerPage) : (cnt / countPerPage) + 1; // 현재 페이지 구하는 식
	       
	       return currentpage; // 현재 페이지 값 리턴
	}

}
