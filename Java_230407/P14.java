package Java_230407;

public class P14 {

	static TvRemocon2 tvre; // TvRemocon2 클래스의 tvre

	public static void main(String[] args) {

		tvre = new TvRemocon2(); // tvre 객체 생성

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

		/*
		 * tvre.channelUp(10); tvre.chMsg("채널 10 올리기");
		 * 
		 * tvre.channelDown(10); tvre.chMsg("채널 10 내리기");
		 * 
		 * tvre.volUp(5); tvre.volMsg("볼륨 5 올리기");
		 */

	}

}
