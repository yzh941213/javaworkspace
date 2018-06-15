package system.uitls;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * User:yanzh
 * Date:2017年9月20日08:59:36
 * 文字识别工具类
 */
public class Discriminate {

    //设置APPID/AK/SK
    public static final String APP_ID = "10162613";
    public static final String API_KEY = "2VB9jbkoQre3a6sYDt34R1H2";
    public static final String SECRET_KEY = "MlSjG7nAShzbFkm3jhK3Hsicu2e0VvXx";


    /**
     * User:yanzh
     * Date:2017年9月20日08:59:36
     * 文字识别
     */
    public static void getSample(){

        // 初始化一个OcrClient
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        //client.setConnectionTimeoutInMillis(2000);
        //client.setSocketTimeoutInMillis(6000);

        /* // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理*/

        // 调用接口
        String path = "C:/Users/yzh/Desktop/123.jpg";
        //普通识别(每天500次免费)
        JSONObject response = client.basicGeneral(path, new HashMap<String, String>());

        //精度识别(每天50次免费)
       // JSONObject response = client.basicAccurateGeneral(path, new HashMap<String, String>());

        //精度识别带位置信息(每天50次免费)
        // JSONObject response = client.accurateGeneral(path, new HashMap<String, String>());

        System.out.println(response.toString(2));
        //Object list = response.get("words_result");
        List<Object> result =response.getJSONArray("words_result").toList();
    }

    public static void main(String[] args) {
        getSample();
    }

}
