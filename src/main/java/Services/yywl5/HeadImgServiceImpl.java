package Services.yywl5;

import Beans.wyl.HeadImg;
import Mappers.wyl.HeadImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author 星包客
 */
@Service
public class HeadImgServiceImpl implements HeadImgService{
    @Autowired
    private HeadImgMapper headimgMapper;
    @Override
    public List<HeadImg> list(){
        return headimgMapper.list();
    }
    @Override
    public int save(HeadImg headimg){
        return headimgMapper.save(headimg);
    }
    @Override
    public HeadImg checkexist(String userName){
        return headimgMapper.checkexist(userName);
    }

    @Override
    public HeadImg queryimgByuserName(String userName){
        return headimgMapper.queryimgByuserName(userName);
    }
    @Override
    public int updateheadimg(HeadImg headimg){
        return headimgMapper.updateheadimg(headimg);
    }
    @Override
    public String save(MultipartFile file, HeadImg headimg, ModelMap map)throws IOException{
        /**
         * 保存图片的路径,图书上传成功后,将路径保存到数据库
         */
        String filePath = "/headImg";
        /**
         * 获取原始图片的扩展名
         */
        String originalFilename = file.getOriginalFilename();
        /**
         * 生成文件的新名字
         */
        String newFileName = UUID.randomUUID()+originalFilename;

        /***
         * 封装上传文件的全路径
         */
        File targetFile = new File(filePath,newFileName);
        file.transferTo(targetFile);

        /***
         * 保存到数据库
         */
        headimg.setImgPath(newFileName);
        headimgMapper.save(headimg);
        return "redirect:/listImages";
    }
}
