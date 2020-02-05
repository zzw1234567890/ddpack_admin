package top.amazing.ddpack_admin.dao.extend;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.amazing.ddpack_admin.dao.base.Order;

@Getter
@Setter
@ToString
public class OrderExtend extends Order {
    protected String nickname;
    protected String courierName;
    protected String pickAddress;
    protected String takeAddress;
}
