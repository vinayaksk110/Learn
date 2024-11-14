package VinayakLearnJava;

import java.util.Arrays;

public class SortArrays {
	
	public static void main(String[] args) {
		String str[]= {"apple","zebra","car","map"};
		Arrays.sort(str);
		for(String s:str) {
			System.out.println(s);
		}
	}

}
