package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PickAddress {
    private int id;
    private int schoolId;
    private String company;
    private String img;
    private String pickAddress;
    private String createTime;

    private String school;
}
