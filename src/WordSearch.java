/**
 * https://oj.leetcode.com/problems/word-search/
 * <p/>
 * Created by Penny on 2015/01/23
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        int row = board.length;
        int column = board[0].length;
        boolean[][] used = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (exist(board, used, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, boolean[][] used, int row, int column, String word, int index) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
            return false;

        if (used[row][column])
            return false;

        if (word.charAt(index) != board[row][column])
            return false;

        if (index == word.length() - 1)
            return true;

        used[row][column] = true;

        if (exist(board, used, row - 1, column, word, index + 1))
            return true;

        if (exist(board, used, row + 1, column, word, index + 1))
            return true;

        if (exist(board, used, row, column - 1, word, index + 1))
            return true;

        if (exist(board, used, row, column + 1, word, index + 1))
            return true;

        used[row][column] = false;

        return false;
    }
}
