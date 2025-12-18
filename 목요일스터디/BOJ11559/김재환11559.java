import java.io.*;
import java.util.*;

public class Main {
    static final int R = 12, C = 6;
    static char[][] board = new char[R][C];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c;
        Point(int r, int c) { this.r = r; this.c = c; }
    }

    static List<Point> bfs(int sr, int sc, boolean[][] visited) {
        char color = board[sr][sc];
        ArrayDeque<Point> q = new ArrayDeque<>();
        List<Point> coords = new ArrayList<>();

        visited[sr][sc] = true;
        q.add(new Point(sr, sc));
        coords.add(new Point(sr, sc));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != color) continue;

                visited[nr][nc] = true;
                q.add(new Point(nr, nc));
                coords.add(new Point(nr, nc));
            }
        }
        return coords;
    }

    static void applyGravity() {
        // 각 열마다 아래부터 채우기
        for (int c = 0; c < C; c++) {
            int write = R - 1;
            for (int r = R - 1; r >= 0; r--) {
                if (board[r][c] != '.') {
                    board[write][c] = board[r][c];
                    if (write != r) board[r][c] = '.';
                    write--;
                }
            }
            for (int r = write; r >= 0; r--) board[r][c] = '.';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) board[r][c] = line.charAt(c);
        }

        int chain = 0;

        while (true) {
            boolean[][] visited = new boolean[R][C];
            List<Point> toPop = new ArrayList<>();

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (board[r][c] == '.' || visited[r][c]) continue;
                    List<Point> group = bfs(r, c, visited);
                    if (group.size() >= 4) toPop.addAll(group);
                }
            }

            if (toPop.isEmpty()) break;

            for (Point p : toPop) board[p.r][p.c] = '.';
            applyGravity();
            chain++;
        }

        System.out.println(chain);
    }
}
