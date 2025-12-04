package algorithm.study.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Asc {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		int[] sort = new int[a];
		
		for(int i = 0; i < sort.length; i++) {
			sort[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(sort);
		
		for(int data : sort) {
			System.out.println(data);
		}
	}

}
