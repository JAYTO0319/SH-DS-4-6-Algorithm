import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] arr; // DFS를 담을 배열
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int v = Integer.parseInt(st.nextToken()); // 시작 정점
		
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		//q = new LinkedList<Integer>(); // BFS를 담을 큐

		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=m; i ++) { // 정점 연결 저장
			String[] where = br.readLine().split(" ");
			int node1 = Integer.parseInt(where[0]);
			int node2 = Integer.parseInt(where[1]);
			
			arr[node1].add(node2);
			arr[node2].add(node1);
		}
		
		for(int i=1; i<=n; i++) { // 정렬
			Collections.sort(arr[i]);
		}
		dfs(v);
		
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		
		q.offer(v); // 시작할 노드번호
		
		visited[v] = true; // 방문처리
		
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node+ " ");
			
			for(int node2: arr[node]) {
				if(!visited[node2]) {
					visited[node2] = true;
					q.offer(node2);
				}
			}
		}
		
		System.out.print(sb);
	}

	private static void dfs(int v) { // 시작 정점
		visited[v] = true; // 방문처리
		System.out.print(v+ " ");
		
		for(int node: arr[v]) {
			if(!visited[node]) { // 노드가 방문한 적 없다면 수행
				dfs(node);
			}
		}
	}
	

}
