package kopo23.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kopo23.domain.WifiItem;

public class WifiItemDao {

	public WifiItem create(WifiItem wifiitem) {
		return null;
	}

	public WifiItem selectOne(int id) {
		return null;
	}

	public List<WifiItem> selectAll() throws IOException { // �ǹ������� throws IOException �� ���� �ʴ´� 
		List<WifiItem> wifiItems = new ArrayList<>();

		// ��µǰ� ���α׷��� ����
		File f = new File("C:\\\\Users\\\\����\\\\Desktop\\\\������\\\\���������������.txt");// �ش� ��ο� ���ο� ���� �����
		BufferedReader br = new BufferedReader(new FileReader(f));// BufferedReader�� FileReader�� ���� ���� ��ü ����

		String readtxt;// ����� ���ڿ��� ���� ���� ����

		if ((readtxt = br.readLine()) == null) {// �о�� ������ ������ ���� ������
			System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
		}

		int LineCnt = 0;
		while ((readtxt = br.readLine()) != null) {// �о�� ������ ������ ���� ������
			String[] field = readtxt.split("\t");

			// ��ü�� �� �־��ֱ� - �ʿ��� ���� �־�����!
			WifiItem wifiItem = new WifiItem();

			wifiItem.setInstallationLocationName(field[1]);
			wifiItem.setId(LineCnt);
			wifiItem.setLotNumberAddress(field[10]);
			wifiItem.setLatitude(Double.parseDouble(field[13]));
			wifiItem.setLongitude(Double.parseDouble(field[14]));
			wifiItems.add(wifiItem);

			LineCnt++;
		}

		br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
		return wifiItems;

	}

	public WifiItem update(WifiItem wifiitem) {
		return null;
	}

	public WifiItem delete(int id) {
		return null;
	}

}
