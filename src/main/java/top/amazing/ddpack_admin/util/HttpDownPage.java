package top.amazing.ddpack_admin.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HttpDownPage {
    private final static String URL_1 = "?";
    private final static String URL_2 = "=";
    private final static String URL_3 = "&";

    public static Object get(String url, Map<String,Object> params, Class responseClass){
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append(URL_1);
        for (String key : params.keySet()){
            stringBuilder.append(key);
            stringBuilder.append(URL_2);
            stringBuilder.append(params.get(key));
            stringBuilder.append(URL_3);
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(stringBuilder.toString(),String.class);
        return JSONObject.parseObject(responseEntity.getBody(), responseClass);
    }

    public static Object post(String url, Map<String,Object> params, Class responseClass){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,params,String.class);
        return JSONObject.parseObject(responseEntity.getBody(), responseClass);
    }
}

