package designModel.simpleFactory.single;

/**
 * Created by sunwenwu on 2018/8/27.
 */
public class Demo1 {

    private static Demo1 demo1 = null;
    private Demo1(){

    }
    public static Demo1 get(){
        if(demo1 == null){
            synchronized (Demo1.class){
                if(demo1 == null){
                    demo1 = new Demo1();
                }
            }
        }
        return demo1;
    }
}
