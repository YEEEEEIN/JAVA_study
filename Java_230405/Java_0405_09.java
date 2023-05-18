package Java_230405;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Java_0405_09 {
	
	public static String[] itemNames = { "����׽� 500g X 2��", "(G)LH�����̾���������ȭ��", "����Ĩ ���ڸ������̸�����E", "���Ϸ� ���縻(������ �ȳ���!)",
			"����Ȩ SAFE �ڵ����", "��� �Ŷ��120g*5", "(��)����������", "���ѱ� ������� 156g", "GAP ����� ������ 4-6��", "�� ����� �ٳ����� ����",
			"����ũ ź�θ� �߰�����", "BHC �Ѹ�Ŭ�� �������", "DZ�ִϾ�縻3��C_BK", "�����̾� ������� ��������ʹ�", "1+��޶� 10���� Ư",
			"(���޴���)����߰���(200g*5)", "LG ����Ʈ ��Ÿ�Ϸ�2023", "������ݺ�����������ġ��ȹ", "CJ ����Ĩ 200G", "���� ���� ��ũƼ 20����",
			"����ũ ����̿���", "���ѱ� ��� ����׽� 500g X 2��", "�ٿ�� �ʰ���� ���������� 4L (���� ȭ��ƮƼ�� ���� ��)", "�轺Ų ������ �ܰ��� ���ں� 192g",
			" LG���� �뵹�� ��Ź��", "����� ���� ��ġġ����Ϻ�ħ��~", "��귣�� ������κ�300g*2��", "������ �ູ�̿� ���������ġ10kg", "�̸��� 10kg_����",
			"���ֻ�ټ� �׸� 2L 6��" }; // itemNames String�� �迭 ���� �� ����
	
	public static int[] price = { 1872, 8250, 2400, 12600, 15400, 6400, 18500, 4600, 24500, 6510, 22000, 3100, 23000, 24620, 6400,
			12000, 215640, 1007800, 3450, 156600, 610, 7320, 21270, 10800, 372495, 2450, 3280, 48900, 29900, 6480 }; 
	// price int�� �迭 ���� �� ����
	public static int[] num = { 6, 1, 3, 4, 2, 2, 1, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 2, 2, 1, 1, 1, 1, 10, 1, 1, 1, 2, 1, 1 };
	// num int���迭 ���� �� ����
																												
	public static boolean[] taxFree = { true, true, false, false, false, true, true, false, true, false, false, false, false,
			true, false, true, false, false, true, false, false, true, true, false, false, false, true, false,
			false, true }; // taxFree boolean�� �迭 ���� �� ����

	// ���� ��� (�翬�� ������ǰ��)
	public static int netprice(int price, double rate) { // ������ �Һ��ڰ�, ������ ������ ������ ������ǰ���� ���
		return (int) (price / (1 + rate)); // �Һ��ڰ�/ (1+����)�� ���������� �޾� �Ҽ��� �ڸ� ����
											// -> ������ǰ�� ���� ��� -> �ΰ��� ���� ����ϱ� ����
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����
		Calendar cal2 = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����
		Date date = new Date(); // Date Ŭ������ ���� �ν��Ͻ� ����
		cal2.setTime(date); // ���� ��¥�� ����
		cal2.add(Calendar.HOUR, -2); // �ð��� 2�ð� ���� ����

		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // ����ð� ��� ���� ����
		SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyyMMdd"); // ����ð� ��� ���� ����
		SimpleDateFormat dateFormatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ����ð� ��� ���� ����
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // �� ���� ���� ����

		String[] itemNames = { "����׽� 500g X 2��", "(G)LH�����̾���������ȭ��", "����Ĩ ���ڸ������̸�����E", "���Ϸ� ���縻(������ �ȳ���!)",
				"����Ȩ SAFE �ڵ����", "��� �Ŷ��120g*5", "(��)����������", "���ѱ� ������� 156g", "GAP ����� ������ 4-6��", "�� ����� �ٳ����� ����",
				"����ũ ź�θ� �߰�����", "BHC �Ѹ�Ŭ�� �������", "DZ�ִϾ�縻3��C_BK", "�����̾� ������� ��������ʹ�", "1+��޶� 10���� Ư",
				"(���޴���)����߰���(200g*5)", "LG ����Ʈ ��Ÿ�Ϸ�2023", "������ݺ�����������ġ��ȹ", "CJ ����Ĩ 200G", "���� ���� ��ũƼ 20����",
				"����ũ ����̿���", "���ѱ� ��� ����׽� 500g X 2��", "�ٿ�� �ʰ���� ���������� 4L (���� ȭ��ƮƼ�� ���� ��)", "�轺Ų ������ �ܰ��� ���ں� 192g",
				" LG���� �뵹�� ��Ź��", "����� ���� ��ġġ����Ϻ�ħ��~", "��귣�� ������κ�300g*2��", "������ �ູ�̿� ���������ġ10kg", "�̸��� 10kg_����",
				"���ֻ�ټ� �׸� 2L 6��" }; // itemNames String�� �迭 ���� �� ����
		
		int[] price = { 1872, 8250, 2400, 12600, 15400, 6400, 18500, 4600, 24500, 6510, 22000, 3100, 23000, 24620, 6400,
				12000, 215640, 1007800, 3450, 156600, 610, 7320, 21270, 10800, 372495, 2450, 3280, 48900, 29900, 6480 }; 
		// price int�� �迭 ���� �� ����
		int[] num = { 6, 1, 3, 4, 2, 2, 1, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 2, 2, 1, 1, 1, 1, 10, 1, 1, 1, 2, 1, 1 };
		// num int���迭 ���� �� ����
																													
		boolean[] taxFree = { true, true, false, false, false, true, true, false, true, false, false, false, false,
				true, false, true, false, false, true, false, false, true, true, false, false, false, true, false,
				false, true }; // taxFree boolean�� �迭 ���� �� ����

		int taxFreePrice = 0; // �鼼 ��ǰ �Һ��ڰ�
		int taxPrice = 0; // ���� ��ǰ �Һ��ڰ�(�ΰ��� ����)
		int total_price = 0; // ��ü �Һ��ڰ� = �鼼 ��ǰ �Һ��ڰ� + ���� ��ǰ �Һ��ڰ�
		double vatRate = 0.1; // ������

		// ������ ��º�
		System.out.printf("%13s�̸�Ʈ ������ (031)888-1234\n", ""); // ������ ���� ���
		System.out.printf("%13s206-86-50913 ����\n", ""); // ������ ���� ���
		System.out.printf("%s", "emart"); // ������ ���� ���
		System.out.printf("%8s���� ������ ������� 552\n", ""); // ������ ���� ���
		System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�\n"); // ������ ���� ���
		System.out.printf("�����ǰ�� ����, 30�� �̳�(�ż� 7��)\n"); // ������ ���� ���
		System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n"); // ������ ���� ���
		System.out.printf("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n\n"); // ������ ���� ���
		System.out.printf("[����]%s%19s\n", dateFormatter1.format(cal.getTime()), "POS:0011-9861"); // ���� �ð� ���Ŀ� �°� ���
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("%7s%11s%6s%9s", "�� ǰ ��", "��  ��", "����", "��  ��\n"); // ������ ���� ���

		// ǰ�� ��º�
		for (int i = 0; i < itemNames.length; i++) { // i�� 0���� itemNames�迭�� ���� ������ 1�� ����
			String cc = cutString(itemNames[i], 14); // cutString �Լ��� ����� itemNames[i]�� �߶� String cc�� ����

			if (i % 5 == 0) { // i ������ 5�� �������� 0�̸� (5������ ���м� ��µǰ� �Ϸ���)
				System.out.printf("-----------------------------------------\n"); // ���м� ���
			}

			if (taxFree[i] == true) { // �鼼
				System.out.printf("* %s%11s%3d%11s\n", cc, df.format(price[i]), num[i], df.format(price[i] * num[i]));
				// ǰ��, ����, ��, �� ���
				taxFreePrice += num[i] * price[i]; // �鼼 ��ǰ �Һ��ڰ� ����

			} else { // ����
				System.out.printf("  %s%11s%3d%11s\n", cc, df.format(price[i]), num[i], df.format(price[i] * num[i]));
				// ǰ��, ����, ��, �� ���
				taxPrice += num[i] * price[i]; // ������ǰ �Һ��ڰ� ����(�ΰ��� ����)
			}

			total_price = taxFreePrice + taxPrice; // �� �鼼 ��ǰ �Һ��ڰ� + �� ������ǰ �Һ��ڰ�
		}

		int netprice = netprice(taxPrice, vatRate); // ������ǰ
		int vatPrice = taxPrice - netprice; // �ΰ���
		int point = 5473; // ���� ����Ʈ
		int plusPoint = (int) (total_price * 0.001); // ������ ����Ʈ

		System.out.printf("\n%15s�� ǰ�� ���� %13d\n", "", itemNames.length); // ǰ�� ���� ���
		System.out.printf("%11s (*)�� ��  �� ǰ %13s\n", "", df.format(taxFreePrice)); // �鼼 ��ǰ �Һ��ڰ� ���
		System.out.printf("%15s�� ��  �� ǰ %13s\n", "", df.format(netprice)); // ������ǰ �Һ��ڰ� ���
		System.out.printf("%15s��   ��   �� %13s\n", "", df.format(vatPrice)); // �ΰ��� ���
		System.out.printf("%15s��        �� %13s\n", "", df.format(total_price)); // �Һ��ڰ� �� �� ���
		System.out.printf("�� �� �� �� �� �� %23s\n", df.format(total_price)); // �Һ��ڰ� �� �� ���
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("0012 KEB �ϳ�       541707**0484/35860658\n"); // ���� ���
		System.out.printf("ī�����(IC)           �Ͻú� /%10s\n", df.format(total_price)); // �Һ��ڰ� �� �� ���
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("           [�ż�������Ʈ ����]\n"); // ���
		System.out.printf("ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n"); // ���
		System.out.printf("��ȸ�߻�����Ʈ      9350**9995 %10s\n", df.format(plusPoint)); // ������ ����Ʈ ���
		System.out.printf("����(����)����Ʈ   %10s(%10s)      \n", df.format(point + plusPoint), df.format(point)); // ������
																												// ����Ʈ+����
																												// ����Ʈ,
																												// ����
																												// ����Ʈ
																												// ���
		System.out.printf("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n"); // ���
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("   ���űݾױ��� ���������ð� �ڵ��ο�   \n"); // ���
		System.out.printf("������ȣ :                       34��****\n"); // ���
		System.out.printf("�����ð� :            %s\n", dateFormatter3.format(cal2.getTime())); // ����ð� 2�ð� �� ���
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("ĳ��:084599 ��00                     1150\n"); // ���
		System.out.println("\n"); // ����
		System.out.printf("      %s/00119861/00164980/31\n", dateFormatter2.format(cal.getTime())); // ����ð� ���

	}

	public static String cutString(String str, int len) {
		// ���ڿ�(str)�� �Է¹޾�
		// ���̰� 14 �����̸� �����ʿ� ������ ä���� 14�ڷ� ������ְ�,
		// 14�ڸ� �ʰ��ϸ� ���ڿ��� �߶� ��ȯ���ִ� ���
		byte[] by = str.getBytes(); // ���ڿ��� byte �迭�� ��ȯ�մϴ�.
		if (by.length <= 14) { // ���� ���ڿ��� ���̰� 14 �����̸�
			str = new String(by, 0, by.length); // ����Ʈ �迭(by)�� ���ڿ�(str)�� ��ȯ
			for (int i = by.length; i < 14; i++) { // ���̰� 14�� �ǵ���
				str = str + " "; // ���ڿ� �ڿ� ������ �߰�
			}
			return str; // �� ����� ��ȯ
		} else { // ���� ���ڿ��� ���̰� 14���� ũ��
			int count = 0; // count �ʱ�ȭ
			try {
				for (int i = 0; i < len; i++) { // ����Ʈ �迭�� ����(len)��ŭ �ݺ��� ����
					if ((by[i] & 0x80) == 0x80) // ����Ʈ�� �ֻ��� ��Ʈ�� 1���� Ȯ��
						count++; // count 1 ����(�ٽ��ڵ�)
				}
				if ((by[len - 1] & 0x80) == 0x80 && (count % 2) == 1) { // ����Ʈ �迭�� ������ ����Ʈ�� �ֻ��� ��Ʈ�� 1�̰� count�� Ȧ���� ���
					len--; // ����Ʈ �迭�� ����(len)�� 1 ����(�ٽ��ڵ�)
					String str1 = new String(by, 0, len) + " "; // ���ο� ���ڿ� ����
					return str1;// ���ο� ���ڿ� ��ȯ
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) { // ���� ó��
				System.out.println(e);
				return "";
			}
			String str2 = new String(by, 0, len); // ����Ʈ �迭 ��ü�� ���ڿ��� ��ȯ
			return str2; // ���ڿ� ��ȯ
		}
	}
}
