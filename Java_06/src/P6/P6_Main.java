package P6;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
Timer
- Print the current time on the screen
- User inputs a time in second
- The program prints out “time is over” after the input time

12:34:45
30
time is over(12:35:15)
 */

public class P6_Main {

	public static void main(String[] args) {
		// 현재 시간 출력
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		String dateAndTime = format.format(time);

		System.out.println(dateAndTime);

		Scanner sc = new Scanner(System.in);
		int sec = sc.nextInt();

		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		time = new Date();
		dateAndTime = format.format(time);
		System.out.println(dateAndTime);

	}

}
