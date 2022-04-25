package Controllers.potatob6.Pages;

import Services.potatob6.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Admin/Users")
public class AdminUsers {

    @Autowired
    private UsersService userService;

    @GetMapping(value = {"", "/"})
    public String AdminUsersPage(Model model, @RequestParam(value = "words", required = false) String words) {
        if(words == null || words.equals("")) {
            model.addAttribute("list", userService.getPageOfUser(1));
            model.addAttribute("page", 1);
            return "potatob6/AdminUsers";
        } else {
            model.addAttribute("page", 1);
            model.addAttribute("list", userService.searchUser(words));
            model.addAttribute("searchWord", words);
            return "potatob6/AdminUsers";
        }
    }
}
