package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.School;
import top.amazing.ddpack_admin.request.SchoolTableRequest;

import java.util.List;

public interface SchoolDao {
    List query(SchoolTableRequest tableRequest);

    int queryCount(SchoolTableRequest tableRequest);

    void update(School school);

    void del(List<Integer> idList);

    School selectById(int id);

    void insert(School school);

    List<School> selectAll();

    School locate(String lat, String lng);
}
