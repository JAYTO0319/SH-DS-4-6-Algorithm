import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        population = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                adj[i].add(x);
            }
        }

        int answer = Integer.MAX_VALUE;

        // 모든 부분 집합 분할
        for (int mask = 1; mask < (1 << N); mask++) {
            ArrayList<Integer> group1 = new ArrayList<>();
            ArrayList<Integer> group2 = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    group1.add(i);
                } else {
                    group2.add(i);
                }
            }

            if (group1.isEmpty() || group2.isEmpty()) continue;

            if (isConnected(group1) && isConnected(group2)) {
                int sum1 = 0, sum2 = 0;
                for (int idx : group1) sum1 += population[idx];
                for (int idx : group2) sum2 += population[idx];
                answer = Math.min(answer, Math.abs(sum1 - sum2));
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static boolean isConnected(ArrayList<Integer> group) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int nxt : adj[curr]) {
                if (!visited[nxt] && group.contains(nxt)) {
                    visited[nxt] = true;
                    queue.add(nxt);
                    count++;
                }
            }
        }
        return count == group.size();
    }
}
