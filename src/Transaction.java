import java.security.SecureRandom;

public class Transaction implements Runnable 
{
private final int sleepTime; // random sleep time for thread
private final String taskName; // name of task
private final static SecureRandom generator = new SecureRandom();

Account account;
public Transaction( String name, Account account )
{
	
   taskName = name; // set task name
   this.account=account;
     
   // pick random sleep time between 0 and 1 second
   sleepTime = generator.nextInt( 1000 ); // milliseconds
} // end Transaction constructor

// method run contains the code that a thread will execute
public void run()
{
   try // put thread to sleep for sleepTime amount of time 
   {
      System.out.printf( "%s going to sleep for %d milliseconds.\n", 
         taskName, sleepTime );
      Thread.sleep( sleepTime ); // put thread to sleep
      if (taskName.equals("withdraw"))
      {
    	  account.withdraw(50.0);
      }
      else if (taskName.equals("deposit"))
      {
    	  account.deposit(50.0);
      }
   } // end try  
   
   catch ( InterruptedException exception )
   {
      System.out.printf( "%s %s\n", taskName,
         "terminated prematurely due to interruption" );
   } // end catch
     
   // transaction task name
   System.out.printf( "%s thread done sleeping\n", taskName ); 
   System.out.println( account.getBalance() ); 
} // end method run
} // end class Transaction
