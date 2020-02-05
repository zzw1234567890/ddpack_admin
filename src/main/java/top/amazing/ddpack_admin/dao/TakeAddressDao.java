package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.TakeAddress;
import top.amazing.ddpack_admin.dao.extend.SelectData;
import top.amazing.ddpack_admin.request.TakeAddressTableRequest;

import java.util.List;

public interface TakeAddressDao {

    TakeAddress selectById(int id);

    List query(TakeAddressTableRequest tableRequest);

    int queryCount(TakeAddressTableRequest tableRequest);

    void update(TakeAddress takeAddress);

    void del(List<Integer> idList);

    void insert(TakeAddress takeAddress);

    List<SelectData> getByOrderId(int orderId);
}
