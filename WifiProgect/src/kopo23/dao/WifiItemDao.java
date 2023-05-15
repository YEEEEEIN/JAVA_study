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

	public List<WifiItem> selectAll() throws IOException { // 실무에서는 throws IOException 을 쓰지 않는다 
		List<WifiItem> wifiItems = new ArrayList<>();

		// 출력되고 프로그램이 종료
		File f = new File("C:\\\\Users\\\\예인\\\\Desktop\\\\리눅스\\\\무료와이파이정보.txt");// 해당 경로에 새로운 파일 만들기
		BufferedReader br = new BufferedReader(new FileReader(f));// BufferedReader에 FileReader로 읽은 파일 객체 전달

		String readtxt;// 출력할 문자열을 담을 변수 선언

		if ((readtxt = br.readLine()) == null) {// 읽어온 한줄이 내용이 없지 않으면
			System.out.printf("빈 파일 입니다\n");// 출력하기
		}

		int LineCnt = 0;
		while ((readtxt = br.readLine()) != null) {// 읽어온 한줄이 내용이 없지 않으면
			String[] field = readtxt.split("\t");

			// 객체에 값 넣어주기 - 필요한 값만 넣어주자!
			WifiItem wifiItem = new WifiItem();

			wifiItem.setInstallationLocationName(field[1]);
			wifiItem.setId(LineCnt);
			wifiItem.setLotNumberAddress(field[10]);
			wifiItem.setLatitude(Double.parseDouble(field[13]));
			wifiItem.setLongitude(Double.parseDouble(field[14]));
			wifiItems.add(wifiItem);

			LineCnt++;
		}

		br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
		return wifiItems;

	}

	public WifiItem update(WifiItem wifiitem) {
		return null;
	}

	public WifiItem delete(int id) {
		return null;
	}

}
