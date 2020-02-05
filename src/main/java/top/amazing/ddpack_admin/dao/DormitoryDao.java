package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.Dormitory;
import top.amazing.ddpack_admin.request.DormitoryTableRequest;

import java.util.List;

public interface DormitoryDao {

    Dormitory selectById(int id);

    int queryCount(DormitoryTableRequest tableRequest);

    List query(DormitoryTableRequest tableRequest);

    void update(Dormitory dormitory);

    void del(List<Integer> idList);

    void insert(Dormitory dormitory);

    List<Dormitory> selectBySchoolId(int schoolId);
}
