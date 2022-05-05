package Controllers.czx;

import Beans.czx.ICategory;
import Beans.czx.IRole;
import Beans.czx.IUser;
import Services.czx.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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

    /***
     * 添加用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/addCategory.action", method = RequestMethod.POST)
    public String addCategory(ICategory category, Model model) {
        // 获取列表
        List<ICategory> categoryList = icategoryService.findCategoryList();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("category",category);
        System.out.println("在addCategory处获取到的category是:"+category);
        System.out.println("在addCategory处获取到的category名称（1）是:"+category.getCategoryName());
        int categoryNameTest = category.getCategoryId();
        //检查登录账号是否已存在
        ICategory checkCategory = icategoryService.findCategoryById(categoryNameTest);
        System.out.println("在addCategory处获取到的category名称（2）是:"+categoryNameTest);
        if (checkCategory!=null) {
            // 分类类别已存在,重新转回添加用户页面
            System.out.println("在addCategory（1）处进入到错误页");
            model.addAttribute("checkCategoryNameMsg", "分类目录已存在，请重新输入");
            return "czx/Iadd_category";
        }else{
            //调用UserService实例中的添加用户方法
            System.out.println("在addCategory（2）处进入到成功页（2）");
            int rows = icategoryService.addIcategory(category);
            System.out.println("在addCategory处被数据库影响到的行是:"+rows+"行");
            if (rows > 0) {
                // 添加成功，转向用户列表页面
                System.out.println("在addCategory（2）处进入到成功页");
                return "redirect:findIcategorylist.action";
            } else {
                // 添加失败，重新转回添加用户页面
                System.out.println("在addCategory（2）处进入到错误页");
                return "czx/Iadd_category";
            }
        }
    }

    //删除用户（前台页面中通过ajax方式调用此方法）
    @RequestMapping(value = "delCategory.action")
    @ResponseBody
    public ICategory delCategory(@RequestBody ICategory category, Model model) {
        System.out.println("ajax转发调用已接收");
        int rows = icategoryService.delIcategory(category.getCategoryId());
        if (rows>0) {
            return category;
        }else{
            //此处设置为0，只是作为操作失败的标记用
            category.setCategoryId(0);
            return category;
        }
    }

    /**
     * 修改用户
     * @param category
     * @param model
     * @return
     */
    @RequestMapping(value = "/EditCategory.action", method = RequestMethod.POST)
    public String editCategory(ICategory category, Model model) {
        System.out.println("category处所获取的category值为:"+category);
        int rows = icategoryService.updateIcategory(category);
        if (rows > 0) {
            // 添加成功，转向用户列表页面
            return "redirect:findIcategorylist.action";
        } else {
            model.addAttribute("category", category);
            // 修改失败，转回修改用户页面
            return "czx/Iedit_category";
        }
    }

    /***
     * 修改页面跳转
     * @param categoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/toEditCategory.action")
    public String toEditCategory(Integer categoryId, Model model) {
        //通过userId获取用户
        ICategory category = icategoryService.findCategoryById(categoryId);
        if (category != null) {
            model.addAttribute("category", category);
            return "czx/Iedit_category";
        }else{
            return "redirect:findIcategorylist.action";
        }
    }
}
