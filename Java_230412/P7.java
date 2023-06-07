package Java_230412;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P7 {

	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두개를 써야한다
		File k23_f = new File("C:\\Users\\예인\\Desktop\\리눅스\\무료와이파이정보.csv"); // 파일 경로 지정
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f));  // 파일 읽기 위한 BufferedWriter 객체 생성

		String k23_readtxt; // 파일에서 읽어온 문자열을 저장할 변수

		// 한 줄을 먼저 읽어야 필드명을 알 수 있다
		if ((k23_readtxt = k23_br.readLine()) == null) { // 파일이 비어있는 경우 => 여기서 처음 br.readLine()가 실행된다
			System.out.printf("빈 파일입니다\n");
			return;
		}
		// 필드명을 쉼표(,)를 기준으로 분리하여 배열에 저장
		String[] k23_field_name = k23_readtxt.split(","); // csv파일은 ,로 열 구분
		
		int k23_LineCnt = 1; // 라인 수 저장 변수
		while ((k23_readtxt = k23_br.readLine()) != null) { // 파일 끝까지 한 줄씩 읽음 => 두번째 br.readLine()가 실행된다
			String[] field = k23_readtxt.split(","); // 현재 라인의 필드값을 쉼표(,)를 기준으로 분리하여 배열에 저장
			System.out.printf("**[%d번째 항목]******************************\n", k23_LineCnt);
			for (int k23_j = 0; k23_j < k23_field_name.length; k23_j++) { // 필드명과 필드값을 출력
				System.out.printf(" %s : %s\n", k23_field_name[k23_j], field[k23_j]); // 
			}
			System.out.println("*******************************************\n");
			if (k23_LineCnt == 100) // 100개 까지만 출력
				break;
			k23_LineCnt++; // 라인 수 증가
		}
		k23_br.close(); // 파일 닫기
	}

}
