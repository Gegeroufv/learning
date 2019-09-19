import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/3 11:48
 */
public class GuavaDemo2Test {
    /**
     * 切分器
     */
    @Test
    public void test1() {
        List<String> list = Splitter.on("|").splitToList("hello|world|fuck!!!");
        System.out.println(list + "  " + list.getClass());
        List<String> list2 = Splitter.on("|").omitEmptyStrings().splitToList("hello|world|fuck!!!|||");
        System.out.println(list2);
        //aaaabbbbbbbcccccccdd 解析切分字符串
        List<String> strings = Splitter.fixedLength(4).splitToList("aaaabbbbbbbcccccccdd");
        System.out.println(strings);
    }

    /**
     * guava断言
     * 状态机等编程模型可以用state之类的断言
     */
    @Test
    public void test2() {
        try {
            String fuck = null;
//        Preconditions.checkNotNull(fuck);
//        Preconditions.checkElementIndex()
            //jdk提供的断言表达式,动作不能包含在断言当中
            assert fuck != null : "sucker!!!";
        }catch (Error e){
            System.err.println(e.getMessage());
        }
    }
}
