package top.amazing.ddpack_admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.amazing.ddpack_admin.dao.AdminDao;
import top.amazing.ddpack_admin.dao.base.Admin;
import zzw.util.fileupload.FileUpload;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class IndexController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private FileUpload fileUpload;
    @Resource
    private AdminDao adminDao;

    // 后台默认页面
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/userList");
        return mv;
    }
    // 管理员信息修改页面
    @GetMapping("infoUpdate")
    public ModelAndView infoUpdate(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("infoUpdate");
        return mv;
    }
    // 管理员登录页面
    @GetMapping("login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    // 管理员用户登录
    @PostMapping("loginAction")
    public boolean loginAction(String code, Admin admin){
        admin = adminDao.login(admin);
        if (admin == null){
            return false;
        }
        request.getSession().setAttribute("admin",admin);
        return true;
    }
    // 获取管理员信息
    @GetMapping("getInfo")
    public Admin getInfo(){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        return adminDao.selectById(admin.getId());
    }
    // 更新管理员信息
    @PostMapping("update")
    public boolean update(MultipartFile file,String data){
        Admin admin = JSONObject.parseObject(data,Admin.class);
        Admin adminSession = (Admin)(request.getSession().getAttribute("admin"));
        admin.setId(adminSession.getId());
        if (file != null)
            admin.setHead(fileUpload.save(file));
        else
            admin.setHead(adminSession.getHead());
        adminDao.update(admin);
        adminSession.setHead(admin.getHead());
        adminSession.setName(admin.getName());
        request.getSession().setAttribute("admin",adminSession);
        return true;
    }
}
