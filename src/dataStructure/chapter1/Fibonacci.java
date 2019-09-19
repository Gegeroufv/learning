package dataStructure.chapter1;

/**
 * 1,1,2,3,5,8,13,21,34,55
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(primitive(20));
        System.out.println(someCache(20));
    }

    //原始算法等。。。
    private static Integer primitive(int i) {
        if (i < 1) {
            return -1;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        int after = primitive(i - 2);
        int before = primitive(i - 1);
        return after + before;
    }

    private static Integer someCache(int i) {
        if (i < 1) {
            return -1;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        int cache=0;
        int after=1;
        int before=1;
        for (int index = 3; index <= i; index++) {
            cache=after+before;
            after=before;
            before=cache;
        }
        return cache;
    }
}
