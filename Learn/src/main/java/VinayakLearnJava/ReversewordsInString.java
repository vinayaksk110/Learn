package VinayakLearnJava;

public class ReversewordsInString {
	
	public static void main(String[] args) {
		String str = "Good morning Vinayak";
		String arr[]=str.split(" ");
		
		StringBuilder rev = new StringBuilder();
		System.out.println("type 1");
		for(int i=arr.length-1;i>=0;i--) {
			rev.append(arr[i]).append(" ");
		}
		System.out.print(rev);
		//type 2
		System.out.println("\ntype 2");
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+ " ");
		}
	}

}
