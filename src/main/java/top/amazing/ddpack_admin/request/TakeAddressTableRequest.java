package top.amazing.ddpack_admin.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TakeAddressTableRequest {
    private String userId;
    private String dormitoryId;
    private String takeAddress;
    private String name;
    private String takePhone;
    private String sex;
    private String startTime;
    private String endTime;
    private int page;
    private int limit;
}
