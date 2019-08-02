import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author zhaocong
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @ -
 * @ -
 * @ -                                                    __----~~~~~~~~~~~------___
 * @ -                                   .  .   ~~//====......          __--~ ~~
 * @ -                   -.            \_|//     |||\\  ~~~~~~::::... /~
 * @ -                ___-==_       _-~o~  \/    |||  \\            _/~~-
 * @ -        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 * @ -    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 * @ -  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * @ - /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * @ - |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 * @ -          '         ~-|      /|    |-~\~~       __--~~
 * @ -                      |-~~-_/ |    |   ~\_   _-~                /\
 * @ -      龙妈保佑                 /  \     \__   \/~                \__
 * @ -                       _--~ _/ | .-~~____--~-/                  ~~==.
 * @ -                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 * @ -                                 -_     ~\      ~~---l__i__i__i--~~_/
 * @ -                                 _-~-__   ~)  \--______________--~~
 * @ -                               //.-~~~-~_--~- |-------~~~~~~~~
 * @ -                                      //.-~~~--\
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @date 2019-05-31
 * @description:
 */
public class qpEmployeeTest {

  public static void main(String[] args) {

//    getSaleId();
//    postHttp();
//    System.out.println(removeDuplicate(Arrays.asList("15657195202","12345678","15657195202")));

    System.out.println((1L << 9 & 512L) != 1L << 9);
  }

  public static void getSaleId() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("pageNo", "1");
    jsonObject.put("pageSize", "10");
    jsonObject.put("keyword", "diyuanyuan@qipeng.com");

    try {
      String url = "https://b.taovip.com/service/employee/search";
      String param = "Content-Type=application/json&App-Id=59ddb0bd203eca731de5456b&App-Secret=096e94dfc4fa7adfb6ec120095a1079f4a04bc981deae5665f8d4c0e9107e5cc";
      HttpClient httpClient = new DefaultHttpClient();
      HttpPost post = null;
      // 设置超时时间
      post = new HttpPost(url);
      // 构造消息头
      post.setHeader("Content-type", "application/json");
      post.setHeader("App-Id", "59ddb0bd203eca731de5456b");
      post.setHeader("App-Secret",
        "096e94dfc4fa7adfb6ec120095a1079f4a04bc981deae5665f8d4c0e9107e5cc");

      // 构建消息实体
      StringEntity entity = new StringEntity(jsonObject.toString(), Charset.forName("UTF-8"));
      entity.setContentEncoding("UTF-8");
      // 发送Json格式的数据请求
      entity.setContentType("application/json");
      post.setEntity(entity);

      HttpResponse response = httpClient.execute(post);
      HttpEntity httpEntity = response.getEntity();
      String result = EntityUtils.toString(httpEntity, "utf-8");
      JSONObject json = JSON.parseObject(result);
      JSONObject user= (JSONObject) json.getJSONObject("data").getJSONArray("records").get(0);
      Long id = user.getLong("id");
      System.out.println(id);
      System.out.println(json.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void postHttp(){
    CloseableHttpClient client = HttpClients.createDefault();
    String msg="\n"
      + "#销售名字#的客户当前余额少于最近7天累计的通知类账户消费金额：\n"
      + "公司名：烽火网络科技有限公司  id：8000000000001\n"
      + "公司名：多客网络科技有限公司  id：8000000000002\n"
      + "第四f3 4f 行";
    Collection<Long> uids= Arrays.asList(593L);

    String uidss = "";
    for(Long u : uids){
      uidss += u + ",";
    }
//    log.info(" 推送人工号为： " + uidss + "\nmsg: " + msg);
    HttpPost httpPost = new HttpPost("https://b.taovip.com/service/notify/qywx/text/push");
    httpPost.setHeader("App-Id", "59ddb0bd203eca731de5456b");
    httpPost.setHeader("App-Secret", "096e94dfc4fa7adfb6ec120095a1079f4a04bc981deae5665f8d4c0e9107e5cc");
//    httpPost.setHeader("appName", "sale");
    Gson gson = new Gson();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("msg", msg);
    jsonObject.put("users", uids);
    jsonObject.put("appName", "sale");
    String json = gson.toJson(jsonObject);
    StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
    httpPost.setEntity(requestEntity);
    try {
      CloseableHttpResponse e = client.execute(httpPost);
      String resEntity = EntityUtils.toString(e.getEntity());
    } catch (IOException e) {
    }
  }
  public static List<String> removeDuplicate(List list) {
    HashSet h = new HashSet(list);
    return new ArrayList<String>(h);
  }


}
