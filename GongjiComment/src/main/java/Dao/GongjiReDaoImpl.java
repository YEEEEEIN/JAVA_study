package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.GongjiRe;

public class GongjiReDaoImpl implements GongjiReDao {
	
	@Override
	public String makeData() {
	    try { // try문 시작
	        Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	        Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	        
	        stmt.execute("drop table gongjiRe;"); // 공지사항 테이블 삭제
	        
	        stmt.execute("create table gongjiRe (" // 공지사항 테이블 생성
	                + "id int not null primary key auto_increment, " // 게시글 id
	                + "title varchar(70), " // 제목
	                + "date date, " // 입력일자
	                + "content text, " // 내용
	                + "rootId int, " // 원글 번호
	                + "reLevel int, " // 댓글 레벨
	                + "reCnt int, " // 댓글 내 표시 순서
	                + "viewCnt int)"); // 방문자 수 카운트

	        for (int i = 0; i < 210; i++) {
	            String title = "공지사항" + (i + 1);
	            //java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	            String date = "2023-06-13";
	            String content = "공지사항내용" + (i + 1);
	            int rootid = (i + 1);
	            int relevel = 0;
	            int recnt = 0;
	            int viewcnt = 0;
	            String insertQuery = "INSERT INTO gongjiRe (title, date, content, rootId, reLevel, reCnt, viewCnt)"
	                    + "VALUES ('" + title + "', '" + date + "', '" + content + "', " + rootid + ", " + relevel + ", " + recnt + ", " + viewcnt + ")";

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
	public List<GongjiRe> selectAll(int page, int countPerPage) {
		List<GongjiRe> gongjiRes = new ArrayList<GongjiRe>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			
			ResultSet rset = stmt.executeQuery( // LIMIT(범위)가 있는 쿼리문 실행
					"select * from gongjiRe order by rootId desc, reCnt asc LIMIT " + (page - 1) * countPerPage + "," + countPerPage + ";"); // LIMIT는

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				GongjiRe gongjiRe = new GongjiRe(); // 객체 생성
				gongjiRe.setId(rset.getInt(1)); // rset에 저장된 1번째 열 값을 가져오고
				gongjiRe.setTitle(rset.getString(2)); // rset에 저장된 1번째 열 값을 가져오고
				gongjiRe.setDate(rset.getString(3)); // rset에 저장된 1번째 열 값을 가져오고
				gongjiRe.setContent(rset.getString(4)); // rset에 저장된 1번째 열 값을 가져오고
				gongjiRe.setRootId(rset.getInt(5)); 
				gongjiRe.setReLevel(rset.getInt(6)); 
				gongjiRe.setReCnt(rset.getInt(7)); 
				gongjiRe.setViewCnt(rset.getInt(8)); 
				gongjiRes.add(gongjiRe); // 객체를 리스터형 객체에 더한다
			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
			return null;
		}

		return gongjiRes; // 객체 반환
	}
	
	@Override
	public GongjiRe selectOneGongji(int id) {
		GongjiRe gongjiRe = new GongjiRe(); // 객체 생성
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			
			ResultSet rset = stmt.executeQuery( // studentid가 같은 조건의 쿼리문 실행
					"select * from gongjiRe where id = " + id + ";");

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				gongjiRe.setId(rset.getInt(1)); // rset에 저장된 번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setTitle(rset.getString(2)); // rset에 저장된 2번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setDate(rset.getString(3)); // rset에 저장된 3번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setContent(rset.getString(4)); // rset에 저장된 4번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setRootId(rset.getInt(5)); // rset에 저장된 5번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setReLevel(rset.getInt(6)); // rset에 저장된 6번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setReCnt(rset.getInt(7)); // rset에 저장된 7번째 열 값을 가져오고 객체에 세팅
				gongjiRe.setViewCnt(rset.getInt(8)); // rset에 저장된 8번째 열 값을 가져오고 객체에 세팅
			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return gongjiRe; // 객체 반환
	}
	
	@Override
	public int deleteOneGongji(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			
			// 해당 id의 댓글 수준 가져옴
			ResultSet rset1 = stmt.executeQuery("select rootId from gongjiRe where id = " + id + ";");
			int rootId = 0; // 댓글 수준 담는 변수			
			while (rset1.next()) { // 읽어올 값이 남아있는 한 루프 반복
				rootId = rset1.getInt(1); // 댓글 순서 받아옴
			}
			
			// 삭제하려는 글의 레벨 찾기
			ResultSet rset2 = stmt.executeQuery("select reLevel from gongjiRe where id = " + id + ";");
			int reLevel = 0; // 게시글 레벨 넣을 변수
			while (rset2.next()) { // 읽어올 값이 남아있는 한 루프 반복
				reLevel = rset2.getInt(1); // 게시글 레벨 받아옴
			}

			ResultSet rset3 = stmt.executeQuery("select reCnt from gongjiRe where id = " + id + ";"); 
			int reCnt = 0; // 댓글 표시 순서 담는 변수			
			while (rset3.next()) { // 읽어올 값이 남아있는 한 루프 반복
				reCnt = rset3.getInt(1); // 댓글 표시 순서 받아옴
			}
			
			// 삭제하려는 글과 같거나 작은 레벨에 있으면서, rootid가 같고 recnt가 큰 글의 최소 recnt 값 찾기
			ResultSet rset4 = stmt.executeQuery("select min(reCnt) from gongjiRe"
					+ " where rootId = " + rootId 
					+ " and reLevel <= " + reLevel
					+ " and reCnt > " + reCnt + ";");
			int nextReCnt = 0; // 다음 recnt 값 담을 변수
			while (rset4.next()) { // 읽어올 값이 남아있는 한 루프 반복
				nextReCnt = rset4.getInt(1); // 다음 recnt 받아옴
			}
			
			int count = nextReCnt - reCnt; // recnt들 사이 count 계산
			
			Statement stmt2 = conn.createStatement(); // 새로 Statement 만들기
			
			if (nextReCnt != 0) { // 다음 recnt가 0이 아닐 경우
				stmt2.execute("delete from gongjiRe"
						+ " where rootId = " + rootId
						+ " and reCnt >= " + reCnt
						+ " and reCnt < " + nextReCnt + ";"); // 삭제하려는 글에 달린 모든 댓글 삭제				
			} else { // 그 외에는
				// 삭제하려는 글 이후의 모든 댓글 삭제
				stmt2.execute("delete from gongjiRe"
						+ " where rootId = " + rootId 
						+ " and reCnt >= " + reCnt + ";");
			}
			// 삭제된 글 개수만큼 뒤에 있던 댓글들 recnt 감소
			stmt2.execute("update gongjiRe set reCnt= reCnt - " + count 
					+ " where reCnt >= " + nextReCnt + " and rootId = " + rootId + ";");

	        stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	        conn.close(); // 객체 닫고 반환하여 자원 소모 방지
			
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return 1; // 객체 반환
	}
	
	@Override
	public int updateGongji(GongjiRe gongjiRe) { // 객체 중에서 id, title, content 필요
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에																											// 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			
			// SQL 쿼리문을 실행하기 위해 executeUpdate 메서드를 호출합니다.
			// 현재시간을 사용하려면 NOW() 함수를 사용
			stmt.execute("UPDATE gongjiRe SET " 
					+ "title = '" + gongjiRe.getTitle() + "', " 
					+ "date = NOW(), "
					+ "content = '" + gongjiRe.getContent() + "' " 
					+ "WHERE id = " + gongjiRe.getId() + ";");
			
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
			System.out.println(e);
			
		}
		return 1;// 업데이트된 객체를 반환
	}
	
	@Override
	public int insertGongji(GongjiRe gongjiRe) { // 객체 중에서 title, content 필요
		int id = 1;
		String title = gongjiRe.getTitle(); // 공지사항 제목 가져오기
		String content = gongjiRe.getContent(); // 본문 내용 가져오기
		int rootId = gongjiRe.getRootId(); // rootid 가져오기
		int reLevel = gongjiRe.getReLevel(); // relevel 가져오기
		int reCnt = gongjiRe.getReCnt(); // recnt 가져오기
		int viewCnt = gongjiRe.getViewCnt(); // viewcnt 가져오기
		
	    try {
	         Class.forName("com.mysql.cj.jdbc.Driver");  // jdbc드라이버 로드하여 데이터 베이스와 연결
	         Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	         Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	         
	         stmt.execute("update gongjiRe set reCnt= reCnt + 1 "
	         		+ "where reCnt >= " + reCnt + " and rootId = " + rootId + ";");
				
	         stmt.execute("insert into gongjiRe (title, date, content, rootid, relevel, recnt, viewcnt) "
					+ "values('" + title + "', NOW(), '" + content + "', " + rootId + ", " + reLevel + ", " + reCnt + ", 0);"); // 삽입 진행
				
	         ResultSet rset = stmt.executeQuery("select max(id) from gongjiRe;");
	         
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
	public int count() {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery("select count(*) from gongjiRe;"); // ResultSet 객체 rset을 선언하여 쿼리를 실행

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
	           
	           ResultSet rset = stmt.executeQuery("select * from gongjiRe order by rootId desc, reCnt asc;"); // 쿼리문을 실행하고 실행 결과를 rset에 저장

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
	
	@Override
	public int addViewCnt(int id) { // 게시글의 조회수를 1 늘려줌
		try { // 오류를 방지하기 위한 try문 시작
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	        Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	           
			stmt.execute("update gongjiRe set viewCnt = viewCnt + 1 where id = " + id + ";"); // 조회수 1 늘리기
			
			conn.close(); // Connection 닫기
			stmt.close(); // Statement 닫기
		} catch (ClassNotFoundException | SQLException e) { // 오류를 잡았을 경우
			e.printStackTrace(); // 오류 내용 프린트
			return -1; // null 리턴
		}
		return 1; // 1 리턴
	}

	@Override
	public int getReCnt(int rootId, int reLevel, int reCnt) {
		int cnt = 0; // cnt 담을 변수
		try { // 오류를 방지하기 위한 try문
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	        Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	        
			// 해당 페이지에 나오는 모든 학생들의 정보를 가져오는 명령어 실행
			ResultSet rset = stmt.executeQuery("select min(reCnt) from gongjiRe"
					+ " where rootId = " + rootId 
					+ " and reLevel <= " + reLevel 
					+ " and reCnt > " + reCnt + ";");

			while (rset.next()) { // 읽어올 값이 있는 한 루프 반복
				reCnt = rset.getInt(1); // recnt 받아오기
			}
			
			Statement stmt2 = conn.createStatement(); // Statement 새로 만들기
			
			if (reCnt == 0) { // recnt가 0일 경우
				// recnt의 마지막 값에 1 추가한 값 가져오기
				ResultSet rset2 = stmt2.executeQuery("select max(reCnt)+1 from gongjiRe where rootId = " + rootId + ";");
				while(rset2.next()) { // 읽어올 값이 있는 한 루프 반복
					reCnt = rset2.getInt(1); // recnt 받아오기
				}
			}
			
			if (reCnt == 0) reCnt = 1; // recnt가 0이면 1로 지정
			
			conn.close(); // Connection 닫기
			stmt.close(); // Statement 닫기
			rset.close(); // ResultSet 닫기
		} catch (ClassNotFoundException | SQLException e) { // 오류를 잡았을 경우
			e.printStackTrace(); // 오류 내용 프린트
			return -1; // null값 리턴
		}
		return reCnt; // recnt 값 리턴
	}

	@Override
	public int getNewId() {
		int id = 0; // id 값 담을 변수
		try { // 오류를 방지하기 위한 try문
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	        Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	        
			ResultSet rset = stmt // id의 max값 받아옴
					.executeQuery("select max(id) from gongjiRe;");

			while (rset.next()) { // 읽어올 값이 있는 한 루프 반복
				id = rset.getInt(1); // id 값 받아옴
			}
			conn.close(); // Connection 닫기
			stmt.close(); // Statement 닫기
			rset.close(); // ResultSet 닫기
		} catch (ClassNotFoundException | SQLException e) { // 오류를 잡았을 경우
			e.printStackTrace(); // 오류 내용 프린트
			return -1; // null값 리턴
		}
		return id; // id 값 리턴
	}


}
