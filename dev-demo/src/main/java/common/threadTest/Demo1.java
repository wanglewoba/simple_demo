package common.threadTest;/**
 * Created by admin on 2017/10/27.
 */

import java.util.Vector;

/**
 * @author sunwenwu
 * @create 2017-10-27 17:41
 **/
public class Demo1 {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while(true){
            for(int i=0;i<10;i++){
                vector.add(i);
                System.out.println("增加中："+i);
            }

            Thread reThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized(vector){
                        for (int i = 0; i < vector.size(); i++) {
                            //当前线程让出CPU,使例子中的错误更快出现
                            Thread.yield();
                            Integer remove = vector.remove(i);
                            System.out.println("<----删除中：" + remove);
                        }
                    }
                }
            });

            Thread getThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized(vector){
                        for (int i = 0; i < vector.size(); i++) {
                            //当前线程让出CPU,使例子中的错误更快出现
                            Thread.yield();
                            Integer get = vector.get(i);
                            System.out.println("获取中---->：" + get);
                        }
                    }
                }
            });

            reThread.start();
            getThread.start();

            while(Thread.activeCount()>20){};
        }
    }
}
