package Java_230407;

public class InputData { // 입력 데이터 클래스
	String[] name; // String 배열 변수 선언
	int[] kor; // int 배열 변수 선언
	int[] eng; // int 배열 변수 선언
	int[] mat; // int 배열 변수 선언
	int[] sum; // int 배열 변수 선언
	double[] avg; // double 배열 변수 선언

	public InputData(int iPerson) { // int형을 인자로 받는 생성자
		name = new String[iPerson]; // 인자만큼 배열의 크기 생성
		kor = new int[iPerson]; // 인자만큼 배열의 크기 생성
		eng = new int[iPerson]; // 인자만큼 배열의 크기 생성
		mat = new int[iPerson]; // 인자만큼 배열의 크기 생성
		sum = new int[iPerson]; // 인자만큼 배열의 크기 생성
		avg = new double[iPerson]; // 인자만큼 배열의 크기 생성
	}

	public void SetData(int index, String name, int kor, int eng, int mat) { // 인자를 5개 받는 SetData 함수
		this.name[index] = name; // 인자를 (인자로 받은 index 번째 배열에 대입
		this.kor[index] = kor; // 인자를 (인자로 받은 index 번째 배열에 대입
		this.eng[index] = eng; // 인자를 (인자로 받은 index 번째 배열에 대입
		this.mat[index] = mat; // 인자를 (인자로 받은 index 번째 배열에 대입
		this.sum[index] = kor + eng + mat; // 합은 각 과목의 합
		this.avg[index] = (kor + eng + mat) / 3.0; // 평균은 각 과목의 합 /3

	}
}
