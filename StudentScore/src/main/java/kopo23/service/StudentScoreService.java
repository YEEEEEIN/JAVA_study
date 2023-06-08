package kopo23.service;

import kopo23.dto.Pagination;

public interface StudentScoreService {
	Pagination getPagination(int page, int countPerpage); // 현재 페이지를 얻는 함수, return 값 Pagination

}
