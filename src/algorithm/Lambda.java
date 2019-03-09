package algorithm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;


public class Lambda {

    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
    //
    private static final String JSON_HYPER="[{\"type\":\"java.lang.Boolean\",\"value\":\"true\",\"mayvalue\":\"true\"},{\"type\":\"bytes\",\"value\":\"3100000000000000000000000000000000000000000000000000000000000000\",\"mayvalue\":\"1\"}]";
    public static void main(String args[]) {

        testJSONStrToJSONObject();
        testJSONStrToJSONArray();
        testComplexJSONStrToJSONObject();
    }
    /**
     * json字符串-简单对象型与JSONObject之间的转换
     */
    public static void testJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的
        System.out.println("===1.0==");
        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        System.out.println("===1.1==");

    }
    /**
     * json字符串-数组类型与JSONArray之间的转换
     */
    public static void testJSONStrToJSONArray(){

        JSONArray jsonArray = JSON.parseArray(JSON_HYPER);
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的
        System.out.println("===2.0==");
        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(1);
            System.out.println(jsonObject.getString("mayvalue"));
        }
        System.out.println("===2.1==");
        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("type")+":"+jsonObject.getString("value"));
        }
        System.out.println("===2.2==");

        Object a=jsonArray.get(1);
        String s=a.toString();
        System.out.println(s);
    }
    /**
     * 复杂json格式字符串与JSONObject之间的转换
     */
    public static void testComplexJSONStrToJSONObject(){
        System.out.println("===3.2==");
        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的

        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");
        System.out.println("===3.2==");

    }


}
