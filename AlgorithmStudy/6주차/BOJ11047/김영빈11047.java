import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		
		for(int i=N-1; i>=0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0;
		int cnt = 0;
		
		while(idx < coins.length) {
			if(K >= coins[idx]) {
				K -= coins[idx];
				cnt++;
			} else {
				idx++;
			}
		}
		System.out.println(cnt);
	}

}
