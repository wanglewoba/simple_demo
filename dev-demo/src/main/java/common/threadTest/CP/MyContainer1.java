package common.threadTest.CP;

import java.util.LinkedList;


/**
 * Created by sunwenwu on 2018/8/27.
 *
 * 消费者，生产者问题
 */
public class MyContainer1<T> {

    private final LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    //添加元素的方法
    public synchronized void put(T t){
        while(count == MAX){//表示已经满了
            try {
                this.wait();//让生产者等待
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notifyAll();//唤醒消费者进行消费
    }


    public synchronized T get(){
        T t = null;
        while(count == 0){//表示已经消费完了
            try {
                this.wait();// 让消费者进行等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();//唤醒生产者进行生产

        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1<>();

        for (int i=0;i<10;i++){//启动消费者
            new Thread("C"+i){
                @Override
                public void run() {
                    for(int j=0;j<5;j++){
                        System.out.println(Thread.currentThread().getName()+":   "+c.get());
                    }
                }
            }.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0;i<2;i++){//启动消费者
            new Thread("P"){
                @Override
                public void run() {
                    for(int j=0;j<25;j++){
                        c.put(Thread.currentThread().getName() + j);
                    }
                }
            }.start();
        }
    }
}
