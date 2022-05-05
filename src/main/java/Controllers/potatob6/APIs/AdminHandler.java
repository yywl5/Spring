package Controllers.potatob6.APIs;

import Beans.potatob6.Administrator;
import Mappers.potatob6.AdminMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminHandler {

    @Autowired
    @Qualifier("PBAdminDAO")
    private AdminMapper administratorDAO;

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
     * @return          管理员Bean的JSON
     */
    @RequestMapping(value = "/login",
            method = RequestMethod.POST
    )
    @ResponseBody
    public String adminLogin(@RequestBody Map map, HttpServletRequest request) {
        String loginName = (String)map.get("loginName");
        String password = (String)map.get("password");
        if(loginName == null || password == null) {
            return "{\"status\":\"error\"}";
        }
        Administrator administrator = administratorDAO.getAdmin((String) map.get("loginName"), (String) map.get("password"));
        if(administrator == null)
        {
            return "{\"status\":\"Not Found\"}";
        }
        request.getSession().setAttribute("admin", administrator);
        return "{\"status\":\"Founded\",\"admin\":"+
                JSON.toJSONString(administrator)
                +"}";
    }

    /**
     * 密码修改
     * @param adminID     管理员的Id
     * @param newPassword 管理员新密码
     * @return
     */
    @RequestMapping(value = "/passwordChange",
            method = RequestMethod.GET,
            params = {"adminID", "newPassword"}
    )
    @ResponseBody
    public String adminPasswordChange(String adminID, String newPassword) {
        Integer i = administratorDAO.updatePassword(adminID, newPassword);
        JSONObject json = new JSONObject();
        if(i == 1) {
            json.put("status", "success");
        } else {
            json.put("status", "error");
        }
        return json.toJSONString();
    }

    /**
     * 管理员登出
     * @param request ServletRequest
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "potatob6/AdminLogin";
    }
}
