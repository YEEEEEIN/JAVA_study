package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.Vote;

public class VoteDaoImpl implements VoteDao {
	
	@Override
	public List<Vote> selectAll() {
		List<Vote> votes = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.
			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.
			ResultSet rset = stmt.executeQuery("select * from hubo_table;"); // "hubo_table" 테이블에서 모든 열을 선택하는 쿼리를 실행하고 결과를 ResultSet 객체로 받습니다.

			while (rset.next()) {
				Vote vote = new Vote(); // Vote 객체를 생성합니다.
				vote.setKiho(rset.getInt(1)); // ResultSet의 첫 번째 열(인덱스 1)에서 kiho 값을 가져와 Vote 객체에 설정합니다.
				vote.setName(rset.getString(2)); // ResultSet의 두 번째 열(인덱스 2)에서 name 값을 가져와 Vote 객체에 설정합니다.

				votes.add(vote); // 생성된 Vote 객체를 votes 리스트에 추가합니다.
			}
			conn.close(); // 데이터베이스 연결을 닫습니다.
			stmt.close(); // Statement 객체를 닫습니다.
			rset.close(); // ResultSet 객체를 닫습니다.
		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
			return null; // 예외가 발생하면 null을 반환합니다.
		}

		return votes; // votes 리스트를 반환합니다.
	}


	@Override
	public int deleteHubo(int kiho) {
		Vote vote = new Vote(); // Vote 객체 생성

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.
			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.
			stmt.executeUpdate("delete from hubo_table where kiho = " + kiho + ";"); // "hubo_table" 테이블에서 kiho가 주어진 값인 행을 삭제하는 쿼리를 실행합니다.
			stmt.close(); // Statement 객체를 닫습니다.
			conn.close(); // 데이터베이스 연결을 닫습니다.

		} catch (Exception e) {
			e.printStackTrace(); // 에러 내용 찾기
		}

		return kiho; // 삭제된 기호의 번호를 반환합니다.
	}


	@Override
	public int insertIntoHubo(String name) {
		int newKiho = 1; // 새로운 학번 변수를 1로 초기화합니다.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.

			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.

			ResultSet rset = stmt.executeQuery("select kiho from hubo_table order by kiho asc"); // "hubo_table" 테이블에서 kiho를 오름차순으로 정렬한 결과를 가져옵니다.

			while (rset.next()) { // ResultSet을 반복하면서 루프를 실행합니다.
				int currentKiho = rset.getInt("kiho"); // 현재 행의 kiho 값을 가져옵니다.
				if (newKiho < currentKiho) { // newKiho가 현재 kiho보다 작으면
					break; // 루프를 종료합니다.
				}
				newKiho = currentKiho + 1; // 비어있는 학번에 새로운 학번을 추가합니다.
			}
			rset.close(); // ResultSet 객체를 닫습니다.

			stmt.execute("INSERT INTO hubo_table VALUES (" + newKiho + ", '" + name + "');"); // 새로운 학번과 주어진 이름을 가지는 행을 "hubo_table" 테이블에 삽입합니다.

			conn.close(); // 데이터베이스 연결을 닫습니다.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e); // 에러 내용 찾기
		}

		return newKiho; // 새로운 학번을 반환합니다.
	}


	@Override
	public int calNumber() {
		int newKiho = 1; // 새로운 학번 변수를 1로 초기화합니다.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.

			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.

			ResultSet rset = stmt.executeQuery("select kiho from hubo_table order by kiho asc"); // "hubo_table" 테이블에서 kiho를 오름차순으로 정렬한 결과를 가져옵니다.

			while (rset.next()) { // ResultSet을 반복하면서 루프를 실행합니다.
				int currentKiho = rset.getInt("kiho"); // 현재 행의 kiho 값을 가져옵니다.
				if (newKiho < currentKiho) { // newKiho가 현재 kiho보다 작으면
					break; // 루프를 종료합니다.
				}
				newKiho = currentKiho + 1; // 비어있는 학번에 새로운 학번을 추가합니다.
			}
			rset.close(); // ResultSet 객체를 닫습니다.

			conn.close(); // 데이터베이스 연결을 닫습니다.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e); // 에러 내용 찾기
		}

		return newKiho; // 새로운 학번을 반환합니다.
	}


	@Override
	public void insertIntoTupyo(int kiho, int age) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.

			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.

			stmt.execute("INSERT INTO tupyo_table VALUES (" + kiho + ", " + age + ");"); // 주어진 kiho와 age 값을 가지는 새로운 행을 "tupyo_table" 테이블에 삽입합니다.

			conn.close(); // 데이터베이스 연결을 닫습니다.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}


	@Override
	public int countAll() {
		int count = 0; // 초기 카운트 값을 0으로 설정합니다.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.

			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.

			ResultSet rset = stmt.executeQuery("select count(*) from tupyo_table;"); // "tupyo_table" 테이블의 레코드 수를 조회합니다.

			while (rset.next()) { // ResultSet에서 결과를 반복하여 처리합니다.
				count = rset.getInt(1); // 첫 번째 컬럼의 값을 가져와 count 변수에 대입합니다.
			}

			conn.close(); // 데이터베이스 연결을 닫습니다.
			stmt.close(); // Statement 객체를 닫습니다.
			rset.close(); // ResultSet 객체를 닫습니다.

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count; // 카운트 값을 반환합니다.
	}


	@Override
	public int countVotes(int kiho) {
		int count = 0; // 초기 카운트 값을 0으로 설정합니다.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.

			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.

			ResultSet rset = stmt.executeQuery("SELECT kiho, COUNT(*) FROM tupyo_table WHERE kiho = " + kiho + " GROUP BY kiho"); // 주어진 kiho에 해당하는 레코드 수를 조회합니다.

			while (rset.next()) { // ResultSet에서 결과를 반복하여 처리합니다.
				count = rset.getInt(2); // 두 번째 컬럼의 값을 가져와 count 변수에 대입합니다.
			}

			conn.close(); // 데이터베이스 연결을 닫습니다.
			stmt.close(); // Statement 객체를 닫습니다.
			rset.close(); // ResultSet 객체를 닫습니다.
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count; // 카운트 값을 반환합니다.
	}


	@Override
	public List<Vote> selectOne(int kiho) {
		List<Vote> votes = new ArrayList<>(); // Vote 객체를 저장할 리스트를 생성합니다.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23"); // 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다. "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.

			Statement stmt = conn.createStatement(); // SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.

			ResultSet rset = stmt.executeQuery("SELECT t.age, COUNT(*) AS voteCnt " 
					+ "FROM hubo_table as h "
					+ "JOIN tupyo_table as t ON h.kiho = t.kiho " 
					+ "WHERE h.kiho = '" + kiho + "'"
					+ "GROUP BY t.age;"); // 주어진 kiho에 해당하는 나이(age)별 투표 수를 조회합니다.

			while (rset.next()) { // ResultSet에서 결과를 반복하여 처리합니다.
				Vote vote = new Vote(); // Vote 객체를 생성합니다.
				vote.setAge(rset.getInt(1)); // 첫 번째 컬럼의 값을 Vote 객체의 나이(age) 필드에 설정합니다.
				vote.setCount(rset.getInt(2)); // 두 번째 컬럼의 값을 Vote 객체의 투표 수(count) 필드에 설정합니다.
				votes.add(vote); // Vote 객체를 리스트에 추가합니다.
			}

			conn.close(); // 데이터베이스 연결을 닫습니다.
			stmt.close(); // Statement 객체를 닫습니다.
			rset.close(); // ResultSet 객체를 닫습니다.
		} catch (Exception e) {
			e.printStackTrace();
		}

		return votes; // Vote 객체들을 담은 리스트를 반환합니다.
	}


}
