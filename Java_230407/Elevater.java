package Java_230407;

public class Elevater {
	int limit_up_floor = 10; // �ֻ��� ��
	int limit_down_floor = 0; // ������ ��
	int floor = 1; // ���� ��
	String help;

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

}
