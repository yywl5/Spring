package Controllers.czx;

import Beans.czx.ICategory;
import Beans.czx.IRole;
import Beans.czx.IUser;
import Services.czx.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ICategoryController {
    @Autowired
    private ICategoryService icategoryService;
    @RequestMapping("findIcategorylist.action")
    public String findIcategoryList(Model model){
        /****
         * 获取不同公共以及种类的类别
         */
        List<ICategory> IcategoryList = icategoryService.findCategoryList();
        model.addAttribute("IcategoryList", IcategoryList);
        System.out.println(IcategoryList);
        return "czx/Icategory_list";
    }
    //转向添加用户
    @RequestMapping(value="/toAddcategory.action")
    public String toAddUser(){
        return "czx/Iadd_category";
    }
}
