package Controllers.potatob6.Interceptors;

import Beans.potatob6.Administrator;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().equals("/Admin/Login") || request.getRequestURI().equals("/admin/login")) {
            return true;
        }
        Administrator administrator = (Administrator) request.getSession().getAttribute("admin");
        if(administrator == null) {
            response.sendRedirect("/Admin/Login");
        }
        return true;
    }
}
