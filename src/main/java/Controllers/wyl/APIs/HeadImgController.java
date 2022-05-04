package Controllers.wyl.APIs;

import Beans.wyl.HeadImg;
import Services.yywl5.HeadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 本代码为废弃代码,存在调试问题
 * @author 星包客
 */
@Controller
public class HeadImgController {
    @Autowired
    private HeadImgService headimgservice;
    @RequestMapping("/listImages")
    public String list(Model model){
        List<HeadImg>lists = headimgservice.list();
        model.addAttribute("lists",lists);
        System.out.println("请求lists of img");
        return "yywl5/loginMainPage";
    }
    @RequestMapping("saveImage")
    public String saveImage(MultipartFile file, HttpServletRequest request)throws IOException{
        String filePath =request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("filePath;;"+filePath);
        String originalFilename = file.getOriginalFilename();
        System.out.println("originFilename"+originalFilename);
        /***
         * 封装文件新的名字
         */
        String newFileName = UUID.randomUUID().toString().replace("-","")+originalFilename;
        /**
         * 封装文件上传的全路径
         */
        File targetFile = new File(filePath,newFileName);
        file.transferTo(targetFile);
        /***
         * 保存到数据库中
         */
        HeadImg headimg = new HeadImg();
        headimg.setImgPath(newFileName);
        headimgservice.save(headimg);
        return "yywl5/loginMainPage";
    }

}
