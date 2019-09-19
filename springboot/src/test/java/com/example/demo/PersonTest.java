package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/2 14:06
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {
    /**
     * 测试localDateTime构建动态sql,填充数据
     */
    @Rollback(value = false)
    @Transactional
    @Test
    public void test1(){

    }

}
