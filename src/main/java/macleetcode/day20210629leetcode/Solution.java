package macleetcode.day20210629leetcode;

class Solution {
    public String convertToTitle(int columnNumber) {
        int temp = columnNumber;
        StringBuilder ans = new StringBuilder();
        while(temp>0){
            int num = temp%26;
            if (num == 0){
                ans.append('Z');
                temp = temp/26;
                continue;
            }
            char i = (char)( num + 'A'-1);
            ans.append(i);
            temp = temp/26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.convertToTitle(26);
        System.out.println(s);
    }
}