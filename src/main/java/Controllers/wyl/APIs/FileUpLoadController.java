package Controllers.wyl.APIs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 * @author 星包客
 */
@Controller
public class FileUpLoadController {
    /**
     * 执行文件上传
     * List<MultipartFile>用于同时接收多个相同参数的文件；若只有一个文件，则使用MultipartFile即可。
     */
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam(value = "usernames",required = false) String name,
                                   @RequestParam(value = "uploadfile",required = false) List<MultipartFile> uploadfile, HttpServletRequest request, Model model) {
        List<String> filesFileName = new ArrayList<String>();
        // 判断所上传文件是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            // 循环输出上传的文件
            for (MultipartFile file : uploadfile) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
                String newFilename = name + "_" + UUID.randomUUID() + "_" + originalFilename;
                filesFileName.add(newFilename);
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(filePath, newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            // 跳转到成功页面
            model.addAttribute("filesFileName", filesFileName);
            return "yywl5/LoginMainPage";
        } else {
            return "error";
        }
    }
}
