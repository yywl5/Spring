package Controllers.potatob6.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class Admin {

    /**
     * 管理员登录页面
     * @return
     */
    @GetMapping("/Login")
    public String adminLoginPage() {
        return "potatob6/AdminLogin";
    }
}
