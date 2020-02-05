package top.amazing.ddpack_admin.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SchoolTableRequest {
    private String name;
    private String city;
    private String startTime;
    private String endTime;
    private int page;
    private int limit;
}
