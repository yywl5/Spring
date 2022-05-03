package Services.czx.Impl;

import Mappers.czx.INewsDao;
import Beans.czx.INews;
import Services.czx.INewsService;
import Others.czx.IPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 星包客
 */
@Service("InewsService")
public class INewsServiceImpl implements INewsService {
    //注入NewsDao
    @Autowired
    private INewsDao newsDao;
    @Override
    public IPageBean<INews> findNewsByPage(String keywords, Integer newsListCategoryId, Integer currentPage,
                                         Integer pageSize) {
        //获取当前类别信息数量
        int count=newsDao.getNewsCount(keywords,newsListCategoryId);
        //求总页数
        int totalPage = (int) Math.ceil(count*1.0/pageSize);
        List<INews> newsList=newsDao.findNewsList(keywords,newsListCategoryId,(currentPage-1)*pageSize,pageSize);
        IPageBean<INews> pb = new IPageBean<>();
        pb.setCount(count);
        if(currentPage==0) {
            currentPage = 1;
        }
        pb.setCurrentPage(currentPage);
        pb.setList(newsList);
        pb.setPageSize(pageSize);
        pb.setTotalPage(totalPage);
        return pb;
    }
    @Override
    public INews getNewsByNewsId(Integer newsId) {
        return newsDao.getNewsByNewsId(newsId);
    }
    @Override
    public int setNewsPublishStatus(INews news) {
        return newsDao.setNewsPublishStatus(news);
    }
    @Override
    public int addNews(INews news) {
        return newsDao.addNews(news);
    }
    @Override
    public int editNews(INews news) {
        return newsDao.updateNews(news);
    }
    @Override
    public int delNews(Integer newsId) {
        return newsDao.delNews(newsId);
    }
}
