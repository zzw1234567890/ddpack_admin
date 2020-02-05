package top.amazing.ddpack_admin.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TableDataResponse {
    private int code = 0;
    private String msg = "";
    private int count = 0;
    private List data = null;
}
