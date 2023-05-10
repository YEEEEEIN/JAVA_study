package day2;

import java.util.*;
class Info implements Comparable<Info>{ // Comparable 클래스를 override
	public String name;
	public int time;
	Info(String name, int time){
		this.name = name;
		this.time = time;
	}
	@Override
	public int compareTo(Info ob) {
		// Info 객체를 정렬할 때 사용되는 compareTo 메서드
        // 현재 객체의 시간(time)과 인자로 받은 객체(ob)의 시간(time)을 비교하여 반환한다.
		//System.out.println("compare out : " + (this.time - ob.time));
		
		return this.time - ob.time; // 리턴값이 시간이다 (이름X)
	}
	
}

class P6_src { // 문서 도난
	public int getTime(String time) { // 문자열 시간:분 을 쪼개서 더하는 함수
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		return H*60+M;
	}
	public String[] solution(String[] reports, String times){
        ArrayList<Info> tmp = new ArrayList<>(); // Info 객체 list를 저장할 수 있는 빈 ArrayList 객체 tmp 생성하는 코드
        for(String x : reports){ // 로그 정보를 처리하여 Info 객체를 생성하고 ArrayList에 추가
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        Collections.sort(tmp); // ArrayList를 시간 순서로 정렬

        int s = getTime(times.split(" ")[0]); // 검색 시작 시간
        Info startTime = new Info("startTime", s);

        int e = getTime(times.split(" ")[1]); // 검색 종료 시간
        Info endTime = new Info("endTime", e);

        ArrayList<String> res = new ArrayList<>(); // 검색 결과를 저장할 ArrayList
        for(Info ob : tmp){
            // 검색 범위 내에 있는 로그를 res 리스트에 추가
            if(ob.compareTo(startTime) > 1 && ob.compareTo(endTime) <= 0){
                res.add(ob.name);
            }
            // endTime 이후의 로그는 검색할 필요가 없으므로 반복문을 탈출한다.
            if(ob.compareTo(endTime) > 0) break;
        }
        // 결과를 String 배열로 변환하여 반환
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

	public static void main(String[] args){
		P6_src T = new P6_src();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		//System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		//System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}

