package dataStructure.chapter2;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 8:01
 */
//计算数据a+aa+aaa+aaaa+...
public class Exer3 {
    public static void main(String[] args) {
        System.out.println(calSum(2, 4));
    }

    private static int calSum(int a, int n) {
        int sum = 0;
        int temp=1;
        for (int i=n; i >= 1;i-- ) {
            sum+=a*temp*i;
            temp*=10;
        }
        return sum;
    }
}
