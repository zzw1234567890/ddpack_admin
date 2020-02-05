package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class School {
    protected int id;
    protected String name;
    protected String city;
    protected double lat;
    protected double lng;
    protected String createTime;
}
