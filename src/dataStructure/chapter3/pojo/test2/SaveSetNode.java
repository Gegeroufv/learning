package dataStructure.chapter3.pojo.test2;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/21 14:35
 */
@Data
@RequiredArgsConstructor
public class SaveSetNode {
    /**
     * 多项式赋值位置
     */
    @NonNull
    private int position;
    /**
     * 系数
     */
    @NonNull
    private int ratio;
    /**
     * 指数
     */
    @NonNull
    private int power;
    /**
     * 单链表存储
     */
    private SaveSetNode next;
    /**
     * 多项式的关联节点
     */
    private SaveSetSubNode parallel;
}
