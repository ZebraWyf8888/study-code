package java8.com;
/**
* @Author: WYF
* @Description: 递归回溯，八皇后问题
* @Create: 2020/4/3 16:04
* @Version: 1.0
*/
public class FindQueen {
    public static int[][] array = new int[8][8];
    public static int map = 0;

    public static void main(String[] args) {
        System.out.println("start!");
        findQueen(0);
        System.out.println("end!");
    }

    private static void findQueen(int row) {
        if (row>7) {
            map++;
            printQueens();
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (check1(row,i)) {
                array[row][i] = 1;
                findQueen(row+1);
                array[row][i] = 0;
            }
        }
    }

    private static boolean check1(int row, int i) {
        for (int j = 0; j < row; j++) {
            if (array[j][i] == 1){
                return false;
            }
        }
        for (int x = row-1,y = i-1; x>=0&& y>=0; x--,y--) {
            if (array[x][y] == 1){
                return false;
            }
        }
        for (int x = row-1,y = i+1; x>=0&& y<8; x--,y++) {
            if (array[x][y] == 1){
                return false;
            }
        }
        return true;
    }

    private static void printQueens() {
        System.out.print("方案"+map+":"+"\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (array[i][j] == 1) {
                    System.out.print("0 ");
                }else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
