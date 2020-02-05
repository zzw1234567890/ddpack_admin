package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.Order;
import top.amazing.ddpack_admin.dao.extend.OrderState1;
import top.amazing.ddpack_admin.request.OrderTableRequest;

import java.util.List;

public interface OrderDao {
    int queryCount(OrderTableRequest tableRequest);

    List query(OrderTableRequest tableRequest);

    void update(Order order);

    void del(List<Integer> idList);

    Order selectById(int id);

    void insert(Order order);

    List<OrderState1> getByState1();
}
