package dataStructure.chapter2;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/12 16:42
 */


/**
 * 做题前最重要的是先把流程图跑好再动手
 * 不要首先让各种异常的思路打断你的思考
 * <p>
 * 这个思路还是有问题，考虑问题的时间多考虑下自己的技巧
 */
public class Test10 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 3, 5, 6, 7};
        int i = search2Mid(arr, 4);
        System.out.println(i);
    }

    //获取第k大的数
    private static int search2Mid(int[] arr, int n) {
        return search2MidStage(arr, n, 0, arr.length - 1);
    }

    /**
     * 多思考本质，分割数组，分割的方式就是在分割点的左边比右边大
     * 这里不需要排序，只是需要分割点左边比右边大，所以对左边的顺序没有要求！
     * 真笨啊！！！
     *
     * 这里不是每次去减量，实际是每次减少夹逼，最终只剩下一个
     * @param arr   待求值的数组
     * @param offset   对于left的偏移量,不是给的中间的值
     * @param left  左边遍历开始点
     * @param right 右边遍历开始点
     * @return
     */
    private static int search2MidStage(int[] arr, int offset, int left, int right) {
        int i = left;
        int j = right;
        int line = arr[left];
        int temp;
        while (true) {
            while (i <= j && arr[i] >= line) {
                i++;
            }
            while (i < j && arr[j] < line) {
                j--;
            }
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }
        temp = arr[i - 1];
        arr[i - 1] = arr[left];
        arr[left] = temp;
       if((i-left-1)>=offset) {
           System.out.println(arr);
       }else if((i-left-1)<offset-1){
           System.out.println(arr);
       }else {
           System.out.println(arr);
       }
       return 1;
    }

}
