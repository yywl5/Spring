package Controllers.potatob6.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Admin/Options")
public class AdminOptions {

    @GetMapping(value = {"/", ""})
    public String options(Model model, HttpServletRequest request) {
        return "potatob6/AdminOptionsCenter";
    }
}
