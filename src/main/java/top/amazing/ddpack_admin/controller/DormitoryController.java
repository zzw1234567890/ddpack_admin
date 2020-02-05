package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.config.LocationSearchConfig;
import top.amazing.ddpack_admin.dao.DormitoryDao;
import top.amazing.ddpack_admin.dao.SchoolDao;
import top.amazing.ddpack_admin.dao.base.Dormitory;
import top.amazing.ddpack_admin.dao.base.School;
import top.amazing.ddpack_admin.request.DormitoryTableRequest;
import top.amazing.ddpack_admin.response.LocationSearchResponse;
import top.amazing.ddpack_admin.response.TableDataResponse;
import top.amazing.ddpack_admin.util.HttpDownPage;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dormitory/")
public class DormitoryController {
    @Resource
    private LocationSearchConfig locationSearchConfig;
    @Resource
    private DormitoryDao dormitoryDao;
    @Resource
    private SchoolDao schoolDao;
    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<School> schoolList = schoolDao.selectAll();
        mv.addObject(schoolList);
        mv.setViewName("dormitory/dormitoryList");
        return mv;
    }
    // 添加页面
    @GetMapping("insert")
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView();
        List<School> schoolList = schoolDao.selectAll();
        mv.addObject(schoolList);
        mv.setViewName("dormitory/dormitoryInsert");
        return mv;
    }
    // 单条记录查询
    @GetMapping("get")
    public Dormitory get(int id){
        return dormitoryDao.selectById(id);
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(DormitoryTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(dormitoryDao.query(tableRequest));
        response.setCount(dormitoryDao.queryCount(tableRequest));
        return response;
    }
    // 更新
    @PostMapping("update")
    public boolean update(Dormitory dormitory){
//        System.out.println(cUser);
        dormitoryDao.update(dormitory);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        dormitoryDao.del(idList);
        return true;
    }
    // 新增记录
    @PostMapping("insertAction")
    public boolean insertAction(Dormitory dormitory){
        dormitoryDao.insert(dormitory);
        return true;
    }
    // 获取学校附近的宿舍经纬度
    @GetMapping("getLocation")
    public LocationSearchResponse getLocation(int schoolId,@RequestParam(defaultValue = "学生宿舍") String name){
        School school = schoolDao.selectById(schoolId);
        String boundary = "nearby(" + school.getLat() + "," + school.getLng() + ",1000)";
        locationSearchConfig.setPageSize(10);
        Map<String,Object> params = locationSearchConfig.getParams(boundary,name);
        return (LocationSearchResponse) HttpDownPage.get(locationSearchConfig.getUrl(),params,LocationSearchResponse.class);
    }
}
