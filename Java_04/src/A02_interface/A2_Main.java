package A02_interface;

import java.util.Scanner;

public class A2_Main {
    public static Account account; // Account 인터페이스 타입으로 선언
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            if (count == 0) {
                initialization(); // 초기화
            }

            int n = showMenu();

            if (n == 1) {
                insertMoney();
            } else if (n == 2) {
                withDrawalMoney();
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
        account = new Money(0, 0, 0);
    }

    public static int showMenu() {
        System.out.println("#Menu");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("Balance : " + account.getBalance());
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

    public static void insertMoney() {
        int insert = sc.nextInt();
        account.deposit(insert);

        System.out.println("입금 성공!");
    }

    public static void withDrawalMoney() {
        int withDrawal = sc.nextInt();
        account.withdraw(withDrawal);

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
        System.out.println("Balance : " + account.getBalance());
        System.err.println("입출금을 종료합니다");
    }

}

class Money implements Account {
    int deposit;
    int withDrawal;
    int balance;

    public Money() {
    }

    public Money(int deposit, int withDrawal, int balance) {
        this.deposit = deposit;
        this.withDrawal = withDrawal;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.deposit += amount;
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.withDrawal += amount;
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

}

