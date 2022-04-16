package Controllers.potatob6;

import Beans.potatob6.Administrator;
import Mappers.potatob6.AdminiMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminHandler {

    @Autowired
    private AdminiMapper administratorDAO;

    /**
     * 获取所有管理员的信息
     * @return
     */
    @GetMapping("/admins")
    @ResponseBody
    public String getAdmins() {
        List<Administrator> adminDao = administratorDAO.getAllAdmins();
        return JSON.toJSONString(adminDao);
    }

    /**
     * 管理员登录API
     * @param loginName 管理员登录名
     * @param password  管理员密码
     * @return          管理员Bean的JSON
     */
    @RequestMapping(value = "/adminLogin",
            method = RequestMethod.GET,
            params = {"loginName", "password"}
    )
    @ResponseBody
    public String adminLogin(String loginName, String password) {
        Administrator administrator = administratorDAO.getAdmin(loginName, password);
        if(administrator == null)
        {
            return "{\"status\":\"Not Found\"}";
        }
        return "{\"status\":\"Founded\",\"admin\":"+
                JSON.toJSONString(administrator)
                +"}";
    }
}
