package dataStructure.chapter1;

//求最大子列和
public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 4, 5, -1, -22, 2, -1, 3, -6
        };
        maxSubSum1(arr);
    }

    //暴力法，for循环条件从后向前
    private static void maxSubSum1(int[] arr) {
        int max = 0;
        int temp = 0;

    }
}
