package Java_230407;

public class TvRemocon2 {
	public int limit_up_vol; // �ִ� ����
	public int limit_down_vol; // �ּ� ����
	public int vol; // ���� ����
	public String volHelp; // �޼���

	public int limit_up_channel; // �ִ� ä��
	public int limit_down_channel; // �ּ� ä��
	public int channel; // ���� ä��
	public String chHelp; // ä�� �޼���
	
	public String help; // �޼���
	

	TvRemocon2() { // �⺻ ����, ä�� ����
		limit_up_vol = 5; // �ִ� ���� 10 ����
		limit_down_vol = 0; // �ּ� ���� 0 ����
		vol = 1; // ���� ����
		volHelp = "�⺻ ���� 1"; // ���� ��

		limit_up_channel = 10; // �ִ� ä��
		limit_down_channel = 0; // �ּ� ä��
		channel = 1; // ���� ä��
		chHelp = "�⺻ ä�� 1"; // ���� ��

	}

	void volUp() { // ������ �ö�
		if (vol == limit_up_vol) { // ������ �ִ� ������ ���ٸ�
			volHelp = "�ִ� �����Դϴ�."; // �޼��� ���� ����
		} else { // �ִ뺼���� �ƴ� ��
			vol++; // 1�� �ö�
			volHelp = String.format("���� %d �Դϴ�", vol); // ���� ���� �� volHelp�� ����
		}
	}

	void volDown() { // ������ ������
		if (vol == limit_down_vol) { // ���� ������ ��
			volHelp = "�ּ� �ҷ��Դϴ�."; // �޼��� ���� ����
		} else { // ���� ������ �ƴ� ��
			vol--; // 1�� ������
			volHelp = String.format("���� %d �Դϴ�", vol); // ���� ���� �� volHelp�� ����
		}
	}

	// �ø� ������ ũ�⸦ �����ؼ� �׸�ŭ �ö󰡵��� �Ѵ�
	void volUp(int u) { // ũ�⸦ ���ڷ� �޴� volUp �Լ�
		for (int i = 0; i < u; i++) { // ���ڰ� ��ŭ �ݺ�
			this.volUp(); // this�� ���� ��Ȯ���� volUp() �Լ� ����
		}
	}

	// ���� ������ ũ�⸦ �����ؼ� �׸�ŭ ���������� �Ѵ�
	void volDown(int u) { // ũ�⸦ ���ڷ� �޴� volUp �Լ�
		for (int i = 0; i < u; i++) { // ���ڰ� ��ŭ �ݺ�
			this.volDown(); // this�� ���� ��Ȯ���� volUp() �Լ� ����
		}
	}

	// ������ �޼��� ���
	void volMsg(String id) {
		System.out.printf("%s => [%s], �ִ뺼��[%d] �ּҺ���[%d] ���纼��[%d]\n", id, volHelp, limit_up_vol, limit_down_vol, vol);
	} // �ִ뺼��, �ּҺ���, ���纼�� ���

	void channelUp() { // ä���� �ö�
		if (channel == limit_up_channel) { // ä���� �ִ� ä�ΰ� ���ٸ�
			chHelp = "������ ä���Դϴ�."; // �޼��� ���� ����
		} else {// ä���� �ִ� ä�ΰ� ���� �ʴٸ�
			channel++; // 1�� �ö�
			chHelp = String.format("ä�� %d �Դϴ�", channel); // �޼��� ���� ����
		}
	}

	void channelDown() { // ä���� ������
		if (channel == limit_down_channel) { // ä���� �ּ� ä�ΰ� ���ٸ�
			chHelp = "ó�� ä���Դϴ�."; // �޼��� ���� ����
		} else { // ä���� �ּ� ä�ΰ� �����ʴٸ�
			channel--; // 1�� �ö�
			chHelp = String.format("ä�� %d �Դϴ�", channel); // �޼��� ���� ����
		}
	}

	// �ø� ä���� ũ�⸦ �����ؼ� �׸�ŭ �ö󰡵��� �Ѵ�
	void channelUp(int u) { // ũ�⸦ ���ڷ� �޴� channelUp �Լ�
		for (int i = 0; i < u; i++) { // ���ڰ� ��ŭ �ݺ�
			this.channelUp(); // this�� ���� ��Ȯ���� channelUp() �Լ� ����
		}
	}

	// ���� ä���� ũ�⸦ �����ؼ� �׸�ŭ ���������� �Ѵ�
	void channelDown(int u) { // ũ�⸦ ���ڷ� �޴� channelDown �Լ�
		for (int i = 0; i < u; i++) { // ���ڰ� ��ŭ �ݺ�
			this.channelDown(); // this�� ���� ��Ȯ���� channelDown() �Լ� ����
		}
	}

	// ä�� �޼��� ���
	void chMsg(String id) {
		System.out.printf("%s => [%s], �ִ�ä��[%d] �ּ�ä��[%d] ����ä��[%d]\n", id, chHelp, limit_up_channel, limit_down_channel,
				channel);
	} // �ִ뺼��, �ּҺ���, ���纼�� ���

}
