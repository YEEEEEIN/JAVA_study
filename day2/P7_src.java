package day2;

import java.util.*;
class P_src { // 경고 메일
	public int getTime(String time) { // 문자열 시간:분 을 쪼개서 더하는 함수
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		return H * 60 + M;
	}
	
	public String[] solution(String[] reports, int time){
		// String[] answer = {};
		HashMap<String, Integer> inT = new HashMap<>();
		HashMap<String, Integer> sumT = new HashMap<>();
		for(String x : reports) {
			String a = x.split(" ")[0]; // 이름
			String b = x.split(" ")[1]; // 시간
			String c = x.split(" ")[2]; // in/out
			if(c.equals("in")) {
				inT.put(a, getTime(b)); // HasbMap inT에 in일 때 이름 키에 넣기
			}
			else {
				sumT.put(a, sumT.getOrDefault(a, 0) + (getTime(b) - getTime(a))); // out일 때 이름 키에 넣기
			}
		}
		ArrayList<String> res = new ArrayList<>(); 
		for(String name: sumT.keySet()) { // 저장된 모든 key 값들을 가져오는 메소드
			if(sumT.get(name) > time) res.add(name);
		}
		res.sort((a,b) -> a.compareTo(b));
		String[] answer = new String[res.size()]; // answer로 배열
		for(int i = 0; i <res.size(); i++) {
			answer[i] = res.get(i);
		}
		
		return answer;
	}

	public static void main(String[] args){
		P_src T = new P_src();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));	
		System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
		System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
	}
}
