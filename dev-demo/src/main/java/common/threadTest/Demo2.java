package common.threadTest;/**
 * Created by admin on 2017/12/26.
 */

import common.threadTest.vo.Person;

/**
 * @author sunwenwu
 * @create 2017-12-26 15:18
 **/

/**
 *修饰在方法上：
 * before:11
 jinru......
 8888
 after:8888


放在同步块中  锁住了p对象；
 before:11
 jinru......
 after:11
 8888
 */
public class Demo2 {
    static Person p = new Person();

    /**
     放在同步块中  锁住了p对象；
     before:11
     jinru......
     after:11
     8888
     */
    public  void run(){
        synchronized(p){
            System.out.println("before:"+p.getAge());
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println("gg....");
            }
            System.out.println("after:"+p.getAge());
        }
    }
    /**
     *修饰在方法上：
     * before:11
     jinru......
     8888
     after:8888
     */
    public synchronized void run2(){
        System.out.println("before:"+p.getAge());
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("gg....");
        }
        System.out.println("after:"+p.getAge());
    }

    public static void main(String[] args) {
        Demo2 d2 = new Demo2();
        p.setAge("11");
        Thread t = new Thread( new Runnable(){
            @Override
            public void run() {
                System.out.println("jinru......");
                p.setAge("8888");
                System.out.println(p.getAge());
            }
        });
        t.start();
        d2.run();
    }


}
