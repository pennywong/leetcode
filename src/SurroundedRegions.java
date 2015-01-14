import java.util.LinkedList;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/surrounded-regions/
 * <p/>
 * Created by Penny on 2015/01/14
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null)
            return;
        int row = board.length;
        if (row <= 1)
            return;
        int column = board[0].length;
        if (column <= 1)
            return;

        Queue<String> queue = new LinkedList<String>();

        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O')
                queue.add("0," + i);

            if (board[row - 1][i] == 'O')
                queue.add((row - 1) + "," + i);
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                queue.add(i + ",0");

            if (board[i][column - 1] == 'O')
                queue.add(i + "," + (column - 1));
        }

        while (!queue.isEmpty()) {
            String string = queue.poll();
            String[] strings = string.split(",");
            int i = Integer.parseInt(strings[0]);
            int j = Integer.parseInt(strings[1]);
            board[i][j] = 'Z';

            if (i - 1 > 0 && board[i - 1][j] == 'O')
                queue.add((i - 1) + "," + j);
            if (i + 1 < row && board[i + 1][j] == 'O')
                queue.add((i + 1) + "," + j);
            if (j - 1 > 0 && board[i][j - 1] == 'O')
                queue.add(i + "," + (j - 1));
            if (j + 1 < column && board[i][j + 1] == 'O')
                queue.add(i + "," + (j + 1));
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == 'Z')
                    board[i][j] = 'O';
            }
        }
    }
}
