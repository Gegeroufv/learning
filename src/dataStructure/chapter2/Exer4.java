package dataStructure.chapter2;

import java.util.Arrays;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 8:48
 */
//整数序列链表插入已经实现，现在插入有序数列
public class Exer4 {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,4,3};
        Arrays.stream(selectSort(arr)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(insertArr(arr,9)).forEach(System.out::print);

    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    private static int[] selectSort(int[] arr){
        int temp;
        int tempIndex;
        for (int i = 0; i < arr.length; i++) {
            temp=arr[i];
            tempIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<temp){
                    temp=arr[j];
                    tempIndex=j;
                }
            }
            arr[tempIndex]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    private static int[] insertArr(int[] arr,int num){
        int[] temp=new int[arr.length+1];
        for (int i = 0; i < temp.length; i++) {
            if(i<arr.length){
                temp[i]=arr[i];
            }else {
                temp[i]=num;
            }
        }
        return selectSort(temp);
    }
}
