package dataStructure.chapter1;

public class Test2 {
    public static void main(String[] args) {
        testPrint(10000000);

    }
    //简单的递归打印函数
    private static void testPrint(Integer num) {
        System.out.println(num);
        if (num > 0) {
            testPrint(num - 1);
        }
    }
}
