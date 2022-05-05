package Controllers.potatob6.Pages;


import Services.potatob6.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin/Borrow")
public class AdminBorrow {

    @Autowired
    @Qualifier("PBBorrowService")
    private BorrowService borrowService;

    @GetMapping(value = {"/", ""})
    public String borrowPage(Model model) {
        model.addAttribute("list", borrowService.getAllBorrow());
        return "potatob6/AdminBorrow";
    }
}
