package Controllers.czx;

import Beans.czx.IRole;
import Services.czx.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IRoleController {
    //依赖注入
    @Autowired
    private IRoleService roleService;
    @RequestMapping(value="/findRoleList.action",method= RequestMethod.GET)
    public String findRoleList(Model model){
        List<IRole> roleList=roleService.findRoleList();
        if(roleList.size()>0){
            model.addAttribute("role", roleList.get(0));
        }
        return "czx/Irole_list";
    }
    @RequestMapping(value="/findRoleWithUsersByRoleId.action",method=RequestMethod.GET)
    public String findRoleWithUsersByRoleId(Integer roleId,Model model){
        IRole role=roleService.findRoleWithUsersByRoleId(roleId);
        if(role!=null){
            System.out.println(role);
        }
        return "";
    }
}
