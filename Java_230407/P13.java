package Java_230407;

public class P13 {
	static Elevater2 elev1;
	static Elevater2 elev2;
	static Elevater2 elev3;

	public static void main(String[] args) {

		elev1 = new Elevater2();
		elev2 = new Elevater2(20, 1, 8); // �ִ���, ������, ������
		elev3 = new Elevater2(50, -3, 5); // �ִ���, ������, ������

		for (int i = 0; i < 20; i++) {
			//elev1.up(); elev1.msg("1�� ���� 1���� ������");
			//elev2.up(); elev2.msg("2�� ���� 1���� ������");
			// elev3.up(); elev3.msg("3�� ���� 1���� ������");
		}

		for (int i = 0; i < 20; i++) {
			//elev1.up(2); elev1.msg("1�� ���� 2���� ������");
			//elev2.up(2); elev2.msg("2�� ���� 2���� ������");
			// elev3.up(2); elev3.msg("3�� ���� 2���� ������");
		}

		for (int i = 0; i < 20; i++) {
			//elev1.up(3); elev1.msg("1�� ���� 3���� ������");
			// elev2.up(3); elev2.msg("2�� ���� 3���� ������");
			 elev3.up(3); elev3.msg("3�� ���� 3���� ������");
		}

	}

}
