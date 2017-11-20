//package common.Json;
//
//import java.util.*;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//public class BaseUtil {
//    public static String toUC(String param) {
//        char[] chars = param.toCharArray();
//        chars[0] =  (chars[0]+"").toUpperCase().toCharArray()[0];
//        return new String(chars);
//    }
//
//    public static JSONObject low2Up(JSONObject o1){
//        JSONObject o2=new JSONObject();
//        Iterator it = o1.keys();
//        while (it.hasNext()) {
//            String key = (String) it.next();
//            Object object = o1.get(key);
//            if(object.getClass().toString().endsWith("String")){
//                o2.accumulate(BaseUtil.toUC(key), object);
//            }else if(object.getClass().toString().endsWith("JSONObject")){
//                o2.accumulate(BaseUtil.toUC(key), BaseUtil.low2Up((JSONObject)object));
//            }else if(object.getClass().toString().endsWith("JSONArray")){
//                o2.accumulate(BaseUtil.toUC(key), BaseUtil.low2Array(o1.getJSONArray(key)));
//            }else{
//                o2.accumulate(BaseUtil.toUC(key), object);
//            }
//        }
//        return o2;
//    }
//
//    public static JSONArray low2Array(JSONArray o1){
//        JSONArray o2 = new JSONArray();
//        for (int i = 0; i < o1.size(); i++) {
//            Object jArray=o1.getJSONObject(i);
//            if(jArray.getClass().toString().endsWith("JSONObject")){
//                o2.add(BaseUtil.low2Up((JSONObject)jArray));
//            }else if(jArray.getClass().toString().endsWith("JSONArray")){
//                o2.add(BaseUtil.low2Array((JSONArray)jArray));
//            }
//        }
//        return o2;
//    }
//
//
//    /**
//     * 测试程序
//     *
//     * 测试结果：
//     *  before:{"id":111.11,"ob":{"age":"20","name":"李四"},"age":"19","name":"张三","list":[{"age":"230","name":"王五"}]}
//        after:{"Id":111.11,"Ob":{"Age":"20","Name":"李四"},"Age":"19","Name":"张三","List":[{"Age":"230","Name":"王五"}]}
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        Map<String,Object> u2 = new HashMap<String, Object>();
//        u2.put("name","李四");
//        u2.put("age","20");
//        Map<String,Object> u3 = new HashMap<String, Object>();
//        u3.put("name","王五");
//        u3.put("age","230");
//
//        List<Object> list = new ArrayList<Object>();
//        list.add(u3);
//
//        Map<String,Object> u = new HashMap<String, Object>();
//        u.put("name","张三");
//        u.put("age","19");
//        u.put("id",111.11);
//        u.put("list",list);
//        u.put("ob",u2);
//
//        JSONObject jsonObject = JSONObject.fromObject(u);
//        System.out.println("before:"+jsonObject);
//        System.out.println("after:"+low2Up(jsonObject));
//    }
//
//}
//
