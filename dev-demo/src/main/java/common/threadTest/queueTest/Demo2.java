package common.threadTest.queueTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunwenwu on 2018/8/27.
 */
public class Demo2 {

    static List<String> list = new ArrayList<>();

    static {
        for (int i=0;i<1000000;i++){
            list.add("产品："+i);
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int length = 20;
        CountDownLatch cdl = new CountDownLatch(length);

        for(int j=0;j<length;j++){
            new Thread("线程"+j){
                @Override
                public void run() {
                    while (true){
                        synchronized (list){
                            if(list.size()<=0){
                                cdl.countDown();
                                break;
                            }else {
                                System.out.println(Thread.currentThread().getName()+":"+list.remove(0));
                            }
                        }
                    }
                }
            }.start();
        }

        try {
            cdl.await();//等待所有线程执行完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("===========执行时间："+(end-start));
        //===========执行时间：813、6722

    }
}
