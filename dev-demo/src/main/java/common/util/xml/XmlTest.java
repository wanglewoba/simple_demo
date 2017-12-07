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
        /**
         * 运行结果：
         * <common.bean.Man>
         <name>abc</name>
         <age>1111</age>
         <tradeDate>20171209</tradeDate>
         </common.bean.Man>
         */
        System.out.println(s);

        Map<String, String> parse = XmlUtil.parse(s);
        /**
         *  运行结果：
         * {tradeDate=20171209, age=1111, name=abc}
         */
        System.out.println(parse.toString());

        Man man = ReflectUtil.convertFields(m.getClass(), parse);
        /**
         * 运行结果：
         * common.bean.Man@51b32cda[name=abc,age=1111,tradeDate=20171209]
         */
        System.out.println(man);
    }
}
