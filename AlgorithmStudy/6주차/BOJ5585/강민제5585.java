package week6;

import java.util.Scanner;

public class Main5585 {
	public static void main(String[] args) {
		int price = 1000 - new Scanner(System.in).nextInt();
		int count =0;
		int[] arr = {500,100,50,10,5,1};
		for(int i=0;i<6;i++) {
			count += price/arr[i];
			price %= arr[i];
		}
		System.out.println(count);
	}
	
//	public static void main1(String[] args) {
//		int price = 1000 - new Scanner(System.in).nextInt();
//		int count =0;
//		int[] arr = {500,100,50,10,5,1};
//		int i=0;
//		while(price>0) {
//			if(price>=arr[i]) {
//				price-=arr[i];
//				count++;
//			} else i++;
//		}
//		System.out.println(count);
//	}
}
