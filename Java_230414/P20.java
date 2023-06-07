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
		// JSON Parser ê°ì²´ ?ƒ?„±
		JSONParser parser = new JSONParser();
		// ?ŒŒ?¼?—?„œ JSON ?°?´?„° ?½ê¸?
		Object obj = parser.parse(new FileReader("C:\\Users\\?˜ˆ?¸\\Desktop\\?ë°”ì‹¬?™”(v2023)-?ë°”ì‹¬?™”\\datas.json"));

		// JSON ë°°ì—´ë¡? ë³??™˜
		JSONArray array = (JSONArray) obj;

		// ë°°ì—´?˜ ?¬ê¸°ë§Œ?¼ ë°˜ë³µ
		System.out.printf("*****************************\n");
		for (int i = 0; i < array.size(); i++) {
			// ë°°ì—´?—?„œ JSON ê°ì²´ ?•˜?‚˜?”© ê°?? ¸?˜¤ê¸?
			JSONObject result = (JSONObject) array.get(i);
			// ?´ë¦? ì¶œë ¥
			System.out.println("?´ë¦? : " + result.get("name"));
			// ?•™ë²? ì¶œë ¥
			System.out.println("?•™ë²? : " + result.get("studentid"));

			// ? ?ˆ˜ ë°°ì—´ ê°?? ¸?˜¤ê¸?
			JSONArray score = (JSONArray) result.get("score");
			// ê°? ê³¼ëª© ? ?ˆ˜ ì¶œë ¥
			long kor = (long) score.get(0); // ë°°ì—´ ì¤? ì²«ë²ˆì§¸ëŠ” êµ??–´
			long eng = (long) score.get(1); // ë°°ì—´ ì¤? ì²«ë²ˆì§¸ëŠ” ?˜?–´
			long mat = (long) score.get(2); // ë°°ì—´ ì¤? ì²«ë²ˆì§¸ëŠ” ?ˆ˜?•™
			System.out.println("êµ??–´ : " + kor);
			System.out.println("?˜?–´ : " + eng);
			System.out.println("?ˆ˜?•™ : " + mat);
			// ì´ì  ì¶œë ¥
			System.out.println("ì´ì  : " + (kor + eng + mat));
			// ?‰ê·? ì¶œë ¥
			System.out.println("?‰ê·? : " + (kor + eng + mat) / 3);
			System.out.println("\"*****************************");
		}
	}
}
