package VinayakLearnJava;

import java.util.Scanner;

public class PowerOfaNumber {
	int power = 1, power1 = 1;

	public static void main(String[] args) {
		PowerOfaNumber powerOfaNumber = new PowerOfaNumber();
		Scanner sc = new Scanner(System.in);
		powerOfaNumber.powerNumber(5, 3);
		sc.close();

	}

	public void powerNumber(int x, int n) {
		for (int i = 0; i < n; i++) {
			power = power * x;
			power1 *= x;
		}
		System.out.println(power);
		System.out.println(power1);
	}

}
