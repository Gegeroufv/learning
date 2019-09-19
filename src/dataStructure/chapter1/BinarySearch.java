package dataStructure.chapter1;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    private static int[] arr1 = new int[]{1, 2, 3, 4, 8, 9};

    public static void main(String[] args) {
        System.out.println(binarySearch1(arr1, 4));
        System.out.println(binarySearch2(0,arr1.length,arr1,4));
    }

    //循环实现,对于数据就是下标的移动
    public static Integer binarySearch1(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            //防止溢出
            mid = (high - low) / 2 + low;
            if (key > arr[mid]) {
                low = mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //递归实现,这里递归实现比较贴近于我们的实现，比较好一些！
    public static Integer binarySearch2(int low, int high, int[] arr, int key) {
        if(low<=high){
            int mid=(high-low)/2+low;
            if(arr[mid]<key){
                return binarySearch2(mid+1,high,arr,key);
            }else if(arr[mid]>key){
                return binarySearch2(low,mid-1,arr,key);
            }else {
                return mid;
            }
        }else {
            return -1;
        }
    }
}
