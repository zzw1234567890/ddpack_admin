package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.Admin;

public interface AdminDao {
    Admin login(Admin admin);

    Admin selectById(int id);

    void update(Admin admin);
}
