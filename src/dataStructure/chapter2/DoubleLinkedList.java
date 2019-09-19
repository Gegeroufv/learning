package dataStructure.chapter2;

import dataStructure.chapter2.pojo.DoubleLinkedHead;
import dataStructure.chapter2.pojo.DoubleLinkedNode;
import dataStructure.chapter2.pojo.DoubleLinkedTrait;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/6 9:11
 */
public class DoubleLinkedList {
    /**
     * 双向循环链表链表增删改查
     * 应为出现了前后的循环
     * <p>
     * 通过定义双向链表了解抽象的代码构建
     *
     * @param args
     */
    public static void main(String[] args) {
        List<DoubleLinkedTrait> list = Arrays.asList(
                new DoubleLinkedHead("head", null, null),
                new DoubleLinkedNode(null, null, "a"),
                new DoubleLinkedNode(null, null, "b"),
                new DoubleLinkedNode(null, null, "c"),
                new DoubleLinkedNode(null, null, "d"),
                new DoubleLinkedNode(null, null, "e"),
                new DoubleLinkedNode(null, null, "f")
        );
        DoubleLinkedHead head = build(list);
        loopDoubleLinkedList(head);
        System.out.println();
        loopDoubleLinkedList(add(head, "c", new DoubleLinkedNode(null, null, "fuck"), "pre"));
        System.out.println();
        loopDoubleLinkedList(add(head, "c", new DoubleLinkedNode(null, null, "dick"), "back"));
        System.out.println();
        loopDoubleLinkedList(del(head,"fuck"));
        System.out.println();
        loopDoubleLinkedList(del(head,"dick"));
        System.out.println();
        loopDoubleLinkedList(upd(head,"f", "fuckoff"));
    }

    /**
     * 构建双向链表
     * 这里很简单，多考虑下临界条件！！！
     *
     * @param list 满足双向链表定义的集合
     * @return
     */
    private static DoubleLinkedHead build(List<DoubleLinkedTrait> list) {
        if (list.size() == 0) {
            return null;
        }
        if (!(list.get(0) instanceof DoubleLinkedHead)) {
            throw new RuntimeException("头节点必须为第一个！");
        }
        if (list.size() == 1) {
            return (DoubleLinkedHead) list.get(0);
        }
        DoubleLinkedTrait second = list.get(1);
        DoubleLinkedHead head = (DoubleLinkedHead) list.get(0);
        if (list.size() == 2) {
            second.setPre(head);
            second.setNext(head);
            head.setNext(second);
            head.setPre(second);
            return head;
        }
        DoubleLinkedTrait third = list.get(2);
        if (list.size() == 3) {
            second.setPre(head);
            second.setNext(third);
            third.setPre(second);
            third.setNext(head);
            head.setNext(second);
            head.setPre(third);
            return head;
        }
        DoubleLinkedTrait end = list.get(list.size() - 1);
        head.setNext(second);
        head.setPre(end);
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).setPre(list.get(i - 1));
            list.get(i).setNext(list.get(i + 1));
        }
        end.setPre(list.get(list.size() - 2));
        end.setNext(head);
        return head;
    }

    private static void loopDoubleLinkedList(@NonNull DoubleLinkedHead head) {
        System.out.print(head.toString());
        if (Objects.isNull(head.getNext())) {
            return;
        } else {
            loopDoubleLinkedListStage(head.getNext());
        }
    }

    private static void loopDoubleLinkedListStage(DoubleLinkedTrait node) {
        if (node instanceof DoubleLinkedHead) {
            return;
        } else {
            System.out.print(node.toString());
            loopDoubleLinkedListStage(node.getNext());
        }
    }

    private static DoubleLinkedHead add(DoubleLinkedHead head, String find, DoubleLinkedNode insert, String direction) {
        if (!(direction.equals("pre") || direction.equals("back"))) {
            throw new RuntimeException("方向输入错误");
        }
        DoubleLinkedTrait node = findNode(head, find, true);
        if (Objects.isNull(node)) {
            throw new RuntimeException("该节点未找到");
        }
        DoubleLinkedTrait tempNode;
        if (direction.equals("pre")) {
            tempNode = node.getPre();
            tempNode.setNext(insert);
            node.setPre(insert);
            insert.setPre(tempNode);
            insert.setNext(node);
        }
        if (direction.equals("back")) {
            tempNode = node.getNext();
            tempNode.setPre(insert);
            node.setNext(insert);
            insert.setPre(node);
            insert.setNext(tempNode);
        }
        return head;
    }

    /**
     * 一定要解决无穷遍历
     *
     * @param node
     * @param find
     * @param flag
     * @return
     */
    private static DoubleLinkedTrait findNode(DoubleLinkedTrait node, String find, Boolean flag) {
        if (node.getItem().equals(find)) {
            return node;
        }
        if (node instanceof DoubleLinkedHead) {
            if (flag.equals(true)) {
                return findNode(node.getNext(), find, false);
            } else {
                return null;
            }
        }
        return findNode(node.getNext(), find, flag);
    }

    /**
     * 头节点不能被删除
     * @param head
     * @param find
     * @return
     */
    private static DoubleLinkedHead del(DoubleLinkedHead head, String find) {
        DoubleLinkedTrait node = findNode(head, find, true);
        if(Objects.isNull(node)){
            throw new RuntimeException("删除的节点不存在");
        }
        if(node.getNext() instanceof DoubleLinkedHead && node.getPre() instanceof DoubleLinkedHead){
            return head;
        }else {
            DoubleLinkedTrait tempPreNode=node.getPre();
            DoubleLinkedTrait tempBackNode=node.getNext();
            tempPreNode.setNext(tempBackNode);
            tempBackNode.setPre(tempPreNode);
        }
        return head;
    }


    private static DoubleLinkedHead upd(DoubleLinkedHead head,String item,String upd){
        DoubleLinkedTrait node = findNode(head, item, true);
        if(Objects.isNull(node)){
            throw new RuntimeException("删除的节点不存在");
        }
        node.setItem(upd);
        return head;
    }
}
