package Java_230410;

import java.util.Scanner; // Scanner 사용하기 위해 추가

public class Java_0403_01 {

	public static void main(String[] args) {


		
/*
//PPT15
		String k23_s = "12345"; // 변수 k23_s를 문자열 선언과 동시에 12345로 초기화
		int k23_i = Integer.parseInt(k23_s); // 문자열 k23_s의 숫자를 정수형으로 바꿈
		
		System.out.printf("문자를 숫자로 %d	(%d)\n", k23_i, k23_i + 10); // 12345 + 10 = 12355

		String k23_a; // 문자열 k23_a 선언 
		k23_a = String.format("%d", k23_i); // 정수형 k23_i를 문자열로 바꿔준다
		
		System.out.printf("숫자를 문자로 %s (%s)\n", k23_a, k23_a + "abcde"); // "12345" + "abcde" = "12345abcde"
*/

		
		
		
		
/*
//PPT17
		int k23_year = 0; // k23_year라는 숫자형 변수를 정의하고 0으로 초기화
		int k23_age = 14; // k23_age라는 숫자형 변수를 정의하고 14로 초기화
		
		System.out.println("결과 1:" + k23_year); // k23_year변수를 화면에 출력
		System.out.println("결과 2:" + k23_age); // k23_age변수를 화면에 출력
		
		k23_year = k23_age + 2000; // 변수 k23_age의 값에 2000을 더해서 변수 k23_year에 저장
		k23_age = k23_age + 1; // 변수 k23_age에 저장된 값을 1증가시킨다.
		
		System.out.println("결과 3:" + k23_year); // 다시 k23_year변수를 화면에 출력
		System.out.println("결과 4:" + k23_age); // 다시 k23_age변수를 화면에 출력
*/

		
		
		

/*
//ppt 18
		int k23_year = 0; // k23_year라는 숫자형 변수를 정의하고 0으로 초기화
		int k23_age = 14; // k23_age라는 숫자형 변수를 정의하고 14로 초기화
		
		System.out.println("결과 1:" + k23_year); // k23_year변수를 화면에 출력
		System.out.println("결과 2:" + k23_age); // k23_age변수를 화면에 출력
		
		k23_year = k23_age + 2000;
		k23_age = k23_age + 1;
		
		System.out.println(k23_year);
		System.out.println(k23_age);
*/
		

		
		
/*		
//ppt19
		int k23_x = 10; //k23_x라는 숫자형 변수를 정의하고 10으로 초기화 
		int k23_y = 20; //k23_y라는 숫자형 변수를 정의하고 20으로 초기화
		int k23_tmp = 0; //k23_tmp라는 숫자형 변수를 정의하고 0으로 초기화
		
		System.out.println("X:" + k23_x + ", Y:" + k23_y); // k21_x, k21_y 변수를 화면에 출력
		
		k23_tmp = k23_x; // 변수 k21_x의 값을 변수 k21_tmp에 저장
		k23_x = k23_y; // 변수 k21_y의 값을 변수 k21_x에 저장
		k23_y = k23_tmp; // 변수 k21_tmp의 값을 변수 k21_y에 저장
		
		System.out.println("X:" + k23_x + ", Y:" + k23_y); // k21_x, k21_y 변수를 화면에 출력
*/		
		


		
/*		
//ppt20
		String k23_name = "Ja" + "va"; // k23_name라는 문자열 변수를 선언하고 "Ja" + "va"로 초기화
		String k23_str = k23_name + 8.0; // k23_str라는 문자열 변수를 선언하고 k23_name + 8.0로 초기화
		
		System.out.println(k23_name); // 문자열의 합은 붙여서 출력
		System.out.println(k23_str); // 문자열과 숫자의 합도 붙여서 출력
		System.out.println(7 + " "); // 7 + 공백 출력
		System.out.println(" " + 7); // 공백 + 7 출력
		System.out.println(7 + ""); // 7 출력
		System.out.println("" + 7); // 7 출력
		System.out.println("" + ""); // 공백 출력
		System.out.println(7 + 7 + ""); // 14 + 공백
		System.out.println("" + 7 + 7); // 문자열이 앞에 있을 경우 뒤에 나오는 문자, 숫자 붙여서 출력
*/		

		
		

/*
//ppt21
		System.out.println('\''); // \'을 사용하여 작은따옴표 출력
		System.out.println("abc\t123\b456"); // \b에 의해 3이 지워진다
		System.out.println('\n'); // 개행문자 출력하고 개행
		System.out.println("\"Hello\""); // \"을 사용하여 큰따옴표 출력 
		System.out.println("c:\\"); // \\을 사용하여 \ 출력
*/

		
		
		

//ppt22
		Scanner k23_sc = new Scanner(System.in); // Scanner 클래스의 인스턴스 생성
		
		System.out.print("두 자리 정수를 하나 입력해주세요.>"); // 출력
		
		String k23_input = k23_sc.nextLine(); // 변수 k23_input에 문자열을 입력 받음
		int k23_num = Integer.parseInt(k23_input); // 변수 k23_input 문자열에서 정수형으로 변환하여 k23_num에 저장
		
		System.out.println("입력 내용 :" + k23_input); // k23_input변수를 화면에 출력
		System.out.printf("num = %d\n", k23_num); // k23_num변수를 화면에 출력
		


		
		
/*
//ppt23
		byte k23_b = 1; // k23_b라는 byte 변수를 정의하고 1으로 초기화 
		short k23_s = 2; // k23_s라는 short 변수를 정의하고 2으로 초기화 
		char k23_c = 'A'; // k23_c라는 char 변수를 정의하고 'A'으로 초기화 
		
		int k23_finger = 10; // k23_finger라는 int 변수를 정의하고 10으로 초기화 
		long k23_big = 1000000000000L; // k23_big라는 long 변수를 정의하고 1000000000000L으로 초기화
		long k23_hex = 0xFFFFFFFL; // k23_hex라는 long 변수를 정의하고 0xFFFFFFFL으로 초기화
		
		int k23_octNum = 010; // 8진수 10, 10진수로는 8 
		int k23_hexNum = 0x10; // 16진수 10, 10진수로는 16 
		int k23_binNum = 0b10; // 2진수 10, 10진수로는 2  
		
		System.out.printf("B = %d%n", k23_b); // k23_b변수를 화면에 출력
		System.out.printf("S = %d%n", k23_s); // k23_s변수를 화면에 출력  
		System.out.printf("C = %c, %d %n", k23_c, (int)k23_c); // k23_c, (int)k23_c변수를 화면에 출력
		System.out.printf("Finger = [%5d]%n", k23_finger); // k23_finge 변수를 총 5칸 중 뒤쪽 화면에 출력
		System.out.printf("Finger = [%-5d]%n", k23_finger); // k23_finge 변수를 총 5칸 중 앞쪽 화면에 출력
		System.out.printf("Finger = [%05d]%n", k23_finger); // k23_finge 변수를 5칸 중 뒤쪽 화면에, 나머지는 0 출력 
		System.out.printf("Big = %d%n", k23_big); // k23_big변수를 화면에 출력
		System.out.printf("Hex = %#x%n", k23_hex); // '#'은 접두사 (16진수 0x, 8진수 0)
		System.out.printf("OctNum = %o, %d%n", k23_octNum, k23_octNum); // %o는 8진법
		System.out.printf("HexNum = %x, %d%n", k23_hexNum, k23_hexNum); // %x는 16진법
		System.out.printf("BinNum = %s, %d%n", Integer.toBinaryString(k23_binNum), k23_binNum); // 변수 k23_binNum의 문자열과 정수형 출력
*/


/*
//ppt24
		String k23_Url = "www.codechobo.com"; // k23_b라는 문자열로 정의하고 "www.codechobo.com"으로 초기화
		
		float k23_f1 = .10f; // k23_f1라는 float 변수를 정의하고 0.10으로 초기화
		float k23_f2 = 1e1f; // k23_f2라는 float 변수를 정의하고 1e1f으로 초기화 
		float k23_f3 = 3.14e3f; // k23_f13라는 float 변수를 정의하고  3.14e3f으로 초기화
		double k23_d = 1.23456789; // k23_d라는 double 변수를 정의하고 1.23456789으로 초기화
		
		System.out.printf("f1 = %f, %e, %g%n", k23_f1, k23_f1, k23_f1); // %e: 지수 표현식의 형식으로 출력
		System.out.printf("f2 = %f, %e, %g%n", k23_f2, k23_f2, k23_f2); // %g: 소수점 이하 자리수가 고정 또는 부동소수점으로 출력, 
		System.out.printf("f3 = %f, %e, %g%n", k23_f3, k23_f3, k23_f3); //     자리수가 짧은 것을 기준으로 선택해서 출력
		
		System.out.printf("d = %f%n", k23_d); // k23_d 변수를 화면에 출력
		System.out.printf("d = %%14.10f%n", k23_d); // %% -> % 출력
		
		System.out.printf("[12345678901234567890]%n"); // [12345678901234567890]를 화면에 출력
		System.out.printf("[%s]%n", k23_Url); // k23_Ur 변수를 화면에 출력
		System.out.printf("[%20s]%n", k23_Url); // k23_Url 변수를 20크기 만큼 오른쪽 화면에 출력
		System.out.printf("[%-20s]%n",k23_Url); // k23_Url 변수를 20크기 만큼 왼쪽 화면에 출력
		System.out.printf("[%.8s]%n", k23_Url); // k23_Url 변수를 8크기 만큼 화면에 출력
*/				
		
		
		
		
/*		
//PPT25
		short k23_sMin = -32768; // k23_sMin라는 short 변수를 정의하고 -32768으로 초기화
		short k23_sMax = 32767; // k23_sMax라는 short 변수를 정의하고 32768으로 초기화
		char k23_cMin = 0; // k23_cMin라는 short 변수를 정의하고 0으로 초기화
		char k23_cMax = 65535; // k23_cMax라는 short 변수를 정의하고 65535으로 초기화
		
		System.out.println("k23_sMin  = " + k23_sMin); // k23_sMin 변수를 화면에 출력
		System.out.println("k23_sMin-1= " + (short)(k23_sMin-1)); // k23_sMin 변수를 -1 한 후(underflow) short로 형변환 하여 화면에 출력
		System.out.println("k23_sMax = " + k23_sMax); // k23_d 변수를 화면에 출력
		System.out.println("k23_sMax+1= " + (short)(k23_sMax+1)); // k23_sMax 변수를 +1 한 후(overflow) short로 형변환 하여 화면에 출력
		System.out.println("k23_cMin  = " + (int)k23_cMin); // k23_cMin 변수를 int로 형변환 하여 화면에 출력
		System.out.println("k23_cMin-1= " + (int)--k23_cMin); // char 범위의 최댓값 출력
		System.out.println("k23_cMax  = " + (int)k23_cMax); // k23_cMax 변수를 int로 형변환 하여 화면에 출력
		System.out.println("k23_cMax+1= " + (int)++k23_cMax); // char 범위의 최솟값 출력
*/		
		
		
		
		
/*	
//PPT26
		double k23_d = 85.4; //k23_d라는 double 변수를 정의하고 85.4으로 초기화
		int k23_score = (int)k23_d; // k23_d를 double형으로 강제 형변환 후 k23_score 대입 -> 소수점 아래 버림
		
		System.out.println("k23_score=" + k23_score); // k23_score 변수를 화면에 출력
		System.out.println("k23_d=" + k23_d); // k23_d 변수를 화면에 출력
*/
		
		

		
		
		/*
//PPT 27
		int k23_i = 10; // k23_i라는 int 변수를 정의하고 10으로 초기화
		byte k23_b = (byte) k23_i; // k23_i변수를 byte로 강제 형변환 후 k23_b에 대입
		System.out.printf("[int -> byte] i=%d -> b=%d\n", k23_i, k23_b); //k23_i, k23_b 변수 출력

		k23_i = 300; // k23_i를 300으로 초기화
		k23_b = (byte) k23_i; // k23_i변수를 byte로 강제 형변환 후 k23_b에 대입 
		System.out.printf("[int -> byte] i=%d -> b=%d\n", k23_i,k23_b); //k23_i, k23_b 변수 출력

		k23_b = 10; // k23_b를 10으로 초기화
		k23_i = (int) k23_b; // k23_b변수를 int로 강제 형변환 후 k23_i에 대입
		System.out.printf("[byte -> int] i=%d -> b=%d\n", k23_b, k23_i); //k23_i, k23_b 변수 출력

		k23_b = -2; // k23_b를 -2으로 초기화
		k23_i = (int) k23_b; // k23_b변수를 int로 강제 형변환 후 k23_i에 대입
		System.out.printf("[byte -> int] i=%d -> b=%d\n", k23_b, k23_i); //k23_i, k23_b 변수 출력

		System.out.println("i=" + Integer.toBinaryString(k23_i)); //k23_i를 문자열로 변환한 값 출력
*/		
		
		
		
		
		
/*
//PPT28
		 float  k23_f = 9.1234567f; // k23_f라는 float 변수를 정의하고 9.1234567f으로 초기화
		 double  k23_d = 9.1234567; // k23_d라는 double 변수를 정의하고 9.1234567으로 초기화
		 double  k23_d2 = (double) k23_f; // k23_f를 double형으로 강제 형변환 후 k23_d2에 대입
		  
		 System.out.printf("f =%20.18f\n",  k23_f); // k23_f 변수 소수 18번째 짜리까지 20크기 만큼 화면에 출력
		 System.out.printf("d =%20.18f\n",  k23_d); // k23_d 변수 소수 18번째 짜리까지 20크기 만큼 화면에 출력
		 System.out.printf("d2 =%20.18f\n",  k23_d2); // k23_d2 변수 소수 18번째 짜리까지 20크기 만큼 화면에 출력
*/
		
		
/*
//PPT29
		int k23_i = 31234567; //k23_i라는 int 변수를 정의하고 31234567으로 초기화
		float k23_f = (float) k23_i; // k23_i를 float형으로 강제 형변환 후 k23_f에 대입
		int k23_i2 = (int) k23_f; // k23_f를 int형으로 강제 형변환 후 k23_i2에 대입
		
		double k23_d = (double) k23_i; // k23_i를 double형으로 강제 형변환 후 k23_d2에 대입
		int k23_i3 = (int) k23_d; // k23_d를 int형으로 강제 형변환 후 k23_i3에 대입
		
		float k23_f2 = 1.666f; //k23_f2라는 float 변수를 정의하고 1.666으로 초기화
		int k23_i4 = (int) k23_f2; // k23_f2를 int형으로 강제 형변환 후 k23_i4에 대입
		
		System.out.printf("i=%d\n", k23_i); // k23_i 변수를 화면에 출력
		System.out.printf("f=%f i2=%d\n", k23_f, k23_i2); // k23_f, k23_i2 변수를 화면에 출력
		System.out.printf("d=%f i3=%d\n", k23_d, k23_i3); // k23_d, k23_i3 변수를 화면에 출력
		System.out.printf("(int)%f=&d\n", k23_f2, k23_i4); // k23_f2, k23_i4 변수를 화면에 출력
*/
	}
	

}
