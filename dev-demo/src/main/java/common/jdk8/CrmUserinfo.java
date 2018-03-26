package common.jdk8;

/**
 * Created by sunwenwu on 2018/1/8.
 */
public class CrmUserinfo {
    private String id;
    private String empId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "CrmUserinfo{" +
                "id='" + id + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
