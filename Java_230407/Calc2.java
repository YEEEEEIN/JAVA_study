package Java_230407;

public class Calc2 {
	public int sum(int a, int b, int c) { // int�� ���� 3���� �޴� sum �Լ�
		return a + b + c; // 3���� ������ ��(int��) ����
	}

	public int sum(int a, int b, int c, int d) { // int�� ���� 4���� �޴� sum �Լ�
		return a + b + c + d; // 4���� ������ ��(int��) ����
	}

	public int sum(int a, int b, int c, int d, int e) { // int�� ���� 5���� �޴� sum �Լ�
		return a + b + c + d + e; // 5���� ������ ��(int��) ����
	}

	// ���
	public double avg(int sum, int num) { // int�� ���� 5���� �޾� sum �Լ�
		return (double) sum / num; // double�� ����
	}

}
