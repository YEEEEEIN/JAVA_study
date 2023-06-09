package Dao;

import java.util.List;

import Domain.Vote;

public interface VoteDao {
	List<Vote> selectAll(); // 모든 데이터 얻는 함수, return 타입 List<Vote>
	
	int deleteHubo(int kiho); // Hubo 테이블 삭제 함수, return 타입 int
	
	int insertIntoHubo(String name); // hubo 테이블에 값을 넣는 함수, return 타입 int
	
	int calNumber(); // 기호 번호를 계산하는 함수, return 타입 int
	
	void insertIntoTupyo(int kiho, int age); // tupyo 테이블에 값을 넣는 함수
	
	int countAll(); // 총 개수 세는 함수, return 타입 int
	
	int countVotes(int kiho); // 투표 개수 세는 함수, return 타입 int
	
	List<Vote> selectOne(int kiho); // 한개의 데이터 얻는 함수, return 타입 List<Vote>
	
}


