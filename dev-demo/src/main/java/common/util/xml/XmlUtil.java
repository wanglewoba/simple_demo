package common.util.xml;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   解析 xml
 */
final public class XmlUtil {

    private XmlUtil() {
    }

    /**
     *  解析 xml
     * @param xml
     * @return
     * @throws DocumentException
     */
    public static final Map<String, String> parse(String xml) throws DocumentException {
        Map<String, String> result = new HashMap<String, String>(25);
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Element element : elements){
            String content = element.getText();
            if(StringUtils.isBlank(content)){
                continue;
            }

            result.put(element.getName(), content);
        }
        return result;
    }

}
