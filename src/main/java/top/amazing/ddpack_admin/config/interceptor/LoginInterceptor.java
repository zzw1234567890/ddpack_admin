package top.amazing.ddpack_admin.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.amazing.ddpack_admin.dao.AdminDao;
import top.amazing.ddpack_admin.dao.base.Admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private AdminDao adminDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = adminDao.selectById(1);
        admin.setId(1);
        request.getSession().setAttribute("admin",admin);
        if (request.getSession().getAttribute("admin") == null){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}