package Services.dqy;

import Beans.dqy.News;

import java.util.List;

public interface NewsService {

    public List<News> getNewsByTypeOrderByTime(int Ntype);

    public News getNewsById(int Nno);

    public List<News> getNewsByType(int Ntype);

    public List<News> getAllNews();

    public Boolean deleteNews(int Nno);

    public Boolean addNews(News news);

    public Boolean modifyNews(News news);
}
