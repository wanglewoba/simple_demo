package common.threadTest.CP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenwu on 2018/8/28.
 *
 * 不需要wait 和 notify
 */
public class CpLockTest<T> {

    private final List<T> list = new ArrayList<>();//容器

    private final int MAX = 10;//最大数量

    private int count = 0;//当前有效个数


    Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    //生产
    public void put(T t) {
        try {
            lock.lock();
            while (MAX == count){
                producer.await();//满了以后让生产者的线程等待
            }

            list.add(t);
            count++;
            consumer.signalAll();//唤醒等待的消费者
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            lock.unlock();
        }
    }


    //消费
    public T get(){
        T t=null;
        try {
            lock.lock();
            while(count == 0){
                consumer.await();//让消费者进行等待
            }
            t = list.remove(0);
            count--;
            producer.signalAll();//唤醒等待的生产者
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }
}
