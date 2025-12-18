import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            l = (int) Math.pow(2, l);
            switch(k) {
                case 1: rotate1(n, n, n, l); break;
                case 2: rotate2(n, n, n, l); break;
                case 3: rotate3(n, n, n, l); break;
                case 4: rotate4(n, n, n, l); break;
                case 5: rotate5(l); break;
                case 6: rotate6(l); break;
                case 7: rotate7(l); break;
                case 8: rotate8(l); break;
                default: break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void rotate8(int l) {
    	int[][] arr = new int[n][n];
    	for (int ni = 0; ni < n / l; ni++) {
    		for (int nj = 0; nj < n / l; nj++) {
    			for (int i = ni * l; i < ni*l + l; i++) {
    				for (int j = nj * l; j < nj*l + l; j++) {
    					arr[(n/l - nj - 1)*l + i - ni*l][ni*l + j - nj*l] = map[i][j];
    				}
    			}
    		}
    	}
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			map[i][j] = arr[i][j];
    		}
    	}
    }
    private static void rotate7(int l) {
    	int[][] arr = new int[n][n];
    	for (int ni = 0; ni < n / l; ni++) {
    		for (int nj = 0; nj < n / l; nj++) {
    			for (int i = ni * l; i < ni*l + l; i++) {
    				for (int j = nj * l; j < nj*l + l; j++) {
    					arr[nj*l + i - ni*l][(n/l - ni - 1)*l + j - nj*l] = map[i][j];
    				}
    			}
    		}
    	}
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			map[i][j] = arr[i][j];
    		}
    	}
    }
    private static void rotate6(int l) {
    	for (int ni = 0; ni < n / l; ni++) {
    		for (int nj = 0; nj < n/ l / 2; nj++) {
    			for (int i = ni * l; i < ni*l + l; i++) {
    				for (int j = nj * l; j < nj*l + l; j++) {
    					int tmp = map[i][j];
    					map[i][j] = map[i][(n/l - nj - 1)*l + j - nj*l];
    					map[i][(n/l - nj - 1)*l + j - nj*l] = tmp;
    				}
    			}
    		}
    	}
    }
    private static void rotate5(int l) {
    	for (int ni = 0; ni < n / l / 2; ni++) {
    		for (int nj = 0; nj < n/ l; nj++) {
    			for (int i = ni * l; i < ni*l + l; i++) {
    				for (int j = nj * l; j < nj*l + l; j++) {
    					int tmp = map[i][j];
    					map[i][j] = map[(n/l - ni - 1)*l + i - ni*l][j];
    					map[(n/l - ni - 1)*l + i - ni*l][j] = tmp;
    				}
    			}
    		}
    	}
    }
    private static void rotate4(int curI, int curJ, int curl, int l) {
        if (curl == l) {
        	//두 부분으로 나눠서 연산
        	//1. 새 배열에 회전 결과 저장
        	int[][] arr = new int[l][l];
        	for (int i = 0; i < l; i++) {
        		for (int j = 0; j < l; j++) {
        			arr[l - j - 1][i] = map[curI - l + i][curJ - l + j];
        		}
        	}
        	//2. 원래 배열에 새 배열 결과 덮어쓰기
        	for (int i = 0; i < l; i++) {
        		for (int j = 0; j < l; j++) {
        			map[curI - l + i][curJ - l + j] = arr[i][j];
        		}
        	}
            return;
        }
        
        rotate4(curI - curl / 2, curJ - curl/2, curl/2, l);
        rotate4(curI, curJ, curl/2, l);
        rotate4(curI, curJ - curl/2, curl/2, l);
        rotate4(curI - curl / 2, curJ, curl/2, l);
    }
    private static void rotate3(int curI, int curJ, int curl, int l) {
        if (curl == l) {
        	//두 부분으로 나눠서 연산
        	//1. 새 배열에 회전 결과 저장
        	int[][] arr = new int[l][l];
        	for (int i = 0; i < l; i++) {
        		for (int j = 0; j < l; j++) {
        			arr[j][l - i - 1] = map[curI - l + i][curJ - l + j];
        		}
        	}
        	//2. 원래 배열에 새 배열 결과 덮어쓰기
        	for (int i = 0; i < l; i++) {
        		for (int j = 0; j < l; j++) {
        			map[curI - l + i][curJ - l + j] = arr[i][j];
        		}
        	}
            return;
        }
        
        rotate3(curI - curl / 2, curJ - curl/2, curl/2, l);
        rotate3(curI, curJ, curl/2, l);
        rotate3(curI, curJ - curl/2, curl/2, l);
        rotate3(curI - curl / 2, curJ, curl/2, l);
    }
    private static void rotate2(int curI, int curJ, int curl, int l) {
        if (curl == l) {
            //연산
            for (int i = 0; i < l; i++) {
            	for (int j = 0; j < l/2; j++) {
            		int tmp = map[curI - l + i][curJ - l + j];
            		map[curI - l + i][curJ - l + j] = map[curI - l + i][curJ - j - 1];
            		map[curI - l + i][curJ - j - 1] = tmp;
            	}
            }
            return;
        }
        
        rotate2(curI - curl / 2, curJ - curl/2, curl/2, l);
        rotate2(curI, curJ, curl/2, l);
        rotate2(curI, curJ - curl/2, curl/2, l);
        rotate2(curI - curl / 2, curJ, curl/2, l);
    }
    private static void rotate1(int curI, int curJ, int curl, int l) {
        if (curl == l) {
            //연산
            for (int i = 0; i < l/2; i++) {
            	for (int j = 0; j < l; j++) {
            		int tmp = map[curI - l + i][curJ - l + j];
            		map[curI - l + i][curJ - l + j] = map[curI - i - 1][curJ - l + j];
            		map[curI - i - 1][curJ - l + j] = tmp;
            	}
            }
            return;
        }
        
        rotate1(curI - curl / 2, curJ - curl/2, curl/2, l);
        rotate1(curI, curJ, curl/2, l);
        rotate1(curI, curJ - curl/2, curl/2, l);
        rotate1(curI - curl / 2, curJ, curl/2, l);
    }
}
