package simpleAnno;

import org.junit.Test;
import simpleAnno.MyClass;
import simpleAnno.SingleAnno;

import java.lang.reflect.Method;

public class TestDemo {

    @Test
    public void test(){
        Class<MyClass> myClass = MyClass.class;

        for (Method method : myClass.getDeclaredMethods()){
            SingleAnno anno = method.getAnnotation(SingleAnno.class);
            if(anno != null){
                System.out.println(method.getName());//打印方法名
                System.out.println(anno.value());//打印注解值
            }
        }
    }
}
