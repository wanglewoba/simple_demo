package common.threadTest.vo;/**
 * Created by admin on 2017/12/26.
 */

/**
 * @author sunwenwu
 * @create 2017-12-26 15:17
 **/
public class Person {

    private String name;
    private String age;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getAge() {
        return age;
    }

    public synchronized void setAge(String age) {
        this.age = age;
    }
}
