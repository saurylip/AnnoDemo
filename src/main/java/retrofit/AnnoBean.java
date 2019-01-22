package retrofit;

import java.util.List;

public class AnnoBean {
    private String methodName;//方法名
    private List<Object> methodArgs;//方法参数
    private String methodAnniType;//get还是post
    private String methodAnniValue;//注解值
    private List<String> paramAnniList;

    public List<Object> getMethodArgs() {
        return methodArgs;
    }

    public void setMethodArgs(List<Object> methodArgs) {
        this.methodArgs = methodArgs;
    }

    @Override
    public String toString() {
        return "AnniBean{" +
                "methodName='" + methodName + '\'' +
                ", methodArgs=" + methodArgs +
                ", methodAnniType='" + methodAnniType + '\'' +
                ", methodAnniValue='" + methodAnniValue + '\'' +
                ", paramAnniList=" + paramAnniList +
                '}';
    }

    public String getMethodAnniType() {
        return methodAnniType;
    }

    public void setMethodAnniType(String methodAnniType) {
        this.methodAnniType = methodAnniType;
    }

    public String getMethodAnniValue() {
        return methodAnniValue;
    }

    public void setMethodAnniValue(String methodAnniValue) {
        this.methodAnniValue = methodAnniValue;
    }

    public List<String> getParamAnniList() {
        return paramAnniList;
    }

    public void setParamAnniList(List<String> paramAnniMap) {
        this.paramAnniList = paramAnniMap;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}

