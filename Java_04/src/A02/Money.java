package A02;

public class Money {
	int deposit; // 예금하는돈
	int withDrawl; // 출금하는돈
	int balance;

	public Money() {
	}

	public Money(int deposit, int withDrawl, int balance) {
		this.deposit = deposit;
		this.withDrawl = withDrawl;
		this.balance = balance;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithDrawl() {
		return withDrawl;
	}

	public void setWithDrawl(int withDrawl) {
		this.withDrawl = withDrawl;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void balanceCheck(int deposit, int withDrawl) {// 예금 - 적금 = 남은 돈
		this.balance = deposit - withDrawl;
	}

}
