package common.util.xml;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang.StringUtils;

/**
 *  通过 xstream 解析xml 和将对象转换成xml
 */
final public class XStreamUtil {

    private XStreamUtil() {
    }

    /**
     *  将对象格式化成 xml
     * @param model
     * @param <T>
     * @return
     */
    public static <T> String toXml(T model) {
        if(null == model) {
            throw new RuntimeException("model不能为null");
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(model.getClass());
        return xStream.toXML(model);
    }


    /**
     *  通过 xml 解析对象
     * @param xml
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T fromXML(String xml, Class<T> clz){
        if(StringUtils.isBlank(xml)){
            throw new RuntimeException("xml不能为空");
        }

        if(null == clz) {
            throw new RuntimeException("clz不能为null");
        }

        XStream xStream = new XStream();
        xStream.processAnnotations(clz);
        return (T) xStream.fromXML(xml, clz);
    }

}
