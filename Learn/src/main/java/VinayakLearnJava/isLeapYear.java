package VinayakLearnJava;

import java.util.Scanner;

public class isLeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the year to check if lf leap");
		isleap(sc.nextInt());

	}

	public static void isleap(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			System.out.println("Year "+year+" is a leap year.");
		}
		else
			System.out.println("Year "+year+" is not a leap year.");
	}

}
