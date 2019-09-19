package dataStructure.chapter2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/5 16:32
 */

/**
 * 单链表
 */
@AllArgsConstructor
@Data
public class SinguleLinkedNode {
    private SinguleLinkedNode next;
    private String name;

    @Override
    public String toString() {
        return  name+"  "+(Objects.nonNull(next)?next.toString():"") ;
    }
}
