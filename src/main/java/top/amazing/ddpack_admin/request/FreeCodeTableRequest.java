package top.amazing.ddpack_admin.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreeCodeTableRequest {
    private String nickname;
    private String num;
    private String code;
    private String orderId;
    private String startTime;
    private String endTime;
    private int page;
    private int limit;
}
