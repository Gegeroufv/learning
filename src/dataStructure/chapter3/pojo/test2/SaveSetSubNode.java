package dataStructure.chapter3.pojo.test2;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/21 15:30
 */
@RequiredArgsConstructor
@Data
public class SaveSetSubNode {
    /**
     * 参数位置
     */
    @NonNull
    private int position;
    /**
     * 几次方
     */
    @NonNull
    private int power;
    /**
     * 下一个
     */
    private SaveSetSubNode next;
}
