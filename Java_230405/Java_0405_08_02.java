package Java_230405;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_0405_08_02 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // ���� ����
		LocalDateTime now = LocalDateTime.now(); // ���� �ð� ���ϱ�
		LocalDate currentDate = LocalDate.now(); // ���� ��¥ ���ϱ�
		// 14���� ���� ��¥ ���ϱ�
		LocalDate futureDate = currentDate.plusDays(14);
		// ���ϴ� �������� ��¥ ����ϱ�
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM��dd��");
		String result = futureDate.format(formatter);
		String NowTime = now.format(DateTimeFormatter.ofPattern(("yyyy.MM.dd HH:mm:ss")));

		// itemNames String�� �迭 ���� �� ����
		String[] itemNames = { "ǻ��� �����ܿ븶��ũ(�ְ����)", "�����̵�ĸ���(������)(100ȣ)", "�������� ���׸�����ũ(�˷�̴�Ÿ��)" };
		int[] itemcode = { 1031615, 11008152, 1020800 }; // itemcode int�� �迭 ���� �� ����
		int[] prices = { 3000, 1000, 1000 }; // prices int�� �迭 ���� �� ����
		int[] num = { 1, 1, 1 }; // num int�� �迭 ���� �� ����

		// ��º�
		System.out.printf("%23s\n", "\"���ΰ���, ���̼�\""); // ���� ���

		System.out.printf("(��)�Ƽ����̼�_�д缭����\n"); // ���� ���
		System.out.printf("��ȭ:031-702-6016\n"); // ���� ���
		System.out.printf("����:���� ������ ���μ�ȯ�� 2748 (���)\n"); // ���� ���
		System.out.printf("��ǥ:������,��ȣ�� 213-81-52063\n"); // ���� ���
		System.out.printf("����:��⵵ ������ �д籸 �д��53���� 11 (������)\n"); // ���� ���

		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // ���
		System.out.printf("%24s\n", "�Һ����߽ɰ濵(CCM) �������"); // ���� ���
		System.out.printf("%26s\n", "ISIO 9001 ǰ���濵�ý��� �������"); // ���� ���
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // ���� ���
		System.out.printf("%6s��ȯ/ȯ�� 14��(%s)�̳�,\n", "", result); // 14�� ���� MM��dd�� ���
		System.out.printf("(����)������. ����ī�� ���� �� ���Ը��忡�� ����\n"); // ���� ���
		System.out.printf("%23s\n", "����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�"); // ���� ���
		System.out.printf("%23s\n", "üũī�� ��� �� �ִ� 7�� �ҿ�"); // ���� ���
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // ���
		System.out.printf("[PDS 1058231] %27s\n", NowTime); // ����-�ð� ���
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // ���� ���

		int sum = 0; // �Һ��ڰ��� int�� ����, �ʱⰪ ����

		// ǰ�� ��º�
		for (int i = 0; i < itemNames.length; i++) { // i�� 0���� itemNames�迭�� ���� ������ 1�� ����
			String cc = cutString(itemNames[i], 20); // cutString �Լ��� ����� itemNames[i]�� �߶� String cc�� ����
			System.out.printf("%s%8s%3d%10s\n", cc, df.format(prices[i]), num[i], df.format(prices[i] * num[i])); // ǰ��,
																													// ����,
																													// ��,
																													// ��
																													// ���
			System.out.printf("[%d]\n", itemcode[i]); // �ڵ��ȣ ���

			sum += num[i] * prices[i]; // �Һ��ڰ� ����
		}

		// ���� 10 �ۼ�Ʈ
		double vatRate = 0.1; // �ΰ����� 0.1 ����

		// �����հ�
		double calTax = sum / (vatRate + 1.0); // �Һ��ڰ� / 1.1�� double�� �����հ迡 ����
		// ����� �� double������ ���� ����ؼ� �Ҽ����� �ս��� �����ش�
		// ��������ȯ �� ��� �Ҽ����� �սǵǾ� ������� ������ ��Ÿ�� ���� ����

		// �ΰ���
		double vatprice = calTax * vatRate; // double�� �����հ� * double�� �ΰ������� double�� �ΰ����� ����
		int ivatprice = (int) Math.ceil(vatprice); // �ΰ����� �׻� ���� �޾ƾ��ϱ� ������ �ø�ó�� �� ������ ��ȯ�Ͽ� ����

		// ������հ�
		int realCalTax = sum - ivatprice; // �� �����հ� = �Һ��ڰ� - �ΰ���

		System.out.printf("%19s%18s\n", "�����հ�", df.format(realCalTax)); // �����հ� ���
		System.out.printf("%20s%18s\n", "�ΰ���", df.format(ivatprice)); // �ΰ��� ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // ���
		System.out.printf("%s%33s\n", "�Ǹ��հ�", df.format(sum)); // �Һ��ڰ� �� ���
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // ���
		System.out.printf("%s%33s\n", "�ſ�ī��", df.format(sum)); // �Һ��ڰ� �� ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // ���
		System.out.printf("%s%33s\n", "�츮ī��", "538720**********"); // ���� ���
		System.out.printf("%s%17s\n", "���ι�ȣ 77982843(0)", "���αݾ� " + df.format(sum)); // �Һ��ڰ� �� ���
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%25s �д缭����\n", NowTime); // ����ð� ���
		System.out.printf("��ǰ �� ��Ÿ ���� : 1522-4400\n"); // ���� ���
		System.out.printf("����� �� �����̼� ���� ���� : 1599-2211\n"); // ���� ���
		System.out.printf("%28s\n", "2112820610158231"); // ���� ���

		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // ���
		System.out.printf("�´��̼� ����� �� �Ǵ� Ȩ�������� �����ϼż�\n"); // ���
		System.out.printf("  ȸ������ �� �پ��� ������ ����������! ��\n"); // ���

	}

	public static String cutString(String str, int len) {
		// ���ڿ�(str)�� �Է¹޾�
		// ���̰� 14 �����̸� �����ʿ� ������ ä���� 14�ڷ� ������ְ�,
		// 14�ڸ� �ʰ��ϸ� ���ڿ��� �߶� ��ȯ���ִ� ���
		byte[] by = str.getBytes(); // ���ڿ��� byte �迭�� ��ȯ�մϴ�.
		if (by.length <= 21) { // ���� ���ڿ��� ���̰� 14 �����̸�
			str = new String(by, 0, by.length); // ����Ʈ �迭(by)�� ���ڿ�(str)�� ��ȯ
			for (int i = by.length; i < 21; i++) { // ���̰� 14�� �ǵ���
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
