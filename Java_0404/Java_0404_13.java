package Java_0404;

public class Java_0404_13 {

	public static void main(String[] args) {
		int iNumVal = 1201000000;
		String sNumVal = String.valueOf(iNumVal); // 문자열로 바꿈
		String sNumVoice = ""; //

		System.out.printf("==> %s [%d자리]\n\n", sNumVal, sNumVal.length());

		int i, j;

		String[] units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" }; // 숫자 한글로
		String[] unitX = { "", "십", "백", "천", "만", "십", "백", "천", "억", "십" }; // 단위 한글로

		i = 0;
		j = sNumVal.length() - 1; // 배열은 0부터 시작하기 때문에

		while (true) {
			if (i >= sNumVal.length()) {
				break; // While문 탈출
			}

			System.out.printf("%s[%s]", sNumVal.substring(i, i + 1), // 숫자 출력 // 1
					units[Integer.parseInt(sNumVal.substring(i, i + 1))]); // 단위 한글로 출력
			//
			//
			//
			if (iNumVal == 0 && sNumVal.length() == 1) {
				sNumVoice = "영";
				break;
			}

			if (i > 2) { // && sNumVal.charAt(i-2) != 0
				if (sNumVal.substring(i, i + 1).equals("0")) { //
					if (!(sNumVal.substring(i - 3, i).equals("000"))) {
						if (unitX[j].equals("만") || unitX[j].equals("억")) {
							sNumVoice = sNumVoice + "" + unitX[j]; // 억

						} else {

						}
					}
				} else {
					sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i + 1))] + unitX[j];
				}

			} else if (i == 2) { // && sNumVal.charAt(i-2) != 0
				if (sNumVal.substring(i, i + 1).equals("0")) { //
					if (!(sNumVal.substring(i - 2, i).equals("00"))) {
						if (unitX[j].equals("만") || unitX[j].equals("억")) {
							sNumVoice = sNumVoice + "" + unitX[j]; // 억

						} else {

						}
					}
				} else {
					sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i + 1))] + unitX[j];

				}
			} else { // i =

				if (sNumVal.substring(i, i + 1).equals("0")) { //

					if (unitX[j].equals("만") || unitX[j].equals("억")) {
						sNumVoice = sNumVoice + "" + units[j]; // 억

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
