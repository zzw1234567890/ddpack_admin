package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.Courier;
import top.amazing.ddpack_admin.request.CourierTableRequest;

import java.util.List;

public interface CourierDao {
    int queryCount(CourierTableRequest tableRequest);

    List query(CourierTableRequest tableRequest);

    void del(List<Integer> idList);

    void update(Courier courier);

    Courier getById(int id);
}
