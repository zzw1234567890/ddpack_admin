package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TakeAddress {
    protected int id;
    protected int userId;
    protected int dormitoryId;
    protected String takeAddress;
    protected String name;
    protected String takePhone;
    protected int sex;
    protected int isDefault;
    protected String createTime;
}
