import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//使用静态导包直接导入所有的静态方法！
import static org.junit.Assert.*;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/3 8:40
 */
public class GuavaDemo1Test {
    final List<String> list= Arrays.asList(
            "Google","baidu","facebook","alibaba","bytedancer"
    );
    final List<String> listWithNullValue= Arrays.asList(
            "fuck","dick","bitch","hooker",null
    );

    final Map<String,String> stringMap= ImmutableMap.of("Google","baidu","facebook","alibaba","bytedancer","dick");

    /**
     * 连接器
     */
    @Test
    public void test1() {
        String join1 = Joiner.on("#").join(list);
        System.out.println(join1);
        String join2 = Joiner.on("$").skipNulls().join(listWithNullValue);
        System.out.println(join2);
        String join3 = Joiner.on("&").useForNull("<==========>").join(listWithNullValue);
        System.out.println(join3);
        StringBuilder sb=new StringBuilder().append("gogo<>");
        StringBuilder stringBuilder = Joiner.on("*").useForNull("oh~fuck!!!").appendTo(sb, listWithNullValue);
        System.out.println(stringBuilder.toString());
//        fail("fucking fail");
        String collect = listWithNullValue.stream().filter(Objects::nonNull).collect(Collectors.joining("&*&"));
        String collect2 = listWithNullValue.stream().map(e -> e == null || e.isEmpty() ? "fuck is null" : e).collect(Collectors.joining("^%$"));
        System.out.println(collect2);
        System.out.println(collect);
    }

    /**
     * map有关操作
     */
    @Test
    public void test2(){
        String join = Joiner.on("\\#/").withKeyValueSeparator("=").join(stringMap);
        System.out.println(join);
    }

    /**
     * 文件操作
     */
    @Test
    public void test3(){
        boolean test = Files.isFile().test(new File("D:\\a.png"));
        System.out.println(test);
    }
}
