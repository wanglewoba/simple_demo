package common.NoSort;/**
 * Created by admin on 2017/12/1.
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author sunwenwu
 * @create 2017-12-01 10:51
 **/
public class Demo2 {
    public static HashMap<String, String> mapTest = new HashMap<>();

    public static void main(String[] args) throws Exception {
        byte ii = 111;
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
//        stringStringHashtable.put("",null);

//        byte i = 1111; //超出存储范围
//        System.out.println(i);
    /*    HashMap<String, String> map = new HashMap<>(2,1);
        Class<? extends HashMap> aClass = map.getClass();
        Field threshold = aClass.getDeclaredField("threshold");

        map.put("India","India");
        map.put("Japan","Japan");
        map.put("France","France");
        map.put("Tokyo","Tokyo");

        String put = map.put("aa", "bb");
        System.out.println(threshold.get(map));
//        System.out.println("第一次："+put);
        String put1 = map.put("aa", "cc");
        System.out.println(threshold.get(map));
//        System.out.println("第二次："+put1);

        Set<Map.Entry<String, String>> entries = map.entrySet();*/

        /**
         * 线程问题复现：   当hashMap 遍历时，另外一个线程添加数据，将可能报下面的这个错
         * 99
         遍历时增加数据
         Exception in thread "Thread-0" java.util.ConcurrentModificationException
         at java.util.HashMap$HashIterator.nextEntry(HashMap.java:894)
         at java.util.HashMap$EntryIterator.next(HashMap.java:934)
         at java.util.HashMap$EntryIterator.next(HashMap.java:932)
         at common.NoSort.Demo2$1.run(Demo2.java:46)
         at java.lang.Thread.run(Thread.java:722)
         35 : 第35
         */
        for(int i=1;i<100;i++){
            mapTest.put(""+i,"第"+i);
        }
        System.out.println(mapTest.size());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Set<Map.Entry<String, String>> entriesTest = mapTest.entrySet();
                for (Map.Entry<String, String> entry:entriesTest){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println( entry.getKey()+" : "+entry.getValue());
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                Set<Map.Entry<String, String>> entriesTest = mapTest.entrySet();
                for(int i=1;i<1000;i++){
                    mapTest.put("==========="+i,"第"+i);
                }
                System.out.println("遍历时增加数据");
            }
        };
        new Thread(runnable).start();
        new Thread(r2).start();

    }

}
