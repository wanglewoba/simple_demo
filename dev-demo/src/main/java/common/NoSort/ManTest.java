package common.NoSort;/**
 * Created by admin on 2017/8/31.
 */

import common.bean.Man;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunwenwu
 * @create 2017-08-31 11:28
 **/
public class ManTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
      Man m = new Man();
        System.out.println("before :"+ m.toString());

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","sww");
        map.put("age",19);
        BeanUtils.populate(m,map);

        System.out.println("after :"+ m.toString());

        String s = null;

        String a = (s==null?"":s) +"11";
//        System.out.println(a.length());


        String tt = "+1234567999";
        String gg = " 78  970  ";
        if(tt.startsWith("+")){
            System.out.println(tt.length());
            tt = tt.substring(1,tt.length());
            System.out.println(tt.length());
        }
     /*   if(gg.contains("+")){
            gg = gg.substring(1,gg.length());
        }*/
        System.out.println(tt);
//        System.out.println(gg);

        System.out.println(gg.length()+" before:===  "+gg);
        String trim = gg.replace(" ", "");
        System.out.println(trim.length()+" after:===  "+trim);


    }


}
