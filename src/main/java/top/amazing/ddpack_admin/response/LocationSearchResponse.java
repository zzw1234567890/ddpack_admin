package top.amazing.ddpack_admin.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class LocationSearchResponse {
    private int status;
    private String message;
    private int count;
    private String request_id;
    private List data;
}
