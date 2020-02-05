package top.amazing.ddpack_admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.PickAddressDao;
import top.amazing.ddpack_admin.dao.SchoolDao;
import top.amazing.ddpack_admin.dao.base.PickAddress;
import top.amazing.ddpack_admin.dao.base.School;
import top.amazing.ddpack_admin.dao.extend.SelectData;
import top.amazing.ddpack_admin.request.PickAddressTableRequest;
import top.amazing.ddpack_admin.response.TableDataResponse;
import zzw.util.fileupload.FileUpload;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pickAddress/")
public class PickAddressController {
    @Resource
    private PickAddressDao pickAddressDao;
    @Resource
    private SchoolDao schoolDao;
    @Resource
    private FileUpload fileUpload;
    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<School> schoolList = schoolDao.selectAll();
        mv.addObject(schoolList);
        mv.setViewName("pickAddress/pickAddressList");
        return mv;
    }
    // 添加页面
    @GetMapping("insert")
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView();
        List<School> schoolList = schoolDao.selectAll();
        mv.addObject(schoolList);
        mv.setViewName("pickAddress/pickAddressInsert");
        return mv;
    }
    // 单条记录查询
    @GetMapping("get")
    public PickAddress get(int id){
        return pickAddressDao.selectById(id);
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(PickAddressTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(pickAddressDao.query(tableRequest));
        response.setCount(pickAddressDao.queryCount(tableRequest));
        return response;
    }
    // 更新
    @PostMapping("update")
    public boolean update(MultipartFile file, String data){
        PickAddress pickAddress = JSONObject.parseObject(data,PickAddress.class);
        if (file != null)
            pickAddress.setImg(fileUpload.save(file));
        System.out.println(pickAddress.getImg());
        pickAddressDao.update(pickAddress);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        pickAddressDao.del(idList);
        return true;
    }
    // 新增记录
    @PostMapping("insertAction")
    public boolean insertAction(PickAddress pickAddress){
        pickAddressDao.insert(pickAddress);
        return true;
    }
    // 根据orderId查询取货地址
    @GetMapping("getByOrder")
    public List<SelectData> getByOrder(int orderId){
        return pickAddressDao.getByOrderId(orderId);
    }
}
