package common.extendsTest;/**
 * Created by admin on 2017/12/1.
 */

import common.extendsTest.vo.Son;

import java.lang.reflect.Field;

/**
 * @author sunwenwu
 * @create 2017-12-01 17:30
 **/
public class mainTest {

    public static void main(String[] args) {
        /**
         * 只能继承父类非private 属性
         *
         * getFields()获得某个类的所有的公共（public）的字段，包括父类。

         getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，
         但是不包括父类的申明字段。
         */
        Son f = new Son();
        f.setSex("男");
        f.setName("张三");
        System.out.println(f);

        Field[] declaredFields = f.getClass().getFields();

        for (Field fd:declaredFields){
            System.out.println(fd.getName());
        }

    }
}
