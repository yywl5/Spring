package Services.yywl5;

import Beans.wyl.HeadImg;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author 星包客
 */
public interface HeadImgService {
    /**
     * 遍历所有存储图片
     * @return
     */
    List<HeadImg> list();

    /**
     * 待定
     * @param headimg
     * @return
     */
    int save(HeadImg headimg);

    /***
     *
     * @param file
     * @param headImg
     * @param map
     * @return
     * @throws IOException
     */
    String save(MultipartFile file, HeadImg headImg, ModelMap map) throws IOException;
}
