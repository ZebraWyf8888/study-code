package macleetcode.day908;

import java.util.Scanner;

public class Main2 {
    private static int[][] dirction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        char[][] board = {

                {'A', 'B', 'C', 'E'},

                {'S', 'F', 'C', 'S'},

                {'A', 'D', 'E', 'E'}

        };

        int row = board.length;
        int col = board[0].length;
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        boolean[][] isMark = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0, next, board, isMark)) {
                    System.out.println(true);
                    System.exit(0);
                }
            }
        }
        System.out.println(false);
    }

    private static boolean dfs(int i, int j, int start, String next, char[][] board, boolean[][] isMark) {
        if (start == next.length() - 1) {
            return board[i][j] == next.charAt(start);
        }
        if (next.charAt(start) == board[i][j]) {
            isMark[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newx = i + dirction[k][0];
                int newy = j + dirction[k][1];
                if (newx < 4 && newx >= 0 && newy >= 0 && newy < 4) {
                    if (dfs(newx, newy, start + 1, next, board, isMark)) {
                        return true;
                    }
                }
            }
            isMark[i][j] = false;
        }
        return false;
    }
}
