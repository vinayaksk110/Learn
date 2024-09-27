package VinayakLearnJava;

import java.util.Scanner;

public class simpleInterest {
	
	public static void main(String[] args) {
		simpleInterest simple = new simpleInterest();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principle amount");
		double p = sc.nextDouble();
		System.out.println("enter the rate");
		double r = sc.nextDouble();
		System.out.println("enter the time");
		double t = sc.nextDouble();
		simple.simpleInt(p, r, t);
		sc.close();
	}
	
	public void simpleInt(double principle,double rate,double time) {
		double sI = (principle*time*rate)/100;
		System.out.println("simple interest is "+sI);
	}

}
