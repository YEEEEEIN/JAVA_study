package day2;

import java.util.*;

class P6 { // 문서 도난
	public String[] solution(String[] reports, String times) {
		String[] answer = {};
		ArrayList<String> a = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();
		for (String x : reports) {
			String[] temp = x.split(" ");
			a.add(temp[0]); // 이름 리스트
			b.add(temp[1]); // 시간 리스트
		}
		

		String startTime = times.split(" ")[0]; // 08:33
		int startTime_hour = Integer.parseInt(startTime.split(":")[0]); // 08
		int startTime_min = Integer.parseInt(startTime.split(":")[1]); // 33
		int startTimeSum = startTime_hour*60 + startTime_min;
		String endTime = times.split(" ")[1]; // 09:45
		int endTime_hour = Integer.parseInt(endTime.split(":")[0]); // 09
		int endTime_min = Integer.parseInt(endTime.split(":")[1]); // 45
		int endTimeSum = endTime_hour*60 + endTime_min;
		
		return answer;
	}

	public static void main(String[] args) {
		P6 T = new P6();
		System.out.println(Arrays.toString(
				T.solution(new String[] { "john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" },
						"08:33 09:45")));
		// System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56",
		// "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john
		// 15:23", "park 09:59"}, "15:01 19:59")));
		// System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20",
		// "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}
