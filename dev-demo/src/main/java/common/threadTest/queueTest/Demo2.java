package common.threadTest.queueTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunwenwu on 2018/8/27.
 */
public class Demo2 {

    static List<String> list = new ArrayList<>();

    static {
        for (int i=0;i<100000;i++){
            list.add("产品："+i);
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for(int j=0;j<20;j++){
            new Thread("线程"+j){
                @Override
                public void run() {
                    while (true){
                        synchronized (list){
                            if(list.size()<=0){
                                break;
                            }else {
                                System.out.println(Thread.currentThread().getName()+":"+list.remove(0));
                            }
                        }
                    }
                }
            }.start();
        }
        long end = 0;
        while(true){
            if(list.size()<=0){
                end = System.currentTimeMillis();
                break;
            }
        }
        System.out.println("===========执行时间："+(end-start));
    }
}
