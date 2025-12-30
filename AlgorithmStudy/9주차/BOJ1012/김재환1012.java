import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 배추밭 표시 (N행 M열)
            int[][] field = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            boolean[][] visited = new boolean[N][M];
            int count = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (field[r][c] == 1 && !visited[r][c]) {
                        // BFS로 연결된 모든 배추 처리
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.add(new int[]{r, c});
                        visited[r][c] = true;

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            int cr = cur[0], cc = cur[1];
                            for (int d = 0; d < 4; d++) {
                                int nr = cr + dr[d];
                                int nc = cc + dc[d];
                                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                                    if (field[nr][nc] == 1 && !visited[nr][nc]) {
                                        visited[nr][nc] = true;
                                        queue.add(new int[]{nr, nc});
                                    }
                                }
                            }
                        }
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
