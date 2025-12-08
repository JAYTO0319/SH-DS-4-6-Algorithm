import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_20551 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		int[] arr = new int[N];

		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < M; i ++) {
			
			int num = Integer.parseInt(br.readLine());
			int result = BinarySearch(num, arr);
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);

	}
	
    public static int BinarySearch(int key, int[] arr){
	  int answer = -1;
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
	    	  mid -= 1;
	          
	    	  if (mid<0 || arr[mid] != key) {
	    		  answer = mid+1;
	    		  break;
	    	  }
	    	  
	    	  while(mid>=0 && arr[mid] == key) {
	    		  mid-=1;
	          }

	    	  mid+=1;
	    	  answer = mid;
	    	  break;
	      }
	  }
	  return answer;
	}
	
}
