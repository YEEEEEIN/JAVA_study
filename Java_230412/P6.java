package Java_230412;

import java.io.BufferedReader; // 텍스트 파일을 읽기 위한 BufferedReader 클래스 임포트
import java.io.BufferedWriter; // 텍스트 파일을 쓰기 위한 BufferedReader 클래스 임포트
import java.io.File; // 파일 다루기 위한 File 클래스 임포트
import java.io.FileReader; // 파일 읽기 위한 FileReader 클래스 임포트
import java.io.FileWriter; // 파일 쓰기 위한 FileWriter 클래스 임포트
import java.io.IOException; // 입출력 동작 중 발생하는 일반적인 예외를 처리하는 예외 클래스 임포트

public class P6 {
	// 파일 쓰기
	public static void FileWrite() throws IOException {
		File k23_f = new File("C:\\Users\\예인\\Desktop\\리눅스\\Mytest.txt"); // 파일 경로 지정
		BufferedWriter k23_bw = new BufferedWriter(new FileWriter(k23_f)); // 파일 쓰기 위한 BufferedWriter 객체 생성

		k23_bw.write("안녕 파일"); // 텍스트 입력
		k23_bw.newLine(); // 개행
		k23_bw.write("hello 헬로"); // 텍스트 입력
		k23_bw.newLine(); // 개행

		k23_bw.close(); // 파일 닫기
	}
	// 파일 읽기
	public static void FileRead() throws IOException {
		File k23_f = new File("C:\\Users\\예인\\Desktop\\리눅스\\Mytest.txt"); // 파일 경로 지정
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f)); // 파일 읽기 위한 BufferedReader 객체 생성

		String k23_readtxt; // 파일에서 읽어온 문자열을 저장할 변수

		while ((k23_readtxt = k23_br.readLine()) != null) { // 파일에서 읽어온 문자열을 저장할 변수
			System.out.printf("%s\n", k23_readtxt);
		}
		k23_br.close(); // 파일 닫기

	}

	public static void main(String[] args) throws IOException {
		FileWrite(); // 파일 쓰기 함수 출력
		FileRead(); // 파일 읽기 함수 출력
	}

}
