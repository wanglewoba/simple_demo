package common.util.xml;

import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 *   反射工具类
 */
final public class ReflectUtil {

    private ReflectUtil(){}

    /**
     *  转换数据
     * @param clz       需要转换的类
     * @param clzMap    转换的键值对
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static final <T> T convertFields(Class<T> clz, Map<String, String> clzMap) throws IllegalAccessException, InstantiationException {
        T t = clz.newInstance();
        Class cls = t.getClass();
        Class superCls = cls.getSuperclass();
        Field[] fieldAll = (Field[]) ArrayUtils.addAll(superCls.getDeclaredFields(), cls.getDeclaredFields());

        for (Field field : fieldAll){
            field.setAccessible(true);
            XmlTag xmlTag = field.getAnnotation(XmlTag.class);
            if(null == xmlTag){
                continue;
            }


            String tagName = xmlTag.value();
            if(clzMap.containsKey(tagName)){
                field.set(t, clzMap.get(tagName));
            }

        }
        return t;
    }
}
