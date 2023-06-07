package Java_230407;

public class Elevater2 {
	public int limit_up_floor; // �ֻ��� ��
	public int limit_down_floor; // ������ ��
	public int floor; // ���� ��
	public String help;
	
	// ���������� �⺻ �ذ�
	Elevater2() {
		limit_up_floor = 10; // �ֻ��� ��
		limit_down_floor = 0; // ������ ��
		floor = 1; // ���� ��
		help = "���������� �⺻ �ذ��Ϸ�";

	}

	// �ִ��� ,�ּ���, �������� �־ Ŭ������ ������ �� �ֵ��� �غô�
	Elevater2(int up_floor, int d_floor, int in_floor) {
		limit_up_floor = up_floor;
		limit_down_floor = d_floor;
		floor = in_floor;
		help = "���������� ���� �ذ��Ϸ�";
	}

	void up() { // ���������Ͱ� �ö�
		if (floor == limit_up_floor) {
			help = "���������Դϴ�.";
		} else {
			floor++; // �ֻ����� �ƴ� �� �� ���� �ö�
			help = String.format("%d���Դϴ�", floor);
		}
	}

	void down() { // ���������Ͱ� ������
		if (floor == limit_down_floor) {
			help = "ó�����Դϴ�.";
		} else {
			floor--; // �������� �ƴ� �� �� ���� �ö�
			help = String.format("%d���Դϴ�", floor);
		}
	}

	// ó�� �������� �����Ѵٸ� �׸�ŭ �ö󰡵��� �غô�
	void up(int u) {
		for (int i = 0; i < u; i++) {
			this.up(); // this�� ���� ��Ȯ����
		}
	}

	// ó�� �������� �����Ѵٸ� �׸�ŭ ���������� �غô�
	void down(int u) {
		for (int i = 0; i < u; i++) {
			down(); // this�� ���� ��Ȯ����
		}
	}
	
	void msg(String id) {
		System.out.printf("%s => [%s], �ִ���[%d] �ּ���[%d] ������[%d]\n",
				id, help, limit_up_floor, limit_down_floor, floor);
	}

}
