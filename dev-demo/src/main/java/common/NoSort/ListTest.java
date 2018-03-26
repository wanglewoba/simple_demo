package common.NoSort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunwenwu on 2018/2/3.
 */
public class ListTest {

    public static void main(String[] args) throws Exception{
        List<Integer> filterIds =  new ArrayList<>();
        filterIds.add(new Integer(1));
        boolean f = filterIds.contains(new Integer(1));
        System.out.println(f);


        long time = new Date().getTime();
        long l = System.currentTimeMillis();

        Thread.sleep(1000);

        long time2 = new Date().getTime();

        System.out.println("时间差：----->"+(time2-time));
        System.out.println("时间差：----->"+(time2-l));
    }
}
