package A07;
/*
Grade Calculator
- User inputs a number(number of subjects) // 과목수
- User inputs the unit for each subject // 각 과목의 단위? 비율?
- User inputs the grade for each subject(A+, A0, B+, … ,F) // 각 과목의 학점

*Prints the average grade using Float data type // double

3

2
3
3

A+
B+
C0

3.1875
 */

import java.util.Scanner;

public class A7_Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int subjectNum = sc.nextInt();
		double sum = 0;
		double total = 0;

		for (int i = 0; i < subjectNum; i++) {
			int a = inputUnit();
			double b = inputGrade();
			sum = a * b;
			total += sum;
		}

		System.out.println(total / subjectNum);

	}

	public static int inputUnit() {
		int unit = 0;
		unit = sc.nextInt();
		return unit;
	}

	public static double inputGrade() {
		String grade;
		grade = sc.nextLine();
		// double score = unit * Double.parseDouble(grade);
		return ScoreOfGrade(grade);
	}

	public static double ScoreOfGrade(String grade) {
		double a = 0;
		switch (grade) {
		case "A+":
			a = 4.5;
			break;
		case "A":
			a = 4.0;
			break;
		case "B+":
			a = 3.5;
			break;
		case "B":
			a = 3.0;
			break;
		case "C+":
			a = 2.5;
			break;
		case "C":
			a = 2.0;
			break;
		case "D+":
			a = 1.5;
			break;
		case "D":
			a = 1.0;
			break;
		default:
			a = 0;
			break;
		}

		return a;

	}

}
