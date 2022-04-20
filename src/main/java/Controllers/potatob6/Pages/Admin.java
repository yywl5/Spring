package Controllers.potatob6.Pages;

import Beans.potatob6.Administrator;
import Services.potatob6.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Admin")
public class Admin {

    @Autowired
    private ExamService examService;

    /**
     * 管理员登录页面
     * @return
     */
    @GetMapping("/Login")
    public String adminLoginPage() {
        return "potatob6/AdminLogin";
    }

    /**
     * 管理员个人页面
     * @return
     */
    @GetMapping(value = {"/Page", "/", ""})
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView("potatob6/AdminPage");
        Integer n1 = examService.getNumberOfAllNotHandledExams();
        modelAndView.addObject("n1", n1);
        return modelAndView;
    }

    /**
     * 管理员处理待办请求页面
     * @return
     */
    @GetMapping("/NotHandled")
    public String notHandled() {
        return "potatob6/AdminNotHandledExams";
    }

    /**
     * 管理员查看所有请求页面
     * @return
     */
    @GetMapping("/Exams")
    public String adminExams() {
        return "potatob6/AdminExams";
    }

    /**
     * 管理员管理所有管理员
     * @return
     */
    @GetMapping("/Admins")
    public String admins() {
        return "potatob6/AdminAdmins";
    }
}
