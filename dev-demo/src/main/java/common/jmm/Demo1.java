package common.jmm;

/**
 * Created by sunwenwu on 2018/1/24.
 */
public class Demo1 {
    public static void main(String[] args){
        for(int i=0;i<1000;i++){
            int a = 1;
            int b = 2;

            try {
                a = 3;           //A
                b = 1 / 0;       //B
            } catch (Exception e){
                System.out.println("Catch----a = " + a);
            }finally {
                System.out.println("a = " + a);
            }
        }

    }
}
