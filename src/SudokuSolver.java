/**
 * https://oj.leetcode.com/problems/sudoku-solver/
 * <p/>
 * Created by Penny on 2015/01/20
 */
public class SudokuSolver {
    /**
     * 参考：http://www.cnblogs.com/ganganloveu/p/3828401.html
     */
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    private boolean solveSudoku(char[][] board, int pos) {
        if (pos == 81)
            return true;

        int row = pos / 9;
        int column = pos % 9;

        if (board[row][column] != '.')
            return solveSudoku(board, pos + 1);
        else {
            for (int i = 1; i <= 9; i++) {
                board[row][column] = (char) ('0' + i);
                if (isValid(board)) {
                    if (solveSudoku(board, pos + 1))
                        return true;
                }
                // board[row][column] = '.';
            }
            return false;
        }
    }

    private boolean isValid(char[][] board) {
        for (int i = 0; i < 9; i++)
            if (isValid(board, i, true) == false || isValid(board, i, false) == false)
                return false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValid(board, i * 3, j * 3) == false)
                    return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int index, boolean horizontal) {
        int[] flag = new int[10];
        char c;
        for (int i = 0; i < 9; i++) {
            if (horizontal)
                c = board[index][i];
            else
                c = board[i][index];

            if (c == '.')
                continue;

            int value = c - 48;
            if (flag[value] == 1)
                return false;
            else
                flag[value] = 1;
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        int[] flag = new int[10];
        char c;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                c = board[k + i][l + j];
                if (c == '.')
                    continue;

                int value = c - 48;
                if (flag[value] == 1)
                    return false;
                else
                    flag[value] = 1;
            }
        }

        return true;
    }
}
