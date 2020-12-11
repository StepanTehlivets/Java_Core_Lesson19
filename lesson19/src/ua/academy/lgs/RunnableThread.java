package ua.academy.lgs;


import java.util.Scanner;

public class RunnableThread implements Runnable {
	private String name;
	private int delay;
	private Thread thread;

	public RunnableThread(String name, int delay) {
		this.name = name;
		this.delay = delay;
		this.thread = new Thread(this);
		thread.start();
	}

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
				System.out.print("RunnableThreat " +name + fibonacci[i] + " ");
			} else {
				System.out.print(fibonacci[i] + " ");
			}
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
