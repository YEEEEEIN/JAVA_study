package Java_230412;

import java.io.BufferedReader; // BufferedReader 임포트 
import java.io.File; // File 임포트
import java.io.FileReader; // FileReader 임포트
import java.io.IOException; // IOException 임포트

public class P8_1 {
	
	public static void main(String[] args) throws IOException {
		// 파일 경로 지정
		File k23_f = new File("C:\\Users\\예인\\Desktop\\리눅스\\무료와이파이정보.txt");
		// 파일을 읽어들이기 위한 BufferedReader 객체 생성
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f));

		String k23_readtxt;

		// 파일이 비어있는 경우 예외처리
		if ((k23_readtxt = k23_br.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return;
		}

		// 파일의 첫번째 줄에서 필드명을 읽어옴
		String[] k23_field_name = k23_readtxt.split("\t"); // tap은 txt파일

		// 기준 위치(위도, 경도) 설정
		double k23_lat = 37.3860521;
		double k23_lng = 127.1214038;

		// 파일의 데이터를 한 줄씩 읽어와서 처리
		int k23_LineCnt = 0;
		while ((k23_readtxt = k23_br.readLine()) != null) {
			// 탭을 구분자로 각 필드별로 나누어 배열로 저장
			String[] k23_field = k23_readtxt.split("\t");

			// 현재 라인의 번호 출력
			System.out.printf("**[%d]번째 항목*******************\n", k23_LineCnt);
			// 필드명과 값 출력
			System.out.printf(" %s : %s\n", k23_field_name[10], k23_field[10]); // 9번: 지번주소
			System.out.printf(" %s : %s\n", k23_field_name[13], k23_field[13]); // 12번: 위도주소
			System.out.printf(" %s : %s\n", k23_field_name[14], k23_field[14]); // 13번: 경도주소

			// 현재 위치와 해당 위치의 거리 계산
			double dist = Math.sqrt(Math.pow(Double.parseDouble(k23_field[13]) - k23_lat, 2)
					+ Math.pow(Double.parseDouble(k23_field[14]) - k23_lng, 2));
			System.out.printf(" 현재지점과 거리 : %f\n", dist); // 13번: 경도 주소
			System.out.printf("********************************\n");

			k23_LineCnt++;
		}

		// BufferedReader 객체 닫기
		k23_br.close();
	}
}
