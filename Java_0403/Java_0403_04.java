package Java_0403;

public class Java_0403_04 {

	public static void main(String[] args) {
		String[] k23_item = { "������", "���Ͻ�", "�Ե�����", "����", "��극" }; // k23_item ���� ���ڿ� �迭 �� �ʱⰪ ����
		int[] k23_price = { 1000, 2000, 3000, 2500, 1450 }; // k23_item ���� ���ڿ� �迭 �� �ʱⰪ ����
		int[] k23_amount = { 10, 2, 1, 3, 5 }; // k23_amount ���� ������ �迭 �� �ʱⰪ ����
		double k23_tax_rate = 0.1; // k23_tax_rate ���� ������ �� �ʱⰪ ����
		int k23_total_sum = 0; // k23_total_sum ���� ������ �� �ʱⰪ ����
		//
		System.out.printf("*************************************************\n");
		System.out.printf("*\t\t   �ʰ� �� ���ڵ�   \t\t*\n");
		System.out.printf("    �� ��          �� ��     �� ��\t    �� ��\n");
		System.out.printf("*************************************************\n");
		for (int k23_i = 0; k23_i < k23_item.length; k23_i++) { // k23_item.length = 5, i(0 ~ 4) �ݺ�
			int k23_sum = k23_price[k23_i] * k23_amount[k23_i]; // ���� ���� * ����
			k23_total_sum = k23_total_sum + k23_sum; // ���� = ���� ����
			System.out.printf("%5s  \t%7d\t\t%2d\t%9d\n", k23_item[k23_i], k23_price[k23_i], k23_amount[k23_i], k23_sum); // �� ������ �̸�, ����, ����, �� ���																									
		}
		System.out.printf("*************************************************\n");
		System.out.printf(" ���� �ݾ� :\t\t%25d\n", k23_total_sum);

		int k23_total_net_price = (int) (k23_total_sum / (1 + k23_tax_rate)); // �� �����ݾ� = ���� �ݾ� * 1.1 
		System.out.printf(" ���� �ݾ� :\t\t%25d\n", k23_total_net_price); 
		int k23_tax = k23_total_sum - k23_total_net_price; // ���� = ���ұݾ� - �����ݾ�
		System.out.printf(" ���� :\t\t%33d\n", k23_tax);

	}

}
