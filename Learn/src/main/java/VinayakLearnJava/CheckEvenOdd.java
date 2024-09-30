package VinayakLearnJava;

import java.util.Scanner;

public class CheckEvenOdd {

	public static void main(String[] args) {
		int num = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println(" enter the number to be checked as odd or even : ");
		num = sc.nextInt();
		sc.close();
		System.out.println("entered number is :" + num);

		//% gives only the reminder 
		if (num % 2 == 0)
			System.out.println("number is even");
		else
			System.out.println("Number is odd");
	}

}
