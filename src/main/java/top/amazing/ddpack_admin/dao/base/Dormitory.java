package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Dormitory {
    protected int id;
    protected int schoolId;
    protected String name;
    protected String createTime;
}
