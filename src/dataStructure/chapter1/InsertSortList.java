package dataStructure.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入有序数列后继续进行排序
 */
public class InsertSortList {
    private static List<Integer> list=new ArrayList(){{
        add(1);
        add(2);
        add(3);
        add(5);
        add(6);
        add(7);
        add(8);
        add(10);
        add(11);
    }};

    public static void main(String[] args) {
        insertAndSort(list,4).forEach(System.out::println);
        insertAndSort(list,9).forEach(System.err::println);
    }

    private static List<Integer> insertAndSort(List<Integer> list,Integer num){
        int index=0;
        for(int i=0;i<list.size();i++){
            if(num<list.get(i)){
                index=i;
                break;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<index;i++){
            arrayList.add(list.get(i));
        }
        arrayList.add(num);
        for(int i=index;i<list.size();i++){
            arrayList.add(list.get(i));
        }
        return arrayList;
    }
}
