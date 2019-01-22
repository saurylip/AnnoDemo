package retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APICreater {

    public static ServerAPI create(Class<ServerAPI> api){

        ServerAPI serverAPI = (ServerAPI) Proxy.newProxyInstance(api.getClassLoader(), new Class[]{api}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                getMethodMsg(method, args);

                if ("getBaiduHome".equals(method.getName())) {
                    return "I am getBaiduHome return by proxy";
                }
                if ("getBaiduUser".equals(method.getName())) {
                    return "I am getBaiduUser return by proxy";
                }
                ServerAPI obj = getAPI();
                return method.invoke(obj, args);
            }
        });
        return serverAPI;
    }

    private static ServerAPI getAPI() {
        return new ServerAPI() {
            @Override
            public String getBaiduHome(String type) {
                return null;
            }

            @Override
            public String getBaiduUser(String name, String age) {
                return null;
            }
        };
    }


    // 获取了注解信息和参数信息,结合起来就可以实现自己的自定义方法.
    private static void getMethodMsg(Method method, Object[] args) {
        AnnoBean bean = new AnnoBean();
        bean.setMethodName(method.getName());

        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Get) {
                Get getAnni = (Get) annotation;
                String value = getAnni.value();
                bean.setMethodAnniType("Get");
                bean.setMethodAnniValue(value);
            }
            if (annotation instanceof Post) {
                Post getAnni = (Post) annotation;
                String value = getAnni.value();
                bean.setMethodAnniType("Post");
                bean.setMethodAnniValue(value);
            }
        }

        bean.setMethodArgs(Arrays.asList(args));

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotation : parameterAnnotations) {
            for (Annotation annotation1 : annotation) {
                if (annotation1 instanceof Field) {
                    List<String> list = bean.getParamAnniList();
                    if (list == null) {
                        list = new ArrayList<String>();
                    }
                    list.add("paramAnniType: field   " + " value: " + ((Field) annotation1).value());
                    bean.setParamAnniList(list);
                }
                if (annotation1 instanceof Query) {
                    List<String> list = bean.getParamAnniList();
                    if (list == null) {
                        list = new ArrayList<String>();
                    }
                    list.add("paramAnniType: query   " + " value: " + ((Query) annotation1).value());
                    bean.setParamAnniList(list);
                }
            }
        }
        System.out.println(bean.toString());
    }


}
