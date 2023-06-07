package Java_230412;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P8_2 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\����\\Desktop\\������\\���������������.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		String[] field_name = readtxt.split("\t"); // tap�� txt����

		// ���ձ�� �츮�� �����浵, �������� �˾ƺ���
		double lat = 37.3860521;
		double lng = 127.1214038;

		int LineCnt = 0;
		double min_dist = Double.MAX_VALUE; // �ּ� �Ÿ�
		double max_dist = Double.MIN_VALUE; // �ִ� �Ÿ�
		String min_NameOfInstallationPlace = null; // �ּ� �Ÿ� �϶� ��ġ��Ҹ�
		String max_NameOfInstallationPlace = null; // �ִ� �Ÿ� �϶� ��ġ��Ҹ�
		String min_LocationNumberAddress = null; // �ּ� �Ÿ� �϶� �����������ּ�
		String max_LocationNumberAddress = null; // �ּ� �Ÿ� �϶� �����������ּ�
		double min_latitude = Double.MAX_VALUE; // �ּ� �Ÿ� �϶� ����
		double max_latitude = Double.MIN_VALUE; // �ּ� �Ÿ� �϶� ����
		double min_longitude = Double.MAX_VALUE; // �ּ� �Ÿ� �϶� �浵
		double max_longitude = Double.MIN_VALUE; // �ּ� �Ÿ� �϶� �浵

		while ((readtxt = br.readLine()) != null) {
			String[] field = readtxt.split("\t");
			System.out.printf("**[%d]��° �׸�***************************\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[10], field[10]); // 9��: �����ּ�
			System.out.printf(" %s : %s\n", field_name[13], field[13]); // 12��: �����ּ�
			System.out.printf(" %s : %s\n", field_name[14], field[14]); // 13��: �浵�ּ�
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[13]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[14]) - lng, 2));
			System.out.printf(" ���������� �Ÿ� : %f\n", dist); // 13��: �浵 �ּ�
			System.out.printf("********************************************\n");

			// ���� ����� ���� �� �� ã��

			if (dist < min_dist) {
				min_dist = dist;
				min_NameOfInstallationPlace = field[1];
				min_LocationNumberAddress = field[10];
				min_latitude = Double.parseDouble(field[13]);
				min_longitude = Double.parseDouble(field[14]);
			}
			if (dist > max_dist) {
				max_dist = dist;
				max_NameOfInstallationPlace = field[1];
				max_LocationNumberAddress = field[10];
				max_latitude = Double.parseDouble(field[13]);
				max_longitude = Double.parseDouble(field[14]);
			}

			LineCnt++;
		}
		br.close();
		System.out.printf("\n******************[�ּҰŸ�]******************\n");
		System.out.printf(" ���������� �Ÿ� : %f\n", min_dist); // �ּ� �Ÿ�
		System.out.printf(" ��ġ��Ҹ� : %s\n", min_NameOfInstallationPlace); // ��ġ��Ҹ�
		System.out.printf(" �����������ּ� : %s\n", min_LocationNumberAddress); // �����������ּ�
		System.out.printf(" ���� : %f\n", min_latitude); // ����
		System.out.printf(" �浵 : %f\n", min_longitude); // �浵

		System.out.printf("\n******************[�ִ�Ÿ�]******************\n");
		System.out.printf(" ���������� �Ÿ� : %f\n", max_dist); // �ִ� �Ÿ�
		System.out.printf(" ��ġ��Ҹ� : %s\n", max_NameOfInstallationPlace); // ��ġ��Ҹ�
		System.out.printf(" �����������ּ� : %s\n", max_LocationNumberAddress); // �����������ּ�
		System.out.printf(" ���� : %f\n", max_latitude); // ����
		System.out.printf(" �浵 : %f\n", max_longitude); // �浵

	}

}
