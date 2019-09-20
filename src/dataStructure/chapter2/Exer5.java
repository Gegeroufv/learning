package dataStructure.chapter2;

import java.util.Arrays;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 10:26
 */
//两个递增链表合并为一个递增的链表
public class Exer5 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 7, 9};
        int[] arr2 = new int[]{2, 3, 4, 6, 8, 9, 10};
        Arrays.stream(merge(arr1, arr2)).forEach(System.out::println);
    }


    private static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        boolean flag1=true;
        boolean flag2=true;
        for (int k = 0; k < arr.length; k++) {
            if(i==arr1.length){
                flag1=false;
            }
            if(j==arr2.length){
                flag2=false;
            }

            if(flag1&&flag2){
                if(arr1[i]<arr2[j]){
                    arr[k]=arr1[i];
                    i++;
                }else if (arr1[i]>arr2[j]){
                    arr[k]=arr2[j];
                    j++;
                }else {
                    arr[k]=arr1[i];
                    arr[k+1]=arr2[j];
                    k++;
                    i++;
                    j++;
                }
            }else if (flag1){
                arr[k]=arr1[i];
                i++;
            }else if (flag2){
                arr[k]=arr2[j];
                j++;
            }
        }
        return arr;
    }
}
