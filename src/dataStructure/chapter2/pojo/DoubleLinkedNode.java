package dataStructure.chapter2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/6 9:09
 */
@AllArgsConstructor
@Data
public class DoubleLinkedNode implements DoubleLinkedTrait{
    private DoubleLinkedTrait pre;
    private DoubleLinkedTrait next;
    private String item;

    @Override
    public String toString() {
        return item+"  ";
    }
}
