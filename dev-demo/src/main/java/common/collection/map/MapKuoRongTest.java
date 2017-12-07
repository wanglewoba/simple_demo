package common.collection.map;/**
 * Created by admin on 2017/9/11.
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author sunwenwu
 * @create 2017-09-11 18:26
 **/
public class MapKuoRongTest {

    /**
     *待完善，忘了当初怎么设计的了
     * @param args
     */
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<String, String>();

      /*  map.put(null,null);
        System.out.println(map.get(null));
        map.put(null,"111");
        System.out.println(map.get(null));*/
        map.put("null",null);
        System.out.println(map.get("null"));


        Map m= new Hashtable();
        m.put("null",null);
        System.out.println(m.get("null"));

        long t1 = System.currentTimeMillis();
        System.out.println("开始时间："+t1);
        for (int i =0;i<10;i++) {
            map.put(i+"kk","vv");
        }
        long t12 = System.currentTimeMillis();
        System.out.println("结束时间："+t12);
        long tt1 = t12-t1;

        System.out.println("不扩容所需时间"+tt1);
        System.out.println("================================");
        Map<String,String> map2 = new HashMap<String, String>();

        long t2 = System.currentTimeMillis();
        System.out.println("开始时间："+t2);


        for (int i =0;i<16;i++) {
            map2.put(i+"kk","vv");
        }
        long t22 = System.currentTimeMillis();
        System.out.println("结束时间："+t22);
        long tt2 = t22-t2;

        System.out.println("扩容所需时间"+tt2);
    }
}
