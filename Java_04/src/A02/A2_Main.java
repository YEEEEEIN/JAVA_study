package A02;

import java.util.Scanner;
//This program runs indefinitely until the user tries terminating it
//#Menu
//Deposit - 예금
//Withdrawal - 출금
//Balance : 0
//-> 1
//10000

//#Menu
//Deposit
//Withdrawal
//Balance : 10000
//-> 2
//2000

//#Menu
//Deposit
//Withdrawal
//Balance : 8000

public class A2_Main extends Money {
	public static Money money; // money 객체 생성
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int count = 0;
		while (true) {
			if (count == 0) {
				initialization(); // 초기화
			} else {

			}

			int n = showMenu();

			if (n == 1) {
				insertMoney();
			} else if (n == 2) {
				withDrawalMoney();
			} else {
			}

			int c = continueBank();

			if (c == 2) {
				stopBank();
				break;
			}
			count++;
		}
	}

	public static void initialization() {// 값세팅 초기화
		money = new Money(0, 0, 0);
	}

	public static int showMenu() { // ---> 함수가 너무 많아서 별로
		System.out.println("#Menu");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawal");
		System.out.println("Balance : " + money.getBalance());
		int f = 0;
		while (true) {
			System.out.print("-> ");
			int n = sc.nextInt();
			if (n == 1) {
				System.out.print("입금할 금액 : ");
				f = n;
				break;
			} else if (n == 2) {
				System.out.print("출금할 금액 : ");
				f = n;
				break;
			} else {
				System.out.println("retry!");
			}
		}
		return f;
	}

	public static void insertMoney() {// 입금
		int insert = sc.nextInt();
		money.setDeposit(insert);

		int balance = money.getDeposit() - money.getWithDrawl();
		money.setBalance(balance);

		System.out.println("입금 성공!");
	}

	public static void withDrawalMoney() {// 출금
		int withDrawal = sc.nextInt();
		money.setWithDrawl(withDrawal);

		int balance = money.getDeposit() - money.getWithDrawl();
		money.setBalance(balance);

		System.out.println("출금 성공!");
	}

	public static int continueBank() {
		System.out.println("추가 은행 업무를 보시겠습니까? 1. 예 | 2. 아니오");
		int n = sc.nextInt();
		return n;
	}

	public static void stopBank() {
		System.out.println("#Menu");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawal");
		System.out.println("Balance : " + money.getBalance());
		System.err.println("입출금을 종료합니다");
	}

}

