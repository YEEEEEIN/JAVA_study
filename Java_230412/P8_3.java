package Java_230412;

//BufferedReader, File, FileReader, IOException�� ����Ʈ�Ѵ�.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P8_3 {

	// main �޼��带 �����ϰ� IOException�� �������� �����Ѵ�.
	public static void main(String[] args) throws IOException {
		// File Ŭ������ ����Ͽ� txt ������ �о�´�.
		File k23_f = new File("C:\\Users\\����\\Desktop\\������\\���������������.txt");
		// FileReader�� �̿��Ͽ� ������ �д� BufferedReader�� �����Ѵ�.
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f));

		// String �� ���� readtxt�� �����Ѵ�.
		String readtxt;

		// ���� readLine()�� null�� ��ȯ�Ѵٸ�, �� ������ ����ִٸ�
		if ((readtxt = k23_br.readLine()) == null) {
			// "�� �����Դϴ�"��� �޽����� ����Ѵ�.
			System.out.printf("�� �����Դϴ�\n");
		}

		// String �迭 field_name�� readtxt�� ������ �и��� ������ �����Ѵ�.
		String[] field_name = readtxt.split("\t"); // tap�� txt����

		// ���� ��ġ�� ����, �浵�� �����Ѵ�.
		double lat = 37.3860521;
		double lng = 127.1214038;

		// int �� ���� LineCnt�� 0���� �ʱ�ȭ�Ѵ�.
		int LineCnt = 0;
		// ���� �� �Ÿ��� �����ϴ� maxdist�� ���� ����� �Ÿ��� �����ϴ� mindist�� 0���� �ʱ�ȭ�Ѵ�.
		double maxdist = 0;
		double mindist = 0;

		// ���� �� �Ÿ��� ������ ��Ҹ� �����ϴ� String �迭 maxDist�� ���� ����� �Ÿ��� ������ ��Ҹ� �����ϴ� String �迭
		// minDist�� null�� �ʱ�ȭ�Ѵ�.
		String[] maxDist = null;
		String[] minDist = null;

		// BufferedReader�κ��� �� �پ� �о�ͼ� readtxt�� �����ϰ�, readtxt�� null�� �ƴ� ������ �ݺ��Ѵ�.
		while ((readtxt = k23_br.readLine()) != null) {
			// String �迭 field�� readtxt�� ������ �и��� ������ �����Ѵ�.
			String[] field = readtxt.split("\t");
			// "[LineCnt]��° �׸�"�̶�� �޽����� ����Ѵ�.
			System.out.printf("**[%d]��° �׸�***************************\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[10], field[10]); // 9��: �����ּ�
			System.out.printf(" %s : %s\n", field_name[13], field[13]); // 12��: �����ּ�
			System.out.printf(" %s : %s\n", field_name[14], field[14]); // 13��: �浵�ּ�
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[13]) - lat, 2) // ��Ÿ��� ������ Ȱ���Ͽ�
					+ Math.pow(Double.parseDouble(field[14]) - lng, 2)); // �Ÿ� ���ϱ�
			System.out.printf(" ���������� �Ÿ� : %f\n", dist); // 13��: �浵 �ּ�
			System.out.printf("********************************************\n"); // ���

			// ���� ����� ���� �� �� ã��

			if (LineCnt == 0) { // LineCnt�� 0�̸�
				mindist = Double.MAX_VALUE; // double ���� �ִ� ����
				maxdist = Double.MIN_VALUE; // double ���� �ּҰ� ����
			} else { // LineCnt�� 0�� �ƴϸ�
				if (maxdist < dist) { // �Ÿ��� �ִ밪 ���� ũ��
					maxdist = dist; // �ִ밪�� �Ÿ� ����
					maxDist = field; // �ִ밪�� �ʵ� ����
				}
				if (mindist > dist) { // �Ÿ��� �ִ밪 ���� ������
					mindist = dist; // �ִ밪�� �Ÿ� ����
					minDist = field; // �ִ밪�� �ʵ� ����
				}
			}

			LineCnt++; // LineCnt ����
		}
		// ���� ����� ��� ���� ���
		if (minDist != null) { // null�� �ƴϸ�
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n"); // ���
			System.out.printf(" %s : %s\n", field_name[1], minDist[1]); // ��ġ��Ҹ� ���
			System.out.printf(" %s : %s\n", field_name[10], minDist[10]); // �����������ּ� ���
			System.out.printf(" %s : %s\n", field_name[13], minDist[13]); // ���� ���
			System.out.printf(" %s : %s\n", field_name[14], minDist[14]); // �浵���
			System.out.printf(" ���������� �Ÿ� : %f\n", mindist); // ���������� �Ÿ� ���
		} else { // null �̸�
			System.out.printf("\n��� ������ �����ϴ�.\n"); // ���
		}

		// ���� �� ��� ���� ���
		if (maxDist != null) { // ���
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n"); // ��ġ��Ҹ� ���
			System.out.printf(" %s : %s\n", field_name[1], maxDist[1]); // �����������ּ� ���
			System.out.printf(" %s : %s\n", field_name[10], maxDist[10]); // ���� ���
			System.out.printf(" %s : %s\n", field_name[13], maxDist[13]); // �浵���
			System.out.printf(" %s : %s\n", field_name[14], maxDist[14]); // ���������� �Ÿ� ���
			System.out.printf(" ���������� �Ÿ� : %f\n", maxdist);
		} else { // null �̸�
			System.out.printf("\n��� ������ �����ϴ�.\n"); // ���
		}

		k23_br.close(); // BufferedReader ��ü �ݱ�
	}
}
