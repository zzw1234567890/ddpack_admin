package top.amazing.ddpack_admin.dao.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreeCode {
    private int id;
    private int userId;
    private String code;
    private int orderId;
    private String createTime;

    private String nickname;
}
