import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] map = new int[n][n];
		int mx = 0, mn = 101;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, map[i][j]);
				mn = Math.min(mn, map[i][j]);
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		int count = 0, answer = 0;
		for (int h = mx; h >= mn; h--) {
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] >= h && !visited[i][j]) {
						q.addFirst(new int[] {i, j});
						count++;
						visited[i][j] = true;
						while (!q.isEmpty()) {
							int[] cur = q.removeLast();
							for (int dir = 0; dir < 4; dir++) {
								int ni = cur[0] + di[dir];
								int nj = cur[1] + dj[dir];
								if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
								if (map[ni][nj] < h || visited[ni][nj]) continue;
								visited[ni][nj] = true;
								q.addFirst(new int[] {ni, nj});
							}
						}
					}
				}
			}
			answer = Math.max(count, answer);
			count = 0;
		}
		System.out.println(answer);
	}

}
