package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2606 {
	
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static int count;
	
	public static void DFS(int n) {
		visited[n] = true;
		count++;
		if(arr[n].isEmpty()) return;
		
		for(int i = 0; i < arr[n].size(); i++) {
			if(!visited[arr[n].get(i)]) {
				DFS(arr[n].get(i));
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N+1];
		
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}
		count = 0;
		DFS(1);
		
		System.out.println(count-1);
		

	}

}
