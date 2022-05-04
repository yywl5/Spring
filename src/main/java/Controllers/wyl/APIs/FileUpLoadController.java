package Controllers.wyl.APIs;

import Beans.wyl.HeadImg;
import Services.yywl5.HeadImgService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private HeadImgService headimgservice;
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam(value = "usernames",required = false) String name,
                                   @RequestParam(value = "uploadfile",required = false) List<MultipartFile> uploadfile, HttpServletRequest request, Model model) {
        List<String> filesFileName = new ArrayList<String>();
        /**
         * 判断所上传文件是否存在
         */
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            /***
             * 循环输出上传的文件
             */
            for (MultipartFile file : uploadfile) {
                /**
                 * 获取上传文件的原始名称
                 */
                String originalFilename = file.getOriginalFilename();
                /***
                 * 设置上传文件的保存地址目录
                 */
                String dirPath = request.getServletContext().getRealPath("/upload/");
                System.out.println("dirPath:"+dirPath);
                File filePath = new File(dirPath);
                /***
                 * 如果保存文件的地址不存在，就先创建目录
                 */
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                /***
                 * 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
                 */
                String newFilename = name + "_" + UUID.randomUUID() + "_" + originalFilename;
                filesFileName.add(newFilename);
                try {
                    /***
                     * 使用MultipartFile接口的方法完成文件上传到指定位置
                     */
                    String usernames = request.getParameter("usernames");
                    System.out.println("usernames:"+usernames);
                    System.out.println("newFilename:"+newFilename);
                    file.transferTo(new File(filePath, newFilename));
                    HeadImg headimg = new HeadImg();
                    HeadImg checkexist = headimgservice.checkexist(usernames);
                    if(checkexist!=null){
                        String path = request.getServletContext().getRealPath("/upload/");
                        System.out.println("旧头像的存放路径为:"+path);
                        System.out.println("旧头像的名称为:"+checkexist.getImgPath());
                        if(isFileExist(path,checkexist.getImgPath())){
                            this.deleteFile(path+checkexist.getImgPath());
                            System.out.println("删除旧头像成功");
                        }
                        headimg.setUserName(usernames);
                        headimg.setImgPath(newFilename);
                        headimgservice.updateheadimg(headimg);
                    }else{
                        headimg.setUserName(usernames);
                        headimg.setImgPath(newFilename);
                        headimgservice.save(headimg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return "yywl5/error";
                }
            }
            // 跳转到成功页面
            model.addAttribute("filesFileName", filesFileName);
            System.out.println("获取下载时的图片路径:"+filesFileName);
            return "yywl5/LoginMainPage";
        } else {
            return "yywl5/error";
        }
    }

    /**
     * isFileExist(判断某路径下是否有该文件)
     * @param  @return    设定文件
     * @return String    DOM对象
     * @Exception 异常对象
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean isFileExist(String filePath, String file) {
        if (filePath == null || file == null) {
            return false;
        }
        String absPath = null;
        if (filePath.endsWith("/") || filePath.endsWith("\\")) {
            absPath = filePath + file;
        }
        else {
            absPath = filePath + File.separator + file;
        }
        return (new File(absPath)).exists();
    }

    /**
     * deleteFile(删除文件)
     * @param  @return    设定文件
     * @return String    DOM对象
     * @Exception 异常对象
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public void deleteFile(String srcFileName)  {
        boolean success = true;
        File file = new File(srcFileName);
        if (file.exists()) {
            file.delete();
        }
        if (!success) {
          System.out.println("删除文件"+srcFileName+"出错");
        } else {
            return;
        }
    }
}
