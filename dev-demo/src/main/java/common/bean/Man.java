package common.bean;/**
 * Created by admin on 2017/8/31.
 */

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunwenwu
 * @create 2017-08-31 11:25
 **/
public class Man {
    private String name;

    private Integer age;

    @NotBlank(message = "交易日期不能为空")
    @Length(max = 8, message = "交易日期长度不能大于8")
    @Pattern(regexp = "^[^`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]*$", message = "交易日期不能有特殊字符")
    private String tradeDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception{

        Thread.sleep(60000);
        List ali = new ArrayList();

        List lli = new LinkedList();

        final List list = Collections.synchronizedList(new ArrayList());


    }
}
