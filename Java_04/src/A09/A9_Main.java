package A09;

import java.util.Scanner;

/*
Time Calculator
- User inputs the two time information
- Print the calculated time interval between them in seconds

163227 //
163558
211s
 */

public class A9_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time1 = sc.nextInt();
		int time2 = sc.nextInt();

		int hourABS = Math.abs(hour(time1) - hour(time2)); // 시간 차이
		int minABS = Math.abs(minute(time1) - minute(time2)); // 분 차이
		int secABS = Math.abs(second(time1) - second(time2)); // 초 차이

		int sum = 0;

		if (time1 > time2) {
			sum += hourABS * 3600; // 시간 차이
			if (minute(time1) >= minute(time2)) {
				sum += minABS * 60;
			} else {
				sum -= minABS * 60;
			}

			if (second(time1) >= second(time2)) {
				sum += secABS;
			} else {
				sum -= secABS;
			}
		} else if (time1 < time2) {
			sum += hourABS * 3600; // 시간 차이
			if (minute(time1) <= minute(time2)) {
				sum += minABS * 60;
			} else {
				sum -= minABS * 60;
			}

			if (second(time1) <= second(time2)) {
				sum += secABS;
			} else {
				sum -= secABS;
			}
		}
		System.out.println("두 시간의 차이는 : " + sum + "s");

	}

	public static int hour(int a) {
		int h = Math.round(a / 10000); // 16.0
		return h;
	}

	public static int minute(int a) {
		a = a - Math.round(a / 10000) * 10000;
		int m = Math.round(a / 100);
		return m;
	}

	public static int second(int a) {
		a = a - Math.round(a / 100) * 100;
		int s = a;
		return s;
	}

}
