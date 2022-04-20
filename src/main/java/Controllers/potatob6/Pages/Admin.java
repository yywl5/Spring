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

    @GetMapping("/Page")
    public ModelAndView adminPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("potatob6/AdminPage");
        Integer n1 = examService.getNumberOfAllNotHandledExams();
        modelAndView.addObject("n1", n1);
        return modelAndView;
    }

    @GetMapping("/Exams")
    public ModelAndView adminExams(HttpServletRequest request) {
        return adminPage(request);
    }
}
