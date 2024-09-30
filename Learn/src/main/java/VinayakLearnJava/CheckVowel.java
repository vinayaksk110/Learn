package VinayakLearnJava;

import java.util.Scanner;

public class CheckVowel {

	public static void main(String[] args) {
		CheckVowel cv = new CheckVowel();
		Scanner sc  = new Scanner(System.in);
		System.out.println("enter the char to check");
		cv.isvowelOrConsonant(sc.next().charAt(0));
		sc.close();

	}

	public void isvowelOrConsonant(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			System.out.println("Character is vowel");
		} else
			System.out.println("Character is consonant");
	}

}
