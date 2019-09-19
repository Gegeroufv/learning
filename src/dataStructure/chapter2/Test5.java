package dataStructure.chapter2;

import dataStructure.chapter2.pojo.SinguleLinkedNode;

import java.util.Objects;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/10 13:00
 */
//单链表所有乘阶和,其中的值都为非负,c++比较简单 java比较操蛋
public class Test5 {
    public static void main(String[] args) {
        SinguleLinkedNode singuleLinkedListHead = new SinguleLinkedNode(
                new SinguleLinkedNode(
                        new SinguleLinkedNode(
                                new SinguleLinkedNode(
                                        new SinguleLinkedNode(
                                                new SinguleLinkedNode(
                                                        new SinguleLinkedNode(null, "7"),
                                                        "6"),
                                                "5"),
                                        "4"),
                                "3"),
                        "2"),
                "1");
        System.out.println(byMutiSum(singuleLinkedListHead));
        int sum=0;
        int temp=0;
        for (int i = 1; i < 8; i++) {
            temp=1;
            for (int j = 1; j <= i; j++) {
                temp*=j;
            }
            sum+=temp;
        }
        System.out.println(sum);
        SinguleLinkedNode[] arr = toArr(singuleLinkedListHead);
        for (int i = 0; i < arr.length; i++) {
            System.err.println(arr[i]);
        }
    }

    private static Integer byMutiSum(SinguleLinkedNode node){
        Integer sum=1;
        if(Objects.nonNull(node.getNext())) {
            sum=loopList(node, node.getNext(), sum);
        }else {
            return Integer.parseInt(node.getName());
        }
        return sum;
    }
    /**
     * @param begin
     * @param node
     * @param sum sum>1
     * @return
     */
    private static Integer loopList(SinguleLinkedNode begin, SinguleLinkedNode node, Integer sum) {
        if (Objects.nonNull(node.getNext())) {
            sum +=mutiSumStage(begin,node,1);
            return loopList(begin, node.getNext(), sum);
        } else {
            sum +=mutiSumStage(begin,node,1);
            return sum;
        }
    }

    //开始
    private static Integer mutiSumStage(SinguleLinkedNode node, SinguleLinkedNode find, Integer num) {
        if (node.equals(find)) {
            return Integer.parseInt(node.getName()) * num;
        }
        if(Objects.isNull(node.getNext())){
            throw new RuntimeException("未找到！");
        }else {
            int temp = Integer.parseInt(node.getName()) * num;
            return mutiSumStage(node.getNext(), find,temp);
        }
    }

    //线性表转数组
    private static SinguleLinkedNode[] toArr(SinguleLinkedNode node){
        Integer deep = howDeep(node, 1);
        SinguleLinkedNode[] arr=new SinguleLinkedNode[deep];
        return insertNode(node,arr,0);
    }

    private static Integer howDeep(SinguleLinkedNode node,Integer num){
        if(Objects.isNull(node.getNext())){
            return num;
        }else {
            return howDeep(node.getNext(),num+1);
        }
    }

    private static SinguleLinkedNode[] insertNode(SinguleLinkedNode node,SinguleLinkedNode[] arr,Integer index){
        if(arr.length==(index+1)){
            arr[index]=node;
            return arr;
        }else {
            arr[index]=node;
            return insertNode(node.getNext(),arr,index+1);
        }
    }
}
