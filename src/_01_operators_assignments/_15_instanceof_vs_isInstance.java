package _01_operators_assignments;

import java.util.Scanner;

public class _15_instanceof_vs_isInstance {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		Thread t = new Thread();
		System.out.println(t instanceof Runnable);
	
		System.out.println("Enter class name");
		boolean flg = Class.forName(scanner.nextLine()).isInstance(t);
		System.out.println(flg);
		
	}
}
