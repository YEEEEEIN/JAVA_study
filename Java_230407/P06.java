package Java_230407;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P06 {

	// ���� ��� (�翬�� ������ǰ��)
	public static int k23_netprice(int k23_price, double k23_rate) { // ������ �Һ��ڰ�, ������ ������ ������ ������ǰ���� ���
		return (int) (k23_price / (1 + k23_rate)); // �Һ��ڰ�/ (1+����)�� ���������� �޾� �Ҽ��� �ڸ� ����
											// -> ������ǰ�� ���� ��� -> �ΰ��� ���� ����ϱ� ����
	}

	public static Calendar k23_cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����
	public static Calendar k23_cal2 = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����

	public static SimpleDateFormat k23_dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // ����ð� ��� ���� ����
	public static SimpleDateFormat k23_dateFormatter2 = new SimpleDateFormat("yyyyMMdd"); // ����ð� ��� ���� ����
	public static SimpleDateFormat k23_dateFormatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ����ð� ��� ���� ����

	public static DecimalFormat k23_df = new DecimalFormat("###,###,###,###"); // �� ���� ���� ����

	public static String[] k23_itemNames = { "���� �׽� 500g X 2��", "(G)LH�����̾���������ȭ��", "����Ĩ ���ڸ������̸�����E", "���Ϸ� ���縻(������ �ȳ���!)",
			"����Ȩ SAFE �ڵ����", "��� �Ŷ��120g*5", "(��)����������", "���ѱ� ������� 156g", "GAP ����� ������ 4-6��", "�� ����� �ٳ����� ����",
			"����ũ ź�θ� �߰�����", "BHC �Ѹ�Ŭ�� �������", "DZ�ִϾ�縻3��C_BK", "�����̾� ������� ��������ʹ�", "1+��޶� 10���� Ư", "(���޴���)����߰���(200g*5)",
			"LG ����Ʈ ��Ÿ�Ϸ�2023", "������ݺ�����������ġ��ȹ", "CJ ����Ĩ 200G", "���� ���� ��ũƼ 20����", "����ũ ����̿���", "���ѱ� ��� ����׽� 500g X 2��",
			"�ٿ�� �ʰ���� ���������� 4L (���� ȭ��ƮƼ�� ���� ��)", "�轺Ų ������ �ܰ��� ���ں� 192g", "LG���� �뵹�� ��Ź��", "����� ���� ��ġġ����Ϻ�ħ��~",
			"��귣�� ������κ�300g*2��", "������ �ູ�̿� ���������ġ10kg", "�̸��� 10kg_����", "���ֻ�ټ� �׸� 2L 6��" }; // itemNames String�� �迭 ����
																								// �� ����

	public static int[] k23_price = { 1872, 8250, 2400, 12600, 15400, 6400, 18500, 4600, 24500, 6510, 22000, 3100, 23000,
			24620, 6400, 12000, 215640, 1007800, 3450, 156600, 610, 7320, 21270, 10800, 372495, 2450, 3280, 48900,
			29900, 6480 };
	// price int�� �迭 ���� �� ����
	public static int[] k23_num = { 6, 1, 3, 4, 2, 2, 1, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 2, 2, 1, 1, 1, 1, 10, 1, 1, 1, 2, 1,
			1 };
	// num int���迭 ���� �� ����

	public static boolean[] k23_taxFree = { true, true, false, false, false, true, true, false, true, false, false, false,
			false, true, false, true, false, false, true, false, false, true, true, false, false, false, true, false,
			false, true }; // taxFree boolean�� �迭 ���� �� ����
	;

	public static int k23_taxFreePrice = 0; // �鼼 ��ǰ �Һ��ڰ�
	public static int k23_taxPrice = 0; // ���� ��ǰ �Һ��ڰ�(�ΰ��� ����)
	public static int k23_total_price = 0; // ��ü �Һ��ڰ� = �鼼 ��ǰ �Һ��ڰ� + ���� ��ǰ �Һ��ڰ�
	public static double k23_vatRate = 0.1; // ������
	public static int k23_netprice = k23_netprice(k23_taxPrice, k23_vatRate); // ������ǰ
	public static int k23_vatPrice = k23_taxPrice - k23_netprice; // �ΰ���

	public static void main(String[] args) {
		k23_TitlePrint(); // ������ �� �� Ÿ��Ʋ �μ�
		k23_timeStamp(); // ���� �ð� �μ�
		k23_HeaderPrint(); // ���(��ǰ��, �ܰ�, ����, �ݾ�) �μ�
		k23_itemPrint(); // ǰ�� �μ�
		k23_result(); // ��� ��� �μ�
		k23_card(); // ī�� ���� �μ�
		k23_point(); // ����Ʈ ���� �μ�
		k23_parking(); // ���� ���� �μ�
		k23_casher(); // ĳ�� ���� �μ�
		k23_barcode(); // ���ڵ� �μ�

	}

	public static int k23_itemCount(String[] k23_itemNames) { // �׸��� �����
		int k23_itemCount = k23_itemNames.length;

		return k23_itemCount;

	}

	public static void k23_TitlePrint() { // ������ �� �� Ÿ��Ʋ �μ�
		System.out.printf("%13s�̸�Ʈ ������ (031)888-1234\n", ""); // ������ ���� ���
		System.out.printf("%13s206-86-50913 ����\n", ""); // ������ ���� ���
		System.out.printf("%s", "emart"); // ������ ���� ���
		System.out.printf("%8s���� ������ ������� 552\n", ""); // ������ ���� ���
		System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�\n"); // ������ ���� ���
		System.out.printf("�����ǰ�� ����, 30�� �̳�(�ż� 7��)\n"); // ������ ���� ���
		System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n"); // ������ ���� ���
		System.out.printf("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n\n"); // ������ ���� ���

	}

	public static void k23_timeStamp() { // ��½ð� �μ�
		String k23_timeStamp = k23_dateFormatter1.format(k23_cal.getTime());
		System.out.printf("[����]%s%19s\n", k23_timeStamp, "POS:0011-9861"); // ���� �ð� ���Ŀ� �°� ���
		System.out.printf("-----------------------------------------\n"); // ���

	}

	public static void k23_HeaderPrint() { // ���(��ǰ��, �ܰ�, ����, �ݾ�) �μ�
		System.out.printf("%7s%11s%6s%9s", "�� ǰ ��", "��  ��", "����", "��  ��\n"); // ������ ���� ���
	}

	public static void k23_itemPrint() { // ǰ�� �μ�
		for (int k23_i = 0; k23_i < k23_itemNames.length; k23_i++) { // i�� 0���� itemNames�迭�� ���� ������ 1�� ����
			String k23_cc = k23_cutString(k23_itemNames[k23_i], 14); // cutString �Լ��� ����� itemNames[i]�� �߶� String cc�� ����

			if (k23_i % 5 == 0) { // i ������ 5�� �������� 0�̸� (5������ ���м� ��µǰ� �Ϸ���)
				System.out.printf("-----------------------------------------\n"); // ���м� ���
			}

			if (k23_taxFree[k23_i] == true) { // �鼼
				System.out.printf("* ");
				System.out.printf("%s%11s%3d%11s\n", k23_cc, k23_df.format(k23_price[k23_i]), k23_num[k23_i], k23_df.format(k23_price[k23_i] * k23_num[k23_i]));
				// ǰ��, ����, ��, �� ���
				k23_taxFreePrice += k23_num[k23_i] * k23_price[k23_i]; // �鼼 ��ǰ �Һ��ڰ� ����

			} else { // ����
				System.out.printf("  ");
				System.out.printf("%s%11s%3d%11s\n", k23_cc, k23_df.format(k23_price[k23_i]), k23_num[k23_i], k23_df.format(k23_price[k23_i] * k23_num[k23_i]));
				// ǰ��, ����, ��, �� ���
				k23_taxPrice += k23_num[k23_i] * k23_price[k23_i]; // ������ǰ �Һ��ڰ� ����(�ΰ��� ����)
			}

			k23_total_price = k23_taxFreePrice + k23_taxPrice; // �� �鼼 ��ǰ �Һ��ڰ� + �� ������ǰ �Һ��ڰ�
		}
	}

	public static void k23_result() { // ��� ���
		System.out.printf("\n%15s�� ǰ�� ���� %13d\n", "", k23_itemCount(k23_itemNames)); // ǰ�� ���� ���
		System.out.printf("%11s (*)�� ��  �� ǰ %13s\n", "", k23_df.format(k23_taxFreePrice)); // �鼼 ��ǰ �Һ��ڰ� ���
		System.out.printf("%15s�� ��  �� ǰ %13s\n", "", k23_df.format(k23_netprice)); // ������ǰ �Һ��ڰ� ���
		System.out.printf("%15s��   ��   �� %13s\n", "", k23_df.format(k23_vatPrice)); // �ΰ��� ���
		System.out.printf("%15s��        �� %13s\n", "", k23_df.format(k23_total_price)); // �Һ��ڰ� �� �� ���
		System.out.printf("�� �� �� �� �� �� %23s\n", k23_df.format(k23_total_price)); // �Һ��ڰ� �� �� ���
	}

	public static void k23_card() { // ī�� ���� �μ�
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("0012 KEB �ϳ�       541707**0484/35860658\n"); // ���� ���
		System.out.printf("ī�����(IC)           �Ͻú� /%10s\n", k23_df.format(k23_total_price)); // �Һ��ڰ� �� �� ���
	}

	public static void k23_point() { // ����Ʈ ���� �μ�
		int k23_point = 5473; // ���� ����Ʈ
		int k23_plusPoint = (int) (k23_total_price * 0.001); // ������ ����Ʈ
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("           [�ż�������Ʈ ����]\n"); // ���
		System.out.printf("ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n"); // ���
		System.out.printf("��ȸ�߻�����Ʈ      9350**9995 %10s\n", k23_df.format(k23_plusPoint)); // ������ ����Ʈ ���
		System.out.printf("����(����)����Ʈ   %10s(%10s)      \n", k23_df.format(k23_point + k23_plusPoint), k23_df.format(k23_point)); // ������
		System.out.printf("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n"); // ���
	}

	public static void k23_parking() { // ���� ���� �μ�
		System.out.printf("-----------------------------------------\n"); // ���
		k23_cal2.add(Calendar.HOUR, -2); // �ð��� 2�ð� ���� ����
		System.out.printf("   ���űݾױ��� ���������ð� �ڵ��ο�   \n"); // ���
		System.out.printf("������ȣ :                       34��****\n"); // ���
		System.out.printf("�����ð� :            %s\n", k23_dateFormatter3.format(k23_cal2.getTime())); // ����ð� 2�ð� �� ���
	}

	public static void k23_casher() { // ĳ�� ���� �μ�
		System.out.printf("-----------------------------------------\n"); // ���
		System.out.printf("ĳ��:084599 ��00                     1150\n"); // ���
	}

	public static void k23_barcode() { // ���ڵ� �μ�
		System.out.printf("\n      %s/00119861/00164980/31\n", k23_dateFormatter2.format(k23_cal.getTime())); // ����ð� ���
	}

	public static String k23_cutString(String k23_str, int k23_len) {
		// ���ڿ�(str)�� �Է¹޾�
		// ���̰� 14 �����̸� �����ʿ� ������ ä���� 14�ڷ� ������ְ�,
		// 14�ڸ� �ʰ��ϸ� ���ڿ��� �߶� ��ȯ���ִ� ���
		byte[] k23_by = k23_str.getBytes(); // ���ڿ��� byte �迭�� ��ȯ�մϴ�.
		if (k23_by.length <= 14) { // ���� ���ڿ��� ���̰� 14 �����̸�
			k23_str = new String(k23_by, 0, k23_by.length); // ����Ʈ �迭(by)�� ���ڿ�(str)�� ��ȯ
			for (int k23_i = k23_by.length; k23_i < 14; k23_i++) { // ���̰� 14�� �ǵ���
				k23_str = k23_str + " "; // ���ڿ� �ڿ� ������ �߰�
			}
			return k23_str; // �� ����� ��ȯ
		} else { // ���� ���ڿ��� ���̰� 14���� ũ��
			int k23_count = 0; // count �ʱ�ȭ
			try {
				for (int k23_i = 0; k23_i < k23_len; k23_i++) { // ����Ʈ �迭�� ����(len)��ŭ �ݺ��� ����
					if ((k23_by[k23_i] & 0x80) == 0x80) // ����Ʈ�� �ֻ��� ��Ʈ�� 1���� Ȯ��
						k23_count++; // count 1 ����(�ٽ��ڵ�)
				}
				if ((k23_by[k23_len - 1] & 0x80) == 0x80 && (k23_count % 2) == 1) { // ����Ʈ �迭�� ������ ����Ʈ�� �ֻ��� ��Ʈ�� 1�̰� count�� Ȧ���� ���
					k23_len--; // ����Ʈ �迭�� ����(len)�� 1 ����(�ٽ��ڵ�)
					String str1 = new String(k23_by, 0, k23_len) + " "; // ���ο� ���ڿ� ����
					return str1;// ���ο� ���ڿ� ��ȯ
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) { // ���� ó��
				System.out.println(e);
				return "";
			}
			String k23_str2 = new String(k23_by, 0, k23_len); // ����Ʈ �迭 ��ü�� ���ڿ��� ��ȯ
			return k23_str2; // ���ڿ� ��ȯ
		}
	}

}
