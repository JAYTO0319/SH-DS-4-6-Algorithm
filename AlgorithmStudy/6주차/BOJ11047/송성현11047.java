package selfstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11047 {

	public static void main(String[] args) throws IOException {
		
		//N만큼 받아온 값들을 array로 받아서
		//while문을 통해 K가 1보다 작을 때까지 반복문을 돌린다.
		//오름차순으로 array에 넣었기 때문에 맨 뒤부터 값을 비교
		//해당 값보다 크면 나눠서 몫을 total_coin에 더하기
		//나머지는 다시 K에 넣고 반복
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫째 줄에 N과 K가 주어진다
		String[] result = br.readLine().split(" ");
		int N = Integer.parseInt(result[0]);
		int K = Integer.parseInt(result[1]);
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());	
		}
		
		int i=0;
		int total_coin = 0;
		while(K >= 1) {
			if(K >= coin[N-1-i]) {
				total_coin += K / coin[N-1-i];
				K = K%coin[N-1-i];
			}
			i++;
		}
		System.out.println(total_coin);
	}

}
