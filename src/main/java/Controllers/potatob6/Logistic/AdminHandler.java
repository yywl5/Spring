package Controllers.potatob6.Logistic;

import Beans.potatob6.Administrator;
import Mappers.potatob6.AdminMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class AdminHandler {

    @Autowired
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
    @RequestMapping(value = "/adminLogin",
            method = RequestMethod.POST
    )
    @ResponseBody
    public String adminLogin(@RequestBody Map map, @CookieValue("JSESSIONID") String sessionId) {
        System.out.println(sessionId);
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
        return "{\"status\":\"Founded\",\"admin\":"+
                JSON.toJSONString(administrator)
                +"}";
    }

    @RequestMapping(value = "/adminPasswordChange",
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

}
