package P08;
/*
Calendar Application III
-User inputs a date and a number for adding days
-Print the new date after adding the input day to the start date 

20200203
8
20200212
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class P8_Main {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		String date1 = scanner.nextLine();

		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");

		Date chgInputDate = format1.parse(date1);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(chgInputDate);

		int days = scanner.nextInt();
		calendar.add(Calendar.DATE, days); // 캘린더에 days 더하기
		Date resultDate = calendar.getTime();
		System.out.println(format1.format(resultDate));
	}

}
