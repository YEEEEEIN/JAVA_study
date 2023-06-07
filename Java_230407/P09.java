package Java_230407;

public class P09 {

	public static void main(String[] args) {
		TvRemocon k23_tvre = new TvRemocon();
		// 채널 10올리고, 10내리고
		System.out.printf("채널 10올리고, 10내리고\n"); // 출력

		for (int k23_i = 0; k23_i < 10; k23_i++) { // 채널 10 올리기 위해 10번 반복
			k23_tvre.k23_ChannelUp(); // 난 TvRemocon 클래스를 찍어낸 tvre 객체(인스턴스를 가지고 있음)의 ChannelUp()메소드

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help);
		}

		for (int k23_i = 0; k23_i < 10; k23_i++) { // 채널 10 내리기 위해 10번 반복
			k23_tvre.k23_ChannelDown(); // 난 TvRemocon 클래스를 찍어낸 tvre 객체(인스턴스를 가지고 있음)의 ChannelDown()메소드

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help); // tvre 객체의 help에 담긴 메세지 출력
		}

		// 볼륨 5올리고, 5내리고
		System.out.printf("\n볼륨 5올리고, 5내리고\n"); // 출력
		for (int k23_i = 0; k23_i < 5; k23_i++) { // 볼륨 5 올리기 위해 5번 반복
			k23_tvre.k23_VolUp(); // 난 TvRemocon 클래스를 찍어낸 tvre 객체(인스턴스를 가지고 있음)의 VolUp()메소드

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help); // tvre 객체의 help에 담긴 메세지 출력
		}

		for (int k23_i = 0; k23_i < 5; k23_i++) { // 볼륨 5 내리기 위해 5번 반복
			k23_tvre.k23_VolDown(); // 난 TvRemocon 클래스를 찍어낸 tvre 객체(인스턴스를 가지고 있음)의 VolDown()메소드

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help); // tvre 객체의 help에 담긴 메세지 출력
		}

	}

}
