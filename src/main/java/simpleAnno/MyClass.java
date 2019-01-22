package simpleAnno;

import simpleAnno.MultiAnno;

public class MyClass {


    //注意 :注解 属性key是value 时候,引用地方才可省略,其他不行.
    //标准写法  @MySingleAnno(value = "allen")
    //下面是省略写法
    @SingleAnno("single")
    public void run(){

    }

    @MultiAnno(name = "itisName",priority = MultiAnno.Priority.HIGH,status = MultiAnno.Status.PAUSE)
    public void runMulti(){}

}
