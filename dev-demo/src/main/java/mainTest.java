/**
 * Created by admin on 2017/12/8.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunwenwu
 * @create 2017-12-08 15:57
 **/
public class mainTest {
    public static void main(String[] args) {
        List<URL> registryList = new ArrayList<URL>();
        System.out.println(registryList.size());

        System.out.println(System.getProperty("sunwenwu"));
        System.out.println(System.getProperty("user.dir"));

    }
}
