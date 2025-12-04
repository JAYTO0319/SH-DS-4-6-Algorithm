package algorithm.study.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();

		int a = Integer.parseInt(br.readLine());

		for (int i = 0; i < a; i++) {
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>(set);

		Collections.sort(list, (String s1, String s2) -> {
			if (s1.length() != s2.length()) {
				return s1.length() - s2.length();
			}
			return s1.compareTo(s2);
		});

		for (String data : list) {
			System.out.println(data);
		}

	}
}
