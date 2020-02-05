package top.amazing.ddpack_admin.dao.extend;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.amazing.ddpack_admin.dao.base.TakeAddress;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TakeAddressExtend extends TakeAddress {
    private String takeAddress;
    private String takePhone;

    private String nickname;
    private String dormitory;
}
