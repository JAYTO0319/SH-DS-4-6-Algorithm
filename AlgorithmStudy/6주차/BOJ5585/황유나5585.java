import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};

        int total = 0;
        for(int i = 0; i < coins.length; i++){
            total += money / coins[i];
            money %= coins[i];

            if(money == 0) break;
        }

        System.out.println(total);
    }
}
