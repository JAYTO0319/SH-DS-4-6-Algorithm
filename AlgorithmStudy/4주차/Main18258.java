package algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main18258 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String[] st = br.readLine().split(" ");
			int num = 0;
			
			String operator = st[0];
			
			if(operator.equals("push")) {
				num = Integer.parseInt(st[1]);
				queue.addLast(num);;
			} else if(operator.equals("pop")) {
				num = queue.isEmpty() ? -1 : queue.pollFirst();
				sb.append(num+"\n");
			} else if(operator.equals("size")) {
				num = queue.size();
				sb.append(num+"\n");
			} else if(operator.equals("empty")){
				num = queue.isEmpty() ? 1 : 0;
				sb.append(num+"\n");
			} else if(operator.equals("front")) {
				num = queue.isEmpty() ? -1 : queue.getFirst();
				sb.append(num+"\n");
			} else if(operator.equals("back")) {
				num = queue.isEmpty() ? -1 : queue.getLast();
				sb.append(num+"\n");
			}
		}
		System.out.println(sb);
	}

}
