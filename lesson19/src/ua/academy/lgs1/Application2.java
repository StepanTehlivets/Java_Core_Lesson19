package ua.academy.lgs1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application2 {
public static void main(String[] args) {
	ExecutorService executable = Executors.newSingleThreadExecutor();
	executable.execute(new Runnable() {

		@Override
		public void run() {
			System.out.println("Enter quantity of numbers to be displayed");
			Scanner sc = new Scanner(System.in);
			int quantity = sc.nextInt();
			int[] fibonacci = new int[quantity];
			fibonacci[0] = 1;
			fibonacci[1] = 1;
			for (int i = 2; i < fibonacci.length; i++) {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			}
			for (int i = fibonacci.length - 1; i >= 0; i--) {
				if (i == fibonacci.length - 1) {
					System.out.print("RunnableThreat " + fibonacci[i] + " ");
				} else {
					System.out.print(fibonacci[i] + " ");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	executable.execute(new Runnable() {
		@Override
		public void run() {
			System.out.println("Enter quantity of numbers to be displayed");
			Scanner sc = new Scanner(System.in);
			int quantity = sc.nextInt();
			int[] fibonacci = new int[quantity];
			fibonacci[0] = 1;
			fibonacci[1] = 1;
			for (int i = 2; i < fibonacci.length; i++) {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			}
			for (int i = 0; i < fibonacci.length; i++) {
				if (i == 0) {
					System.out.print("MyThread " + fibonacci[i] + " ");
				} else {
					System.out.print(fibonacci[i]+ " ");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	executable.shutdown();
}
}
