import java.io.*;
import java.util.*;

public class B20551 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrB = new int[N];
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrB);

        int[] arrD = new int[M];
        for (int i = 0; i < M; i++) {
            arrD[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int firstIndex = find(arrB, arrD[i]);
            // firstIndex는 arrD가 아니라 arrB의 길이보다 무조건 작아야 한다.
            if (firstIndex >= arrB.length || firstIndex < 0) {
                sb.append(-1 + "\n");
            } else if (arrB[firstIndex] != arrD[i]) {
                sb.append(-1 + "\n");
            } else {
                sb.append(firstIndex + "\n");
            }
        }
        System.out.println(sb);
    }

    private static int find(int[] arr, int my) {
        int min = 0;
        int max = arr.length; // N

        while (min < max) {
            int mid = (min + max) / 2;
            if (arr[mid] >= my) {
                max = mid;
            } else if (arr[mid] < my) {
                min = mid + 1;
            }
        }
        return min;
    }
}
