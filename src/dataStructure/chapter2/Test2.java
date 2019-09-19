package dataStructure.chapter2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 取中位数,基于问题的分解
 * 实际是取一组数中第k大数字
 */
public class Test2 {
    private static Integer[] data = new Integer[]{6, 5, 9, 8, 2, 1, 7, 3, 4};

    public static void main(String[] args) {
        int sortedK = findSortedK(Arrays.asList(data), 4);
        System.out.println(sortedK);
        System.out.println(findSortedK2(Arrays.asList(data),4));
    }


    //没写出来，多想想别急,分治法//这里如果使用了
    private static int findSortedK(List<Integer> data, int k) {
        if (data.size() >= k && k >= 1) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            Integer first = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i) <= first) {
                    left.add(data.get(i));
                } else {
                    right.add(data.get(i));
                }
            }
            if (left.size() == k - 1) {
                return first;
            }
            if (left.size() < k) {
                return findSortedK(right, k - 1 - left.size());
            } else {
                return findSortedK(left, k);
            }
        } else {
            throw new RuntimeException("输入数据不合法");
        }
    }

    //最笨的办法，给全局排序,写的时间需要多考虑临界条件，但是还是写为主
    private static int findSortedK2(List<Integer> data, int k) {
        if (k > 0 && k <= data.size()) {
            List<Integer> list = new ArrayList<>();
            for (Integer ele : data) {
                if (list.size() == 0) {
                    list.add(ele);
                } else {
                    int temp = 0;
                    int cache = 0;
                    boolean flag = false;
                    for (int i = 0; i < list.size(); i++) {
                        //遇见第一个小于的时间需要做处理！
                        if (ele < list.get(i) && !flag) {
                            temp = list.get(i);
                            list.set(i, ele);
                            flag = true;
                            continue;
                        }
                        //连续进行交换
                        if(flag){
                            cache=list.get(i);
                            list.set(i,temp);
                            temp=cache;
                        }
                    }
                    //如果没有最大的，扩容一个
                    if(!flag){
                        list.add(ele);
                    }else {
                        list.add(temp);
                    }
                }
            }
            return list.get(k-1);
        } else {
            throw new RuntimeException("输入数据不合法");
        }
    }
}
