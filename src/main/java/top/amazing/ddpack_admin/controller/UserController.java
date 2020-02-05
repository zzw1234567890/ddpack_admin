package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.UserDao;
import top.amazing.ddpack_admin.dao.base.User;
import top.amazing.ddpack_admin.request.UserTableRequest;
import top.amazing.ddpack_admin.response.TableDataResponse;

import javax.annotation.Resource;
import java.util.List;

/**
 * 普通用户相关接口
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    @Resource
    private UserDao userDao;
    // 管理页面
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/userList");
        return mv;
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(UserTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(userDao.query(tableRequest));
        response.setCount(userDao.queryCount(tableRequest));
        return response;
    }
    // 根据id查找
    @GetMapping("getById")
    public User getById(int id){
        return userDao.selectById(id);
    }
    // 更新
    @PostMapping("update")
    public boolean update(User user){
//        System.out.println(cUser);
        userDao.update(user);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        userDao.del(idList);
        return true;
    }
}
