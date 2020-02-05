package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.Setting;

public interface SettingDao {

    Setting getAll();

    void update(Setting setting);
}
