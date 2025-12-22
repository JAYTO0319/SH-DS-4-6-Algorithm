import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i <= n; i++) Collections.sort(graph[i]);
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	static void dfs(int u) {
		visited[u] = true;
		sb.append(u).append(" ");
		for (int v : graph[u]) {
			if (!visited[v]) dfs(v);
		}
	}
	
	static void bfs(int u) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.addFirst(u);
		visited[u] = true;
		while (!q.isEmpty()) {
			int cur = q.removeLast();
			sb.append(cur).append(" ");
			for (int v : graph[cur]) {
				if (!visited[v]) {
					visited[v] = true;
					q.addFirst(v);
				}
			}
		}
	}
	
}
