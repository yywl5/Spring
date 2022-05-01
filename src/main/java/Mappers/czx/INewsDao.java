package Mappers.czx;

import Beans.czx.INews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 星包客
 */
public interface INewsDao {
    //获取当前类别信息数量
    int getNewsCount(@Param("keywords") String keywords, @Param("newsListCategoryId") Integer newsListCategoryId);
    //获取当前类别信息列表
    List<INews> findNewsList(@Param("keywords") String keywords, @Param("newsListCategoryId") Integer newsListCategoryId, @Param("startRows") Integer startRows, @Param("pageSize") Integer pageSize);
    INews getNewsByNewsId(Integer newsId);
    int addNews(INews news);
    int updateNews(INews news);
    int setNewsPublishStatus(INews news);
    int delNews(Integer newsId);
}