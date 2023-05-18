package Java_0404;

import java.text.DecimalFormat;

public class Java_0404_17 {

	public static void main(String[] args) {
		// ĭ ���߱� ����

		String k23_item = "���"; // ���� k23_item�� String ����, �ʱ�ȭ
		int k23_unit_price = 5000; // ���� k23_unit_price�� int ����, �ʱ�ȭ
		int k23_num = 500; // ���� k23_num�� int ����, �ʱ�ȭ
		int k23_total = 0; // ���� k23_total�� int ����, �ʱ�ȭ

		DecimalFormat k23_df = new DecimalFormat("###,###,###,###,###");
		// DecimalFormat Ŭ������ ���� �ν��Ͻ� ����, ���� �־���

		// �ش� ���
		System.out.printf("========================================================\n");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "ǰ��", "�ܰ�", "����", "�հ�");
		// %20.20s : ���ڿ� ����� ���� ����������
		// �� 20�� ����� �ʵ��� ��, �� 20�� ����� ������ �ִ� ����
		System.out.printf("========================================================\n");

		// �� ���
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n", k23_item, k23_df.format(k23_unit_price),
				k23_df.format(k23_num), k23_df.format(k23_unit_price * k23_num));
		// ǰ��, �ܰ�, ����, �հ� ���
	}

}
