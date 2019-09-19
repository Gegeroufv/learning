package dataStructure.chapter2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/7 15:48
 */
@Data
@AllArgsConstructor
public class DoubleLinkedHead implements DoubleLinkedTrait{
    private String item;
    private DoubleLinkedTrait next;
    private DoubleLinkedTrait pre;

    @Override
    public String toString() {
        return item+"  ";
    }
}

