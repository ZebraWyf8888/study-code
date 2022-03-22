package day20220322;

public class Solution {
    /**
     * 20220322. 如果相邻两个颜色均相同则删,https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color
     * @param colors
     * @return
     */
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
