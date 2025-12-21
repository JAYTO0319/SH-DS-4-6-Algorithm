import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
			//X%3==0 -> X/3
		//2. X가 2로 나누어 떨어지면, 2로 나눈다.
			//X%2==0 -> X/2
		//3. 1을 뺀다.
			//X -= 1
		//3가지 조건으로 연산 횟수의 최솟값을 출력한다.
		
		
		//3으로 나누는게 제일 좋은 방법
		//그럼 3으로 나뉠 때 까지 -1을 해야하나?
		//이렇게 하면 반례 16에서 걸린다.
		
		
		//어쩔때는 3으로 나누는게 좋고,
		//또 다른 경우는 2로 나누는 것 또는 1을 빼는 것이 좋다.
		//이런 경우를 어떻게 파악?
		//규칙이 있음? 3시간 고민 후 GPT에게 물어보니 규칙 없음 ㅋ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		//1부터 X까지의 배열 생성
		//why? 1,2,3,4,5,6,7... 점차 증가하면서 해당 순간의 최소 연산 값을 넣기 위함.
		// dp 배열을 1부터 X까지 생성하는 이유:
		// 작은 수부터 차례대로 계산해야
		// 이미 계산된 최소값(dp 값)을 이용해
		// 더 큰 수의 최소 연산 횟수를 구할 수 있기 때문
		int[] dp = new int[X+1];
		
		// 초기값 1인경우 최소 연산 0번
		// 이미 1이므로 연산 필요 없음
		dp[1] = 0;
		
		
		//2부터 X까지 차례대로 증가하는데 for문에서 해당 숫자의 최소 연산 값을 비교
		//ex) dp[1] = 0
		//	  		  1. -1인 경우 -> 1+dp[ㅑ-1]
		//			  2. 2로 나눈 경우 -> 1 + dp[i/2]
		//			  3. 3으로 나눈 경우 -> 1 + dp[i/3]
		//				dp[??]의 최소 값은 이미 정해져 있으므로 
		for(int i=2; i<dp.length; i++) {
			
			//연산 -1 하기
			// 항상 가능한 연산이므로 기준값으로 설정
			dp[i] = 1+dp[i-1];
			
			//연산 2로 나뉘는 경우, -1뺀 것과 비교 후 최소 값 dp[i]에 넣기
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
			//연산 3로 나뉘는 경우, -1뺀 것 or 2러 나눈 경우 비교 후 최소 값 dp[i]에 넣기
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		System.out.println(dp[X]);
		
		/*
		 * 2로 나누는 것보다 -1을 해서 3으로 나누는게 더 빠를거라 생각하고 적었지만 틀림
		 * 16이라는 숫자가 그 반례 16은 2로 나누는게 더 빠름
		int count = 0;
		while(X>1) {
			if(X%3==0) {
				X = X/3;
				count++;
				System.out.println("1번 if X : " + X);
			} else if((X-1)%3==0) {
				X -=1;
				count++;
				System.out.println("2번 if X : " + X);
			} else if(X%2==0){
				X = X/2;
				count++;
				System.out.println("3번 if X : " + X);
			}else {
				X -= 1;
				count++;
				System.out.println("4번 if X : " + X);
			}
		}
		*/

	}
	
}
