package common.extendsTest.vo;/**
 * Created by admin on 2017/12/1.
 */

/**
 * @author sunwenwu
 * @create 2017-12-01 17:32
 **/
public class Son extends Father {

    private String age;

    private String weight;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Son{" +
                "age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                '}'+super.toString();
    }
}
