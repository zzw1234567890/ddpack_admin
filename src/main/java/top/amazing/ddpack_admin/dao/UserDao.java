package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.User;
import top.amazing.ddpack_admin.request.UserTableRequest;

import java.util.List;

public interface UserDao {

    void insert(String openId);

    User selectById(int id);

    void update(User user);

    List<User> query(UserTableRequest queryRequest);

    int queryCount(UserTableRequest tableRequest);

    void del(List<Integer> idList);
}
