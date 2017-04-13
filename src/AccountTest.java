import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account = new Account(500);
		//create a generic collection object to hold multiple transactions
			
		// demonstrate how multiple threads work
		// create and name each runnable
		Transaction task1 = new Transaction("Deposit",account);
		Transaction task2 = new Transaction("Withdraw",account);
		Transaction task3 = new Transaction ("Deposit", account);
		
		//Create array List for multiple transactions
		 ArrayList<Transaction> arrayList = new ArrayList<>();
		 arrayList.add(task1);
		 arrayList.add(task2);
	     arrayList.add(task3);
		
		System.out.println("Starting executor");
		
		// Create executor service to manage threads
		ExecutorService exService = Executors.newCachedThreadPool();
		/*
		// Start the threads
		exService.execute(task1);
		exService.execute(task2);
		exService.execute(task3);
		*/
		// run all transactions concurrently
		//use an enhanced loop to do that
		 for(Transaction transaction : arrayList){
	            exService.execute(transaction);
	        }
		
		exService.shutdown();
		 /*------------------------------------------------------------------------------*/
       
		System.out.printf("Tasks started, main ends%n");

	}

}
