package Dao;

import java.util.List;

import Domain.Stock;

public interface StockDao {
	String makedata(); // 데이터 생성 메서드입니다.
	
	List<Stock> selectAll(int page, int countPerPage); // 페이지와 페이지 당 항목 수를 기반으로 모든 항목을 조회하는 메서드입니다.
	
	Stock selectOne(String id); // 주어진 ID에 해당하는 항목을 조회하는 메서드입니다.
	
	void insertStock(Stock stock); // 주식 항목을 삽입하는 메서드입니다.
	
	void deleteStock(String id); // 주어진 ID에 해당하는 주식 항목을 삭제하는 메서드입니다.
	
	void updateStock(Stock stock); // 주식 항목을 업데이트하는 메서드입니다.
	
	int count(); // 데이터의 총 개수를 세는 메서드입니다.
	
	int getCurrentPage(String id, int countPerPage); // 주어진 ID와 페이지 당 항목 수를 기반으로 현재 페이지를 얻는 메서드입니다.
	
	int findExistingValues(String id);
}
