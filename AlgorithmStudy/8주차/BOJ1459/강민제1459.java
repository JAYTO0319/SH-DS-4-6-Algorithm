public class Main1459 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		long min1, min2, min3;
		//1.직진만
		min1 = (X+Y) * W;
		//2.대각선으로만(짝수)
		if((X+Y)%2==0) min2 = Math.max(X,Y) * S;
		//3.대각선으로만(홀수)
		else min2 = (Math.max(X,Y)-1) * S + W;
		//4.대각선+직선
		min3 = Math.min(X,Y) * S + (Math.max(X,Y)-Math.min(X,Y)) * W;
		
		System.out.println(Math.min(Math.min(min1,min2),min3));
	}
}
