package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.PickAddress;
import top.amazing.ddpack_admin.dao.extend.SelectData;
import top.amazing.ddpack_admin.request.PickAddressTableRequest;

import java.util.List;

public interface PickAddressDao {
    PickAddress selectById(int id);

    List query(PickAddressTableRequest tableRequest);

    int queryCount(PickAddressTableRequest tableRequest);

    void update(PickAddress pickAddress);

    void del(List<Integer> idList);

    void insert(PickAddress pickAddress);

    List<SelectData> getByOrderId(int orderId);
}
