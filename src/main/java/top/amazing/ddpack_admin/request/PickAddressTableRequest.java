package top.amazing.ddpack_admin.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PickAddressTableRequest {
    private String schoolId;
    private String company;
    private String pickAddress;
    private String startTime;
    private String endTime;
    private int page;
    private int limit;
}
