package Controllers.potatob6.APIs;

import Beans.potatob6.Administrator;
import Services.potatob6.AdminsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/admin/admins")
public class AdminAdminsHandler {

    @Autowired
    @Qualifier("PBAdminsService")
    private AdminsService adminsService;

    /**
     * 获取一页管理员
     * @param map JSON，包含page
     * @return    JSON，包含list和status
     */
    @PostMapping("/pageAdmins")
    public String pageAdmins(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        Integer page = (Integer) map.get("page");
        if(page == null) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }

        jsonObject.put("status", "success");
        jsonObject.put("list", adminsService.getPageOfAdmin(page));
        return jsonObject.toString();
    }

    /**
     * 修改管理员信息
     * @param map JSON,包含adminId, adminLogin, adminName, adminPassword, avatarPath
     * @return    JSON,包含status
     */
    @PostMapping("/edit")
    @ResponseBody
    public String editAdmin(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer ret = adminsService.editAdmin(String.valueOf(map.get("adminId")), (String) map.get("adminLogin"),
                    (String) map.get("adminName"), (String) map.get("adminPassword"), (String) map.get("avatarPath"));
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
     * 管理员删除管理员API
     * @param map JSON，包含adminId
     * @return    JSON，包含status
     */
    @PostMapping("/delete")
    @ResponseBody
    public String deleteAdmin(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer adminId = (Integer) map.get("adminId");
            Integer ret = adminsService.deleteAdmin(adminId);

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
     *  管理员添加管理员API
     * @param admin 管理员JSON
     * @return     JSON，包含status
     */
    @PostMapping("/add")
    @ResponseBody
    public String addAdmin(@RequestBody Administrator admin) {
        JSONObject jsonObject = new JSONObject();
        if(admin.getAdminName().equals("") || admin.getAdminLogin().equals("") || admin.getAdminPassword().equals("")) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }
        Integer ret = adminsService.addAdmin(admin);
        if(ret > 0) {
            jsonObject.put("status", "success");
            jsonObject.put("adminId", admin.getAdminId());
            return jsonObject.toString();
        }

        jsonObject.put("status", "error");
        return jsonObject.toString();
    }

    /**
     * 查询图书
     * @param words 关键字
     * @return      JSON,包含list
     */
    @GetMapping("/search/{words}")
    @ResponseBody
    public String searchAdmin(@PathVariable(value = "words", required = true) String words) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", adminsService.searchAdmin(words));
        return jsonObject.toString();
    }

    // TODO 处理管理员上传头像
}
