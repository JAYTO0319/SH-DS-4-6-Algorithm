import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++){
            sb.append(BinarySearch(Integer.parseInt(token.nextToken()), arr)).append("\n");
        }
        System.out.println(sb);
    }

    public static int BinarySearch(int key, int[] arr){
        int answer = 0;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] < key){
                low = mid + 1;
            }
            else if (arr[mid] > key){
                high = mid - 1;
            }
            else {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}

---------------------------
//Arrays.binarySearch 를 발견하게 되어 다시 작성
    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++){
            sb.append(Arrays.binarySearch(arr, Integer.parseInt(token.nextToken()))<0?0:1).append("\n");
        }
        System.out.println(sb);
        
    }
}

