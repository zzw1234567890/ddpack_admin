package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    protected int id;
    protected String orderId;
    protected int userId;
    protected int courierId;
    protected int pickAddressId;
    protected int takeAddressId;
    protected int state;
    protected float money;
    protected int isPick;
    protected String code;
    protected String createTime;
    protected String takeTime;
    protected String payTime;
    protected String remark;

}
