package Java_230414;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class P18 {
	// 메소드 oneRec 선언
	public static JSONObject oneRec(String name, int studentid, int kor, int eng, int mat) {
		JSONObject dataObject = new JSONObject(); // JSON 객체 생성
		dataObject.put("name", name); // 데이터 추가
		dataObject.put("studentid", studentid); // 데이터 추가
		
		JSONArray score = new JSONArray(); // JSON 배열 생성
		score.add(kor); // 데이터 추가
		score.add(eng); // 데이터 추가
		score.add(mat); // 데이터 추가
		dataObject.put("score", score); // 데이터 추가 
		
		return dataObject; // JSON 객체 반환
	}

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject(); // JSON 객체 생성

		JSONArray dataArray = new JSONArray(); // JSON 배열 생성

		JSONObject dataObject = new JSONObject(); // JSON 객체 생성

		dataObject.put("name", "나연"); // 데이터 추가
		dataObject.put("studentid", "209901"); // 데이터 추가
		JSONArray score = new JSONArray();

		score.add(90); // 데이터 추가
		score.add(100); // 데이터 추가
		score.add(95); // 데이터 추가
		dataObject.put("score", score); // 데이터 추가
		dataArray.add(dataObject); // JSON 배열에 JSON 객체 추가
		
		// 깔끔하게 함수 처리
		dataArray.add(oneRec("정연", 209902, 100, 85, 75)); // 데이터 추가
		dataArray.add(oneRec("모모", 209903, 90, 75, 85)); // 데이터 추가
		dataArray.add(oneRec("사나", 209904, 90, 85, 75)); // 데이터 추가
		dataArray.add(oneRec("지효", 209905, 80, 75, 85)); // 데이터 추가
		dataArray.add(oneRec("미나", 209906, 90, 85, 55)); // 데이터 추가
		dataArray.add(oneRec("다현", 209907, 70, 75, 65)); // 데이터 추가
		dataArray.add(oneRec("채영", 209908, 100, 75, 95)); // 데이터 추가
		dataArray.add(oneRec("쯔위", 209909, 80, 85, 95)); // 데이터 추가
		
		// 파일 생성 및 데이터 쓰기
		try {
			// 파일에 쓰기 위한 FileWriter 객체 생성 및 파일 경로 지정
			FileWriter file = new FileWriter("C:\\Users\\예인\\Desktop\\자바심화(v2023)-자바심화\\testdata2.json");
			file.write(dataArray.toJSONString()); // JSONArray 객체를 JSON 문자열로 변환하여 파일에 쓰기
			file.flush(); // 버퍼링된 문자 내용을 파일에 쓰기
			file.close(); // 파일 쓰기 종료
		} catch (IOException e) { // 예외 처리를 위한 try-catch 블록
			e.printStackTrace(); // 예외 발생 시 예외 내용 출력
		}
		
		System.out.println("JSON 만든거 : " + dataArray); // JSON 배열 출력

	}


}