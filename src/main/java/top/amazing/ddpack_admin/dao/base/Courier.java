package top.amazing.ddpack_admin.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Courier {
    private int id;
    private int userId;
    private String courierName;
    private String courierPhone;
    private int grade;
    private int identityState;
    private String identity;
    private String schoolId;
    private String studentId;
    private String admissionTime;
    private String graduationTime;
    private String education;
    private String createTime;
}
