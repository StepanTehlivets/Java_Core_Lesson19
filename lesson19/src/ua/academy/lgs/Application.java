package ua.academy.lgs;

public class Application {
	public static void main(String[] args) {
		MyThread myThread = new MyThread("Fibonacci number", 1000);
		myThread.start();
		
		RunnableThread rt= new RunnableThread("Fibonacci number",1000);
	}
}
