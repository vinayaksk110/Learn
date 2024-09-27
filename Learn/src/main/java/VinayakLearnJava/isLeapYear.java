package VinayakLearnJava;

import java.util.Scanner;

public class isLeapYear {

//	A year is a leap year if “any one of ” the following conditions are satisfied: 
//
//		1. The year is multiple of 400.
//		2. The year is a multiple of 4 and not a multiple of 100.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the year to check if lf leap");
		isleap(sc.nextInt());
		sc.close();

	}

	public static void isleap(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			System.out.println("Year " + year + " is a leap year.");
		} else
			System.out.println("Year " + year + " is not a leap year.");
	}

}
