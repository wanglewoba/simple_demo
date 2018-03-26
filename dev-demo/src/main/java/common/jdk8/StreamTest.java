package common.jdk8;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sunwenwu on 2018/1/8.
 */
public class StreamTest {

    public static void main(String[] args) {
        String empId = "111";
        CrmUserinfo crm = new CrmUserinfo();
        crm.setEmpId("111");

        CrmUserinfo crm2 = new CrmUserinfo();
        crm2.setEmpId("222");

        List<CrmUserinfo> crmUserinfos = new ArrayList<>();
        crmUserinfos.add(crm);
        crmUserinfos.add(crm2);
        System.out.println("before:----->"+crmUserinfos.toString());

        List<CrmUserinfo> crmUserinfosByEmpId = crmUserinfos.parallelStream().filter(e->e.getEmpId() == empId).collect(Collectors.toList());
        System.out.println("after:----->"+crmUserinfosByEmpId.toString());


        int x = 1;
        int y = 1;
        int c = x=y=0;
        System.out.println("c:----------"+c);
        System.out.println("x:----------"+x);
        System.out.println("y:----------"+y);

    }
}
