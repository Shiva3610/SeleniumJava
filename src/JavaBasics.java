import java.util.Scanner;

public class JavaBasics {

	public static void main(String[] args) {
		int num = 5;
		String s = "Hello World, It's Mounika here";
		int arr[]= {1,5,2,7,3};
		String arr1[] = {"Innu","Shiva","Mona"};
		
		for(String s1: arr1) {
				System.out.println("Yes it's "+s1);
		}
		
		for(int i=1;i<=20;i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		//prime number
		System.out.println("Enter number to check");
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt();
		int flag = 0;
		if(m==0 || m==1) {
			flag = 1;
		} 
		for(int j=2;j<=m/2;j++) {
			int remainder = m%j;
			if(remainder == 0) {
				flag = 1;
			}
			
		}
		if(flag == 0) {
			System.out.println(m+" is prime number");
		}

	}

}
