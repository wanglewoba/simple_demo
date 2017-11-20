package tempTest.newAbstracClass;/**
 * Created by admin on 2017/11/20.
 */

/**
 * @author sunwenwu
 * @create 2017-11-20 15:17
 **/
public abstract class AbTest {

    private String name;

    private String sex;


    public abstract void handle();

    public void doHandle(){
        handle();
    }

    public AbTest(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "AbTest{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
