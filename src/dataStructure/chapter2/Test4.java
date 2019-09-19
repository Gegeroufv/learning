package dataStructure.chapter2;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/5 16:21
 */

import dataStructure.chapter2.pojo.SinguleLinkedNode;
import lombok.NonNull;

import javax.sound.midi.SoundbankResource;
import java.security.cert.CertificateExpiredException;
import java.util.Objects;

/**
 * 单链表反转
 * 给定一个单链表，不需要申请新的结点，将链表的第一个元素转为最后一个元素
 */
public class Test4 {
    public static void main(String[] args) {
        SinguleLinkedNode singuleLinkedListHead = new SinguleLinkedNode(
                new SinguleLinkedNode(
                        new SinguleLinkedNode(
                                new SinguleLinkedNode(
                                        new SinguleLinkedNode(
                                                new SinguleLinkedNode(
                                                        new SinguleLinkedNode(null, "seventh"),
                                                        "sixth"),
                                                "fifth"),
                                        "fourth"),
                                "third"),
                        "second"),
                "first");
        System.out.println(singuleLinkedListHead);
        //查找
        System.out.println(search(singuleLinkedListHead, "fourth"));
        System.out.println(searchPre(singuleLinkedListHead, "fourth"));
        //单链表的增加
        System.out.println(add(singuleLinkedListHead, "sixth", new SinguleLinkedNode(null, "fuck")));
        System.out.println(del(singuleLinkedListHead, "fuck"));
        System.out.println(upd(singuleLinkedListHead, "first", "slut"));
        System.out.println(upd(singuleLinkedListHead, "slut", "first"));
        loopTheSingleLinkedNode(singuleLinkedListHead);
        System.out.println();
        System.out.println(add(singuleLinkedListHead, "seventh", new SinguleLinkedNode(null, "eighth")));
        SinguleLinkedNode reverse = reverse(singuleLinkedListHead);
        System.out.println(reverse);
    }

    /**
     * 对单链表的增删改查
     */
    //增加
    private static SinguleLinkedNode add(@NonNull SinguleLinkedNode node, @NonNull String item, @NonNull SinguleLinkedNode insertNode) {
        SinguleLinkedNode search = search(node, item);
        if (Objects.isNull(search) || Objects.nonNull(insertNode.getNext())) {
            return node;
        } else {
            if (Objects.nonNull(search.getNext())) {
                SinguleLinkedNode temp = search.getNext();
                search.setNext(insertNode);
                insertNode.setNext(temp);
            } else {
                search.setNext(insertNode);
            }
            return node;
        }
    }

    //删除
    private static SinguleLinkedNode del(@NonNull SinguleLinkedNode node, @NonNull String item) {
        SinguleLinkedNode search = search(node, item);
        if (Objects.isNull(search)) {
            return null;
        } else {
            SinguleLinkedNode pre = searchPre(node, item);
            SinguleLinkedNode temp = null;
            if (Objects.nonNull(pre)) {
                if (Objects.nonNull(pre.getNext().getNext())) {
                    pre.setNext(pre.getNext().getNext());
                } else {
                    pre.setNext(null);
                }
            }
        }
        return node;
    }

    private static SinguleLinkedNode upd(@NonNull SinguleLinkedNode node, @NonNull String item, @NonNull String updItem) {
        SinguleLinkedNode search = search(node, item);
        if (Objects.nonNull(search)) {
            search.setName(updItem);
            return node;
        } else {
            return node;
        }
    }

    //递归的无记忆性，需要传递参数
    //查询
    private static SinguleLinkedNode search(@NonNull SinguleLinkedNode node, @NonNull String item) {
        if (node.getName().equals(item)) {
            return node;
        } else {
            if (Objects.nonNull(node.getNext())) {
                return search(node.getNext(), item);
            } else {
                return null;
            }
        }
    }

    //找到目标节点的前一个节点
    //查询
    private static SinguleLinkedNode searchPre(@NonNull SinguleLinkedNode node, @NonNull String item) {
        //如果头节点是要找的，直接返回
        if (node.getName().equals(item)) {
            return null;
        } else {
            return searchPreStage(node, item, node);
        }
    }

    //这里还是记得递归的无记忆性
    private static SinguleLinkedNode searchPreStage(@NonNull SinguleLinkedNode node, @NonNull String item, SinguleLinkedNode preNode) {
        if (node.getName().equals(item)) {
            return preNode;
        } else {
            if (Objects.nonNull(node.getNext())) {
                return searchPreStage(node.getNext(), item, node);
            } else {
                return null;
            }
        }
    }

    //遍历单链表
    private static void loopTheSingleLinkedNode(@NonNull SinguleLinkedNode node) {
        if (Objects.nonNull(node.getNext())) {
            System.out.print(node.getName() + "  ");
            loopTheSingleLinkedNode(node.getNext());
        } else {
            System.out.print(node.getName());
            return;
        }
    }

    //反转链表
    private static SinguleLinkedNode reverse(@NonNull SinguleLinkedNode node) {
        return reverseStage(node, null);
    }

    /**
     * 不要申请新的节点
     * 注意java是引用传递，这里坑比较多，要注意，不要设置为对象之间相互拉取
     * 这里题其实很简单，就是分情况讨论的递进法
     *
     * @param node      需要被反转的节点
     * @param cacheNode 被缓存的节点
     * @return
     */
    private static SinguleLinkedNode reverseStage(SinguleLinkedNode node, SinguleLinkedNode cacheNode) {
        SinguleLinkedNode tempNode1;
        SinguleLinkedNode tempNode2;
        if (Objects.isNull(cacheNode)) {
            if (Objects.isNull(node.getNext())) {
                return node;
            } else {
                if (Objects.isNull(node.getNext().getNext())) {
                    tempNode1 = node.getNext();
                    node.setNext(null);
                    tempNode1.setNext(node);
                    return tempNode1;
                } else {
                    tempNode1=node.getNext();
                    tempNode2=node.getNext().getNext();
                    node.setNext(null);
                    tempNode1.setNext(node);
                    return reverseStage(tempNode2,tempNode1);
                }
            }
        } else {
            if(Objects.isNull(node.getNext())){
                node.setNext(cacheNode);
                return node;
            }else {
                tempNode1=node.getNext();
                node.setNext(cacheNode);
                return reverseStage(tempNode1,node);
            }
        }
    }

}
