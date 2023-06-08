package kopo23.dao;

import java.util.List;

import kopo23.domian.StudentScore;

public interface StudentScoreDao {
	String createTable(); // 테이블 생성 함수, return 타입 String

	String dropTable(); // 테이블 삭제 함수, return 타입 String

	String allsetTable(int totaldata); // 테이블에 값 넣는 함수, return 타입 String

	int getCurrentPage(String studentid, int countPerPage); // 현재 페이지 얻는 함수, 매개변수 String studentid, int countPerPage), return 타입 String, return 타입 int

	int count(); // 데이터 총 갯수 얻는 함수, return 타입 int

	StudentScore create(StudentScore studentScore); // 데이터 넣는(insert) 함수, return 타입 StudentScore

	StudentScore selectOne(String studentid); // 데이터 한 행 얻는 함수, return 타입 StudentScore

	List<StudentScore> selectAll(int page, int countPerPage); // 모든 데이터 얻는 함수, return 타입 List<StudentScore>

	StudentScore update(String studentid, StudentScore studentScore); // 데이터 수정 함수, return 타입 StudentScore

	StudentScore delete(String studentid); // 데이터 삭제 함수, return 타입 StudentScore

}
