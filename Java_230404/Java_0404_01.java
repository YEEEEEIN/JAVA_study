package Java_230404;

public class Java_0404_01 {

	public static void main(String[] args) {
		String k23_jumin = "123456-1234567"; // ���� k23_jumin�� String ����, �ʱⰪ ����
		
		switch(k23_jumin.charAt(8)) { // switch case��
			case '1' : // k23_jumin.charAt(8)�� 1�� ��
				System.out.printf("20���� �� �¾ ���� ���\n"); // ���
			case '2' : // k23_jumin.charAt(8)�� 2�� ��
				System.out.printf("20���� �� �¾ ���� ���\n"); // ���
			case '3' : // k23_jumin.charAt(8)�� 3�� ��
				System.out.printf("20���� �� �¾ ���� ���\n"); // ���
			case '4' : // k23_jumin.charAt(8)�� 4�� ��
				System.out.printf("20���� �� �¾ ���� ���\n"); // ���
			default : // k23_jumin.charAt(8)�� 1~4�� �ƴ� ��
				System.out.printf("���\n"); // ���
				break; // switch���� �������´�
		}

	}

}
