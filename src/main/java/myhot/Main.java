package myhot;

public class Main {
    /**
     * 快排寻找第k大大数字，不交换节点
     * @param args
     */
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        int [] arr = new int[]{3,5,1,6,4,7,8,2};
        System.out.println(findKthNum(arr, 3));
    }

    public static int findKthNum(int[] nums,int k){
        int l = 0;
        int r = nums.length -1;
        k-=1;
        while(l<r){
            int idx = partition(nums, l, r);
            if(idx == k){
                break;
            }else if(idx >k){
                r = idx-1;
            }else if(idx < k){
                l = idx+1;
            }
        }
        return nums[k];
    }

    public static int partition(int[] nums,int l,int r){
        int key = nums[l];
        while(l<r){
            while(l<r && nums[r]<=key){
                r--;
            }
            nums[l] = nums[r];
            while(l<r && nums[l]>=key){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        return l;
    }
}