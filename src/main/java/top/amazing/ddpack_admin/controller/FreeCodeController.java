package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.FreeCodeDao;
import top.amazing.ddpack_admin.dao.base.FreeCode;
import top.amazing.ddpack_admin.request.FreeCodeTableRequest;
import top.amazing.ddpack_admin.response.TableDataResponse;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/freeCode/")
public class FreeCodeController {
    @Resource
    private FreeCodeDao freeCodeDao;

    // 管理列表
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("freeCode/freeCodeList");
        return mv;
    }
    // 添加页面
    @GetMapping("insert")
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("freeCode/freeCodeInsert");
        return mv;
    }
    @GetMapping("get")
    public FreeCode get(int id){
        return freeCodeDao.selectById(id);
    }
    // 查询
    @GetMapping("query")
    public TableDataResponse query(FreeCodeTableRequest tableRequest){
//        System.out.println(tableRequest);
        tableRequest.setPage((tableRequest.getPage() - 1) * tableRequest.getLimit());
        TableDataResponse response = new TableDataResponse();
        response.setData(freeCodeDao.query(tableRequest));
        response.setCount(freeCodeDao.queryCount(tableRequest));
        return response;
    }
    // 更新
    @PostMapping("update")
    public boolean update(FreeCode freeCode){
//        System.out.println(cUser);
        freeCodeDao.update(freeCode);
        return true;
    }
    // 删除
    @GetMapping("del")
    public boolean del(@RequestParam("idList[]") List<Integer> idList){
        freeCodeDao.del(idList);
        return true;
    }
    // 新增记录
    @PostMapping("insertAction")
    public boolean insertAction(FreeCode freeCode){
        freeCodeDao.insert(freeCode);
        return true;
    }
    // 自动生成免单码
    @GetMapping("generate")
    public String generate(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int j;
        for (j = 0;j < 1000;j++){
            for (int i = 0; i < 5; i++) {
                int t = random.nextInt(46);
                if (t < 20) {
                    stringBuilder.append(t % 10);
                } else {
                    char c = (char) (t - 20 + 'a');
                    stringBuilder.append(c);
                }
            }
            if (freeCodeDao.selectByCode(stringBuilder.toString()) == 0)
                break;
        }
        if (j >= 1000){
            return null;
        }
        return stringBuilder.toString();
    }
}
