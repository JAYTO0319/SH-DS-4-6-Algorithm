import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }

        long M = Long.parseLong(br.readLine());

        // 모든 요청이 배정 가능하면 요청의 최대값
        if (sum <= M) {
            System.out.println(max);
            return;
        }

        int low = 0, high = max;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int a : arr) {
                total += Math.min(a, mid);
            }

            if (total <= M) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
