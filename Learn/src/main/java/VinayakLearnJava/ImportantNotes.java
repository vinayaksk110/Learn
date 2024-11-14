package VinayakLearnJava;

import java.util.Scanner;

public class ImportantNotes {

	Scanner sc = new Scanner(System.in);
	int y = sc.nextInt();
	char s = sc.next().charAt(0);
	String str = sc.nextLine();

//	*******************A year is a leap year if “any one of ” the following conditions are satisfied: 
//
//		1. The year is multiple of 400.
//		2. The year is a multiple of 4 and not a multiple of 100.

//	*******************int max = (num1 > num2) ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3);
//	   This line of Java code is a nested ternary (or conditional) operator. It is used to find the largest of three numbers: num1, num2, and num3. Here’s a breakdown:
//
//		Outer Ternary Operator: (num1 > num2) ? ... : ...
//		If num1 is greater than num2, the expression evaluates to the part after the ? (i.e., (num1 > num3 ? num1 : num3)).
//		Otherwise, it evaluates to the part after the : (i.e., (num2 > num3 ? num2 : num3)).
//		Inner Ternary Operators:
//		(num1 > num3 ? num1 : num3): If num1 is greater than num3, it returns num1; otherwise, it returns num3.
//		(num2 > num3 ? num2 : num3): If num2 is greater than num3, it returns num2; otherwise, it returns num3.
//		So, the entire expression evaluates to the largest of the three numbers. Here’s a step-by-step example:
//
//		If num1 = 5, num2 = 3, and num3 = 4:
//		num1 > num2 is true (5 > 3), so we evaluate (num1 > num3 ? num1 : num3).
//		num1 > num3 is true (5 > 4), so the result is num1, which is 5.

//	*******************char to string
//	str = Character.toString(ch);

//	*******************Reverse letters
//	char chars[]=str.toCharArray();
//	for(int i=chars.length-1;i>=0;i--) {
//		System.out.print(chars[i]);
//	}

//	*******************Reverse words in string
//	String str = "Good morning Vinayak";
//	String arr[]=str.split(" ");
//	
//	StringBuilder rev = new StringBuilder();
//	System.out.println("type 1");
//	for(int i=arr.length-1;i>=0;i--) {
//		rev.append(arr[i]).append(" ");
//	}
//	System.out.print(rev);
//	//type 2
//	System.out.println("\ntype 2");
//	for(int i=arr.length-1;i>=0;i--) {
//		System.out.print(arr[i]+ " ");
}
