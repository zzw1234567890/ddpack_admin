package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.CourierDao;
import top.amazing.ddpack_admin.dao.base.Courier;
import top.amazing.ddpack_admin.request.CourierTableRequest;
import top.amazing.ddpack_admin.response.TableDataResponse;

import javax.annotation.Resource;
import java.util.List;

/**
 * 派送员后台管理相关接口
 */
@RestController
@RequestMapping("/courier/")
public class CourierController {
    @Resource
    private CourierDao courierDao;
    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courier/courierList");
        return mv;
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(CourierTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(courierDao.query(tableRequest));
        response.setCount(courierDao.queryCount(tableRequest));
        return response;
    }
    // 根据id获取信息
    @GetMapping("getById")
    public Courier getById(int id){
        return courierDao.getById(id);
    }
    // 更新
    @PostMapping("update")
    public boolean update(Courier courier){
//        System.out.println(cUser);
        courierDao.update(courier);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        courierDao.del(idList);
        return true;
    }
}
