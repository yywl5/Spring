package Controllers.potatob6.APIs;

import Beans.potatob6.Administrator;
import Mappers.potatob6.AdminMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin/options")
@ResponseBody
public class AdminOptionsHandler {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员上传头像
     * @param multipartFile       头像文件
     * @param httpServletRequest
     * @return                    JSON，包含status和path
     */
    @PostMapping("/upload")
    public String uploadAvatar(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) {
        JSONObject jsonObject = new JSONObject();
        if(!(multipartFile.isEmpty() && multipartFile.getSize() == 0)) {
            String newName = ((Administrator)(httpServletRequest.getSession().getAttribute("admin"))).getAdminId()+"_"+
                    UUID.randomUUID().toString().replace("-", "")+"_"+
                    multipartFile.getOriginalFilename();
            File dir = new File(httpServletRequest.getServletContext().getRealPath("/static/avatars"));
            if(!dir.exists()) {
                dir.mkdir();
            }
            File files = new File(httpServletRequest.getServletContext().getRealPath("/static/avatars/"+newName));
            System.out.println(files.getAbsolutePath());
            try {
                multipartFile.transferTo(files);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 回显路径
            jsonObject.put("status", "success");
            jsonObject.put("path", "static/avatars/"+newName);
            return jsonObject.toJSONString();
        }
        jsonObject.put("status", "error");
        return jsonObject.toJSONString();
    }

    @PostMapping("/commit")
    public String commit(@RequestBody Map map, HttpServletRequest httpServletRequest) {

        try {
            String adminName = (String) map.get("adminName");
            String adminPassword = (String) map.get("adminPassword");
            String avatarPath = (String) map.get("avatarPath");

            JSONObject jsonObject = new JSONObject();

            if (adminName == null || adminPassword == null || avatarPath == null) {
                jsonObject.put("status", "error");
                return jsonObject.toJSONString();
            }

            if (adminName.equals("") || adminPassword.equals("")) {
                jsonObject.put("status", "error");
                return jsonObject.toJSONString();
            }

            Administrator administrator = new Administrator();
            administrator.setAdminName(adminName);
            administrator.setAdminPassword(adminPassword);
            administrator.setAvatarPath(avatarPath);
            administrator.setAdminId(((Administrator)httpServletRequest.getSession().getAttribute("admin")).getAdminId());
            Integer i = adminMapper.updateInfo(administrator);
            if (i != 0) {
                // 更新session
                httpServletRequest.getSession().setAttribute("admin", administrator);
                jsonObject.put("status", "success");
                return jsonObject.toJSONString();
            }

            jsonObject.put("status", "error");
            return jsonObject.toJSONString();
        }catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "error");
            return jsonObject.toJSONString();
        }
    }
}
