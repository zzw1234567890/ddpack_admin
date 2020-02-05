package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User {
    private int id;
    private int schoolId;
    private String openId;
    private String nickname;
    private String head;
    private int integral;
    private int type;
    private String memberTime;
    private String createTIme;
    private int del;
}
