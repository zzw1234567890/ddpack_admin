package top.amazing.ddpack_admin.dao.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BLog {
    private int id;
    private int cuId;
    private int money;
    private String event;
    private String createTime;
}
