package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.Vector;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests  {
    @Autowired
    ObjectMapper mapper;

    @Test
    public void contextLoads() throws Exception {
        System.out.println(Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File("d:/a.png"))));
    }

    @Test
    public void testClassLoader() throws Exception{
        Field field = ClassLoader.class.getDeclaredField("classes");
        field.setAccessible(true);
        Vector<Class> classes=(Vector<Class>) field.get(this.getClass().getClassLoader());
        classes.stream().forEach(System.out::println);
    }

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Test
    public void testFindMapping(){
       requestMappingHandlerMapping.getHandlerMethods().forEach((k,v)-> System.out.println(k+" : "+v));
    }

    @Test
    public void test1(){
    }

}
