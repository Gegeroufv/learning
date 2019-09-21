package dataStructure.chapter3;

import dataStructure.chapter3.pojo.test1.SaveSet;
import dataStructure.chapter3.pojo.test1.SaveSetNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一元多项式及其运算
 * <p>
 * 矩阵存储多项式/顺序结构存储多项式 两个都存在浪费空间严重的问题，由于底层是数组，所以需要新的数据结构来完成存储
 *
 * @author leviathan
 * @version 1.0
 * @date 2019/9/21 10:31
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<SaveSet> arr = new ArrayList<SaveSet>() {{
            add(new SaveSet(1, 1));
            add(new SaveSet(2, 3));
            add(new SaveSet(1, 1));
            add(new SaveSet(3, 3));
            add(new SaveSet(4, 4));
            add(new SaveSet(-5, 5));
        }};
        ArrayList<SaveSet> arr2 = new ArrayList<SaveSet>() {{
            add(new SaveSet(1, 2));
            add(new SaveSet(2, 3));
            add(new SaveSet(1, 1));
            add(new SaveSet(3, 4));
            add(new SaveSet(4, 5));
            add(new SaveSet(-7, 6));
        }};
        ArrayList<SaveSet> line = ploynomeAdd(arr, arr2);
        System.out.println(line);
        System.out.println(countPloynome(line, 1));

        //链表存储不会有浪费
        SaveSetNode line2 = new SaveSetNode(1, 1,
                new SaveSetNode(2, 2,
                        new SaveSetNode(3, 3, null)));
        System.out.println(countPloynome(line2,1,0));

        //二元多项式
    }

    /**
     * 一元顺序结构计算多项式
     *
     * @param line1
     * @param line2
     * @return
     */
    private static ArrayList<SaveSet> ploynomeAdd(ArrayList<SaveSet> line1, ArrayList<SaveSet> line2) {
        Map<Integer, List<SaveSet>> collect1 = line1.stream().collect(Collectors.groupingBy(SaveSet::getPower));
        Map<Integer, List<SaveSet>> collect2 = line2.stream().collect(Collectors.groupingBy(SaveSet::getPower));
        ArrayList<SaveSet> result = new ArrayList<>();
        collect1.forEach((k, v) -> {
            int sum = v.stream().mapToInt(SaveSet::getRatio).sum();
            List<SaveSet> list = collect2.get(k);
            if (Objects.nonNull(list)) {
                result.add(new SaveSet(list.stream().mapToInt(SaveSet::getRatio).sum() + sum, k));
            } else {
                result.add(new SaveSet(sum, k));
            }
        });
        Set<Integer> set = result.stream().map(SaveSet::getPower).collect(Collectors.toSet());
        Optional.of(line2.stream().filter(e -> !set.contains(e.getPower())).collect(Collectors.toList())).ifPresent(result::addAll);
        return result;
    }

    /**
     * 一元给予数字计算多项式
     *
     * @param line
     * @param x
     * @return
     */
    private static double countPloynome(ArrayList<SaveSet> line, double x) {
        return line.stream().mapToDouble(e ->
                Math.pow(x, e.getPower()) * e.getRatio()
        ).sum();
    }

    /**
     *
     * @param node
     * @param x
     * @param temp
     * @return
     */
    private static double countPloynome(SaveSetNode node,double x,double temp){
        temp+=Math.pow(x,node.getPower())*node.getRatio();
        if(Objects.isNull(node.getNext())){
            return temp;
        }else {
            return countPloynome(node.getNext(),x,temp);
        }
    }
}
