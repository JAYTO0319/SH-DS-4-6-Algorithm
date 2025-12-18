import java.io.*;
import java.util.*;

public class Main {

    static int N, R, size;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        size = 1 << N;
        A = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            applyOperation(k, l);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void applyOperation(int k, int l) {
        int s = 1 << l;        // block size
        int nb = size / s;    // number of blocks per row
        int[][] B = new int[size][size];

        for (int i = 0; i < size; i++) {
            int bi = i / s;
            int ii = i % s;

            for (int j = 0; j < size; j++) {
                int bj = j / s;
                int jj = j % s;

                int nbi = bi, nbj = bj;
                int nii = ii, njj = jj;

                switch (k) {
                    case 1: // block 내부 상하 반전
                        nii = s - 1 - ii;
                        break;
                    case 2: // block 내부 좌우 반전
                        njj = s - 1 - jj;
                        break;
                    case 3: // block 내부 시계 회전
                        nii = jj;
                        njj = s - 1 - ii;
                        break;
                    case 4: // block 내부 반시계 회전
                        nii = s - 1 - jj;
                        njj = ii;
                        break;
                    case 5: // block 상하 반전
                        nbi = nb - 1 - bi;
                        break;
                    case 6: // block 좌우 반전
                        nbj = nb - 1 - bj;
                        break;
                    case 7: // block 시계 회전
                        nbi = bj;
                        nbj = nb - 1 - bi;
                        break;
                    case 8: // block 반시계 회전
                        nbi = nb - 1 - bj;
                        nbj = bi;
                        break;
                }

                int ni = nbi * s + nii;
                int nj = nbj * s + njj;
                B[ni][nj] = A[i][j];
            }
        }

        A = B;
    }
}
