package dataStructure.chapter2;

import dataStructure.chapter2.pojo.DoubleLinkedHead;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 11:21
 */
public class Exer7 {
    public static void main(String[] args) {
        System.out.println(countLength(1.0));
        System.out.println(countLength2(1.0));
    }

    private static double countLength(Double h) {
        if (Math.pow(10, -6) > h) {
            return 0;
        } else {
            return 0.9 * h + countLength(0.9 * h);
        }
    }

    private static double countLength2(Double h){
        double sum=0.0;
        while (Math.pow(10, -6) <= h){
            h = 0.9 * h;
            sum+=h;
        }
        return sum;
    }
}
