package Java_230410;

import java.util.Scanner; // Scanner ����ϱ� ���� �߰�

public class Java_0403_01 {

	public static void main(String[] args) {


		
/*
//PPT15
		String k23_s = "12345"; // ���� k23_s�� ���ڿ� ����� ���ÿ� 12345�� �ʱ�ȭ
		int k23_i = Integer.parseInt(k23_s); // ���ڿ� k23_s�� ���ڸ� ���������� �ٲ�
		
		System.out.printf("���ڸ� ���ڷ� %d	(%d)\n", k23_i, k23_i + 10); // 12345 + 10 = 12355

		String k23_a; // ���ڿ� k23_a ���� 
		k23_a = String.format("%d", k23_i); // ������ k23_i�� ���ڿ��� �ٲ��ش�
		
		System.out.printf("���ڸ� ���ڷ� %s (%s)\n", k23_a, k23_a + "abcde"); // "12345" + "abcde" = "12345abcde"
*/

		
		
		
		
/*
//PPT17
		int k23_year = 0; // k23_year��� ������ ������ �����ϰ� 0���� �ʱ�ȭ
		int k23_age = 14; // k23_age��� ������ ������ �����ϰ� 14�� �ʱ�ȭ
		
		System.out.println("��� 1:" + k23_year); // k23_year������ ȭ�鿡 ���
		System.out.println("��� 2:" + k23_age); // k23_age������ ȭ�鿡 ���
		
		k23_year = k23_age + 2000; // ���� k23_age�� ���� 2000�� ���ؼ� ���� k23_year�� ����
		k23_age = k23_age + 1; // ���� k23_age�� ����� ���� 1������Ų��.
		
		System.out.println("��� 3:" + k23_year); // �ٽ� k23_year������ ȭ�鿡 ���
		System.out.println("��� 4:" + k23_age); // �ٽ� k23_age������ ȭ�鿡 ���
*/

		
		
		

/*
//ppt 18
		int k23_year = 0; // k23_year��� ������ ������ �����ϰ� 0���� �ʱ�ȭ
		int k23_age = 14; // k23_age��� ������ ������ �����ϰ� 14�� �ʱ�ȭ
		
		System.out.println("��� 1:" + k23_year); // k23_year������ ȭ�鿡 ���
		System.out.println("��� 2:" + k23_age); // k23_age������ ȭ�鿡 ���
		
		k23_year = k23_age + 2000;
		k23_age = k23_age + 1;
		
		System.out.println(k23_year);
		System.out.println(k23_age);
*/
		

		
		
/*		
//ppt19
		int k23_x = 10; //k23_x��� ������ ������ �����ϰ� 10���� �ʱ�ȭ 
		int k23_y = 20; //k23_y��� ������ ������ �����ϰ� 20���� �ʱ�ȭ
		int k23_tmp = 0; //k23_tmp��� ������ ������ �����ϰ� 0���� �ʱ�ȭ
		
		System.out.println("X:" + k23_x + ", Y:" + k23_y); // k21_x, k21_y ������ ȭ�鿡 ���
		
		k23_tmp = k23_x; // ���� k21_x�� ���� ���� k21_tmp�� ����
		k23_x = k23_y; // ���� k21_y�� ���� ���� k21_x�� ����
		k23_y = k23_tmp; // ���� k21_tmp�� ���� ���� k21_y�� ����
		
		System.out.println("X:" + k23_x + ", Y:" + k23_y); // k21_x, k21_y ������ ȭ�鿡 ���
*/		
		


		
/*		
//ppt20
		String k23_name = "Ja" + "va"; // k23_name��� ���ڿ� ������ �����ϰ� "Ja" + "va"�� �ʱ�ȭ
		String k23_str = k23_name + 8.0; // k23_str��� ���ڿ� ������ �����ϰ� k23_name + 8.0�� �ʱ�ȭ
		
		System.out.println(k23_name); // ���ڿ��� ���� �ٿ��� ���
		System.out.println(k23_str); // ���ڿ��� ������ �յ� �ٿ��� ���
		System.out.println(7 + " "); // 7 + ���� ���
		System.out.println(" " + 7); // ���� + 7 ���
		System.out.println(7 + ""); // 7 ���
		System.out.println("" + 7); // 7 ���
		System.out.println("" + ""); // ���� ���
		System.out.println(7 + 7 + ""); // 14 + ����
		System.out.println("" + 7 + 7); // ���ڿ��� �տ� ���� ��� �ڿ� ������ ����, ���� �ٿ��� ���
*/		

		
		

/*
//ppt21
		System.out.println('\''); // \'�� ����Ͽ� ��������ǥ ���
		System.out.println("abc\t123\b456"); // \b�� ���� 3�� ��������
		System.out.println('\n'); // ���๮�� ����ϰ� ����
		System.out.println("\"Hello\""); // \"�� ����Ͽ� ū����ǥ ��� 
		System.out.println("c:\\"); // \\�� ����Ͽ� \ ���
*/

		
		
		

//ppt22
		Scanner k23_sc = new Scanner(System.in); // Scanner Ŭ������ �ν��Ͻ� ����
		
		System.out.print("�� �ڸ� ������ �ϳ� �Է����ּ���.>"); // ���
		
		String k23_input = k23_sc.nextLine(); // ���� k23_input�� ���ڿ��� �Է� ����
		int k23_num = Integer.parseInt(k23_input); // ���� k23_input ���ڿ����� ���������� ��ȯ�Ͽ� k23_num�� ����
		
		System.out.println("�Է� ���� :" + k23_input); // k23_input������ ȭ�鿡 ���
		System.out.printf("num = %d\n", k23_num); // k23_num������ ȭ�鿡 ���
		


		
		
/*
//ppt23
		byte k23_b = 1; // k23_b��� byte ������ �����ϰ� 1���� �ʱ�ȭ 
		short k23_s = 2; // k23_s��� short ������ �����ϰ� 2���� �ʱ�ȭ 
		char k23_c = 'A'; // k23_c��� char ������ �����ϰ� 'A'���� �ʱ�ȭ 
		
		int k23_finger = 10; // k23_finger��� int ������ �����ϰ� 10���� �ʱ�ȭ 
		long k23_big = 1000000000000L; // k23_big��� long ������ �����ϰ� 1000000000000L���� �ʱ�ȭ
		long k23_hex = 0xFFFFFFFL; // k23_hex��� long ������ �����ϰ� 0xFFFFFFFL���� �ʱ�ȭ
		
		int k23_octNum = 010; // 8���� 10, 10�����δ� 8 
		int k23_hexNum = 0x10; // 16���� 10, 10�����δ� 16 
		int k23_binNum = 0b10; // 2���� 10, 10�����δ� 2  
		
		System.out.printf("B = %d%n", k23_b); // k23_b������ ȭ�鿡 ���
		System.out.printf("S = %d%n", k23_s); // k23_s������ ȭ�鿡 ���  
		System.out.printf("C = %c, %d %n", k23_c, (int)k23_c); // k23_c, (int)k23_c������ ȭ�鿡 ���
		System.out.printf("Finger = [%5d]%n", k23_finger); // k23_finge ������ �� 5ĭ �� ���� ȭ�鿡 ���
		System.out.printf("Finger = [%-5d]%n", k23_finger); // k23_finge ������ �� 5ĭ �� ���� ȭ�鿡 ���
		System.out.printf("Finger = [%05d]%n", k23_finger); // k23_finge ������ 5ĭ �� ���� ȭ�鿡, �������� 0 ��� 
		System.out.printf("Big = %d%n", k23_big); // k23_big������ ȭ�鿡 ���
		System.out.printf("Hex = %#x%n", k23_hex); // '#'�� ���λ� (16���� 0x, 8���� 0)
		System.out.printf("OctNum = %o, %d%n", k23_octNum, k23_octNum); // %o�� 8����
		System.out.printf("HexNum = %x, %d%n", k23_hexNum, k23_hexNum); // %x�� 16����
		System.out.printf("BinNum = %s, %d%n", Integer.toBinaryString(k23_binNum), k23_binNum); // ���� k23_binNum�� ���ڿ��� ������ ���
*/


/*
//ppt24
		String k23_Url = "www.codechobo.com"; // k23_b��� ���ڿ��� �����ϰ� "www.codechobo.com"���� �ʱ�ȭ
		
		float k23_f1 = .10f; // k23_f1��� float ������ �����ϰ� 0.10���� �ʱ�ȭ
		float k23_f2 = 1e1f; // k23_f2��� float ������ �����ϰ� 1e1f���� �ʱ�ȭ 
		float k23_f3 = 3.14e3f; // k23_f13��� float ������ �����ϰ�  3.14e3f���� �ʱ�ȭ
		double k23_d = 1.23456789; // k23_d��� double ������ �����ϰ� 1.23456789���� �ʱ�ȭ
		
		System.out.printf("f1 = %f, %e, %g%n", k23_f1, k23_f1, k23_f1); // %e: ���� ǥ������ �������� ���
		System.out.printf("f2 = %f, %e, %g%n", k23_f2, k23_f2, k23_f2); // %g: �Ҽ��� ���� �ڸ����� ���� �Ǵ� �ε��Ҽ������� ���, 
		System.out.printf("f3 = %f, %e, %g%n", k23_f3, k23_f3, k23_f3); //     �ڸ����� ª�� ���� �������� �����ؼ� ���
		
		System.out.printf("d = %f%n", k23_d); // k23_d ������ ȭ�鿡 ���
		System.out.printf("d = %%14.10f%n", k23_d); // %% -> % ���
		
		System.out.printf("[12345678901234567890]%n"); // [12345678901234567890]�� ȭ�鿡 ���
		System.out.printf("[%s]%n", k23_Url); // k23_Ur ������ ȭ�鿡 ���
		System.out.printf("[%20s]%n", k23_Url); // k23_Url ������ 20ũ�� ��ŭ ������ ȭ�鿡 ���
		System.out.printf("[%-20s]%n",k23_Url); // k23_Url ������ 20ũ�� ��ŭ ���� ȭ�鿡 ���
		System.out.printf("[%.8s]%n", k23_Url); // k23_Url ������ 8ũ�� ��ŭ ȭ�鿡 ���
*/				
		
		
		
		
/*		
//PPT25
		short k23_sMin = -32768; // k23_sMin��� short ������ �����ϰ� -32768���� �ʱ�ȭ
		short k23_sMax = 32767; // k23_sMax��� short ������ �����ϰ� 32768���� �ʱ�ȭ
		char k23_cMin = 0; // k23_cMin��� short ������ �����ϰ� 0���� �ʱ�ȭ
		char k23_cMax = 65535; // k23_cMax��� short ������ �����ϰ� 65535���� �ʱ�ȭ
		
		System.out.println("k23_sMin  = " + k23_sMin); // k23_sMin ������ ȭ�鿡 ���
		System.out.println("k23_sMin-1= " + (short)(k23_sMin-1)); // k23_sMin ������ -1 �� ��(underflow) short�� ����ȯ �Ͽ� ȭ�鿡 ���
		System.out.println("k23_sMax = " + k23_sMax); // k23_d ������ ȭ�鿡 ���
		System.out.println("k23_sMax+1= " + (short)(k23_sMax+1)); // k23_sMax ������ +1 �� ��(overflow) short�� ����ȯ �Ͽ� ȭ�鿡 ���
		System.out.println("k23_cMin  = " + (int)k23_cMin); // k23_cMin ������ int�� ����ȯ �Ͽ� ȭ�鿡 ���
		System.out.println("k23_cMin-1= " + (int)--k23_cMin); // char ������ �ִ� ���
		System.out.println("k23_cMax  = " + (int)k23_cMax); // k23_cMax ������ int�� ����ȯ �Ͽ� ȭ�鿡 ���
		System.out.println("k23_cMax+1= " + (int)++k23_cMax); // char ������ �ּڰ� ���
*/		
		
		
		
		
/*	
//PPT26
		double k23_d = 85.4; //k23_d��� double ������ �����ϰ� 85.4���� �ʱ�ȭ
		int k23_score = (int)k23_d; // k23_d�� double������ ���� ����ȯ �� k23_score ���� -> �Ҽ��� �Ʒ� ����
		
		System.out.println("k23_score=" + k23_score); // k23_score ������ ȭ�鿡 ���
		System.out.println("k23_d=" + k23_d); // k23_d ������ ȭ�鿡 ���
*/
		
		

		
		
		/*
//PPT 27
		int k23_i = 10; // k23_i��� int ������ �����ϰ� 10���� �ʱ�ȭ
		byte k23_b = (byte) k23_i; // k23_i������ byte�� ���� ����ȯ �� k23_b�� ����
		System.out.printf("[int -> byte] i=%d -> b=%d\n", k23_i, k23_b); //k23_i, k23_b ���� ���

		k23_i = 300; // k23_i�� 300���� �ʱ�ȭ
		k23_b = (byte) k23_i; // k23_i������ byte�� ���� ����ȯ �� k23_b�� ���� 
		System.out.printf("[int -> byte] i=%d -> b=%d\n", k23_i,k23_b); //k23_i, k23_b ���� ���

		k23_b = 10; // k23_b�� 10���� �ʱ�ȭ
		k23_i = (int) k23_b; // k23_b������ int�� ���� ����ȯ �� k23_i�� ����
		System.out.printf("[byte -> int] i=%d -> b=%d\n", k23_b, k23_i); //k23_i, k23_b ���� ���

		k23_b = -2; // k23_b�� -2���� �ʱ�ȭ
		k23_i = (int) k23_b; // k23_b������ int�� ���� ����ȯ �� k23_i�� ����
		System.out.printf("[byte -> int] i=%d -> b=%d\n", k23_b, k23_i); //k23_i, k23_b ���� ���

		System.out.println("i=" + Integer.toBinaryString(k23_i)); //k23_i�� ���ڿ��� ��ȯ�� �� ���
*/		
		
		
		
		
		
/*
//PPT28
		 float  k23_f = 9.1234567f; // k23_f��� float ������ �����ϰ� 9.1234567f���� �ʱ�ȭ
		 double  k23_d = 9.1234567; // k23_d��� double ������ �����ϰ� 9.1234567���� �ʱ�ȭ
		 double  k23_d2 = (double) k23_f; // k23_f�� double������ ���� ����ȯ �� k23_d2�� ����
		  
		 System.out.printf("f =%20.18f\n",  k23_f); // k23_f ���� �Ҽ� 18��° ¥������ 20ũ�� ��ŭ ȭ�鿡 ���
		 System.out.printf("d =%20.18f\n",  k23_d); // k23_d ���� �Ҽ� 18��° ¥������ 20ũ�� ��ŭ ȭ�鿡 ���
		 System.out.printf("d2 =%20.18f\n",  k23_d2); // k23_d2 ���� �Ҽ� 18��° ¥������ 20ũ�� ��ŭ ȭ�鿡 ���
*/
		
		
/*
//PPT29
		int k23_i = 31234567; //k23_i��� int ������ �����ϰ� 31234567���� �ʱ�ȭ
		float k23_f = (float) k23_i; // k23_i�� float������ ���� ����ȯ �� k23_f�� ����
		int k23_i2 = (int) k23_f; // k23_f�� int������ ���� ����ȯ �� k23_i2�� ����
		
		double k23_d = (double) k23_i; // k23_i�� double������ ���� ����ȯ �� k23_d2�� ����
		int k23_i3 = (int) k23_d; // k23_d�� int������ ���� ����ȯ �� k23_i3�� ����
		
		float k23_f2 = 1.666f; //k23_f2��� float ������ �����ϰ� 1.666���� �ʱ�ȭ
		int k23_i4 = (int) k23_f2; // k23_f2�� int������ ���� ����ȯ �� k23_i4�� ����
		
		System.out.printf("i=%d\n", k23_i); // k23_i ������ ȭ�鿡 ���
		System.out.printf("f=%f i2=%d\n", k23_f, k23_i2); // k23_f, k23_i2 ������ ȭ�鿡 ���
		System.out.printf("d=%f i3=%d\n", k23_d, k23_i3); // k23_d, k23_i3 ������ ȭ�鿡 ���
		System.out.printf("(int)%f=&d\n", k23_f2, k23_i4); // k23_f2, k23_i4 ������ ȭ�鿡 ���
*/
	}
	

}
