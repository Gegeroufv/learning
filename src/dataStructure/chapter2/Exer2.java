package dataStructure.chapter2;

import java.util.Arrays;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/19 18:00
 */
public class Exer2 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(leftMove(arr, 3)).forEach(System.err::println);
    }

    /**
     * 数组问题必须画图，否则思路对了也很难写对！！！
     *
     * @param arr
     * @param m
     * @return
     */
    private static int[] leftMove(int[] arr, int m) {
        if (m > arr.length) {
            throw new RuntimeException("m超过数组界限");
        }
        //先缓存之前的m个
        int[] tempArr = new int[m];
        for (int i = 0; i < m; i++) {
            tempArr[i] = arr[i];
        }
        //左移
        for (int i = m; i < arr.length; i++) {
            arr[i - m] = arr[i];
        }
        for (int i = arr.length - m; i < arr.length; i++) {
            arr[i] = tempArr[i - arr.length + m];
        }
        return arr;
    }
}
