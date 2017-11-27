package designModel.simpleFactory.version1;/**
 * Created by admin on 2017/11/27.
 */

import java.util.Scanner;

/**
 * @author sunwenwu
 * @create 2017-11-27 15:29
 **/
public class OperationTest {
    /**
     * 一个简单计算器
     * 问题：单纯的计算机思想，没有使用到封装、继承、多态的面向对象思想，不宜扩展
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
        if("+".equals(op)){
            result = String.valueOf(a + b);
        }else if("-".equals(op)){
            result = String.valueOf(a - b);
        }else if("*".equals(op)){
            result = String.valueOf(a * b);
        }
        System.out.println("----------------->结果:"+a+op+b+"="+result);
    }
}
