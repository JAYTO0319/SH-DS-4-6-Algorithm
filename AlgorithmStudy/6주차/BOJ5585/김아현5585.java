import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 김아현5585 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int money = 1000 - Integer.parseInt(stringTokenizer.nextToken());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int result = 0;

       for(int c: coins){
           result += money / c;
           money %= c;
       }
        System.out.println(result);
    }
}
