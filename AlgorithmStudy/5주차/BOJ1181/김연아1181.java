import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new TreeSet<>();

		for(int i = 0; i < N; i ++) {
			set.add(br.readLine());
		}

		StringBuffer sb = new StringBuffer();

		int strLength = 1;
		int count = 0;

		while(count < set.size()) {
			for(String str : set) {
				if(strLength == str.length()) {
					sb.append(str).append("\n");
					count++;
				}
			}
			strLength++;
		}
		System.out.println(sb);
	}
}
