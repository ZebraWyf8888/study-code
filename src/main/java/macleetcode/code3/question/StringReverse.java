package macleetcode.code3.question;

/**
* @Author: WYF
* @Description:  用递归实现字符串倒转
* @Create: 2020/4/23 23:02
* @Version: 1.0
*/
public class StringReverse {
    public static String reverse(String s){
        if (s == null || s.length()==1) {
            return s;
        }
        return reverse(s.substring(1))+s.charAt(0);
    }
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
