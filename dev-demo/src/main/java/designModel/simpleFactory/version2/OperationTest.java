package designModel.simpleFactory.version2;/**
 * Created by admin on 2017/11/27.
 */

import designModel.simpleFactory.version2.factory.OpFactory;
import designModel.simpleFactory.version2.op.Operation;

import java.util.Scanner;

/**
 * @author sunwenwu
 * @create 2017-11-27 15:29
 **/
public class OperationTest {
    /**
     * 一个简单计算器
     * 使用到封装、继承、多态的面向对象思想
     *
     * 增加相应的运算只需继承Operation类，实现自己的运算规则即可，唯一不好就是还需修改静态工厂类，相对于version1已更好管理与扩展了
     * @param args
     */

    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        String op = "";
        String result = null;
        System.out.print("请输入第一个数：");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            a = sc.nextDouble();
        }
        System.out.print("请输入第二个数：");
        Scanner sc2 = new Scanner(System.in);
        if(sc2.hasNext()){
            b = sc2.nextDouble();
        }
        System.out.print("请输入运算符：");
        Scanner sc3 = new Scanner(System.in);
        if(sc3.hasNext()){
            op = sc3.next();
        }
        Operation operation = OpFactory.getOp(op);
        operation.setFristNum(a);
        operation.setSecondNum(b);
        result = operation.getResult();
        System.out.println("----------------->结果:"+a+op+b+"="+result);
    }
}
