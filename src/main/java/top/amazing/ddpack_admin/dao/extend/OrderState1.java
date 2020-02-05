package top.amazing.ddpack_admin.dao.extend;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderState1 {
    private int id;
    private String orderId;
    private String createTime;
    private String code;

    private String name;
    private String takePhone;
    private String takeAddress;

    private String company;
    private String pickAddress;
}
