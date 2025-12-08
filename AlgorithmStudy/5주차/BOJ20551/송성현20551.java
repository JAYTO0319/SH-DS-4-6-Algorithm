package selfstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//순서를 지키기 위해서 list를 사용했다.
//받은 것을 오름차순으로 정렬해야하기 때문에 sort를 사용했어.
//그래서 나는 이제 오름차순으로 정렬한 것을 하나씩 돌리면서 비교 후 값이 없으면 -1, 있으면 해당 위치를 찾으려고 하는데
//내가 2중 for문을 사용해서 돌려봤는데 일단 예제의 답은 맞아 하지만 시간초과ㅜㅜ
//만약 List를 map으로 변경했을 때 괜찮을지도...?
//갓재환


public class bj20551_wow {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 제자들에게 N개의 원소를 가진 배열A
		String[] count = br.readLine().split(" ");
		
		//정렬하기 위해 List사용
		//처음에 String으로 받았더니 오름차순을 한 경우 10이 맨 앞으로 간다.
		//따라서 Integer로 수정해서 받음.
		List<Integer> N_arr = new ArrayList<Integer>();
		for(int i=0; i<Integer.parseInt(count[0]); i++) {
			N_arr.add(Integer.parseInt(br.readLine()));
		}
		
		//오름차순으로 정렬된 배열B
		Collections.sort(N_arr);
		System.out.println("N_arr" + N_arr);
		
		//map의 key에 원소를 넣고 value에는 원소의 index값을 넣기 단, 원소가 있다면 index만 증가 후 넘어가기
		int k=0;
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for(int data:N_arr) {
			if(map.containsKey(data)) {
				k++;
				continue;
			}
			map.put(data, k);
			k++;
		}
		System.out.println("map " + map);
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<Integer.parseInt(count[1]); i++) {
			int data = Integer.parseInt(br.readLine());
			if(map.containsKey(data)) {
				//N_arr.indexOf(data);
				//가장 먼저 등장한 위치를 출력
				sb.append(map.get(data)+"\n");	
			}else {
				//가장 먼저 등장한 위치를 출력, 존재하지 않는 경우에는 -1를 출력
				sb.append(-1+"\n");
			}
		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
}
