package dataStructure.chapter3.pojo.test1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/21 14:22
 */
@AllArgsConstructor
@Data
public class SaveSetNode {
    /**
     * 系数
     */
    private int ratio;

    /**
     * 指数
     */
    private int power;
    /**
     * 单链表存储
     */
    private SaveSetNode next;
}

