package common.NoSort;

/**
 * @author sunwenwu
 * @create 2017-08-31 17:19
 **/
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("4:"+getResult(4));
        System.out.println("3:"+getResult(3));
        System.out.println("2:"+getResult(2));
        System.out.println("1:"+getResult(1));
    }

    public static int getResult(int n){
        int temp1=1;
        int temp2=1;
        int result=0;
        for(int i=0;i<n;i++){
            temp1=temp1*n;
        }
        for(int i=0;i<(n-1);i++){
            temp2=temp2*(n-1);
        }
        for(int x=0;;x++){
            result=(x+1)*temp1/temp2+1-n;
            int temp=result;

            int bear=n;
            while(bear>0) {

                if(temp%n==1){
                    temp=temp-temp/n-1;
//                    temp=((temp-1)/n)*(n-1);   这个效率低！！上面那句简单！！
                    bear--;
                }else {
                    break;
                }

            }
            if(bear==0) {
                return result;
            }
        }
    }
}
