package common.extendsTest.vo;/**
 * Created by admin on 2017/12/1.
 */

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author sunwenwu
 * @create 2017-12-01 17:30
 **/
public class Father {

    private String name;

    private String sex;

    public String test;

    public String test2;


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
        return ToStringBuilder.reflectionToString(this);
    }

    public static void main(String[] args) {
        Father f = new Father();
        f.setName("aa");
        f.setSex("男");
        System.out.println(f);
    }
}
