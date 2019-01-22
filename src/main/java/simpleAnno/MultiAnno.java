package simpleAnno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiAnno {

    enum Priority{HIGH,MID,LOW}
    enum Status {START,PAUSE,STOP}

    String name() default "TheShy";
    Priority priority() default Priority.HIGH;
    Status status() default Status.START;

}
