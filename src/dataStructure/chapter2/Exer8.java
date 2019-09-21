package dataStructure.chapter2;

import java.util.Arrays;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 11:31
 */
public class Exer8 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        permutations(arr,arr.length-1);
    }

    /**
     * 打印全排列,记住题设，这尼玛用返回值是做不了的.返回值最终只能返回一个结果！
     * 递归的过程中不关心任何顺序！只关心执行过程
     *
     * 回溯完整结果的思路时，递归不能减少，这个题的思路可以借鉴汉诺塔
     *
     * 传递的无记忆性和递归还是需要多想一下
     *
     * @param arr
     * @return
     */
    private static void permutations(int[] arr,int pointer){
        if(pointer==0){
            Arrays.stream(arr).forEach(System.out::print);
            System.out.print("\n");
        }else {
            int temp=arr[pointer];
            for (int i = pointer; i >= 0; i--) {
                arr[pointer]=arr[i];
                arr[i]=temp;
                permutations(arr,pointer-1);
                arr[i]=arr[pointer];
                arr[pointer]=temp;
            }
        }
    }

    // TODO: 2019/9/20 全排去重 1123 搞一哈
}
