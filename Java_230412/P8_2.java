package Java_230412;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P8_2 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\예인\\Desktop\\리눅스\\무료와이파이정보.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return;
		}
		String[] field_name = readtxt.split("\t"); // tap은 txt파일

		// 융합기술 우리집 위도경도, 지도에서 알아보기
		double lat = 37.3860521;
		double lng = 127.1214038;

		int LineCnt = 0;
		double min_dist = Double.MAX_VALUE; // 최소 거리
		double max_dist = Double.MIN_VALUE; // 최대 거리
		String min_NameOfInstallationPlace = null; // 최소 거리 일때 설치장소명
		String max_NameOfInstallationPlace = null; // 최대 거리 일때 설치장소명
		String min_LocationNumberAddress = null; // 최소 거리 일때 소재지지번주소
		String max_LocationNumberAddress = null; // 최소 거리 일때 소재지지번주소
		double min_latitude = Double.MAX_VALUE; // 최소 거리 일때 위도
		double max_latitude = Double.MIN_VALUE; // 최소 거리 일때 위도
		double min_longitude = Double.MAX_VALUE; // 최소 거리 일때 경도
		double max_longitude = Double.MIN_VALUE; // 최소 거리 일때 경도

		while ((readtxt = br.readLine()) != null) {
			String[] field = readtxt.split("\t");
			System.out.printf("**[%d]번째 항목***************************\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[10], field[10]); // 9번: 지번주소
			System.out.printf(" %s : %s\n", field_name[13], field[13]); // 12번: 위도주소
			System.out.printf(" %s : %s\n", field_name[14], field[14]); // 13번: 경도주소
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[13]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[14]) - lng, 2));
			System.out.printf(" 현재지점과 거리 : %f\n", dist); // 13번: 경도 주소
			System.out.printf("********************************************\n");

			// 가장 가까운 곳과 먼 곳 찾기

			if (dist < min_dist) {
				min_dist = dist;
				min_NameOfInstallationPlace = field[1];
				min_LocationNumberAddress = field[10];
				min_latitude = Double.parseDouble(field[13]);
				min_longitude = Double.parseDouble(field[14]);
			}
			if (dist > max_dist) {
				max_dist = dist;
				max_NameOfInstallationPlace = field[1];
				max_LocationNumberAddress = field[10];
				max_latitude = Double.parseDouble(field[13]);
				max_longitude = Double.parseDouble(field[14]);
			}

			LineCnt++;
		}
		br.close();
		System.out.printf("\n******************[최소거리]******************\n");
		System.out.printf(" 현재지점과 거리 : %f\n", min_dist); // 최소 거리
		System.out.printf(" 설치장소명 : %s\n", min_NameOfInstallationPlace); // 설치장소명
		System.out.printf(" 소재지지번주소 : %s\n", min_LocationNumberAddress); // 소재지지번주소
		System.out.printf(" 위도 : %f\n", min_latitude); // 위도
		System.out.printf(" 경도 : %f\n", min_longitude); // 경도

		System.out.printf("\n******************[최대거리]******************\n");
		System.out.printf(" 현재지점과 거리 : %f\n", max_dist); // 최대 거리
		System.out.printf(" 설치장소명 : %s\n", max_NameOfInstallationPlace); // 설치장소명
		System.out.printf(" 소재지지번주소 : %s\n", max_LocationNumberAddress); // 소재지지번주소
		System.out.printf(" 위도 : %f\n", max_latitude); // 위도
		System.out.printf(" 경도 : %f\n", max_longitude); // 경도

	}

}
