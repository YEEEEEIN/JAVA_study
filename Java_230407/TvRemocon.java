package Java_230407;

public class TvRemocon {
	int k23_limit_up_vol = 5; // �ִ� ����
	int k23_limit_down_vol = 0; // �ּ� ����

	int k23_limit_up_channel = 10; // �ִ� ä��
	int k23_limit_down_channel = 0; // ���� ä��

	int k23_vol = 1; // ���� ����
	int k23_channel = 1; // ���� ä��
	String k23_help; // �޼��� ����

	void k23_VolUp() { // ������ �ö󰡴� �Լ�
		if (k23_vol == k23_limit_up_vol) { // �ִ� ������ ��
			k23_help = "�ִ� �����Դϴ�."; // �޼��� ���� ����
		} else { // �ִ뺼���� �ƴ� ��
			k23_vol++; // 1�� �ö�
			k23_help = String.format("���� %d �Դϴ�", k23_vol); // �޼��� ���� ����
		}
	}

	void k23_VolDown() { // ������ �������� �Լ�
		if (k23_vol == k23_limit_down_vol) { // ���� ������ ��
			k23_help = "�ּ� �ҷ��Դϴ�."; // �޼��� ���� ����
		} else { // ���� ������ �ƴ� ��
			k23_vol--; // 1�� �ö�
			k23_help = String.format("���� %d �Դϴ�", k23_vol); // �޼��� ���� ����
		}
	}

	void k23_ChannelUp() { // ä���� �ö󰡴� �Լ�
		if (k23_channel == k23_limit_up_channel) { // �ִ� ä���� ��
			k23_help = "������ ä���Դϴ�."; // �޼��� ���� ����
		} else { // �ִ� ä���� �ƴ� ��
			k23_channel++; // 1�� �ö�
			k23_help = String.format("ä�� %d �Դϴ�", k23_channel); // �޼��� ���� ����
		}
	}

	void k23_ChannelDown() { // ä���� �������� �Լ�
		if (k23_channel == k23_limit_down_channel) { // ���� ä���� ��
			k23_help = "ó�� ä���Դϴ�."; // �޼��� ���� ����
		} else { // ���� ä���� �ƴ� ��
			k23_channel--; // ó�� ä���� �ƴҶ� 1�� �ö�
			k23_help = String.format("ä�� %d �Դϴ�", k23_channel); // �޼��� ���� ����
		}
	}
}
