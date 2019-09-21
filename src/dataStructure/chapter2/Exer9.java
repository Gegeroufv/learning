package dataStructure.chapter2;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 递归的返回值是很重要的递归传递的手段
 * 观察汉诺塔和全排列都是递归问题通过增大问题的规模来解决的。
 * 但是如果只有一个结果的只能通过传递统一的值
 *
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 14:54
 */
//递归排序，实现对n个整数的排序
public class Exer9 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 5, 4, 6};
        Arrays.stream(sort(arr,0)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(sort2(arr)).forEach(System.err::print);
    }


    //转换为对n-1个整数排序问题的递归
    private static int[] sort(int[] arr, int pointer) {
        if (pointer == arr.length - 1) {
            return arr;
        } else {
            int min = arr[pointer];
            int minIndex = pointer;
            int temp;
            for (int i = pointer + 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            temp = arr[pointer];
            arr[pointer] = min;
            arr[minIndex] = temp;
            return sort(arr, pointer + 1);
        }
    }

    /**
     * 最烂快排而且写的有问题，在不断的创建数组
     * @param arr
     * @return
     */
    private static int[] sort2(int[] arr) {
        if(arr.length==1){
            return arr;
        }

        int[] leftTemp=new int[arr.length/2];
        for (int i = 0; i < arr.length/2; i++) {
            leftTemp[i]=arr[i];
        }
        int[] rightTemp=new int[arr.length-arr.length/2];
        for (int i = arr.length/2; i < arr.length; i++) {
            rightTemp[i-arr.length/2]=arr[i];
        }

        int[] leftArr=sort2(leftTemp);
        int[] rightArr=sort2(rightTemp);

        int[] result=new int[leftArr.length+rightArr.length];
        int i=0;
        int j=0;
        boolean flag1=true;
        boolean flag2=true;
        for (int k = 0; k < result.length; k++) {
            if(j==rightArr.length){
                flag2=false;
            }
            if(i==leftArr.length){
                flag1=false;
            }
            if(flag1&&flag2){
                if(leftArr[i]<rightArr[j]){
                    result[k]=leftArr[i];
                    i++;
                }else if(leftArr[i]>rightArr[j]){
                    result[k]=rightArr[j];
                    j++;
                }else {
                    result[k]=leftArr[i];
                    result[k+1]=rightArr[j];
                    k++;
                    j++;
                    i++;
                }
            }else if (flag1){
                arr[k]=leftArr[i];
                i++;
            }else if (flag2){
                arr[k]=rightArr[j];
                j++;
            }
        }
        return arr;
    }
}
