package Services.dqy;

import Beans.dqy.News;
import Beans.dqy.NewsAndType;

import java.util.List;

public interface NewsService {

    public List<News> getNewsByTypeOrderByTime(int Ntype);

    public News getNewsById(int Nno);

    public List<NewsAndType> getNewsByType(int Ntype);

    public List<NewsAndType> getNewsLimitAndOrder();

    public Boolean deleteNews(int Nno);

    public Boolean addNews(News news);

    public Boolean modifyNews(News news);

    public NewsAndType getNewsAndTypeById(int Nno);
}
