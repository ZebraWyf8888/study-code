public class 循环打印矩阵 {
    public static int[][] mark(int n){
        if(n == 0 ){
            return null;
        }
        int[][] result = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n -1;
        int num = 1;
        int numEle = n*n;
        while (numEle >= num){
            for (int i = left; i <= right && numEle >= num; i++) {
                result[top][i] = num;
                num++;
            }
            top++;

            for (int i = top; i <= bottom && numEle >= num; i++) {
                result[i][right] = num;
                num++;
            }
            right--;

            for (int i = right; i >= left && numEle >= num; i--) {
                result[bottom][i] = num;
                num++;
            }
            bottom--;

            for (int i = bottom; i >= top && numEle >= num; i--) {
                result[i][left] = num;
                num++;
            }
            left++;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mark = mark(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }

        boolean aaababb = winnerOfGame("AAABABB");


    }

    public static  boolean winnerOfGame(String colors) {
        int freqAlice = 0;
        int freqBob = 0;
        int cnt = 0;
        char preChar = '0';
        for(char c: colors.toCharArray()){
            if(preChar == c){
                cnt++;
            }else{
                cnt = 1;
            }
            if (c == 'A'  && cnt >=3) {
                freqAlice++;
            } else if(c == 'B' && cnt >=3) {
                freqBob++;
            }
            preChar = c;
        }
        return freqAlice > freqBob;
    }
}
