package A02_interface;

// 부모
public interface Account {
    void deposit(int amount);
    
    void withdraw(int amount);
    
    int getBalance();
}
