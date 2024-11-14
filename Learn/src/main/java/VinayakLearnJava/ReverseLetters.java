package VinayakLearnJava;

public class ReverseLetters {
	
	public static void main(String[] args) {
		String str = "Vinayak";
		char chars[]=str.toCharArray();
		for(int i=chars.length-1;i>=0;i--) {
			System.out.print(chars[i]);
		}
	}

}
