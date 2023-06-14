package Dao;

import java.util.List;

import Domain.GongjiRe;

public interface GongjiReDao {
	String makeData(); // 테이블 생성, 원래 데이터 추가, 기본 값 추가

	int insertGongji(GongjiRe gongjiRe); // 공지 값 넣기
	
	int deleteOneGongji(int id); // 공지 삭제
	
	int updateGongji(GongjiRe gongjiRe); // 공지 수정
	
	GongjiRe selectOneGongji(int id); // 공지 리스트 중 id가 같은 번호를 찾아서 1개 출력

	List<GongjiRe> selectAll(int pageNum, int countPerPage); // 공지 리스트 출력

	int count(); // 데이터 총 개수 
	
	int getCurrentPage(int id, int countPerPage); // 현재 페이지 얻는 함수, 매개변수 String studentid, int countPerPage), return 타입 String, return 타입 int
	
	int addViewCnt(int id); // 게시글의 조회수를 1 늘려줌
	
	int getReCnt(int rootId, int reLevel, int reCnt); // 모체의 rootid, relevel, recnt를 기반으로 새로운 댓글의 recnt를 계산해 리턴
	
	int getNewId(); // 새로운 게시글이 배정받은 아이디 값을 리턴

}
