package top.amazing.ddpack_admin.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@Component
public class LocationSearchConfig{
    @Value("${map.url}")
    private String url;
    @Value("${map.key}")
    private String key;

    private int pageSize = 20;
    private int pageIndex = 1;
    private String orderby = "_distance";

    public Map<String, Object> getParams(String boundary,String keyword) {
        Map<String,Object> params = new HashMap<>();
        params.put("boundary",boundary);
        params.put("page_size",pageSize);
        params.put("page_index",pageIndex);
        params.put("keyword",keyword);
        params.put("orderby",orderby);
        params.put("key",key);
        return params;
    }
}
