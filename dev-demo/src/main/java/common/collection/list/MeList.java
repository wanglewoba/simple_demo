package common.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunwenwu on 2018/3/26.
 */
public class MeList {

    public static void main(String[] args) {
        List<List<AA>> resultList = new ArrayList<>();

        List<AA> tl = new ArrayList<>();
        AA aa;
        for(int i=0;i<10;i++){
            aa = new AA();
            aa.setId(i);
            aa.setName(i+" "+i);
            tl.add(aa);
        }
        System.out.println("测试数据"+tl);

        List<AA> smallList = null;
        int k=3;//每行显示数
        for (int i=0;i<tl.size();i++){
            if(i%k == 0){
                smallList = new ArrayList<>();
                resultList.add(smallList);
            }
            smallList.add(tl.get(i));
        }
        for(int j=0;j<resultList.size();j++){
            System.out.println("第"+(j+1)+" 返回数据 "+resultList.get(j));
        }
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