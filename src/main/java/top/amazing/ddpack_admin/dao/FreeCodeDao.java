package top.amazing.ddpack_admin.dao;

import top.amazing.ddpack_admin.dao.base.FreeCode;
import top.amazing.ddpack_admin.request.FreeCodeTableRequest;

import java.util.List;

public interface FreeCodeDao {
    List query(FreeCodeTableRequest tableRequest);

    int queryCount(FreeCodeTableRequest tableRequest);

    void update(FreeCode freeCode);

    void del(List<Integer> idList);

    FreeCode selectById(int id);

    int selectByCode(String code);

    void insert(FreeCode freeCode);

    void useCode(FreeCode freeCode);
}
