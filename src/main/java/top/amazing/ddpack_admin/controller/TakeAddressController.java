package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.SchoolDao;
import top.amazing.ddpack_admin.dao.TakeAddressDao;
import top.amazing.ddpack_admin.dao.base.School;
import top.amazing.ddpack_admin.dao.base.TakeAddress;
import top.amazing.ddpack_admin.dao.extend.SelectData;
import top.amazing.ddpack_admin.request.TakeAddressTableRequest;
import top.amazing.ddpack_admin.response.TableDataResponse;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/takeAddress/")
public class TakeAddressController {
    @Resource
    private TakeAddressDao takeAddressDao;
    @Resource
    private SchoolDao schoolDao;
    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<School> schoolList = schoolDao.selectAll();
        mv.addObject(schoolList);
        mv.setViewName("takeAddress/takeAddressList");
        return mv;
    }
    // 单条记录查询
    @GetMapping("get")
    public TakeAddress get(int id){
        return takeAddressDao.selectById(id);
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(TakeAddressTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(takeAddressDao.query(tableRequest));
        response.setCount(takeAddressDao.queryCount(tableRequest));
        return response;
    }
    // 更新
    @PostMapping("update")
    public boolean update(TakeAddress takeAddress){
//        System.out.println(cUser);
        takeAddressDao.update(takeAddress);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        takeAddressDao.del(idList);
        return true;
    }
    // 新增记录
    @PostMapping("insertAction")
    public boolean insertAction(TakeAddress takeAddress){
        takeAddressDao.insert(takeAddress);
        return true;
    }
    // 根据orderId查询取货地址
    @GetMapping("getByOrder")
    public List<SelectData> getByOrder(int orderId){
    return takeAddressDao.getByOrderId(orderId);
    }
}
