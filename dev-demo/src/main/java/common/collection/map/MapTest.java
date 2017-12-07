package common.collection.map;/**
 * Created by admin on 2017/9/1.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author sunwenwu
 * @create 2017-09-01 10:38
 **/
public class MapTest {
    /**
     * 输出结果：
     *
     * before:{userId=2, merchantId=1}
     Map 的hash值测试：2
     -836030906比较hashCode-836030906
     after:{merchantId=1, userId=2}
     merchantId=1&userId=2&
     format:quota_pay_123
     * @param args
     */

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("userId","2");
        map.put("merchantId","1");
        System.out.println("before:"+map.toString());

        System.out.println("Map 的hash值测试："+map.get(new String("userId")));
        System.out.println("userId".hashCode()   + "比较hashCode" + new String("userId").hashCode());

        Map<String, String> sortedParams = new TreeMap<String, String>(map);

        System.out.println("after:"+sortedParams.toString());
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue()).append("&");
        }
        System.out.println(basestring);

        String cacheQuotaKey =String.format("%s%s%s%s","quota_pay_",1,2,3);

        System.out.println("format:"+cacheQuotaKey);
    }
}
