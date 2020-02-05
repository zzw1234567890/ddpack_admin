package top.amazing.ddpack_admin.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderTableRequest {
    private String orderId;
    private String userId;
    private String courierId;
    private String pickAddressId;
    private String takeAddressId;
    private String code;
    private String state;
    private String startTime;
    private String endTime;
    private int page;
    private int limit;
}
