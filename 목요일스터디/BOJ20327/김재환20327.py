import sys
input = sys.stdin.readline

def solve():
    N, R = map(int, input().split())
    size = 1 << N  # 2^N

    A = [list(map(int, input().split())) for _ in range(size)]

    for _ in range(R):
        k, l = map(int, input().split())
        s = 1 << l          # block size = 2^l
        nb = size // s      # number of blocks per row/col

        B = [[0] * size for _ in range(size)]

        for i in range(size):
            bi, ii = divmod(i, s)   # block row, in-block row
            for j in range(size):
                bj, jj = divmod(j, s)  # block col, in-block col

                # default: block stays, inside stays
                nbi, nbj = bi, bj
                nii, njj = ii, jj

                if k == 1:      # flip inside block vertically
                    nii = s - 1 - ii
                elif k == 2:    # flip inside block horizontally
                    njj = s - 1 - jj
                elif k == 3:    # rotate inside block right
                    nii, njj = jj, s - 1 - ii
                elif k == 4:    # rotate inside block left
                    nii, njj = s - 1 - jj, ii
                elif k == 5:    # flip blocks vertically
                    nbi = nb - 1 - bi
                elif k == 6:    # flip blocks horizontally
                    nbj = nb - 1 - bj
                elif k == 7:    # rotate blocks right
                    nbi, nbj = bj, nb - 1 - bi
                elif k == 8:    # rotate blocks left
                    nbi, nbj = nb - 1 - bj, bi

                ni = nbi * s + nii
                nj = nbj * s + njj
                B[ni][nj] = A[i][j]

        A = B

    out = []
    for row in A:
        out.append(" ".join(map(str, row)))
    print("\n".join(out))

if __name__ == "__main__":
    solve()
