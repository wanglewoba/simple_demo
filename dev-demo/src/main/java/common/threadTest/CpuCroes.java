package common.threadTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunwenwu on 2018/8/28.
 */
public class CpuCroes {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        test(5);
    }

    public static void test(int n){
        int[] a = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        for (int i=0;i<list.size();i++){
            if(list.get(0)==1){
                list.add(99);
            }
            System.out.println(list.get(i));
        }


    }
}
