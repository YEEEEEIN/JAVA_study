package Service;

import Dao.GongjiDaoImpl;
import Dto.Pagination;

public class GongjiServiceImpl implements GongjiService {

	@Override
	public Pagination getPagination(int page, int countPerpage) { // 구하는 페이지, 페이지당 보여주는 데이터 수 매개변수
		
		GongjiDaoImpl studentScoreDaoImpl = new GongjiDaoImpl(); // GongjiDaoImpl의 객체 선언
		
		int totalData = studentScoreDaoImpl.count(); // 총 데이터 개수
		int cntPT = countPerpage; // 간격 10, get 요소
		
		int currentpage = page; // 현재 위치한 페이지에 구하는 페이지 대입
		int startPage = 1; // 현재 위치한 페이지의 하단 페이지 범위 시작값
		int pagecnt = 10; // 하단 페이지박수 갯수 10으로 고정
		
		// 마지막 페이지 구하는 변수, 데이터를 cntPT로 나눈 값이 0이면 그냥 몫 출력, 아니면 페이지가 더 필요하기 때문에 +1
		int lastPage = totalData % cntPT == 0 ? totalData / cntPT : (totalData / cntPT) + 1;
		
		if(page <= 1) { // 구하는 페이지가 1보다 작거나 같으면
			currentpage = 1; // 현재 페이지 1
		} else if (page > lastPage) { // 구하는 페이지가 마지막 페이지보다 크면
			currentpage = lastPage; // currentpage 마지막 페이지를 대입
		} else { // 둘 다 아니면
			currentpage = page; // currentpage는 구하는 페이지
		}

        startPage = ((currentpage - 1) / pagecnt) * pagecnt + 1; // 현재 페이지의 페이지박스 시작 페이지 계산 
        int lastStartPage = ((lastPage - 1) / pagecnt) * pagecnt + 1; // 마지막 페이지의 페이지 박스 시작 페이지 계산 
        int endPage = startPage + pagecnt - 1; // 페이지박스 끝 값
        
        if(lastPage < endPage) { // 마지막 페이지가 페이지박스의 끝 값 보다 작으면
        	endPage = lastPage; // 페이지 박스 끝 값에 마지막 페이지 값 대입
        }
        
        int prev = currentpage - pagecnt; // 10페이지 뒤로 이동, 현재페이지 - 10
        int pprev = 1; // 처음 페이지 이동, 1페이지로 이동
        if (prev < 1) { // prev가 1보다 작다면
        	prev = -1; // prev는 -1
        	pprev = -1; // pprev는 -1
        }
        
        int next = currentpage + pagecnt; // 10 앞으로 이동한 페이지, 현재 페이지 + 10
        if (next > lastPage) { // next가 마지막페이지보다 크면
        	next = lastPage; // lastPage 대입
        }
        
        int nnext = lastPage; // 마지막 페이지로 이동, lastPage 대입
        if(startPage == lastStartPage) { // 현재페이지의 페이지박스 시작 값 == 마지마페이지의 페이지박스 시작 값
        	next = -1; // -1 대입
    		nnext = -1; // -1 대입
        }
        
		Pagination pagination = new Pagination(); // Pagination 객체 생성하여
		
		pagination.setC(currentpage); // 현재 페이지 값 객체에 저장
		pagination.setS(startPage); // 현재 페이지의 페이지박스 시작 페이지 값 객체에 저장
		pagination.setE(endPage); // 현재 페에지의 페이지박스 마지막 페이지 값 객체에 저장
		pagination.setP(prev); // 10 페이지 앞으로 이동 값 객체에 저장
		pagination.setPp(pprev); // 1 페이지 이동 값 객체에 저장
		pagination.setN(next); // 10 페이지 뒤로 이동 값 객체에 저장
		pagination.setNn(nnext); // 마지막 페이지 이동 값 객체에 저장
		
		return pagination; // 객체 리턴
	}

}
