import org.junit.Test;
import staticProxy.Runnable;
import staticProxy.Train;
import staticProxy.TrainLogProxy;
import staticProxy.TrainTimeProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxyDemo {

    @Test
    public void staticProxy(){
        Train train = new Train();

//        TrainTimeProxy trainTimeProxy = new TrainTimeProxy(train);
//        TrainLogProxy trainLogProxy = new TrainLogProxy(trainTimeProxy);
//        trainLogProxy.running();

        TrainLogProxy trainLogProxy = new TrainLogProxy(train);
        TrainTimeProxy trainTimeProxy = new TrainTimeProxy(trainLogProxy);
        trainTimeProxy.running();
    }

    @Test
    public void dynamicProxy(){
//        DynamicProxy dynamicProxy = new DynamicProxy(new Train());
//        Runnable runnable  = (Runnable) Proxy.newProxyInstance(Runnable.class.getClassLoader(), new Class[]{Runnable.class}, dynamicProxy);

        Runnable runnable = (Runnable) Proxy.newProxyInstance(Runnable.class.getClassLoader(), new Class[]{Runnable.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                Object invoke =  method.invoke(new Train(), args);
                System.out.println("after");
                return invoke;
            }
        });
        runnable.running();
    }
}
