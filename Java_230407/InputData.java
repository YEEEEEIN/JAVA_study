package Java_230407;

public class InputData { // �Է� ������ Ŭ����
	String[] name; // String �迭 ���� ����
	int[] kor; // int �迭 ���� ����
	int[] eng; // int �迭 ���� ����
	int[] mat; // int �迭 ���� ����
	int[] sum; // int �迭 ���� ����
	double[] avg; // double �迭 ���� ����

	public InputData(int iPerson) { // int���� ���ڷ� �޴� ������
		name = new String[iPerson]; // ���ڸ�ŭ �迭�� ũ�� ����
		kor = new int[iPerson]; // ���ڸ�ŭ �迭�� ũ�� ����
		eng = new int[iPerson]; // ���ڸ�ŭ �迭�� ũ�� ����
		mat = new int[iPerson]; // ���ڸ�ŭ �迭�� ũ�� ����
		sum = new int[iPerson]; // ���ڸ�ŭ �迭�� ũ�� ����
		avg = new double[iPerson]; // ���ڸ�ŭ �迭�� ũ�� ����
	}

	public void SetData(int index, String name, int kor, int eng, int mat) { // ���ڸ� 5�� �޴� SetData �Լ�
		this.name[index] = name; // ���ڸ� (���ڷ� ���� index ��° �迭�� ����
		this.kor[index] = kor; // ���ڸ� (���ڷ� ���� index ��° �迭�� ����
		this.eng[index] = eng; // ���ڸ� (���ڷ� ���� index ��° �迭�� ����
		this.mat[index] = mat; // ���ڸ� (���ڷ� ���� index ��° �迭�� ����
		this.sum[index] = kor + eng + mat; // ���� �� ������ ��
		this.avg[index] = (kor + eng + mat) / 3.0; // ����� �� ������ �� /3

	}
}
