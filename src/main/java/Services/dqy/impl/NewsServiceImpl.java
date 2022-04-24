package Services.dqy.impl;

import Beans.dqy.News;
import Mappers.dqy.NewsMapper;
import Services.dqy.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsDao;

    @Override
    public List<News> getNewsByTypeOrderByTime (int Ntype) {
        return newsDao.getNewsByTypeOrderByTime(Ntype);
    }

    @Override
    public News getNewsById (int Nno) {
        return newsDao.getNewsById(Nno);
    }

    @Override
    public List<News> getNewsByType (int Ntype) {
        return newsDao.getNewsByType(Ntype);
    }

    @Override
    public List<News> getAllNews () {
        return newsDao.getAllNews();
    }

    @Override
    public Boolean deleteNews (int Nno) {
        return newsDao.deleteNews(Nno);
    }

    @Override
    public Boolean addNews (News news) {
        return newsDao.addNews(news);
    }

    @Override
    public Boolean modifyNews (News news) {
        return newsDao.modifyNews(news);
    }
}
