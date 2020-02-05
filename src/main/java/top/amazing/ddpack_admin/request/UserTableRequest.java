package top.amazing.ddpack_admin.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserTableRequest {
    private String nickname;
    private String integral;
    private String type;
    private String startTime;
    private String endTime;
    private int page;
    private int limit;
}
