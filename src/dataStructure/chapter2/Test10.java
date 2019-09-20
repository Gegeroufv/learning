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

    //求出来是倒序获得的第k大
    private static int search2Mid(int[] arr, int n) {
        return search2MidStage(arr, n, 0, arr.length - 1);
    }

    /**
     * 多思考本质，分割数组，分割的方式就是在分割点的左边比右边大
     * 这里不需要排序，只是需要分割点左边比右边大，所以对左边的顺序没有要求！
     * <p>
     * 这里有个技巧也就是代码如果自己排序的话为了简便需要倒序
     * <p>
     * 这里不是每次去减量，实际是每次减少夹逼，最终只剩下一个
     * <p>
     * 如果真是写不出来就别硬顶着，直接敲出来然后看运行思路！(这里有大量的临界问题需要去解决，需要用特定的思路！)
     * <p>
     * 不得不说这个题太难了………………技巧有点多
     *
     * @param arr    待求值的数组
     * @param offset 对于left的偏移量,不是给的中间的值
     * @param left   左边遍历开始点
     * @param right  右边遍历开始点
     * @return
     */
    private static int search2MidStage(int[] arr, int offset, int left, int right) {
        int i = left;
        int j = right;
        int line = arr[left];
        int temp;
        while (true) {
            //对临界条件的考虑！！！
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
        //offset如果落入到左边
        if ((i - left - 1) >= offset) {
            return search2MidStage(arr, offset, left, i - 2);
            //offset落入到右边
        } else if ((i - left - 1) < offset - 1) {
            return search2MidStage(arr, offset - 1 - (i - left - 1), i, right);
        } else {
            return line;
        }
    }

    // TODO: 2019/9/19 把while改成for 临界调价再考虑一遍


    // TODO: 2019/9/19 尝试正序来搞一遍
}
