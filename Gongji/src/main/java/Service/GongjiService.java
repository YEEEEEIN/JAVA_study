package Service;

import Dto.Pagination;

public interface GongjiService {
	Pagination getPagination(int page, int countPerpage); // 현재 페이지를 얻는 함수, return 값 Pagination

}
