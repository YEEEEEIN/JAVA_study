package Java_230407;

public class P08 {
	
	private static int inVal;
	
	public static void up() {
		inVal++;
		System.out.printf("난 그냥 메소드[%d]\n", inVal);
	}

	public static void main(String[] args) {
		inVal = 0; // 자기 내부 변수 사용
		
		Elevater elev; // 클래스를 받아 객체를 만듦
		elev = new Elevater(); // 인스턴스를 생성하여 객체에 연결
		
		up(); // 난 그냥 현재 소스 내 메소드
		
		for(int i = 0; i <10; i++) {
			elev.up(); // 난 엘리베이터 클래스를 찍어낸 elev 객체(인스턴스를 가지고 있음)의 up()메소드
			
			System.out.printf("MSG[%s]\n", elev.help);
		}
		
		for(int i = 0; i <10; i++) {
			elev.down(); // 난 엘리베이터 클래스를 찍어낸 elev 객체(인스턴스를 가지고 있음)의 down()메소드
			
			System.out.printf("MSG[%s]\n", elev.help);
		}
		

	}

}
