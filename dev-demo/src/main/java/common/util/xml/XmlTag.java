package common.util.xml;

import java.lang.annotation.*;

/**
 *  处理报文返回时  反射使用
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XmlTag {

    String value();
}
