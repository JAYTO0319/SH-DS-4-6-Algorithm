package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

//백준 1181
public class Week5_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<String> ts = new TreeSet<String>(
				(Comparator<String>) (a, b)->{
					return a.length() == b.length() ?  
							a.compareTo(b) :
							a.length() - b.length();
				});
		
		for(int i = 0 ; i < n; i++) {
			ts.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : ts) {
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());
		

	}

}
