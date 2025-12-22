import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			int r1 = N;
			int r2 = N;
			int r3 = N;
			
			if(i%3==0) {
				r1 = arr[i/3];
			}
			
			if(i%2==0) {
				r2 = arr[i/2];
			}
			
			r3 = arr[i-1];
			
			int min = Math.min(Math.min(r1, r2), r3);
			arr[i] = min + 1;
		}
		
		System.out.println(arr[N]);
	}

}
