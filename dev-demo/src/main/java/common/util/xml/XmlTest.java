package common.util.xml;/**
 * Created by admin on 2017/12/7.
 */

import common.bean.Man;

import java.util.Map;

/**
 * @author sunwenwu
 * @create 2017-12-07 15:52
 **/
public class XmlTest {
    public static void main(String[] args) throws Exception{
        Man m = new Man();
        m.setAge("1111");
        m.setName("abc");
        m.setTradeDate("20171209");

        String s = XStreamUtil.toXml(m);
        System.out.println(s);

        Map<String, String> parse = XmlUtil.parse(s);
        System.out.println(parse.toString());

        Man man = ReflectUtil.convertFields(m.getClass(), parse);
        System.out.println(man);
    }
}
