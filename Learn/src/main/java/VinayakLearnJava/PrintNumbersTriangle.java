package VinayakLearnJava;

public class PrintNumbersTriangle {

	public static void main(String[] args) {
		int row = 7;
		int i, j;
		for (i = 1; i <= row; i++) {
			for (j = 1; j < row - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println(" ");
		}
	}

}
