import java.io.*;
import java.util.*;

public class B2750 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        // 구현, 정렬
        int N =  Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = 0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}
