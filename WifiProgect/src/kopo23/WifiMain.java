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
		me.setLatitude(me_lat); // ����
		me.setLongitude(me_lng); // �浵

		double mindist = Double.MAX_VALUE;
		double maxdist = Double.MIN_VALUE;

		WifiItem Max = null;
		WifiItem Min = null;

		for (WifiItem target : wifiItems) { // WifiItem Ŭ������ target
			System.out.printf("**[%d��° �׸�]***********\n", target.getId());// ����ϱ�
			System.out.printf(" %s : %s\n", "���������ּ�", target.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", target.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", target.getLongitude());

			double dist = wifiItemService.getDistance(me, target);
			System.out.printf(" ���� ������ �Ÿ� : %f\n", dist);
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

		// ���� ����� ��� ���� ���
		System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
		System.out.printf(" %s : %s\n", "��ġ��Ҹ�", Min.getInstallationLocationName());
		System.out.printf(" %s : %s\n", "���������ּ�", Min.getLotNumberAddress());
		System.out.printf(" %s : %s\n", "����", Min.getLatitude());
		System.out.printf(" %s : %s\n", "�浵", Min.getLongitude());
		System.out.printf(" ���������� �Ÿ� : %f\n", mindist);

		// ���� �� ��� ���� ���
		System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
		System.out.printf(" %s : %s\n", "��ġ��Ҹ�", Max.getInstallationLocationName());
		System.out.printf(" %s : %s\n", "���������ּ�", Max.getLotNumberAddress());
		System.out.printf(" %s : %s\n", "����", Max.getLatitude());
		System.out.printf(" %s : %s\n", "�浵", Max.getLongitude());
		System.out.printf(" ���������� �Ÿ� : %f\n", maxdist);

	}

}
