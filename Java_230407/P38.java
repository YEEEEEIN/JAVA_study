package Java_230407;

public class P38 {

	public static void main(String[] args) {
		int iPerson = 10; // 이 값을 주는 만큼 저장소 생성
		
		InputData inData = new InputData(iPerson); // 생성자의 숫자를 준 만큼 배열을 만든다.
		
		for (int i = 0; i <iPerson; i++) {
			String name = String.format("홍길%02d", i); // 이름 만들기
			int kor = (int)(Math.random()*100); // 국어점수 만들기
			int eng = (int)(Math.random()*100); // 영어점수 만들기
			int mat = (int)(Math.random()*100); // 수학점수 만들기
			inData.SetData(i, name, kor, eng, mat); // 클래스 내 값 입력

		}
		
		// 입력된 값이 잘 들어갔는지 확인
		for(int i = 0; i <iPerson; i++) {
			
			System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n",
					i, inData.name[i], inData.kor[i], inData.eng[i], inData.mat[i], inData.sum[i], inData.avg[i]);
		}

	}

}
