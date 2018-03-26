package common.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunwenwu on 2018/3/26.
 */
public class MeList {

    public static void main(String[] args) {

        List<AA> tl = new ArrayList<>();
        AA aa;
        for(int i=0;i<10;i++){
            aa = new AA();
            aa.setId(i);
            aa.setName(i+" "+i);
            tl.add(aa);
        }
        System.out.println(tl);
    }
}
class AA{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}