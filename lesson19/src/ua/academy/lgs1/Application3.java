package ua.academy.lgs1;


import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application3 {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executable = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Enter quantity of numbers to be displayed");
		Scanner sc = new Scanner(System.in);
		int quantity = sc.nextInt();
		int[] fibonacci = new int[quantity];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for (int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}

		
		executable.scheduleAtFixedRate(new Runnable() {
			int i=0;
			@Override
			public void run() {
			if(i==0) {
			System.out.print("Fibonacci numbers: " +fibonacci[i] +" ");}else if(i==quantity){
				System.out.print(fibonacci[i] +" ");
				
			}else {
				System.out.print(fibonacci[i] +" ");
			
			}
			i++;
				
			
		}}, 1, 1, TimeUnit.SECONDS);


		
		executable.awaitTermination(quantity+1, TimeUnit.SECONDS);
		executable.shutdown();
	}
}
