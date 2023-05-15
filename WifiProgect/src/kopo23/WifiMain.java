package kopo23;

import java.io.IOException;
import java.util.List;

import kopo23.dao.WifiItemDao;
import kopo23.domain.WifiItem;
import kopo23.service.WifiItemService;

public class WifiMain {

	public static void main(String[] args) throws IOException {
		System.out.println("wifi project");

		WifiItemService wifiItemService = new WifiItemService();
		WifiItemDao wifiItemDao = new WifiItemDao();
		List<WifiItem> wifiItems = wifiItemDao.selectAll();

		WifiItem me = new WifiItem();
		double me_lat = 37.3860521;
		double me_lng = 127.1214038;
		me.setLatitude(me_lat); // 위도
		me.setLongitude(me_lng); // 경도

		double mindist = Double.MAX_VALUE;
		double maxdist = Double.MIN_VALUE;

		WifiItem Max = null;
		WifiItem Min = null;

		for (WifiItem target : wifiItems) { // WifiItem 클래스의 target
			System.out.printf("**[%d번째 항목]***********\n", target.getId());// 출력하기
			System.out.printf(" %s : %s\n", "소재지번주소", target.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", target.getLatitude());
			System.out.printf(" %s : %s\n", "경도", target.getLongitude());

			double dist = wifiItemService.getDistance(me, target);
			System.out.printf(" 현재 지점과 거리 : %f\n", dist);
			System.out.println("*************************");

			if (maxdist < dist) {
				maxdist = dist;
				Max = target;
			}
			if (mindist > dist) {
				mindist = dist;
				Min = target;
			}

		}

		// 가장 가까운 장소 정보 출력
		System.out.printf("\n**[최단 거리]***************\n");
		System.out.printf(" %s : %s\n", "설치장소명", Min.getInstallationLocationName());
		System.out.printf(" %s : %s\n", "소재지번주소", Min.getLotNumberAddress());
		System.out.printf(" %s : %s\n", "위도", Min.getLatitude());
		System.out.printf(" %s : %s\n", "경도", Min.getLongitude());
		System.out.printf(" 현재지점과 거리 : %f\n", mindist);

		// 가장 먼 장소 정보 출력
		System.out.printf("\n**[최단 거리]***************\n");
		System.out.printf(" %s : %s\n", "설치장소명", Max.getInstallationLocationName());
		System.out.printf(" %s : %s\n", "소재지번주소", Max.getLotNumberAddress());
		System.out.printf(" %s : %s\n", "위도", Max.getLatitude());
		System.out.printf(" %s : %s\n", "경도", Max.getLongitude());
		System.out.printf(" 현재지점과 거리 : %f\n", maxdist);

	}

}
