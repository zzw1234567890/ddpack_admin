package top.amazing.ddpack_admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.SettingDao;
import top.amazing.ddpack_admin.dao.base.Setting;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/fun/")
public class FunController {
    @Resource
    private SettingDao settingDao;

    // 设置管理页面
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        Setting setting = settingDao.getAll();
        mv.addObject(setting);
        System.out.println(setting);
        mv.setViewName("system/fun");
        return mv;
    }
    // 修改设置
    @PostMapping("update")
    public boolean update(Setting setting){
        settingDao.update(setting);
        return true;
    }
}
