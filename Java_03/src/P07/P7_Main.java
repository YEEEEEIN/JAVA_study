package P07;
/*
Calendar Application II
-User inputs the two dates
-Print the days between the first and the second dates
  (Calculate Duration)

20200203
20200212
8
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class P7_Main {

	public static void main(String[] args) throws ParseException  {
		Scanner scanner = new Scanner (System.in);
	      String date1 = scanner.nextLine();
	      String date2 = scanner.nextLine();
	      
	      Date simpleDate1 = new SimpleDateFormat("yyyyMMdd").parse(date1);
	      Date simpleDate2 = new SimpleDateFormat("yyyyMMdd").parse(date2);
	      
	      long diffSec = (simpleDate1.getTime() - simpleDate2.getTime()) / 1000; // 어떤 기준 날짜 부터 초시간
	      long diffDays= diffSec / (24 * 60 * 60);
	      
	      System.out.println(Math.abs(diffDays));
	}

}
