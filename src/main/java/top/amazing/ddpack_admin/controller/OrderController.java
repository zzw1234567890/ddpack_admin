package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.OrderDao;
import top.amazing.ddpack_admin.dao.base.Order;
import top.amazing.ddpack_admin.request.OrderTableRequest;
import top.amazing.ddpack_admin.response.TableDataResponse;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单后台管理相关接口
 */
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Resource
    private OrderDao orderDao;
    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order/orderList");
        return mv;
    }
    // 查询一条订单
    @GetMapping("get")
    public Order get(int id){
        return orderDao.selectById(id);
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(OrderTableRequest tableRequest){
        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(orderDao.query(tableRequest));
        response.setCount(orderDao.queryCount(tableRequest));
        return response;
    }
    // 更新
    @PostMapping("update")
    public boolean update(Order order){
//        System.out.println(cUser);
        orderDao.update(order);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        orderDao.del(idList);
        return true;
    }
}
