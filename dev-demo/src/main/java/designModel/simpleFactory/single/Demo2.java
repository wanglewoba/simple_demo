package designModel.simpleFactory.single;

/**
 * Created by sunwenwu on 2018/8/28.
 */
public class Demo2 {

//    private static Demo2 demo2 = null;
    private Demo2(){

    }

    public static Demo2 get(){
        return InnerDemo.demo2;
    }


    private static class InnerDemo{
       private static Demo2 demo2 = new Demo2();
    }
}
