package Java_0404;

public class Java_0404_13 {

	public static void main(String[] args) {
		int iNumVal = 1201000000;
		String sNumVal = String.valueOf(iNumVal); // ���ڿ��� �ٲ�
		String sNumVoice = ""; //

		System.out.printf("==> %s [%d�ڸ�]\n\n", sNumVal, sNumVal.length());

		int i, j;

		String[] units = { "��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��" }; // ���� �ѱ۷�
		String[] unitX = { "", "��", "��", "õ", "��", "��", "��", "õ", "��", "��" }; // ���� �ѱ۷�

		i = 0;
		j = sNumVal.length() - 1; // �迭�� 0���� �����ϱ� ������

		while (true) {
			if (i >= sNumVal.length()) {
				break; // While�� Ż��
			}

			System.out.printf("%s[%s]", sNumVal.substring(i, i + 1), // ���� ��� // 1
					units[Integer.parseInt(sNumVal.substring(i, i + 1))]); // ���� �ѱ۷� ���
			//
			//
			//
			if (iNumVal == 0 && sNumVal.length() == 1) {
				sNumVoice = "��";
				break;
			}

			if (i > 2) { // && sNumVal.charAt(i-2) != 0
				if (sNumVal.substring(i, i + 1).equals("0")) { //
					if (!(sNumVal.substring(i - 3, i).equals("000"))) {
						if (unitX[j].equals("��") || unitX[j].equals("��")) {
							sNumVoice = sNumVoice + "" + unitX[j]; // ��

						} else {

						}
					}
				} else {
					sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i + 1))] + unitX[j];
				}

			} else if (i == 2) { // && sNumVal.charAt(i-2) != 0
				if (sNumVal.substring(i, i + 1).equals("0")) { //
					if (!(sNumVal.substring(i - 2, i).equals("00"))) {
						if (unitX[j].equals("��") || unitX[j].equals("��")) {
							sNumVoice = sNumVoice + "" + unitX[j]; // ��

						} else {

						}
					}
				} else {
					sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i + 1))] + unitX[j];

				}
			} else { // i =

				if (sNumVal.substring(i, i + 1).equals("0")) { //

					if (unitX[j].equals("��") || unitX[j].equals("��")) {
						sNumVoice = sNumVoice + "" + units[j]; // ��

					} else {

					}

				} else {
					sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i + 1))] + unitX[j];

				}

			}
			i++;
			j--;

		}
		System.out.printf("\n\n%s[%s]\n", sNumVal, sNumVoice);
	}

}
