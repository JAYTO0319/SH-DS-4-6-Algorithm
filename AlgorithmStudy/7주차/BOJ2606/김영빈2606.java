import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2606 {
	
	static LinkedList<Integer>[] adj;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		adj = new LinkedList[N+1];
		
		for(int i=1; i<=N; i++) adj[i] = new LinkedList();
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v].add(w);
			adj[w].add(v);
		}
		
		visited = new boolean[N+1];
		
		DFS(1);
		System.out.println(cnt-1);
	}

	private static void DFS(int i) {
		
		if(visited[i]) return;
		
		visited[i] = true;
		cnt++;
		for(int x : adj[i]) {
			if(!visited[x]) {
				DFS(x);
			}
		}
		
	}
}
