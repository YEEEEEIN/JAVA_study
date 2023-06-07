package Java_230412;

import java.io.File; // 파일 다루기 위한 File 클래스 임포트
import java.io.FileReader; // 파일 읽기 위한 FileReader 클래스 임포트
import java.io.FileWriter; // 파일 쓰기 위한 FileWriter 클래스 임포트

public class P5 {

	public static void main(String[] args) {
		try { // 예외 처리 시작
			File k23_f = new File("C:\\Users\\예인\\Desktop\\리눅스\\text.txt"); // 입력한 저장위치에 파일을 생성하는 File 클래스의 인스턴스인 f 생성
			FileWriter k23_fw = new FileWriter(k23_f); // 파일을 쓰기 위한 FileWriter 클래스의 인스턴스인 fw 생성

			k23_fw.write("안녕 파일\n"); // 파일에 "안녕 파일" 문자열 쓰기
			k23_fw.write("hello 헬로\n"); // 파일에 "안녕 파일" 문자열 쓰기

			k23_fw.close(); // 파일 쓰기 종료

			FileReader k23_fr = new FileReader(k23_f); // 파일을 읽기 위한 FileReader 클래스의 인스턴스인 fr 생성

			int k23_n = -1; // 문자를 읽어들일 때 사용할 변수 n을 -1로 초기화
			char[] k23_ch; // 문자열을 저장할 char형 배열 ch 선언

			while (true) {
				k23_ch = new char[100]; // 여유 있게 공간 100으로 할당
				k23_n = k23_fr.read(k23_ch); // 파일에서 최대 ch.length만큼의 문자열을 읽어들이고, 실제로 읽어들인 문자의 개수를 n에 저장

				if (k23_n == -1)
					break; // 읽어들인 문자의 개수가 -1이면 파일 읽기 종료

				for (int k23_i = 0; k23_i < k23_n; k23_i++) { // 읽어들인 문자의 개수만큼 반복문 실행
					// for(char c : ch){
					System.out.printf("%c", k23_ch[k23_i]); // 읽어들인 문자열을 출력
				}
			}
			k23_fr.close();// 읽어들인 문자열을 출력
			System.out.printf("\n FILE READ END ");// 읽어들인 문자열을 출력
		} catch (Exception k23_e) {// 읽어들인 문자열을 출력
			System.out.printf("나 에러[%s]\n", k23_e); // 예외 메시지 출력
		}
	}
}
