package Java_230403;

import java.text.DecimalFormat; // DecimalFormat Ŭ���� ȣ��
import java.text.SimpleDateFormat; // SimpleDateFormat Ŭ���� ȣ��
import java.util.Calendar; // Calendar Ŭ���� ȣ��

public class Java_0403_05 {

	public static void main(String[] args) {
		// ������ ���� ���
		int k23_MyWon = 1000000; // ȯ���� �ݾ�, ������ �� �ʱⰪ ����
		double k23_MoneyEx = 1238.21; // �޷� ȯ��, ������ �� �ʱⰪ ����
		double k23_commission = 0.003; // ȯ�� ������, ������ �� �ʱⰪ ����

		int k23_usd = (int) (k23_MyWon / k23_MoneyEx); // ȯ���� �޷�, ���� ����� ���������� ����� ���� ó��
		int k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx); // ���� �� = ȯ���� �ݾ� - ȯ���� �ݾ�

		// ���
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			������ ���� ��� 			*\n");
		System.out.printf("�� ȯȭȯ���ݾ�: %d�� => ��ȭ: %d�޷�, �ܵ�: %d��\n", k23_MyWon, k23_usd, k23_remain);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// ������ ���
		double k23_ComPerOne = k23_MoneyEx * k23_commission; // 1�޷� �� ������, double������ �����Ͽ� �Ҽ������� �޴´�.

		double k23_totalcom = k23_usd * k23_ComPerOne; // �� ������, �޷� * 1�޷� �� ������

		// ���
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			������ ��� 			*\n");
		System.out.printf("�� ������: %f�� => ��ȭ: %d�޷�, �޷��� ������: %f��\n", k23_totalcom, k23_usd, k23_ComPerOne);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// ������ ����ȯ��
		int k23_i_totalcom; // k23_i_totalcom ȯ�� ������ ������ ���� -> ������� �翬�� �޾ƾ� �� ���̴� �ø� ó��

		if (k23_totalcom != (double) ((int) k23_totalcom)) { // double������ ������ ����� ���� �Ҽ����� ������
			k23_i_totalcom = (int) k23_totalcom + 1; // �ø����� ó���ؾ��ϱ� ������ ������ + 1
		} else { // double������ ������ ����� ���� �Ҽ��� ���� ������ ��������
			k23_i_totalcom = (int) k23_totalcom; // ������
		}

		// ���
		System.out.printf("*********************************************************************\n"); // ���
		System.out.printf("*			������ ����ȯ�� 			*\n");
		System.out.printf("�� ������: %d�� => ��ȭ: %d�޷�, �޷��� ������: %f��\n", k23_i_totalcom, k23_usd, k23_ComPerOne);

		k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx - k23_i_totalcom); // �ܵ� = ȯ���� �ݾ� - ȯ���� �ݾ� - ȯ�� ������

		// ���
		System.out.printf("�� ��ȭȯ���ݾ�: %d�� => ��ȭ: %d�޷�, ������û��: %d��, �ܵ�: %d��\n", k23_MyWon, k23_usd, k23_i_totalcom, 
				k23_remain);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// (��Ȯ��) ������ ����ȯ��
		k23_usd = (int) (k23_MyWon / (k23_MoneyEx + k23_ComPerOne)); // ȯ���� �޷� = ȯ���� �޷� / ( �޷� ȯ�� + 1�޷� �� ������) �� ������
		k23_totalcom = k23_usd * k23_ComPerOne;

		// ������ �ø�ó��
		if (k23_totalcom != (double) ((int) k23_totalcom)) { // double������ ������ ����� ���� �Ҽ����� ������
			k23_i_totalcom = (int) k23_totalcom + 1; // �ø����� ó���ؾ��ϱ� ������ ������ + 1
		} else { // double������ ������ ����� ���� �Ҽ��� ���� ������ ��������
			k23_i_totalcom = (int) k23_totalcom; // ������
		}

		// ���
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			(��Ȯ��)������ ����ȯ�� 			*\n");
		System.out.printf("�� ������: %d�� => ��ȭ: %d�޷�, �޷��� ������: %f��\n", k23_i_totalcom, k23_usd, k23_ComPerOne);

		k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx - k23_i_totalcom); // �ܵ� = ȯ���� �ݾ� - ȯ���� �ݾ� - ȯ�� ������

		// ���
		System.out.printf("�� ��ȭȯ���ݾ�: %d�� => ��ȭ: %d�޷�, ������û��: %d��, �ܵ�: %d��\n", k23_MyWon, k23_usd, k23_i_totalcom,
				k23_remain);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// �޸����, ��¥ ����
		DecimalFormat k23_df = new DecimalFormat("###,###,###,###,###"); // DecimalFormat Ŭ������ ���Ͽ� �ν��Ͻ� ����

		// ���
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			�޸����, ��¥ ���� 			*\n");
		System.out.printf("�� ������: %s�� => ��ȭ: %s�޷�, �޷��� ������: %f��\n", k23_df.format(k23_i_totalcom),
				k23_df.format(k23_usd), k23_ComPerOne);

		k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx - k23_i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ�: %s�� => ��ȭ: %s�޷�, ������û��: %s��, �ܵ�: %s��\n", k23_df.format(k23_MyWon),
				k23_df.format(k23_usd), k23_df.format(k23_i_totalcom), k23_df.format(k23_remain));

		Calendar k23_calt = Calendar.getInstance(); // Calendar Ŭ������ ���Ͽ� �ν��Ͻ� ����
		SimpleDateFormat k23_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); // SimpleDateFormat Ŭ������ ���Ͽ� �ν��Ͻ� ����
		System.out.printf("��������ð�: %s\n", k23_sdt.format(k23_calt.getTime())); // k23_calt�� ���� �ð��� �����ͼ� k23_sdt�� ���� ������ �������� ���
		System.out.printf("*********************************************************************\n");

	}

}
