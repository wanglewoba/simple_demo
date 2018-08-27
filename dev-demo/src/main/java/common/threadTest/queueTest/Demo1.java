package common.threadTest.queueTest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Created by sunwenwu on 2018/8/27.
 */
public class Demo1 {

    static Queue<String> queue = new ConcurrentLinkedQueue<>();
    static {
        for (int i=0;i<100000;i++){
            queue.add("产品："+i);
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for(int j=0;j<20;j++){
            new Thread("线程"+j){
                @Override
                public void run() {
                    while (true){
                        String poll = queue.poll();
                        if(poll == null){
                            break;
                        }else {
                            System.out.println(Thread.currentThread().getName()+":"+poll);
                        }
                    }
                }
            }.start();
        }
        long end = 0;
        while(true){
            if(queue.poll() == null){
                end = System.currentTimeMillis();
                break;
            }
        }

        System.out.println("===========执行时间："+(end-start));
    }
}
