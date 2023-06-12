package Dao;

import java.util.List;

import Domain.Gongji;

public interface GongjiDao {
	String makeData(); // 테이블 생성, 원래 데이터 추가, 기본 값 추가

	int insertGongji(Gongji gongji); // 공지 값 넣기
	
	int deleteOneGongji(int id); // 공지 삭제
	
	Gongji updateGongji(Gongji gongji); // 공지 수정
	
	Gongji selectOneGongji(int id); // 공지 리스트 중 id가 같은 번호를 찾아서 1개 출력

	List<Gongji> selectAll(int pageNum, int countPerPage); // 공지 리스트 출력

	int count(); // 데이터 총 개수 
	
	int getCurrentPage(int id, int countPerPage); // 현재 페이지 얻는 함수, 매개변수 String studentid, int countPerPage), return 타입 String, return 타입 int


}
