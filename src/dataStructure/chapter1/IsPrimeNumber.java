package dataStructure.chapter1;


/**
 * 判断是否为质数
 * https://blog.csdn.net/afei__/article/details/80638460
 */
public class IsPrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(7));
        System.out.println(someEnhance(7));
        System.err.println(isPrimeNumber3(7));
    }

    /**
     * 效率过低
     *
     * @param num
     * @return
     */
    private static Boolean isPrimeNumber(int num) {
        if (num <= 3) {
            return true;
        }
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对数学原理需要有一定了解，这里使用控制范围的方式，这里采用的是控制和数
     * 这里临界条件很难观察
     * 质数为和数，质数没办法开方 所以有a + b且两者可以开方
     *
     * @param num
     * @return
     */
    private static Boolean someEnhance(int num) {
        if (num <= 3) {
            return true;
        }
        int sqart = new Double(Math.sqrt(num)).intValue();
        for (int i = 2; i <= sqart; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这里使用数值优化,对于素数的观察
     *
     * @param num
     * @return
     */
    private static Boolean isPrimeNumber3(int num) {
        if (num <= 3) {
            return true;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqt = new Double(Math.sqrt(num)).intValue();
        for (int i = 5; i <= sqt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
