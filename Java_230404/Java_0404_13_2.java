package Java_230404;

public class Java_0404_13_2 {

	public static void main(String[] args) {
		int k23_iNumVal = 2030200000;
		String k23_sNumVal = String.valueOf(k23_iNumVal); // 문자열로 바꿈
		String k23_sNumVoice = ""; //

		System.out.printf("==> %s [%d자리]\n\n", k23_sNumVal, k23_sNumVal.length());

		int k23_i, k23_j;

		String[] units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" }; // 숫자 한글로
		String[] unitX = { "", "십", "백", "천", "만", "십", "백", "천", "억", "십" }; // 단위 한글로

		k23_i = 0;
		k23_j = k23_sNumVal.length() - 1; // 배열은 0부터 시작하기 때문에

		while (true) {
			if (k23_i >= k23_sNumVal.length()) { // i가 sNumVa의 길이보다 크면
				break; // While문 탈출
			}

			System.out.printf("%s[%s]", k23_sNumVal.substring(k23_i, k23_i + 1), // 숫자 출력 // 1
					units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))]); // 단위 한글로 출력
			
			//
			if (k23_iNumVal == 0 && k23_sNumVal.length() == 1) { // k23_iNumVal == 0이고  k23_sNumVal의 길이가 1이면
				k23_sNumVoice = "영"; // "영" 대입
				break; // While문 탈출
			}
			
			if (k23_i > 2) { // i > 2일 때   ===>   i = 2;
				if (k23_sNumVal.substring(k23_i, k23_i + 1).equals("0")) { // k23_sNumVal의 i번째 자리가 0일 때
					if (!(k23_sNumVal.substring(k23_i - 3, k23_i).equals("000"))) { // k23_sNumVal의 (i-3~i-1)번째 자리가 "000"이 아니면 => 어떠한 숫자라도 들어가면 단위를 붙여야하기 때문에
						if (unitX[k23_j].equals("만") || unitX[k23_j].equals("억")) { // unitX[j]가 "만" 또는 "억" 이면
							k23_sNumVoice = k23_sNumVoice + "" + unitX[k23_j]; // "만" 또는 "억"을 붙인다.

						}
					}
				} else { // 변수 k23_iNumVal의 i번째 수가 가 0이 아니면
					k23_sNumVoice = k23_sNumVoice + units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))] + unitX[k23_j]; // 대입 -> 문자열의 합은 이어붙이기!
				}
				
				
			} else if (k23_i > 1) { // i > 1일 때   ===>   i = 2;
				if (k23_sNumVal.substring(k23_i, k23_i + 1).equals("0")) { // k23_sNumVal의 i번째 자리가 0일 때
					if (!(k23_sNumVal.substring(k23_i - 2, k23_i).equals("00"))) { // k23_sNumVal의 (i-2~i-1)번째 자리가 "00"이 아니면
						if (unitX[k23_j].equals("만") || unitX[k23_j].equals("억")) { // unitX[j]가 "만" 또는 "억" 이면
							k23_sNumVoice = k23_sNumVoice + "" + unitX[k23_j]; // "만" 또는 "억"을 붙인다.

						}
					}
				} else { // 변수 k23_iNumVal의 i번째 수가 가 0이 아니면
					k23_sNumVoice = k23_sNumVoice + units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))] + unitX[k23_j];
				}
				
				
			} else { // i <= 1일 때   ===>   i = 0, 1
				if (k23_sNumVal.substring(k23_i, k23_i + 1).equals("0")) { // 변수 k23_iNumVal의 i번째 수가 가 0이면 -> i = 1 부터 가능
					// i = 0일 때 i - 1 존재xxx
					// i = 1일 때 i - 1은 무조건 존재해야하기 때문에 i - 1 = 0 이 될 수 없다.
					if (unitX[k23_j].equals("만") || unitX[k23_j].equals("억")) { // unitX[j]가 "만" 또는 "억" 이면
						k23_sNumVoice = k23_sNumVoice + "" + unitX[k23_j]; // "만" 또는 "억"을 붙인다.
					}

				} else { // 변수 k23_iNumVal의 i번째 수가 가 0이 아니면
					k23_sNumVoice = k23_sNumVoice + units[Integer.parseInt(k23_sNumVal.substring(k23_i, k23_i + 1))] + unitX[k23_j]; // 대입
				}
			}
			
			k23_i++; // i 증가
			k23_j--; // j 감소

		}
		System.out.printf("\n\n%s[%s]\n", k23_sNumVal, k23_sNumVoice); // k23_sNumVal, k23_sNumVoice 출력
	}

}
