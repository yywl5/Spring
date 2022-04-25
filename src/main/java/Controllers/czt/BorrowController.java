package Controllers.czt;

import Beans.potatob6.User;
import Services.Y0looo.Impl.BorrowServiceImpl;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BorrowController {

    @Autowired
    private BorrowServiceImpl borrowService;

    /**
     * 查询未归还
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("toBorrows")
    public String toBorrows(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserId();
        if(userId != 0){
            List list = borrowService.getBorrowUserNotReturn(userId);
            if(list != null){
                model.addAttribute("borrow", list);
                return "Y0looo/ShowBorrows";
            } else {
                model.addAttribute("errorMsg","无法查询到借阅信息");
                return "Y0looo/error";
            }
        } else {
            model.addAttribute("errorMsg","无法获取用户id");
            return "Y0looo/error";
        }
    }

    @RequestMapping("toAllBorrows")
    public String toAllBorrows(HttpServletRequest request,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserId();
        if(userId != 0){
            List list = borrowService.getAllBorrowByUserId(userId);
            if(list != null){
                model.addAttribute("borrow", list);
                return "Y0looo/ShowBorrows";
            } else {
                model.addAttribute("errorMsg","无法查询到借阅信息");
                return "Y0looo/error";
            }
        } else {
            model.addAttribute("errorMsg","无法获取用户id");
            return "Y0looo/error";
        }
    }

    @RequestMapping("toNotReturnBorrows")
    public String toNotReturnBorrows(HttpServletRequest request,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserId();
        if(userId != 0){
            List list = borrowService.getBorrowUserNotReturn(userId);
            if(list != null){
                model.addAttribute("borrow", list);
                return "Y0looo/ShowBorrows";
            } else {
                model.addAttribute("errorMsg","无法查询到借阅信息");
                return "Y0looo/error";
            }
        } else {
            model.addAttribute("errorMsg","无法获取用户id");
            return "Y0looo/error";
        }
    }

    @RequestMapping("toIsReturnBorrows")
    public String toIsReturnBorrows(HttpServletRequest request,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserId();
        if(userId != 0){
            List list = borrowService.getBorrowUserIsReturn(userId);
            if(list != null){
                model.addAttribute("borrow", list);
                return "Y0looo/ShowBorrows";
            } else {
                model.addAttribute("errorMsg","无法查询到借阅信息");
                return "Y0looo/error";
            }
        } else {
            model.addAttribute("errorMsg","无法获取用户id");
            return "Y0looo/error";
        }
    }

    @RequestMapping("toWillOverTimeBorrows")
    public String toWillOverTimeBorrows(HttpServletRequest request,Model model ) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getUserId();
        if(userId != 0){
            List list = borrowService.getBorrowWillOverTime(userId);
            if(list != null){
                model.addAttribute("borrow", list);
                return "Y0looo/ShowBorrows";
            } else {
                model.addAttribute("errorMsg","无法查询到借阅信息");
                return "Y0looo/error";
            }
        } else {
            model.addAttribute("errorMsg","无法获取用户id");
            return "Y0looo/error";
        }
    }

    @RequestMapping("toLastPage")
    public String toLastPage() {
        return "yywl5/LoginMainPage";
    }
}
