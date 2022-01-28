package java8.com.offer;

public class AddALL {

    public static void main(String[] args) {
        int[] a = {7,6,7,3,100,1,7,8,6,4};
        //int sum = addAll(a,0);//从头来
        //int sum = addAll2(a, a.length-1);//从尾巴来
        int sum = addAll3(a, 0,a.length-1);//从尾巴来
        System.out.println(sum);
    }

    /**
     * @Description ： 实现递归累加
     * @Param: [a]：要累加的数组 begin：
     * @Return: int：累加值
     * @Author: WYF
     * @Date: 2020/1/12 11:26
    */
    private static int addAll(int[] a,int begin) {
        //问题核心：传入的数组a压根没变，怎么搞
        //踢皮球【.自己加[.....给别人去加]】
        //要多加一个参数
        if (begin >= a.length) {
            return 0;
        }
        return a[begin] + addAll(a,begin+1);
    }

    /**
     * @Description:
     * @Param: [a, end] a是要累加的数组，end是结束位置
     * @Return: int
     * @Author: WYF
     * @Date: 2020/1/12 12:36
    */
    private static int addAll2(int[] a,int end) {
        //问题核心：传入的数组a压根没变，怎么搞
        //踢皮球【[.....给别人去加].自己加】
        //要多加一个参数
        if (end < 0) {
            return 0;
        }
        return a[end] + addAll2(a,end-1);
    }

    /**
     * @Description: 折半式累加
     * @Param: [a：累加的数组, begin：起始位置, end：结束位置]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/1/12 13:10
    */
    private static int addAll3(int[] a,int begin,int end) {
        //问题核心：传入的数组a压根没变，怎么搞?加参数呗
        //踢皮球【[.....给别人去加].自己加[.....给别人去加]】
        //要多加2个参数
        if (begin==end) {
            return a[begin];
        }else if (end-begin==1){
            return a[end]+a[begin];
        }
        int mid = (begin + end) / 2;
        return addAll3(a,begin,mid-1) + a[mid] + addAll3(a,mid+1,end);
    }
}
