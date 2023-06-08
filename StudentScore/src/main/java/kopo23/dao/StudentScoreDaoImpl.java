package kopo23.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kopo23.domian.StudentScore;

public class StudentScoreDaoImpl implements StudentScoreDao {

	@Override
	public String createTable() {
		try { // try문 시작
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행

			stmt.execute("create table examtable(" // examtable 테이블 생성 명령어 실행
					+ "name varchar(20)," // 문자열 이름 필드 생성
					+ "studentid varchar(20) not null primary key," // 문자형 학번 필드 생성 및 not null, primary key 속성 부여
					+ "kor int," // 정수형 국어 점수 필드 생성
					+ "eng int," // 정수형 영어 점수 필드 생성
					+ "mat int)"); // 정수형 수학 점수 필드 생성

			stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
			conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) { // Exception 에러 잡기
			e.printStackTrace(); // 에러 내용 찾기
			return e.toString(); // 에러 내용 리턴
		}
		return "create Complete"; // 오류가 없으면 해당 문구 리턴
	}

	@Override
	public String dropTable() {
		try { // try문 시작
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행

			stmt.execute("drop table examtable"); // 테이블 삭제 명령어 실행

			stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
			conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) { // Exception 에러 잡기
			e.printStackTrace(); // 에러 내용 찾기
			return e.toString(); // 에러 내용 리턴
		}
		return "drop Complete"; // 오류가 없으면 해당 문구 리턴
	}

	@Override
	public String allsetTable(int totaldata) { // 원하는 데이터 총 개수가 매개변수
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행

			String name; // name이라는 String 변수를 선언
			String studentid; //studentid라는 String 타입 변수를 선언
			int cnt = 0; // cnt라는 int 타입 변수를 선언, 0으로 초기화

			// stmt.execute("DELETE FROM examtable WHERE studentid > 0;"); // studentid가 0보다 큰 행을 examtable 테이블에서 삭제

			while (cnt != totaldata) { // cnt가 totaldata과 같지 않을 때 까지 반복
				cnt++; // cnt 변수를 1씩 증가
				name = "홍길" + cnt; // name 변수에 "홍길" 문자열과 cnt 변수를 연결하여 할당
				studentid = String.valueOf(209900 + cnt); // studentid 변수에 209900에 cnt 변수를 더하여 할당

				// RAND()*100 => 0 ~ 100 까지의 점수 출력, 데이터 삽입 쿼리문 실행
				stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('" + name + "', '"
						+ studentid + "', RAND()*100, RAND()*100, RAND()*100)");

			}
			
			stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
			conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) { // Exception 에러 잡기
			e.printStackTrace(); // 에러 내용 찾기
			return e.toString(); // 에러 내용 리턴
		}
		return "insert Complete"; // 오류가 없으면 해당 문구 리턴

	}
	
	@Override
	public int getCurrentPage(String studentid, int countPerPage) { // studentid, countPerPage로 현재 페이지 구하는 함수
		int cnt = 0; // 변수 cnt int 선언
	       try {
	           Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
	           Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	           Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	           ResultSet rset = stmt.executeQuery("select * from examtable order by studentid"); // 쿼리문을 실행하고 실행 결과를 rset에 저장

	           while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
	              cnt ++; // cnt 증가
	              if(studentid.equals(rset.getString(2))) { // getInt(2)을 호출하여 현재 행의 2 번째 열 값을 가져온게 studentid와 같으면
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
	public int count() {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery("select count(*) from examtable;"); // ResultSet 객체 rset을 선언하여 쿼리를 실행

			if (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				count = rset.getInt(1); // getInt(1)을 호출하여 현재 행의 첫 번째 열 값을 가져와서 count 변수에 할당
			}

			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
	        stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	        conn.close(); // 객체 닫고 반환하여 자원 소모 방지 

		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}
		return count;
		// return 1225;
	}

//	@Override
//	public StudentScore create(StudentScore studentScore) { // insert
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
//			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에
//																														// 연결
//			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
//
//			int NewStdId = 0;
//			int aStdId = 20990001;
//
//			ResultSet rset1 = stmt.executeQuery("select studentid from examtable;");
//
//			while (rset1.next()) {
//				if (aStdId == rset1.getInt(1)) {
//					aStdId = rset1.getInt(1) + 1;
//				} else {
//					NewStdId = aStdId;
//					break;
//				}
//			}
//			rset1.close();
//
//			ResultSet rset2 = stmt.executeQuery("select max(studentid) from examtable;");
//			if (NewStdId == 0) {
//				while (rset2.next()) {
//					NewStdId = rset2.getInt(1) + 1; // 가장 큰 학번 + 1
//				}
//			}
//			rset2.close();
//
//
//			String studentid = Integer.toString(NewStdId);
//			studentScore.setStudentid(studentid); // 학번 객체에 set하기
//			
//			stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('" + studentScore.getName()
//					+ "', '" + studentScore.getStudentid() + "'," + studentScore.getKor() + "," + studentScore.getEng() + ","
//					+ studentScore.getMat() + ");");
//			
//			
//			
//			// 출력
//			ResultSet rset = stmt.executeQuery("select id from examtable where studentid = '" + studentScore.getStudentid() + "';");
//
//			while (rset.next()) {
//				studentScore.setId(rset.getInt(1)); // id
//			}
//			rset.close();
//			conn.close();
//			stmt.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		return studentScore;
//	}
	
	   @Override
	   public StudentScore create(StudentScore studentScore) {
	      String name = studentScore.getName(); // StudentScore 객체에서 name 가져옴
	      int kor = studentScore.getKor(); // StudentScore 객체에서 kor 가져옴
	      int eng = studentScore.getEng(); // StudentScore 객체에서 eng 가져옴
	      int mat = studentScore.getMat(); // StudentScore 객체에서 mat 가져옴

	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");  // jdbc드라이버 로드하여 데이터 베이스와 연결
	         Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
	         Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
	         ResultSet rset = stmt.executeQuery("select studentid from examtable order by studentid asc"); // 쿼리문을 실행하고 실행 결과를 rset에 저장

	         int newId = 209901; // 새로운 학번 변수 선언 및 초기값 설정
	         while (rset.next()) { // rset 돌면서 루프
	            int currentId = rset.getInt("studentid"); // currentId에 현재 학번 대입
	            if (newId < currentId) { // newId가 currentId가 작으면
	               break; // 루프 탈출
	            }
	            newId = currentId + 1; // 비어있는 학번에 새로운 학번 추가
	         }
	         rset.close(); // 객체 닫고 반환하여 자원 소모 방지 

	         String studentid = String.format("%06d", newId);// studentid 값 설정
	      
	         studentScore.setStudentid(studentid); // 부여된 학번을 studentScore에 넣어줌
	         
	         // 각각이 값들을 넣어주고 삽입 쿼리문 실행
	         stmt.execute("insert into examtable (name, studentid, kor, eng, mat) "
	         		+ "VALUES ('" + name + "', " + studentid + "," + kor + "," + eng + "," + mat + ");");

	         rset = stmt.executeQuery("select studentid from examtable where studentid = " + studentid); // 쿼리문 실행
	         
	         rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		     stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		     conn.close(); // 객체 닫고 반환하여 자원 소모 방지
	      } catch (Exception e) {
	         e.printStackTrace(); // 에러 내용 찾기
	         return null;
	      }
	      return studentScore; // 객체 리턴
	   }

	@Override
	public StudentScore selectOne(String studentid) {
		StudentScore studentScore = null; // 객체 생성

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery( // studentid가 같은 조건의 쿼리문 실행
					"select *, b.kor + b.eng + b.mat, (b.kor + b.eng + b.mat) / 3," +
					"(select count(*) + 1 from examtable as a where (a.kor + a.eng + a.mat) > (b.kor + b.eng + b.mat)) from examtable as b " +
					"where studentid = " + studentid);

			studentScore = new StudentScore(); // 객체 생성
			
			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				studentScore.setName(rset.getString(1)); // rset에 저장된 1번째 열 값을 가져오고, 객체의 name 변수에 저장
				studentScore.setStudentid(rset.getString(2)); // rset에 저장된 2번째 열 값을 가져오고, 객체의 studentid 변수에 저장
				studentScore.setKor(rset.getInt(3)); // rset에 저장된 3번째 열 값을 가져오고, 객체의 kor 변수에 저장
				studentScore.setEng(rset.getInt(4)); // rset에 저장된 4번째 열 값을 가져오고, 객체의 eng 변수에 저장
				studentScore.setMat(rset.getInt(5)); // rset에 저장된 5번째 열 값을 가져오고, 객체의 mat 변수에 저장
				studentScore.setSum(rset.getInt(6)); // rset에 저장된 6번째 열 값을 가져오고, 객체의 sum 변수에 저장
				studentScore.setAvg(rset.getDouble(7)); // rset에 저장된 7번째 열 값을 가져오고, 객체의 avg 변수에 저장
				studentScore.setRank(rset.getInt(8)); // rset에 저장된 8번째 열 값을 가져오고, 객체의 rank 변수에 저장
			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return studentScore; // 객체 반환
	}

	@Override
	public List<StudentScore> selectAll(int page, int countPerPage) {

		List<StudentScore> studentScores = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			ResultSet rset = stmt.executeQuery( // LIMIT(범위)가 있는 쿼리문 실행
					"select *, b.kor + b.eng + b.mat, (b.kor + b.eng + b.mat) / 3," +
					"(select count(*) + 1 from examtable as a where (a.kor + a.eng + a.mat) > (b.kor + b.eng + b.mat)) from examtable as b " +
					"LIMIT " + (page - 1) * countPerPage + "," + countPerPage + ";"); // LIMIT는

			while (rset.next()) { // rset.next()를 통해 ResultSet 객체의 다음 행으로 이동
				StudentScore studentScore = new StudentScore(); // 객체 생성
				studentScore.setName(rset.getString(1)); // rset에 저장된 1번째 열 값을 가져오고, 객체의 name 변수에 저장
				studentScore.setStudentid(rset.getString(2)); // rset에 저장된 2번째 열 값을 가져오고, 객체의 studentid 변수에 저장
				studentScore.setKor(rset.getInt(3)); // rset에 저장된 3번째 열 값을 가져오고, 객체의 kor 변수에 저장
				studentScore.setEng(rset.getInt(4)); // rset에 저장된 4번째 열 값을 가져오고, 객체의 eng 변수에 저장
				studentScore.setMat(rset.getInt(5)); // rset에 저장된 5번째 열 값을 가져오고, 객체의 mat 변수에 저장
				studentScore.setSum(rset.getInt(6)); // rset에 저장된 6번째 열 값을 가져오고, 객체의 sum 변수에 저장
				studentScore.setAvg(rset.getDouble(7)); // rset에 저장된 7번째 열 값을 가져오고, 객체의 avg 변수에 저장
				studentScore.setRank(rset.getInt(8)); // rset에 저장된 8번째 열 값을 가져오고, 객체의 rank 변수에 저장

				studentScores.add(studentScore); // 객체를 리스터형 객체에 더한다
			}
			rset.close(); // 객체 닫고 반환하여 자원 소모 방지 
		    stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
			return null;
		}

		return studentScores; // 객체 반환
	}

	@Override
	public StudentScore update(String studentid, StudentScore studentScore) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			// studentid가 같은 조건에서 update하는 쿼리문 문자열에 저장
			String sqlQuery = "update examtable set " + "name = '" + studentScore.getName() + "', " + "kor = "
					+ studentScore.getKor() + ", " + "eng = " + studentScore.getEng() + ", " + "mat = "
					+ studentScore.getMat() + " " + "where studentid = " + studentid;

			stmt.executeUpdate(sqlQuery); // 쿼리 실행

			stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
		    conn.close(); // 객체 닫고 반환하여 자원 소모 방지
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return studentScore;  // 에러 내용 찾기
	}


	@Override
	public StudentScore delete(String studentid) {
		StudentScore studentScore = new StudentScore(); // 객체 생성

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버 로드하여 데이터 베이스와 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결
			Statement stmt = conn.createStatement(); // sql문을 데이터베이스로 보내고 실행
			stmt.executeUpdate("delete from examtable where studentid = '" + studentid + "';"); // studentid가 같은 조건에서 delete하는 쿼리문 실행
			
	        stmt.close(); // 객체 닫고 반환하여 자원 소모 방지
	        conn.close(); // 객체 닫고 반환하여 자원 소모 방지
			

		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return studentScore; // 객체 반환
	}

	

	

	

}
