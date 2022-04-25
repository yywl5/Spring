package Services.dqy.impl;

import Beans.dqy.News;
import Beans.dqy.NewsAndType;
import Mappers.dqy.NewsMapper;
import Services.dqy.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsDao;

    /**
     * 根据发布时间查询最新的五条新闻
     * @param Ntype
     * @return
     */
    @Override
    public List<News> getNewsByTypeOrderByTime (int Ntype) {
        return newsDao.getNewsByTypeOrderByTime(Ntype);
    }

    /**
     * 根据新闻的id查询指定新闻
     * @param Nno
     * @return
     */
    @Override
    public News getNewsById (int Nno) {
        return newsDao.getNewsById(Nno);
    }

    /**
     * 根据新闻类型查询新闻
     * @param Ntype
     * @return
     */
    @Override
    public List<NewsAndType> getNewsByType (int Ntype) {
        return newsDao.getNewsByType(Ntype);
    }

    /**
     * 获取所有新闻
     * @return
     */
    @Override
    public List<NewsAndType> getNewsLimitAndOrder () {
        return newsDao.getNewsLimitAndOrder();
    }

    /**
     * 根据新闻id删除新闻
     * @param Nno
     * @return
     */
    @Override
    public Boolean deleteNews (int Nno) {
        return newsDao.deleteNews(Nno);
    }

    /**
     * 增加新闻
     * @param news
     * @return
     */
    @Override
    public Boolean addNews (News news) {
        return newsDao.addNews(news);
    }

    /**
     * 修改新闻信息
     * @param news
     * @return
     */
    @Override
    public Boolean modifyNews (News news) {
        return newsDao.modifyNews(news);
    }

    /**
     * 根据新闻id获取新闻和新闻名称
     * @param Nno
     * @return
     */
    @Override
    public NewsAndType getNewsAndTypeById (int Nno) {
        return newsDao.getNewsAndTypeById(Nno);
    }
}
