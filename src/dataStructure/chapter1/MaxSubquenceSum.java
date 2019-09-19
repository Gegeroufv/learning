package dataStructure.chapter1;


import java.util.Arrays;

/**
 * 最大子列和，这里起码有一个正数
 */
public class MaxSubquenceSum {
    private static int[] data = new int[]{
            4, -3, 5, -2, -1, 2, 6, -2, 45, -78, 100
    };

    public static void main(String[] args) {
        System.out.println(cacheAlgo(data));
        System.err.println(primitiveAlgo(data));
        System.out.println("=========");
        System.out.println(MaxRecursive(data));
        System.out.println(onlineProcess(data));
    }

    /**
     * 最大子列和问题：
     * 最暴力的算法，按照一般逻辑
     * 带有存入的算法：避免对以前的结果进行重算
     * 分治法：化解问题的规模
     */
    private static Integer MaxRecursive(int[] arr) {
        return divideProcess(arr, 0, arr.length - 1);
    }

    /**
     * 分治法的要点在于无记忆，需要通过传递，所以格式为:
     * 1.终止条件，最后细分为单一的值
     * 2.索引传递逻辑
     * 3.返回值传递逻辑
     * 4，每次递归处理的逻辑
     * 分治法这里需要传递的一般为逻辑的递进
     * <p>
     * 分治的过程需要传入
     * 临界条件需要仔细分析,这里需要画图确认算法
     *
     * 对数列的操作请注意索引的位置
     *
     * @param arr
     * @return
     */
    private static Integer divideProcess(int[] arr, int left, int right) {
        //终止条件
        if (left == right) {
            return arr[left] > 0 ? arr[left] : 0;
        }

        //对索引的折半,索引的传递步进
        int mid = (left + right) / 2;


        //返回值传递递归信息
        int leftMax = divideProcess(arr, left, mid);
        int rightMax = divideProcess(arr, mid + 1, right);


        int midLeftMaxSum = 0;
        int midRightMaxSum = 0;
        //每次递归需要传递的逻辑
        int temp = 0;
        for (int i = mid; i >= left; i--) {
            temp += arr[i];
            if (midLeftMaxSum < temp) {
                midLeftMaxSum = temp;
            }
        }
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += arr[i];
            if (midRightMaxSum < temp) {
                midRightMaxSum = temp;
            }
        }

        //取最大值
        return Arrays.stream(new int[]{leftMax, rightMax, midLeftMaxSum + midRightMaxSum}).max().getAsInt();
    }

    /**
     * o3 最原始的算法
     * <p>
     * 无记忆性算法，没有对已经重算的结果进行保存
     *
     * @param arr
     * @return
     */
    private static Integer primitiveAlgo(int[] arr) {
        int temp = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                temp = 0;
                for (int k = i; k <= j; k++) {
                    temp += arr[k];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 对每次计算结果进行缓存
     *
     * @param arr
     * @return
     */
    private static Integer cacheAlgo(int[] arr) {
        int max = 0;
        int cache = 0;
        for (int i = 0; i < arr.length; i++) {
            cache = 0;
            for (int j = i; j < arr.length; j++) {
                cache += arr[j];
                if (cache > max) {
                    max = cache;
                }
            }
        }
        return max;
    }

    /**
     * 最屌的算法，观察逻辑，递归的一种
     * 其中肯定有缓存去缓存过去的结果,其中肯定有递推的判断
     *
     * 正确性也就是人们观察到逻辑特性很难理解！
     * @param arr
     * @return
     */
    private static Integer onlineProcess(int[] arr){
        int temp=0;
        int max=0;
        for (int i=0;i<arr.length;i++){
            temp+=arr[i];
            if(temp>max){
                max=temp;
            }else if(temp<0){
                temp=0;
            }
        }
        return max;
    }
}