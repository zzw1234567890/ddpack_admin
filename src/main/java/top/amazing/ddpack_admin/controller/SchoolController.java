package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.config.LocationSearchConfig;
import top.amazing.ddpack_admin.dao.SchoolDao;
import top.amazing.ddpack_admin.dao.base.School;
import top.amazing.ddpack_admin.request.SchoolTableRequest;
import top.amazing.ddpack_admin.response.LocationSearchResponse;
import top.amazing.ddpack_admin.response.TableDataResponse;
import top.amazing.ddpack_admin.util.HttpDownPage;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/school/")
public class SchoolController {
    @Resource
    private LocationSearchConfig locationSearchConfig;
    @Resource
    private SchoolDao schoolDao;
    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("school/schoolList");
        return mv;
    }
    // 添加页面
    @GetMapping("insert")
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("school/schoolInsert");
        return mv;
    }
    // 单条记录查询
    @GetMapping("get")
    public School get(int id){
        return schoolDao.selectById(id);
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(SchoolTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(schoolDao.query(tableRequest));
        response.setCount(schoolDao.queryCount(tableRequest));
        return response;
    }
    // 更新
    @PostMapping("update")
    public boolean update(School school){
//        System.out.println(cUser);
        schoolDao.update(school);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        schoolDao.del(idList);
        return true;
    }
    // 新增记录
    @PostMapping("insertAction")
    public boolean insertAction(School school){
        schoolDao.insert(school);
        return true;
    }
    // 获取学校经纬度
    @GetMapping("getLocation")
    public LocationSearchResponse getLocation(String city,String name){
        locationSearchConfig.setPageSize(10);
        String boundary = "region(" + city + ",0)";
        Map<String,Object> params = locationSearchConfig.getParams(boundary,name);
        return (LocationSearchResponse) HttpDownPage.get(locationSearchConfig.getUrl(),params,LocationSearchResponse.class);
    }
}
