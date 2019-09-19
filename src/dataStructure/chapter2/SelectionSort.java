package dataStructure.chapter2;

import java.util.Arrays;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/11 15:01
 */
//选择排序 从中倒找最大元素，然后
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr=new int[]{10,23,34,56,3,4,6,0,-1,65,7,6,8};
        Arrays.stream(selecttionSort(arr)).forEach(System.out::println);
    }

    private static int[] selecttionSort(int[] arr){
        int min;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            min=arr[i];
            for (int j = i; j < arr.length; j++) {
                if(min>arr[j]){
                    temp=arr[j];
                    arr[j]=min;
                    min=temp;
                }
            }
            arr[i]=min;
        }
        return arr;
    }

}
