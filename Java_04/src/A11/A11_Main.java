package A11;

import java.util.Scanner;

/*
Comparing the velocities in different units
- User inputs the three values
- Each is m/s, km/h, m/ms in order // s = 1000ms
-Comparing the values and print the quickest one

[Example]
190
780
0.19

780km/h
 */

public class A11_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double mPerS = sc.nextDouble();
		double kmPerH = sc.nextDouble();
		double mPerMs = sc.nextDouble();
		System.out.println("");

		// 속련 단위 m/s로 통일
		double kmPerHTomPerS = kmPerH * 1000 / 3600; // km/h -> m/s
		double mPerMsTomPerS = mPerMs * 1000; // m/ms -> m/s

		if (mPerS > kmPerHTomPerS && mPerS > mPerMsTomPerS) {
			System.out.println(mPerS + "m/s");
		}

		if (kmPerHTomPerS > mPerS && kmPerHTomPerS > mPerMsTomPerS) {
			System.out.println(kmPerH + "km/h");
		}

		if (mPerMsTomPerS > mPerS && mPerMsTomPerS > kmPerHTomPerS) {
			System.out.println(mPerMs + "km/h");
		}

	}

}
