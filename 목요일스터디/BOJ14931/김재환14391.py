import sys



class Solution:  # 14391
    @staticmethod
    def solve():
        rows, cols = map(int, sys.stdin.readline().split())
        board = [list(map(int, sys.stdin.readline().strip())) for _ in range(rows)]

        res = Solution.cal_max_val_of_paper(board, rows, cols)
        print(res)


    @staticmethod
    def cal_max_val_of_paper(board, rows, cols):
        memo = [-1] * (1 << 8)

        def __get_col(col):
            return [row[col] for row in board]


        def __cal_max_val_of_paper(br, bc, er, ec):
            if not (0 <= br <= er < rows and 0 <= bc <= ec < cols):
                return 0

            memo_index = (br << 6) + (bc << 4) + (er << 2) + ec

            if memo[memo_index] != -1:
                return memo[memo_index]

            res = 0

            if br == er:
                res = Solution.digit_list_to_int(board[br][bc:ec+1])
            elif bc == ec:
                res = Solution.digit_list_to_int(__get_col(bc)[br:er+1])
            else:
                for r in range(br, er+1):
                    t1 = __cal_max_val_of_paper(br, bc, r-1, ec)
                    t2 = __cal_max_val_of_paper(r, bc, r, ec)
                    t3 = __cal_max_val_of_paper(r+1, bc, er, ec)
                    res = max(res, t1 + t2 + t3)

                for c in range(bc, ec+1):
                    t1 = __cal_max_val_of_paper(br, bc, er, c-1)
                    t2 = __cal_max_val_of_paper(br, c, er, c)
                    t3 = __cal_max_val_of_paper(br, c+1, er, ec)
                    res = max(res, t1 + t2 + t3)

            memo[memo_index] = res
            return res

        return __cal_max_val_of_paper(0, 0, rows - 1, cols - 1)


    @staticmethod
    def digit_list_to_int(digit_list):
        return int(''.join(map(str, digit_list)))



def main():
    Solution.solve()



if __name__ == '__main__':
    main()
