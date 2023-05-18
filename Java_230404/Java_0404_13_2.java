package Java_230404;

public class Java_0404_13_2 {

	public static void main(String[] args) {
		int k23_iNumVal = 2030200000;
		String k23_sNumVal = String.valueOf(k23_iNumVal); // ���ڿ��� �ٲ�
		String k23_sNumVoice = ""; //

		System.out.printf("==> %s [%d�ڸ�]\n\n", k23_sNumVal, k23_sNumVal.length());

		int k23_i, k23_j;

		String[] units = { "��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��" }; // ���� �ѱ۷�
		String[] unitX = { "", "��", "��", "õ", "��", "��", "��", "õ", "��", "��" }; // ���� �ѱ۷�

		k23_i = 0;
		k23_j = k23_sNumVal.length() - 1; // �迭�� 0���� �����ϱ� ������

		while (true) {
			if (k23_i >= k23_sNumVal.length()) { // i�� sNumVa�� ���̺��� ũ��
				break; // While�� Ż��
			}

			System.out.printf("%s[%s]", k23_sNumVal.substring(k23_i, k23_i + 1), // ���� ��� // 1
					units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))]); // ���� �ѱ۷� ���
			
			//
			if (k23_iNumVal == 0 && k23_sNumVal.length() == 1) { // k23_iNumVal == 0�̰�  k23_sNumVal�� ���̰� 1�̸�
				k23_sNumVoice = "��"; // "��" ����
				break; // While�� Ż��
			}
			
			if (k23_i > 2) { // i > 2�� ��   ===>   i = 2;
				if (k23_sNumVal.substring(k23_i, k23_i + 1).equals("0")) { // k23_sNumVal�� i��° �ڸ��� 0�� ��
					if (!(k23_sNumVal.substring(k23_i - 3, k23_i).equals("000"))) { // k23_sNumVal�� (i-3~i-1)��° �ڸ��� "000"�� �ƴϸ� => ��� ���ڶ� ���� ������ �ٿ����ϱ� ������
						if (unitX[k23_j].equals("��") || unitX[k23_j].equals("��")) { // unitX[j]�� "��" �Ǵ� "��" �̸�
							k23_sNumVoice = k23_sNumVoice + "" + unitX[k23_j]; // "��" �Ǵ� "��"�� ���δ�.

						}
					}
				} else { // ���� k23_iNumVal�� i��° ���� �� 0�� �ƴϸ�
					k23_sNumVoice = k23_sNumVoice + units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))] + unitX[k23_j]; // ���� -> ���ڿ��� ���� �̾���̱�!
				}
				
				
			} else if (k23_i > 1) { // i > 1�� ��   ===>   i = 2;
				if (k23_sNumVal.substring(k23_i, k23_i + 1).equals("0")) { // k23_sNumVal�� i��° �ڸ��� 0�� ��
					if (!(k23_sNumVal.substring(k23_i - 2, k23_i).equals("00"))) { // k23_sNumVal�� (i-2~i-1)��° �ڸ��� "00"�� �ƴϸ�
						if (unitX[k23_j].equals("��") || unitX[k23_j].equals("��")) { // unitX[j]�� "��" �Ǵ� "��" �̸�
							k23_sNumVoice = k23_sNumVoice + "" + unitX[k23_j]; // "��" �Ǵ� "��"�� ���δ�.

						}
					}
				} else { // ���� k23_iNumVal�� i��° ���� �� 0�� �ƴϸ�
					k23_sNumVoice = k23_sNumVoice + units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))] + unitX[k23_j];
				}
				
				
			} else { // i <= 1�� ��   ===>   i = 0, 1
				if (k23_sNumVal.substring(k23_i, k23_i + 1).equals("0")) { // ���� k23_iNumVal�� i��° ���� �� 0�̸� -> i = 1 ���� ����
					// i = 0�� �� i - 1 ����xxx
					// i = 1�� �� i - 1�� ������ �����ؾ��ϱ� ������ i - 1 = 0 �� �� �� ����.
					if (unitX[k23_j].equals("��") || unitX[k23_j].equals("��")) { // unitX[j]�� "��" �Ǵ� "��" �̸�
						k23_sNumVoice = k23_sNumVoice + "" + unitX[k23_j]; // "��" �Ǵ� "��"�� ���δ�.
					}

				} else { // ���� k23_iNumVal�� i��° ���� �� 0�� �ƴϸ�
					k23_sNumVoice = k23_sNumVoice + units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))] + unitX[k23_j]; // ����
				}
			}
			
			k23_i++; // i ����
			k23_j--; // j ����

		}
		System.out.printf("\n\n%s[%s]\n", k23_sNumVal, k23_sNumVoice); // k23_sNumVal, k23_sNumVoice ���
	}

}
