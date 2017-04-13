
class Account { 
  private double balance; 
  public Account(double initialDeposit) { 
    balance = initialDeposit; 
  } 
  public double getBalance() { 
    return balance; 
  } 
  public synchronized void deposit(double amount) { 
    balance += amount;
    System.out.println("After deposit balance is: "+balance);
  } 
  public synchronized void withdraw(double amount) { 
	  if ( balance >= amount ) { balance -= amount; }
  } 
}
