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
    /****
     * 检测是否存在重复
     * @return
     */
    HeadImg checkexist(String username);

    /***
     * 如果有重复,则更改
     */
    int updateheadimg(HeadImg headimg);

    /**
     * 返回头像
     * @param username
     * @return
     */
    HeadImg queryimgByuserName(String username);
}
