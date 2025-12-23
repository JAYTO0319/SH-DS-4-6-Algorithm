import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[1001];
        int minL = 1000, maxL = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            heights[l] = h;
            minL = Math.min(minL, l);
            maxL = Math.max(maxL, l);
        }

        int maxH = 0;
        for (int x = minL; x <= maxL; x++) maxH = Math.max(maxH, heights[x]);

        int leftMax = -1, rightMax = -1;
        for (int x = minL; x <= maxL; x++) {
            if (heights[x] == maxH) { leftMax = x; break; }
        }
        for (int x = maxL; x >= minL; x--) {
            if (heights[x] == maxH) { rightMax = x; break; }
        }

        long area = 0;

        // 왼쪽 -> leftMax
        int cur = 0;
        for (int x = minL; x < leftMax; x++) {
            cur = Math.max(cur, heights[x]);
            area += cur;
        }

        // 오른쪽 -> rightMax
        cur = 0;
        for (int x = maxL; x > rightMax; x--) {
            cur = Math.max(cur, heights[x]);
            area += cur;
        }

        // 가운데(최고 높이 구간)
        area += (long) maxH * (rightMax - leftMax + 1);

        System.out.println(area);
    }
}
