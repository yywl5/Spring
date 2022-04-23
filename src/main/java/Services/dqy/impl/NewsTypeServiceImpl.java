package Services.dqy.impl;

import Beans.dqy.NewsType;
import Mappers.dqy.NewsTypeMapper;
import Services.dqy.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {

    @Autowired
    private NewsTypeMapper newsTypeDao;

    @Override
    public List<NewsType> getAllNewsType () {
        return newsTypeDao.getAllNewsType();
    }

    @Override
    public boolean addType (String TtypeName) {
        return newsTypeDao.addType(TtypeName);
    }

    @Override
    public boolean modifyType (NewsType newsType) {
        return newsTypeDao.modifyType(newsType);
    }

    @Override
    public boolean deleteType (int Tno) {
        return newsTypeDao.deleteType(Tno);
    }

    @Override
    public NewsType getNewsTypeByTno (int Tno) {
        return newsTypeDao.getNewsTypeByTno(Tno);
    }
}
