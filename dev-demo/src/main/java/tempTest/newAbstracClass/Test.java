package tempTest.newAbstracClass;/**
 * Created by admin on 2017/11/20.
 */

/**
 * @author sunwenwu
 * @create 2017-11-20 15:21
 **/
public class Test {

    //new 一个抽象类，重写抽象方法后，再调用
    public static void main(String[] args) {
        new AbTest("sww","man"){
            @Override
            public void handle() {
                System.out.println(this.getName()+" "+this.getSex());
            }
        }.doHandle();
    }
}
