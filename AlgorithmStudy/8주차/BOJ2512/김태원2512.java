import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	
	static int m, n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mx = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			mx = Math.max(mx, arr[i]);
		}
		m = Integer.parseInt(br.readLine());
		int left = 0, right = mx;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isFine(mid)) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		System.out.println(left - 1);
	}

	private static boolean isFine(int b) {
		int sum = 0;
		for (int e : arr) {
			sum += e > b ? b : e;
		}
		return sum <= m;
	}
	
}
