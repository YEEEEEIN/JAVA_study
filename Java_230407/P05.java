package Java_230407;

public class P05 {
	static int iStatic; // 클래스내 전역 변수 static에 주의-
	
	public static void add(int i) {
		iStatic++;
		i++;
		System.out.printf("add메소드에서->iStatic=[%d]\n",iStatic);
		System.out.printf("add메소드에서->i=[%d]\n",i);
	}
	
	public static int add2(int i) {
		iStatic++;
		i++;
		System.out.printf("add메소드에서->iStatic=[%d]\n",iStatic);
		System.out.printf("add메소드에서->i=[%d]\n",i);
		return i;
	}

	public static void main(String[] args) {
		int iMain;
		
		iMain = 1;
		iStatic = 1;
		
		System.out.printf("**************************\n");
		System.out.printf("메소드호출 전 메인에서->iStaitc=[%d]\n",iStatic);
		System.out.printf("메소드호출 전 메인에서->iMain=[%d]\n",iMain);
		System.out.printf("**************************\n");
		
		add(iMain);
		
		System.out.printf("**************************\n");
		System.out.printf("메소드호출 후 메인에서->iStaitc=[%d]\n",iStatic);
		System.out.printf("메소드호출 후 메인에서->iMain=[%d]\n",iMain);
		System.out.printf("**************************\n");
		
		iMain = add2(iMain); // 이런식으로 값을 전달하고 받는 방법이 이해하기 쉬움
							// 전역변수로 선언 후 이함수... 아니 메소드 저메서드에서 변경해 버리면
							// 도대체 어떻게 로직이 되었는지 알아보기 어렵다
		
		System.out.printf("**************************\n");
		System.out.printf("메소드호출 후 메인에서->iStaitc=[%d]\n",iStatic);
		System.out.printf("메소드호출 후 메인에서->iMain=[%d]\n",iMain);
		System.out.printf("**************************\n");
		
		
	}

}
