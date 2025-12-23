import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static class C {
		int x, y, z; // x:행, y:열, z:최단거리
		
		public C(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] miro = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<M; j++) {
				miro[i][j] = Integer.parseInt(s[j]);
			}
		}
		Deque<C> queue = new ArrayDeque<>();
		
		int[] di = {0,0,1,-1};
		int[] dj = {-1,1,0,0};
		
		miro[0][0] = -1;
		
		queue.add(new C(0,0,1));
		
		while(!queue.isEmpty()) {
			C c = queue.poll();
			
			if(c.x==N-1 && c.y==M-1) {
				System.out.println(c.z);
				return;
			}
			
			for(int k=0; k<4; k++) {
				int ni = c.x + di[k];
				int nj = c.y + dj[k];
				
				if(ni>N-1 || ni<0 || nj>M-1 || nj<0) continue;
				if(miro[ni][nj]==1) {
					miro[ni][nj] = -1;
					queue.add(new C(ni,nj,c.z+1));
				}
			}
		}
		
	}

}
