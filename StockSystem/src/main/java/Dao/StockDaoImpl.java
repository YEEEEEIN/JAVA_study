package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.Stock;

public class StockDaoImpl implements StockDao {

	@Override
	public String makedata() {
	    try {
	        // MySQL JDBC 드라이버를 로드합니다.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 데이터베이스에 연결합니다.
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23");

	        // SQL 문을 실행하기 위한 Statement 객체를 생성합니다.
	        Statement stmt = conn.createStatement();

	        // 'stock' 테이블을 생성하는 SQL 문을 실행합니다.
	        stmt.execute("create table stock("
	                + "row_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "  // row_id: 순번 컬럼 (자동 증가)
	                + "id VARCHAR(70) UNIQUE, "  // id: 고유한 바코드 값 (문자열, 최대 70자, 중복 불가)
	                + "name VARCHAR(70), "  // name: 상품명 (문자열, 최대 70자)
	                + "amount int, "  // amount: 수량 (정수)
	                + "regDate date, "  // regDate: 등록 일자 (날짜)
	                + "checkDate date, "  // checkDate: 검사 일자 (날짜)
	                + "content text, "  // content: 상세 정보 (텍스트)
	                + "photo text)");  // photo: 사진 URL (텍스트)

	        // 111개의 데이터를 생성하여 'stock' 테이블에 삽입합니다.
	        for (int i = 0; i < 111; i++) {
	            String id = String.valueOf(1000000000000L + i); // 바코드 13자리
	            String name = "100% 국산 과일 품번 : " + (i + 1);
	            int amount = 5;
	            java.sql.Date regDate = java.sql.Date.valueOf("2023-06-01");
	            java.sql.Date checkDate = java.sql.Date.valueOf("2023-06-09");
	            String content = "과일 상세 정보" + (i + 1);
	            String photo = ""; // url

	            // 데이터를 삽입하는 SQL 문을 생성합니다.
	            String insertQuery = "INSERT INTO stock (id, name, amount, regDate, checkDate, content, photo) VALUES ('"
	                    + id + "', '"
	                    + name + "', "
	                    + amount + ", '"
	                    + regDate.toString() + "', '"
	                    + checkDate.toString() + "', '"
	                    + content + "', '"
	                    + photo + "')";

	            // SQL 문을 실행하여 데이터를 삽입합니다.
	            stmt.executeUpdate(insertQuery);
	        }

	        // Statement와 Connection을 닫습니다.
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return e.toString();
	    }

	    // 작업이 성공적으로 완료되면 "createTable & insertData"를 반환합니다.
	    return "createTable & insertData";
	}



	@Override
	public List<Stock> selectAll(int page, int countPerPage) {
	    List<Stock> Stockes = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다.

	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다.

	        Statement stmt = conn.createStatement(); // SQL 문을 실행하기 위한 Statement 객체를 생성합니다.

	        // 페이지와 페이지 당 항목 수를 기반으로 'stock' 테이블에서 데이터를 조회하는 SQL 문을 실행합니다.
	        ResultSet rset = stmt.executeQuery(
	                "select * from stock order by row_id desc LIMIT " + (page - 1) * countPerPage + "," + countPerPage + ";");

	        while (rset.next()) { // ResultSet 객체의 다음 행으로 이동합니다.
	            Stock stock = new Stock(); // Stock 객체를 생성합니다.

	            // ResultSet에서 각 열의 값을 가져와서 Stock 객체에 설정합니다.
	            stock.setId(rset.getString(2)); // 상품번호
	            stock.setName(rset.getString(3)); // 상품명
	            stock.setAmount(rset.getInt(4)); // 현재재고수
	            stock.setCheckDate(rset.getString(5)); // 상품등록일
	            stock.setRegDate(rset.getString(6)); // 재고파악일

	            Stockes.add(stock); // Stock 객체를 리스트에 추가합니다.
	        }

	        rset.close(); // ResultSet을 닫고 자원을 반환합니다.
	        stmt.close(); // Statement를 닫고 자원을 반환합니다.
	        conn.close(); // Connection을 닫고 자원을 반환합니다.
	    } catch (Exception e) {
	        e.printStackTrace(); // 에러 내용을 출력합니다.
	        return null;
	    }

	    return Stockes; // Stock 리스트를 반환합니다.
	}


	@Override
	public Stock selectOne(String id) {
		Stock stock = new Stock(); // 객체 생성
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery( // id가 같은 조건의 쿼리문 실행
					"select * from stock where id = '" + id + "'");

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				// rset에 저장된 1번째 열 값을 가져온다
				stock.setId(rset.getString(2)); // 상품번호
				stock.setName(rset.getString(3)); // 상품명
				stock.setAmount(rset.getInt(4)); // 재고현황
				stock.setRegDate(rset.getString(5)); // 상품등록일
				stock.setCheckDate(rset.getString(6)); // 재고파익일
				stock.setContent(rset.getString(7)); // 상품설명
				stock.setPhoto(rset.getString(8)); // 상품사진

			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return stock; // 객체 반환
	}

	@Override
	public void insertStock(Stock stock) {
	    try {
	         Class.forName("com.mysql.cj.jdbc.Driver");  // jdbc드라이버 로드하여 데이터 베이스와 연결
	         Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	         Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	         
	         String insertQuery = "INSERT INTO stock (id, name, amount, checkDate, regDate, content, photo) VALUES ('" 
	                 + stock.getId() + "', '"
	                 + stock.getName() + "', "
	                 + stock.getAmount() + ", NOW(), NOW(), '"
	                 + stock.getContent() + "', '"
	                 + stock.getPhoto() + "')";

	         stmt.executeUpdate(insertQuery); // INSERT 문을 실행하여 데이터를 stock 테이블에 삽입합니다.

		     stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		     conn.close(); // 객체 닫고 반환하여 자원 소모 방지
	      } catch (Exception e) {
	         e.printStackTrace(); // 에러 내용 찾기
	         System.out.println(e);
	      }
	}
	

	@Override
	public void deleteStock(String id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			stmt.executeUpdate("delete from stock where id = '" + id + "';"); //studentid가 같은 조건에서 delete하는 쿼리문 실행
			
	        stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	        conn.close(); // 객체 닫고 반환하여 자원 소모 방지
			
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

	}

	@Override
	public void updateStock(Stock stock) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에																											// 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			
			// SQL 쿼리문을 실행하기 위해 executeUpdate 메서드를 호출합니다.
			// 현재시간을 사용하려면 NOW() 함수를 사용
			String updateQuery = "UPDATE stock SET "
			        + "amount = " + stock.getAmount() + ", "
			        + "checkdate = NOW() "
			        + "WHERE id = '" + stock.getId() + "'";

			stmt.executeUpdate(updateQuery);
			
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
			System.out.println(e);
		}
	}

	@Override
	public int count() {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery("select count(*) from stock;"); // ResultSet 객체 rset을 선언하여 쿼리를 실행

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
	public int getCurrentPage(String id, int countPerPage) {
		int cnt = 0; // 변수 cnt int 선언
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에
																														// 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery("select * from stock order by row_id desc;"); // 쿼리문을 실행하고 실행 결과를 rset에 저장

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				cnt++; // cnt 증가
				if (id.equals(rset.getString(2))) { // getInt(2)을 호출하여 현재 행의 2 번째 열 값을 가져온게 id와 같으면
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

	@Override
	public int findExistingValues(String id) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery( // id가 같은 조건의 쿼리문 실행
					"select * from stock where id = '" + id + "'");

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				cnt++;
			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
			return -1; // 존재하면 1
		}

		return cnt; // 존재하면 1
	}


}
