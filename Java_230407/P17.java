package Java_230407;

public class P17 {

	public static void main(String[] args) {

		TvRemoconX tvre;
		tvre = new TvRemoconX(); // tvre 객체 생성

		// 채널 10 올리기
		System.out.printf("채널 10 올리기\n"); // 출력
		for (int i = 0; i < 10; i++) { // 채널 10 올리기 위해 10번 반복
			tvre.channelUp();
			tvre.chMsg("채널 1 올리기");
		}

		// 채널 10 내리기
		System.out.printf("\n채널 10 내리기\n"); // 출력
		for (int i = 0; i < 10; i++) { // 채널 10 내리기 위해 10번 반복
			tvre.channelDown();
			tvre.chMsg("채널 1 내리기");
		}

		// 볼륨 5 올리기
		System.out.printf("\n볼륨 5 올리기\n"); // 출력
		for (int i = 0; i < 5; i++) { // 볼륨 5 올리기 위해 5번 반복
			tvre.volUp();
			tvre.volMsg("볼륨 1 올리기");
		}

		// 볼륨 5 내리기
		System.out.printf("\n볼륨 5 내리기\n"); // 출력
		for (int i = 0; i < 5; i++) { // 볼륨 5 내리기 위해 5번 반복
			tvre.volDown();
			tvre.volMsg("볼륨 1 내리기");
		}
		
		tvre.batteryCheck(); // 배터리 체크
		System.out.printf("MSG TvRemocon[%s]\n", tvre.help); 

	}

}
