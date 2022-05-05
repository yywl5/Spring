package Controllers.potatob6.APIs;

import Beans.potatob6.User;
import Services.potatob6.UsersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin/users")
@ResponseBody
public class AdminUserHandler {

    @Autowired
    @Qualifier("PBAdminUserService")
    private UsersService userService;

    /**
     * 获取一页图书
     * @param map JSON，包含page
     * @return    JSON，包含list和status
     */
    @PostMapping("/pageUsers")
    public String pageUsers(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        Integer page = (Integer) map.get("page");
        if(page == null) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }

        jsonObject.put("status", "success");
        jsonObject.put("list", userService.getPageOfUser(page));
        return jsonObject.toString();
    }

    /**
     * 修改用户信息
     * @param map JSON,包含userId, userName, userLogin, userPassword
     * @return    JSON,包含status
     */
    @PostMapping("/edit")
    @ResponseBody
    public String editUser(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer ret = userService.editUser(String.valueOf(map.get("userId")), (String) map.get("userLogin"),
                    (String) map.get("userName"), (String) map.get("userPassword"));
            if(ret != 0) {
                jsonObject.put("status", "success");
                return jsonObject.toString();
            }
            jsonObject.put("status", "error");
            jsonObject.put("message", "参数异常");
            return jsonObject.toString();
        } catch (Exception e) {
            jsonObject.put("status", "error");
            jsonObject.put("message", e.toString());
            return jsonObject.toString();
        }
    }

    /**
     * 管理员删除用户API
     * @param map JSON，包含userId
     * @return    JSON，包含status
     */
    @PostMapping("/delete")
    @ResponseBody
    public String deleteUser(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer userId = (Integer) map.get("userId");
            Integer ret = userService.deleteUser(userId);

            if(ret != 0) {
                jsonObject.put("status", "success");
                return jsonObject.toString();
            }

            jsonObject.put("status", "error");
            jsonObject.put("message", "参数错误");
            return jsonObject.toString();
        } catch (Exception e) {
            jsonObject.put("status", "error");
            jsonObject.put("message", e.toString());
            return jsonObject.toString();
        }
    }

    /**
     *  管理员添加用户API
     * @param user 用户JSON
     * @return     JSON，包含status
     */
    @PostMapping("/add")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer ret = userService.addUser(user);
            if(ret > 0) {
                jsonObject.put("status", "success");
                jsonObject.put("userId", user.getUserId());
                return jsonObject.toString();
            }
        } catch (Exception e) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }
        jsonObject.put("status", "error");
        return jsonObject.toString();
    }

    /**
     * 查询用户
     * @param words 关键字
     * @return      JSON,包含list
     */
    @GetMapping("/search/{words}")
    @ResponseBody
    public String searchUser(@PathVariable(value = "words", required = true) String words) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", userService.searchUser(words));
        return jsonObject.toString();
    }
}
