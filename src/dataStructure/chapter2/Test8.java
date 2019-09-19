package dataStructure.chapter2;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/11 15:40
 */
//n的阶乘
public class Test8 {
    public static void main(String[] args) {
        System.out.println(factorial1(5));
        System.out.println(factorial2(5));
    }

    private static int factorial1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial1(n - 1);
        }
    }

    private static int factorial2(int n) {
        int result=1;
        for (int i = 1; i < n+1; i++) {
            result=result*i;
        }
        return result;
    }
}
