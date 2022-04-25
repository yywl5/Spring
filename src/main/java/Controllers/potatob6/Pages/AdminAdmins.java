package Controllers.potatob6.Pages;

import Beans.potatob6.Administrator;
import Beans.potatob6.Book;
import Services.potatob6.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminAdmins {

    @Autowired
    private AdminsService adminsService;

    /**
     * 管理员查询管理员页面
     * @param model
     * @return
     */
    @GetMapping("/Admins")
    public String checkAllAdmins(Model model, @RequestParam(value = "words", required = false) String words) {
        if(words == null || words.equals("")) {
            List<Administrator> adminList = adminsService.getPageOfAdmin(1);
            model.addAttribute("list", adminList);
            model.addAttribute("page", 1);
            return "potatob6/AdminAdmins";
        } else {
            List<Administrator> seached = adminsService.searchAdmin(words);
            model.addAttribute("page", 1);
            model.addAttribute("list", seached);
            model.addAttribute("searchWord", words);
            return "potatob6/AdminAdmins";
        }
    }
}
