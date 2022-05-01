package Services.czx;

import Beans.czx.INews;
import Others.czx.IPageBean;

/**
 * @author 星包客
 */
public interface INewsService {
    IPageBean<INews> findNewsByPage(String keywords, Integer newsListCategoryId, Integer currentPage, Integer pageSize);
    INews getNewsByNewsId(Integer newsId);
    int setNewsPublishStatus(INews news);
    int addNews(INews news);
    int editNews(INews news);
    int delNews(Integer newsId);
}
