package VinayakLearnJava;

public class factorial {
	
	public static void main(String[] args) {
		int factorial = 1;
		int num = 6;
		
		for(int i=1;i<=num;i++) {
			//In Java, the expression factorial *= i; is a shorthand for factorial = factorial * i;
			factorial*= i;
		}
		System.out.println("Factorial is >>"+factorial);
	}

}
