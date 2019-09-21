package dataStructure.chapter3.pojo.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/21 10:38
 */

@AllArgsConstructor
@Data
public class SaveSet {
    /**
     * 系数
     */
    private int ratio;

    /**
     * 指数
     */
    private int power;
}
