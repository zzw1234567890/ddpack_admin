package top.amazing.ddpack_admin.dao.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Setting {
    private int id;
    private int rate;
    private int take;
    private int pick;
    private int transfer;
}
