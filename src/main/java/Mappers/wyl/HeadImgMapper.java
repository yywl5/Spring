package Mappers.wyl;

import Beans.wyl.HeadImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadImgMapper {
    /***
     * 查询所有图片
     * @reutrn
     */
    List<HeadImg> list();
    /***
     * 上传一张图片
     * @return
     */
    int save(HeadImg headimg);
}
