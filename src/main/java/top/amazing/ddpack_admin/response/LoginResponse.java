package top.amazing.ddpack_admin.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponse {
    private String openid;
    private String session_key;
    private String unionid;
    private int errcode;
    private String errmsg;
}
