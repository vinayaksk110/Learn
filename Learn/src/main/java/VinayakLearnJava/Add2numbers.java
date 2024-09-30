package VinayakLearnJava;

import java.util.Scanner;

public class Add2numbers {

	static int x = 10;
	int y = 20;

	Scanner sc = new Scanner(System.in);

	public void scannerTest() {
		System.out.println("Enter first number : ");
		int s = sc.nextInt();
		
		System.out.println("Enter second number : ");
		int u = sc.nextInt();
		
		int res  = s+u;
		System.out.println("numbers added using scanner is : "+res);
	}

	public void addNumbers() {
		// Object is created to use non static variable in static method
		Add2numbers object = new Add2numbers();
		int z = x + object.y;
		System.out.println("Addition fo 2 numbers is " + z);
	}

	public static void main(String[] args) {
		// Object is created to use non static method in static method
		Add2numbers object1 = new Add2numbers();
		
		object1.addNumbers();
		object1.scannerTest();

	}

}
