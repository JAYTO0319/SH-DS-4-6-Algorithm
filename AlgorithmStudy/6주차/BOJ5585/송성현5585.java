package selfstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5585 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1000엔 지폐를 한장 냈을 때
		int submit = 1000;
		int total_coin = 0;
		// 500엔, 100엔, 50엔, 10엔, 5엔, 1엔 거스름돈 개수가 가장 적게 잔돈
		// 큰 수 부터 나누기하면 거스름돈이 가장 적음.
		// 500엔 나눈 값 = 500엔 동전 수
		// 500엔을 나눈 나머지를 다음 100엔에 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int price = Integer.parseInt(br.readLine());
		submit -= price;
		while (submit >= 1) {
			if (submit >= 500) {
				total_coin += submit / 500;
				submit = submit % 500;
			} else if (submit >= 100) {
				total_coin += submit / 100;
				submit = submit % 100;
			} else if (submit >= 50) {
				total_coin += submit / 50;
				submit = submit % 50;
			} else if (submit >= 10) {
				total_coin += submit / 10;
				submit = submit % 10;
			} else if (submit >= 5) {
				total_coin += submit / 5;
				submit = submit % 5;
			} else if (submit >= 1) {
				total_coin += submit / 1;
				submit = submit % 1;
			}
		}
		System.out.println(total_coin);

	}

}
