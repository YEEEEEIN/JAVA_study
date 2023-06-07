package Java_230414;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import org.json.simple.perser.JSONParser;

public class P20 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// JSON Parser 객체 ?��?��
		JSONParser parser = new JSONParser();
		// ?��?��?��?�� JSON ?��?��?�� ?���?
		Object obj = parser.parse(new FileReader("C:\\Users\\?��?��\\Desktop\\?��바심?��(v2023)-?��바심?��\\datas.json"));

		// JSON 배열�? �??��
		JSONArray array = (JSONArray) obj;

		// 배열?�� ?��기만?�� 반복
		System.out.printf("*****************************\n");
		for (int i = 0; i < array.size(); i++) {
			// 배열?��?�� JSON 객체 ?��?��?�� �??��?���?
			JSONObject result = (JSONObject) array.get(i);
			// ?���? 출력
			System.out.println("?���? : " + result.get("name"));
			// ?���? 출력
			System.out.println("?���? : " + result.get("studentid"));

			// ?��?�� 배열 �??��?���?
			JSONArray score = (JSONArray) result.get("score");
			// �? 과목 ?��?�� 출력
			long kor = (long) score.get(0); // 배열 �? 첫번째는 �??��
			long eng = (long) score.get(1); // 배열 �? 첫번째는 ?��?��
			long mat = (long) score.get(2); // 배열 �? 첫번째는 ?��?��
			System.out.println("�??�� : " + kor);
			System.out.println("?��?�� : " + eng);
			System.out.println("?��?�� : " + mat);
			// 총점 출력
			System.out.println("총점 : " + (kor + eng + mat));
			// ?���? 출력
			System.out.println("?���? : " + (kor + eng + mat) / 3);
			System.out.println("\"*****************************");
		}
	}
}
