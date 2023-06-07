package Java_230412;

//BufferedReader, File, FileReader, IOException을 임포트한다.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P8_3 {

	// main 메서드를 정의하고 IOException을 던지도록 선언한다.
	public static void main(String[] args) throws IOException {
		// File 클래스를 사용하여 txt 파일을 읽어온다.
		File k23_f = new File("C:\\Users\\예인\\Desktop\\리눅스\\무료와이파이정보.txt");
		// FileReader를 이용하여 파일을 읽는 BufferedReader를 생성한다.
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f));

		// String 형 변수 readtxt를 정의한다.
		String readtxt;

		// 만약 readLine()이 null을 반환한다면, 즉 파일이 비어있다면
		if ((readtxt = k23_br.readLine()) == null) {
			// "빈 파일입니다"라는 메시지를 출력한다.
			System.out.printf("빈 파일입니다\n");
		}

		// String 배열 field_name에 readtxt를 탭으로 분리한 값들을 저장한다.
		String[] field_name = readtxt.split("\t"); // tap은 txt파일

		// 현재 위치의 위도, 경도를 지정한다.
		double lat = 37.3860521;
		double lng = 127.1214038;

		// int 형 변수 LineCnt를 0으로 초기화한다.
		int LineCnt = 0;
		// 가장 먼 거리를 저장하는 maxdist와 가장 가까운 거리를 저장하는 mindist를 0으로 초기화한다.
		double maxdist = 0;
		double mindist = 0;

		// 가장 먼 거리를 가지는 장소를 저장하는 String 배열 maxDist와 가장 가까운 거리를 가지는 장소를 저장하는 String 배열
		// minDist를 null로 초기화한다.
		String[] maxDist = null;
		String[] minDist = null;

		// BufferedReader로부터 한 줄씩 읽어와서 readtxt에 저장하고, readtxt가 null이 아닐 때까지 반복한다.
		while ((readtxt = k23_br.readLine()) != null) {
			// String 배열 field에 readtxt를 탭으로 분리한 값들을 저장한다.
			String[] field = readtxt.split("\t");
			// "[LineCnt]번째 항목"이라는 메시지를 출력한다.
			System.out.printf("**[%d]번째 항목***************************\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[10], field[10]); // 9번: 지번주소
			System.out.printf(" %s : %s\n", field_name[13], field[13]); // 12번: 위도주소
			System.out.printf(" %s : %s\n", field_name[14], field[14]); // 13번: 경도주소
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[13]) - lat, 2) // 피타고라스 정리를 활용하여
					+ Math.pow(Double.parseDouble(field[14]) - lng, 2)); // 거리 구하기
			System.out.printf(" 현재지점과 거리 : %f\n", dist); // 13번: 경도 주소
			System.out.printf("********************************************\n"); // 출력

			// 가장 가까운 곳과 먼 곳 찾기

			if (LineCnt == 0) { // LineCnt가 0이면
				mindist = Double.MAX_VALUE; // double 형의 최댓값 저장
				maxdist = Double.MIN_VALUE; // double 형의 최소값 저장
			} else { // LineCnt가 0이 아니면
				if (maxdist < dist) { // 거리가 최대값 보다 크면
					maxdist = dist; // 최대값에 거리 저장
					maxDist = field; // 최대값에 필드 저장
				}
				if (mindist > dist) { // 거리가 최대값 보다 작으면
					mindist = dist; // 최대값에 거리 저장
					minDist = field; // 최대값에 필드 저장
				}
			}

			LineCnt++; // LineCnt 증가
		}
		// 가장 가까운 장소 정보 출력
		if (minDist != null) { // null이 아니면
			System.out.printf("\n**[최단 거리]***************\n"); // 출력
			System.out.printf(" %s : %s\n", field_name[1], minDist[1]); // 설치장소명 출력
			System.out.printf(" %s : %s\n", field_name[10], minDist[10]); // 소재지지번주소 출력
			System.out.printf(" %s : %s\n", field_name[13], minDist[13]); // 위도 출력
			System.out.printf(" %s : %s\n", field_name[14], minDist[14]); // 경도출력
			System.out.printf(" 현재지점과 거리 : %f\n", mindist); // 현재지점과 거리 출력
		} else { // null 이면
			System.out.printf("\n장소 정보가 없습니다.\n"); // 출력
		}

		// 가장 먼 장소 정보 출력
		if (maxDist != null) { // 출력
			System.out.printf("\n**[최대 거리]***************\n"); // 설치장소명 출력
			System.out.printf(" %s : %s\n", field_name[1], maxDist[1]); // 소재지지번주소 출력
			System.out.printf(" %s : %s\n", field_name[10], maxDist[10]); // 위도 출력
			System.out.printf(" %s : %s\n", field_name[13], maxDist[13]); // 경도출력
			System.out.printf(" %s : %s\n", field_name[14], maxDist[14]); // 현재지점과 거리 출력
			System.out.printf(" 현재지점과 거리 : %f\n", maxdist);
		} else { // null 이면
			System.out.printf("\n장소 정보가 없습니다.\n"); // 출력
		}

		k23_br.close(); // BufferedReader 객체 닫기
	}
}
